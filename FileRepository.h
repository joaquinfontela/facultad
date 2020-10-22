#include <iostream>
#include <list>
#include <string>

class FileRepository {
 private:
  std::list<std::string> fileNames;

  void printFileNames();  // for debug

 public:
  FileRepository(std::list<std::string>& fileNames);
};