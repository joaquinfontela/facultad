#ifndef FILE_VERIFIER_H
#define FILE_VERIFIER_H

#include <string>

#include "Graph.h"

class FileVerifier {
 public:
  void verify(Graph& fileGraph, const std::string& nameOfFile,
              std::string& result) const;
};

#endif
