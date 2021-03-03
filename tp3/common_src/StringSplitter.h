#include <iostream>
#include <string>
#include <vector>

class StringSplitter {
 private:
  std::vector<int> findAll(const std::string& string,
                           const std::string& searched) const;

 public:
  std::vector<std::string> split(const std::string& string,
                                 const std::string& delim = " ") const;
};
