#!/bin/sh

MYSQL_USER="admin"
MYSQL_PASS="admin"

/etc/init.d/mysql restart mysqladmin -u root password root

#Root has no password and allows local connection only
#C01="ALTER USER '$MYSQL_USER'@'localhost' IDENTIFIED BY '$MYSQL_PASS';"
#C01="UPDATE mysql.user SET authentication_STRING = 'root' WHERE user = 'root' AND HOST = 'localhost';"

#-------Create a new user-------#
C1="CREATE USER '$MYSQL_USER'@'localhost' IDENTIFIED BY '$MYSQL_PASS';"
C2="GRANT ALL PRIVILEGES ON *.* TO 'admin'@'localhost' WITH GRANT OPTION;"
C3="FLUSH PRIVILEGES;"

SQL="${C1}${C2}${C3}"
mysql -h localhost "--user=root" "--password=root" -Bse "$SQL"

/etc/init.d/mysql restart

#------Create a database--------------#
C4="CREATE DATABASE IF NOT EXISTS ecommdb;"
C5="USE ecommdb;"

SQL="${C4}${C5}"
mysql -h localhost "--user=$MYSQL_USER" "--password=$MYSQL_PASS" -Bse "$SQL"

