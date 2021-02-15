/************Oracle SQL*****************/

create table em_users(
    user_id number(10) primary key not null,
    first_name varchar2(28) not null,
    last_name varchar2(28) not null,
    email varchar2(30) not null,
    password clob not null
);

create table em_categories(
    category_id number(10) primary key not null,
    user_id number(10) not null,
    title varchar2(20) not null,
    description varchar2(50) not null
);

create table em_transactions(
    transaction_id number(10) primary key not null,
    category_id number(10) not null,
    user_id number(10) not null,
    amount numeric(10,2) not null,
    transaction_date number(19) not null,
    note varchar2(50) not null
);

alter table em_categories add constraint cat_users_fk foreign key (user_id) references em_users(user_id);

alter table em_transactions add constraint trans_cat_fk foreign key (category_id) references em_categories(category_id);

alter table em_transactions add constraint trans_users_fk foreign key (user_id) references em_users(user_id);

create sequence em_users_seq start with 1 increment by 1;
create sequence em_categories_seq  start with 1 increment by 1;
create sequence em_transactions_seq  start with 1000 increment by 1;