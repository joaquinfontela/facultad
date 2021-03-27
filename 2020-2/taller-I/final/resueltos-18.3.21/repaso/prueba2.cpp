#include <iostream>
#include <list>

template <class T>
void agregarTodosLosElementosDeLaPrimeraListaALaSegunda(const std::list<T>& a,
                                                        std::list<T>& b) {
  for (auto elem : a) {
    b.push_back(elem);
  }
}
template <class T>
void agregarLosPrimerosCincoElementosDeAaB(const std::list<T>& a,
                                           std::list<T>& b) {
  int i = 0;
  for (auto elem : a) {
    if (i < 5) {
      b.push_back(elem);
    } else
      break;
    i++;
  }
}
template <class T>
void reemplazarElemEnPos(int pos, T elem, std::list<T>& lista) {
  std::list<T> auxList;
  int pos_lista = 4;
  for (auto e : lista) {
    std::cout << e << std::endl;
    if (pos_lista == pos) break;
    auxList.push_back(e);
    lista.pop_back();
    pos_lista--;
  }
  lista.pop_back();
  lista.push_back(elem);
  for (auto e : auxList) {
    lista.push_back(e);
  }
}
template <class T>
void reemplazarPorElMenorSiEsMayor(std::list<T>& a, T b) {
  int pos = 0;
  int pos_menor = 0;
  T menor_elem = a.front();
  for (auto elem : a) {
    if (elem < menor_elem) {
      pos_menor = pos;
      menor_elem = elem;
    }
    pos++;
  }
  if (b > menor_elem) {
    reemplazarElemEnPos(pos, b, a);
  }
}
template <class T>
std::list<T> Mayores(const std::list<T> a) {
  std::list<T> newList;
  if (a.size() <= 5) {
    agregarTodosLosElementosDeLaPrimeraListaALaSegunda(a, newList);
    return newList;
  }
  agregarLosPrimerosCincoElementosDeAaB(a, newList);
  for (auto elem : a) {
    reemplazarPorElMenorSiEsMayor(newList, elem);
  }
  return newList;
}

int main() {
  std::list<int> l;
  for (int i = 0; i < 100; i++) {
    l.push_back(i);
  }
  std::list<int> l2 = Mayores(l);
  for (auto elem : l2) {
    std::cout << elem << std::endl;
  }
}