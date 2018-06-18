#!/usr/bin/env bash

check=$( sudo docker ps -a -f "name=stockwinner-postgresql" | tail -n +2 )
if [ -z "$check" ]; then
  docker build -t agh/postgres_stockwinner .
  docker run --name stockwinner-postgresql -d -p 5432:5432 agh/postgres_stockwinner
fi

docker start stockwinner-postgresql
