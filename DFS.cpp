#include "DFS.h"

DFS::DFS(adjacencyMap& adjMap) {
  this->adjMap = adjMap;
  this->_originalGraphHasCycles = false;
}

bool DFS::setContainsNode(int node, std::set<int>* nodeSet) {
  return (nodeSet->find(node) != nodeSet->end());
}

bool DFS::hasBeenVisited(int currentNode, std::set<int>* visitedNodes) {
  return setContainsNode(currentNode, visitedNodes);
}

bool DFS::adjacentNodeIsAParentNode(int adjacentNode,
                                    std::set<int>* parentNodes) {
  return setContainsNode(adjacentNode, parentNodes);
}

bool DFS::hasABackEdge(std::vector<int>* currentNodeAdjacentNodes,
                       std::set<int>* currentNodeParentNodes) {
  std::vector<int>::iterator it;
  for (it = currentNodeAdjacentNodes->begin();
       it != currentNodeAdjacentNodes->end(); ++it) {
    if (adjacentNodeIsAParentNode(*it, currentNodeParentNodes)) return true;
  }
  return false;
}

void DFS::DFSexecute(int currentNode, std::set<int>* visitedNodes,
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

bool DFS::originalGraphHasCycles() { return this->_originalGraphHasCycles; }