#include <iostream>
#include <string>

class Phone {
  std::string number;
  friend std::ostream& operator<<(std::ostream& out, const Phone& p);
  friend std::istream& operator>>(std::istream& in, Phone& p);

 public:
  Phone(int area, int number);

  Phone(Phone&& other);

  Phone(const Phone& other);

  bool operator==(const Phone& other) const;

  Phone operator=(const Phone& other);

  operator long();
};

std::ostream& operator<<(std::ostream& out, const Phone& p);
std::istream& operator>>(std::istream& in, Phone& p) {
  in >> p.number;
  return in;
}