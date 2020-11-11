#include "FileResults.h"

void FileResults::addResult(std::string result) {
  std::unique_lock<std::mutex> lock(m);
  results.insert(result);
}

void FileResults::printResults() {
  for (std::string result : results) std::cout << result;
}
