#!/bin/bash
ROOT_FOLDER="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd $ROOT_FOLDER && gradle build 
cd $ROOT_FOLDER &&  docker build -t print-request:latest .