#include <iostream>
#include <queue>
#include <string>

class FileRepository {
 private:
  std::queue<std::string> fileNames;

 public:
  FileRepository(std::queue<std::string>& fileNames);
  FileRepository(const FileRepository& copy) = delete;

  std::string getNextFileName();
};