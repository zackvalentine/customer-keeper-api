#!/usr/bin/env sh

set -e

GIT_REV_SHORT=$(git rev-parse --short HEAD)

echo "Ignoring whether this directory has been updated in commit ${GIT_REV_SHORT}"
echo ${GIT_REV_SHORT} > ../docker-env/ref
exit 0
