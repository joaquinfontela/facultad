#include <algorithm>
#include <iostream>
#include <list>

template <class T>
static bool containsElem(std::list<T> list, T elem) {
  return (std::find(list.begin(), list.end(), elem) != list.end());
}

template <class T>
std::list<T> sacar(std::list<T>& a, std::list<T>& b) {
  std::list<T> newList;
  for (auto elem : a) {
    if (!containsElem(b, elem)) {
      newList.push_back(elem);
    }
  }
  return newList;
}

int main() {
  std::list<int> a;
  std::list<int> b;
  a.push_back(1);
  a.push_back(2);
  a.push_back(3);
  a.push_back(4);
  a.push_back(5);
  b.push_back(3);
  b.push_back(5);
  std::list<int> c = sacar(a, b);
  for (auto elem : c) {
    std::cout << elem << std::endl;
  }
  return 0;
}