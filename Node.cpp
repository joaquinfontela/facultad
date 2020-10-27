#include "Node.h"

Node::Node(int newLineNumber) : lineNumber(newLineNumber) { this->label = ""; }

std::vector<Node*> Node::getNext() const { return adjacentNodes; }

int Node::addNext(Node* newNode) { this->adjacentNodes.push_back(newNode); }

int Node::getLine() const { return lineNumber; }

std::string Node::getLabel() const { return label; }

void Node::updateLabel(std::string label) { this->label = label; }

void Node::printLineNumber() const { printf("%d\n", lineNumber); }

void Node::printAdjacentNodes() {
  std::vector<Node*>::iterator it;
  for (it = this->adjacentNodes.begin(); it != this->adjacentNodes.end();
       ++it) {
    printf("%d | ", (*it)->getLine());
  }
  puts("\n");
}