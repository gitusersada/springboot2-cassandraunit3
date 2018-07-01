CREATE KEYSPACE IF NOT EXISTS mykeyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

DROP TABLE IF EXISTS mykeyspace.logs;

CREATE TABLE IF NOT EXISTS mykeyspace.logs (
    id text,
    query text,
    PRIMARY KEY (id)
);


INSERT into mykeyspace.logs(id, query) values ('1','cinema');
INSERT into mykeyspace.logs(id, query) values ('2','serial');
INSERT into mykeyspace.logs(id, query) values ('3','documentary');
INSERT into mykeyspace.logs(id, query) values ('4','series');