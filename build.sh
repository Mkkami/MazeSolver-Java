#!/bin/bash

SRC_DIR=src
OUT_DIR=out
MAIN_CLASS=main.Main

rm -r out

mkdir $OUT_DIR

javac -d $OUT_DIR $(find $SRC_DIR -name "*.java")

java -cp "$OUT_DIR" $MAIN_CLASS maze_files/maze.txt
