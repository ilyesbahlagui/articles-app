FROM mysql
ENV MYSQL_DATABASE articles_bdd
ENV MYSQL_ROOT_PASSWORD root
# ENV MYSQL_USER root
COPY init_bdd.sql /docker-entrypoint-initdb.d 
