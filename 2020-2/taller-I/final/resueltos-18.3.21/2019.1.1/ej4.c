#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define MAX_LINE_LEN 500

char* read_next_line(FILE* file, size_t* seek_read, char* buf) {
  fseek(file, *seek_read, SEEK_SET);
  char* res = fgets(buf, MAX_LINE_LEN, file);
  *seek_read += strlen(buf);
  return res;
}

bool is_one_word_line(char* buf) {
  size_t pos = 0;
  size_t spaces = 0;
  char space = ' ';
  bool last_char_was_space_bar = false;
  while (buf[pos]) {
    last_char_was_space_bar = false;
    if (!strncmp(&space, &(buf[pos]), 1)) {
      spaces++;
      last_char_was_space_bar = true;
    }
    pos++;
  }
  if (spaces == 0) {
    return true;
  } else if (spaces == 1 && last_char_was_space_bar) {
    return true;
  }
  return false;
}

void write_next_line(FILE* file, size_t* seek_write, char* line) {
  fseek(file, *seek_write, SEEK_SET);
  size_t line_len = strlen(line);
  line[line_len] = 0;
  fputs(line, file);
  *seek_write += (line_len);
}

int main() {
  char line[MAX_LINE_LEN];
  FILE* file = fopen("ej4.txt", "r+");
  size_t seek_read = 0;
  size_t seek_write = 0;

  while (read_next_line(file, &seek_read, line)) {
    printf("%s\n", line);
    if (!is_one_word_line(line)) {
      printf("%s", "tiene mas de una pal.\n");
      write_next_line(file, &seek_write, line);
    }
  }

  ftruncate(fileno(file), seek_write);

  return 0;
}