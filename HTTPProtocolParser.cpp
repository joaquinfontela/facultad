#include "HTTPProtocolParser.h"

#include "StringSplitter.h"

HTTPProtocolParser::HTTPProtocolParser() {}

void HTTPProtocolParser::parseFirstLine(std::string& line) {
  std::vector<std::string> lineArguments = StringSplitter().split(line, " ");
  method = lineArguments.at(0);
  resource = lineArguments.at(1);
  protocol = lineArguments.at(2);
}

void HTTPProtocolParser::parseKeyValueLine(std::string& line) {
  std::vector<std::string> lineArguments = StringSplitter().split(line, ": ");
  lines.insert({lineArguments[0], lineArguments[1]});
}

void HTTPProtocolParser::parseFile(std::string& filePath) {
  std::ifstream file;
  std::string line;
  file.open(filePath);
  if (!file.is_open()) return;

  getline(file, line);
  std::cout << line << std::endl;
  parseFirstLine(line);
  while (getline(file, line) && !line.empty()) {
    parseKeyValueLine(line);
  }
  while (getline(file, line)) {
    if (!line.empty()) body += (line + "\n");
  }
  file.close();
}

std::string& HTTPProtocolParser::getMethod() { return method; }

std::string& HTTPProtocolParser::getProtocol() { return protocol; }

std::string& HTTPProtocolParser::getResource() { return resource; }

std::map<std::string, std::string>& HTTPProtocolParser::getLines() {
  return lines;
}

std::string& HTTPProtocolParser::getBody() { return body; }