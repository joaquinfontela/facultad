#include "CommandParser.h"
#include "FileParser.h"
#include "FileVerifier.h"

int main(int argc, char** argv) {
  CommandParser commandParser(argc, argv);
  FileRepository fileRepository(commandParser.getFileNames());
  FileParser parser(&fileRepository);
  std::string nameOfFileParsed;
  FileVerifier fileVerifier;

  while (parser.thereAreFilesPending()) {
    Graph fileGraph;
    parser.reinit();
    nameOfFileParsed = parser.parseNextFile(fileGraph);
    fileVerifier.verify(fileGraph, nameOfFileParsed);
  }

  return 0;
}