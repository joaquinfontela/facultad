#include "FileHandler.h"

FileHandler::FileHandler(FileRepository& f) : fileRepository(f) {}

bool FileHandler::getNextFileOpened(std::ifstream& nextFile) {
  nameOfLastFileOpened = fileRepository.getNextFileName();
  nextFile.open(nameOfLastFileOpened);
  return nextFile.is_open();
}

void FileHandler::closeCurrentFile(std::ifstream& currentFile) const {
  currentFile.close();
}

std::string FileHandler::getNameOfLastFileOpened() const {
  return nameOfLastFileOpened;
}

bool FileHandler::thereAreFilesPending() const {
  return fileRepository.thereAreFilesPending();
}
