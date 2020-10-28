#include <fstream>

#include "FileRepository.h"

class FileHandler {
 private:
  FileRepository* fileRepository;
  std::string nameOfLastFileOpened;

 public:
  FileHandler(FileRepository* fileRepository);
  FileHandler(const FileHandler& copy) = delete;

  bool getNextFileOpened(std::ifstream& nextFile);
  void closeCurrentFile(std::ifstream& currentFile) const;
  std::string getNameOfLastFileOpened() const;
  bool thereAreFilesPending() const;
};