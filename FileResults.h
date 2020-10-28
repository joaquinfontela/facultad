#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

class FileResults {
 private:
  std::vector<std::string> results;

 public:
  void addResult(std::string result);
  void printResults();
};