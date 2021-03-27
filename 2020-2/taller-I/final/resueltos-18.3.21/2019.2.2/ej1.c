#include <netdb.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <unistd.h>

#define MAX_QUEUE 1
#define MAX_MSG_LEN 500
#define END_SIGNAL "[]"

void print_sum(const char* buf) {
  size_t buf_pos = 1;
  size_t buf_len = strlen(buf);
  int sum = 0;
  char str_number[MAX_MSG_LEN - 2];
  size_t str_number_pos = 0;
  const char PLUS = '+';
  const char END_OF_MSG = ']';
  for (buf_pos; buf_pos < buf_len - 1; buf_pos++) {
    if (strncmp(&(buf[buf_pos]), &PLUS, 1)) {
      str_number[str_number_pos] = buf[buf_pos];
      str_number_pos++;
    } else {
      str_number[str_number_pos] = 0;
      sum += atoi(str_number);
      str_number_pos = 0;
    }
  }
  str_number[str_number_pos] = 0;
  sum += atoi(str_number);
  printf("%i\n", sum);
}

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

  int acc_fd =
      socket(results->ai_family, results->ai_socktype, results->ai_flags);

  int val = 1;
  setsockopt(acc_fd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));

  bind(acc_fd, results->ai_addr, results->ai_addrlen);
  listen(acc_fd, MAX_QUEUE);
  int peerfd = accept(acc_fd, NULL, NULL);

  bool running = true;
  size_t bytes_recieved;
  while (running) {
    bytes_recieved = recv(peerfd, buf, sizeof(buf), 0);
    buf[bytes_recieved] = 0;
    if (!strncmp(END_SIGNAL, buf, sizeof(END_SIGNAL))) {
      running = false;
    } else {
      print_sum(buf);
    }
  }

  shutdown(peerfd, SHUT_RDWR);
  shutdown(acc_fd, SHUT_RDWR);
  close(peerfd);
  close(acc_fd);

  return 0;
}