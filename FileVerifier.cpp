#include "FileVerifier.h"

void FileVerifier::verify(Graph& fileGraph, const std::string nameOfFile,
                          std::string& result) const {
  if (nameOfFile.empty()) {
    result = "";
    return;
  }
  result = (nameOfFile + " ");

  if (fileGraph.hasLoops()) {
    result += "FAIL: cycle detected";
  } else if (fileGraph.hasUnreachableInstructions()) {
    result += "FAIL: unused instructions detected";
  } else {
    result += "GOOD";
  }
  result += "\n";
}
