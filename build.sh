#!/bin/bash
ROOT_FOLDER="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
gradle build $ROOT_FOLDER
cd $ROOT_FOLDER &&  docker build -t print-request:latest .