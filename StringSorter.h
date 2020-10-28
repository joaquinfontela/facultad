#include <queue>
#include <string>
#include <vector>

typedef std::vector<std::string> strList;

class StringSorter {
 public:
  std::queue<std::string> sort(strList stringList) const;
};