#include "TaskAdmin.h"

TaskAdmin::TaskAdmin(FileRepository& fileRepository, FileResults& fr)
    : fileParser(fileRepository), fileResults(fr) {}

void TaskAdmin::run() {
  FileVerifier fileVerifier;

  std::string nameOfFileParsed = "notNull";
  Graph fileGraph;
  while (!(nameOfFileParsed = fileParser.parseNextFile(fileGraph)).empty()) {
    std::string fileResult;
    fileVerifier.verify(fileGraph, nameOfFileParsed, fileResult);
    fileResults.addResult(fileResult);
    fileParser.reinit();
    fileGraph.reinit();
  }
}

