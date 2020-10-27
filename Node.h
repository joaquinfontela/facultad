#ifndef NODE_H_
#define NODE_H_

#include <stdio.h>

#include <string>
#include <vector>

class Node {
 private:
  int lineNumber;
  std::string label;
  std::vector<Node*> adjacentNodes;

 public:
  Node(int newLineNumber);
  Node(const Node& copy) = delete;

  std::vector<Node*> getNext() const;
  int addNext(Node* newNode);
  int getLine() const;
  std::string getLabel() const;
  void updateLabel(std::string label);
  void printLineNumber() const;
  void printAdjacentNodes();
};

#endif