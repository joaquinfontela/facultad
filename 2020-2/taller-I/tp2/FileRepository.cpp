#include "FileRepository.h"

// Me pide que fileNames sea const pero lo necesito modificar por dentro.
// cppcheck-suppress constParameter
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
