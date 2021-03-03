#include "ServerAnswerer.h"

ServerAnswerer::ServerAnswerer(const HTTPProtocolParser& http)
    : httpProtocolParser(http) {}

ServerAnswerer::~ServerAnswerer() {}
