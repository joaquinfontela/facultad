#ifndef DFS_H
#define DFS_H

#include <map>
#include <set>
#include <vector>

typedef std::map<int, std::vector<int>> adjacencyMap;

class DFS {
 private:
  adjacencyMap adjMap;
  bool _originalGraphHasCycles;
  bool setContainsNode(int node, std::set<int>* nodeSet);
  bool hasBeenVisited(int currentNode, std::set<int>* visitedNodes);
  bool adjacentNodeIsAParentNode(int adjacentNode, std::set<int>* parentNodes);
  bool hasABackEdge(std::vector<int>* currentNodeAdjacentNodes,
                    std::set<int>* currentNodeParentNodes);

 public:
  DFS(adjacencyMap& adjMap);
  DFS(const DFS& copy) = delete;

  void DFSexecute(int currentNode, std::set<int>* visitedNodes,
                  std::set<int>* parentNodes);
  bool originalGraphHasCycles();
};

#endif
