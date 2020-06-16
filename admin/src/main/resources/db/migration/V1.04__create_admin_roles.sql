create table admin_roles(
    id BIGSERIAL primary key,
    admin_id int8,
    role_id int8,
    deleted_at timestamp(6) NULL,
    created_at timestamp(6) NOT NULL,
    updated_at timestamp(6) NOT NULL
);
comment on column admin_roles.role_id is '角色ID';
comment on column admin_roles.admin_id is '管理员ID';
comment on column admin_roles.deleted_at is '软删';
comment on column admin_roles.created_at is '创建时间';
comment on column admin_roles.updated_at is '修改时间';


