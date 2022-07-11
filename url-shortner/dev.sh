#!/bin/sh
mvn clean package
docker compose build --no-cache app
docker compose up