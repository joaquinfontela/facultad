#include <fstream>
#include <string>

class HTTPProtocolReader {
 private:
  std::ifstream file;
  std::string fileContent;
  void readFileContent();

 public:
  HTTPProtocolReader(std::string& filePath);
  std::string& getFileContent();
};