#!/bin/bash

echo "Prepare directoty struct"
if [ -d $(pwd)/../dist ]; then
    rm -rf $(pwd)/../dist;
    echo "Catalog structure rebuilding"
fi


mkdir $(pwd)/../dist;
echo "Created dist directory"
mkdir $(pwd)/../dist/database;
echo "Created database directory"
mkdir $(pwd)/../dist/pgadmin;
echo "Created pgadmin directory"
mkdir $(pwd)/../dist/docker-entrypoint-initdb;
echo "Created docker-entrypoint-initdb directory"

cp $(pwd)/main/resources/database/* $(pwd)/../dist/docker-entrypoint-initdb/

cd ./deploy && docker-compose up
