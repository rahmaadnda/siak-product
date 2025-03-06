echo SELECT 'CREATE DATABASE siakreborn_product_universitasaurum' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'siakreborn_product_universitasaurum') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/siakreborn_product_universitasaurum"

java -cp siakreborn.product.universitasaurum --module-path siakreborn.product.universitasaurum -m siakreborn.product.universitasaurum