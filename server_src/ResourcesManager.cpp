#include "ResourcesManager.h"

ResourcesManager::ResourcesManager() {}

void ResourcesManager::addResource(std::string name, std::string body) {
  resources.insert({name, body});
}

bool ResourcesManager::hasResource(std::string& resourceName) {
  return (resources.find(resourceName) != resources.end());
}

const std::string& ResourcesManager::getResourceBody(std::string& name) {
  return resources.at(name);
}