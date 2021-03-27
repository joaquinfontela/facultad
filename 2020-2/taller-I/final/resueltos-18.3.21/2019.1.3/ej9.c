#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define MAX_LINE_LEN 500

bool read_line(FILE* file, size_t* seek_read, char* buf) {
  fseek(file, *seek_read, SEEK_SET);
  char* res = fgets(buf, MAX_LINE_LEN, file);
  *seek_read += strlen(buf);
  return res;
}

bool the_word_ends_at(char c) {
  char space_bar = ' ';
  char line_jump = '\n';
  return (!strncmp((&c), &space_bar, 1) || !strncmp((&c), &line_jump, 1));
}

void set_line_pos_at_next_space_bar(char* line, size_t* line_pos) {
  char space_bar = ' ';
  while (strncmp(&(line[*line_pos]), &space_bar, 1)) {
    (*line_pos)++;
    if (!&(line[*line_pos])) break;
  }
}

void save_only_three_or_less_letter_words(char* line, char* buf) {
  size_t line_pos = 0;
  size_t line_len = strlen(line);
  size_t new_buf_pos = 0;
  while (line_pos < line_len) {
    printf("%li\n", line_pos);
    if (!the_word_ends_at(line[line_pos])) {
      if (the_word_ends_at(line[line_pos + 1])) {
        buf[new_buf_pos] = line[line_pos];
        buf[new_buf_pos + 1] = ' ';
        new_buf_pos += 2;
        line_pos += 2;
      } else if (the_word_ends_at(line[line_pos + 2])) {
        buf[new_buf_pos] = line[line_pos];
        buf[new_buf_pos + 1] = line[line_pos + 1];
        buf[new_buf_pos + 2] = ' ';
        new_buf_pos += 3;
        line_pos += 3;
      } else if (the_word_ends_at(line[line_pos + 3])) {
        buf[new_buf_pos] = line[line_pos];
        buf[new_buf_pos + 1] = line[line_pos + 1];
        buf[new_buf_pos + 2] = line[line_pos + 2];
        buf[new_buf_pos + 3] = ' ';
        new_buf_pos += 4;
        line_pos += 4;
      } else {
        set_line_pos_at_next_space_bar(line, &line_pos);
      }
    } else {
      line_pos++;
    }
  }
  buf[new_buf_pos] = 0;
}

void write_line(FILE* file, size_t* seek_write, char* line) {
  fseek(file, *seek_write, SEEK_SET);
  size_t line_len = strlen(line);
  line[line_len] = '\n';
  line[line_len + 1] = 0;
  fputs(line, file);
  *seek_write += strlen(line);
}

int main() {
  char line[MAX_LINE_LEN];
  FILE* file = fopen("ej9.txt", "r+");
  size_t seek_read = 0;
  size_t seek_write = 0;

  while (read_line(file, &seek_read, line)) {
    char buf[MAX_LINE_LEN];
    save_only_three_or_less_letter_words(line, buf);
    write_line(file, &seek_write, buf);
  }

  ftruncate(fileno(file), seek_write);
  fclose(file);

  return 0;
}
