#ifndef HTTP_PROTOCOL_PARSER_H
#define HTTP_PROTOCOL_PARSER_H

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
  ~HTTPProtocolParser();
  void parseFile(const std::string& fileContent);
  std::string getMethod() const;
  std::string getResource() const;
  std::string getProtocol() const;
  std::string getBody() const;
};

#endif
