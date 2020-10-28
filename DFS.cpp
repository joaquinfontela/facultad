#include "DFS.h"

DFS::DFS(const adjacencyMap& adjMap) {
  this->adjMap = adjMap;
  this->_originalGraphHasCycles = false;
}

bool DFS::setContainsNode(const int node, const std::set<int>* nodeSet) const {
  return (nodeSet->find(node) != nodeSet->end());
}

bool DFS::hasBeenVisited(const int currentNode,
                         const std::set<int>* visitedNodes) const {
  return setContainsNode(currentNode, visitedNodes);
}

bool DFS::adjacentNodeIsAParentNode(const int adjacentNode,
                                    const std::set<int>* parentNodes) const {
  return setContainsNode(adjacentNode, parentNodes);
}

bool DFS::hasABackEdge(std::vector<int>* currentNodeAdjacentNodes,
                       const std::set<int>* currentNodeParentNodes) const {
  std::vector<int>::iterator it;
  for (it = currentNodeAdjacentNodes->begin();
       it != currentNodeAdjacentNodes->end(); ++it) {
    if (adjacentNodeIsAParentNode(*it, currentNodeParentNodes)) return true;
  }
  return false;
}

void DFS::DFSexecute(const int currentNode, std::set<int>* visitedNodes,
                     std::set<int>* parentNodes) {
  if (!hasBeenVisited(currentNode, visitedNodes)) {
    visitedNodes->insert(currentNode);
    parentNodes->insert(currentNode);
    std::vector<int> adjacentNodes = adjMap.at(currentNode);
    if (hasABackEdge(&adjacentNodes, parentNodes))
      this->_originalGraphHasCycles = true;
    std::vector<int>::iterator it;
    for (it = adjacentNodes.begin(); it != adjacentNodes.end(); ++it) {
      DFSexecute((*it), visitedNodes, parentNodes);
    }
    parentNodes->erase(currentNode);
  }
}

bool DFS::originalGraphHasCycles() const { return _originalGraphHasCycles; }