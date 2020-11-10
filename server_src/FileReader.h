#include <fstream>
#include <string>
#include <utility>

class FileReader {
 public:
  FileReader();
  std::string getFileContent(const std::string& filePath);
};
