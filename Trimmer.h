#include <string>

class Trimmer {
 public:
  Trimmer();
  Trimmer(const Trimmer& copy) = delete;

  std::string leftTrim(const std::string& str,
                       const std::string& chars = "\t\n\v\f\r ") const;

  std::string rightTrim(const std::string& str,
                        const std::string& chars = "\t\n\v\f\r ") const;

  std::string trim(const std::string& str,
                   const std::string& chars = "\t\n\v\f\r ") const;
};