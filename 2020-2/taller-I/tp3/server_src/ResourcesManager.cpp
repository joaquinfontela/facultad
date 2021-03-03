#include "ResourcesManager.h"

ResourcesManager::ResourcesManager() {}

void ResourcesManager::addResource(std::string name, std::string body) {
  std::unique_lock<std::mutex> lock(m);
  resources.insert({name, body});
}

bool ResourcesManager::hasResource(const std::string& resourceName) {
  std::unique_lock<std::mutex> lock(m);
  return (resources.find(resourceName) != resources.end());
}

const std::string& ResourcesManager::getResourceBody(const std::string& name) {
  std::unique_lock<std::mutex> lock(m);
  return resources.at(name);
}
