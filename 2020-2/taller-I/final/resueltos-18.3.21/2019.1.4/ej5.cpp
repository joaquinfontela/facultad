#include <algorithm>
#include <iostream>
#include <list>

template <class T>
bool listContainsElem(const std::list<T>& list, const T& elem) {
  return (std::find(list.begin(), list.end(), elem) != list.end());
}

template <class T>
std::list<T> DobleSegunda(const std::list<T>& a, const std::list<T>& b) {
  std::list<T> newList;
  for (auto elem : a) {
    newList.push_back(elem);
    if (listContainsElem(b, elem)) {
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
  b.push_back(4);
  std::list<int> c = DobleSegunda(a, b);
  for (auto elem : c) {
    std::cout << elem << std::endl;
  }
  return 0;
}