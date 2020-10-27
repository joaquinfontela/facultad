#include "FileRepository.h"

FileRepository::FileRepository(std::vector<std::string>& fileNames) {
  this->fileNames = fileNames;
}

std::string FileRepository::getNextFileName() {
  if (this->fileNames.empty()) return NULL;
  std::string fileName = this->fileNames.back();
  this->fileNames.pop_back();
  return fileName;
}

void FileRepository::printFileNames() {
  std::vector<std::string>::iterator it;
  for (it = this->fileNames.begin(); it != this->fileNames.end(); ++it) {
    std::cout << (*it) << "\n";
  }
}