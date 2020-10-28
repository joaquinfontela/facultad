#include "FileRepository.h"

#include "StringSorter.h"

FileRepository::FileRepository(std::vector<std::string>& fileNames) {
  this->fileNames = StringSorter().sort(fileNames);
}

std::string FileRepository::getNextFileName() {
  if (fileNames.empty()) return NULL;
  std::string fileName = fileNames.front();
  fileNames.pop();
  return fileName;
}

bool FileRepository::thereAreFilesPending() const {
  return (!fileNames.empty());
}