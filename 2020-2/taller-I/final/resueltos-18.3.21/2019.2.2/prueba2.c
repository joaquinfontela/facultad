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

int main() {
  print_sum("[2+99+11+3+0+5717]");
  return 0;
}