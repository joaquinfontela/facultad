#include "Graph.h"

void Graph::addVertex(Node* newNode) {
  nodes.insert({newNode->getLine(), newNode});
}

void Graph::addEdge(Node* fromNode, Node* toNode) {
  this->addVertexIfNotInGraph(fromNode);
  this->addVertexIfNotInGraph(toNode);
  fromNode->addNext(toNode);
}

bool Graph::hasNode(Node* node) const {
  return (nodes.find(node->getLine()) != nodes.end());
}

void Graph::addVertexIfNotInGraph(Node* newNode) {
  if (!this->hasNode(newNode)) addVertex(newNode);
}

int Graph::size() const { return nodes.size(); }

std::set<Node*> Graph::runDFS() {
  Node* firstNode = nodes.begin()->second;
  std::set<Node*> visitedNodes;
  std::set<Node*> parentNodes;
  this->dfs.DFSexecute(firstNode, &visitedNodes, &parentNodes);
  return visitedNodes;
}

bool Graph::hasUnreachableInstructions() {
  std::set<Node*> visitedNodes = this->runDFS();
  return (visitedNodes.size() != this->size());
}

bool Graph::hasLoops() {
  this->runDFS();
  return this->dfs.originalGraphHasCycles();
}

void Graph::printGraphAdjacencies() {
  nodeIterator it;
  for (it = nodes.begin(); it != nodes.end(); ++it) {
    printf("%d: ", (*it).first);
    (*it).second->printAdjacentNodes();
  }
}