#include "CommandParser.h"
#include "FileParser.h"
#include "FileResults.h"
#include "FileVerifier.h"

int main(int argc, char** argv) {
  CommandParser commandParser(argc, argv);
  FileRepository fileRepository(commandParser.getFileNames());
  FileParser parser(fileRepository);
  std::string nameOfFileParsed;
  FileVerifier fileVerifier;
  FileResults fileResults;

  while (parser.thereAreFilesPending()) {
    Graph fileGraph;
    parser.reinit();
    nameOfFileParsed = parser.parseNextFile(fileGraph);
    std::string fileResult;
    fileVerifier.verify(fileGraph, nameOfFileParsed, fileResult);
    fileResults.addResult(fileResult);
  }

  fileResults.printResults();

  return 0;
}
