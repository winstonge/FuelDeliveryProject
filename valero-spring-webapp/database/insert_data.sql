
/*========= DELETE tables ============*/
/* FuelDelivery */
Delete from `valerodb`.`fuel_delivery`
where id>0;

/*Device  */
DELETE FROM `valerodb`.`device`
WHERE id>0;

/* Truck */
DELETE FROM `valerodb`.`truck`
WHERE id>0;

/*Device  */
DELETE FROM `valerodb`.`driver`
WHERE id>0;

/* Department    */
DELETE FROM `valerodb`.`department`
WHERE id=1;

DELETE FROM `valerodb`.`department`
WHERE id=2;

/* Company    */
DELETE FROM `valerodb`.`company`
WHERE id=1;

/* == INSERT data to tables */
INSERT INTO `valerodb`.`company`
(`id`,
`company_name`,
`phone`,
`fax`,
`address`,
`city`,
`country`,
`postal_code`,
`slogan`)
VALUES
(1,
'Citgo Aruba',
'00297-5882001',
'00297-5882044',
'San Nicolas straat 40',
'Oranjestad',
'Aruba',
'None',
'Let us be great');

INSERT INTO `valerodb`.`department`
(`id`,
`department_name`,
`company_id`)
VALUES
(1,
'Distribution',
1);

INSERT INTO `valerodb`.`department`
(`id`,
`department_name`,
`company_id`)
VALUES
(2,
'Airport',
1);

/* == Device  ==*/
INSERT INTO `valerodb`.`device`
(`id`,
`device_no`,
`last_synch`,
`department_id`)
VALUES
(1,
1,
null,
1);

/* == Device  ==*/
INSERT INTO `valerodb`.`device`
(`id`,
`device_no`,
`last_synch`,
`department_id`)
VALUES
(
2,
2,
null,
1);

/* == Device  ==*/
INSERT INTO `valerodb`.`device`
(`id`,
`device_no`,
`last_synch`,
`department_id`)
VALUES
(3,
3,
null,
1);

/* == Device  ==*/
INSERT INTO `valerodb`.`device`
(`id`,
`device_no`,
`last_synch`,
`department_id`)
VALUES
(4,
4,
null,
1);

/* == Device  ==*/
INSERT INTO `valerodb`.`device`
(`id`,
`device_no`,
`last_synch`,
`department_id`)
VALUES
(5,
5,
null,
1);

/* === Truck ===*/
INSERT INTO `valerodb`.`truck`
(`id`,
`truck_code`,
`truck_volume`,
`number_of_meters`,
`department_id`)
VALUES
(1,
1,
5000,
1,
1);


INSERT INTO `valerodb`.`truck`
(`id`,
`truck_code`,
`truck_volume`,
`number_of_meters`,
`department_id`)
VALUES
(2,
2,
6000,
1,
1);

INSERT INTO `valerodb`.`truck`
(`id`,
`truck_code`,
`truck_volume`,
`number_of_meters`,
`department_id`)
VALUES
(3,
3,
8000,
1,
1);

INSERT INTO `valerodb`.`truck`
(`id`,
`truck_code`,
`truck_volume`,
`number_of_meters`,
`department_id`)
VALUES
(4,
4,
9000,
1,
1);


INSERT INTO `valerodb`.`truck`
(`id`,
`truck_code`,
`truck_volume`,
`number_of_meters`,
`department_id`)
VALUES
(5,
5,
5000,
1,
1);



