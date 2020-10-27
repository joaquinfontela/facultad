#include <iostream>
#include <string>
#include <vector>

class FileRepository {
 private:
  std::vector<std::string> fileNames;

  void printFileNames();  // for debug

 public:
  FileRepository(std::vector<std::string>& fileNames);
  FileRepository(const FileRepository& copy) = delete;

  std::string getNextFileName();
};