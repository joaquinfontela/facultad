#ifndef TP_FINAL_MAP_H
#define TP_FINAL_MAP_H

#include <string>

class Map {
 public:
  Map(const std::string& s) : dimx(10), dimy(13) {}
  int matrix[10][13] = {{1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {2, 0, 2, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                        {2, 0, 2, 0, 0, 0, 1, 0, 4, 4, 4, 0, 1},
                        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 3, 0, 0, 0, 0, 0, 4, 4, 4, 0, 1},
                        {1, 0, 3, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                        {1, 0, 3, 0, 1, 0, 0, 0, 3, 3, 3, 0, 3},
                        {1, 0, 3, 0, 1, 1, 1, 0, 1, 0, 3, 0, 3},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1}};
  int dimx;
  int dimy;
  int get(int x, int y) { return matrix[x][y]; } 
};

#endif  // TP_FINAL_MAP_H
