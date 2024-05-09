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
    DependencyManager dependencyGraph;

    std::cout << "Text files found:\n";
    for (const std::string& filePath : textFiles) {
        std::cout << filePath << std::endl;
    }

    for (const std::string& filePath : textFiles) {
        std::string absoluteFilePath = fs::absolute(filePath).string();
        dependencyGraph.registerFile(absoluteFilePath);

        std::string fileContent = loadFileContent(filePath);
        std::vector<std::string> requiredFiles = parseRequiredFiles(fileContent);
        for (const std::string& requiredFile : requiredFiles) {
            fs::path relativePath(requiredFile);
            fs::path fullPath = fs::absolute(rootDirectory / relativePath);
            std::string absoluteDependencyPath = fullPath.string();
            if (fullPath.extension() != ".txt") {
                absoluteDependencyPath += ".txt";
            }

            dependencyGraph.addDependency(absoluteFilePath, absoluteDependencyPath);
        }
    }

    try {
        std::vector<std::string> sortedFiles = dependencyGraph.getOrderedFiles();
        std::cout << "Sorted file order for concatenation:" << std::endl;
        for (const std::string& file : sortedFiles) {
            std::cout << file << std::endl;
        }

        mergeFiles(sortedFiles, outputFileName);
        std::cout << "Files successfully concatenated into " << outputFileName << std::endl;
    } catch (const std::runtime_error& error) {
        std::cerr << "Error: " << error.what() << std::endl;
    }

    return 0;
}