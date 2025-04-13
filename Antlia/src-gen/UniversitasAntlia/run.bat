echo SELECT 'CREATE DATABASE siakreborn_product_universitasantlia' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'siakreborn_product_universitasantlia') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/siakreborn_product_universitasantlia"

java -cp siakreborn.product.universitasantlia --module-path siakreborn.product.universitasantlia -m siakreborn.product.universitasantlia