#include "FileVerifier.h"

void FileVerifier::verify(Graph& fileGraph,
                          const std::string nameOfFile) const {
  if (nameOfFile.empty()) return;
  std::cout << nameOfFile << " ";

  if (fileGraph.hasLoops()) {
    std::cout << "FAIL: cycle detected";
  } else if (fileGraph.hasUnreachableInstructions()) {
    std::cout << "FAIL: unused instructions detected";
  } else {
    std::cout << "GOOD";
  }
  std::cout << "\n";
}