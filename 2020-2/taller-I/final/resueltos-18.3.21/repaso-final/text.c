#include <stdio.h>
#include <unistd.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>


char* read_next_line(FILE* file, size_t* seek, char* buf) {
	fseek(file, *seek, SEEK_SET);
	char* res = fgets(buf, 500, file);
	*seek = ftell(file);
	return res;
}


void get_next_word(char* buf, size_t* pos, char* word) {

	size_t word_pos = 0;
	const char space_bar = ' ';
	const char line_jump = '\n';
	while (strncmp(&(buf[*pos]), &space_bar, 1) && strncmp(&(buf[*pos]), &line_jump, 1)) {
		printf("%li\n", *pos);
		word[word_pos] = buf[*pos];
		word_pos++;
		(*pos)++;
	}
	word[word_pos] = 0;
	(*pos)++;
}


void save_short_words(char* buf, char* new_buf) {
	char word[500];
	for (int i = 0; i < 500; i++) {
		new_buf[i] = 0;
	}
	size_t pos = 0;
	size_t new_buf_pos = 0;
	while (buf[pos]) {
		get_next_word(buf, &pos, word);
		if (strlen(word) < 4) {
			size_t len_word = strlen(word);
			for (int i = 0; i < len_word; i++) {
				new_buf[new_buf_pos] = buf[pos - len_word - 1 + i];
				new_buf_pos++;
			}
			new_buf[new_buf_pos++] = 0;
		}
		pos++;
	} 
}


void write_next_line(FILE* file, size_t* seek, char* line) {

	fseek(file, *seek, SEEK_SET);
	fputs(line, file);
	*seek = ftell(file);
}


int main(int argc, char* argv[]) {
	
	FILE* file = fopen("text.txt", "r+");
	char line[500];
	
	size_t seek_rd = 0;
	size_t seek_wr = 0;
	
	while (read_next_line(file, &seek_rd, line)) {
		char new_line[500];
		save_short_words(line, new_line);
		write_next_line(file, &seek_wr, new_line);
	}
	
	ftruncate(fileno(file), seek_wr);
	fclose(file);
	
	return 0;
}
