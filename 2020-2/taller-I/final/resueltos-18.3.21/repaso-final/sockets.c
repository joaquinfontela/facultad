#include <sys/socket.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include <netdb.h>

#define MAX_QUEUE_LEN 1
#define MAX_MSG_LEN 500

int main(int argc, char* argv[]) {

	char* host = argv[1];
	char* port = argv[2];
	char buf[MAX_MSG_LEN];

	struct addrinfo hints;
	memset(&hints, 0, sizeof(struct addrinfo));
	
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_flags = AI_PASSIVE;
	
	struct addrinfo* results;
	getaddrinfo(host, port, &hints, &results);
	
	int fd = socket(results->ai_family, results->ai_socktype, results->ai_protocol);
	
	int val = 1;
	setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(val));
	
	bind(fd, results->ai_addr, results->ai_addrlen);
	listen(fd, MAX_QUEUE_LEN);
	
	int peerfd = accept(fd, 0, 0);
	
	bool run = true;
	size_t bytes_recv = 0;
	size_t bytes_recv_in_last_call = 0;
	const char* END_SIGNAL = "FIN";
	const char END_MSG_SIGNAL = '=';
	
	while (run) {
		bytes_recv_in_last_call = recv(peerfd, &(buf[bytes_recv]), MAX_MSG_LEN - bytes_recv, 0);
		bytes_recv += bytes_recv_in_last_call;
		buf[bytes_recv] = 0;
		if (!strncmp(buf, END_SIGNAL, sizeof(END_SIGNAL))) {
			run = false;
		} else if (!strncmp(&(buf[bytes_recv - 1]), &END_MSG_SIGNAL, 1)) {
			// process buf.
		}
	}

	shutdown(peerfd, SHUT_RDWR);
	shutdown(fd, SHUT_RDWR);
	close(peerfd);
	close(fd);
	
	return 0;
}
