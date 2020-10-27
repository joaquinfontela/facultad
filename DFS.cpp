#include "DFS.h"

DFS::DFS() { this->_originalGraphHasCycles = false; }

bool DFS::setContainsNode(Node* node, std::set<Node*>* nodeSet) {
  return (nodeSet->find(node) != nodeSet->end());
}

bool DFS::hasBeenVisited(Node* currentNode, std::set<Node*>* visitedNodes) {
  return setContainsNode(currentNode, visitedNodes);
}

bool DFS::adjacentNodeIsAParentNode(Node* adjacentNode,
                                    std::set<Node*>* parentNodes) {
  return setContainsNode(adjacentNode, parentNodes);
}

bool DFS::hasABackEdge(std::vector<Node*>* currentNodeAdjacentNodes,
                       std::set<Node*>* currentNodeParentNodes) {
  std::vector<Node*>::iterator it;
  for (it = currentNodeAdjacentNodes->begin();
       it != currentNodeAdjacentNodes->end(); ++it) {
    Node* currentAdjacentNode = (*it);
    if (adjacentNodeIsAParentNode(currentAdjacentNode, currentNodeParentNodes))
      return true;
  }
  return false;
}

void DFS::DFSexecute(Node* currentNode, std::set<Node*>* visitedNodes,
                     std::set<Node*>* parentNodes) {
  if (!hasBeenVisited(currentNode, visitedNodes)) {
    visitedNodes->insert(currentNode);
    parentNodes->insert(currentNode);
    std::vector<Node*> adjacentNodes = currentNode->getNext();
    if (hasABackEdge(&adjacentNodes, parentNodes))
      this->_originalGraphHasCycles = true;
    std::vector<Node*>::iterator it;
    for (it = adjacentNodes.begin(); it != adjacentNodes.end(); ++it) {
      DFSexecute((*it), visitedNodes, parentNodes);
    }
    parentNodes->erase(currentNode);
  }
}

bool DFS::originalGraphHasCycles() { return this->_originalGraphHasCycles; }