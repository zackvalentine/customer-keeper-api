#!/bin/bash

set -e

current_directory="$PWD"

cd $(dirname $0)/../customer-keeper-api-acceptance-tests

./gradlew healthCheck

result=$?

cd "$current_directory"

exit $result