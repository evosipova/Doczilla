#include <iostream>
#include <filesystem>
#include <vector>
#include <string>
#include "FileOperations.h"
#include "DependencyManager.h"

namespace fs = std::filesystem;

int main() {
    std::string projectRoot = std::string(PROJECT_SOURCE_DIR);
    fs::path rootDirectory = fs::path(projectRoot) / "root";
    std::string outputFileName = (fs::path(projectRoot) / "output.txt").string();

    if (!fs::exists(rootDirectory)) {
        std::cerr << "Error: Root directory '" << rootDirectory << "' not found." << std::endl;
        return 1;
    }

    std::vector<std::string> textFiles = collectAllTextFiles(rootDirectory.string());

    std::cout << "Text files found:\n";
    for (const std::string& filePath : textFiles) {
        std::cout << filePath << std::endl;
    }

    return 0;
}