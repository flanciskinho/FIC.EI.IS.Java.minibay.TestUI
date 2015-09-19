-- ----------------------------------------------------------------------------
-- Put here INSERT statements for inserting data required by the application
-- in the "pojo" database.
-------------------------------------------------------------------------------

-- MySQL – Disable Foreign Key Checks or Constraints
SET foreign_key_checks = 0;

SET @today=CURDATE();

-- - - - - - - - - - - - - - - - - - - - - - - - 
-- Volcado de datos para la tabla `Category` - -
-- - - - - - - - - - - - - - - - - - - - - - - -
TRUNCATE TABLE `Category`;
INSERT INTO Category (`categoryId`, `categoryName`) VALUES
(1, 'Electronica'),
(2, 'Informatica'),
(3, 'Deportes'),
(4, 'Juegos'),
(5, 'Viajes'),
(6, 'Ropa');


-- - - - - - - - - - - - - - - - - - - - - - 
-- Volcado de datos para la tabla `Card` - -
-- - - - - - - - - - - - - - - - - - - - - -
TRUNCATE TABLE `Card`;
INSERT INTO `Card` (`numberId`, `expiryDate`) VALUES
(4417123456789113, DATE_ADD(@today,INTERVAL 3 YEAR)),
(3759876543210011, DATE_ADD(@today,INTERVAL 10 MONTH));


-- - - - - - - - - - - - - - - - - - - - - - - - - - 
-- Volcado de datos para la tabla `UserProfile`  - -
-- - - - - - - - - - - - - - - - - - - - - - - - - -
-- Todas las contrasenas son pass
TRUNCATE TABLE `UserProfile`;
INSERT INTO `UserProfile` (`usrId`, `loginName`, `enPassword`, `firstName`, `lastName`, `email`, `card`) VALUES
(1, 'fcedron' , 'NRYlpSlGPSxpg', 'Francisco Abel', 'Cedrón Santaeufemia', 'francisco.cedron@udc.es', 4417123456789113),
(2, 'nlrivas' , 'NRYlpSlGPSxpg', 'Nuria'         , 'López Rivas'        , 'nrlivas@udc.es'         , 3759876543210011),
(3, 'lucas38' , 'NRYlpSlGPSxpg', 'Lucas'         , 'Peréz González'     , 'lucas38@hotmail.com'    , NULL);

-- - - - - - - - - - - - - - - - - - - - - - - - 
-- Volcado de datos para la tabla `Product`  - -
-- - - - - - - - - - - - - - - - - - - - - - - -
TRUNCATE TABLE `Product`;
INSERT INTO `Product` (`productId`, `productName`, `Category`, `owner`, `description`,  `initDate`, `endDate`, `initPrice`, `shipmentDescription`, `winBid`, `currentPrice`, version) VALUES
(1, 'Motor Nema 17', 1, 1, 'Motor Nema 17 4.8kg Nuevo!!!', CURRENT_TIMESTAMP(), TIMESTAMPADD(DAY,38,CURRENT_TIMESTAMP()), 10.05, 'Se envía por correo certificado', NULL, NULL, 1),
(2, 'Mac Book Air', 2, 1, 'Mac Book Air 13". Modelo A1369', CURRENT_TIMESTAMP(), TIMESTAMPADD(DAY,42,CURRENT_TIMESTAMP()), 300.00, 'Se envía por DHL', NULL, NULL, 1),
(3, 'Bicicleta Trek', 3, 2, 'Bicicleta Trek de carbono con Durace', CURRENT_TIMESTAMP(), TIMESTAMPADD(DAY,32,CURRENT_TIMESTAMP()), 400.50, 'Se entrega en mano', 304, 500.5, 1),
(4, 'GTA V', 4, 2, 'GTA V para PC', CURRENT_TIMESTAMP(), TIMESTAMPADD(DAY,42,CURRENT_TIMESTAMP()), 0.01, 'Se envia por correo estandar', NULL, NULL, 1),
(5, 'Troller', 5, 2, 'Maleta Troller de 15L', CURRENT_TIMESTAMP(), TIMESTAMPADD(MONTH,3,CURRENT_TIMESTAMP()), 9.50, 'Se envía por UPS', NULL, NULL, 1),
(6, 'Gafas Maximo Dutti', 6, 1, 'Gafas Maximo Dutti Negras', CURRENT_TIMESTAMP(), TIMESTAMPADD(YEAR,1,CURRENT_TIMESTAMP()), 120.12, 'Se entrega en mano', NULL, NULL, 1),
(7, 'Cinturon hombre', 6, 2, 'Cinturon Kalvin klein', CURRENT_TIMESTAMP(), TIMESTAMPADD(DAY,2,CURRENT_TIMESTAMP()), 1.00, 'Recogida en local', NULL, NULL, 1),
(8, 'Zapatilla Kawasaki', 6, 2, 'Calzado de color rosa. Talla 34.', CURRENT_TIMESTAMP(), TIMESTAMPADD(YEAR,1,CURRENT_TIMESTAMP()), 8.00, 'Envío por correo certificado', NULL, NULL, 1),
(9, 'Cocina a gas', 5, 2, 'Cocina a gas campegio a estrenar', CURRENT_TIMESTAMP(), TIMESTAMPADD(MONTH,1,CURRENT_TIMESTAMP()), 14.90, 'Entrega en local', NULL, NULL, 1),
(10, 'Adaptador de enchufe', 5, 1, 'Adaptador Universal USA-UK', CURRENT_TIMESTAMP(), TIMESTAMPADD(DAY,1,CURRENT_TIMESTAMP()), 1.30, 'Entrega por la compañía Saime', NULL, NULL, 1);

-- MySQL – Enable Foreign Key Checks or Constraints
SET foreign_key_checks = 1;