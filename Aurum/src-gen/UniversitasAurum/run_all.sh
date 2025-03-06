#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE siakreborn_product_universitasaurum' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'siakreborn_product_universitasaurum') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/siakreborn_product_universitasaurum"
done

java -cp siakreborn.product.universitasaurum --module-path siakreborn.product.universitasaurum -m siakreborn.product.universitasaurum &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait