#include <iostream>
#include <map>
#include <set>

#include "DFS.h"

typedef std::set<int>::iterator nodeIterator;

class Graph {
 private:
  std::set<int> nodes;
  adjacencyMap adjacencies;
  std::set<int> runDFS(DFS& dfs);

 public:
  Graph();
  Graph(const Graph& copy) = delete;

  void addVertex(int newNode);
  void addEdge(int fromNode, int toNode);
  bool hasNode(int node) const;
  void addVertexIfNotInGraph(int newNode);
  int size() const;
  bool hasUnreachableInstructions();
  bool hasLoops();

  void printGraphAdjacencies();

  //~Graph();
};