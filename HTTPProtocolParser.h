#include <fstream>
#include <iostream>
#include <map>
#include <string>
#include <vector>

class HTTPProtocolParser {
 private:
  std::string method;
  std::string resource;
  std::string protocol;
  std::map<std::string, std::string> lines;
  std::string body;
  void parseFirstLine(std::string& line);
  void parseKeyValueLine(std::string& line);

 public:
  HTTPProtocolParser();
  void parseFile(std::string& filePath);
  std::string& getMethod();
  std::string& getResource();
  std::string& getProtocol();
  std::map<std::string, std::string>& getLines();
  std::string& getBody();
};