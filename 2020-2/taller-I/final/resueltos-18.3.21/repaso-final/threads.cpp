#include <thread>
#include <mutex>
#include <iostream>
#include <atomic>


int i;

#define MAX_NUM 100

class Printer {

	std::mutex m;
	std::atomic<bool>& print;
	
	bool keepPrinting() { return print; }
	
	void print_num(bool even) {
	
		if ((i % 2 == 0) == even) {
			std::cout << (even ? "Even: " : "Odd: ") << i++ << std::endl;
		}
		if (i > MAX_NUM) print = false;
	}
		
	
	public:	
		
		Printer(std::atomic<bool>& print) : print(print) {}
		
		void print_num_if_not_max(bool even) {
			
			std::unique_lock<std::mutex> lock(m);
			if (this->keepPrinting()) {
				this->print_num(even);
			}
		}

};

void printOddNumbers(Printer& p, std::atomic<bool>& print) {
	while (print) {
		p.print_num_if_not_max(false);
	}
}

void printEvenNumbers(Printer& p, std::atomic<bool>& print) {
	while (print) {
		p.print_num_if_not_max(true);
	}
}


int main(int argc, char* arv[]) {

	i = 1;

	std::atomic<bool> keepPrinting(true);
	Printer p(keepPrinting);
	
	std::thread t1(printOddNumbers, std::ref(p), std::ref(keepPrinting));
	std::thread t2(printEvenNumbers, std::ref(p), std::ref(keepPrinting));
	
	t1.join(); t2.join();
	
	return 0;
}
