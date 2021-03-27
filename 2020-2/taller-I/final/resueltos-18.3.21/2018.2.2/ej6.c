#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define MAX_WORD_SIZE 50

int min(int a, int b) {
  if (a < b) {
    return a;
  }
  return b;
}

bool read_next_line(FILE* file, char* word) {
  char* read = fgets(word, MAX_WORD_SIZE, file);
  return read;
}

size_t get_pos_of_next_word_to_order(FILE* file, size_t lines_remaining) {
  fseek(file, 0, SEEK_SET);
  size_t pos = 0;
  size_t current_pos = 0;

  char word[MAX_WORD_SIZE];
  read_next_line(file, word);
  char word_to_order[MAX_WORD_SIZE];
  word_to_order[0] = word[0];

  for (int i = 0; i < lines_remaining - 1; i++) {
    read_next_line(file, word);
    current_pos += strlen(word);
    if (strncmp(word_to_order, word, min(strlen(word_to_order), strlen(word))) <
        0) {
      word_to_order[0] = word[0];
      pos = current_pos;
    }
  }
  return pos;
}

void order_word(FILE* file, size_t pos_to_order, size_t* seek_write) {
  char word[MAX_WORD_SIZE];
  char null_word[MAX_WORD_SIZE];
  fseek(file, pos_to_order, SEEK_SET);
  printf("Pos to order: %li\n", pos_to_order);
  read_next_line(file, word);
  size_t word_len = strlen(word);
  fseek(file, pos_to_order, SEEK_SET);
  printf("Pos to order: %li\n", pos_to_order);
  for (int i = 0; i < word_len; i++) {
    putc(0, file);
  }
  *seek_write -= word_len;
  fseek(file, *seek_write, SEEK_SET);
  printf("Seek write: %li\n", *seek_write);
  fputs(word, file);
}

int main() {
  char word[MAX_WORD_SIZE];
  size_t total_lines = 0;
  size_t total_bytes = 0;
  size_t largest_word_size = 0;
  FILE* file = fopen("ej6.txt", "r+");
  while (read_next_line(file, word)) {
    if (largest_word_size < strlen(word)) largest_word_size = strlen(word);
    total_bytes += (strlen(word) + 1);
    total_lines++;
  }
  ftruncate(fileno(file), largest_word_size * total_lines);
  size_t seek_write = largest_word_size * total_lines;
  size_t lines_remaining_to_order = total_lines;
  while (lines_remaining_to_order) {
    size_t pos_of_word_to_order =
        get_pos_of_next_word_to_order(file, lines_remaining_to_order);
    order_word(file, pos_of_word_to_order, &seek_write);
    lines_remaining_to_order--;
  }
  fclose(file);
  return 0;
}