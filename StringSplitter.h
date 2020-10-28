#include <string>
#include <vector>

class StringSplitter {
 private:
  std::vector<int> findAll(std::string string, std::string searched) const;

 public:
  std::vector<std::string> split(std::string string,
                                 std::string delim = " ") const;
};