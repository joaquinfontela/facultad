#include "Graph.h"

Graph::Graph() {}

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

void Graph::printGraphAdjacencies() {
  nodeIterator it;
  for (it = nodes.begin(); it != nodes.end(); ++it) {
    printf("%d: ", (*it).first);
    (*it).second->printAdjacentNodes();
  }
}