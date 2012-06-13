#!/bin/bash

dropdb -h localhost -p 5432 -U postgres -w activejdbc-postgresql;
createdb -h localhost -p 5432 -U postgres -w -O postgres activejdbc-postgresql;
psql -h localhost -p 5432 -U postgres -W activejdbc-postgresql < ./create.sql;
