#include <atomic>
#include <iostream>
#include <mutex>
#include <thread>

#define LAST_NUM 100

std::atomic<int> i(0);
std::mutex m;
std::atomic<bool> running(true);

void printNextOddValue() {
  while (running) {
    std::unique_lock<std::mutex> lock(m);
    if (i > 100) break;
    if (i % 2 != 0) {
      std::cout << "Odd: " << i << std::endl;
      i++;
    }
  }
}

void printNextEvenValue() {
  while (running) {
    std::unique_lock<std::mutex> lock(m);
    if (i > 100) break;
    if (i % 2 == 0) {
      std::cout << "Even: " << i << std::endl;
      i++;
    }
  }
}

int main() {
  std::thread t1(printNextEvenValue);
  std::thread t2(printNextOddValue);

  t1.join();
  t2.join();

  return 0;
}
