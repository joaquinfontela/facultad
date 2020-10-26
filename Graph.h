#include <iostream>
#include <map>
#include <set>

#include "DFS.h"

typedef std::map<int, Node*>::iterator nodeIterator;

class Graph {
 private:
  std::map<int, Node*> nodes;
  DFS dfs;
  std::set<Node*> runDFS();

 public:
  Graph() : dfs() {}
  Graph(const Graph& copy) = delete;

  void addVertex(Node* newNode);
  void addEdge(Node* fromNode, Node* toNode);
  bool hasNode(Node* node) const;
  void addVertexIfNotInGraph(Node* newNode);
  int size() const;
  bool hasUnreachableInstructions();
  bool hasLoops();

  void printGraphAdjacencies();

  //~Graph();
};