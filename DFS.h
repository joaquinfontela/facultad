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
  bool setContainsNode(int node, std::set<int>* nodeSet) const;
  bool hasBeenVisited(int currentNode, std::set<int>* visitedNodes) const;
  bool adjacentNodeIsAParentNode(int adjacentNode,
                                 std::set<int>* parentNodes) const;
  bool hasABackEdge(std::vector<int>* currentNodeAdjacentNodes,
                    std::set<int>* currentNodeParentNodes) const;

 public:
  DFS(adjacencyMap& adjMap);
  DFS(const DFS& copy) = delete;

  void DFSexecute(int currentNode, std::set<int>* visitedNodes,
                  std::set<int>* parentNodes);
  bool originalGraphHasCycles() const;
};

#endif
