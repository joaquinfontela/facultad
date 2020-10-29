#include "FileParser.h"
#include "FileResults.h"
#include "FileVerifier.h"
#include "Thread.h"

class TaskAdmin : public Thread {
 private:
  FileParser fileParser;
  FileResults* fileResults;

 public:
  TaskAdmin(FileRepository& fileRepository, FileResults* fileResults);
  void run();
};
