cmake_minimum_required(VERSION 3.4.1)

include(ndk-stl-config.cmake)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14 -Wall -Wextra -Wno-deprecated -Wno-unused-parameter -fexceptions -frtti")


############################################################################
set(DJINNI_MODULE ../modules/djinni_jni)

add_subdirectory(${DJINNI_MODULE} ${PROJECT_BINARY_DIR}/modules/djinni_jni)
############################################################################

get_directory_property(
        DJINNI_INCLUDE_DIRS
        DIRECTORY ${DJINNI_MODULE}
        DEFINITION DJINNI_INCLUDE_DIRS)
        

include_directories(
        ${CMAKE_CURRENT_BINARY_DIR} ${PROJECT_SOURCE_DIR} ${DJINNI_INCLUDE_DIRS})

set(SOURCE_FILES
        main.cpp
        generated/jni/hello_world.cpp
        generated/jni/hello_world_maker.cpp
        generated/jni/logger.cpp 
        ${djinni_jni_SOURCE_DIR}/src/support-lib/jni/djinni_main.cpp)

add_library(hello-jni SHARED ${SOURCE_FILES})

# Include libraries needed for hello-jni lib
target_link_libraries(hello-jni djinni_jni android log)
