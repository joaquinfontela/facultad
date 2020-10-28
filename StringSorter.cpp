#include "StringSorter.h"

#include <iostream>

std::queue<std::string> StringSorter::sort(strList stringList) const {
  std::queue<std::string> newStringList;
  int i;
  int originalListSize = stringList.size();
  for (i = 0; i < originalListSize; ++i) {
    int j;
    std::string smallestString = stringList.at(0);
    int smallestStringPos = 0;
    for (j = 0; j < stringList.size(); ++j) {
      if (stringList.at(j) < smallestString) {
        smallestString = stringList.at(j);
        smallestStringPos = j;
      }
    }
    newStringList.push(smallestString);
    stringList.erase(stringList.begin() + smallestStringPos);
  }
  return std::move(newStringList);
}