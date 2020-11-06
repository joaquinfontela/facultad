#include <iostream>
#include <map>
#include <string>
#include <vector>

#include "../common_src/StringSplitter.h"

class HTTPProtocolParser {
 private:
  std::string method;
  std::string resource;
  std::string protocol;
  std::string body;
  void parseFirstLine(std::string& line);

 public:
  HTTPProtocolParser();
  void parseFile(std::string& fileContent);
  std::string& getMethod();
  std::string& getResource();
  std::string& getProtocol();
  std::string& getBody();
};