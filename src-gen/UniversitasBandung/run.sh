#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp siakreborn.product.universitasbandung --module-path siakreborn.product.universitasbandung -m siakreborn.product.universitasbandung 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE siakreborn_product_universitasbandung' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'siakreborn_product_universitasbandung') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/siakreborn_product_universitasbandung"
done

wait