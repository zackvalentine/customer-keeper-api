#!/bin/bash

set -e

current_directory="$PWD"

cd $(dirname $)/../customer-keeper-api-acceptance-tests

./gradlew healthCheck

result=$?

cd "$current_directory"

exit $result
