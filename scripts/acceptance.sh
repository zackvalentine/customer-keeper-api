#!/bin/bash

set -e

current_directory="$PWD"

cd ../customer-keeper-api-acceptance-tests

./gradlew clean build

result=$?

cd "$current_directory"

exit $result
