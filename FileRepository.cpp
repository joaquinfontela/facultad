#include "FileRepository.h"

FileRepository::FileRepository(std::list<std::string>& fileNames) {
  this->fileNames = fileNames;
}

void FileRepository::printFileNames() {
  std::list<std::string>::iterator it;
  for (it = this->fileNames.begin(); it != this->fileNames.end(); ++it) {
    std::cout << (*it) << "\n";
  }
}