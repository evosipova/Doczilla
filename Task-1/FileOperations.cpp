#include <iostream>#include <filesystem>#include <unordered_set>namespace fs = std::filesystem;std::vector<std::string> collectAllTextFiles(const std::string& rootDirectory) {    std::vector<std::string> textFiles;    for (const auto& entry : fs::recursive_directory_iterator(rootDirectory)) {        if (entry.is_regular_file() && entry.path().extension() == ".txt") {            textFiles.push_back(fs::absolute(entry.path()).string());        }    }    return textFiles;}