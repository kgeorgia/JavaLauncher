#!/bin/sh

find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java kgeorgia.school21.Simulation.Simulation scenario.txt