#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define MAX_LINE_LEN 500

char* read_next_line(FILE* file, size_t* seek_read, char* line) {
  fseek(file, *seek_read, SEEK_SET);
  char* res = fgets(line, MAX_LINE_LEN, file);
  *seek_read = ftell(file);
  return res;
}

void save_last_bytes_on_buf(size_t bytes, char* buf, size_t buf_pos,
                            char* new_buf, size_t new_buf_pos) {
  size_t i;
  for (i = 0; i < bytes; i++) {
    new_buf[new_buf_pos + i] = buf[buf_pos - bytes + i];
  }
}

void save_three_letter_or_less(char* buf, char* new_buf) {
  size_t buf_pos = 0;
  size_t new_buf_pos = 0;
  const char space_bar = ' ';
  size_t bytes_without_spaces = 0;

  while (buf[buf_pos]) {
    if (!strncmp(&(buf[buf_pos]), &space_bar, 1)) {
      if (bytes_without_spaces <= 3 && bytes_without_spaces > 0) {
        printf("%s\n", &(buf[buf_pos - bytes_without_spaces]));
        save_last_bytes_on_buf(bytes_without_spaces, buf, buf_pos, new_buf,
                               new_buf_pos);
        new_buf_pos += bytes_without_spaces;
        new_buf[new_buf_pos] = ' ';
        new_buf_pos++;
      }
      printf("HOLA\n");
      bytes_without_spaces = 0;
    } else
      bytes_without_spaces++;
    buf_pos++;
  }

  if (bytes_without_spaces <= 3 && bytes_without_spaces > 0) {
    printf("%s\n", &(buf[buf_pos - bytes_without_spaces]));
    save_last_bytes_on_buf(bytes_without_spaces, buf, buf_pos, new_buf,
                           new_buf_pos);
  }
  new_buf[new_buf_pos] = 0;
}

void write_line(FILE* file, size_t* seek_write, char* buf) {
  fseek(file, *seek_write, SEEK_SET);
  size_t buf_len = strlen(buf);
  buf[buf_len] = '\n';
  buf[buf_len + 1] = 0;
  fputs(buf, file);
  *seek_write = ftell(file);
}

int main(int argc, char* argv[]) {
  FILE* file = fopen("ej9.txt", "r+");
  char line[MAX_LINE_LEN];
  char new_line[MAX_LINE_LEN];

  size_t seek_read = 0;
  size_t seek_write = 0;

  while (read_next_line(file, &seek_read, line)) {
    save_three_letter_or_less(line, new_line);
    write_line(file, &seek_write, new_line);
  }

  ftruncate(fileno(file), seek_write);
  fclose(file);

  return 0;
}
