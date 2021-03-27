#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void duplicate(const char* a, const char* b) {
  char* new_str = (char*)malloc(strlen(a) * 2 + 1);
  size_t b_len = strlen(b);
  int pos = 0;
  int new_str_pos = 0;
  int last_pos = strlen(a) - b_len;
  while (a[pos]) {
    int aux_pos = pos;
    if (!strncmp(&(a[pos]), b, b_len)) {
      int i;
      for (i = 0; i < b_len; i++) {
        new_str[new_str_pos] = a[pos];
        pos++;
        new_str_pos++;
      }
    }
    pos = aux_pos;
    new_str[new_str_pos] = a[pos];
    new_str_pos++;
    pos++;
  }
  new_str[new_str_pos] = 0;
  printf("%s", new_str);
  free(new_str);
}

int main(int argc, char** argv) {
  duplicate(argv[1], argv[2]);
  return 0;
}