echo SELECT 'CREATE DATABASE siakreborn_product_universitasbandung' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'siakreborn_product_universitasbandung') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/siakreborn_product_universitasbandung"

java -cp siakreborn.product.universitasbandung --module-path siakreborn.product.universitasbandung -m siakreborn.product.universitasbandung