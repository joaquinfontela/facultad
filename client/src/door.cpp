#include "door.h"
#include "area.h"
#include "texturemanager.h"
#include <iostream>

void Door::draw(TextureManager& manager, double posX, double posY, double dirX,
  double dirY, double planeX, double planeY, double* zBuffer) {


  double perpWallDist;
  double rayDirX = dirX + planeX * cameraX;
  double rayDirY = dirY + planeY * cameraX;

  if(this->side == 0) perpWallDist = (this->mapX - posX + (1 - stepX) / 2) / (rayDirX + 0.01);
  else perpWallDist = (this->mapY - posY + (1 - stepY) / 2) / (rayDirY + 0.01);

  int lineHeight = int(this->height / perpWallDist);


  double wallX;
  if (this->side == 0) wallX = posY + perpWallDist * rayDirY;
  else wallX = posX + perpWallDist * rayDirX;
  wallX -= floor((wallX));

  int texX = int(wallX * double(BLOCKSIZE));
  if(this->side == 0 && rayDirX > 0) texX = BLOCKSIZE - texX - 1;
  if(this->side == 1 && rayDirY < 0) texX = BLOCKSIZE - texX - 1;

  Area srcArea(texX, 0, 1, (lineHeight < BLOCKSIZE) ? BLOCKSIZE : lineHeight);
  Area destArea(x, (this->height - lineHeight) / 2, 1, lineHeight);
  if (this->side) manager.render(DOOR, srcArea, destArea);
  else manager.render(WOODEN_WALL, srcArea, destArea);
}
