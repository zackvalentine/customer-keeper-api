#!/bin/bash

set -e

current_directory="$PWD"

cd $(dirname $0)/..

./gradlew build

result=$?

cd "$current_directory"

exit $result
