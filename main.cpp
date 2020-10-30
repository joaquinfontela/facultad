#include "CommandParser.h"
#include "FileParser.h"
#include "FileVerifier.h"
#include "TaskAdmin.h"

int main(int argc, char** argv) {
  CommandParser commandParser(argc, argv);
  FileRepository fileRepository(commandParser.getFileNames());
  FileResults fileResults;

  std::vector<TaskAdmin*> threads;
  int numberOfThreads = commandParser.getNumberOfThreads();
  for (int i = 0; i < numberOfThreads; i++) {
    threads.push_back(new TaskAdmin(fileRepository, fileResults));
  }
  unsigned int i;
  for (i = 0; i < threads.size(); i++) {
    threads[i]->start();
  }
  for (i = 0; i < threads.size(); i++) {
    threads[i]->join();
    delete threads[i];
  }

  fileResults.printResults();

  return 0;
}
