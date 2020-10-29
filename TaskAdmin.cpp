#include "TaskAdmin.h"

TaskAdmin::TaskAdmin(FileRepository& fileRepository, FileResults* fileResults)
    : fileParser(&fileRepository) {
  this->fileResults = fileResults;
}

void TaskAdmin::run() {}