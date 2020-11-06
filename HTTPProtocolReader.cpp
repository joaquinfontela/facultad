#include "HTTPProtocolReader.h"

HTTPProtocolReader::HTTPProtocolReader(std::string& filePath) {
  file.open(filePath);
  if (!file.is_open()) throw -1;
  readFileContent();
}

void HTTPProtocolReader::readFileContent() {
  std::string line;
  while (getline(file, line)) {
    fileContent += (line + "\n");
  }
}

std::string& HTTPProtocolReader::getFileContent() { return fileContent; }