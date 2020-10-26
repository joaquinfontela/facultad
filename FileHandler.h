#include <fstream>

#include "FileRepository.h"

class FileHandler {
 private:
  FileRepository* fileRepository;

 public:
  FileHandler(FileRepository* fileRepository);
  FileHandler(const FileHandler& copy) = delete;

  bool getNextFileOpened(std::ifstream& nextFile);

  void closeCurrentFile(std::ifstream& currentFile);
};