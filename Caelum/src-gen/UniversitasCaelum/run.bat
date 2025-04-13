echo SELECT 'CREATE DATABASE siakreborn_product_universitascaelum' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'siakreborn_product_universitascaelum') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/siakreborn_product_universitascaelum"

java -cp siakreborn.product.universitascaelum --module-path siakreborn.product.universitascaelum -m siakreborn.product.universitascaelum