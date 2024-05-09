#pragma once#include <string>#include <unordered_map>#include <set>#include <vector>class DependencyManager {private:    std::unordered_map<std::string, std::set<std::string>> dependencyGraph;public:    void registerFile(const std::string& fileName);    void addDependency(const std::string& from, const std::string& to);    std::vector<std::string> getOrderedFiles() const;};