use simple_journal_entry_db;

create table balls
(
    id     bigint      not null primary key auto_increment,
    name   varchar(50) not null,
    size   int         not null,
    price  int         not null
)