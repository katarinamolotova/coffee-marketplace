create type payment_status as enum (
    'NOT_PAID',
    'IN_PROCESS',
    'PAID'
);

create type payment_type as enum (
    'SBP',
    'BANK_CARD',
    'PAYMENT_ON_DELIVERY',
    'SBER_PAY'
);

create table payment (
    id bigint primary key not null,
    status payment_status not null,
    type payment_type not null,
    receipt_id varchar not null
);

create table transport_company (
    id bigint primary key not null,
    short_name varchar,
    full_name varchar not null,
    inn varchar(10) not null, -- только цифры, валидация?
    kpp varchar(9) not null,
    okpo varchar(8) not null,
    ogrn varchar(13) not null,
    address varchar not null
);

create type delivery_status as enum (
    'TRANSFER_TO_TRANSPORT_COMPANY',
    'RECEIVED',
    'NOT_STARTED'
    );

create table delivery (
    id bigint primary key not null,
    transport_company_id bigint not null,
    status delivery_status not null,
    address varchar not null,
    constraint fk_coalition_transport_company_id foreign key (transport_company_id) references transport_company(id)
);

create type order_type as enum ('VIP', 'DEFAULT');

create type order_status as enum (
    'ON_CONFIRMATION',
    'ROASTING',
    'PACKAGING',
    'DELIVERY',
    'RECEIVED',
    'CANCEL'
);

create table "order" (
     id bigint primary key not null,
     type order_type not null,
     status order_status not null,
     user_id varchar not null,
     cost real not null,
     discount real,
     total_cost real not null,
     payment_id bigint unique,
     delivery_id bigint unique,
     create_ts timestamp default now() not null,
     update_ts timestamp default now() not null,
     deleted boolean default false,
     constraint fk_coalition_payment_id foreign key (payment_id) references payment(id),
     constraint fk_coalition_delivery_id foreign key (delivery_id) references delivery(id)
);

create table nomenclature (
    id bigint primary key not null,
    name varchar not null,
    description varchar,
    acidity real not null,
    density real not null,
    price real not null
);

create table status_history (
    id bigint primary key not null,
    order_id bigint not null,
    status order_status not null,
    operation_time timestamp not null default now(),
    constraint fk_coalition_order_id foreign key (order_id) references "order"(id)
);

create type grind_degree_type as enum(
    'BEANS',
    'COARSE',
    'SMALL',
    'MEDIUM'
);

create table order_item (
    id bigint primary key not null,
    order_id bigint not null,
    nomenclature_id bigint not null,
    count integer not null,
    grind_degree_type grind_degree_type not null,
    cost integer not null,
    serial_number bigint not null,
    constraint fk_coalition_nomenclature_id foreign key (nomenclature_id) references nomenclature(id),
    constraint fk_coalition_order_id foreign key (order_id) references "order"(id)
);
