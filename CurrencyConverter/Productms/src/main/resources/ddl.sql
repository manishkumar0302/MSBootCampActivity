CREATE TABLE `conversion` (
  `id` int(11) NOT NULL,
  `CountryCode` varchar(45) DEFAULT NULL,
  `ConversionFactor` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB
