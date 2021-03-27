#include <iostream>

class Sumador {
 private:
  int suma;
  Sumador(int suma) : suma(suma) {}
  friend std::ostream& operator<<(std::ostream& out, const Sumador& s);

 public:
  Sumador() : suma(0) {}

  Sumador(Sumador&& other) {
    this->suma = other.suma;
    other.suma = 0;
  }

  void operator()(int valor) { suma += valor; }

  void operator++() { ++suma; }

  void operator++(int) { suma++; }

  Sumador operator-(const Sumador& s) const {
    return Sumador(this->suma - s.suma);
  }

  bool operator==(const Sumador& s) const { return this->suma == s.suma; }

  operator float() const { return (float)suma; }
};

std::ostream& operator<<(std::ostream& out, const Sumador& s) {
  out << s.suma;
  return out;
}

int main() {
  Sumador s1;
  Sumador s2;
  std::cout << s1 << s2 << std::endl;
  s1++;
  s2(5);
  Sumador s3 = s2 - s1;
  std::cout << s1 << s2 << s3 << std::endl;
  s3++;
  std::cout << (s1 == s2) << (s2 == s3) << std::endl;
  float s1Value = float(s1);
  std::cout << s1Value << std::endl;
  return 0;
}