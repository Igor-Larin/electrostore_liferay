create index IX_B45278A5 on electronics (electrotype_id);
create index IX_4BD5FD7C on electronics (name[$COLUMN_LENGTH:150$]);

create index IX_937C7D2F on electrotype_employee (electro_id);