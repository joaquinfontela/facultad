#ifndef RESOURCES_MANAGER_H
#define RESOURCES_MANAGER_H

#include <iostream>
#include <map>
#include <mutex>
#include <string>

class ResourcesManager {
 private:
  std::map<std::string, std::string> resources;
  std::mutex m;

 public:
  ResourcesManager();
  void addResource(std::string name, std::string body);
  bool hasResource(std::string& resourceName);
  const std::string& getResourceBody(const std::string& name);
};

#endif
