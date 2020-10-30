#include "FileRepository.h"

FileRepository::FileRepository(std::vector<std::string>& fileNames) {
  this->fileNames = fileNames;
}

std::string FileRepository::getNextFileName() {
  std::unique_lock<std::mutex> lock(m);
  if (fileNames.empty()) return "";
  std::string fileName = fileNames.back();
  fileNames.pop_back();
  return fileName;
}
