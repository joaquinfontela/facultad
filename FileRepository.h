#include <iostream>
#include <queue>
#include <string>
#include <vector>

class FileRepository {
 private:
  std::vector<std::string> fileNames;

 public:
  explicit FileRepository(std::vector<std::string>& fileNames);
  FileRepository(const FileRepository& copy) = delete;

  std::string getNextFileName();
  bool thereAreFilesPending() const;
};
