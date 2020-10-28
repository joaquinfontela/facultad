#include "CommandParser.h"
#include "FileParser.h"
#include "FileVerifier.h"

int main(int argc, char** argv) {
  CommandParser commandParser(argc, argv);
  FileRepository fileRepository(commandParser.getFileNames());
  std::string nameOfFileParsed;
  FileVerifier fileVerifier;
  FileParser parser(&fileRepository);

  while (parser.thereAreFilesPending()) {
    Graph fileGraph;
    parser.reinit();
    nameOfFileParsed = parser.parseNextFile(fileGraph);
    fileVerifier.verify(fileGraph, nameOfFileParsed);
  }

  return 0;
}