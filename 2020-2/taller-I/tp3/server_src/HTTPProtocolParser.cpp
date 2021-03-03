#include "HTTPProtocolParser.h"

#include "../client_src/HTTPProtocolReader.h"

HTTPProtocolParser::HTTPProtocolParser() {}

HTTPProtocolParser::~HTTPProtocolParser() {}

void HTTPProtocolParser::parseFirstLine(std::string& line) {
  std::cout << line << std::endl;
  std::vector<std::string> lineArguments = StringSplitter().split(line, " ");
  if (lineArguments.size() != 3)
    throw std::runtime_error(
        "incorrect first line format of http protocol file");
  method = lineArguments.at(0);
  resource = lineArguments.at(1);
}

void HTTPProtocolParser::parseFile(const std::string& fileContent) {
  std::vector<std::string> fileLines =
      StringSplitter().split(fileContent, "\n");

  if (fileLines.empty())
    throw std::runtime_error("http protocol file is empty.");
  parseFirstLine(fileLines.at(0));

  bool addLineToBody = false;
  for (std::string line : fileLines) {
    if (line.empty()) {
      // the body starts in the next line.
      addLineToBody = true;
      continue;
    }
    if (addLineToBody) {
      body += (line + "\n");
    }
  }
}

std::string HTTPProtocolParser::getMethod() const { return method; }

std::string HTTPProtocolParser::getResource() const { return resource; }

std::string HTTPProtocolParser::getBody() const { return body; }
