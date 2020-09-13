
/* ExpenseMint by ChibiBank  */


/************POSTGRESQL*****************/

/*script for creating databases in postgresql
setup postgresql on windows
- download and install a postgreSQL server on postgresql.org
- create a superuser (default user is postgresql) and go through postgresql installation.
- run psql -U postgres --file em_db.sql in the project directory to create database on your machine
*/

drop database expensemintdb;
drop user em_admin;

create user em_admin with password 'password';

create database expensemintdb with template=template0 owner=em_admin;
\connect expensemintdb;

alter default privileges grant all on tables to em_admin;
alter default privileges grant all on sequences to em_admin;

create table em_users (
    user_id integer primary key not null,
    -- username varchar(45) not null,
    first_name varchar(28) not null,
    last_name varchar(28) not null,
    email varchar(30) not null,
    password text not null
    -- phone_number varchar(15),
    -- address varchar(50)
);
/*each user has many accounts to handle and pay expenses*/
/* create table em_account(
    acct_id integer primary key not null,
    acct_type
    acct_balance
) */

create table em_categories(
    category_id integer primary key not null,
    user_id integer not null,
    title varchar(20) not null,
    description varchar(50) not null
);

alter table em_categories add constraint cat_users_fk
foreign key (user_id) references em_users(user_id);

create table em_transactions(
    transaction_id integer primary key not null,
    category_id integer not null,
    user_id integer not null,
    amount numeric(10,2) not null,
    transaction_date bigint not null,
    note varchar(50) not null

);

alter table em_transactions add constraint trans_cat_fk
foreign key (category_id) references em_categories(category_id);
alter table em_transactions add constraint trans_users_fk
foreign key (user_id) references em_users(user_id);

create sequence em_users_seq increment 1 start 1;
create sequence em_categories_seq increment 1 start 1;
create sequence em_transactions_seq increment 1 start 1000;