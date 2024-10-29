#!/usr/bin/bash

set -e
SCRIPT_DIR=$(dirname "$0")
(
  cd "$SCRIPT_DIR"
  mvn -B package -Ddir=/tmp/redisZero
)
exec java -jar /tmp/redisZero/redisZero.jar "$@"
