#include <set>

#include "Node.h"

class DFS {
 private:
  bool _originalGraphHasCycles;
  bool setContainsNode(Node* node, std::set<Node*>* nodeSet);
  bool hasBeenVisited(Node* currentNode, std::set<Node*>* visitedNodes);
  bool adjacentNodeIsAParentNode(Node* adjacentNode,
                                 std::set<Node*>* parentNodes);
  bool hasABackEdge(std::vector<Node*>* currentNodeAdjacentNodes,
                    std::set<Node*>* currentNodeParentNodes);

 public:
  DFS();
  DFS(const DFS& copy) = delete;

  void DFSexecute(Node* currentNode, std::set<Node*>* visitedNodes,
                  std::set<Node*>* parentNodes);
  bool originalGraphHasCycles();
};
