#include <condition_variable>
#include <iostream>
#include <mutex>
#include <thread>

#define MAX 100

int i;

class Printer {
  std::mutex m;
  std::condition_variable cv;
  bool& continuePrinting;

 public:
  Printer(bool& continuePrinting) : continuePrinting(continuePrinting) {}

  void printNumber(bool even) {
    std::unique_lock<std::mutex> lock(m);
    if ((i % 2 == 0) != even) {
      cv.wait(lock);
    }
    std::cout << (even ? "Even: " : "Odd: ") << i << std::endl;
    i++;
    cv.notify_all();
    continuePrinting = (i <= MAX);
  }
};

void printOddNumbers(Printer& p, bool& continuePrinting) {
  while (continuePrinting) {
    p.printNumber(false);
  }
}

void printEvenNumbers(Printer& p, bool& continuePrinting) {
  while (continuePrinting) {
    p.printNumber(true);
  }
}

int main() {
  i = 1;
  bool continuePrinting = true;
  Printer p(continuePrinting);

  std::thread t1(printOddNumbers, std::ref(p), std::ref(continuePrinting));
  std::thread t2(printEvenNumbers, std::ref(p), std::ref(continuePrinting));

  t1.join();
  t2.join();

  return 0;
}