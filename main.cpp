#include "CommandParser.h"
#include "FileParser.h"
#include "FileVerifier.h"
#include "TaskAdmin.h"

int main(int argc, char** argv) {
  CommandParser commandParser(argc, argv);
  FileRepository fileRepository(commandParser.getFileNames());
  FileResults fileResults;

  std::vector<TaskAdmin*> threads;
  int i;
  for (i = 0; i < argc; ++i) {
    threads.push_back(new TaskAdmin(fileRepository, &fileResults));
  }

  /*
    FileParser parser(&fileRepository);
  std::string nameOfFileParsed;
  FileVerifier fileVerifier;

  while (parser.thereAreFilesPending()) {
    Graph fileGraph;
    parser.reinit();
    nameOfFileParsed = parser.parseNextFile(fileGraph);
    std::string fileResult;
    fileVerifier.verify(fileGraph, nameOfFileParsed, fileResult);
    fileResults.addResult(fileResult);
  }

  fileResults.printResults();
  */

  return 0;
}
