#!/usr/bin/env sh

set -e

GIT_REV_SHORT=$(git rev-parse --short HEAD)
GIT_REV=$(git rev-parse HEAD)

LAST_UPDATED_SHAS=$(ls ${DIR} | xargs -I{} git rev-list -1 ${GIT_REV} ${DIR}/{})

DIR_HAS_UPDATED=false

for sha in ${LAST_UPDATED_SHAS}; do
  if [ "${sha}" == "${GIT_REV}" ]; then
    DIR_HAS_UPDATED=true
  fi
done

if [ "${DIR_HAS_UPDATED}" = true ]; then
  echo "This directory has been updated in commit ${GIT_REV_SHORT}"
  echo ${GIT_REV_SHORT} > ../docker-env/ref
  exit 0
fi

echo "This directory has not been updated in commit ${GIT_REV_SHORT}"

exit 1