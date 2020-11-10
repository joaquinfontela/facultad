#ifndef RESOURCES_MANAGER_H
#define RESOURCES_MANAGER_H

#include <iostream>
#include <map>
#include <string>

class ResourcesManager {
 private:
  std::map<std::string, std::string> resources;

 public:
  ResourcesManager();
  void addResource(std::string name, std::string body);
  bool hasResource(std::string& resourceName);
  const std::string& getResourceBody(std::string& name);
};

#endif