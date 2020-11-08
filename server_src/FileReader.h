#include <fstream>
#include <string>

class FileReader {
 public:
  FileReader();
  std::string getFileContent(std::string& filePath);
};