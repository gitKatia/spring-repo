Install MySQL database or use an existing MySQL DBMS you have access to
Install MySQL Workbench to connect to the DBMS
Execute the following commands in MySQL Workbench:

create database testdb;
use testdb;
create table SERVER (
		id int not null auto_increment,
        name varchar(255) not null,
        description varchar(255) not null,
        primary key(id)
);

In src/main/resources/application.properties edit jdbc.url, jdbc.username and jdbc.password properties:

jdbc.url=jdbc:mysql://<MySQLHost>:3306/testdb
jdbc.username=<MySQLUsername>
jdbc.password=<MySQLPassword>

cd to the project directory
mvn clean install

This maven  command will execute unit tests and create an executable jar named cmd.jar

Copy the cmd.jar file in a directory of your choice, open a terminal window to this directory and type:

java -jar cmd.jar -command <command> [required parameters]:

java -jar cmd.jar -command help
java -jar cmd.jar -command count
java -jar cmd.jar -command list
java -jar cmd.jar -command add -name <yourServerName> -description <yourServerDescription>
java -jar cmd.jar -command edit -name <yourServerName> -description <yourServerDescription>
java -jar cmd.jar -command delete -name <yourServerName> 
java -jar cmd.jar -command filter -name <yourServerName> 