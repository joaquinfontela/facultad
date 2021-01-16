#include "drawable.h"
#include "clientprotocol.h"
#include <math.h>

bool Drawable::isSprite() {
  return true;
}

bool Drawable::hasThisUniqueId(int otherid) {
  return (this->uniqueid == otherid);
}

void Drawable::loadDistanceWithCoords(int px, int py){
  this->dist = pow(px - this->x, 2) + pow(py - this->y, 2);
}

bool Drawable::operator<(Drawable& other) {
  return this->dist > other.dist;
}

void Drawable::draw(TextureManager& manager, double posX, double posY, double dirX,
                    double dirY, double planeX, double planeY, double* zBuffer) {

  int width, height;
  manager.getWindowSize(&width, &height);

  double spriteX = this->x - posX;
  double spriteY = this->y - posY;

  double invDet = 1.0 / (planeX * dirY - dirX * planeY);

  double transformX = invDet * (dirY * spriteX - dirX * spriteY);
  double transformY = invDet * (-planeY * spriteX + planeX * spriteY);

  int spriteScreenX = int((width >> 1) * (1 + transformX / transformY));

  int spriteHeight = abs(int(height / (transformY)));

  int drawStartY = (height - spriteHeight) >> 1;
  if (drawStartY < 0) drawStartY = 0;
  int drawEndY = (spriteHeight + height) >> 1;
  if (drawEndY >= height) drawEndY = height - 1;

  int spriteWidth = abs(int (height / (transformY)));
  int drawStartX = (spriteScreenX - spriteWidth) >> 1;
  if (drawStartX < 0) drawStartX = 0;
  int drawEndX = spriteWidth / 2 + spriteScreenX;
  if (drawEndX >= width) drawEndX = width - 1;

  for (int stripe = drawStartX; stripe < drawEndX; stripe++){
    int texX = int((((stripe - (spriteScreenX - (spriteWidth >> 1))) << 6) << 8) / spriteWidth) >> 8;

    if (transformY > 0 && stripe > 0 && stripe < width && transformY < zBuffer[stripe]){
      srcArea.update(texX, 0, 1, (spriteHeight < BLOCKSIZE) ? BLOCKSIZE : spriteHeight);
      destArea.update(stripe, (height - spriteHeight) >> 1, 1, spriteHeight);
      manager.render(this->id, srcArea, destArea);
    }
  }
}
