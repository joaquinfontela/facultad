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
  bool setContainsNode(const int node, const std::set<int>& nodeSet) const;
  bool hasBeenVisited(const int currentNode,
                      const std::set<int>& visitedNodes) const;
  bool adjacentNodeIsAParentNode(const int adjacentNode,
                                 const std::set<int>& parentNodes) const;
  bool hasABackEdge(std::vector<int>& currentNodeAdjacentNodes,
                    const std::set<int>& currentNodeParentNodes) const;

 public:
  explicit DFS(const adjacencyMap& adjMap);
  DFS(const DFS& copy) = delete;

  void DFSexecute(const int currentNode, std::set<int>& visitedNodes,
                  std::set<int>& parentNodes);
  bool originalGraphHasCycles() const;
};

#endif
