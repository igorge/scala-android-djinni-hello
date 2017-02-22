#!/bin/sh
djinni  --idl src/main/idl/hello_world.djinni   \
        --java-out src/main/java/generated/     \
        --jni-out jni/generated/jni    \
        --cpp-out jni/generated/       \
        --java-package gie                      \
        --cpp-namespace gie \
         --jni-include-prefix "generated/jni/" \
         --jni-include-cpp-prefix "generated/"

