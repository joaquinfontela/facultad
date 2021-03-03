#include "HTTPProtocolReader.h"

#include <iostream>

HTTPProtocolReader::HTTPProtocolReader() {}

std::istream& HTTPProtocolReader::readLine(std::string& line) const {
  std::istream& result = getline(std::cin, line);
  line += "\n";
  return result;
}
