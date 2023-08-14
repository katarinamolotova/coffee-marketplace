#!/bin/bash

echo "Prepare directoty struct"
if [ -d $(pwd)/dist ]; then
    rm -rf $(pwd)/dist;
    echo "Catalog structure rebuilding"
fi


mkdir $(pwd)/dist;
echo "Created dist directory"
mkdir $(pwd)/dist/database;
echo "Created database directory"
mkdir $(pwd)/dist/pgadmin;
echo "Created pgadmin directory"

docker-compose up
