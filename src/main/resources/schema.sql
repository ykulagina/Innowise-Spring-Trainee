-- create table if not exists shawarma_order (
-- id identity,
-- delivery_name varchar(50) not null,
-- delivery_street varchar(50) not null,
-- delivery_city varchar(50) not null,
-- delivery_state varchar(2) not null,
-- delivery_zip_code varchar(10) not null,
-- cc_number varchar(16) not null,
-- cc_expiration varchar(5) not null,
-- cc_cvv varchar(3) not null,
-- placed_at timestamp not null
-- );

-- create table if not exists shawarma (
-- id identity,
-- name varchar(50) not null,
-- shawarma_order bigint not null,
-- shawarma_order_key bigint not null,
-- created_at timestamp not null
-- );

-- create table if not exists ingredient_ref (
-- ingredient varchar(4) not null,
-- shawarma bigint not null,
-- shawarma_key bigint not null
-- );

-- create table if not exists ingredient (
-- id varchar(4) not null,
-- name varchar(25) not null,
-- type varchar(10) not null
-- );

-- alter table shawarma
-- add foreign key (shawarma_order) references shawarma_order(id);

-- alter table ingredient
-- add primary key (id);

-- alter table ingredient_ref add foreign key (ingredient) references ingredient(id);