cmake_minimum_required(VERSION 3.4.1)

include(ndk-stl-config.cmake)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14 -Wall -Wextra -Wno-deprecated -Wno-unused-parameter -fexceptions -frtti")

include_directories(
        ${CMAKE_CURRENT_BINARY_DIR} ${PROJECT_SOURCE_DIR} ${JNI_INCLUDE_DIRS} ${PROJECT_SOURCE_DIR}/support-lib/jni ${gie_include_dir} )

set(SOURCE_FILES
        main.cpp
        generated/jni/hello_world.cpp
        generated/jni/hello_world_maker.cpp
        generated/jni/logger.cpp
        support-lib/jni/djinni_main.cpp
        support-lib/jni/djinni_support.cpp)

add_library(hello-jni SHARED ${SOURCE_FILES})

# Include libraries needed for hello-jni lib
target_link_libraries(hello-jni android log)
