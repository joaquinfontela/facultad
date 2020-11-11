#include "StringSplitter.h"

std::vector<int> StringSplitter::findAll(const std::string string,
                                         const std::string searched) const {
  std::vector<int> searchedLocations;
  size_t searchedSize = searched.size();
  unsigned int i;
  for (i = 0; i <= (string.size() - searchedSize); ++i) {
    if (!string.substr(i, searchedSize).compare(searched)) {
      searchedLocations.push_back(i);
    }
  }
  return searchedLocations;
}

std::vector<std::string> StringSplitter::split(const std::string string,
                                               const std::string delim) const {
  std::vector<std::string> splitedString;
  std::vector<int> delimLocations = findAll(string, delim);
  std::vector<int>::iterator it;
  int lastDelimLocation = -2;
  for (it = delimLocations.begin(); it != delimLocations.end(); ++it) {
    int delimLocation = (*it);
    splitedString.push_back(string.substr(
        lastDelimLocation + 2, delimLocation - lastDelimLocation - 2));
    lastDelimLocation = delimLocation;
  }
  splitedString.push_back(string.substr(lastDelimLocation + 2, string.size()));
  return std::move(splitedString);
}
