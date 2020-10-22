#include <stdio.h>

#include <list>

class Node {
 private:
  int lineNumber;
  std::list<Node*> adjacentNodes;

 public:
  Node(int newLineNumber) : lineNumber(newLineNumber) {}

  std::list<Node*> getNext() const;
  int addNext(Node* newNode);
  int getLine() const;
  void printLineNumber() const;
  void printAdjacentNodes();
};