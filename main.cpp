#include "CommandParser.h"
#include "FileParser.h"

int main(int argc, char** argv) {
  CommandParser commandParser(argc, argv);
  FileRepository fileRepository(commandParser.getFileNames());
  Graph fileGraph;
  FileParser parser(&fileRepository);

  parser.parseNextFile(fileGraph);

  fileGraph.printGraphAdjacencies();

  return 0;
}