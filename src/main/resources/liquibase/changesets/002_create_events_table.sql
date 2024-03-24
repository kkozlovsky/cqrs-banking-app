create table banking.events
(
    id           bigint generated by default as identity primary key,
    dtype        varchar(255) not null,
    aggregate_id varchar(36),
    type         varchar(255) not null,
    timestamp    timestamp    not null default current_timestamp,
    payload      jsonb
);