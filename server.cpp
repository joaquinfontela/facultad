#include <iostream>

#include "HTTPProtocolParser.h"
#include "ServerCommandParser.h"
#include "ServerSocket.h"

int main(int argc, char* argv[]) {
  HTTPProtocolParser http;
  std::string fileName = "test.txt";
  http.parseFile(fileName);
  std::cout << http.getMethod() << std::endl
            << http.getResource() << std::endl
            << http.getProtocol() << std::endl;
  std::map<std::string, std::string> lines = http.getLines();
  for (auto dictIt : lines) {
    std::cout << dictIt.first << ": " << dictIt.second << std::endl;
  }
  std::cout << http.getBody();
  /*
  ServerCommandParser commandParser;
  if (!commandParser.commandIsValid(argc, argv)) return 1;
  ServerSocket server;
  std::string buffer;
  std::string PORT = commandParser.getPort();

  server.bindListen(PORT, true, 5);
  server._accept();
  server.recieve(buffer, 1000);

  std::cout << buffer << std::endl;
  */

  return 0;
}