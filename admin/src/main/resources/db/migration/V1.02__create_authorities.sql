create table authorities (
    id BIGSERIAL primary key,
    name varchar,
    action varchar,
    type int4 default 0,
    deleted_at timestamp(6) NULL,
    created_at timestamp(6) NOT NULL,
    updated_at timestamp(6) NOT NULL

);
comment on table authorities is '权限表';
comment on column authorities.name is '权限名称';
comment on column authorities.action is '权限路由，例如admins/index';
comment on column authorities.type is '权限类型，1=账号管理';
comment on column authorities.deleted_at is '软删';
comment on column authorities.created_at is '创建时间';
comment on column authorities.updated_at is '修改时间';
