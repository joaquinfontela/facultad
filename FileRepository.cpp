#include "FileRepository.h"

FileRepository::FileRepository(std::queue<std::string>& fileNames) {
  this->fileNames = fileNames;
}

std::string FileRepository::getNextFileName() {
  if (fileNames.empty()) return NULL;
  std::string fileName = fileNames.back();
  fileNames.pop();
  return fileName;
}