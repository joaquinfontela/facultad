#include <string>

class Trimmer {
 public:
  std::string leftTrim(const std::string& str,
                       const std::string& chars = "\t\n\v\f\r ");

  std::string rightTrim(const std::string& str,
                        const std::string& chars = "\t\n\v\f\r ");

  std::string trim(const std::string& str,
                   const std::string& chars = "\t\n\v\f\r ");
};