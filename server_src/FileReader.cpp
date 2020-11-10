#include "FileReader.h"

#include <iostream>

FileReader::FileReader() {}

std::string FileReader::getFileContent(const std::string& filePath) const {
  std::ifstream file;
  file.open(filePath);
  if (!file.is_open()) throw std::runtime_error("error opening the file");
  std::string line;
  std::string fileContent;
  while (getline(file, line)) {
    fileContent += (line + "\n");
  }
  return fileContent;
}
