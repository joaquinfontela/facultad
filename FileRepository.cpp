#include "FileRepository.h"

FileRepository::FileRepository(std::vector<std::string>& fileNames) {
  std::sort(fileNames.begin(), fileNames.end(), std::greater<std::string>());
  this->fileNames = fileNames;
}

std::string FileRepository::getNextFileName() {
  if (fileNames.empty()) return NULL;
  std::string fileName = fileNames.back();
  fileNames.pop_back();
  return fileName;
}

bool FileRepository::thereAreFilesPending() const {
  return (!fileNames.empty());
}