CREATE DATABASE cars;

create TABLE admin (
  adminId int(11) NOT NULL,
  password varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `admin` (`adminId`, `password`) VALUES
(1, '1');

CREATE TABLE `car_info` (
  `carId` varchar(30) NOT NULL,
  `type` varchar(50) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `introduction` text,
  `manufactureDate` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `customer_card` (
  `customerId` int(11) NOT NULL,
  `name` varchar(16) NOT NULL,
  `password` varchar(15) NOT NULL DEFAULT '2',
  `cardState` varchar(10) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer_info` (
  `customerId` int(11) NOT NULL,
  `name` varchar(16) NOT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birth` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `tel` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from car_info;

CREATE TABLE `rent_list` (
  `carId` varchar(30) NOT NULL,
  `customerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `rent_list`
  ADD PRIMARY KEY (`carId`);
  
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminId`);
  
ALTER TABLE `car_info`
  ADD PRIMARY KEY (`carId`);
  
ALTER TABLE `customer_card`
  ADD PRIMARY KEY (`customerId`);

select * from customer_card;
select * from customer_info;
delete from customer_card where customerId = 2;

DELETE from rent_list WHERE carId = 'a'