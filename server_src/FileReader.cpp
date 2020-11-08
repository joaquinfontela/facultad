#include "FileReader.h"

#include <iostream>

FileReader::FileReader() {}

std::string FileReader::getFileContent(std::string& filePath) {
  std::ifstream file;
  file.open(filePath);
  std::string line;
  std::string fileContent;
  while (getline(file, line)) {
    fileContent += (line + "\n");
  }
  return std::move(fileContent);
}