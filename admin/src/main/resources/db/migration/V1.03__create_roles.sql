create table roles (
    id BIGSERIAL primary key,
    name varchar,
    brief varchar,
    deleted_at timestamp(6) NULL,
    created_at timestamp(6) NOT NULL,
    updated_at timestamp(6) NOT NULL

);

comment on table roles is '角色表';
comment on column roles.name is '角色名称';
comment on column roles.brief is '角色描述';
comment on column roles.deleted_at is '软删';
comment on column roles.created_at is '创建时间';
comment on column roles.updated_at is '修改时间';

