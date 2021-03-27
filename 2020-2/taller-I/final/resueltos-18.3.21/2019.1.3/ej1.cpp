#include <math.h>

#include <iostream>

class Complex {
  float re;
  float im;
  friend std::ostream& operator<<(std::ostream& out, const Complex& c);
  friend std::istream& operator>>(std::istream& in, const Complex& c);

 public:
  Complex() : re(0), im(0) {}

  Complex(int re, int im) : re(re), im(im) {}

  Complex operator+(const Complex& other) const {
    return Complex(this->re + other.re, this->im + other.im);
  }

  Complex operator++(int) {
    Complex copy(*this);
    this->re++;
    this->im++;
    return copy;
  }

  Complex operator++() {
    this->re++;
    this->im++;
    return *this;
  }

  operator long() { return (long)sqrt(pow(this->re, 2) + pow(this->im, 2)); }
};

std::ostream& operator<<(std::ostream& out, const Complex& c) {
  out << "Complex (Re: " << c.re << ", Im: " << c.im << ")";
  return out;
}

std::istream& operator>>(std::istream& in, const Complex& c);

// ERA DECLARAR!
