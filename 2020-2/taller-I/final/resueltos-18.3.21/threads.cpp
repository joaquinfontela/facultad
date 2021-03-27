#include <atomic>
#include <thread>
#include <mutex>
#include <iostream>

#define MAX_VAL 100

int i;

class Printer {

	std::mutex m;
	std::atomic<bool>& keepPrinting;
	
	public:
	
	Printer(std::atomic<bool>& keepPrinting) : keepPrinting(keepPrinting) {}
	
	void printNumber(bool even) {
		std::unique_lock<std::mutex> lock(m);
		if ((i % 2 == 0) == even) {
			std::cout << (even ? "EVEN: " : "ODD: ") << i++ << std::endl; 
		}	
		if (i > MAX_VAL) keepPrinting = false;
	}
};

void printOddNumbers(Printer& p, std::atomic<bool>& print) {
	while(print) {
		p.printNumber(false);
	}
}

void printEvenNumbers(Printer& p, std::atomic<bool>& print) {
	while(print) {
		p.printNumber(true);
	}
}

int main() {
	i = 1;
	std::atomic<bool> keepPrinting(true);
	Printer p(keepPrinting);
	
	std::thread t1(printOddNumbers, std::ref(p), std::ref(keepPrinting));
	std::thread t2(printEvenNumbers, std::ref(p), std::ref(keepPrinting));
	
	t1.join(); t2.join();
	
	return 0;
}
