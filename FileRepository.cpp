#include "FileRepository.h"

FileRepository::FileRepository(std::list<std::string>& fileNames) {
  this->fileNames = fileNames;
}

std::string FileRepository::getNextFileName() {
  if (this->fileNames.empty()) return NULL;
  std::string fileName = this->fileNames.front();
  this->fileNames.pop_front();
  return fileName;
}

void FileRepository::printFileNames() {
  std::list<std::string>::iterator it;
  for (it = this->fileNames.begin(); it != this->fileNames.end(); ++it) {
    std::cout << (*it) << "\n";
  }
}