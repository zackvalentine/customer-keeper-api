#!/bin/bash

set -e

current_directory="$PWD"

echo "Running acceptance tests"

cd $(dirname $0)/../customer-keeper-api-acceptance-tests

./../gradlew clean build

result=$?

cd "$current_directory"

exit $result
