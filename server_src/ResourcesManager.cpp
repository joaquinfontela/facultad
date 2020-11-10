#include "ResourcesManager.h"

ResourcesManager::ResourcesManager() {}

void ResourcesManager::addResource(std::string name, std::string body) {
  resources.insert({name, body});
}

bool ResourcesManager::hasResource(const std::string& resourceName) {
  return (resources.find(resourceName) != resources.end());
}

const std::string& ResourcesManager::getResourceBody(const std::string& name) {
  std::unique_lock<std::mutex> lock(m);
  return resources.at(name);
}
