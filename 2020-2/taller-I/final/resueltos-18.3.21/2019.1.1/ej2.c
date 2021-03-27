#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* Replicar(const char* s, int i1, int i2, int q) {
  size_t bytes = (i2 - i1 + 1) * q + i1 + (strlen(s) - i2);
  char* buf = (char*)malloc(bytes);

  int s_pos = 0;
  while (s_pos < i1) {
    buf[s_pos] = s[s_pos];
    s_pos++;
  }

  char* rep_buf = (char*)malloc((i2 - i1 + 1) * q);
  int rep_buf_pos = 0;
  while (rep_buf_pos <= (i2 - i1)) {
    rep_buf[rep_buf_pos] = s[s_pos];
    rep_buf_pos++;
    s_pos++;
  }
  rep_buf[rep_buf_pos] = 0;

  int rep_buf_len = rep_buf_pos;
  int i;
  int buf_pos = i1;
  for (i = 0; i < q; i++) {
    rep_buf_pos = 0;
    while (rep_buf_pos < rep_buf_len) {
      printf("Buf: %s\n", rep_buf);
      buf[buf_pos] = rep_buf[rep_buf_pos];
      buf_pos++;
      rep_buf_pos++;
    }
  }

  free(rep_buf);

  while (s[s_pos]) {
    buf[buf_pos] = s[s_pos];
    s_pos++;
    buf_pos++;
  }

  return buf;
}

int main() {
  char* new_str = Replicar("Hola", 1, 2, 3);
  printf("%s", new_str);
  free(new_str);
  return 0;
}