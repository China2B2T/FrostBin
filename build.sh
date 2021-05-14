#!/bin/bash

rm -rf build/libs

cd src/main/rust
cargo build --release --target x86_64-unknown-linux-gnu || exit 1
cargo build --release --target x86_64-pc-windows-gnu || exit 1
cargo build --release --target x86_64-apple-darwin || exit 1
cd ../../..

./gradlew build || exit 1

mv src/main/rust/target/x86_64-unknown-linux-gnu/release/libJvmClassHook.so ./build/libs/
mv src/main/rust/target/x86_64-pc-windows-gnu/release/JvmClassHook.dll ./build/libs/
mv src/main/rust/target/x86_64-apple-darwin/release/libJvmClassHook.dylib ./build/libs/

