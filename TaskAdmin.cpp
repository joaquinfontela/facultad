#include "TaskAdmin.h"

TaskAdmin::TaskAdmin(FileRepository& fileRepository, FileResults* fileResults)
    : fileParser(&fileRepository) {
  this->fileResults = fileResults;
}

void TaskAdmin::run() {
  std::string nameOfFileParsed;
  FileVerifier fileVerifier;

  while (fileParser.thereAreFilesPending()) {
    Graph fileGraph;
    fileParser.reinit();
    nameOfFileParsed = fileParser.parseNextFile(fileGraph);
    std::string fileResult;
    fileVerifier.verify(fileGraph, nameOfFileParsed, fileResult);
    fileResults->addResult(fileResult);
  }
}