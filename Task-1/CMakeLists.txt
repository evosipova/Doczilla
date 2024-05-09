cmake_minimum_required(VERSION 3.28)
project(Task_1)

set(CMAKE_CXX_STANDARD 17)

set(SOURCE_FILES
        src/main.cpp
        src/FileOperations.cpp
        src/DependencyManager.cpp
)

add_executable(Task_1 ${SOURCE_FILES})

target_compile_definitions(Task_1 PRIVATE PROJECT_SOURCE_DIR="${CMAKE_SOURCE_DIR}")

target_include_directories(Task_1 PUBLIC "${PROJECT_SOURCE_DIR}")
