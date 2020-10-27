#include <string>
#include <vector>

class StringSplitter {
 private:
  std::vector<int> findAll(std::string string, std::string searched);

 public:
  std::vector<std::string> split(std::string string, std::string delim = " ");
};