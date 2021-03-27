#include <errno.h>
#include <netdb.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

#define MAX_QUEUE_LEN 1
#define MAX_MSG_LEN 500

int main(int argc, char* argv[]) {
  char* host = argv[1];
  char* port = argv[2];
  char* buf[MAX_MSG_LEN];

  struct addrinfo hints;
  memset(&hints, 0, sizeof(struct addrinfo));

  hints.ai_family = AF_INET;
  hints.ai_socktype = SOCK_STREAM;
  hints.ai_flags = AI_PASSIVE;

  struct addrinfo* results;
  getaddrinfo(host, port, &hints, &results);

  int fd =
      socket(results->ai_family, results->ai_socktype, results->ai_protocol);

  int val = 1;
  setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));

  bind(fd, results->ai_addr, results->ai_addrlen);
  listen(fd, MAX_QUEUE_LEN);

  int peerfd = accept(fd, NULL, NULL);

  bool running = true;
  size_t bytes_recieved = 0;
  size_t bytes_recieved_in_last_recv;
  const char END_OF_MSG = '>';

  while (running) {
    bytes_recieved_in_last_recv =
        recv(peerfd, buf[bytes_recieved], MAX_MSG_LEN - bytes_recieved, 0);
    bytes_recieved += bytes_recieved_in_last_recv;
    buf[bytes_recieved] = 0;
    if (!strncmp(&(buf[bytes_recieved - 1]), &END_OF_MSG, 1)) {
      if (strlen(buf) == 2) {
        running = false;
      } else {
        // process buf
        bytes_recieved = 0;
      }
    }
  }

  shutdown(peerfd, SHUT_RDWR);
  shutdown(fd, SHUT_RDWR);
  close(peerfd);
  close(fd);

  return 0;
}
