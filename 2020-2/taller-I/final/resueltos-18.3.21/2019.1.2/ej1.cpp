#include <iostream>
#include <string>

class Numero {
  std::string number;
  friend std::ostream& operator<<(std::ostream& out, const Numero& n);

 public:
  Numero(unsigned long number) : number(std::to_string(number)) {}
  Numero() : number("0") {}
  Numero(Numero&& other) {
    this->number = other.number;
    other.number = "";
  }
  void operator()(int value) {
    this->number = std::to_string(std::stoi(number) + value);
  }
  void operator=(const Numero& other) { this->number = other.number; }
  operator long() { return (long)std::stoi(this->number); }
  unsigned long operator++(int) {
    unsigned long numberCopy = std::stoi(this->number);
    this->number = std::to_string(numberCopy + 1);
    return numberCopy;
  }
};

std::ostream& operator<<(std::ostream& out, const Numero& n) {
  out << n.number;
  return out;
}

int main() {
  Numero n(19);
  Numero other;
  std::cout << n << std::endl;
  std::cout << other << std::endl;
  n(14);
  other(11);
  std::cout << n << std::endl;
  std::cout << other << std::endl;
  n++;
  other++;
  std::cout << n << std::endl;
  std::cout << other << std::endl;
  n = other;
  std::cout << n << std::endl;
  std::cout << other << std::endl;
  return 0;
}