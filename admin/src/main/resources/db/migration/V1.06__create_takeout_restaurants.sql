create table takeout_restaurants(
    id BIGSERIAL primary key,
    name varchar,
    admin_id int8,
    boss_id int8,
    department_id int8,
    status int4,
    delivery_fastest_time int4,
    delivery_slowest_time int4,
    is_breakfast int4,
    is_lunch int4,
    is_dinner int4,
    breakfast_start_at time(6),
    breakfast_end_at time(6),
    lunch_start_at time(6),
    lunch_end_at time(6),
    dinner_start_at time(6),
    dinner_end_at time(6),
    overall_star int4,
    comment_count int4,
    pay_type varchar,
    big_img varchar,
    tableware_price numeric(10,2),
    package_price numeric(10,2),
    takeout_rule text,
    remark text,
    sort int4,
    like_count int4,
    phone varchar ,
    identifier varchar,
    breakfast_name varchar default '早餐',
    lunch_name varchar,
    dinner_name varchar,
    list_img varchar,
    detail_img varchar,
    sales_num int4,
    online_status int4,
    order_min_price numeric (10,2),
    delivery_type varchar [] default '{1}'::character varying[],
    pick_place varchar,
    pick_time_type int4 default 1,
    project_source varchar default 'aranya_app',
    order_list_img varchar,
    business_times_desc text,
    online_status_content varchar,
    deleted_at timestamp(6) NULL,
    created_at timestamp(6) NOT NULL,
    updated_at timestamp(6) NOT NULL
);
comment on table takeout_restaurants is '外卖餐厅';
comment on column takeout_restaurants.name is '餐厅名称';
comment on column takeout_restaurants.admin_id is '创建者AdminID';
comment on column takeout_restaurants.boss_id is '后台管理员AdminID(餐厅所属商家)';
comment on column takeout_restaurants.department_id is '所属部门';
comment on column takeout_restaurants.status is '状态：0=正常,1=下架';
comment on column takeout_restaurants.delivery_fastest_time is '最快送达时间（例如30分钟）';
comment on column takeout_restaurants.delivery_slowest_time is '最慢送达时间（例如60分钟）';
comment on column takeout_restaurants.is_breakfast is '是否提供早餐 0=提供,1=不提供';
comment on column takeout_restaurants.is_lunch is '是否提供午餐 0=提供,1=不提供';
comment on column takeout_restaurants.is_dinner is '是否提供晚餐 0=提供,1=不提供';
comment on column takeout_restaurants.breakfast_start_at is '早餐营业开始时间';
comment on column takeout_restaurants.breakfast_end_at is '早餐营业结束时间';
comment on column takeout_restaurants.lunch_start_at is '午餐营业开始时间';
comment on column takeout_restaurants.lunch_end_at is '午餐营业结束时间';
comment on column takeout_restaurants.dinner_start_at is '晚餐营业开始时间';
comment on column takeout_restaurants.dinner_end_at is '晚餐营业结束时间';
comment on column takeout_restaurants.overall_star is '综合星级';
comment on column takeout_restaurants.comment_count is '评论总数';
comment on column takeout_restaurants.pay_type is '支付方式 1=支付宝,2=微信,3=业主卡主卡,4=业主卡副卡,5=反租卡主卡,6=反租卡副卡,7=vvip卡，8=员工卡';
comment on column takeout_restaurants.big_img is '餐厅图片';
comment on column takeout_restaurants.tableware_price is '餐具费';
comment on column takeout_restaurants.package_price is '包装盒费用';
comment on column takeout_restaurants.takeout_rule is '送餐规则';
comment on column takeout_restaurants.remark is '备注';
comment on column takeout_restaurants.deleted_at is '软删';
comment on column takeout_restaurants.sort is '排序';
comment on column takeout_restaurants.like_count is '关注数量';
comment on column takeout_restaurants.phone is '外卖餐厅电话';
comment on column takeout_restaurants.identifier is '餐厅编号';
comment on column takeout_restaurants.breakfast_name is '早餐名称';
comment on column takeout_restaurants.lunch_name is '午餐名称';
comment on column takeout_restaurants.dinner_name is '晚餐名称';
comment on column takeout_restaurants.list_img is '列表图';
comment on column takeout_restaurants.detail_img is '详情图';
comment on column takeout_restaurants.sales_num is '餐厅的真实销量总和';
comment on column takeout_restaurants.online_status is '餐点在线接单状态： 1=正常在线接单,2=停止在线接单';
comment on column takeout_restaurants.order_min_price is '起送金额设置,订单满足起送金额才能下单';
comment on column takeout_restaurants.delivery_type is '送餐类型;1=尽快,2=预定时间,3=打包自提';
comment on column takeout_restaurants.pick_place is '餐厅自提地点';
comment on column takeout_restaurants.pick_time_type is '自提时间类型：当delivery_type为打包自提时改值才有效：1为系统默认按营业时间15分钟间隔，2=蛋糕店的自提时间';
comment on column takeout_restaurants.project_source is '餐厅类型.aranya_app=阿那亚app.aranya_minsu=阿那亚民宿小程序';
comment on column takeout_restaurants.order_list_img is '订单列表的正方形图';
comment on column takeout_restaurants.business_times_desc is '营业时间描述';
comment on column takeout_restaurants.online_status_content is '餐点在线接单状态需要显示的文案';
