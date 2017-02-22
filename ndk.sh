#!/bin/sh

BuildType=Debug

./ndk-cmake ${BuildType} armeabi || exit 1
./ndk-cmake ${BuildType} armeabi-v7a || exit 1
./ndk-cmake ${BuildType} "armeabi-v7a with NEON" || exit 1
./ndk-cmake ${BuildType} arm64-v8a || exit 1
./ndk-cmake ${BuildType} mips || exit 1
./ndk-cmake ${BuildType} mips64 || exit 1
./ndk-cmake ${BuildType} x86 || exit 1
./ndk-cmake ${BuildType} x86_64 || exit 1
    

