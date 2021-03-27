#define _POSIX_C_SOURCE 200112L
#include <errno.h>
#include <netdb.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

#define MAX_CLIENT_QUEUE 1
#define BUF_LEN 128

int main(int argc, char** argv) {
  char* ip = argv[1];
  char* port = argv[2];
  char buf[BUF_LEN];
  char exitCommand[] = "FINAL";

  struct addrinfo hints;
  memset(&hints, 0, sizeof(struct addrinfo));
  hints.ai_family = AF_INET;
  hints.ai_socktype = SOCK_STREAM;
  hints.ai_flags = AI_PASSIVE;

  struct addrinfo* res;
  int status = getaddrinfo(ip, port, &hints, &res);

  int acceptorFd = socket(res->ai_family, res->ai_socktype, res->ai_protocol);
  int val = 1;
  setsockopt(acceptorFd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));
  bind(acceptorFd, res->ai_addr, res->ai_addrlen);
  listen(acceptorFd, MAX_CLIENT_QUEUE);

  int peerFd = accept(acceptorFd, NULL, NULL);

  size_t bytesReceived = 0;
  bool alive = true;

  while (alive) {
    bytesReceived = recv(peerFd, buf, sizeof(buf), 0);
    buf[bytesReceived] = 0;
    if (strncmp(exitCommand, buf, sizeof(exitCommand)) == 0) {
      alive = false;
    } else {
      printf("%s", buf);
    }
  }

  shutdown(peerFd, SHUT_RDWR);
  shutdown(acceptorFd, SHUT_RDWR);
  close(peerFd);
  close(acceptorFd);

  return 0;
}