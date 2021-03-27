#include <algorithm>
#include <iostream>
#include <list>

template <class T>
bool listContainsElement(std::list<T> list, T element);

template <class T>
std::list<T> DobleSiNo(std::list<T>& a, std::list<T>& b) {
  std::list<T> newList;
  for (auto elem : a) {
    newList.push_back(elem);
    if (!listContainsElement(b, elem)) newList.push_back(elem);
  }
  return newList;
}

template <class T>
bool listContainsElement(std::list<T> list, T element) {
  return (std::find(list.begin(), list.end(), element) != list.end());
}

int main() {
  std::list<int> a;
  std::list<int> b;
  a.push_back(1);
  a.push_back(2);
  a.push_back(3);
  a.push_back(4);
  a.push_back(5);
  b.push_back(2);
  b.push_back(3);
  std::list<int> c = DobleSiNo(a, b);
  for (auto elem : c) {
    std::cout << elem << std::endl;
  }
  return 0;
}