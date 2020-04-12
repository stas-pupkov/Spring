
drop table if exists hibernate_sequence;
drop table if exists tasks;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table tasks (
                       id integer not null,
                       adding_time date not null,
                       completed_task bit not null,
                       date date not null,
                       order_id integer,
                       primary key (id))
    engine=InnoDB;