#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE siakreborn_product_universitascaelum' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'siakreborn_product_universitascaelum') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/siakreborn_product_universitascaelum"
done

java -cp siakreborn.product.universitascaelum --module-path siakreborn.product.universitascaelum -m siakreborn.product.universitascaelum &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait