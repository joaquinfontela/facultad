#ifndef GRAPH_H
#define GRAPH_H

#include <iostream>
#include <map>
#include <set>
#include <vector>

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

  void addVertex(const int newNode);
  void addEdge(const int fromNode, const int toNode);
  bool hasNode(const int node) const;
  void addVertexIfNotInGraph(const int newNode);
  size_t size() const;
  bool hasUnreachableInstructions();
  bool hasLoops();
  void reinit();

  //~Graph();
};

#endif
