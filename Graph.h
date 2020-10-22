#include <list>
#include <map>

#include "Node.h"

typedef std::map<int, Node*>::iterator nodeIterator;

class Graph {
 private:
  std::map<int, Node*> nodes;

 public:
  Graph();
  Graph(const Graph& copy) = delete;

  void addVertex(Node* newNode);
  void addEdge(Node* fromNode, Node* toNode);
  bool hasNode(Node* node) const;
  void addVertexIfNotInGraph(Node* newNode);
  int size() const;

  void printGraphAdjacencies();

  //~Graph();
};