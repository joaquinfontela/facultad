#include <algorithm>
#include <functional>
#include <iostream>
#include <mutex>
#include <string>
#include <vector>

class FileResults {
 private:
  std::vector<std::string> results;
  std::mutex m;

 public:
  void addResult(std::string result);
  void printResults();
};
