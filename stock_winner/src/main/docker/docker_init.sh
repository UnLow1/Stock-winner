#!/usr/bin/env bash

check=$( sudo docker ps -a -f "name=stockwinner-postgresql" | tail -n +2 )
if [ -z "$check" ]; then
  docker build -t postgres_stockwinner .
  docker run --name stockwinner-postgresql -d -p 5432:5432 postgres_stockwinner
fi

docker start stockwinner-postgresql
