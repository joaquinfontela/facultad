#include "Trimmer.h"

Trimmer::Trimmer() {}

std::string Trimmer::leftTrim(const std::string& str,
                              const std::string& chars) const {
  std::string newStr = str;
  newStr.erase(0, newStr.find_first_not_of(chars));
  return newStr;
}

std::string Trimmer::rightTrim(const std::string& str,
                               const std::string& chars) const {
  std::string newStr = str;
  newStr.erase(newStr.find_last_not_of(chars) + 1);
  return newStr;
}

std::string Trimmer::trim(const std::string& str,
                          const std::string& chars) const {
  return leftTrim(rightTrim(str, chars), chars);
}