#include "FileHandler.h"

FileHandler::FileHandler(FileRepository* fileRepository) {
  this->fileRepository = fileRepository;
}

bool FileHandler::getNextFileOpened(std::ifstream& nextFile) {
  std::string nextFileName = this->fileRepository->getNextFileName();
  nextFile.open(nextFileName);
  return nextFile.is_open();
}

void FileHandler::closeCurrentFile(std::ifstream& currentFile) {
  currentFile.close();
}