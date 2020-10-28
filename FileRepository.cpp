#include "FileRepository.h"

FileRepository::FileRepository(std::queue<std::string>& fileNames) {
  this->fileNames = fileNames;
}

std::string FileRepository::getNextFileName() {
  if (this->fileNames.empty()) return NULL;
  std::string fileName = this->fileNames.back();
  this->fileNames.pop();
  return fileName;
}