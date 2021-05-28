#!/bin/bash

rm -rf build/libs

cd src/main/rust
cargo build --release --target x86_64-pc-windows-gnu || exit 1
cd ../../..

./gradlew build || exit 1

mv src/main/rust/target/x86_64-pc-windows-gnu/release/JvmClassHook.dll ./build/libs/
cp paperclip/patched_1.12.2.jar ./build/libs


