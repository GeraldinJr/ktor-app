#!/usr/bin/env bash

HOST=$1
DATABASE=$2

docker run --name flyway --rm --net=host \
-v "${PWD}/resources/migrations/conf/":/flyway/conf \
-v "${PWD}/resources/migrations/sql/:"/flyway/sql \
flyway/flyway migrate \
-url="jdbc:postgresql://${HOST}:5432/${DATABASE}"