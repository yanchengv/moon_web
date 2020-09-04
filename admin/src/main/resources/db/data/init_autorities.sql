
/**
 urls.add("/crms/");
            urls.add("/crms/admins/index");
            urls.add("/crms/admins/new");
            urls.add("/crms/admins/create");
            urls.add("/crms/roles/index");
            urls.add("/crms/roles/new");
            urls.add("/crms/roles/create");
            urls.add("/crms/authorites/index");
 */

-- 主页
insert into authorities (id,name,action,type,updated_at,created_at) values(50001,'主页','/crms/',3,'2020-7-15','2020-7-15');

-- 账户管理
-- insert into authorities (id,name,action,type,updated_at,created_at) values(51000,'账户管理','/crms/',1,'2020-6-23','2020-6-23');
insert into authorities (id,name,action,type,updated_at,created_at) values(51001,'管理员列表','/crms/admins/index',1,'2020-6-23','2020-6-23');
insert into authorities (id,name,action,type,updated_at,created_at) values(51002,'管理员新建页面','/crms/admins/new',1,'2020-6-23','2020-6-23');
insert into authorities (id,name,action,type,updated_at,created_at) values(51003,'管理员创建','/crms/admins/create',1,'2020-6-23','2020-6-23');
insert into authorities (id,name,action,type,updated_at,created_at) values(51004,'角色列表','/crms/roles/index',1,'2020-6-23','2020-6-23');
insert into authorities (id,name,action,type,updated_at,created_at) values(51005,'角色创建','/crms/roles/create',1,'2020-6-23','2020-6-23');
insert into authorities (id,name,action,type,updated_at,created_at) values(51006,'权限列表','/crms/authorites/index',1,'2020-6-23','2020-6-23');

-- 系统管理
insert into authorities (id,name,action,type,updated_at,created_at) values(52000,'系统管理','/crms/roles/index',2,'2020-7-15','2020-7-15');


-- 外卖管理
insert into takeout_restaurants (id,name,action,type,updated_at,created_at) values(53001,'外卖管理','/crms/takeouts/restaurants/index',4,'2020-09-03','2020-09-03');
