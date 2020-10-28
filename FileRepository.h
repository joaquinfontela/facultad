#include <iostream>
#include <queue>
#include <string>

class FileRepository {
 private:
  std::vector<std::string> fileNames;

 public:
  FileRepository(std::vector<std::string>& fileNames);
  FileRepository(const FileRepository& copy) = delete;

  std::string getNextFileName();
  bool thereAreFilesPending() const;
};