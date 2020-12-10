#!/bin/bash

set -e

current_directory="$PWD"

cd $(dirname $0)/../customer-keeper-api

../gradlew healthCheck

result=$?

cd "$current_directory"

exit $result
