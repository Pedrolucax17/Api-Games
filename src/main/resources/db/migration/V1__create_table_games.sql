CREATE TABLE TBL_GAMES(
    id BIGINT NOT NULL auto_increment,
    title VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,

    PRIMARY KEY(id)
)