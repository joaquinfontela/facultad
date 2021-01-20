#include "../../../includes/Control/UpdatableEvent/RocketMissile.h"
#include "../../../includes/Control/Notification/MissileExplotion.h"
#include "../../../includes/Control/Notification/ElementSwitchPosition.h"


RocketMissile::RocketMissile(double x, double y, double dirX, double dirY, int uniqueId) : Updatable(), x(x), y(y), dirX(dirX), dirY(dirY), uniqueId(uniqueId){  }

void RocketMissile::update(float timeElapsed, Game& game){
  double newX = x + dirX * (moveSpeed * (timeElapsed));
  double newY = y + dirY * (moveSpeed * (timeElapsed));
  this->hasToBeNotified = true;


 // Returns True if Rocket collided with another game object.
 // Even if a collision happened, settings these variables helps us know where the impact happened.
  if(!(this->done = game.moveRocketMissileFrom(this->x, this->y, newX, newY))){
    this->x = newX;
    this->y = newY;
  }
}

bool RocketMissile::notify(WaitingQueue<Notification*>& notif){

  if(this->hasToBeNotified){
    ElementSwitchPosition* posUpdate = new ElementSwitchPosition(this->uniqueId, this->x, this->y);
    notif.push(posUpdate);

    if(this->done){
      MissileExplotion* noti = new MissileExplotion(this->uniqueId);
      notif.push(noti);
      return true;
    }
  }


  return false;
}
