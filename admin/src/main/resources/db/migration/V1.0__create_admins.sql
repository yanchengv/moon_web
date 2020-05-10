create table admins(
    id BIGSERIAL primary key,
    nickname varchar,
    name varchar,
    password varchar,
    salt varchar,
    phone varchar,
    email varchar,
    avatar varchar,
    role int4 default 0 ,
    status int4 default 0,
    company_id int4,
    department_id int4,
    login_ip varchar,
    deleted_at timestamp(6) NULL,
    created_at timestamp(6) NOT NULL,
    updated_at timestamp(6) NOT NULL
)


