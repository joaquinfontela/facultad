#include "Graph.h"

Graph::Graph() {}

void Graph::addVertex(const int newNode) {
  nodes.insert(newNode);
  std::vector<int> adj;
  adjacencies.insert({newNode, adj});
}

void Graph::addEdge(const int fromNode, const int toNode) {
  addVertexIfNotInGraph(fromNode);
  addVertexIfNotInGraph(toNode);
  adjacencies.at(fromNode).push_back(toNode);
}

bool Graph::hasNode(const int node) const {
  return (nodes.find(node) != nodes.end());
}

void Graph::addVertexIfNotInGraph(const int newNode) {
  if (!hasNode(newNode)) addVertex(newNode);
}

size_t Graph::size() const { return nodes.size(); }

std::set<int> Graph::runDFS(DFS& dfs) {
  std::set<int> visitedNodes;
  std::set<int> parentNodes;
  dfs.DFSexecute(1, &visitedNodes, &parentNodes);
  return visitedNodes;
}

bool Graph::hasUnreachableInstructions() {
  DFS dfs(adjacencies);
  std::set<int> visitedNodes = runDFS(dfs);
  return (visitedNodes.size() != this->size());
}

bool Graph::hasLoops() {
  DFS dfs(adjacencies);
  runDFS(dfs);
  return dfs.originalGraphHasCycles();
}