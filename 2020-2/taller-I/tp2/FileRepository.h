#include <iostream>
#include <mutex>
#include <queue>
#include <string>
#include <vector>

class FileRepository {
 private:
  std::vector<std::string> fileNames;
  std::mutex m;

 public:
  explicit FileRepository(std::vector<std::string>& fileNames);
  FileRepository(const FileRepository& copy) = delete;

  std::string getNextFileName();
};
