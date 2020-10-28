#include "StringSplitter.h"

std::vector<int> StringSplitter::findAll(std::string string,
                                         std::string searched) const {
  std::vector<int> searchedLocations;
  size_t searchedSize = searched.size();
  int i;
  for (i = 0; i <= (string.size() - searchedSize); ++i) {
    if (!string.substr(i, searchedSize).compare(searched)) {
      searchedLocations.push_back(i);
    }
  }
  return searchedLocations;
}

std::vector<std::string> StringSplitter::split(std::string string,
                                               std::string delim) const {
  std::vector<std::string> splitedString;
  std::vector<int> delimLocations = findAll(string, delim);
  std::vector<int>::iterator it;
  int delimLocation;
  int lastDelimLocation = -2;
  for (it = delimLocations.begin(); it != delimLocations.end(); ++it) {
    int delimLocation = (*it);
    splitedString.push_back(string.substr(
        lastDelimLocation + 2, delimLocation - lastDelimLocation - 2));
    lastDelimLocation = delimLocation;
  }
  splitedString.push_back(string.substr(lastDelimLocation + 2, string.size()));
  return splitedString;
}