create table role_authorities(
    id BIGSERIAL primary key,
    authority_id int8,
    role_id int8,
    deleted_at timestamp(6) NULL,
    created_at timestamp(6) NOT NULL,
    updated_at timestamp(6) NOT NULL
);
comment on table role_authorities is '角色权限关联表';
comment on column role_authorities.authority_id is '权限ID';
comment on column role_authorities.role_id is '角色ID';
comment on column role_authorities.deleted_at is '软删';
comment on column role_authorities.created_at is '创建时间';
comment on column role_authorities.updated_at is '修改时间';

