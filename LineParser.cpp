#include "LineParser.h"

LineParser::LineParser() {
  this->jumpInstructions = {"jmp", "ja",  "jeq", "jneq", "jne",
                            "jlt", "jle", "jgt", "jge",  "jset"};
}

bool LineParser::hasLabel(std::string& line) {
  return (line.find(":") != std::string::npos);
}

size_t LineParser::getLabel(std::string& line, std::string& label) {
  size_t labelLength = line.find(":");
  label = line.substr(0, labelLength);
  return labelLength;
}

std::string LineParser::getInstruction(std::string& line, size_t labelLength) {
  return Trimmer().trim(line.substr(labelLength + 1, line.size()));
}

bool LineParser::isJumpInstruction(std::string& instruction) {
  std::string command = Trimmer().trim(instruction.substr(0, 4));
  return (this->jumpInstructions.find(command) != this->jumpInstructions.end());
}
