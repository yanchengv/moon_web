create table users (
    id int8 primary key default nextval('users_id_seq'::regclass) not null,
    name varchar,
    password varchar,

)