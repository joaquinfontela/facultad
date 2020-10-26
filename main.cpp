#include "CommandParser.h"
#include "FileRepository.h"
#include "Graph.h"

int main(int argc, char** argv) {
  CommandParser commandParser(argc, argv);
  FileRepository fileRepository(commandParser.getFileNames());

  Graph myGraph;
  Node nodeA(1);
  Node nodeB(2);
  Node nodeC(3);
  Node nodeD(4);

  myGraph.addVertex(&nodeA);
  myGraph.addVertex(&nodeB);
  myGraph.addVertex(&nodeC);
  myGraph.addVertex(&nodeD);

  myGraph.addEdge(&nodeA, &nodeB);
  myGraph.addEdge(&nodeB, &nodeC);
  myGraph.addEdge(&nodeA, &nodeC);
  myGraph.addEdge(&nodeC, &nodeD);

  myGraph.printGraphAdjacencies();
  std::cout << myGraph.hasUnreachableInstructions() << "\n";
  std::cout << myGraph.hasLoops() << "\n";

  return 0;
}