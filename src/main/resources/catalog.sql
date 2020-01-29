
CREATE TABLE K_SITE (
                ID_SITE INTEGER NOT NULL,
                DS_SITE NVARCHAR(100) NOT NULL,
                DS_REST_URL NVARCHAR(255) NOT NULL,
                CONSTRAINT K_SITE_PK PRIMARY KEY (ID_SITE)
);


CREATE TABLE K_REMOTE_SERVICE (
                ID_REMOTE_SERVICE INTEGER NOT NULL,
                ID_SITE INTEGER NOT NULL,
                DS_UUID VARCHAR(36) NOT NULL,
                DS_REQUEST NCLOB,
                DT_REQUEST TIMESTAMP NOT NULL,
                CONSTRAINT K_REMOTE_SERVICE_PK PRIMARY KEY (ID_REMOTE_SERVICE)
);


CREATE UNIQUE INDEX K_REMOTE_SERVICE_DS_UDDI_UQ
 ON K_REMOTE_SERVICE
 ( DS_UUID );

CREATE INDEX K_REMOTE_SERVICE_ID_SITE_IDX
 ON K_REMOTE_SERVICE
 ( ID_SITE );

CREATE TABLE K_LOG (
                ID_LOG INTEGER NOT NULL,
                ID_SITE INTEGER NOT NULL,
                DS_UUID VARCHAR(36) NOT NULL,
                DS_REQUEST NCLOB,
                DS_IP VARCHAR(45) NOT NULL,
                DT_REQUEST TIMESTAMP NOT NULL,
                CONSTRAINT K_LOG_PK PRIMARY KEY (ID_LOG)
);


CREATE INDEX K_LOG_ID_SITE_IDX
 ON K_LOG
 ( ID_SITE );

CREATE UNIQUE INDEX K_LOG_DS_UDDI_UQ
 ON K_LOG
 ( DS_UUID );

ALTER TABLE K_LOG ADD CONSTRAINT K_SITE_K_LOG_fk
FOREIGN KEY (ID_SITE)
REFERENCES K_SITE (ID_SITE)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE K_REMOTE_SERVICE ADD CONSTRAINT K_SITE_K_REMOTE_SERVICE_fk
FOREIGN KEY (ID_SITE)
REFERENCES K_SITE (ID_SITE)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

INSERT INTO K_SITE ( ID_SITE, DS_SITE, DS_REST_URL) VALUES
(1, 'site1', 'localhost:8080/server/process1'),
(2, 'site1', 'localhost:8080/server/process2'),
(3, 'site1', 'localhost:8080/server/process3'),
(4, 'site1', 'localhost:8080/server/process4'),
(5, 'site1', 'localhost:8080/server/process5');