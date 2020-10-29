#include "FileResults.h"

void FileResults::addResult(std::string result) { results.push_back(result); }

void FileResults::printResults() {
  std::sort(results.begin(), results.end(), std::less<std::string>());

  unsigned int i = 0;
  for (i = 0; i < results.size(); ++i) {
    std::cout << results.at(i);
  }
}
