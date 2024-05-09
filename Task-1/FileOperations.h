#pragma once#include <vector>#include <string>std::vector<std::string> collectAllTextFiles(const std::string& rootDirectory);std::string loadFileContent(const std::string& filePath);std::vector<std::string> parseRequiredFiles(const std::string& fileContent);void mergeFiles(const std::vector<std::string>& files, const std::string& outputFileName);