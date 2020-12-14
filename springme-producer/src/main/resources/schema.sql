drop table task if exists;

create table task (
    id bigint auto_increment,
    name varchar(255),
    content varchar(5000),
    create_time timestamp,
    update_time timestamp,
    primary key (id)
);