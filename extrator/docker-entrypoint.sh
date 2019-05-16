#!/bin/sh
set -e

echo "The entrypoint has been executed"

psql -v --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE SCHEMA db_esocial;
EOSQL