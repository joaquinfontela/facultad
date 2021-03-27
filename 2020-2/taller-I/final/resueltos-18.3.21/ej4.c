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

bool is_one_word_line(char* line) {
  const char SPACE_BAR = ' ';
  bool last_char_was_space_bar = false;
  int space_bars = 0;
  size_t line_pos = 0;
  size_t line_len = strlen(line);
  while (line_pos < line_len) {
    last_char_was_space_bar = false;
    if (!strncmp(&(line[line_pos]), &SPACE_BAR, 1)) {
      last_char_was_space_bar = true;
      space_bars++;
    }
    line_pos++;
  }
  return ((space_bars == 0) || (space_bars == 1 && last_char_was_space_bar));
}

void write_line(FILE* file, size_t* seek_write, char* line) {
  fseek(file, *seek_write, SEEK_SET);
  fputs(line, file);
  *seek_write += strlen(line);
}

int main() {
  FILE* file = fopen("texto.txt", "r+");
  char buf[MAX_LINE_LEN];

  size_t seek_read = 0;
  size_t seek_write = 0;

  while (read_next_line(file, &seek_read, buf)) {
    if (is_one_word_line(buf)) {
      write_line(file, &seek_write, buf);
    }
  }

  ftruncate(fileno(file), seek_write);
  fclose(file);

  return 0;
}
