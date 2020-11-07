#include <fstream>
#include <string>

class HTTPProtocolReader {
 private:
  std::string fileContent;

 public:
  HTTPProtocolReader();
  std::istream& readLine(std::string& line) const;
};