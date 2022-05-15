DROP TABLE IF EXISTS `kaustav_db`.`with_json01`;
Create table kaustav_db.with_json01 (id integer, name string, json_test json);
-- insert data into the table
insert into kaustav_db.with_json01 (id, name, json_test)
values (
        1,
        'kaustav',
        PARSE_JSON(
            '{"faq" : {"description":[{"answer":"sample text","question":"sample question","uiorder":0} , {"answer":"sample text","question":"sample question","uiorder":1} , {"answer":"sample text","question":"sample question","uiorder":2}]}}'
        )
    );
insert into kaustav_db.with_json01 (id, name, json_test)
values (
        2,
        'sumant',
        PARSE_JSON(
            '{"faq" : {"description":[{"answer":"sample text","question":"sample question","uiorder":0} , {"answer":"sample text","question":"sample question","uiorder":1} , {"answer":"sample text","question":"sample question","uiorder":2}]}}'
        )
    );
-- Create one without json
DROP TABLE IF EXISTS `kaustav_db`.`wo_json01`;
DROP TABLE IF EXISTS `kaustav_db`.`wo_json01`;
Create table kaustav_db.wo_json01 (id integer, name string);
-- insert data into the table
insert into kaustav_db.wo_json01 (id, name)
values (1, 'kaustav');
insert into kaustav_db.wo_json01 (id, name)
values (2, 'sumant');
insert into kaustav_db.with_json01 (id, name, json_test)
values (