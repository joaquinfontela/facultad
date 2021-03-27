#include <netdb.h>
#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

#define MAX_QUEUE 1
#define MAX_MESG_LEN 500
#define FINISH_SIGNAL "FINAL"

int main(int argc, char* argv[]) {
  char* port = argv[1];
  char* host = argv[2];
  char* buf[MAX_MESG_LEN];

  struct addrinfo hints;
  memset(&hints, 0, sizeof(struct addrinfo));
  hints.ai_family = AF_INET;
  hints.ai_socktype = SOCK_STREAM;
  hints.ai_flags = AI_PASSIVE;

  struct addrinfo* results;
  getaddrinfo(host, port, &hints, &results);

  int acc_fd =
      socket(results->ai_family, results->ai_socktype, results->ai_protocol);
  int val = 1;
  setsockopt(acc_fd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));
  bind(acc_fd, results->ai_addr, results->ai_addrlen);
  listen(acc_fd, MAX_QUEUE);

  int peerfd = accept(acc_fd, NULL, NULL);
  size_t recieved;
  bool alive = true;

  while (alive) {
    recieved = recv(peerfd, buf, sizeof(buf), 0);
    buf[recieved] = 0;
    if (!strncmp(buf, FINISH_SIGNAL, strlen(FINISH_SIGNAL))) {
      alive = false;
    } else {
      printf("%s", buf);
    }
  }

  shutdown(peerfd, SHUT_RDWR);
  shutdown(acc_fd, SHUT_RDWR);
  close(peerfd);
  close(acc_fd);

  return 0;
}