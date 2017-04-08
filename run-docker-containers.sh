#!/usr/bin/env sh

set -e

# Export the active docker machine IP, We can use it for internal networking purposes.
export DOCKER_IP=$(docker-machine ip $(docker-machine active))
DOCKER_IP=${DOCKER_IP:-127.0.0.1}


# Build the project and docker images
echo "***********************************  BUILDING CRUCIAL BACKING SERVICES  *****************************************"

# Manual action makes faster the startup
docker-compose up -d boot-mon-server

echo "**************************************  BUILDING BACKING SERVICES  ***********************************************"


echo "****************************************  BUILDING CORE SERVICES  ************************************************"
echo "*********************************************  LOGGING  **********************************************************"

# Run all remaining services
docker-compose up
