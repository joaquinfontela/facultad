#include <iostream>

using namespace std;

class A {
 public:
  A() { cout << "A()" << endl; }
  ~A() { cout << "~A()" << endl; }
};

class B : public A {
 public:
  B() { cout << "B()" << endl; }
  ~B() { cout << "~B()" << endl; }
};

int main() {
  B b;
  A* pB = new B();
  delete pB;
  return 0;
}