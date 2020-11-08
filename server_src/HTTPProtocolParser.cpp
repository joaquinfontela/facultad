#include "HTTPProtocolParser.h"

#include "../client_src/HTTPProtocolReader.h"

HTTPProtocolParser::HTTPProtocolParser() {}

void HTTPProtocolParser::parseFirstLine(std::string& line) {
  std::cout << line << std::endl;
  std::vector<std::string> lineArguments = StringSplitter().split(line, " ");
  method = lineArguments.at(0);
  resource = lineArguments.at(1);
  protocol = lineArguments.at(2);
}

void HTTPProtocolParser::parseFile(const std::string& fileContent) {
  std::vector<std::string> fileLines =
      StringSplitter().split(fileContent, "\n");

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

std::string HTTPProtocolParser::getProtocol() const { return protocol; }

std::string HTTPProtocolParser::getResource() const { return resource; }

std::string HTTPProtocolParser::getBody() const { return body; }