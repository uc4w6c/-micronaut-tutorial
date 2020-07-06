---- drop ----
DROP TABLE IF EXISTS `users`;

---- create ----
create table users
(
 user_id          VARCHAR(20) NOT NULL,
 password         VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id)
) DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
