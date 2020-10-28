#ifndef GRAPH_H
#define GRAPH_H

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

  void addVertex(const int newNode);
  void addEdge(const int fromNode, const int toNode);
  bool hasNode(const int node) const;
  void addVertexIfNotInGraph(const int newNode);
  int size() const;
  bool hasUnreachableInstructions();
  bool hasLoops();

  //~Graph();
};

#endif