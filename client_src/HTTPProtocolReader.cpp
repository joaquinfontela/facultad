#include "HTTPProtocolReader.h"

#include <iostream>

HTTPProtocolReader::HTTPProtocolReader(std::string& filePath) {
  file.open(filePath);
  if (!file.is_open())
    throw std::runtime_error("File '" + filePath + "' couldn't be opened.");
  readFileContent();
}

void HTTPProtocolReader::readFileContent() {
  std::string line;
  while (getline(file, line)) {
    fileContent += (line + "\n");
  }
}

std::string& HTTPProtocolReader::getFileContent() { return fileContent; }