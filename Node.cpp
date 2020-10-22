#include "Node.h"

std::list<Node*> Node::getNext() const { return adjacentNodes; }

int Node::addNext(Node* newNode) { this->adjacentNodes.push_back(newNode); }

int Node::getLine() const { return lineNumber; }

void Node::printLineNumber() const { printf("%d\n", lineNumber); }

void Node::printAdjacentNodes() {
  std::list<Node*>::iterator it;
  for (it = this->adjacentNodes.begin(); it != this->adjacentNodes.end();
       ++it) {
    printf("%d | ", (*it)->getLine());
  }
  puts("\n");
}