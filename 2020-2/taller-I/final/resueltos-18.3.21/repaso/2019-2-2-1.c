#include <errno.h>
#include <netdb.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

void printSum(const char* buf) {
  const char sum_sign = '+';
  const char equal_sign = '=';
  int sum = 0;
  char current_number_buf[500];
  size_t current_number_buf_pos = 0;
  size_t buf_pos = 0;

  while (buf[buf_pos]) {
    if (strncmp(&(buf[buf_pos]), &sum_sign, 1)) {
      current_number_buf[current_number_buf_pos] = buf[buf_pos];
      current_number_buf_pos++;
    } else {
      current_number_buf[current_number_buf_pos] = 0;
      sum += atoi(current_number_buf);
      current_number_buf_pos = 0;
    }
    buf_pos++;
  }
  current_number_buf[current_number_buf_pos] = 0;
  sum += atoi(current_number_buf);

  printf("%i", sum);
}

int main(int argc, char* argv[]) {
  char* host = argv[1];
  char* port = argv[2];
  char buf[500];

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
  listen(fd, 1);

  int peerfd = accept(fd, NULL, NULL);

  bool running = true;
  size_t bytes_recv = 0;
  size_t bytes_recv_in_last_recv = 0;
  const char equal_sign = '=';

  while (running) {
    size_t bytes_recv_in_last_recv =
        recv(peerfd, &(buf[bytes_recv]), 500 - bytes_recv, 0);
    bytes_recv += bytes_recv_in_last_recv;
    buf[bytes_recv] = 0;
    if (!strncmp(buf, &equal_sign, 1)) {
      running = false;
    } else if (!strncmp(&(buf[bytes_recv - 1]), &equal_sign, 1)) {
      buf[bytes_recv - 1] = 0;
      printSum(buf);
      bytes_recv = 0;
    }
  }

  shutdown(peerfd, SHUT_RDWR);
  shutdown(fd, SHUT_RDWR);
  close(peerfd);
  close(fd);

  return 0;
}
