package com.mitocode.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mitocode.model.Modulo;


public interface UtilitarioRepo extends JpaRepository<Modulo, Integer>{

	@Query(value="insert into estado_civil (id_estado_civil,descripcion) values (1, 'SOLTERO'),"
			+ "(2, 'CASADO'),"
			+ "(3, 'VIUDO'),"
			+ "(4, 'DIVORCIADO')", nativeQuery = true)
	void  insertarEstadoCivil();

	@Query(value="insert into situacion (id_situacion,descripcion) values (1, 'ACTIVO O SUBSIDIADO')", nativeQuery = true)
	void  insertarSituacion();
	
	@Query(value="insert into perfiles_pagina (id_perfil, id_pagina) VALUES (1, 1),(1, 2),(1, 3),(1, 4),(1, 5),(1, 6),(1, 7),(1, 8),(1, 9),(1, 10),"
			+ "(1, 11),(1, 12),(1, 13),(1, 14),(1, 15),(1, 16),(1, 17),(1, 18),(1, 19),(1, 20);", nativeQuery = true)
	void insertarPerfilesPagina();
	
	
	@Query(value="insert into tipo_doc(id_tipo_doc, descripcion) VALUES ( 1, 'DNI'),( 2, 'RUC'),( 3, 'PASAPORTE'),( 4, 'CARNET EXTRANJERIA');", nativeQuery = true)
	void insertarTipoDoc();
	
	
	@Query(value="insert into tipo_pago(id_tipo_pago, descripcion) VALUES (1, 'DEPOSITO CUENTA'),(2, 'EFECTIVO'),(3, 'OTRO');", nativeQuery = true)
	void insertarTipoPago();
	
	@Query(value="insert into tipo_empresa(id_tipo_emp, descripcion) VALUES (1, 'MICROEMPRESA'),"
			+ "(2, 'PEQUEÑA EMPRESA'),"
			+ "(3, 'MEDIANA EMPRESA'),"
			+ "(4,'GRAN EMPRESA');", nativeQuery = true)
	void insertarTipoEmpresa();
	
	@Query(value="insert into reg_tributario(id_reg_trib, descripcion) VALUES (1, 'NRUS - Nuevo Régimen Único Simplificado'),"
			+ "(2,'RER - Régimen Especial de Impuesto a la Renta'),"
			+ "(3,'RMT - Régimen MYPE Tributario'),"
			+ "(4,'RG - Régimen General');", nativeQuery = true)
	void insertarRegimenTributario();
	
	
	@Query(value="insert into tipo_zona(id_tipo_zona, descripcion) VALUES (1, 'A.H. ASENTAMIENTO HUMANO'),"
			+ "(2, 'C.H. CONJUNTO HABITACIONAL'),"
			+ "(3, 'CAS. CASERÍO'),"
			+ "(4, 'COO. COOPERATIVA'),"
			+ "(5, 'FND. FUNDO'),"
			+ "(6, 'GRU. GRUPO'),"
			+ "(7, 'P.J. PUEBLO JOVEN'),"
			+ "(8, 'RES. RESIDENCIAL'),"
			+ "(9, 'U.V. UNIDAD VECINAL'),"
			+ "(10, 'URB. URBANIZACIÓN'),"
			+ "(11, 'Z.I. ZONA INDUSTRIAL'),"
			+ "(12, 'OTROS');", nativeQuery = true)
	void insertarTipoZona();
	
	
	@Query(value="insert into banco(id_banco, descripcion) VALUES (1, 'BANCO DE COMERCIO'),"
			+ "(2, 'BANCO DE CREDITO DEL PERU'),"
			+ "(3, 'BANCO PICHINCHA'),"
			+ "(4, 'BBVA CONTINENTAL'),"
			+ "(5, 'CITIBANK'),"
			+ "(6, 'INTERBANK'),"
			+ "(7, 'MIBANCO');", nativeQuery = true)
	void insertarBanco();
	
	
	@Query(value="insert into departamento(id_departamento, descripcion) VALUES (1, 'AMAZONAS'),"
			+ "(2, 'ANCASH'),"
			+ "(3, 'APURIMAC'),"
			+ "(4, 'AREQUIPA'),"
			+ "(5, 'AYACUCHO'),"
			+ "(6, 'CAJAMARCA'),"
			+ "(7, 'CUSCO'),"
			+ "(8, 'HUANCAVELICA'),"
			+ "(9, 'HUANUCO'),"
			+ "(10, 'ICA'),"
			+ "(11, 'JUNIN'),"
			+ "(12, 'LA LIBERTAD'),"
			+ "(13, 'LAMBAYEQUE'),"
			+ "(14, 'LIMA'),"
			+ "(15, 'LORETO'),"
			+ "(16, 'MADRE DE DIOS'),"
			+ "(17, 'MOQUEGUA'),"
			+ "(18, 'PASCO'),"
			+ "(19, 'PIURA'),"
			+ "(20, 'PUNO'),"
			+ "(21, 'SAN MARTIN'),"
			+ "(22, 'TACNA'),"
			+ "(23, 'TUMBES'),"
			+ "(24, 'UCAYALI'),"
			+ "(25, 'PROV. CONST. DEL CALLAO');", nativeQuery = true)
	void insertarDepartamento();
	
	
	@Query(value="insert into provincia(id_provincia, descripcion, id_departamento) VALUES (1, 'BAGUA', 1),"
			+ "(2, 'BONGARA', 1),"
			+ "(3, 'CHACHAPOYAS', 1),"
			+ "(4, 'CONDORCANQUI', 1),"
			+ "(5, 'LUYA', 1),"
			+ "(6, 'RODRIGUEZ DE MENDOZA', 1),"
			+ "(7, 'UTCUBAMBA', 1),"
			+ "(8, 'AIJA', 2),"
			+ "(9, 'ANTONIO RAIMONDI', 2),"
			+ "(10, 'ASUNCION', 2),"
			+ "(11, 'BOLOGNESI', 2),"
			+ "(12, 'CARHUAZ', 2),"
			+ "(13, 'CARLOS FERMIN FITZCARRALD', 2),"
			+ "(14, 'CASMA', 2),"
			+ "(15, 'CORONGO', 2),"
			+ "(16, 'HUARAZ', 2),"
			+ "(17, 'HUARI', 2),"
			+ "(18, 'HUARMEY', 2),"
			+ "(19, 'HUAYLAS', 2),"
			+ "(20, 'MARISCAL LUZURIAGA', 2),"
			+ "(21, 'OCROS', 2),"
			+ "(22, 'PALLASCA', 2),"
			+ "(23, 'POMABAMBA', 2),"
			+ "(24, 'RECUAY', 2),"
			+ "(25, 'SANTA', 2),"
			+ "	(26, 'SIHUAS', 2),"
			+ "(27, 'YUNGAY', 2),"
			+ "(28, 'ABANCAY', 3),"
			+ "(29, 'ANDAHUAYLAS', 3),"
			+ "(30, 'ANTABAMBA', 3),"
			+ "(31, 'AYMARAES', 3),"
			+ "(32, 'CHINCHEROS', 3),"
			+ "(33, 'COTABAMBAS', 3),"
			+ "(34, 'GRAU', 3),"
			+ "(35, 'AREQUIPA', 4),"
			+ "(36, 'CAMANA', 4),"
			+ "(37, 'CARAVELI', 4),"
			+ "(38, 'CASTILLA', 4),"
			+ "(39, 'CAYLLOMA', 4),"
			+ "(40, 'CONDESUYOS', 4),"
			+ "(41, 'ISLAY', 4),"
			+ "(42, 'LA UNION', 4),"
			+ "(43, 'CANGALLO', 5),"
			+ "(44, 'HUAMANGA', 5),"
			+ "(45, 'HUANCA SANCOS', 5),"
			+ "(46, 'HUANTA', 5),"
			+ "(47, 'LA MAR', 5),"
			+ "(48, 'LUCANAS', 5),"
			+ "(49, 'PARINACOCHAS', 5),"
			+ "(50, 'PAUCAR DEL SARA SARA', 5),"
			+ "(51, 'SUCRE', 5),"
			+ "(52, 'VICTOR FAJARDO', 5),"
			+ "(53, 'VILCAS HUAMAN', 5),"
			+ "(54, 'CAJABAMBA', 6),"
			+ "(55, 'CAJAMARCA', 6),"
			+ "(56, 'CELENDIN', 6),"
			+ "(57, 'CHOTA', 6),"
			+ "(58, 'CONTUMAZA', 6),"
			+ "(59, 'CUTERVO', 6),"
			+ "(60, 'HUALGAYOC', 6),"
			+ "(61, 'JAEN', 6),"
			+ "(62, 'SAN IGNACIO', 6),"
			+ "(63, 'SAN MARCOS', 6),"
			+ "(64, 'SAN MIGUEL', 6),"
			+ "(65, 'SAN PABLO', 6),"
			+ "(66, 'SANTA CRUZ', 6),"
			+ "(67, 'ACOMAYO', 7),"
			+ "(68, 'ANTA', 7),"
			+ "(69, 'CALCA', 7),"
			+ "(70, 'CANAS', 7),"
			+ "(71, 'CANCHIS', 7),"
			+ "(72, 'CHUMBIVILCAS', 7),"
			+ "(73, 'CUSCO', 7),"
			+ "(74, 'ESPINAR', 7),"
			+ "(75, 'LA CONVENCION', 7),"
			+ "(76, 'PARURO', 7),"
			+ "(77, 'PAUCARTAMBO', 7),"
			+ "(78, 'QUISPICANCHIS', 7),"
			+ "(79, 'URUBAMBA', 7),"
			+ "(80, 'ACOBAMBA', 8),"
			+ "(81, 'ANGARAES', 8),"
			+ "(82, 'CASTROVIRREYNA', 8),"
			+ "(83, 'CHURCAMPA', 8),"
			+ "(84, 'HUANCAVELICA', 8),"
			+ "(85, 'HUAYTARA', 8),"
			+ "(86, 'TAYACAJA', 8),"
			+ "(87, 'AMBO', 9),"
			+ "(88, 'DOS DE MAYO', 9),"
			+ "(89, 'HUACAYBAMBA', 9),"
			+ "(90, 'HUAMALIES', 9),"
			+ "(91, 'HUANUCO', 9),"
			+ "(92, 'LAURICOCHA', 9),"
			+ "(93, 'LEONCIO PRADO', 9),"
			+ "(94, 'MARANON', 9),"
			+ "(95, 'PACHITEA', 9),"
			+ "(96, 'PUERTO INCA', 9),"
			+ "(97, 'YAROWILCA', 9),"
			+ "(98, 'CHINCHA', 10),"
			+ "(99, 'ICA', 10),"
			+ "(100, 'NAZCA', 10),"
			+ "(101, 'PALPA', 10),"
			+ "(102, 'PISCO', 10),"
			+ "(103, 'CHANCHAMAYO', 11),"
			+ "(104, 'CHUPACA', 11),"
			+ "(105, 'CONCEPCION', 11),"
			+ "(106, 'HUANCAYO', 11),"
			+ "(107, 'JAUJA', 11),"
			+ "(108, 'JUNIN', 11),"
			+ "(109, 'SATIPO', 11),"
			+ "(110, 'TARMA', 11),"
			+ "(111, 'YAULI', 11),"
			+ "(112, 'ASCOPE', 12),"
			+ "(113, 'BOLIVAR', 12),"
			+ "(114, 'CHEPEN', 12),"
			+ "(115, 'GRAN CHIMU', 12),"
			+ "(116, 'JULCAN', 12),"
			+ "(117, 'OTUZCO', 12),"
			+ "(118, 'PACASMAYO', 12),"
			+ "(119, 'PATAZ', 12),"
			+ "(120, 'SANCHEZ CARRION', 12),"
			+ "(121, 'SANTIAGO DE CHUCO', 12),"
			+ "(122, 'TRUJILLO', 12),"
			+ "(123, 'VIRU', 12),"
			+ "(124, 'CHICLAYO', 13),"
			+ "(125, 'FERRENAFE', 13),"
			+ "(126, 'LAMBAYEQUE', 13),"
			+ "(127, 'BARRANCA', 14),"
			+ "(128, 'CAJATAMBO', 14),"
			+ "(129, 'CANETE', 14),"
			+ "(130, 'CANTA', 14),"
			+ "(131, 'HUARAL', 14),"
			+ "(132, 'HUAROCHIRI', 14),"
			+ "(133, 'HUAURA', 14),"
			+ "(134, 'LIMA', 14),"
			+ "(135, 'OYON', 14),"
			+ "(136, 'YAUYOS', 14),"
			+ "(137, 'ALTO AMAZONAS', 15),"
			+ "(138, 'DATEM DEL MARAÑON', 15),"
			+ "(139, 'LORETO', 15),"
			+ "(140, 'MARISCAL RAMON CASTILLA', 15),"
			+ "(141, 'MAYNAS', 15),"
			+ "(142, 'REQUENA', 15),"
			+ "(143, 'UCAYALI', 15),"
			+ "(144, 'MANU', 16),"
			+ "(145, 'TAHUAMANU', 16),"
			+ "(146, 'TAMBOPATA', 16),"
			+ "(147, 'GENERAL SANCHEZ CERRO', 17),"
			+ "(148, 'ILO', 17),"
			+ "(149, 'MARISCAL NIETO', 17),"
			+ "(150, 'DANIEL ALCIDES CARRION', 18),"
			+ "(151, 'OXAPAMPA', 18),"
			+ "(152, 'PASCO', 18),"
			+ "(153, 'AYABACA', 19),"
			+ "(154, 'HUANCABAMBA', 19),"
			+ "(155, 'MORROPON', 19),"
			+ "(156, 'PAITA', 19),"
			+ "(157, 'PIURA', 19),"
			+ "(158, 'SECHURA', 19),"
			+ "(159, 'SULLANA', 19),"
			+ "(160, 'TALARA', 19),"
			+ "(161, 'AZANGARO', 20),"
			+ "(162, 'CARABAYA', 20),"
			+ "(163, 'CHUCUITO', 20),"
			+ "(164, 'EL COLLAO', 20),"
			+ "(165, 'HUANCANE', 20),"
			+ "(166, 'LAMPA', 20),"
			+ "(167, 'MELGAR', 20),"
			+ "(168, 'MOHO', 20),"
			+ "(169, 'PUNO', 20),"
			+ "(170, 'SAN ANTONIO DE PUTINA', 20),"
			+ "(171, 'SAN ROMAN', 20),"
			+ "(172, 'SANDIA', 20),"
			+ "(173, 'YUNGUYO', 20),"
			+ "(174, 'BELLAVISTA', 21),"
			+ "(175, 'EL DORADO', 21),"
			+ "(176, 'HUALLAGA', 21),"
			+ "(177, 'LAMAS', 21),"
			+ "(178, 'MARISCAL CACERES', 21),"
			+ "(179, 'MOYOBAMBA', 21),"
			+ "(180, 'PICOTA', 21),"
			+ "(181, 'RIOJA', 21),"
			+ "(182, 'SAN MARTIN', 21),"
			+ "(183, 'TOCACHE', 21),"
			+ "(184, 'CANDARAVE', 22),"
			+ "(185, 'JORGE BASADRE', 22),"
			+ "(186, 'TACNA', 22),"
			+ "(187, 'TARATA', 22),"
			+ "(188, 'CONTRALMIRANTE VILLAR', 23),"
			+ "(189, 'TUMBES', 23),"
			+ "(190, 'ZARUMILLA', 23),"
			+ "(191, 'ATALAYA', 24),"
			+ "(192, 'CORONEL PORTILLO', 24),"
			+ "(193, 'PADRE ABAD', 24),"
			+ "(194, 'PURUS', 24),"
			+ "(195, 'CALLAO', 25);", nativeQuery = true)
	void insertarProvincia();
	
	
	@Query(value="insert into distrito(id_distrito, descripcion, id_provincia) VALUES (1,'ARAMANGO',1),"
			+"(2,'BAGUA',1),\r\n" + 
			"(3,'COPALLIN',1),\r\n" + 
			"(4,'EL PARCO',1),\r\n" + 
			"(5,'IMAZA',1),\r\n" + 
			"(6,'LA PECA',1),\r\n" + 
			"(7,'CHISQUILLA',2),\r\n" + 
			"(8,'CHURUJA',2),\r\n" + 
			"(9,'COROSHA',2),\r\n" + 
			"(10,'CUISPES',2),\r\n" + 
			"(11,'FLORIDA',2),\r\n" + 
			"(12,'JAZAN',2),\r\n" + 
			"(13,'JUMBILLA',2),\r\n" + 
			"(14,'RECTA',2),\r\n" + 
			"(15,'SAN CARLOS',2),\r\n" + 
			"(16,'SHIPASBAMBA',2),\r\n" + 
			"(17,'VALERA',2),\r\n" + 
			"(18,'YAMBRASBAMBA',2),\r\n" + 
			"(19,'ASUNCION',3),\r\n" + 
			"(20,'BALSAS',3),\r\n" + 
			"(21,'CHACHAPOYAS',3),\r\n" + 
			"(22,'CHETO',3),\r\n" + 
			"(23,'CHILIQUIN',3),\r\n" + 
			"(24,'CHUQUIBAMBA',3),\r\n" + 
			"(25,'GRANADA',3),\r\n" + 
			"(26,'HUANCAS',3),\r\n" + 
			"(27,'LA JALCA',3),\r\n" + 
			"(28,'LEIMEBAMBA',3),\r\n" + 
			"(29,'LEVANTO',3),\r\n" + 
			"(30,'MAGDALENA',3),\r\n" + 
			"(31,'MARISCAL CASTILLA',3),\r\n" + 
			"(32,'MOLINOPAMPA',3),\r\n" + 
			"(33,'MONTEVIDEO',3),\r\n" + 
			"(34,'OLLEROS',3),\r\n" + 
			"(35,'QUINJALCA',3),\r\n" + 
			"(36,'SAN FCO DE DAGUAS',3),\r\n" + 
			"(37,'SAN ISIDRO DE MAINO',3),\r\n" + 
			"(38,'SAN ISIDRO DE MAINO',3),\r\n" + 
			"(39,'SOLOCO',3),\r\n" + 
			"(40,'SONCHE',3),\r\n" + 
			"(41,'EL CENEPA',4),\r\n" + 
			"(42,'NIEVA',4),\r\n" + 
			"(43,'RIO SANTIAGO',4),\r\n" + 
			"(44,'CAMPORREDONDO',5),\r\n" + 
			"(45,'COCABAMBA',5),\r\n" + 
			"(46,'COLCAMAR',5),\r\n" + 
			"(47,'CONILA',5),\r\n" + 
			"(48,'INGUILPATA',5),\r\n" + 
			"(49,'LAMUD',5),\r\n" + 
			"(50,'LONGUITA',5),\r\n" + 
			"(51,'LONYA CHICO',5),\r\n" + 
			"(52,'LUYA',5),\r\n" + 
			"(53,'LUYA VIEJO',5),\r\n" + 
			"(54,'MARIA',5),\r\n" + 
			"(55,'OCALLI',5),\r\n" + 
			"(56,'OCUMAL',5),\r\n" + 
			"(57,'PISUQUIA',5),\r\n" + 
			"(58,'PROVIDENCIA',5),\r\n" + 
			"(59,'SAN CRISTOBAL',5),\r\n" + 
			"(60,'SAN FRANCISCO DE YESO',5),\r\n" + 
			"(61,'SAN JERONIMO',5),\r\n" + 
			"(62,'SAN JUAN DE LOPECANCHA',5),\r\n" + 
			"(63,'SANTA CATALINA',5),\r\n" + 
			"(64,'SANTO TOMAS',5),\r\n" + 
			"(65,'TINGO',5),\r\n" + 
			"(66,'TRITA',5),\r\n" + 
			"(67,'CHIRIMOTO',6),\r\n" + 
			"(68,'COCHAMAL',6),\r\n" + 
			"(69,'HUAMBO',6),\r\n" + 
			"(70,'LIMABAMBA',6),\r\n" + 
			"(71,'LONGAR',6),\r\n" + 
			"(72,'MCAL BENAVIDES',6),\r\n" + 
			"(73,'MILPUC',6),\r\n" + 
			"(74,'OMIA',6),\r\n" + 
			"(75,'SAN NICOLAS',6),\r\n" + 
			"(76,'SANTA ROSA',6),\r\n" + 
			"(77,'TOTORA',6),\r\n" + 
			"(78,'VISTA ALEGRE',6),\r\n" + 
			"(79,'BAGUA GRANDE',7),\r\n" + 
			"(80,'CAJARURO',7),\r\n" + 
			"(81,'CUMBA',7),\r\n" + 
			"(82,'EL MILAGRO',7),\r\n" + 
			"(83,'JAMALCA',7),\r\n" + 
			"(84,'LONYA GRANDE',7),\r\n" + 
			"(85,'YAMON',7),\r\n" + 
			"(86,'AIJA',8),\r\n" + 
			"(87,'CORIS',8),\r\n" + 
			"(88,'HUACLLAN',8),\r\n" + 
			"(89,'LA MERCED',8),\r\n" + 
			"(90,'SUCCHA',8),\r\n" + 
			"(91,'ACZO',9),\r\n" + 
			"(92,'CHACCHO',9),\r\n" + 
			"(93,'CHINGAS',9),\r\n" + 
			"(94,'LLAMELLIN',9),\r\n" + 
			"(95,'MIRGAS',9),\r\n" + 
			"(96,'SAN JUAN DE RONTOY',9),\r\n" + 
			"(97,'ACOCHACA',10),\r\n" + 
			"(98,'CHACAS',10),\r\n" + 
			"(99,'A PARDO LEZAMETA',11),\r\n" + 
			"(100,'ANTONIO RAIMONDI',11),\r\n" + 
			"(101,'AQUIA',11),\r\n" + 
			"(102,'CAJACAY',11),\r\n" + 
			"(103,'CANIS',11),\r\n" + 
			"(104,'CHIQUIAN',11),\r\n" + 
			"(105,'COLQUIOC',11),\r\n" + 
			"(106,'HUALLANCA',11),\r\n" + 
			"(107,'HUASTA',11),\r\n" + 
			"(108,'HUAYLLACAYAN',11),\r\n" + 
			"(109,'LA PRIMAVERA',11),\r\n" + 
			"(110,'MANGAS',11),\r\n" + 
			"(111,'PACLLON',11),\r\n" + 
			"(112,'SAN MIGUEL DE CORPANQUI',11),\r\n" + 
			"(113,'TICLLOS',11),\r\n" + 
			"(114,'ACOPAMPA',12),\r\n" + 
			"(115,'AMASHCA',12),\r\n" + 
			"(116,'ANTA',12),\r\n" + 
			"(117,'ATAQUERO',12),\r\n" + 
			"(118,'CARHUAZ',12),\r\n" + 
			"(119,'MARCARA',12),\r\n" + 
			"(120,'PARIAHUANCA',12),\r\n" + 
			"(121,'SAN MIGUEL DE ACO',12),\r\n" + 
			"(122,'SHILLA',12),\r\n" + 
			"(123,'TINCO',12),\r\n" + 
			"(124,'YUNGAR',12),\r\n" + 
			"(125,'SAN LUIS',13),\r\n" + 
			"(126,'SAN NICOLAS',13),\r\n" + 
			"(127,'YAUYA',13),\r\n" + 
			"(128,'BUENA VISTA ALTA',14),\r\n" + 
			"(129,'CASMA',14),\r\n" + 
			"(130,'COMANDANTE NOEL',14),\r\n" + 
			"(131,'YAUTAN',14),\r\n" + 
			"(132,'ACO',15),\r\n" + 
			"(133,'BAMBAS',15),\r\n" + 
			"(134,'CORONGO',15),\r\n" + 
			"(135,'CUSCA',15),\r\n" + 
			"(136,'LA PAMPA',15),\r\n" + 
			"(137,'YANAC',15),\r\n" + 
			"(138,'YUPAN',15),\r\n" + 
			"(139,'COCHABAMBA',16),\r\n" + 
			"(140,'COLCABAMBA',16),\r\n" + 
			"(141,'HUANCHAY',16),\r\n" + 
			"(142,'HUARAZ',16),\r\n" + 
			"(143,'INDEPENDENCIA',16),\r\n" + 
			"(144,'JANGAS',16),\r\n" + 
			"(145,'LA LIBERTAD',16),\r\n" + 
			"(146,'OLLEROS',16),\r\n" + 
			"(147,'PAMPAS',16),\r\n" + 
			"(148,'PARIACOTO',16),\r\n" + 
			"(149,'PIRA',16),\r\n" + 
			"(150,'TARICA',16),\r\n" + 
			"(151,'ANRA',17),\r\n" + 
			"(152,'CAJAY',17),\r\n" + 
			"(153,'CHAVIN DE HUANTAR',17),\r\n" + 
			"(154,'HUACACHI',17),\r\n" + 
			"(155,'HUACCHIS',17),\r\n" + 
			"(156,'HUACHIS',17),\r\n" + 
			"(157,'HUANTAR',17),\r\n" + 
			"(158,'HUARI',17),\r\n" + 
			"(159,'MASIN',17),\r\n" + 
			"(160,'PAUCAS',17),\r\n" + 
			"(161,'PONTO',17),\r\n" + 
			"(162,'RAHUAPAMPA',17),\r\n" + 
			"(163,'RAPAYAN',17),\r\n" + 
			"(164,'SAN MARCOS',17),\r\n" + 
			"(165,'SAN PEDRO DE CHANA',17),\r\n" + 
			"(166,'UCO',17),\r\n" + 
			"(167,'COCHAPETI',18),\r\n" + 
			"(168,'CULEBRAS',18),\r\n" + 
			"(169,'HUARMEY',18),\r\n" + 
			"(170,'HUAYAN',18),\r\n" + 
			"(171,'MALVAS',18),\r\n" + 
			"(172,'CARAZ',19),\r\n" + 
			"(173,'HUALLANCA',19),\r\n" + 
			"(174,'HUATA',19),\r\n" + 
			"(175,'HUAYLAS',19),\r\n" + 
			"(176,'MATO',19),\r\n" + 
			"(177,'PAMPAROMAS',19),\r\n" + 
			"(178,'PUEBLO LIBRE',19),\r\n" + 
			"(179,'SANTA CRUZ',19),\r\n" + 
			"(180,'SANTO TORIBIO',19),\r\n" + 
			"(181,'YURACMARCA',19),\r\n" + 
			"(182,'CASCA',20),\r\n" + 
			"(183,'ELEAZAR GUZMAN BARRON',20),\r\n" + 
			"(184,'FIDEL OLIVAS ESCUDERO',20),\r\n" + 
			"(185,'LLAMA',20),\r\n" + 
			"(186,'LLUMPA',20),\r\n" + 
			"(187,'LUCMA',20),\r\n" + 
			"(188,'MUSGA',20),\r\n" + 
			"(189,'PISCOBAMBA',20),\r\n" + 
			"(190,'ACAS',21),\r\n" + 
			"(191,'CAJAMARQUILLA',21),\r\n" + 
			"(192,'CARHUAPAMPA',21),\r\n" + 
			"(193,'COCHAS',21),\r\n" + 
			"(194,'CONGAS',21),\r\n" + 
			"(195,'LLIPA',21),\r\n" + 
			"(196,'OCROS',21),\r\n" + 
			"(197,'SAN CRISTOBAL DE RAJAN',21),\r\n" + 
			"(198,'SAN PEDRO',21),\r\n" + 
			"(199,'SANTIAGO DE CHILCAS',21),\r\n" + 
			"(200,'BOLOGNESI',22),\r\n" + 
			"(201,'CABANA',22),\r\n" + 
			"(202,'CONCHUCOS',22),\r\n" + 
			"(203,'HUACASCHUQUE',22),\r\n" + 
			"(204,'HUANDOVAL',22),\r\n" + 
			"(205,'LACABAMBA',22),\r\n" + 
			"(206,'LLAPO',22),\r\n" + 
			"(207,'PALLASCA',22),\r\n" + 
			"(208,'PAMPAS',22),\r\n" + 
			"(209,'SANTA ROSA',22),\r\n" + 
			"(210,'TAUCA',22),\r\n" + 
			"(211,'HUAYLLAN',23),\r\n" + 
			"(212,'PAROBAMBA',23),\r\n" + 
			"(213,'POMABAMBA',23),\r\n" + 
			"(214,'QUINUABAMBA',23),\r\n" + 
			"(215,'CATAC',24),\r\n" + 
			"(216,'COTAPARACO',24),\r\n" + 
			"(217,'HUAYLLAPAMPA',24),\r\n" + 
			"(218,'LLACLLIN',24),\r\n" + 
			"(219,'MARCA',24),\r\n" + 
			"(220,'PAMPAS CHICO',24),\r\n" + 
			"(221,'PARARIN',24),\r\n" + 
			"(222,'RECUAY',24),\r\n" + 
			"(223,'TAPACOCHA',24),\r\n" + 
			"(224,'TICAPAMPA',24),\r\n" + 
			"(225,'CACERES DEL PERU',25),\r\n" + 
			"(226,'CHIMBOTE',25),\r\n" + 
			"(227,'COISHCO',25),\r\n" + 
			"(228,'MACATE',25),\r\n" + 
			"(229,'MORO',25),\r\n" + 
			"(230,'NEPENA',25),\r\n" + 
			"(231,'NUEVO CHIMBOTE',25),\r\n" + 
			"(232,'SAMANCO',25),\r\n" + 
			"(233,'SANTA',25),\r\n" + 
			"(234,'ACOBAMBA',26),\r\n" + 
			"(235,'ALFONSO UGARTE',26),\r\n" + 
			"(236,'CASHAPAMPA',26),\r\n" + 
			"(237,'CHINGALPO',26),\r\n" + 
			"(238,'HUAYLLABAMBA',26),\r\n" + 
			"(239,'QUICHES',26),\r\n" + 
			"(240,'RAGASH',26),\r\n" + 
			"(241,'SAN JUAN',26),\r\n" + 
			"(242,'SICSIBAMBA',26),\r\n" + 
			"(243,'SIHUAS',26),\r\n" + 
			"(244,'CASCAPARA',27),\r\n" + 
			"(245,'MANCOS',27),\r\n" + 
			"(246,'MATACOTO',27),\r\n" + 
			"(247,'QUILLO',27),\r\n" + 
			"(248,'RANRAHIRCA',27),\r\n" + 
			"(249,'SHUPLUY',27),\r\n" + 
			"(250,'YANAMA',27),\r\n" + 
			"(251,'YUNGAY',27),\r\n" + 
			"(252,'ABANCAY',28),\r\n" + 
			"(253,'CHACOCHE',28),\r\n" + 
			"(254,'CIRCA',28),\r\n" + 
			"(255,'CURAHUASI',28),\r\n" + 
			"(256,'HUANIPACA',28),\r\n" + 
			"(257,'LAMBRAMA',28),\r\n" + 
			"(258,'PICHIRHUA',28),\r\n" + 
			"(259,'SAN PEDRO DE CACHORA',28),\r\n" + 
			"(260,'TAMBURCO',28),\r\n" + 
			"(261,'ANDAHUAYLAS',29),\r\n" + 
			"(262,'ANDARAPA',29),\r\n" + 
			"(263,'CHIARA',29),\r\n" + 
			"(264,'HUANCARAMA',29),\r\n" + 
			"(265,'HUANCARAY',29),\r\n" + 
			"(266,'HUAYANA',29),\r\n" + 
			"(267,'KAQUIABAMBA',29),\r\n" + 
			"(268,'KISHUARA',29),\r\n" + 
			"(269,'PACOBAMBA',29),\r\n" + 
			"(270,'PACUCHA',29),\r\n" + 
			"(271,'PAMPACHIRI',29),\r\n" + 
			"(272,'POMACOCHA',29),\r\n" + 
			"(273,'SAN ANTONIO DE CACHI',29),\r\n" + 
			"(274,'SAN JERONIMO',29),\r\n" + 
			"(275,'SAN MIGUEL DE CHACCRAMPA',29),\r\n" + 
			"(276,'STA MARIA DE CHICMO',29),\r\n" + 
			"(277,'TALAVERA',29),\r\n" + 
			"(278,'TUMAY HUARACA',29),\r\n" + 
			"(279,'TURPO',29),\r\n" + 
			"(280,'ANTABAMBA',30),\r\n" + 
			"(281,'EL ORO',30),\r\n" + 
			"(282,'HUAQUIRCA',30),\r\n" + 
			"(283,'JUAN ESPINOZA MEDRANO',30),\r\n" + 
			"(284,'OROPESA',30),\r\n" + 
			"(285,'PACHACONAS',30),\r\n" + 
			"(286,'SABAINO',30),\r\n" + 
			"(287,'CAPAYA',31),\r\n" + 
			"(288,'CARAYBAMBA',31),\r\n" + 
			"(289,'CHALHUANCA',31),\r\n" + 
			"(290,'CHAPIMARCA',31),\r\n" + 
			"(291,'COLCABAMBA',31),\r\n" + 
			"(292,'COTARUSE',31),\r\n" + 
			"(293,'IHUAYLLO',31),\r\n" + 
			"(294,'JUSTO APU SAHUARAURA',31),\r\n" + 
			"(295,'LUCRE',31),\r\n" + 
			"(296,'POCOHUANCA',31),\r\n" + 
			"(297,'SAN JUAN DE CHACNA',31),\r\n" + 
			"(298,'SANAICA',31),\r\n" + 
			"(299,'SORAYA',31),\r\n" + 
			"(300,'TAPAIRIHUA',31),\r\n" + 
			"(301,'TINTAY',31),\r\n" + 
			"(302,'TORAYA',31),\r\n" + 
			"(303,'YANACA',31),\r\n" + 
			"(304,'ANCO HUALLO',32),\r\n" + 
			"(305,'CHINCHEROS',32),\r\n" + 
			"(306,'COCHARCAS',32),\r\n" + 
			"(307,'HUACCANA',32),\r\n" + 
			"(308,'OCOBAMBA',32),\r\n" + 
			"(309,'ONGOY',32),\r\n" + 
			"(310,'RANRACANCHA',32),\r\n" + 
			"(311,'URANMARCA',32),\r\n" + 
			"(312,'CHALLHUAHUACHO',33),\r\n" + 
			"(313,'COTABAMBAS',33),\r\n" + 
			"(314,'COYLLURQUI',33),\r\n" + 
			"(315,'HAQUIRA',33),\r\n" + 
			"(316,'HAQUIRA',33),\r\n" + 
			"(317,'MARA',33),\r\n" + 
			"(318,'TAMBOBAMBA',33),\r\n" + 
			"(319,'CHUQUIBAMBILLA',34),\r\n" + 
			"(320,'CURASCO',34),\r\n" + 
			"(321,'CURPAHUASI',34),\r\n" + 
			"(322,'HUAILLATI',34),\r\n" + 
			"(323,'MAMARA',34),\r\n" + 
			"(324,'MARISCAL GAMARRA',34),\r\n" + 
			"(325,'MICAELA BASTIDAS',34),\r\n" + 
			"(326,'PATAYPAMPA',34),\r\n" + 
			"(327,'PROGRESO',34),\r\n" + 
			"(328,'SAN ANTONIO',34),\r\n" + 
			"(329,'SANTA ROSA',34),\r\n" + 
			"(330,'TURPAY',34),\r\n" + 
			"(331,'VILCABAMBA',34),\r\n" + 
			"(332,'VIRUNDO',34),\r\n" + 
			"(333,'ALTO SELVA ALEGRE',35),\r\n" + 
			"(334,'AREQUIPA',35),\r\n" + 
			"(335,'CAYMA',35),\r\n" + 
			"(336,'CERRO COLORADO',35),\r\n" + 
			"(337,'CHARACATO',35),\r\n" + 
			"(338,'CHIGUATA',35),\r\n" + 
			"(339,'JACOBO HUNTER',35),\r\n" + 
			"(340,'JOSE LUIS BUSTAMANTE Y RIVERO',35),\r\n" + 
			"(341,'LA JOYA',35),\r\n" + 
			"(342,'MARIANO MELGAR',35),\r\n" + 
			"(343,'MIRAFLORES',35),\r\n" + 
			"(344,'MOLLEBAYA',35),\r\n" + 
			"(345,'PAUCARPATA',35),\r\n" + 
			"(346,'POCSI',35),\r\n" + 
			"(347,'POLOBAYA',35),\r\n" + 
			"(348,'QUEQUENA',35),\r\n" + 
			"(349,'SABANDIA',35),\r\n" + 
			"(350,'SACHACA',35),\r\n" + 
			"(351,'SAN JUAN DE SIGUAS',35),\r\n" + 
			"(352,'SAN JUAN DE TARUCANI',35),\r\n" + 
			"(353,'SANTA ISABEL DE SIGUAS',35),\r\n" + 
			"(354,'SOCABAYA',35),\r\n" + 
			"(355,'STA RITA DE SIGUAS',35),\r\n" + 
			"(356,'TIABAYA',35),\r\n" + 
			"(357,'UCHUMAYO',35),\r\n" + 
			"(358,'VITOR',35),\r\n" + 
			"(359,'YANAHUARA',35),\r\n" + 
			"(360,'YARABAMBA',35),\r\n" + 
			"(361,'YURA',35),\r\n" + 
			"(362,'CAMANA',36),\r\n" + 
			"(363,'JOSE MARIA QUIMPER',36),\r\n" + 
			"(364,'MARIANO N VALCARCEL',36),\r\n" + 
			"(365,'MARISCAL CACERES',36),\r\n" + 
			"(366,'NICOLAS DE PIEROLA',36),\r\n" + 
			"(367,'OCONA',36),\r\n" + 
			"(368,'QUILCA',36),\r\n" + 
			"(369,'SAMUEL PASTOR',36),\r\n" + 
			"(370,'ACARI',37),\r\n" + 
			"(371,'ATICO',37),\r\n" + 
			"(372,'ATIQUIPA',37),\r\n" + 
			"(373,'BELLA UNION',37),\r\n" + 
			"(374,'CAHUACHO',37),\r\n" + 
			"(375,'CARAVELI',37),\r\n" + 
			"(376,'CHALA',37),\r\n" + 
			"(377,'CHAPARRA',37),\r\n" + 
			"(378,'HUANUHUANU',37),\r\n" + 
			"(379,'JAQUI',37),\r\n" + 
			"(380,'LOMAS',37),\r\n" + 
			"(381,'QUICACHA',37),\r\n" + 
			"(382,'YAUCA',37),\r\n" + 
			"(383,'ANDAGUA',38),\r\n" + 
			"(384,'APLAO',38),\r\n" + 
			"(385,'AYO',38),\r\n" + 
			"(386,'CHACHAS',38),\r\n" + 
			"(387,'CHILCAYMARCA',38),\r\n" + 
			"(388,'CHOCO',38),\r\n" + 
			"(389,'HUANCARQUI',38),\r\n" + 
			"(390,'MACHAGUAY',38),\r\n" + 
			"(391,'ORCOPAMPA',38),\r\n" + 
			"(392,'PAMPACOLCA',38),\r\n" + 
			"(393,'TIPAN',38),\r\n" + 
			"(394,'UNON',38),\r\n" + 
			"(395,'URACA',38),\r\n" + 
			"(396,'VIRACO',38),\r\n" + 
			"(397,'ACHOMA',39),\r\n" + 
			"(398,'CABANACONDE',39),\r\n" + 
			"(399,'CALLALLI',39),\r\n" + 
			"(400,'CAYLLOMA',39),\r\n" + 
			"(401,'CHIVAY',39),\r\n" + 
			"(402,'COPORAQUE',39),\r\n" + 
			"(403,'HUAMBO',39),\r\n" + 
			"(404,'HUANCA',39),\r\n" + 
			"(405,'ICHUPAMPA',39),\r\n" + 
			"(406,'LARI',39),\r\n" + 
			"(407,'LLUTA',39),\r\n" + 
			"(408,'MACA',39),\r\n" + 
			"(409,'MADRIGAL',39),\r\n" + 
			"(410,'MAJES',39),\r\n" + 
			"(411,'SAN ANTONIO DE CHUCA',39),\r\n" + 
			"(412,'SIBAYO',39),\r\n" + 
			"(413,'TAPAY',39),\r\n" + 
			"(414,'TISCO',39),\r\n" + 
			"(415,'TUTI',39),\r\n" + 
			"(416,'YANQUE',39),\r\n" + 
			"(417,'ANDARAY',40),\r\n" + 
			"(418,'CAYARANI',40),\r\n" + 
			"(419,'CHICHAS',40),\r\n" + 
			"(420,'CHUQUIBAMBA',40),\r\n" + 
			"(421,'IRAY',40),\r\n" + 
			"(422,'RIO GRANDE',40),\r\n" + 
			"(423,'SALAMANCA',40),\r\n" + 
			"(424,'YANAQUIHUA',40),\r\n" + 
			"(425,'COCACHACRA',41),\r\n" + 
			"(426,'DEAN VALDIVIA',41),\r\n" + 
			"(427,'ISLAY',41),\r\n" + 
			"(428,'MEJIA',41),\r\n" + 
			"(429,'MOLLENDO',41),\r\n" + 
			"(430,'PUNTA DE BOMBON',41),\r\n" + 
			"(431,'ALCA',42),\r\n" + 
			"(432,'CHARCANA',42),\r\n" + 
			"(433,'COTAHUASI',42),\r\n" + 
			"(434,'HUAYNACOTAS',42),\r\n" + 
			"(435,'PAMPAMARCA',42),\r\n" + 
			"(436,'PUYCA',42),\r\n" + 
			"(437,'QUECHUALLA',42),\r\n" + 
			"(438,'SAYLA',42),\r\n" + 
			"(439,'TAURIA',42),\r\n" + 
			"(440,'TOMEPAMPA',42),\r\n" + 
			"(441,'TORO',42),\r\n" + 
			"(442,'CANGALLO',43),\r\n" + 
			"(443,'CHUSCHI',43),\r\n" + 
			"(444,'LOS MOROCHUCOS',43),\r\n" + 
			"(445,'MARIA PARADO DE BELLIDO',43),\r\n" + 
			"(446,'PARAS',43),\r\n" + 
			"(447,'TOTOS',43),\r\n" + 
			"(448,'ACOCRO',44),\r\n" + 
			"(449,'ACOS VINCHOS',44),\r\n" + 
			"(450,'AYACUCHO',44),\r\n" + 
			"(451,'CARMEN ALTO',44),\r\n" + 
			"(452,'CHIARA',44),\r\n" + 
			"(453,'JESUS NAZARENO',44),\r\n" + 
			"(454,'OCROS',44),\r\n" + 
			"(455,'PACAYCASA',44),\r\n" + 
			"(456,'QUINUA',44),\r\n" + 
			"(457,'SAN JOSE DE TICLLAS',44),\r\n" + 
			"(458,'SAN JUAN BAUTISTA',44),\r\n" + 
			"(459,'SANTIAGO DE PISCHA',44),\r\n" + 
			"(460,'SOCOS',44),\r\n" + 
			"(461,'TAMBILLO',44),\r\n" + 
			"(462,'VINCHOS',44),\r\n" + 
			"(463,'CARAPO',45),\r\n" + 
			"(464,'SACSAMARCA',45),\r\n" + 
			"(465,'SANCOS',45),\r\n" + 
			"(466,'SANTIAGO DE LUCANAMARCA',45),\r\n" + 
			"(467,'AYAHUANCO',46),\r\n" + 
			"(468,'HUAMANGUILLA',46),\r\n" + 
			"(469,'HUANTA',46),\r\n" + 
			"(470,'IGUAIN',46),\r\n" + 
			"(471,'LLOCHEGUA',46),\r\n" + 
			"(472,'LURICOCHA',46),\r\n" + 
			"(473,'SANTILLANA',46),\r\n" + 
			"(474,'SIVIA',46),\r\n" + 
			"(475,'ANCO',47),\r\n" + 
			"(476,'AYNA',47),\r\n" + 
			"(477,'CHILCAS',47),\r\n" + 
			"(478,'CHUNGUI',47),\r\n" + 
			"(479,'LUIS CARRANZA',47),\r\n" + 
			"(480,'SAN MIGUEL',47),\r\n" + 
			"(481,'SANTA ROSA',47),\r\n" + 
			"(482,'TAMBO',47),\r\n" + 
			"(483,'AUCARA',48),\r\n" + 
			"(484,'CABANA',48),\r\n" + 
			"(485,'CARMEN SALCEDO',48),\r\n" + 
			"(486,'CHAVINA',48),\r\n" + 
			"(487,'CHIPAO',48),\r\n" + 
			"(488,'HUAC-HUAS',48),\r\n" + 
			"(489,'LARAMATE',48),\r\n" + 
			"(490,'LEONCIO PRADO',48),\r\n" + 
			"(491,'LLAUTA',48),\r\n" + 
			"(492,'LUCANAS',48),\r\n" + 
			"(493,'OCANA',48),\r\n" + 
			"(494,'OTOCA',48),\r\n" + 
			"(495,'PUQUIO',48),\r\n" + 
			"(496,'SAISA',48),\r\n" + 
			"(497,'SAN CRISTOBAL',48),\r\n" + 
			"(498,'SAN JUAN',48),\r\n" + 
			"(499,'SAN PEDRO',48),\r\n" + 
			"(500,'SAN PEDRO DE PALCO',48),\r\n" + 
			"(501,'SANCOS',48),\r\n" + 
			"(502,'SANTA LUCIA',48),\r\n" + 
			"(503,'STA ANA DE HUAYCAHUACHO',48),\r\n" + 
			"(504,'CHUMPI',49),\r\n" + 
			"(505,'CORACORA',49),\r\n" + 
			"(506,'CORONEL CASTANEDA',49),\r\n" + 
			"(507,'PACAPAUSA',49),\r\n" + 
			"(508,'PULLO',49),\r\n" + 
			"(509,'PUYUSCA',49),\r\n" + 
			"(510,'SAN FCO DE RAVACAYCO',49),\r\n" + 
			"(511,'UPAHUACHO',49),\r\n" + 
			"(512,'COLTA',50),\r\n" + 
			"(513,'CORCULLA',50),\r\n" + 
			"(514,'LAMPA',50),\r\n" + 
			"(515,'MARCABAMBA',50),\r\n" + 
			"(516,'OYOLO',50),\r\n" + 
			"(517,'PARARCA',50),\r\n" + 
			"(518,'PAUSA',50),\r\n" + 
			"(519,'SAN JAVIER DE ALPABAMBA',50),\r\n" + 
			"(520,'SAN JOSE DE USHUA',50),\r\n" + 
			"(521,'SARA SARA',50),\r\n" + 
			"(522,'BELEN',51),\r\n" + 
			"(523,'CHALCOS',51),\r\n" + 
			"(524,'CHILCAYOC',51),\r\n" + 
			"(525,'HUACANA',51),\r\n" + 
			"(526,'MORCOLLA',51),\r\n" + 
			"(527,'PAICO',51),\r\n" + 
			"(528,'QUEROBAMBA',51),\r\n" + 
			"(529,'SAN PEDRO DE LARCAY',51),\r\n" + 
			"(530,'SAN SALVADOR DE QUIJE',51),\r\n" + 
			"(531,'SANTIAGO DE PAUCARAY',51),\r\n" + 
			"(532,'SORAS',51),\r\n" + 
			"(533,'ALCAMENCA',52),\r\n" + 
			"(534,'APONGO',52),\r\n" + 
			"(535,'ASQUIPATA',52),\r\n" + 
			"(536,'CANARIA',52),\r\n" + 
			"(537,'CAYARA',52),\r\n" + 
			"(538,'COLCA',52),\r\n" + 
			"(539,'HUAMANQUIQUIA',52),\r\n" + 
			"(540,'HUANCAPI',52),\r\n" + 
			"(541,'HUANCARAYLLA',52),\r\n" + 
			"(542,'HUAYA',52),\r\n" + 
			"(543,'SARHUA',52),\r\n" + 
			"(544,'VILCANCHOS',52),\r\n" + 
			"(545,'ACCOMARCA',53),\r\n" + 
			"(546,'CARHUANCA',53),\r\n" + 
			"(547,'CONCEPCION',53),\r\n" + 
			"(548,'HUAMBALPA',53),\r\n" + 
			"(549,'INDEPENDENCIA',53),\r\n" + 
			"(550,'SAURAMA',53),\r\n" + 
			"(551,'VILCAS HUAMAN',53),\r\n" + 
			"(552,'VISCHONGO',53),\r\n" + 
			"(553,'CACHACHI',54),\r\n" + 
			"(554,'CAJABAMBA',54),\r\n" + 
			"(555,'CONDEBAMBA',54),\r\n" + 
			"(556,'SITACOCHA',54),\r\n" + 
			"(557,'ASUNCION',55),\r\n" + 
			"(558,'CAJAMARCA',55),\r\n" + 
			"(559,'CHETILLA',55),\r\n" + 
			"(560,'COSPAN',55),\r\n" + 
			"(561,'ENCANADA',55),\r\n" + 
			"(562,'JESUS',55),\r\n" + 
			"(563,'LLACANORA',55),\r\n" + 
			"(564,'LOS BANOS DEL INCA',55),\r\n" + 
			"(565,'MAGDALENA',55),\r\n" + 
			"(566,'MATARA',55),\r\n" + 
			"(567,'NAMORA',55),\r\n" + 
			"(568,'SAN JUAN',55),\r\n" + 
			"(569,'CELENDIN',56),\r\n" + 
			"(570,'CHUMUCH',56),\r\n" + 
			"(571,'CORTEGANA',56),\r\n" + 
			"(572,'HUASMIN',56),\r\n" + 
			"(573,'JORGE CHAVEZ',56),\r\n" + 
			"(574,'JOSE GALVEZ',56),\r\n" + 
			"(575,'LA LIBERTAD DE PALLAN',56),\r\n" + 
			"(576,'MIGUEL IGLESIAS',56),\r\n" + 
			"(577,'OXAMARCA',56),\r\n" + 
			"(578,'SOROCHUCO',56),\r\n" + 
			"(579,'SUCRE',56),\r\n" + 
			"(580,'UTCO',56),\r\n" + 
			"(581,'ANGUIA',57),\r\n" + 
			"(582,'CHADIN',57),\r\n" + 
			"(583,'CHALAMARCA',57),\r\n" + 
			"(584,'CHIGUIRIP',57),\r\n" + 
			"(585,'CHIMBAN',57),\r\n" + 
			"(586,'CHOROPAMPA',57),\r\n" + 
			"(587,'CHOTA',57),\r\n" + 
			"(588,'COCHABAMBA',57),\r\n" + 
			"(589,'CONCHAN',57),\r\n" + 
			"(590,'HUAMBOS',57),\r\n" + 
			"(591,'LAJAS',57),\r\n" + 
			"(592,'LLAMA',57),\r\n" + 
			"(593,'MIRACOSTA',57),\r\n" + 
			"(594,'PACCHA',57),\r\n" + 
			"(595,'PION',57),\r\n" + 
			"(596,'QUEROCOTO',57),\r\n" + 
			"(597,'SAN JUAN DE LICUPIS',57),\r\n" + 
			"(598,'TACABAMBA',57),\r\n" + 
			"(599,'TOCMOCHE',57),\r\n" + 
			"(600,'CHILETE',58),\r\n" + 
			"(601,'CONTUMAZA',58),\r\n" + 
			"(602,'CUPISNIQUE',58),\r\n" + 
			"(603,'GUZMANGO',58),\r\n" + 
			"(604,'SAN BENITO',58),\r\n" + 
			"(605,'STA CRUZ DE TOLEDO',58),\r\n" + 
			"(606,'TANTARICA',58),\r\n" + 
			"(607,'YONAN',58),\r\n" + 
			"(608,'CALLAYUC',59),\r\n" + 
			"(609,'CHOROS',59),\r\n" + 
			"(610,'CUJILLO',59),\r\n" + 
			"(611,'CUTERVO',59),\r\n" + 
			"(612,'LA RAMADA',59),\r\n" + 
			"(613,'PIMPINGOS',59),\r\n" + 
			"(614,'QUEROCOTILLO',59),\r\n" + 
			"(615,'SAN ANDRES DE CUTERVO',59),\r\n" + 
			"(616,'SAN JUAN DE CUTERVO',59),\r\n" + 
			"(617,'SAN LUIS DE LUCMA',59),\r\n" + 
			"(618,'SANTA CRUZ',59),\r\n" + 
			"(619,'SANTO DOMINGO DE LA CAPILLA',59),\r\n" + 
			"(620,'SANTO TOMAS',59),\r\n" + 
			"(621,'SOCOTA',59),\r\n" + 
			"(622,'TORIBIO CASANOVA',59),\r\n" + 
			"(623,'BAMBAMARCA',60),\r\n" + 
			"(624,'CHUGUR',60),\r\n" + 
			"(625,'HUALGAYOC',60),\r\n" + 
			"(626,'BELLAVISTA',61),\r\n" + 
			"(627,'CHONTALI',61),\r\n" + 
			"(628,'COLASAY',61),\r\n" + 
			"(629,'HUABAL',61),\r\n" + 
			"(630,'JAEN',61),\r\n" + 
			"(631,'LAS PIRIAS',61),\r\n" + 
			"(632,'POMAHUACA',61),\r\n" + 
			"(633,'PUCARA',61),\r\n" + 
			"(634,'SALLIQUE',61),\r\n" + 
			"(635,'SAN FELIPE',61),\r\n" + 
			"(636,'SAN JOSE DEL ALTO',61),\r\n" + 
			"(637,'SANTA ROSA',61),\r\n" + 
			"(638,'CHIRINOS',62),\r\n" + 
			"(639,'HUARANGO',62),\r\n" + 
			"(640,'LA COIPA',62),\r\n" + 
			"(641,'NAMBALLE',62),\r\n" + 
			"(642,'SAN IGNACIO',62),\r\n" + 
			"(643,'SAN JOSE DE LOURDES',62),\r\n" + 
			"(644,'TABACONAS',62),\r\n" + 
			"(645,'CHANCAY',63),\r\n" + 
			"(646,'EDUARDO VILLANUEVA',63),\r\n" + 
			"(647,'GREGORIO PITA',63),\r\n" + 
			"(648,'ICHOCAN',63),\r\n" + 
			"(649,'JOSE MANUEL QUIROZ',63),\r\n" + 
			"(650,'JOSE SABOGAL',63),\r\n" + 
			"(651,'PEDRO GALVEZ',63),\r\n" + 
			"(652,'BOLIVAR',64),\r\n" + 
			"(653,'CALQUIS',64),\r\n" + 
			"(654,'CATILLUC',64),\r\n" + 
			"(655,'EL PRADO',64),\r\n" + 
			"(656,'LA FLORIDA',64),\r\n" + 
			"(657,'LLAPA',64),\r\n" + 
			"(658,'NANCHOC',64),\r\n" + 
			"(659,'NIEPOS',64),\r\n" + 
			"(660,'SAN GREGORIO',64),\r\n" + 
			"(661,'SAN MIGUEL',64),\r\n" + 
			"(662,'SAN SILVESTRE DE COCHAN',64),\r\n" + 
			"(663,'TONGOD',64),\r\n" + 
			"(664,'UNION AGUA BLANCA',64),\r\n" + 
			"(665,'SAN BERNARDINO',65),\r\n" + 
			"(666,'SAN LUIS',65),\r\n" + 
			"(667,'SAN PABLO',65),\r\n" + 
			"(668,'TUMBADEN',65),\r\n" + 
			"(669,'ANDABAMBA',66),\r\n" + 
			"(670,'CATACHE',66),\r\n" + 
			"(671,'CHANCAIBANOS',66),\r\n" + 
			"(672,'LA ESPERANZA',66),\r\n" + 
			"(673,'NINABAMBA',66),\r\n" + 
			"(674,'PULAN',66),\r\n" + 
			"(675,'SANTA CRUZ',66),\r\n" + 
			"(676,'SAUCEPAMPA',66),\r\n" + 
			"(677,'SEXI',66),\r\n" + 
			"(678,'UTICYACU',66),\r\n" + 
			"(679,'YAUYUCAN',66),\r\n" + 
			"(680,'ACOMAYO',67),\r\n" + 
			"(681,'ACOPIA',67),\r\n" + 
			"(682,'ACOS',67),\r\n" + 
			"(683,'MOSOC LLACTA',67),\r\n" + 
			"(684,'POMACANCHI',67),\r\n" + 
			"(685,'RONDOCAN',67),\r\n" + 
			"(686,'SANGARARA',67),\r\n" + 
			"(687,'ANCAHUASI',68),\r\n" + 
			"(688,'ANTA',68),\r\n" + 
			"(689,'CACHIMAYO',68),\r\n" + 
			"(690,'CHINCHAYPUJIO',68),\r\n" + 
			"(691,'HUAROCONDO',68),\r\n" + 
			"(692,'LIMATAMBO',68),\r\n" + 
			"(693,'MOLLEPATA',68),\r\n" + 
			"(694,'PUCYURA',68),\r\n" + 
			"(695,'ZURITE',68),\r\n" + 
			"(696,'CALCA',69),\r\n" + 
			"(697,'COYA',69),\r\n" + 
			"(698,'LAMAY',69),\r\n" + 
			"(699,'LARES',69),\r\n" + 
			"(700,'PISAC',69),\r\n" + 
			"(701,'SAN SALVADOR',69),\r\n" + 
			"(702,'TARAY',69),\r\n" + 
			"(703,'YANATILE',69),\r\n" + 
			"(704,'CHECCA',70),\r\n" + 
			"(705,'KUNTURKANKI',70),\r\n" + 
			"(706,'LANGUI',70),\r\n" + 
			"(707,'LAYO',70),\r\n" + 
			"(708,'PAMPAMARCA',70),\r\n" + 
			"(709,'QUEHUE',70),\r\n" + 
			"(710,'TUPAC AMARU',70),\r\n" + 
			"(711,'YANAOCA',70),\r\n" + 
			"(712,'CHECACUPE',71),\r\n" + 
			"(713,'COMBAPATA',71),\r\n" + 
			"(714,'MARANGANI',71),\r\n" + 
			"(715,'PITUMARCA',71),\r\n" + 
			"(716,'SAN PABLO',71),\r\n" + 
			"(717,'SAN PEDRO',71),\r\n" + 
			"(718,'SICUANI',71),\r\n" + 
			"(719,'TINTA',71),\r\n" + 
			"(720,'CAPACMARCA',72),\r\n" + 
			"(721,'CHAMACA',72),\r\n" + 
			"(722,'COLQUEMARCA',72),\r\n" + 
			"(723,'LIVITACA',72),\r\n" + 
			"(724,'LLUSCO',72),\r\n" + 
			"(725,'QUINOTA',72),\r\n" + 
			"(726,'SANTO TOMAS',72),\r\n" + 
			"(727,'VELILLE',72),\r\n" + 
			"(728,'CCORCA',73),\r\n" + 
			"(729,'CUSCO',73),\r\n" + 
			"(730,'POROY',73),\r\n" + 
			"(731,'SAN JERONIMO',73),\r\n" + 
			"(732,'SAN SEBASTIAN',73),\r\n" + 
			"(733,'SANTIAGO',73),\r\n" + 
			"(734,'SAYLLA',73),\r\n" + 
			"(735,'WANCHAQ',73),\r\n" + 
			"(736,'ALTO PICHIGUA',74),\r\n" + 
			"(737,'CONDOROMA',74),\r\n" + 
			"(738,'COPORAQUE',74),\r\n" + 
			"(739,'ESPINAR',74),\r\n" + 
			"(740,'OCORURO',74),\r\n" + 
			"(741,'PALLPATA',74),\r\n" + 
			"(742,'PICHIGUA',74),\r\n" + 
			"(743,'SUYKUTAMBO',74),\r\n" + 
			"(744,'ECHARATE',75),\r\n" + 
			"(745,'HUAYOPATA',75),\r\n" + 
			"(746,'KIMBIRI',75),\r\n" + 
			"(747,'MARANURA',75),\r\n" + 
			"(748,'OCOBAMBA',75),\r\n" + 
			"(749,'PICHARI',75),\r\n" + 
			"(750,'QUELLOUNO',75),\r\n" + 
			"(751,'SANTA ANA',75),\r\n" + 
			"(752,'SANTA TERESA',75),\r\n" + 
			"(753,'VILCABAMBA',75),\r\n" + 
			"(754,'ACCHA',76),\r\n" + 
			"(755,'CCAPI',76),\r\n" + 
			"(756,'COLCHA',76),\r\n" + 
			"(757,'HUANOQUITE',76),\r\n" + 
			"(758,'OMACHA',76),\r\n" + 
			"(759,'PACCARITAMBO',76),\r\n" + 
			"(760,'PARURO',76),\r\n" + 
			"(761,'PILLPINTO',76),\r\n" + 
			"(762,'YAURISQUE',76),\r\n" + 
			"(763,'CAICAY',77),\r\n" + 
			"(764,'CHALLABAMBA',77),\r\n" + 
			"(765,'COLQUEPATA',77),\r\n" + 
			"(766,'COSNIPATA',77),\r\n" + 
			"(767,'HUANCARANI',77),\r\n" + 
			"(768,'PAUCARTAMBO',77),\r\n" + 
			"(769,'ANDAHUAYLILLAS',78),\r\n" + 
			"(770,'CAMANTI',78),\r\n" + 
			"(771,'CCARHUAYO',78),\r\n" + 
			"(772,'CCATCA',78),\r\n" + 
			"(773,'CUSIPATA',78),\r\n" + 
			"(774,'HUARO',78),\r\n" + 
			"(775,'LUCRE',78),\r\n" + 
			"(776,'MARCAPATA',78),\r\n" + 
			"(777,'OCONGATE',78),\r\n" + 
			"(778,'OROPESA',78),\r\n" + 
			"(779,'QUIQUIJANA',78),\r\n" + 
			"(780,'URCOS',78),\r\n" + 
			"(781,'CHINCHERO',79),\r\n" + 
			"(782,'HUAYLLABAMBA',79),\r\n" + 
			"(783,'MACHUPICCHU',79),\r\n" + 
			"(784,'MARAS',79),\r\n" + 
			"(785,'OLLANTAYTAMBO',79),\r\n" + 
			"(786,'URUBAMBA',79),\r\n" + 
			"(787,'YUCAY',79),\r\n" + 
			"(788,'ACOBAMBA',80),\r\n" + 
			"(789,'ANDABAMBA',80),\r\n" + 
			"(790,'ANTA',80),\r\n" + 
			"(791,'CAJA',80),\r\n" + 
			"(792,'MARCAS',80),\r\n" + 
			"(793,'PAUCARA',80),\r\n" + 
			"(794,'POMACOCHA',80),\r\n" + 
			"(795,'ROSARIO',80),\r\n" + 
			"(796,'ANCHONGA',81),\r\n" + 
			"(797,'CALLANMARCA',81),\r\n" + 
			"(798,'CCOCHACCASA',81),\r\n" + 
			"(799,'CHINCHO',81),\r\n" + 
			"(800,'CONGALLA',81),\r\n" + 
			"(801,'HUANCA HUANCA',81),\r\n" + 
			"(802,'HUAYLLAY GRANDE',81),\r\n" + 
			"(803,'JULCAMARCA',81),\r\n" + 
			"(804,'LIRCAY',81),\r\n" + 
			"(805,'SAN ANTONIO DE ANTAPARCO',81),\r\n" + 
			"(806,'SECCLLA',81),\r\n" + 
			"(807,'STO TOMAS DE PATA',81),\r\n" + 
			"(808,'ARMA',82),\r\n" + 
			"(809,'AURAHUA',82),\r\n" + 
			"(810,'CAPILLAS',82),\r\n" + 
			"(811,'CASTROVIRREYNA',82),\r\n" + 
			"(812,'CHUPAMARCA',82),\r\n" + 
			"(813,'COCAS',82),\r\n" + 
			"(814,'HUACHOS',82),\r\n" + 
			"(815,'HUAMATAMBO',82),\r\n" + 
			"(816,'MOLLEPAMPA',82),\r\n" + 
			"(817,'SAN JUAN',82),\r\n" + 
			"(818,'SANTA ANA',82),\r\n" + 
			"(819,'TANTARA',82),\r\n" + 
			"(820,'TICRAPO',82),\r\n" + 
			"(821,'ANCO',83),\r\n" + 
			"(822,'CHINCHIHUASI',83),\r\n" + 
			"(823,'CHURCAMPA',83),\r\n" + 
			"(824,'EL CARMEN',83),\r\n" + 
			"(825,'LA MERCED',83),\r\n" + 
			"(826,'LOCROJA',83),\r\n" + 
			"(827,'PACHAMARCA',83),\r\n" + 
			"(828,'PAUCARBAMBA',83),\r\n" + 
			"(829,'SAN MIGUEL DE MAYOC',83),\r\n" + 
			"(830,'SAN PEDRO DE CORIS',83),\r\n" + 
			"(831,'ACOBAMBILLA',84),\r\n" + 
			"(832,'ACORIA',84),\r\n" + 
			"(833,'ASCENCION',84),\r\n" + 
			"(834,'CONAYCA',84),\r\n" + 
			"(835,'CUENCA',84),\r\n" + 
			"(836,'HUACHOCOLPA',84),\r\n" + 
			"(837,'HUANCAVELICA',84),\r\n" + 
			"(838,'HUANDO',84),\r\n" + 
			"(839,'HUAYLLAHUARA',84),\r\n" + 
			"(840,'IZCUCHACA',84),\r\n" + 
			"(841,'LARIA',84),\r\n" + 
			"(842,'MANTA',84),\r\n" + 
			"(843,'MARISCAL CACERES',84),\r\n" + 
			"(844,'MOYA',84),\r\n" + 
			"(845,'NUEVO OCCORO',84),\r\n" + 
			"(846,'PALCA',84),\r\n" + 
			"(847,'PILCHACA',84),\r\n" + 
			"(848,'VILCA',84),\r\n" + 
			"(849,'YAULI',84),\r\n" + 
			"(850,'AYAVI',85),\r\n" + 
			"(851,'CORDOVA',85),\r\n" + 
			"(852,'HUAYACUNDO ARMA',85),\r\n" + 
			"(853,'HUAYTARA',85),\r\n" + 
			"(854,'LARAMARCA',85),\r\n" + 
			"(855,'OCOYO',85),\r\n" + 
			"(856,'PILPICHACA',85),\r\n" + 
			"(857,'QUERCO',85),\r\n" + 
			"(858,'QUITO ARMA',85),\r\n" + 
			"(859,'SAN ANTONIO DE CUSICANCHA',85),\r\n" + 
			"(860,'SAN FRANCISCO DE SANGAYAICO',85),\r\n" + 
			"(861,'SAN ISIDRO',85),\r\n" + 
			"(862,'SANTIAGO DE CHOCORVOS',85),\r\n" + 
			"(863,'SANTIAGO DE QUIRAHUARA',85),\r\n" + 
			"(864,'SANTO DOMINGO DE CAPILLA',85),\r\n" + 
			"(865,'TAMBO',85),\r\n" + 
			"(866,'ACOSTAMBO',86),\r\n" + 
			"(867,'ACRAQUIA',86),\r\n" + 
			"(868,'AHUAYCHA',86),\r\n" + 
			"(869,'COLCABAMBA',86),\r\n" + 
			"(870,'DANIEL HERNANDEZ',86),\r\n" + 
			"(871,'HUACHOCOLPA',86),\r\n" + 
			"(872,'HUARIBAMBA',86),\r\n" + 
			"(873,'NAHUIMPUQUIO',86),\r\n" + 
			"(874,'PAMPAS',86),\r\n" + 
			"(875,'PAZOS',86),\r\n" + 
			"(876,'QUISHUAR',86),\r\n" + 
			"(877,'SALCABAMBA',86),\r\n" + 
			"(878,'SALCAHUASI',86),\r\n" + 
			"(879,'SAN MARCOS DE ROCCHAC',86),\r\n" + 
			"(880,'SURCUBAMBA',86),\r\n" + 
			"(881,'TINTAY PUNCU',86),\r\n" + 
			"(882,'AMBO',87),\r\n" + 
			"(883,'CAYNA',87),\r\n" + 
			"(884,'COLPAS',87),\r\n" + 
			"(885,'CONCHAMARCA',87),\r\n" + 
			"(886,'HUACAR',87),\r\n" + 
			"(887,'SAN FRANCISCO',87),\r\n" + 
			"(888,'SAN RAFAEL',87),\r\n" + 
			"(889,'TOMAY KICHWA',87),\r\n" + 
			"(890,'CHUQUIS',88),\r\n" + 
			"(891,'LA UNION',88),\r\n" + 
			"(892,'MARIAS',88),\r\n" + 
			"(893,'PACHAS',88),\r\n" + 
			"(894,'QUIVILLA',88),\r\n" + 
			"(895,'RIPAN',88),\r\n" + 
			"(896,'SHUNQUI',88),\r\n" + 
			"(897,'SILLAPATA',88),\r\n" + 
			"(898,'YANAS',88),\r\n" + 
			"(899,'CANCHABAMBA',89),\r\n" + 
			"(900,'COCHABAMBA',89),\r\n" + 
			"(901,'HUACAYBAMBA',89),\r\n" + 
			"(902,'PINRA',89),\r\n" + 
			"(903,'ARANCAY',90),\r\n" + 
			"(904,'CHAVIN DE PARIARCA',90),\r\n" + 
			"(905,'JACAS GRANDE',90),\r\n" + 
			"(906,'JIRCAN',90),\r\n" + 
			"(907,'LLATA',90),\r\n" + 
			"(908,'MIRAFLORES',90),\r\n" + 
			"(909,'MONZON',90),\r\n" + 
			"(910,'PUNCHAO',90),\r\n" + 
			"(911,'PUNOS',90),\r\n" + 
			"(912,'SINGA',90),\r\n" + 
			"(913,'TANTAMAYO',90),\r\n" + 
			"(914,'AMARILIS',91),\r\n" + 
			"(915,'CHINCHAO',91),\r\n" + 
			"(916,'CHURUBAMBA',91),\r\n" + 
			"(917,'HUANUCO',91),\r\n" + 
			"(918,'MARGOS',91),\r\n" + 
			"(919,'PILLCO MARCA',91),\r\n" + 
			"(920,'QUISQUI',91),\r\n" + 
			"(921,'SAN FCO DE CAYRAN',91),\r\n" + 
			"(922,'SAN PEDRO DE CHAULAN',91),\r\n" + 
			"(923,'STA MARIA DEL VALLE',91),\r\n" + 
			"(924,'YARUMAYO',91),\r\n" + 
			"(925,'BANOS',92),\r\n" + 
			"(926,'JESUS',92),\r\n" + 
			"(927,'JIVIA',92),\r\n" + 
			"(928,'QUEROPALCA',92),\r\n" + 
			"(929,'RONDOS',92),\r\n" + 
			"(930,'SAN FRANCISCO DE ASIS',92),\r\n" + 
			"(931,'SAN MIGUEL DE CAURI',92),\r\n" + 
			"(932,'DANIEL ALOMIA ROBLES',93),\r\n" + 
			"(933,'HERMILIO VALDIZAN',93),\r\n" + 
			"(934,'JOSE CRESPO Y CASTILLO',93),\r\n" + 
			"(935,'LUYANDO',93),\r\n" + 
			"(936,'MARIANO DAMASO BERAUN',93),\r\n" + 
			"(937,'RUPA RUPA',93),\r\n" + 
			"(938,'CHOLON',94),\r\n" + 
			"(939,'HUACRACHUCO',94),\r\n" + 
			"(940,'SAN BUENAVENTURA',94),\r\n" + 
			"(941,'CHAGLLA',95),\r\n" + 
			"(942,'MOLINO',95),\r\n" + 
			"(943,'PANAO',95),\r\n" + 
			"(944,'UMARI',95),\r\n" + 
			"(945,'CODO DEL POZUZO',96),\r\n" + 
			"(946,'HONORIA',96),\r\n" + 
			"(947,'PUERTO INCA',96),\r\n" + 
			"(948,'TOURNAVISTA',96),\r\n" + 
			"(949,'YUYAPICHIS',96),\r\n" + 
			"(950,'APARICIO POMARES (CHUPAN)',97),\r\n" + 
			"(951,'CAHUAC',97),\r\n" + 
			"(952,'CHACABAMBA',97),\r\n" + 
			"(953,'CHAVINILLO',97),\r\n" + 
			"(954,'CHORAS',97),\r\n" + 
			"(955,'JACAS CHICO',97),\r\n" + 
			"(956,'OBAS',97),\r\n" + 
			"(957,'PAMPAMARCA',97),\r\n" + 
			"(958,'ALTO LARAN',98),\r\n" + 
			"(959,'CHAVIN',98),\r\n" + 
			"(960,'CHINCHA ALTA',98),\r\n" + 
			"(961,'CHINCHA BAJA',98),\r\n" + 
			"(962,'EL CARMEN',98),\r\n" + 
			"(963,'GROCIO PRADO',98),\r\n" + 
			"(964,'PUEBLO NUEVO',98),\r\n" + 
			"(965,'SAN JUAN DE YANAC',98),\r\n" + 
			"(966,'SAN PEDRO DE HUACARPANA',98),\r\n" + 
			"(967,'SUNAMPE',98),\r\n" + 
			"(968,'TAMBO DE MORA',98),\r\n" + 
			"(969,'ICA',99),\r\n" + 
			"(970,'LA TINGUINA',99),\r\n" + 
			"(971,'LOS AQUIJES',99),\r\n" + 
			"(972,'OCUCAJE',99),\r\n" + 
			"(973,'PACHACUTEC',99),\r\n" + 
			"(974,'PARCONA',99),\r\n" + 
			"(975,'PUEBLO NUEVO',99),\r\n" + 
			"(976,'SALAS',99),\r\n" + 
			"(977,'SAN JOSE DE LOS MOLINOS',99),\r\n" + 
			"(978,'SAN JUAN BAUTISTA',99),\r\n" + 
			"(979,'SANTIAGO',99),\r\n" + 
			"(980,'SUBTANJALLA',99),\r\n" + 
			"(981,'TATE',99),\r\n" + 
			"(982,'YAUCA DEL ROSARIO',99),\r\n" + 
			"(983,'CHANGUILLO',100),\r\n" + 
			"(984,'EL INGENIO',100),\r\n" + 
			"(985,'MARCONA',100),\r\n" + 
			"(986,'NAZCA',100),\r\n" + 
			"(987,'VISTA ALEGRE',100),\r\n" + 
			"(988,'LLIPATA',101),\r\n" + 
			"(989,'PALPA',101),\r\n" + 
			"(990,'RIO GRANDE',101),\r\n" + 
			"(991,'SANTA CRUZ',101),\r\n" + 
			"(992,'TIBILLO',101),\r\n" + 
			"(993,'HUANCANO',102),\r\n" + 
			"(994,'HUMAY',102),\r\n" + 
			"(995,'INDEPENDENCIA',102),\r\n" + 
			"(996,'PARACAS',102),\r\n" + 
			"(997,'PISCO',102),\r\n" + 
			"(998,'SAN ANDRES',102),\r\n" + 
			"(999,'SAN CLEMENTE',102),\r\n" + 
			"(1000,'TUPAC AMARU INCA',102),\r\n" + 
			"(1001,'CHANCHAMAYO',103),\r\n" + 
			"(1002,'PERENE',103),\r\n" + 
			"(1003,'PICHANAQUI',103),\r\n" + 
			"(1004,'SAN LUIS DE SHUARO',103),\r\n" + 
			"(1005,'SAN RAMON',103),\r\n" + 
			"(1006,'VITOC',103),\r\n" + 
			"(1007,'AHUAC',104),\r\n" + 
			"(1008,'CHONGOS BAJO',104),\r\n" + 
			"(1009,'CHUPACA',104),\r\n" + 
			"(1010,'HUACHAC',104),\r\n" + 
			"(1011,'HUAMANCACA CHICO',104),\r\n" + 
			"(1012,'SAN JUAN DE ISCOS',104),\r\n" + 
			"(1013,'SAN JUAN DE JARPA',104),\r\n" + 
			"(1014,'TRES DE DICIEMBRE',104),\r\n" + 
			"(1015,'YANACANCHA',104),\r\n" + 
			"(1016,'ACO',105),\r\n" + 
			"(1017,'ANDAMARCA',105),\r\n" + 
			"(1018,'CHAMBARA',105),\r\n" + 
			"(1019,'COCHAS',105),\r\n" + 
			"(1020,'COMAS',105),\r\n" + 
			"(1021,'CONCEPCION',105),\r\n" + 
			"(1022,'HEROINAS TOLEDO',105),\r\n" + 
			"(1023,'MANZANARES',105),\r\n" + 
			"(1024,'MATAHUASI',105),\r\n" + 
			"(1025,'MCAL CASTILLA',105),\r\n" + 
			"(1026,'MITO',105),\r\n" + 
			"(1027,'NUEVE DE JULIO',105),\r\n" + 
			"(1028,'ORCOTUNA',105),\r\n" + 
			"(1029,'SAN JOSE DE QUERO',105),\r\n" + 
			"(1030,'STA ROSA DE OCOPA',105),\r\n" + 
			"(1031,'CARHUACALLANGA',106),\r\n" + 
			"(1032,'CHACAPAMPA',106),\r\n" + 
			"(1033,'CHICCHE',106),\r\n" + 
			"(1034,'CHILCA',106),\r\n" + 
			"(1035,'CHONGOS ALTO',106),\r\n" + 
			"(1036,'CHUPURO',106),\r\n" + 
			"(1037,'COLCA',106),\r\n" + 
			"(1038,'CULLHUAS',106),\r\n" + 
			"(1039,'EL TAMBO',106),\r\n" + 
			"(1040,'HUACRAPUQUIO',106),\r\n" + 
			"(1041,'HUALHUAS',106),\r\n" + 
			"(1042,'HUANCAN',106),\r\n" + 
			"(1043,'HUANCAYO',106),\r\n" + 
			"(1044,'HUASICANCHA',106),\r\n" + 
			"(1045,'HUAYUCACHI',106),\r\n" + 
			"(1046,'INGENIO',106),\r\n" + 
			"(1047,'PARIAHUANCA',106),\r\n" + 
			"(1048,'PILCOMAYO',106),\r\n" + 
			"(1049,'PUCARA',106),\r\n" + 
			"(1050,'QUICHUAY',106),\r\n" + 
			"(1051,'QUILCAS',106),\r\n" + 
			"(1052,'SAN AGUSTIN',106),\r\n" + 
			"(1053,'SAN JERONIMO DE TUNAN',106),\r\n" + 
			"(1054,'SANO',106),\r\n" + 
			"(1055,'SAPALLANGA',106),\r\n" + 
			"(1056,'SICAYA',106),\r\n" + 
			"(1057,'STO DOMINGO DE ACOBAMBA',106),\r\n" + 
			"(1058,'VIQUES',106),\r\n" + 
			"(1059,'ACOLLA',107),\r\n" + 
			"(1060,'APATA',107),\r\n" + 
			"(1061,'ATAURA',107),\r\n" + 
			"(1062,'CANCHAILLO',107),\r\n" + 
			"(1063,'CURICACA',107),\r\n" + 
			"(1064,'EL MANTARO',107),\r\n" + 
			"(1065,'HUAMALI',107),\r\n" + 
			"(1066,'HUARIPAMPA',107),\r\n" + 
			"(1067,'HUERTAS',107),\r\n" + 
			"(1068,'JANJAILLO',107),\r\n" + 
			"(1069,'JAUJA',107),\r\n" + 
			"(1070,'JULCAN',107),\r\n" + 
			"(1071,'LEONOR ORDONEZ',107),\r\n" + 
			"(1072,'LLOCLLAPAMPA',107),\r\n" + 
			"(1073,'MARCO',107),\r\n" + 
			"(1074,'MASMA',107),\r\n" + 
			"(1075,'MASMA CHICCHE',107),\r\n" + 
			"(1076,'MOLINOS',107),\r\n" + 
			"(1077,'MONOBAMBA',107),\r\n" + 
			"(1078,'MUQUI',107),\r\n" + 
			"(1079,'MUQUIYAUYO',107),\r\n" + 
			"(1080,'PACA',107),\r\n" + 
			"(1081,'PACCHA',107),\r\n" + 
			"(1082,'PANCAN',107),\r\n" + 
			"(1083,'PARCO',107),\r\n" + 
			"(1084,'POMACANCHA',107),\r\n" + 
			"(1085,'RICRAN',107),\r\n" + 
			"(1086,'SAN LORENZO',107),\r\n" + 
			"(1087,'SAN PEDRO DE CHUNAN',107),\r\n" + 
			"(1088,'SAUSA',107),\r\n" + 
			"(1089,'SINCOS',107),\r\n" + 
			"(1090,'TUNAN MARCA',107),\r\n" + 
			"(1091,'YAULI',107),\r\n" + 
			"(1092,'YAUYOS',107),\r\n" + 
			"(1093,'CARHUAMAYO',108),\r\n" + 
			"(1094,'JUNIN',108),\r\n" + 
			"(1095,'ONDORES',108),\r\n" + 
			"(1096,'ULCUMAYO',108),\r\n" + 
			"(1097,'COVIRIALI',109),\r\n" + 
			"(1098,'LLAYLLA',109),\r\n" + 
			"(1099,'MAZAMARI',109),\r\n" + 
			"(1100,'PAMPA HERMOSA',109),\r\n" + 
			"(1101,'PANGOA',109),\r\n" + 
			"(1102,'RIO NEGRO',109),\r\n" + 
			"(1103,'RIO TAMBO',109),\r\n" + 
			"(1104,'SATIPO',109),\r\n" + 
			"(1105,'ACOBAMBA',110),\r\n" + 
			"(1106,'HUARICOLCA',110),\r\n" + 
			"(1107,'HUASAHUASI',110),\r\n" + 
			"(1108,'LA UNION',110),\r\n" + 
			"(1109,'PALCA',110),\r\n" + 
			"(1110,'PALCAMAYO',110),\r\n" + 
			"(1111,'SAN PEDRO DE CAJAS',110),\r\n" + 
			"(1112,'TAPO',110),\r\n" + 
			"(1113,'TARMA',110),\r\n" + 
			"(1114,'CHACAPALPA',111),\r\n" + 
			"(1115,'HUAY HUAY',111),\r\n" + 
			"(1116,'LA OROYA',111),\r\n" + 
			"(1117,'MARCAPOMACOCHA',111),\r\n" + 
			"(1118,'MOROCOCHA',111),\r\n" + 
			"(1119,'PACCHA',111),\r\n" + 
			"(1120,'STA BARBARA DE CARHUACAYAN',111),\r\n" + 
			"(1121,'STA ROSA DE SACCO',111),\r\n" + 
			"(1122,'SUITUCANCHA',111),\r\n" + 
			"(1123,'YAULI',111),\r\n" + 
			"(1124,'ASCOPE',112),\r\n" + 
			"(1125,'CASA GRANDE',112),\r\n" + 
			"(1126,'CHICAMA',112),\r\n" + 
			"(1127,'CHOCOPE',112),\r\n" + 
			"(1128,'MAGDALENA DE CAO',112),\r\n" + 
			"(1129,'PAIJAN',112),\r\n" + 
			"(1130,'RAZURI',112),\r\n" + 
			"(1131,'SANTIAGO DE CAO',112),\r\n" + 
			"(1132,'BAMBAMARCA',113),\r\n" + 
			"(1133,'BOLIVAR',113),\r\n" + 
			"(1134,'CONDORMARCA',113),\r\n" + 
			"(1135,'LONGOTEA',113),\r\n" + 
			"(1136,'UCHUMARCA',113),\r\n" + 
			"(1137,'UCUNCHA',113),\r\n" + 
			"(1138,'CHEPEN',114),\r\n" + 
			"(1139,'PACANGA',114),\r\n" + 
			"(1140,'PUEBLO NUEVO',114),\r\n" + 
			"(1141,'CASCAS',115),\r\n" + 
			"(1142,'LUCMA',115),\r\n" + 
			"(1143,'MARMOT',115),\r\n" + 
			"(1144,'SAYAPULLO',115),\r\n" + 
			"(1145,'CALAMARCA',116),\r\n" + 
			"(1146,'CARABAMBA',116),\r\n" + 
			"(1147,'HUASO',116),\r\n" + 
			"(1148,'JULCAN',116),\r\n" + 
			"(1149,'AGALLPAMPA',117),\r\n" + 
			"(1150,'CHARAT',117),\r\n" + 
			"(1151,'HUARANCHAL',117),\r\n" + 
			"(1152,'LA CUESTA',117),\r\n" + 
			"(1153,'MACHE',117),\r\n" + 
			"(1154,'OTUZCO',117),\r\n" + 
			"(1155,'PARANDAY',117),\r\n" + 
			"(1156,'SALPO',117),\r\n" + 
			"(1157,'SINSICAP',117),\r\n" + 
			"(1158,'USQUIL',117),\r\n" + 
			"(1159,'GUADALUPE',118),\r\n" + 
			"(1160,'JEQUETEPEQUE',118),\r\n" + 
			"(1161,'PACASMAYO',118),\r\n" + 
			"(1162,'SAN JOSE',118),\r\n" + 
			"(1163,'SAN PEDRO DE LLOC',118),\r\n" + 
			"(1164,'BULDIBUYO',119),\r\n" + 
			"(1165,'CHILLIA',119),\r\n" + 
			"(1166,'HUANCASPATA',119),\r\n" + 
			"(1167,'HUAYLILLAS',119),\r\n" + 
			"(1168,'HUAYO',119),\r\n" + 
			"(1169,'ONGON',119),\r\n" + 
			"(1170,'PARCOY',119),\r\n" + 
			"(1171,'PATAZ',119),\r\n" + 
			"(1172,'PIAS',119),\r\n" + 
			"(1173,'SANTIAGO DE CHALLAS',119),\r\n" + 
			"(1174,'TAURIJA',119),\r\n" + 
			"(1175,'TAYABAMBA',119),\r\n" + 
			"(1176,'URPAY',119),\r\n" + 
			"(1177,'CHUGAY',120),\r\n" + 
			"(1178,'COCHORCO',120),\r\n" + 
			"(1179,'CURGOS',120),\r\n" + 
			"(1180,'HUAMACHUCO',120),\r\n" + 
			"(1181,'MARCABAL',120),\r\n" + 
			"(1182,'SANAGORAN',120),\r\n" + 
			"(1183,'SARIN',120),\r\n" + 
			"(1184,'SARTIMBAMBA',120),\r\n" + 
			"(1185,'ANGASMARCA',121),\r\n" + 
			"(1186,'CACHICADAN',121),\r\n" + 
			"(1187,'MOLLEBAMBA',121),\r\n" + 
			"(1188,'MOLLEPATA',121),\r\n" + 
			"(1189,'QUIRUVILCA',121),\r\n" + 
			"(1190,'SANTA CRUZ DE CHUCA',121),\r\n" + 
			"(1191,'SANTIAGO DE CHUCO',121),\r\n" + 
			"(1192,'SITABAMBA',121),\r\n" + 
			"(1193,'EL PORVENIR',122),\r\n" + 
			"(1194,'FLORENCIA DE MORA',122),\r\n" + 
			"(1195,'HUANCHACO',122),\r\n" + 
			"(1196,'LA ESPERANZA',122),\r\n" + 
			"(1197,'LAREDO',122),\r\n" + 
			"(1198,'MOCHE',122),\r\n" + 
			"(1199,'POROTO',122),\r\n" + 
			"(1200,'SALAVERRY',122),\r\n" + 
			"(1201,'SIMBAL',122),\r\n" + 
			"(1202,'TRUJILLO',122),\r\n" + 
			"(1203,'VICTOR LARCO HERRERA',122),\r\n" + 
			"(1204,'CHAO',123),\r\n" + 
			"(1205,'GUADALUPITO',123),\r\n" + 
			"(1206,'VIRU',123),\r\n" + 
			"(1207,'CAYALTI',124),\r\n" + 
			"(1208,'CHICLAYO',124),\r\n" + 
			"(1209,'CHONGOYAPE',124),\r\n" + 
			"(1210,'ETEN',124),\r\n" + 
			"(1211,'ETEN PUERTO',124),\r\n" + 
			"(1212,'JOSE LEONARDO ORTIZ',124),\r\n" + 
			"(1213,'LA VICTORIA',124),\r\n" + 
			"(1214,'LAGUNAS',124),\r\n" + 
			"(1215,'MONSEFU',124),\r\n" + 
			"(1216,'NUEVA ARICA',124),\r\n" + 
			"(1217,'OYOTUN',124),\r\n" + 
			"(1218,'PATAPO',124),\r\n" + 
			"(1219,'PICSI',124),\r\n" + 
			"(1220,'PIMENTEL',124),\r\n" + 
			"(1221,'POMALCA',124),\r\n" + 
			"(1222,'PUCALA',124),\r\n" + 
			"(1223,'REQUE',124),\r\n" + 
			"(1224,'SANA',124),\r\n" + 
			"(1225,'SANTA ROSA',124),\r\n" + 
			"(1226,'TUMAN',124),\r\n" + 
			"(1227,'CANARIS',125),\r\n" + 
			"(1228,'FERRENAFE',125),\r\n" + 
			"(1229,'INCAHUASI',125),\r\n" + 
			"(1230,'MANUEL ANTONIO MESONES MURO',125),\r\n" + 
			"(1231,'PITIPO',125),\r\n" + 
			"(1232,'PUEBLO NUEVO',125),\r\n" + 
			"(1233,'CHOCHOPE',126),\r\n" + 
			"(1234,'ILLIMO',126),\r\n" + 
			"(1235,'JAYANCA',126),\r\n" + 
			"(1236,'LAMBAYEQUE',126),\r\n" + 
			"(1237,'MOCHUMI',126),\r\n" + 
			"(1238,'MORROPE',126),\r\n" + 
			"(1239,'MOTUPE',126),\r\n" + 
			"(1240,'OLMOS',126),\r\n" + 
			"(1241,'PACORA',126),\r\n" + 
			"(1242,'SALAS',126),\r\n" + 
			"(1243,'SAN JOSE',126),\r\n" + 
			"(1244,'TUCUME',126),\r\n" + 
			"(1245,'BARRANCA',127),\r\n" + 
			"(1246,'PARAMONGA',127),\r\n" + 
			"(1247,'PATIVILCA',127),\r\n" + 
			"(1248,'SUPE',127),\r\n" + 
			"(1249,'SUPE PUERTO',127),\r\n" + 
			"(1250,'CAJATAMBO',128),\r\n" + 
			"(1251,'COPA',128),\r\n" + 
			"(1252,'GORGOR',128),\r\n" + 
			"(1253,'HUANCAPON',128),\r\n" + 
			"(1254,'MANAS',128),\r\n" + 
			"(1255,'ASIA',129),\r\n" + 
			"(1256,'CALANGO',129),\r\n" + 
			"(1257,'CERRO AZUL',129),\r\n" + 
			"(1258,'CHILCA',129),\r\n" + 
			"(1259,'COAYLLO',129),\r\n" + 
			"(1260,'IMPERIAL',129),\r\n" + 
			"(1261,'LUNAHUANA',129),\r\n" + 
			"(1262,'MALA',129),\r\n" + 
			"(1263,'NUEVO IMPERIAL',129),\r\n" + 
			"(1264,'PACARAN',129),\r\n" + 
			"(1265,'QUILMANA',129),\r\n" + 
			"(1266,'SAN ANTONIO',129),\r\n" + 
			"(1267,'SAN LUIS',129),\r\n" + 
			"(1268,'SAN VICENTE DE CANETE',129),\r\n" + 
			"(1269,'SANTA CRUZ DE FLORES',129),\r\n" + 
			"(1270,'ZUNIGA',129),\r\n" + 
			"(1271,'ARAHUAY',130),\r\n" + 
			"(1272,'CANTA',130),\r\n" + 
			"(1273,'HUAMANTANGA',130),\r\n" + 
			"(1274,'HUAROS',130),\r\n" + 
			"(1275,'LACHAQUI',130),\r\n" + 
			"(1276,'SAN BUENAVENTURA',130),\r\n" + 
			"(1277,'SANTA ROSA DE QUIVES',130),\r\n" + 
			"(1278,'ATAVILLOS ALTO',131),\r\n" + 
			"(1279,'ATAVILLOS BAJO',131),\r\n" + 
			"(1280,'AUCALLAMA',131),\r\n" + 
			"(1281,'CHANCAY',131),\r\n" + 
			"(1282,'HUARAL',131),\r\n" + 
			"(1283,'IHUARI',131),\r\n" + 
			"(1284,'LAMPIAN',131),\r\n" + 
			"(1285,'PACARAOS',131),\r\n" + 
			"(1286,'SAN MIGUEL DE ACOS',131),\r\n" + 
			"(1287,'STA CRUZ DE ANDAMARCA',131),\r\n" + 
			"(1288,'SUMBILCA',131),\r\n" + 
			"(1289,'VEINTISIETE DE NOVIEMBRE',131),\r\n" + 
			"(1290,'ANTIOQUIA',132),\r\n" + 
			"(1291,'CALLAHUANCA',132),\r\n" + 
			"(1292,'CARAMPOMA',132),\r\n" + 
			"(1293,'CASTA',132),\r\n" + 
			"(1294,'CHICLA',132),\r\n" + 
			"(1295,'CUENCA',132),\r\n" + 
			"(1296,'HUACHUPAMPA',132),\r\n" + 
			"(1297,'HUANZA',132),\r\n" + 
			"(1298,'HUAROCHIRI',132),\r\n" + 
			"(1299,'LAHUAYTAMBO',132),\r\n" + 
			"(1300,'LANGA',132),\r\n" + 
			"(1301,'LARAOS',132),\r\n" + 
			"(1302,'MARIATANA',132),\r\n" + 
			"(1303,'MATUCANA',132),\r\n" + 
			"(1304,'RICARDO PALMA',132),\r\n" + 
			"(1305,'SAN ANDRES DE TUPICOCHA',132),\r\n" + 
			"(1306,'SAN ANTONIO',132),\r\n" + 
			"(1307,'SAN BARTOLOME',132),\r\n" + 
			"(1308,'SAN DAMIAN',132),\r\n" + 
			"(1309,'SAN JUAN DE IRIS',132),\r\n" + 
			"(1310,'SAN JUAN DE TANTARANCHE',132),\r\n" + 
			"(1311,'SAN LORENZO DE QUINTI',132),\r\n" + 
			"(1312,'SAN MATEO',132),\r\n" + 
			"(1313,'SAN MATEO DE OTAO',132),\r\n" + 
			"(1314,'SAN PEDRO DE HUANCAYRE',132),\r\n" + 
			"(1315,'SAN PEDRO DE HUANCAYRE',132),\r\n" + 
			"(1316,'SANGALLAYA',132),\r\n" + 
			"(1317,'SANTA CRUZ DE COCACHACRA',132),\r\n" + 
			"(1318,'SANTA EULALIA',132),\r\n" + 
			"(1319,'SANTIAGO DE ANCHUCAYA',132),\r\n" + 
			"(1320,'SANTIAGO DE TUNA',132),\r\n" + 
			"(1321,'SURCO',132),\r\n" + 
			"(1322,'AMBAR',133),\r\n" + 
			"(1323,'CALETA DE CARQUIN',133),\r\n" + 
			"(1324,'CHECRAS',133),\r\n" + 
			"(1325,'HUACHO',133),\r\n" + 
			"(1326,'HUALMAY',133),\r\n" + 
			"(1327,'HUAURA',133),\r\n" + 
			"(1328,'LEONCIO PRADO',133),\r\n" + 
			"(1329,'PACCHO',133),\r\n" + 
			"(1330,'SANTA LEONOR',133),\r\n" + 
			"(1331,'SANTA MARIA',133),\r\n" + 
			"(1332,'SAYAN',133),\r\n" + 
			"(1333,'VEGUETA',133),\r\n" + 
			"(1334,'ANCON',134),\r\n" + 
			"(1335,'ATE',134),\r\n" + 
			"(1336,'BARRANCO',134),\r\n" + 
			"(1337,'BRENA',134),\r\n" + 
			"(1338,'CARABAYLLO',134),\r\n" + 
			"(1339,'CHACLACAYO',134),\r\n" + 
			"(1340,'CHORRILLOS',134),\r\n" + 
			"(1341,'CIENEGUILLA',134),\r\n" + 
			"(1342,'COMAS',134),\r\n" + 
			"(1343,'EL AGUSTINO',134),\r\n" + 
			"(1344,'INDEPENDENCIA',134),\r\n" + 
			"(1345,'JESUS MARIA',134),\r\n" + 
			"(1346,'LA MOLINA',134),\r\n" + 
			"(1347,'LA VICTORIA',134),\r\n" + 
			"(1348,'LIMA',134),\r\n" + 
			"(1349,'LINCE',134),\r\n" + 
			"(1350,'LOS OLIVOS',134),\r\n" + 
			"(1351,'LURIGANCHO',134),\r\n" + 
			"(1352,'LURIN',134),\r\n" + 
			"(1353,'MAGDALENA DEL MAR',134),\r\n" + 
			"(1354,'MIRAFLORES',134),\r\n" + 
			"(1355,'PACHACAMAC',134),\r\n" + 
			"(1356,'PUCUSANA',134),\r\n" + 
			"(1357,'PUEBLO LIBRE',134),\r\n" + 
			"(1358,'PUENTE PIEDRA',134),\r\n" + 
			"(1359,'PUNTA HERMOSA',134),\r\n" + 
			"(1360,'PUNTA NEGRA',134),\r\n" + 
			"(1361,'RIMAC',134),\r\n" + 
			"(1362,'SAN BARTOLO',134),\r\n" + 
			"(1363,'SAN BORJA',134),\r\n" + 
			"(1364,'SAN ISIDRO',134),\r\n" + 
			"(1365,'SAN JUAN DE LURIGANCHO',134),\r\n" + 
			"(1366,'SAN JUAN DE MIRAFLORES',134),\r\n" + 
			"(1367,'SAN LUIS',134),\r\n" + 
			"(1368,'SAN MIGUEL',134),\r\n" + 
			"(1369,'SANTA ANITA',134),\r\n" + 
			"(1370,'SANTA ROSA',134),\r\n" + 
			"(1371,'SANTIAGO DE SURCO',134),\r\n" + 
			"(1372,'STA MARIA DEL MAR',134),\r\n" + 
			"(1373,'SURQUILLO',134),\r\n" + 
			"(1374,'VILLA EL SALVADOR',134),\r\n" + 
			"(1375,'ANDAJES',135),\r\n" + 
			"(1376,'CAUJUL',135),\r\n" + 
			"(1377,'COCHAMARCA',135),\r\n" + 
			"(1378,'NAVAN',135),\r\n" + 
			"(1379,'OYON',135),\r\n" + 
			"(1380,'PACHANGARA',135),\r\n" + 
			"(1381,'ALIS',136),\r\n" + 
			"(1382,'AYAUCA',136),\r\n" + 
			"(1383,'AYAVIRI',136),\r\n" + 
			"(1384,'AZANGARO',136),\r\n" + 
			"(1385,'CACRA',136),\r\n" + 
			"(1386,'CARANIA',136),\r\n" + 
			"(1387,'CATAHUASI',136),\r\n" + 
			"(1388,'CHOCOS',136),\r\n" + 
			"(1389,'COCHAS',136),\r\n" + 
			"(1390,'COLONIA',136),\r\n" + 
			"(1391,'HONGOS',136),\r\n" + 
			"(1392,'HUAMPARA',136),\r\n" + 
			"(1393,'HUANCAYA',136),\r\n" + 
			"(1394,'HUANEC',136),\r\n" + 
			"(1395,'HUANGASCAR',136),\r\n" + 
			"(1396,'HUANTAN',136),\r\n" + 
			"(1397,'LARAOS',136),\r\n" + 
			"(1398,'LINCHA',136),\r\n" + 
			"(1399,'MADEAN',136),\r\n" + 
			"(1400,'MIRAFLORES',136),\r\n" + 
			"(1401,'OMAS',136),\r\n" + 
			"(1402,'PUTINZA',136),\r\n" + 
			"(1403,'QUINCHES',136),\r\n" + 
			"(1404,'QUINOCAY',136),\r\n" + 
			"(1405,'SAN JOAQUIN',136),\r\n" + 
			"(1406,'SAN PEDRO DE PILAS',136),\r\n" + 
			"(1407,'TANTA',136),\r\n" + 
			"(1408,'TAURIPAMPA',136),\r\n" + 
			"(1409,'TOMAS',136),\r\n" + 
			"(1410,'TUPE',136),\r\n" + 
			"(1411,'VINAC',136),\r\n" + 
			"(1412,'VITIS',136),\r\n" + 
			"(1413,'YAUYOS',136),\r\n" + 
			"(1414,'BALSAPUERTO',137),\r\n" + 
			"(1415,'JEBEROS',137),\r\n" + 
			"(1416,'LAGUNAS',137),\r\n" + 
			"(1417,'SANTA CRUZ',137),\r\n" + 
			"(1418,'TNTE CESAR LOPEZ ROJAS',137),\r\n" + 
			"(1419,'YURIMAGUAS',137),\r\n" + 
			"(1420,'ANDOAS',138),\r\n" + 
			"(1421,'BARRANCA',138),\r\n" + 
			"(1422,'CAHUAPANAS',138),\r\n" + 
			"(1423,'MANSERICHE',138),\r\n" + 
			"(1424,'MORONA',138),\r\n" + 
			"(1425,'PASTAZA',138),\r\n" + 
			"(1426,'NAUTA',139),\r\n" + 
			"(1427,'PARINARI',139),\r\n" + 
			"(1428,'TIGRE',139),\r\n" + 
			"(1429,'TROMPETEROS',139),\r\n" + 
			"(1430,'URARINAS',139),\r\n" + 
			"(1431,'MARISCAL RAMON CASTILLA',140),\r\n" + 
			"(1432,'PEBAS',140),\r\n" + 
			"(1433,'SAN PABLO',140),\r\n" + 
			"(1434,'YAVARI',140),\r\n" + 
			"(1435,'ALTO NANAY',141),\r\n" + 
			"(1436,'BELEN',141),\r\n" + 
			"(1437,'FERNANDO LORES',141),\r\n" + 
			"(1438,'INDIANA',141),\r\n" + 
			"(1439,'IQUITOS',141),\r\n" + 
			"(1440,'LAS AMAZONAS',141),\r\n" + 
			"(1441,'MAZAN',141),\r\n" + 
			"(1442,'NAPO',141),\r\n" + 
			"(1443,'PUNCHANA',141),\r\n" + 
			"(1444,'PUTUMAYO',141),\r\n" + 
			"(1445,'SAN JUAN BAUTISTA',141),\r\n" + 
			"(1446,'TNTE MANUEL CLAVERO',141),\r\n" + 
			"(1447,'TORRES CAUSANA',141),\r\n" + 
			"(1448,'ALTO TAPICHE',142),\r\n" + 
			"(1449,'CAPELO',142),\r\n" + 
			"(1450,'EMILIO SAN MARTIN',142),\r\n" + 
			"(1451,'JENARO HERRERA',142),\r\n" + 
			"(1452,'MAQUIA',142),\r\n" + 
			"(1453,'PUINAHUA',142),\r\n" + 
			"(1454,'REQUENA',142),\r\n" + 
			"(1455,'SAQUENA',142),\r\n" + 
			"(1456,'SOPLIN',142),\r\n" + 
			"(1457,'TAPICHE',142),\r\n" + 
			"(1458,'YAQUERANA',142),\r\n" + 
			"(1459,'CONTAMANA',143),\r\n" + 
			"(1460,'INAHUAYA',143),\r\n" + 
			"(1461,'PADRE MARQUEZ',143),\r\n" + 
			"(1462,'PAMPA HERMOZA',143),\r\n" + 
			"(1463,'SARAYACU',143),\r\n" + 
			"(1464,'VARGAS GUERRA',143),\r\n" + 
			"(1465,'FITZCARRALD',144),\r\n" + 
			"(1466,'HUEPETUHE',144),\r\n" + 
			"(1467,'MADRE DE DIOS',144),\r\n" + 
			"(1468,'MANU',144),\r\n" + 
			"(1469,'IBERIA',145),\r\n" + 
			"(1470,'INAPARI',145),\r\n" + 
			"(1471,'TAHUAMANU',145),\r\n" + 
			"(1472,'INAMBARI',146),\r\n" + 
			"(1473,'LABERINTO',146),\r\n" + 
			"(1474,'LAS PIEDRAS',146),\r\n" + 
			"(1475,'TAMBOPATA',146),\r\n" + 
			"(1476,'CHOJATA',147),\r\n" + 
			"(1477,'COALAQUE',147),\r\n" + 
			"(1478,'ICHUNA',147),\r\n" + 
			"(1479,'LA CAPILLA',147),\r\n" + 
			"(1480,'LLOQUE',147),\r\n" + 
			"(1481,'MATALAQUE',147),\r\n" + 
			"(1482,'OMATE',147),\r\n" + 
			"(1483,'PUQUINA',147),\r\n" + 
			"(1484,'QUINISTAQUILLAS',147),\r\n" + 
			"(1485,'UBINAS',147),\r\n" + 
			"(1486,'YUNGA',147),\r\n" + 
			"(1487,'EL ALGARROBAL',148),\r\n" + 
			"(1488,'ILO',148),\r\n" + 
			"(1489,'PACOCHA',148),\r\n" + 
			"(1490,'CARUMAS',149),\r\n" + 
			"(1491,'CUCHUMBAYA',149),\r\n" + 
			"(1492,'MOQUEGUA',149),\r\n" + 
			"(1493,'SAMEGUA',149),\r\n" + 
			"(1494,'SAN CRISTOBAL',149),\r\n" + 
			"(1495,'TORATA',149),\r\n" + 
			"(1496,'CHACAYAN',150),\r\n" + 
			"(1497,'GOYLLARISQUIZGA',150),\r\n" + 
			"(1498,'PAUCAR',150),\r\n" + 
			"(1499,'SAN PEDRO DE PILLAO',150),\r\n" + 
			"(1500,'SANTA ANA DE TUSI',150),\r\n" + 
			"(1501,'TAPUC',150),\r\n" + 
			"(1502,'VILCABAMBA',150),\r\n" + 
			"(1503,'YANAHUANCA',150),\r\n" + 
			"(1504,'CHONTABAMBA',151),\r\n" + 
			"(1505,'HUANCABAMBA',151),\r\n" + 
			"(1506,'OXAPAMPA',151),\r\n" + 
			"(1507,'PALCAZU',151),\r\n" + 
			"(1508,'POZUZO',151),\r\n" + 
			"(1509,'PUERTO BERMUDEZ',151),\r\n" + 
			"(1510,'VILLA RICA',151),\r\n" + 
			"(1511,'CHAUPIMARCA',152),\r\n" + 
			"(1512,'HUACHON',152),\r\n" + 
			"(1513,'HUARIACA',152),\r\n" + 
			"(1514,'HUAYLLAY',152),\r\n" + 
			"(1515,'NINACACA',152),\r\n" + 
			"(1516,'PALLANCHACRA',152),\r\n" + 
			"(1517,'PAUCARTAMBO',152),\r\n" + 
			"(1518,'SAN FCO DE ASIS DE YARUSYACAN',152),\r\n" + 
			"(1519,'SIMON BOLIVAR',152),\r\n" + 
			"(1520,'TICLACAYAN',152),\r\n" + 
			"(1521,'TINYAHUARCO',152),\r\n" + 
			"(1522,'VICCO',152),\r\n" + 
			"(1523,'YANACANCHA',152),\r\n" + 
			"(1524,'AYABACA',153),\r\n" + 
			"(1525,'FRIAS',153),\r\n" + 
			"(1526,'JILILI',153),\r\n" + 
			"(1527,'LAGUNAS',153),\r\n" + 
			"(1528,'MONTERO',153),\r\n" + 
			"(1529,'PACAIPAMPA',153),\r\n" + 
			"(1530,'PAIMAS',153),\r\n" + 
			"(1531,'SAPILLICA',153),\r\n" + 
			"(1532,'SICCHEZ',153),\r\n" + 
			"(1533,'SUYO',153),\r\n" + 
			"(1534,'CANCHAQUE',154),\r\n" + 
			"(1535,'EL CARMEN DE LA FRONTERA',154),\r\n" + 
			"(1536,'HUANCABAMBA',154),\r\n" + 
			"(1537,'HUARMACA',154),\r\n" + 
			"(1538,'LALAQUIZ',154),\r\n" + 
			"(1539,'SAN MIGUEL DE EL FAIQUE',154),\r\n" + 
			"(1540,'SONDOR',154),\r\n" + 
			"(1541,'SONDORILLO',154),\r\n" + 
			"(1542,'BUENOS AIRES',155),\r\n" + 
			"(1543,'CHALACO',155),\r\n" + 
			"(1544,'CHULUCANAS',155),\r\n" + 
			"(1545,'LA MATANZA',155),\r\n" + 
			"(1546,'MORROPON',155),\r\n" + 
			"(1547,'SALITRAL',155),\r\n" + 
			"(1548,'SAN JUAN DE BIGOTE',155),\r\n" + 
			"(1549,'SANTA CATALINA DE MOSSA',155),\r\n" + 
			"(1550,'SANTO DOMINGO',155),\r\n" + 
			"(1551,'YAMANGO',155),\r\n" + 
			"(1552,'AMOTAPE',156),\r\n" + 
			"(1553,'ARENAL',156),\r\n" + 
			"(1554,'LA HUACA',156),\r\n" + 
			"(1555,'PAITA',156),\r\n" + 
			"(1556,'PUEBLO NUEVO DE COLAN',156),\r\n" + 
			"(1557,'TAMARINDO',156),\r\n" + 
			"(1558,'VICHAYAL',156),\r\n" + 
			"(1559,'CASTILLA',157),\r\n" + 
			"(1560,'CATACAOS',157),\r\n" + 
			"(1561,'CURA MORI',157),\r\n" + 
			"(1562,'EL TALLAN',157),\r\n" + 
			"(1563,'LA ARENA',157),\r\n" + 
			"(1564,'LA UNION',157),\r\n" + 
			"(1565,'LAS LOMAS',157),\r\n" + 
			"(1566,'PIURA',157),\r\n" + 
			"(1567,'TAMBO GRANDE',157),\r\n" + 
			"(1568,'BELLAVISTA DE LA UNION',158),\r\n" + 
			"(1569,'BERNAL',158),\r\n" + 
			"(1570,'CRISTO NOS VALGA',158),\r\n" + 
			"(1571,'RINCONADA LLICUAR',158),\r\n" + 
			"(1572,'SECHURA',158),\r\n" + 
			"(1573,'VICE',158),\r\n" + 
			"(1574,'BELLAVISTA',159),\r\n" + 
			"(1575,'IGNACIO ESCUDERO',159),\r\n" + 
			"(1576,'LANCONES',159),\r\n" + 
			"(1577,'MARCAVELICA',159),\r\n" + 
			"(1578,'MIGUEL CHECA',159),\r\n" + 
			"(1579,'QUERECOTILLO',159),\r\n" + 
			"(1580,'SALITRAL',159),\r\n" + 
			"(1581,'SULLANA',159),\r\n" + 
			"(1582,'EL ALTO',160),\r\n" + 
			"(1583,'LA BREA',160),\r\n" + 
			"(1584,'LOBITOS',160),\r\n" + 
			"(1585,'LOS ORGANOS',160),\r\n" + 
			"(1586,'MANCORA',160),\r\n" + 
			"(1587,'PARINAS',160),\r\n" + 
			"(1588,'ACHAYA',161),\r\n" + 
			"(1589,'ARAPA',161),\r\n" + 
			"(1590,'ASILLO',161),\r\n" + 
			"(1591,'AZANGARO',161),\r\n" + 
			"(1592,'CAMINACA',161),\r\n" + 
			"(1593,'CHUPA',161),\r\n" + 
			"(1594,'JOSE DOMINGO CHOQUEHUANCA',161),\r\n" + 
			"(1595,'MUNANI',161),\r\n" + 
			"(1596,'POTONI',161),\r\n" + 
			"(1597,'SAMAN',161),\r\n" + 
			"(1598,'SAN ANTON',161),\r\n" + 
			"(1599,'SAN JOSE',161),\r\n" + 
			"(1600,'SAN JUAN DE SALINAS',161),\r\n" + 
			"(1601,'STGO DE PUPUJA',161),\r\n" + 
			"(1602,'TIRAPATA',161),\r\n" + 
			"(1603,'AJOYANI',162),\r\n" + 
			"(1604,'AYAPATA',162),\r\n" + 
			"(1605,'COASA',162),\r\n" + 
			"(1606,'CORANI',162),\r\n" + 
			"(1607,'CRUCERO',162),\r\n" + 
			"(1608,'ITUATA',162),\r\n" + 
			"(1609,'MACUSANI',162),\r\n" + 
			"(1610,'OLLACHEA',162),\r\n" + 
			"(1611,'SAN GABAN',162),\r\n" + 
			"(1612,'USICAYOS',162),\r\n" + 
			"(1613,'DESAGUADERO',163),\r\n" + 
			"(1614,'HUACULLANI',163),\r\n" + 
			"(1615,'JULI',163),\r\n" + 
			"(1616,'KELLUYO',163),\r\n" + 
			"(1617,'PISACOMA',163),\r\n" + 
			"(1618,'POMATA',163),\r\n" + 
			"(1619,'ZEPITA',163),\r\n" + 
			"(1620,'CAPASO',164),\r\n" + 
			"(1621,'CONDURIRI',164),\r\n" + 
			"(1622,'ILAVE',164),\r\n" + 
			"(1623,'PILCUYO',164),\r\n" + 
			"(1624,'SANTA ROSA',164),\r\n" + 
			"(1625,'COJATA',165),\r\n" + 
			"(1626,'HUANCANE',165),\r\n" + 
			"(1627,'HUATASANI',165),\r\n" + 
			"(1628,'INCHUPALLA',165),\r\n" + 
			"(1629,'PUSI',165),\r\n" + 
			"(1630,'ROSASPATA',165),\r\n" + 
			"(1631,'TARACO',165),\r\n" + 
			"(1632,'VILQUE CHICO',165),\r\n" + 
			"(1633,'CABANILLA',166),\r\n" + 
			"(1634,'CALAPUJA',166),\r\n" + 
			"(1635,'LAMPA',166),\r\n" + 
			"(1636,'NICASIO',166),\r\n" + 
			"(1637,'OCUVIRI',166),\r\n" + 
			"(1638,'PALCA',166),\r\n" + 
			"(1639,'PARATIA',166),\r\n" + 
			"(1640,'PUCARA',166),\r\n" + 
			"(1641,'SANTA LUCIA',166),\r\n" + 
			"(1642,'VILAVILA',166),\r\n" + 
			"(1643,'ANTAUTA',167),\r\n" + 
			"(1644,'AYAVIRI',167),\r\n" + 
			"(1645,'CUPI',167),\r\n" + 
			"(1646,'LLALLI',167),\r\n" + 
			"(1647,'MACARI',167),\r\n" + 
			"(1648,'NUNOA',167),\r\n" + 
			"(1649,'ORURILLO',167),\r\n" + 
			"(1650,'SANTA ROSA',167),\r\n" + 
			"(1651,'UMACHIRI',167),\r\n" + 
			"(1652,'CONIMA',168),\r\n" + 
			"(1653,'HUAYRAPATA',168),\r\n" + 
			"(1654,'MOHO',168),\r\n" + 
			"(1655,'TILALI',168),\r\n" + 
			"(1656,'ACORA',169),\r\n" + 
			"(1657,'AMANTANI',169),\r\n" + 
			"(1658,'ATUNCOLLA',169),\r\n" + 
			"(1659,'CAPACHICA',169),\r\n" + 
			"(1660,'CHUCUITO',169),\r\n" + 
			"(1661,'COATA',169),\r\n" + 
			"(1662,'HUATA',169),\r\n" + 
			"(1663,'MANAZO',169),\r\n" + 
			"(1664,'PAUCARCOLLA',169),\r\n" + 
			"(1665,'PICHACANI',169),\r\n" + 
			"(1666,'PLATERIA',169),\r\n" + 
			"(1667,'PUNO',169),\r\n" + 
			"(1668,'SAN ANTONIO',169),\r\n" + 
			"(1669,'TIQUILLACA',169),\r\n" + 
			"(1670,'VILQUE',169),\r\n" + 
			"(1671,'ANANEA',170),\r\n" + 
			"(1672,'PEDRO VILCA APAZA',170),\r\n" + 
			"(1673,'PUTINA',170),\r\n" + 
			"(1674,'QUILCA PUNCU',170),\r\n" + 
			"(1675,'SINA',170),\r\n" + 
			"(1676,'CABANA',171),\r\n" + 
			"(1677,'CABANILLAS',171),\r\n" + 
			"(1678,'CARACOTO',171),\r\n" + 
			"(1679,'JULIACA',171),\r\n" + 
			"(1680,'ALTO INAMBARI',172),\r\n" + 
			"(1681,'CUYOCUYO',172),\r\n" + 
			"(1682,'LIMBANI',172),\r\n" + 
			"(1683,'PATAMBUCO',172),\r\n" + 
			"(1684,'PHARA',172),\r\n" + 
			"(1685,'QUIACA',172),\r\n" + 
			"(1686,'SAN JUAN DEL ORO',172),\r\n" + 
			"(1687,'SAN PEDRO DE PUTINA PUNCO',172),\r\n" + 
			"(1688,'SANDIA',172),\r\n" + 
			"(1689,'YANAHUAYA',172),\r\n" + 
			"(1690,'ANAPIA',173),\r\n" + 
			"(1691,'COPANI',173),\r\n" + 
			"(1692,'CUTURAPI',173),\r\n" + 
			"(1693,'OLLARAYA',173),\r\n" + 
			"(1694,'TINICACHI',173),\r\n" + 
			"(1695,'UNICACHI',173),\r\n" + 
			"(1696,'YUNGUYO',173),\r\n" + 
			"(1697,'ALTO BIAVO',174),\r\n" + 
			"(1698,'BAJO BIAVO',174),\r\n" + 
			"(1699,'BELLAVISTA',174),\r\n" + 
			"(1700,'HUALLAGA',174),\r\n" + 
			"(1701,'SAN PABLO',174),\r\n" + 
			"(1702,'SAN RAFAEL',174),\r\n" + 
			"(1703,'AGUA BLANCA',175),\r\n" + 
			"(1704,'SAN JOSE DE SISA',175),\r\n" + 
			"(1705,'SAN MARTIN',175),\r\n" + 
			"(1706,'SANTA ROSA',175),\r\n" + 
			"(1707,'SHATOJA',175),\r\n" + 
			"(1708,'ALTO SAPOSOA',176),\r\n" + 
			"(1709,'EL ESLABON',176),\r\n" + 
			"(1710,'PISCOYACU',176),\r\n" + 
			"(1711,'SACANCHE',176),\r\n" + 
			"(1712,'SAPOSOA',176),\r\n" + 
			"(1713,'TINGO DE SAPOSOA',176),\r\n" + 
			"(1714,'ALONSO DE ALVARADO',177),\r\n" + 
			"(1715,'BARRANQUITA',177),\r\n" + 
			"(1716,'CAYNARACHI',177),\r\n" + 
			"(1717,'CUNUMBUQUI',177),\r\n" + 
			"(1718,'LAMAS',177),\r\n" + 
			"(1719,'PINTO RECODO',177),\r\n" + 
			"(1720,'RUMISAPA',177),\r\n" + 
			"(1721,'SAN ROQUE DE CUMBAZA',177),\r\n" + 
			"(1722,'SHANAO',177),\r\n" + 
			"(1723,'TABALOSOS',177),\r\n" + 
			"(1724,'ZAPATERO',177),\r\n" + 
			"(1725,'CAMPANILLA',178),\r\n" + 
			"(1726,'HUICUNGO',178),\r\n" + 
			"(1727,'JUANJUI',178),\r\n" + 
			"(1728,'PACHIZA',178),\r\n" + 
			"(1729,'PAJARILLO',178),\r\n" + 
			"(1730,'CALZADA',179),\r\n" + 
			"(1731,'HABANA',179),\r\n" + 
			"(1732,'JEPELACIO',179),\r\n" + 
			"(1733,'MOYOBAMBA',179),\r\n" + 
			"(1734,'SORITOR',179),\r\n" + 
			"(1735,'YANTALO',179),\r\n" + 
			"(1736,'BUENOS AIRES',180),\r\n" + 
			"(1737,'CASPIZAPA',180),\r\n" + 
			"(1738,'PICOTA',180),\r\n" + 
			"(1739,'PILLUANA',180),\r\n" + 
			"(1740,'PUCACACA',180),\r\n" + 
			"(1741,'SAN CRISTOBAL',180),\r\n" + 
			"(1742,'SAN HILARION',180),\r\n" + 
			"(1743,'SHAMBOYACU',180),\r\n" + 
			"(1744,'TINGO DE PONASA',180),\r\n" + 
			"(1745,'TRES UNIDOS',180),\r\n" + 
			"(1746,'AWAJUN',181),\r\n" + 
			"(1747,'ELIAS SOPLIN',181),\r\n" + 
			"(1748,'NUEVA CAJAMARCA',181),\r\n" + 
			"(1749,'PARDO MIGUEL',181),\r\n" + 
			"(1750,'POSIC',181),\r\n" + 
			"(1751,'RIOJA',181),\r\n" + 
			"(1752,'SAN FERNANDO',181),\r\n" + 
			"(1753,'YORONGOS',181),\r\n" + 
			"(1754,'YURACYACU',181),\r\n" + 
			"(1755,'ALBERTO LEVEAU',182),\r\n" + 
			"(1756,'CACATACHI',182),\r\n" + 
			"(1757,'CHAZUTA',182),\r\n" + 
			"(1758,'CHIPURANA',182),\r\n" + 
			"(1759,'EL PORVENIR',182),\r\n" + 
			"(1760,'HUIMBAYOC',182),\r\n" + 
			"(1761,'JUAN GUERRA',182),\r\n" + 
			"(1762,'LA BANDA DE SHILCAYO',182),\r\n" + 
			"(1763,'MORALES',182),\r\n" + 
			"(1764,'PAPAPLAYA',182),\r\n" + 
			"(1765,'SAN ANTONIO',182),\r\n" + 
			"(1766,'SAUCE',182),\r\n" + 
			"(1767,'SHAPAJA',182),\r\n" + 
			"(1768,'TARAPOTO',182),\r\n" + 
			"(1769,'NUEVO PROGRESO',183),\r\n" + 
			"(1770,'POLVORA',183),\r\n" + 
			"(1771,'SHUNTE',183),\r\n" + 
			"(1772,'TOCACHE',183),\r\n" + 
			"(1773,'UCHIZA',183),\r\n" + 
			"(1774,'CAIRANI',184),\r\n" + 
			"(1775,'CAMILACA',184),\r\n" + 
			"(1776,'CANDARAVE',184),\r\n" + 
			"(1777,'CURIBAYA',184),\r\n" + 
			"(1778,'HUANUARA',184),\r\n" + 
			"(1779,'QUILAHUANI',184),\r\n" + 
			"(1780,'ILABAYA',185),\r\n" + 
			"(1781,'ITE',185),\r\n" + 
			"(1782,'LOCUMBA',185),\r\n" + 
			"(1783,'ALTO DE LA ALIANZA',186),\r\n" + 
			"(1784,'CALANA',186),\r\n" + 
			"(1785,'CIUDAD NUEVA',186),\r\n" + 
			"(1786,'CORONEL GREGORIO ALBARRACIN L.ALFONSO UGARTE',186),\r\n" + 
			"(1787,'INCLAN',186),\r\n" + 
			"(1788,'PACHIA',186),\r\n" + 
			"(1789,'PALCA',186),\r\n" + 
			"(1790,'POCOLLAY',186),\r\n" + 
			"(1791,'SAMA',186),\r\n" + 
			"(1792,'TACNA',186),\r\n" + 
			"(1793,'CHUCATAMANI',187),\r\n" + 
			"(1794,'ESTIQUE',187),\r\n" + 
			"(1795,'ESTIQUE PAMPA',187),\r\n" + 
			"(1796,'SITAJARA',187),\r\n" + 
			"(1797,'SUSAPAYA',187),\r\n" + 
			"(1798,'TARATA',187),\r\n" + 
			"(1799,'TARUCACHI',187),\r\n" + 
			"(1800,'TICACO',187),\r\n" + 
			"(1801,'CANOAS DE PUNTA SAL',188),\r\n" + 
			"(1802,'CASITAS',188),\r\n" + 
			"(1803,'ZORRITOS',188),\r\n" + 
			"(1804,'CORRALES',189),\r\n" + 
			"(1805,'LA CRUZ',189),\r\n" + 
			"(1806,'PAMPAS DE HOSPITAL',189),\r\n" + 
			"(1807,'SAN JACINTO',189),\r\n" + 
			"(1808,'SAN JUAN DE LA VIRGEN',189),\r\n" + 
			"(1809,'TUMBES',189),\r\n" + 
			"(1810,'AGUAS VERDES',190),\r\n" + 
			"(1811,'MATAPALO',190),\r\n" + 
			"(1812,'PAPAYAL',190),\r\n" + 
			"(1813,'ZARUMILLA',190),\r\n" + 
			"(1814,'RAIMONDI',191),\r\n" + 
			"(1815,'SEPAHUA',191),\r\n" + 
			"(1816,'TAHUANIA',191),\r\n" + 
			"(1817,'YURUA',191),\r\n" + 
			"(1818,'CALLERIA',192),\r\n" + 
			"(1819,'CAMPOVERDE',192),\r\n" + 
			"(1820,'IPARIA',192),\r\n" + 
			"(1821,'MANANTAY',192),\r\n" + 
			"(1822,'MASISEA',192),\r\n" + 
			"(1823,'NUEVA REQUENA',192),\r\n" + 
			"(1824,'YARINACOCHA',192),\r\n" + 
			"(1825,'CURIMANA',193),\r\n" + 
			"(1826,'PADRE ABAD',193),\r\n" + 
			"(1827,'YRAZOLA',193),\r\n" + 
			"(1828,'PURUS',194),\r\n" + 
			"(1829,'BELLAVISTA',195),\r\n" + 
			"(1830,'CALLAO',195),\r\n" + 
			"(1831,'CARMEN DE LA LEGUA-REYNOSO',195),\r\n" + 
			"(1832,'LA PERLA',195),\r\n" + 
			"(1833,'LA PUNTA',195),\r\n" + 
			"(1834,'VENTANILLA',195);", nativeQuery = true)
	void insertarDistrito();
	
	
	@Query(value="insert into pais(id_pais, descripcion) VALUES (1,'Afganistán'),"
			+"(2,'Islas Gland'),\r\n" + 
			"(3,'Albania'),\r\n" + 
			"(4,'Alemania'),\r\n" + 
			"(5,'Andorra'),\r\n" + 
			"(6,'Angola'),\r\n" + 
			"(7,'Anguilla'),\r\n" + 
			"(8,'Antártida'),\r\n" + 
			"(9,'Antigua y Barbuda'),\r\n" + 
			"(10,'Antillas Holandesas'),\r\n" + 
			"(11,'Arabia Saudí'),\r\n" + 
			"(12,'Argelia'),\r\n" + 
			"(13,'Argentina'),\r\n" + 
			"(14,'Armenia'),\r\n" + 
			"(15,'Aruba'),\r\n" + 
			"(16,'Australia'),\r\n" + 
			"(17,'Austria'),\r\n" + 
			"(18,'Azerbaiyán'),\r\n" + 
			"(19,'Bahamas'),\r\n" + 
			"(20,'Bahréin'),\r\n" + 
			"(21,'Bangladesh'),\r\n" + 
			"(22,'Barbados'),\r\n" + 
			"(23,'Bielorrusia'),\r\n" + 
			"(24,'Bélgica'),\r\n" + 
			"(25,'Belice'),\r\n" + 
			"(26,'Benin'),\r\n" + 
			"(27,'Bermudas'),\r\n" + 
			"(28,'Bhután'),\r\n" + 
			"(29,'Bolivia'),\r\n" + 
			"(30,'Bosnia y Herzegovina'),\r\n" + 
			"(31,'Botsuana'),\r\n" + 
			"(32,'Isla Bouvet'),\r\n" + 
			"(33,'Brasil'),\r\n" + 
			"(34,'Brunéi'),\r\n" + 
			"(35,'Bulgaria'),\r\n" + 
			"(36,'Burkina Faso'),\r\n" + 
			"(37,'Burundi'),\r\n" + 
			"(38,'Cabo Verde'),\r\n" + 
			"(39,'Islas Caimán'),\r\n" + 
			"(40,'Camboya'),\r\n" + 
			"(41,'Camerún'),\r\n" + 
			"(42,'Canadá'),\r\n" + 
			"(43,'República Centroafricana'),\r\n" + 
			"(44,'Chad'),\r\n" + 
			"(45,'República Checa'),\r\n" + 
			"(46,'Chile'),\r\n" + 
			"(47,'China'),\r\n" + 
			"(48,'Chipre'),\r\n" + 
			"(49,'Isla de Navidad'),\r\n" + 
			"(50,'Ciudad del Vaticano'),\r\n" + 
			"(51,'Islas Cocos'),\r\n" + 
			"(52,'Colombia'),\r\n" + 
			"(53,'Comoras'),\r\n" + 
			"(54,'República Democrática del Congo'),\r\n" + 
			"(55,'Congo'),\r\n" + 
			"(56,'Islas Cook'),\r\n" + 
			"(57,'Corea del Norte'),\r\n" + 
			"(58,'Corea del Sur'),\r\n" + 
			"(59,'Costa de Marfil'),\r\n" + 
			"(60,'Costa Rica'),\r\n" + 
			"(61,'Croacia'),\r\n" + 
			"(62,'Cuba'),\r\n" + 
			"(63,'Dinamarca'),\r\n" + 
			"(64,'Dominica'),\r\n" + 
			"(65,'República Dominicana'),\r\n" + 
			"(66,'Ecuador'),\r\n" + 
			"(67,'Egipto'),\r\n" + 
			"(68,'El Salvador'),\r\n" + 
			"(69,'Emiratos Árabes Unidos'),\r\n" + 
			"(70,'Eritrea'),\r\n" + 
			"(71,'Eslovaquia'),\r\n" + 
			"(72,'Eslovenia'),\r\n" + 
			"(73,'España'),\r\n" + 
			"(74,'Islas ultramarinas de Estados Unidos'),\r\n" + 
			"(75,'Estados Unidos'),\r\n" + 
			"(76,'Estonia'),\r\n" + 
			"(77,'Etiopía'),\r\n" + 
			"(78,'Islas Feroe'),\r\n" + 
			"(79,'Filipinas'),\r\n" + 
			"(80,'Finlandia'),\r\n" + 
			"(81,'Fiyi'),\r\n" + 
			"(82,'Francia'),\r\n" + 
			"(83,'Gabón'),\r\n" + 
			"(84,'Gambia'),\r\n" + 
			"(85,'Georgia'),\r\n" + 
			"(86,'Islas Georgias del Sur'),\r\n" + 
			"(87,'Ghana'),\r\n" + 
			"(88,'Gibraltar'),\r\n" + 
			"(89,'Granada'),\r\n" + 
			"(90,'Grecia'),\r\n" + 
			"(91,'Groenlandia'),\r\n" + 
			"(92,'Guadalupe'),\r\n" + 
			"(93,'Guam'),\r\n" + 
			"(94,'Guatemala'),\r\n" + 
			"(95,'Guayana Francesa'),\r\n" + 
			"(96,'Guinea'),\r\n" + 
			"(97,'Guinea Ecuatorial'),\r\n" + 
			"(98,'Guinea-Bissau'),\r\n" + 
			"(99,'Guyana'),\r\n" + 
			"(100,'Haití'),\r\n" + 
			"(101,'Islas Heard y McDonald'),\r\n" + 
			"(102,'Honduras'),\r\n" + 
			"(103,'Hong Kong'),\r\n" + 
			"(104,'Hungría'),\r\n" + 
			"(105,'India'),\r\n" + 
			"(106,'Indonesia'),\r\n" + 
			"(107,'Irán'),\r\n" + 
			"(108,'Iraq'),\r\n" + 
			"(109,'Irlanda'),\r\n" + 
			"(110,'Islandia'),\r\n" + 
			"(111,'Israel'),\r\n" + 
			"(112,'Italia'),\r\n" + 
			"(113,'Jamaica'),\r\n" + 
			"(114,'Japón'),\r\n" + 
			"(115,'Jordania'),\r\n" + 
			"(116,'Kazajstán'),\r\n" + 
			"(117,'Kenia'),\r\n" + 
			"(118,'Kirguistán'),\r\n" + 
			"(119,'Kiribati'),\r\n" + 
			"(120,'Kuwait'),\r\n" + 
			"(121,'Laos'),\r\n" + 
			"(122,'Lesotho'),\r\n" + 
			"(123,'Letonia'),\r\n" + 
			"(124,'Líbano'),\r\n" + 
			"(125,'Liberia'),\r\n" + 
			"(126,'Libia'),\r\n" + 
			"(127,'Liechtenstein'),\r\n" + 
			"(128,'Lituania'),\r\n" + 
			"(129,'Luxemburgo'),\r\n" + 
			"(130,'Macao'),\r\n" + 
			"(131,'ARY Macedonia'),\r\n" + 
			"(132,'Madagascar'),\r\n" + 
			"(133,'Malasia'),\r\n" + 
			"(134,'Malawi'),\r\n" + 
			"(135,'Maldivas'),\r\n" + 
			"(136,'Malí'),\r\n" + 
			"(137,'Malta'),\r\n" + 
			"(138,'Islas Malvinas'),\r\n" + 
			"(139,'Islas Marianas del Norte'),\r\n" + 
			"(140,'Marruecos'),\r\n" + 
			"(141,'Islas Marshall'),\r\n" + 
			"(142,'Martinica'),\r\n" + 
			"(143,'Mauricio'),\r\n" + 
			"(144,'Mauritania'),\r\n" + 
			"(145,'Mayotte'),\r\n" + 
			"(146,'México'),\r\n" + 
			"(147,'Micronesia'),\r\n" + 
			"(148,'Moldavia'),\r\n" + 
			"(149,'Mónaco'),\r\n" + 
			"(150,'Mongolia'),\r\n" + 
			"(151,'Montserrat'),\r\n" + 
			"(152,'Mozambique'),\r\n" + 
			"(153,'Myanmar'),\r\n" + 
			"(154,'Namibia'),\r\n" + 
			"(155,'Nauru'),\r\n" + 
			"(156,'Nepal'),\r\n" + 
			"(157,'Nicaragua'),\r\n" + 
			"(158,'Níger'),\r\n" + 
			"(159,'Nigeria'),\r\n" + 
			"(160,'Niue'),\r\n" + 
			"(161,'Isla Norfolk'),\r\n" + 
			"(162,'Noruega'),\r\n" + 
			"(163,'Nueva Caledonia'),\r\n" + 
			"(164,'Nueva Zelanda'),\r\n" + 
			"(165,'Omán'),\r\n" + 
			"(166,'Países Bajos'),\r\n" + 
			"(167,'Pakistán'),\r\n" + 
			"(168,'Palau'),\r\n" + 
			"(169,'Palestina'),\r\n" + 
			"(170,'Panamá'),\r\n" + 
			"(171,'Papúa Nueva Guinea'),\r\n" + 
			"(172,'Paraguay'),\r\n" + 
			"(173,'Perú'),\r\n" + 
			"(174,'Islas Pitcairn'),\r\n" + 
			"(175,'Polinesia Francesa'),\r\n" + 
			"(176,'Polonia'),\r\n" + 
			"(177,'Portugal'),\r\n" + 
			"(178,'Puerto Rico'),\r\n" + 
			"(179,'Qatar'),\r\n" + 
			"(180,'Reino Unido'),\r\n" + 
			"(181,'Reunión'),\r\n" + 
			"(182,'Ruanda'),\r\n" + 
			"(183,'Rumania'),\r\n" + 
			"(184,'Rusia'),\r\n" + 
			"(185,'Sahara Occidental'),\r\n" + 
			"(186,'Islas Salomón'),\r\n" + 
			"(187,'Samoa'),\r\n" + 
			"(188,'Samoa Americana'),\r\n" + 
			"(189,'San Cristóbal y Nevis'),\r\n" + 
			"(190,'San Marino'),\r\n" + 
			"(191,'San Pedro y Miquelón'),\r\n" + 
			"(192,'San Vicente y las Granadinas'),\r\n" + 
			"(193,'Santa Helena'),\r\n" + 
			"(194,'Santa Lucía'),\r\n" + 
			"(195,'Santo Tomé y Príncipe'),\r\n" + 
			"(196,'Senegal'),\r\n" + 
			"(197,'Serbia y Montenegro'),\r\n" + 
			"(198,'Seychelles'),\r\n" + 
			"(199,'Sierra Leona'),\r\n" + 
			"(200,'Singapur'),\r\n" + 
			"(201,'Siria'),\r\n" + 
			"(202,'Somalia'),\r\n" + 
			"(203,'Sri Lanka'),\r\n" + 
			"(204,'Suazilandia'),\r\n" + 
			"(205,'Sudáfrica'),\r\n" + 
			"(206,'Sudán'),\r\n" + 
			"(207,'Suecia'),\r\n" + 
			"(208,'Suiza'),\r\n" + 
			"(209,'Surinam'),\r\n" + 
			"(210,'Svalbard y Jan Mayen'),\r\n" + 
			"(211,'Tailandia'),\r\n" + 
			"(212,'Taiwán'),\r\n" + 
			"(213,'Tanzania'),\r\n" + 
			"(214,'Tayikistán'),\r\n" + 
			"(215,'Territorio Británico del Océano Índico'),\r\n" + 
			"(216,'Territorios Australes Franceses'),\r\n" + 
			"(217,'Timor Oriental'),\r\n" + 
			"(218,'Togo'),\r\n" + 
			"(219,'Tokelau'),\r\n" + 
			"(220,'Tonga'),\r\n" + 
			"(221,'Trinidad y Tobago'),\r\n" + 
			"(222,'Túnez'),\r\n" + 
			"(223,'Islas Turcas y Caicos'),\r\n" + 
			"(224,'Turkmenistán'),\r\n" + 
			"(225,'Turquía'),\r\n" + 
			"(226,'Tuvalu'),\r\n" + 
			"(227,'Ucrania'),\r\n" + 
			"(228,'Uganda'),\r\n" + 
			"(229,'Uruguay'),\r\n" + 
			"(230,'Uzbekistán'),\r\n" + 
			"(231,'Vanuatu'),\r\n" + 
			"(232,'Venezuela'),\r\n" + 
			"(233,'Vietnam'),\r\n" + 
			"(234,'Islas Vírgenes Británicas'),\r\n" + 
			"(235,'Islas Vírgenes de los Estados Unidos'),\r\n" + 
			"(236,'Wallis y Futuna'),\r\n" + 
			"(237,'Yemen'),\r\n" + 
			"(238,'Yibuti'),\r\n" + 
			"(239,'Zambia'),\r\n" + 
			"(240,'Zimbabue'),\r\n" + 
			"(241,'ZONA DEL CANAL DE PANAMA'),\r\n" + 
			"(242,'ZONA LIBRE OSTRAVA'),\r\n" + 
			"(243,'ZONA NEUTRAL (PALESTINA)');", nativeQuery = true)
	void insertarPais();
	
	
	@Query(value="insert into regimen_laboral(id_reg_laboral, descripcion)VALUES (1, 'AGRARIO LEY 27360'),"
			+ "(2,'CONSTRUCCION CIVIL'),\r\n" + 
			"(3,'CONTRATO ADMINISTRATIVO DE SERVICIOS - D.LEG. N.° 1057')," + 
			"(4,'DOCENTES UNIVERSITARIOS - LEY N.° 23733')," + 
			"(5,'ESPECIAL GER. PÚBLICOS DECRETO LEGISLATIVO N.° 1024 (2)')," + 
			"(6,'EXPORTACION NO TRADICIONAL D. LEY 22342')," + 
			"(7,'FISCALES - D. LEG.  N.° 052')," + 
			"(8,'JUECES - CARRERA JUDICIAL - LEY N.° 29277')," + 
			"(9,'MAGISTERIO - LEY N.° 29062')," + 
			"(10,'MICROEMPRESA D. LEG. 1086 (1)')," + 
			"(11,'MILITARES')," + 
			"(12,'MINEROS')," + 
			"(13,'OTROS NO PREVISTOS')," + 
			"(14,'PEQUEÑA EMPRESA D. LEG. 1086 (1)')," + 
			"(15,'POLICIA NACIONAL DEL PERÚ - LEY N.° 27238')," + 
			"(16,'PRIVADO GENERAL -DECRETO LEGISLATIVO N.° 728')," + 
			"(17,'PROFESIONALES DE LA SALUD LEY N.° 23536')," + 
			"(18,'PROFESORADO - LEY N.° 24029')," + 
			"(19,'PÚBLICO GENERAL - DECRETO LEGISLATIVO N.° 276')," + 
			"(20,'SERUM - LEY N.° 23330')," + 
			"(21,'SERVICIO DIPLOMÁTICO DE LA REPÚBLICA - LEY N.° 28091')," + 
			"(22,'TECNICOS Y AUXILIARES ASIST. DE LA SALUD - LEY N.° 28561'),"+
			"(23,'TRABAJADORES DEL HOGAR'),"+ 
			"(24,'TRABAJADORES PESQUEROS');", nativeQuery = true)
	void insertarRegLaboral();
	
	
	@Query(value="insert into nivel_edu(id_nivel_edu, descripcion) VALUES (1,'EDUCACIÓN ESPECIAL COMPLETA'),"
			+ "(2,'EDUCACIÓN ESPECIAL INCOMPLETA'),\r\n" + 
			"(3,'EDUCACIÓN PRIMARIA COMPLETA'),\r\n" + 
			"(4,'EDUCACIÓN PRIMARIA INCOMPLETA'),\r\n" + 
			"(5,'EDUCACIÓN SECUNDARIA COMPLETA'),\r\n" + 
			"(6,'EDUCACIÓN SECUNDARIA INCOMPLETA'),\r\n" + 
			"(7,'EDUCACIÓN SUPERIOR (INSTITUTO SUPERIOR, ETC) COMPLETA '),\r\n" + 
			"(8,'EDUCACIÓN SUPERIOR (INSTITUTO SUPERIOR, ETC) INCOMPLETA '),\r\n" + 
			"(9,'EDUCACIÓN TÉCNICA COMPLETA'),\r\n" + 
			"(10,'EDUCACIÓN TÉCNICA INCOMPLETA'),\r\n" + 
			"(11,'EDUCACIÓN UNIVERSITARIA COMPLETA'),\r\n" + 
			"(12,'EDUCACIÓN UNIVERSITARIA INCOMPLETA'),\r\n" + 
			"(13,'ESTUDIOS DE DOCTORADO COMPLETO'),\r\n" + 
			"(14,'ESTUDIOS DE DOCTORADO INCOMPLETO'),\r\n" + 
			"(15,'ESTUDIOS DE MAESTRÍA COMPLETA'),\r\n" + 
			"(16,'ESTUDIOS DE MAESTRÍA INCOMPLETA'),\r\n" + 
			"(17,'GRADO DE BACHILLER'),\r\n" + 
			"(18,'GRADO DE DOCTOR'),\r\n" + 
			"(19,'GRADO DE MAESTRÍA'),\r\n" + 
			"(20,'SIN EDUCACIÓN FORMAL'),\r\n" + 
			"(21,'TITULADO');", nativeQuery = true)
	void insertarNivelEduca();
	
	
	@Query(value="insert into ocupacion(id_ocupacion, descripcion) VALUES (1,'ABANIQUERO,CONFECCIONADOR DE ABANICOS'),"
			+ "(2,'ABARQUERO'),"+ 
			"(3,'ABOGADO'),\r\n" + 
			"(4,'ABOGADO PATROCINANTE'),\r\n" + 
			"(5,'ABOGADO PENALISTA'),\r\n" + 
			"(6,'ABOGADO, CIVIL-LABORAL/DERECHO PRIVADO'),\r\n" + 
			"(7,'ABOGADO, CRIMINALISTA/DERECHO PUBLICO (CONSTIT.PENAL, ADMIN'),\r\n" + 
			"(8,'ABOGADO, DERECHO INTERNACIONAL'),\r\n" + 
			"(9,'ABOGADOS Y OTROS'),\r\n" + 
			"(10,'ABORNADOR DE CUEROS'),\r\n" + 
			"(11,'ABRIDOR DE CAPA Y CAPILLOS,ELABORACION CIGARRO'),\r\n" + 
			"(12,'ACABADOR DE BORDES,CRISTAL'),\r\n" + 
			"(13,'ACABADOR DE CALZADO'),\r\n" + 
			"(14,'ACABADOR DE MUEBLES DE MADERA'),\r\n" + 
			"(15,'ACABADOR DE TEJIDOS'),\r\n" + 
			"(16,'ACABADOR DE TRABAJOS DE PELETERIA'),\r\n" + 
			"(17,'ACABADOR Y ADORNADOR DE SOMBREROS'),\r\n" + 
			"(18,'ACECINADOR'),\r\n" + 
			"(19,'ACEITADOR DE LLENO Y VACIO, CONSERVAS DE PESCADO'),\r\n" + 
			"(20,'ACETIFICADOR'),\r\n" + 
			"(21,'ACIDIFICADOR, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(22,'ACOLITO'),\r\n" + 
			"(23,'ACOMODADOR'),\r\n" + 
			"(24,'ACOMODADOR, SALA, CINE, TEATRO ETC.'),\r\n" + 
			"(25,'ACONDICIONADOR DE TABACO'),\r\n" + 
			"(26,'ACORDEONERO,CONSTRUCTOR'),\r\n" + 
			"(27,'ACROBATA'),\r\n" + 
			"(28,'ACTOR'),\r\n" + 
			"(29,'ACTOR, CINE'),\r\n" + 
			"(30,'ACTOR, TEATRO'),\r\n" + 
			"(31,'ACTRIZ'),\r\n" + 
			"(32,'ACTRIZ, CINE'),\r\n" + 
			"(33,'ACTRIZ, TEATRO'),\r\n" + 
			"(34,'ACTUARIO'),\r\n" + 
			"(35,'ACUARELISTA'),\r\n" + 
			"(36,'ADAPTADOR MUSICAL'),\r\n" + 
			"(37,'ADEREZADOR DE ACEITUNAS'),\r\n" + 
			"(38,'ADEREZADOR DE SEDA'),\r\n" + 
			"(39,'ADIESTRADOR, PERROS'),\r\n" + 
			"(40,'ADMINISTRADOR DE EMPRESAS'),\r\n" + 
			"(41,'ADMINISTRADOR, ABASTECIMIENTO'),\r\n" + 
			"(42,'ADMINISTRADOR, ADMINISTRACION PUBLICA'),\r\n" + 
			"(43,'ADMINISTRADOR, BANCO DE DATOS'),\r\n" + 
			"(44,'ADMINISTRADOR, COMERCIO NEP'),\r\n" + 
			"(45,'ADMINISTRADOR, HOGAR/ECONOMOS'),\r\n" + 
			"(46,'ADMINISTRADOR, MATERIAL CONTABLE'),\r\n" + 
			"(47,'ADMINISTRADOR, PERSONAL'),\r\n" + 
			"(48,'ADMINISTRADOR, PROPIEDADES INMUEBLES'),\r\n" + 
			"(49,'ADMINISTRADORES, OTROS'),\r\n" + 
			"(50,'ADOBADOR DE CUEROS'),\r\n" + 
			"(51,'ADOBADOR DE PIELES'),\r\n" + 
			"(52,'ADOBERO'),\r\n" + 
			"(53,'ADOQUINADOR-PAVIMENTADOR'),\r\n" + 
			"(54,'ADOQUINEROS'),\r\n" + 
			"(55,'ADORNISTAS'),\r\n" + 
			"(56,'ADUANERO'),\r\n" + 
			"(57,'AEROMOZA, CAMARERA DE AVION'),\r\n" + 
			"(58,'AFILADOR EN GENERAL'),\r\n" + 
			"(59,'AFINADOR A MAQUINA DE CRISTALES DE OPTICA'),\r\n" + 
			"(60,'AFINADOR DE INSTRUM. MUSICALES, PIANOS, ORGANOS, ACORDEONES'),\r\n" + 
			"(61,'AFINADOR DE VIDRIO,OPTICA DE ANTEOJERIA'),\r\n" + 
			"(62,'AGENTE ADMINISTRATIVO, ADMINISTRACION PUBLICA/IMPUESTOS'),\r\n" + 
			"(63,'AGENTE ADMINISTRATIVO, ADMINISTRACION PUBLICA/SERVICIO DE TURISMO'),\r\n" + 
			"(64,'AGENTE ADMINISTRATIVO, CONSULADO/ADUANAS'),\r\n" + 
			"(65,'AGENTE ADMINISTRATIVO, CONSULADO/SERVICIO DE TURISMO'),\r\n" + 
			"(66,'AGENTE DE LOS SERVICIOS DE MERCANCIAS, FERROCARRILES'),\r\n" + 
			"(67,'AGENTE DE LOS SERVICIOS DE TRANSPORTE DE CARGA, FERROCARRIL'),\r\n" + 
			"(68,'AGENTE DE SERVICIO DE ADUANA, NO EMPLEADO PUBLICO'),\r\n" + 
			"(69,'AGENTE DE VENTAS, SERVICIO DE PROTECCION  CONTRA ROBOS E IN'),\r\n" + 
			"(70,'AGENTE DISTRIBUIDOR'),\r\n" + 
			"(71,'AGENTE FISCAL'),\r\n" + 
			"(72,'AGENTE INMOBILIARIO'),\r\n" + 
			"(73,'AGENTE TRANSPORTE Y/O MUDANZA'),\r\n" + 
			"(74,'AGENTE, ADUANA'),\r\n" + 
			"(75,'AGENTE, BOLSA'),\r\n" + 
			"(76,'AGENTE, CAMBIO'),\r\n" + 
			"(77,'AGENTE, COMPRAS/SUMINISTROS'),\r\n" + 
			"(78,'AGENTE, DEPORTIVO'),\r\n" + 
			"(79,'AGENTE, FERROCARRIL/MERCANCIAS'),\r\n" + 
			"(80,'AGENTE, FISCAL/ARANCELES'),\r\n" + 
			"(81,'AGENTE, INMIGRACION Y MIGRACION'),\r\n" + 
			"(82,'AGENTE, LITERARIO'),\r\n" + 
			"(83,'AGENTE, MUSICAL'),\r\n" + 
			"(84,'AGENTE, OFICINA DE COLOCACION'),\r\n" + 
			"(85,'AGENTE, PUBLICIDAD'),\r\n" + 
			"(86,'AGENTE, SEGUROS'),\r\n" + 
			"(87,'AGENTE, SERVICIOS A LAS EMPRESAS'),\r\n" + 
			"(88,'AGENTE, SERVICIOS DE ALMACENAMIENTO'),\r\n" + 
			"(89,'AGENTE, SUMINISTROS'),\r\n" + 
			"(90,'AGENTE, TEATRO'),\r\n" + 
			"(91,'AGENTE, TURISMO'),\r\n" + 
			"(92,'AGENTE, VENTA DE PUBLICIDAD/ESPACIOS'),\r\n" + 
			"(93,'AGENTE, VENTAS'),\r\n" + 
			"(94,'AGENTE, VENTAS/COMERCIO'),\r\n" + 
			"(95,'AGENTE, VENTAS/INDUSTRIA MANUFACTURERA'),\r\n" + 
			"(96,'AGENTE, VENTAS/TECNICO'),\r\n" + 
			"(97,'AGENTE, VIAJES'),\r\n" + 
			"(98,'AGENTES DE ADUANAS E INSPECTORES DE FRONTERA'),\r\n" + 
			"(99,'AGENTES DE MANIOBRAS'),\r\n" + 
			"(100,'AGENTES DE VENTAS, SERVICIO DE ILUMINACION Y LIMPIEZA'),\r\n" + 
			"(101,'AGRICULTOR'),\r\n" + 
			"(102,'AGRICULTOR (EXPLOTADOR), POLICULTIVOS'),\r\n" + 
			"(103,'AGRICULTOR EXPLOTADOR DE VIA'),\r\n" + 
			"(104,'AGRICULTOR EXPLOTADOR, ALMENDRAS'),\r\n" + 
			"(105,'AGRICULTOR EXPLOTADOR, CULTIVO/ALFALFA'),\r\n" + 
			"(106,'AGRICULTOR EXPLOTADOR, CULTIVO/ALGODON'),\r\n" + 
			"(107,'AGRICULTOR EXPLOTADOR, CULTIVO/ARROZ'),\r\n" + 
			"(108,'AGRICULTOR EXPLOTADOR, CULTIVO/CACAHUETE'),\r\n" + 
			"(109,'AGRICULTOR EXPLOTADOR, CULTIVO/CAÐA DE AZUCAR'),\r\n" + 
			"(110,'AGRICULTOR EXPLOTADOR, CULTIVO/CEREALES'),\r\n" + 
			"(111,'AGRICULTOR EXPLOTADOR, CULTIVO/CITRICOS'),\r\n" + 
			"(112,'AGRICULTOR EXPLOTADOR, CULTIVO/FLORES'),\r\n" + 
			"(113,'AGRICULTOR EXPLOTADOR, CULTIVO/GRANO'),\r\n" + 
			"(114,'AGRICULTOR EXPLOTADOR, CULTIVO/HORTALIZAS (CULTIVO EXTENSIV'),\r\n" + 
			"(115,'AGRICULTOR EXPLOTADOR, CULTIVO/LINO'),\r\n" + 
			"(116,'AGRICULTOR EXPLOTADOR, CULTIVO/MAIZ'),\r\n" + 
			"(117,'AGRICULTOR EXPLOTADOR, CULTIVO/REMOLACHA'),\r\n" + 
			"(118,'AGRICULTOR EXPLOTADOR, CULTIVO/SISAL'),\r\n" + 
			"(119,'AGRICULTOR EXPLOTADOR, CULTIVO/SOJA'),\r\n" + 
			"(120,'AGRICULTOR EXPLOTADOR, CULTIVO/TABACO'),\r\n" + 
			"(121,'AGRICULTOR EXPLOTADOR, CULTIVO/TRIGO'),\r\n" + 
			"(122,'AGRICULTOR EXPLOTADOR, CULTIVO/YUTE'),\r\n" + 
			"(123,'AGRICULTOR EXPLOTADOR, PLANTACION/CACAO'),\r\n" + 
			"(124,'AGRICULTOR EXPLOTADOR, PLANTACION/CAFE,TE'),\r\n" + 
			"(125,'AGRICULTOR EXPLOTADOR, PLANTACION/COCOTEROS'),\r\n" + 
			"(126,'AGRICULTOR EXPLOTADOR, PLANTACION/COCOTEROS'),\r\n" + 
			"(127,'AGRICULTOR EXPLOTADOR, PLANTACION/HEVEA'),\r\n" + 
			"(128,'AGRICULTOR FORESTAL, TRABAJADOR INDEPENDIENTE'),\r\n" + 
			"(129,'AGRICULTOR GANADERO, TRABAJADOR INDEPENDIENTE'),\r\n" + 
			"(130,'AGRICULTOR, AYUDANTE'),\r\n" + 
			"(131,'AGRICULTOR, SUBSISTENCIA'),\r\n" + 
			"(132,'AGRIMENSOR'),\r\n" + 
			"(133,'AGRIMENSOR, AEROFOTOGRAFO'),\r\n" + 
			"(134,'AGRIMENSOR, GEODESICO'),\r\n" + 
			"(135,'AGRIMENSOR, HIDROGRAFICO'),\r\n" + 
			"(136,'AGRIMENSOR, MARINA'),\r\n" + 
			"(137,'AGRIMENSOR, MINAS'),\r\n" + 
			"(138,'AGRIMENSOR, TOPOGRAFIA'),\r\n" + 
			"(139,'AGRIMENSOR, TOPOGRAFIA AEREA'),\r\n" + 
			"(140,'AGROLOGO'),\r\n" + 
			"(141,'AGRONOMO'),\r\n" + 
			"(142,'AGRONOMO, ARBORICULTOR'),\r\n" + 
			"(143,'AGRONOMO, CONSERVACION DE LA NATURALEZA'),\r\n" + 
			"(144,'AGRONOMO, ECOLOGO'),\r\n" + 
			"(145,'AGRONOMO, EDAFOLOGIA'),\r\n" + 
			"(146,'AGRONOMO, FLORICULTOR'),\r\n" + 
			"(147,'AGRONOMO, HORTICULTURA'),\r\n" + 
			"(148,'AGRONOMO, OLEICULTOR'),\r\n" + 
			"(149,'AGRONOMO, SILVICULTURA'),\r\n" + 
			"(150,'AHOYADOR, CANTERAS'),\r\n" + 
			"(151,'AHUMADOR DE CARNES Y PESCADO'),\r\n" + 
			"(152,'AHUMADOR DE LATEX'),\r\n" + 
			"(153,'AISLADOR DE EDIFICIO'),\r\n" + 
			"(154,'AISLADOR DE INST.DE REFRIG. Y DE CLIMATIZACION'),\r\n" + 
			"(155,'AISLADOR DE TURBINA'),\r\n" + 
			"(156,'AJUSTADOR DE MANDRILES Y CALIBRADORES'),\r\n" + 
			"(157,'AJUSTADOR DE MAQ. DE LABRAR MADERA EN GENERAL'),\r\n" + 
			"(158,'AJUSTADOR DE MAQUINA PARA TEJIDOS DE PUNTO'),\r\n" + 
			"(159,'AJUSTADOR DE PEINES, TELARES'),\r\n" + 
			"(160,'AJUSTADOR DE TELAR JACQUARD'),\r\n" + 
			"(161,'AJUSTADOR DE TELARES'),\r\n" + 
			"(162,'AJUSTADOR DE TUBERIAS EN GENERAL, DE GAS, EN AVIONES'),\r\n" + 
			"(163,'AJUSTADOR ELECTRICISTA EN GENERAL'),\r\n" + 
			"(164,'AJUSTADOR ELECTRONICISTA'),\r\n" + 
			"(165,'AJUSTADOR, MONTADOR DE MOTORES A GASOLINA'),\r\n" + 
			"(166,'AJUSTADOR, MONTADOR DE MOTORES DE COMBUST.INT.(EX.MOT.AVION'),\r\n" + 
			"(167,'AJUSTADOR, MONTADOR DE MOTORES DIESEL'),\r\n" + 
			"(168,'AJUSTADORES ELECTRICISTAS ASCENSORES Y SIMILARES'),\r\n" + 
			"(169,'AJUSTADORES ELECTRICISTAS DE MOTORES Y DINAMOS'),\r\n" + 
			"(170,'AJUSTADORES ELECTRICISTAS DE TRANSFORMADORES'),\r\n" + 
			"(171,'AJUSTADORES ELECTRICISTAS EQUIPOS CENTRALES ELECTRICOS'),\r\n" + 
			"(172,'AJUSTADOR-MODELISTA,FUNDICION'),\r\n" + 
			"(173,'AJUSTADOR-MODELISTAS Y TRAZADORES MATRICES EN METAL'),\r\n" + 
			"(174,'AJUSTADOR-MONTADOR DE MOTORES AVION,REACCION'),\r\n" + 
			"(175,'AJUSTADOR-MONTADOR DE MOTORES MARINOS'),\r\n" + 
			"(176,'AJUSTADOR-MONTADOR EXCEPTO MOTORES COMBUS. INTERNA'),\r\n" + 
			"(177,'AJUSTADOR-OPERADOR CEPILLADORA, INCLUYE METALES'),\r\n" + 
			"(178,'AJUSTADOR-OPERADOR DE CEPILLADORA, LABRA MADERA'),\r\n" + 
			"(179,'AJUSTADOR-OPERADOR DE ESCOPLEADORA DE METALES'),\r\n" + 
			"(180,'AJUSTADOR-OPERADOR DE ESMERILADORA DE METALES'),\r\n" + 
			"(181,'AJUSTADOR-OPERADOR DE FRESADORA,INCLUYE DE METAL'),\r\n" + 
			"(182,'AJUSTADOR-OPERADOR DE MAQ. DE TALLAR ENGRANAJES'),\r\n" + 
			"(183,'AJUSTADOR-OPERADOR DE MAQ. LABRAR MADERA EN GRAL'),\r\n" + 
			"(184,'AJUSTADOR-OPERADOR DE MAQUINA DE LAPIDAR'),\r\n" + 
			"(185,'AJUSTADOR-OPERADOR DE MAQUINA MORTAJADORA'),\r\n" + 
			"(186,'AJUSTADOR-OPERADOR DE MAQUINAS DE MECANISMO NUMERICO DE CON'),\r\n" + 
			"(187,'AJUSTADOR-OPERADOR DE SIERRA MECANICA DE PRECISION'),\r\n" + 
			"(188,'AJUSTADOR-OPERADOR DE TALADRADORA'),\r\n" + 
			"(189,'AJUSTADOR-OPERADOR DE TORNO'),\r\n" + 
			"(190,'AJUSTADOR-OPERADOR DE TORNO DE ROSCAR'),\r\n" + 
			"(191,'AJUSTADOR-OPERADOR MANDRILADORA DE METALES'),\r\n" + 
			"(192,'AJUSTADOR-OPERADOR MAQ. HERRAMIENTAS, EN GENERAL'),\r\n" + 
			"(193,'AJUSTADOR-OPERADOR MOLDURADORA, LABRA DE MADERA'),\r\n" + 
			"(194,'AJUSTADOR-OPERADOR RANURADORA, LABRA DE MADERA'),\r\n" + 
			"(195,'AJUSTADOR-OPERADOR RECTIFICADORA, INCLUYE CILINDROS Y METAL'),\r\n" + 
			"(196,'AJUSTADOR-OPERADOR TORNO AUTOMATICO, LABRA MADERA'),\r\n" + 
			"(197,'AJUSTADOR-OPERADOR TORNO, LABRA DE MADERA'),\r\n" + 
			"(198,'AJUST-OPERAD FRESADORA-GRABADORA, LABRA DE MADERA'),\r\n" + 
			"(199,'ALBAÐIL'),\r\n" + 
			"(200,'ALBAÐIL EN GENERAL'),\r\n" + 
			"(201,'ALBAÐILERO'),\r\n" + 
			"(202,'ALCALDE'),\r\n" + 
			"(203,'ALFARERO,EN GRAL,EXCEPTO LADRILLOS,ADOBES,TEJAS'),\r\n" + 
			"(204,'ALFEREZ DE FRAGATA, RESERVA NAVAL/MARINA MERCANTE'),\r\n" + 
			"(205,'ALGUACILES'),\r\n" + 
			"(206,'ALIENISTA'),\r\n" + 
			"(207,'ALIMENTADORES DE CARDAS'),\r\n" + 
			"(208,'ALISADOR DE PRODUCTOS DE CAUCHO'),\r\n" + 
			"(209,'ALMACENERO'),\r\n" + 
			"(210,'ALMADIERO'),\r\n" + 
			"(211,'ALMADRABERO'),\r\n" + 
			"(212,'ALMAZARERO'),\r\n" + 
			"(213,'ALMIDONADOR, LAVANDERIA'),\r\n" + 
			"(214,'ALOPATA'),\r\n" + 
			"(215,'AMA DE CRIA O SECA O LECHE O NIÐOS'),\r\n" + 
			"(216,'AMA DE LLAVES'),\r\n" + 
			"(217,'AMAESTRADOR, ELEFANTES'),\r\n" + 
			"(218,'AMAESTRADOR, FIERAS'),\r\n" + 
			"(219,'AMANUENSE, ESTADISTICA'),\r\n" + 
			"(220,'AMASADOR DE CAOLIN,PORCELANA'),\r\n" + 
			"(221,'AMASADOR DE CAUCHO'),\r\n" + 
			"(222,'AMASADOR DE PAN'),\r\n" + 
			"(223,'AMOLADOR DE SIERRAS'),\r\n" + 
			"(224,'AMORTAJADOR'),\r\n" + 
			"(225,'AMPLIADOR DE FOTOGRAFIAS'),\r\n" + 
			"(226,'ANALISTA, OCUPACIONES'),\r\n" + 
			"(227,'ANALISTA, PROFESIONES'),\r\n" + 
			"(228,'ANALISTA, PUESTOS DE TRABAJO'),\r\n" + 
			"(229,'ANALISTA, SISTEMAS INFORMATICOS'),\r\n" + 
			"(230,'ANALISTA, SISTEMAS INFORMATICOS/BANCO DE DATOS'),\r\n" + 
			"(231,'ANALISTA, SISTEMAS INFORMATICOS/COMPUTADORAS'),\r\n" + 
			"(232,'ANALISTA, SISTEMAS INFORMATICOS/TELECOMUNICACIONES'),\r\n" + 
			"(233,'ANALISTAS, TRANSMISIONES/SISTEMAS INFORMATICOS'),\r\n" + 
			"(234,'ANATOMISTA'),\r\n" + 
			"(235,'ANCHOVETERO'),\r\n" + 
			"(236,'ANESTESISTA'),\r\n" + 
			"(237,'ANFITRION'),\r\n" + 
			"(238,'ANIMADOR RURAL'),\r\n" + 
			"(239,'ANOTADOR DE APUESTAS'),\r\n" + 
			"(240,'ANTROPOLOGO'),\r\n" + 
			"(241,'APANADOR/COSECHADOR DE ALGODON'),\r\n" + 
			"(242,'APARADOR DE CALZADO'),\r\n" + 
			"(243,'APAREJADOR DE APARATOS DE ELEVACION'),\r\n" + 
			"(244,'APAREJADOR DE AVIONES'),\r\n" + 
			"(245,'APAREJADOR DE BARCOS'),\r\n" + 
			"(246,'APAREJADOR, FONDEOS DE PETROLEO Y DE GAS'),\r\n" + 
			"(247,'APAREJADOR, INGENIERIA CIVIL'),\r\n" + 
			"(248,'APAREJADOR, PERFORACION DE POZOS DE PETROL.Y GAS'),\r\n" + 
			"(249,'APAREJADOR, SONDEOS DE PETROLEO Y DE GAS'),\r\n" + 
			"(250,'APICULTOR (CRIADOR DE ABEJAS)'),\r\n" + 
			"(251,'APILADOR DE MATERIAL, CONSTRUCCION/EDIFICIOS, A MANO'),\r\n" + 
			"(252,'APIRI'),\r\n" + 
			"(253,'APODERADO'),\r\n" + 
			"(254,'APRESTADOR DE TEJIDOS'),\r\n" + 
			"(255,'APUNTALADOR, ADEMADOR, ALADERO, ENTIBADOR, MINAS'),\r\n" + 
			"(256,'APURADOR-LAVADOR DE MINERAL'),\r\n" + 
			"(257,'ARBITRO, DEPORTIVO'),\r\n" + 
			"(258,'ARBORICULTOR'),\r\n" + 
			"(259,'ARBORICULTOR, ALMENDROS'),\r\n" + 
			"(260,'ARBORICULTOR, ARBUSTOS'),\r\n" + 
			"(261,'ARBORICULTOR, CACAO'),\r\n" + 
			"(262,'ARBORICULTOR, CAFETALES'),\r\n" + 
			"(263,'ARBORICULTOR, COCOTEROS'),\r\n" + 
			"(264,'ARBORICULTOR, FRUTALES EN GENERAL'),\r\n" + 
			"(265,'ARBORICULTOR, LUPULO'),\r\n" + 
			"(266,'ARBORICULTOR, NOGALES'),\r\n" + 
			"(267,'ARBORICULTOR, OLEAGINOSAS'),\r\n" + 
			"(268,'ARBORICULTOR, PLANTACIONES/COPRA'),\r\n" + 
			"(269,'ARBORICULTOR, PLANTACIONES/HEVEA'),\r\n" + 
			"(270,'ARBORICULTOR, PLANTACIONES/TE'),\r\n" + 
			"(271,'ARCHIVERO, DE BIBLIOTECA Y SERVICIOS DE ARCHIVOS'),\r\n" + 
			"(272,'ARCHIVERO, DE MUSEO'),\r\n" + 
			"(273,'ARCHIVERO, PALEOLOGO'),\r\n" + 
			"(274,'ARCIPRESTE'),\r\n" + 
			"(275,'ARGUMENTISTA, TEATRO O CINE'),\r\n" + 
			"(276,'ARMADOR DE BARCOS'),\r\n" + 
			"(277,'ARMADOR DE CAJAS DE ACERO EN TALLER'),\r\n" + 
			"(278,'ARMADOR DE CAJAS DE CARTON A MANO'),\r\n" + 
			"(279,'ARMADOR DE CAJAS DE CARTON A MAQUINA'),\r\n" + 
			"(280,'ARMADOR DE CALZADO'),\r\n" + 
			"(281,'ARMADOR DE ESTRUCTURAS DE ACERO'),\r\n" + 
			"(282,'ARMADOR DE HORMIGON'),\r\n" + 
			"(283,'ARMADOR DE PAGINAS, IMPOSICION'),\r\n" + 
			"(284,'ARMADOR DE PRODUCTOS DE CAUCHO'),\r\n" + 
			"(285,'ARMADOR DE PRODUCTOS DE PLASTICO'),\r\n" + 
			"(286,'ARMADOR HIERRO Y ACERO, BLINDAJE, CONSTRUC NAVALES'),\r\n" + 
			"(287,'ARMERO'),\r\n" + 
			"(288,'ARMONISTA'),\r\n" + 
			"(289,'ARPISTA'),\r\n" + 
			"(290,'ARPONERO'),\r\n" + 
			"(291,'ARQUEOLOGO'),\r\n" + 
			"(292,'ARQUITECTO, EDIFICIOS'),\r\n" + 
			"(293,'ARQUITECTO, INTERIORES DE EDIFICIOS'),\r\n" + 
			"(294,'ARREGLO DE MAQUINA DE ESCRIBIR, CALCULADORAS, ETC.'),\r\n" + 
			"(295,'ARRIERO'),\r\n" + 
			"(296,'ARRIERO, CONDUCTOR DE VEHICULOS DE TRACCION ANIMAL'),\r\n" + 
			"(297,'ARROPIERO'),\r\n" + 
			"(298,'ARTESANO DEL CUERO, EN GENERAL'),\r\n" + 
			"(299,'ARTILLERO, MINAS Y CANTERAS'),\r\n" + 
			"(300,'ARTISTA COMERCIAL'),\r\n" + 
			"(301,'ARTISTA CREATIVO'),\r\n" + 
			"(302,'ARTISTA LIRICO'),\r\n" + 
			"(303,'ARTISTA PINTOR'),\r\n" + 
			"(304,'ARTISTA, MARIONETAS'),\r\n" + 
			"(305,'ARTISTA, STRIP-TEASE'),\r\n" + 
			"(306,'ARTISTA, TRAPECIO'),\r\n" + 
			"(307,'ARZOBISPO'),\r\n" + 
			"(308,'ASEGURADOR'),\r\n" + 
			"(309,'ASEGURADOR, MARITIMO'),\r\n" + 
			"(310,'ASENSORISTA'),\r\n" + 
			"(311,'ASERRADOR DE PIEDRA'),\r\n" + 
			"(312,'ASERRADOR EN GENERAL, SERRERIAS'),\r\n" + 
			"(313,'ASERRADOR, MONTE'),\r\n" + 
			"(314,'ASESOR CONTABLE'),\r\n" + 
			"(315,'ASESOR, INVERSIONES'),\r\n" + 
			"(316,'ASESOR, LEGAL O JURIDICO'),\r\n" + 
			"(317,'ASESOR, METODOS DE ENSEÐANZA'),\r\n" + 
			"(318,'ASFALTO, GRANO DE ARENA Y MATERIALES SIMILARES'),\r\n" + 
			"(319,'ASISTENTE DENTISTA, ESCUELAS'),\r\n" + 
			"(320,'ASISTENTE MEDICO'),\r\n" + 
			"(321,'ASISTENTE MEDICO SOCIAL'),\r\n" + 
			"(322,'ASISTENTE MEDICO, PLANIFICACION FAMILIAR'),\r\n" + 
			"(323,'ASISTENTE SOCIAL'),\r\n" + 
			"(324,'ASISTENTE SOCIAL, BIENESTAR SOCIAL'),\r\n" + 
			"(325,'ASISTENTE SOCIAL, DELINCUENCIA'),\r\n" + 
			"(326,'ASISTENTE SOCIAL, DELINCUENCIA/LIBERTAD CONDICIONAL'),\r\n" + 
			"(327,'ASISTENTE SOCIAL, DELINCUENCIA/PREVENCION Y REHABILITACION'),\r\n" + 
			"(328,'ASISTENTE SOCIAL, EMPRESA'),\r\n" + 
			"(329,'ASISTENTE SOCIAL, HOSPITAL'),\r\n" + 
			"(330,'ASISTENTE SOCIAL, PRISIONES'),\r\n" + 
			"(331,'ASISTENTE SOCIAL, PROTECCION DE LA FAMILIA'),\r\n" + 
			"(332,'ASISTENTE SOCIAL, PROTECCION DE LA INFANCIA'),\r\n" + 
			"(333,'ASISTENTE SOCIAL, PSIQUIATRIA'),\r\n" + 
			"(334,'ASISTENTE SOCIAL, REHABILITACION/INCAPACITADOS FISICOS'),\r\n" + 
			"(335,'ASISTENTE SOCIAL, SERVICIOS COMUNITARIOS'),\r\n" + 
			"(336,'ASISTENTE SOCIAL, SERVICIOS CULTURALES'),\r\n" + 
			"(337,'ASISTENTE SOCIAL, SERVICIOS DE AYUDA FAMILIAR'),\r\n" + 
			"(338,'ASISTENTE SOCIAL, SERVICIOS SOCIALES'),\r\n" + 
			"(339,'ASISTENTE, BIBLIOTECA'),\r\n" + 
			"(340,'ASISTENTE, FARMACEUTICO'),\r\n" + 
			"(341,'ASISTENTE, VETERINARIO'),\r\n" + 
			"(342,'ASPEADOR, TEXTIL'),\r\n" + 
			"(343,'ASTROFISICO'),\r\n" + 
			"(344,'ASTROLOGO'),\r\n" + 
			"(345,'ASTRONOMO'),\r\n" + 
			"(346,'ATLETA'),\r\n" + 
			"(347,'AUDITOR'),\r\n" + 
			"(348,'AUDITOR GENERAL, ADMINISTRACION PUBLICA'),\r\n" + 
			"(349,'AUTOMOVILISTA, CARRERAS'),\r\n" + 
			"(350,'AUTOR'),\r\n" + 
			"(351,'AUTOR, DRAMA'),\r\n" + 
			"(352,'AUTOR, LETRA DE CANCIONES'),\r\n" + 
			"(353,'AUTOR, TEATRO'),\r\n" + 
			"(354,'AUXILIAR DE EDUCACION (ENCARGADO DE CURSO)'),\r\n" + 
			"(355,'AUXILIAR DE LA CAMARA DE MAQUINAS,BARCOS'),\r\n" + 
			"(356,'AUXILIAR DE OFICINA'),\r\n" + 
			"(357,'AUXILIAR DE PARTERA'),\r\n" + 
			"(358,'AUXILIAR DE TREN DE LAMINACION'),\r\n" + 
			"(359,'AUXILIAR ESTADISTICO (EMPLEADO ESTADISTICO)'),\r\n" + 
			"(360,'AUXILIAR FARMACEUTICO'),\r\n" + 
			"(361,'AUXILIAR MATEMATICO'),\r\n" + 
			"(362,'AUXILIAR MEDICO'),\r\n" + 
			"(363,'AUXILIAR VETERINARIO'),\r\n" + 
			"(364,'AUXILIAR, ABOGACIA'),\r\n" + 
			"(365,'AUXILIAR, ACTUARIO'),\r\n" + 
			"(366,'AUXILIAR, AGENTE DE BOLSA'),\r\n" + 
			"(367,'AUXILIAR, BUFETE/ABOGADO'),\r\n" + 
			"(368,'AUXILIAR, CONTADOR'),\r\n" + 
			"(369,'AUXILIAR, DENTISTA'),\r\n" + 
			"(370,'AUXILIAR, ENFERMERIA'),\r\n" + 
			"(371,'AUXILIAR, ENFERMERIA/PRIMEROS AUXILIOS'),\r\n" + 
			"(372,'AUXILIAR, HOSPITALARIO'),\r\n" + 
			"(373,'AVENTADOR DE GRANOS,MOLINO'),\r\n" + 
			"(374,'AVIACION, OFICIAL'),\r\n" + 
			"(375,'AVIACION, PERSONAL DE SERVICIO MILITAR'),\r\n" + 
			"(376,'AVIACION, SUB OFICIALES'),\r\n" + 
			"(377,'AVIACION, TECNICOS'),\r\n" + 
			"(378,'AVICULTOR'),\r\n" + 
			"(379,'AVICULOR, CRIA/CRIADERO'),\r\n" + 
			"(380,'AVICULTOR, HUEVOS'),\r\n" + 
			"(381,'AVICULTOR, INCUBACION ARTIFICIAL'),\r\n" + 
			"(382,'AVICULTOR, OCAS'),\r\n" + 
			"(383,'AVICULTOR, PATOS'),\r\n" + 
			"(384,'AVICULTOR, PAVOS'),\r\n" + 
			"(385,'AVICULTOR, POLLOS'),\r\n" + 
			"(386,'AYA MAMA'),\r\n" + 
			"(387,'AYUDA DE CAMARA'),\r\n" + 
			"(388,'AYUDANTE DE BIBLIOTECA'),\r\n" + 
			"(389,'AYUDANTE DE CAMION'),\r\n" + 
			"(390,'AYUDANTE DE DIRECCION, CINE'),\r\n" + 
			"(391,'AYUDANTE DE HERRERO'),\r\n" + 
			"(392,'AYUDANTE DE HOJALATERIA'),\r\n" + 
			"(393,'AYUDANTE DE HORNO DE CERAMICA,ENCENDIDO'),\r\n" + 
			"(394,'AYUDANTE DE HORNO DE SEGUNDA FUSION O DE RECALENTADO'),\r\n" + 
			"(395,'AYUDANTE DE MAQUINISTAS DE TREN'),\r\n" + 
			"(396,'AYUDANTE DE MECANICO DE VEHICULOS DE MOTOR'),\r\n" + 
			"(397,'AYUDANTE DE REENCAUCHADOR DE NEUMATICOS'),\r\n" + 
			"(398,'AYUDANTE DE REMACHADOR DE ESTRUCTURAS METALICAS'),\r\n" + 
			"(399,'AYUDANTE DE TREN DE LAMINACION'),\r\n" + 
			"(400,'AYUDANTE, AMBULANCIA'),\r\n" + 
			"(401,'AYUDANTE, BAÐOS SAUNA'),\r\n" + 
			"(402,'AYUDANTE, BAÐOS TURCOS'),\r\n" + 
			"(403,'AYUDANTE, CONSULTORIO DENTAL'),\r\n" + 
			"(404,'AYUDANTE, CONTABLE'),\r\n" + 
			"(405,'AYUDANTE, CULTO'),\r\n" + 
			"(406,'AYUDANTE, DIRECCION CINEMATOGRAFICA'),\r\n" + 
			"(407,'AYUDANTE, ENFERMERIA'),\r\n" + 
			"(408,'AYUDANTE, ENFERMERIA/AMBULANCIA'),\r\n" + 
			"(409,'AYUDANTE, ENFERMERIA/CLINICA'),\r\n" + 
			"(410,'AYUDANTE, ENFERMERIA/DOMICILIO'),\r\n" + 
			"(411,'AYUDANTE, ENFERMERIA/HOSPITAL'),\r\n" + 
			"(412,'AYUDANTE, HORNO ALTO'),\r\n" + 
			"(413,'AYUDANTE, VUELO'),\r\n" + 
			"(414,'AZAFATA, AEROPUERTO'),\r\n" + 
			"(415,'AZAFATA, AVION'),\r\n" + 
			"(416,'AZAFATA, INFORMACION/AEROPUERTO'),\r\n" + 
			"(417,'AZAFATA, SERVICIO DE COMIDAS/PERSONAL'),\r\n" + 
			"(418,'AZOGADOR'),\r\n" + 
			"(419,'BACTERIOLOGO'),\r\n" + 
			"(420,'BACTERIOLOGO, AGRICULTURA'),\r\n" + 
			"(421,'BACTERIOLOGO, ALIMENTACION'),\r\n" + 
			"(422,'BACTERIOLOGO, FARMACIA'),\r\n" + 
			"(423,'BACTERIOLOGO, INDUSTRIA'),\r\n" + 
			"(424,'BACTERIOLOGO, INDUSTRIA, LACTEAS'),\r\n" + 
			"(425,'BACTERIOLOGO, MEDICINA'),\r\n" + 
			"(426,'BACTERIOLOGO, MEDICINA/VETERINARIA'),\r\n" + 
			"(427,'BACTERIOLOGO, PESCA'),\r\n" + 
			"(428,'BACTERIOLOGO, SUELOS'),\r\n" + 
			"(429,'BAÐOS MEDICINALES, TRATAMIENTO'),\r\n" + 
			"(430,'BAILARIN'),\r\n" + 
			"(431,'BAILARIN, BALLET'),\r\n" + 
			"(432,'BAILARIN, PEÐAS, SALSODROMOS, RESTAURANTES TURISTICOS'),\r\n" + 
			"(433,'BAILARIN, SOLISTA'),\r\n" + 
			"(434,'BAILARINA'),\r\n" + 
			"(435,'BAILARINES DE DANZA CLASICA Y MODERNA'),\r\n" + 
			"(436,'BAJO'),\r\n" + 
			"(437,'BAJONISTA'),\r\n" + 
			"(438,'BALLENERO'),\r\n" + 
			"(439,'BALSEROS'),\r\n" + 
			"(440,'BANDERILLERO'),\r\n" + 
			"(441,'BARITONO'),\r\n" + 
			"(442,'BARMAN'),\r\n" + 
			"(443,'BARNIZADOR, CONSTRUCCION'),\r\n" + 
			"(444,'BARNIZADOR,EXCEPTO CONSTRUCCION'),\r\n" + 
			"(445,'BARRENDERO'),\r\n" + 
			"(446,'BARRENDERO, CALLES'),\r\n" + 
			"(447,'BARRENDERO, FABRICAS'),\r\n" + 
			"(448,'BARRENDERO, PLAZAS Y PARQUES/JARDINES'),\r\n" + 
			"(449,'BARRENERO, DINAMITERO'),\r\n" + 
			"(450,'BASKETBOLISTA'),\r\n" + 
			"(451,'BASURERO'),\r\n" + 
			"(452,'BATERISTA'),\r\n" + 
			"(453,'BATIDOR DE CAZA'),\r\n" + 
			"(454,'BATIDOR DE FIBRA'),\r\n" + 
			"(455,'BATIHOJA,JOYERO O PLATERO'),\r\n" + 
			"(456,'BEDEL'),\r\n" + 
			"(457,'BIBLIOTECARIO'),\r\n" + 
			"(458,'BIOESTADISTICO'),\r\n" + 
			"(459,'BIOFISICO'),\r\n" + 
			"(460,'BIOGRAFO'),\r\n" + 
			"(461,'BIOLOGO'),\r\n" + 
			"(462,'BIOLOGO MOLECULAR'),\r\n" + 
			"(463,'BIOLOGO, FAUNA DE AGUA DULCE'),\r\n" + 
			"(464,'BIOLOGO, FAUNA MARINA'),\r\n" + 
			"(465,'BIOLOGO, GENETICA'),\r\n" + 
			"(466,'BIOLOGO, HIDROBIOLOGIA'),\r\n" + 
			"(467,'BIOMETRISTA'),\r\n" + 
			"(468,'BIOQUIMICO'),\r\n" + 
			"(469,'BISELADOR DE CRISTALES'),\r\n" + 
			"(470,'BLANQUEADOR'),\r\n" + 
			"(471,'BLANQUEADOR DE PASTA PARA PAPEL'),\r\n" + 
			"(472,'BLASONISTAS'),\r\n" + 
			"(473,'BOBINADOR ELECTRICISTA'),\r\n" + 
			"(474,'BOBINADOR, TEXTIL'),\r\n" + 
			"(475,'BOMBERO'),\r\n" + 
			"(476,'BOMBERO, ACCIDENTES DE AVIACION'),\r\n" + 
			"(477,'BOMBERO, AEROPUERTOS'),\r\n" + 
			"(478,'BOMBERO, FORESTAL'),\r\n" + 
			"(479,'BOMBERO, REFINO DEL PETROLEO'),\r\n" + 
			"(480,'BONZO'),\r\n" + 
			"(481,'BORDADORES A MANO O A MAQUINA EN GENERAL'),\r\n" + 
			"(482,'BOTANICO'),\r\n" + 
			"(483,'BOTANICO, ECOLOGIA'),\r\n" + 
			"(484,'BOTANICO, ECONOMISTA'),\r\n" + 
			"(485,'BOTANICO, GENETICA'),\r\n" + 
			"(486,'BOTANICO, HISTOLOGIA'),\r\n" + 
			"(487,'BOTANICO, MICOLOGIA'),\r\n" + 
			"(488,'BOTANICO, SUELOS'),\r\n" + 
			"(489,'BOTANICO, TAXONOMIA'),\r\n" + 
			"(490,'BOTONES'),\r\n" + 
			"(491,'BOXEADOR'),\r\n" + 
			"(492,'BOYERO'),\r\n" + 
			"(493,'BRACERO AGRICOLA'),\r\n" + 
			"(494,'BREQUERO DE FERROCARRIL'),\r\n" + 
			"(495,'BROMATOLOGOS'),\r\n" + 
			"(496,'BRONCEADOR'),\r\n" + 
			"(497,'BRUCEROS'),\r\n" + 
			"(498,'BURRERO, TRANSPORTE'),\r\n" + 
			"(499,'BUZO (CONSTR. Y REPARA CIMIENTO DE LOS PUENTES, Y DIQUES, M'),\r\n" + 
			"(500,'BUZO, PESCADOR/ESPONJAS'),\r\n" + 
			"(501,'BUZO, PESCADOR/OSTRAS'),\r\n" + 
			"(502,'CABALLERIZO (OBRERO)'),\r\n" + 
			"(503,'CABALLISTA, ARRASTRE DE VAZONETAS EN MINAS Y CANTERAS'),\r\n" + 
			"(504,'CABALLISTA, CIRCO'),\r\n" + 
			"(505,'CADDIE, O PORTEADOR DE PALOS DE GOLF'),\r\n" + 
			"(506,'CAJERO, ALMACEN/AUTOSERVICIO'),\r\n" + 
			"(507,'CAJERO, APUESTAS'),\r\n" + 
			"(508,'CAJERO, BANCO'),\r\n" + 
			"(509,'CAJERO, COBRADOR DE PEAJES'),\r\n" + 
			"(510,'CAJERO, CONTABILIDAD DE CAJA'),\r\n" + 
			"(511,'CAJERO, EMPRESA/ALMACEN'),\r\n" + 
			"(512,'CAJERO, HOTEL'),\r\n" + 
			"(513,'CAJERO, MOSTRADOR'),\r\n" + 
			"(514,'CAJERO, OFICINA'),\r\n" + 
			"(515,'CAJERO, RESTAURANTE'),\r\n" + 
			"(516,'CAJERO, TIENDA'),\r\n" + 
			"(517,'CAJERO, VENTA DE BILLETES'),\r\n" + 
			"(518,'CAJISTA, IMPRENTA'),\r\n" + 
			"(519,'CALAFATERO,CARPINTERO'),\r\n" + 
			"(520,'CALANDRADOR DE CAUCHO'),\r\n" + 
			"(521,'CALCETERO A MANO'),\r\n" + 
			"(522,'CALCETERO,TEJEDOR A MAQUINA'),\r\n" + 
			"(523,'CALCINADOR, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(524,'CALCULISTA A MAQUINA'),\r\n" + 
			"(525,'CALDERERO, COBRE Y ALEACIONES LIGERAS CHAPAS ACERO'),\r\n" + 
			"(526,'CALENTADOR AL ROJO DE REMACHES'),\r\n" + 
			"(527,'CALLISTA'),\r\n" + 
			"(528,'CAMALERO, MATARIFE'),\r\n" + 
			"(529,'CAMARERO'),\r\n" + 
			"(530,'CAMARERO, BARCO'),\r\n" + 
			"(531,'CAMARERO, HOTELERIA'),\r\n" + 
			"(532,'CAMAROGRAFO'),\r\n" + 
			"(533,'CAMAROGRAFO, CINEMATOGRAFO'),\r\n" + 
			"(534,'CAMAROGRAFO, TELEVISION'),\r\n" + 
			"(535,'CAMARONERO'),\r\n" + 
			"(536,'CAMBISTA, COMPRA-VENTA  DE DOLARES'),\r\n" + 
			"(537,'CAMILLERO'),\r\n" + 
			"(538,'CAMISERA'),\r\n" + 
			"(539,'CAMPESINO'),\r\n" + 
			"(540,'CAMPESINO, TRABAJADOR INDEPENDIENTE'),\r\n" + 
			"(541,'CANALERO TEXTIL'),\r\n" + 
			"(542,'CANCILLER'),\r\n" + 
			"(543,'CANDELERO'),\r\n" + 
			"(544,'CANONIGO'),\r\n" + 
			"(545,'CANTANTE'),\r\n" + 
			"(546,'CANTANTE, CONCIERTO'),\r\n" + 
			"(547,'CANTANTE, CORAL'),\r\n" + 
			"(548,'CANTANTE, JAZZ'),\r\n" + 
			"(549,'CANTANTE, MUSICA POPULAR'),\r\n" + 
			"(550,'CANTANTE, OPERA'),\r\n" + 
			"(551,'CANTINERO'),\r\n" + 
			"(552,'CANTOR AMBULANTE'),\r\n" + 
			"(553,'CAPADOR (OBRERO)'),\r\n" + 
			"(554,'CAPATAZ DE CAMPO DE HACIENDA'),\r\n" + 
			"(555,'CAPATAZ FORESTAL'),\r\n" + 
			"(556,'CAPATAZ O CONTAMESTRE DE LA CONFECCION DE PRODUCTOS DE PAPE'),\r\n" + 
			"(557,'CAPATAZ O CONTRAMAESTRE DE ELABORACION DE BEBIDAS'),\r\n" + 
			"(558,'CAPATAZ O CONTRAMAESTRE DE LA CONSERVACION DE ALIMENTOS'),\r\n" + 
			"(559,'CAPATAZ O CONTRAMAESTRE DE LA FAB. DE PRODUCTOS DE CAUCHO'),\r\n" + 
			"(560,'CAPATAZ O CONTRAMAESTRE DE MINAS Y CANTERAS'),\r\n" + 
			"(561,'CAPELLAN'),\r\n" + 
			"(562,'CAPITAN, ALTURA'),\r\n" + 
			"(563,'CAPITAN, BARCO/NAVEGACION FLUVIAL O LACUSTRE'),\r\n" + 
			"(564,'CAPITAN, BARCO/NAVEGACION MARITIMA'),\r\n" + 
			"(565,'CAPITAN, BUQUE'),\r\n" + 
			"(566,'CAPITAN, MARINA MERCANTE/BARCO'),\r\n" + 
			"(567,'CAPITAN, PESCA'),\r\n" + 
			"(568,'CAPITAN, PUERTO'),\r\n" + 
			"(569,'CAPITAN, REMOLCADOR'),\r\n" + 
			"(570,'CAPITAN, YATE'),\r\n" + 
			"(571,'CAPORAL, MAYORDOMO DE HACIENDA'),\r\n" + 
			"(572,'CARACOLERO'),\r\n" + 
			"(573,'CARAVANERO'),\r\n" + 
			"(574,'CARBONADOR, REFINACION DE AZUCAR'),\r\n" + 
			"(575,'CARBONERO, CARBON VEGETAL'),\r\n" + 
			"(576,'CARBONIZADOR DE LANA'),\r\n" + 
			"(577,'CARCELERO'),\r\n" + 
			"(578,'CARDADOR DE FIBRAS'),\r\n" + 
			"(579,'CARDIOLOGO'),\r\n" + 
			"(580,'CARGADOR'),\r\n" + 
			"(581,'CARGADOR DE BULTOS'),\r\n" + 
			"(582,'CARGADOR DE HORNO ALTO'),\r\n" + 
			"(583,'CARGADOR DE SEDA'),\r\n" + 
			"(584,'CARGADOR, BUQUES'),\r\n" + 
			"(585,'CARGADOR, BUQUES CISTERNA/LIQUIDO'),\r\n" + 
			"(586,'CARGADOR, CAMIONES'),\r\n" + 
			"(587,'CARGADOR, MUEBLES'),\r\n" + 
			"(588,'CARGADOR, VEHICULOS/TRANSPORTE POR CARRETERA'),\r\n" + 
			"(589,'CARGADOR-DESCARGADOR DE HORNO,DE CERAMICA'),\r\n" + 
			"(590,'CARGAS DE ENERGIA ELECTRICA'),\r\n" + 
			"(591,'CARICATO'),\r\n" + 
			"(592,'CARICATURISTA'),\r\n" + 
			"(593,'CARPINTERIA METALICA'),\r\n" + 
			"(594,'CARPINTERO DE ARMA, TRABAJO DE ENCOFRADO'),\r\n" + 
			"(595,'CARPINTERO DE AVIACION'),\r\n" + 
			"(596,'CARPINTERO DE PUERTA Y VENTANAS'),\r\n" + 
			"(597,'CARPINTERO DE RIVERA'),\r\n" + 
			"(598,'CARPINTERO EBANISTA, CONSTRUCCION DE BARCOS'),\r\n" + 
			"(599,'CARPINTERO EBANISTA, CONSTRUCCION DE EDIFICIOS'),\r\n" + 
			"(600,'CARPINTERO EN CONSTRUC EN GRAL,EXC:ARMA,TRAB.DE ENCOFRADO'),\r\n" + 
			"(601,'CARPINTERO MECANICO'),\r\n" + 
			"(602,'CARPINTERO NAVAL O CALAFATERO'),\r\n" + 
			"(603,'CARPINTERO-ARMADOR DE EMBARCACIONES'),\r\n" + 
			"(604,'CARPINTERO-EBANISTA DE CONSTRUCCION'),\r\n" + 
			"(605,'CARRETERO, CONDUCTOR DE VEHICULOS DE TRACCION'),\r\n" + 
			"(606,'CARRETILLERO, CARGADOR AMBULANTE DE MERCANCIAS'),\r\n" + 
			"(607,'CARROCERO, AUTOMOVILES, AVIONES Y OTROS'),\r\n" + 
			"(608,'CARROCERO, CARROCERIAS DE MADERA'),\r\n" + 
			"(609,'CARTERO'),\r\n" + 
			"(610,'CARTOGRAFO'),\r\n" + 
			"(611,'CARTOGRAFO, MARINA'),\r\n" + 
			"(612,'CARTOMANTICO'),\r\n" + 
			"(613,'CARTONERO A MANO'),\r\n" + 
			"(614,'CARTONERO A MAQUINA'),\r\n" + 
			"(615,'CATADOR DE CAFE O DE TE'),\r\n" + 
			"(616,'CATCHASCANISTA'),\r\n" + 
			"(617,'CAVADOR, ZANJAS Y ACEQUIAS'),\r\n" + 
			"(618,'CAZADOR DE ANIMALES DE PIELES'),\r\n" + 
			"(619,'CAZADOR DE ANIMALES SALVAJES'),\r\n" + 
			"(620,'CAZADOR DE AVES'),\r\n" + 
			"(621,'CAZADOR DE MONOS'),\r\n" + 
			"(622,'CAZADOR DE SERPIENTES'),\r\n" + 
			"(623,'CAZADOR DE VENADO, CHINCHILLA'),\r\n" + 
			"(624,'CAZADOR, BALLENAS'),\r\n" + 
			"(625,'CAZADOR, OTROS'),\r\n" + 
			"(626,'CAZADORES DE OTROS ANIMALES ACUATICOS (FOCAS, LOBOS MARINOS'),\r\n" + 
			"(627,'CAZADORES DE TORTUGAS MARINAS'),\r\n" + 
			"(628,'CEMENTADOR DE METALES'),\r\n" + 
			"(629,'CEMENTADOR DE METALES POR CARBONIZACION'),\r\n" + 
			"(630,'CEMENTADOR DE METALES POR CIANURIZACION'),\r\n" + 
			"(631,'CEMENTADOR DE METALES POR NUTRICION'),\r\n" + 
			"(632,'CEMENTADOR, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(633,'CEMENTERO DE HORMIGON ARMADO,EN GENERAL'),\r\n" + 
			"(634,'CEMENTERO,TRABAJO DE ACABADO'),\r\n" + 
			"(635,'CEPILLADOR DE MADERA'),\r\n" + 
			"(636,'CEPILLADOR DE METALES'),\r\n" + 
			"(637,'CEPILLADOR DE PANA'),\r\n" + 
			"(638,'CERAMISTA ARTISTICO'),\r\n" + 
			"(639,'CERAMISTA EN GRAL,EXCEPTO ADOBES,LADRILLOS,TEJAS'),\r\n" + 
			"(640,'CERAMISTA MOLDES, A MANO EXCEPTO LADRILLOS, ADOBES, TEJAS'),\r\n" + 
			"(641,'CERERO'),\r\n" + 
			"(642,'CERRAJERO'),\r\n" + 
			"(643,'CERVECERO, GERMINACION'),\r\n" + 
			"(644,'CHACINERO'),\r\n" + 
			"(645,'CHALEQUERO,CONFECCION EN SERIE'),\r\n" + 
			"(646,'CHANCAQUERO, ELABORADOR DE CHANCACA'),\r\n" + 
			"(647,'CHAPEADOR DE MUEBLES DE MADERA'),\r\n" + 
			"(648,'CHAPISTA EN GRAL., CALDERO, HOJALATERO, DECORACION	'),\r\n" + 
			"(649,'CHARCUTERO'),\r\n" + 
			"(650,'CHAROLADOR'),\r\n" + 
			"(651,'CHOCOLATERO, PREPARADOR'),\r\n" + 
			"(652,'CHOFER DE ENTREGA DE COCHES NUEVOS'),\r\n" + 
			"(653,'CHOFER DE MONTACARGAS(CONSTRUCCION)'),\r\n" + 
			"(654,'CHOFER DE MONTACARGAS(EXCEPTO CONSTRUCCION)'),\r\n" + 
			"(655,'CHOFER DE TAXI'),\r\n" + 
			"(656,'CHOFER PARTICULAR'),\r\n" + 
			"(657,'CHORERO'),\r\n" + 
			"(658,'CHORICERO'),\r\n" + 
			"(659,'CHURRERO, PREPARADOR'),\r\n" + 
			"(660,'CIENTIFICO, CIENCIAS POLITICAS'),\r\n" + 
			"(661,'CIGARRERO A MANO'),\r\n" + 
			"(662,'CIGARRERO A MAQUINA'),\r\n" + 
			"(663,'CINCELADOR DE PIEZAS DE CERAMICA'),\r\n" + 
			"(664,'CINCELADOR-ORFEBRE'),\r\n" + 
			"(665,'CINEASTA'),\r\n" + 
			"(666,'CIRUJANO'),\r\n" + 
			"(667,'CIRUJANO PLASTICO'),\r\n" + 
			"(668,'CIRUJANO, BUCODENTAL'),\r\n" + 
			"(669,'CIRUJANO, CARDIOLOGIA'),\r\n" + 
			"(670,'CIRUJANO, CIRUGIA GENERAL'),\r\n" + 
			"(671,'CIRUJANO, CIRUGIA PLASTICA'),\r\n" + 
			"(672,'CIRUJANO, DENTISTA'),\r\n" + 
			"(673,'CIRUJANO, NEUROCIRUGIA'),\r\n" + 
			"(674,'CIRUJANO, ORTOPEDIA'),\r\n" + 
			"(675,'CIRUJANO, OSTEOPATA'),\r\n" + 
			"(676,'CIRUJANO, TORAX'),\r\n" + 
			"(677,'CITARISTA'),\r\n" + 
			"(678,'CITOLOGO'),\r\n" + 
			"(679,'CITOLOGO, BOTANICA'),\r\n" + 
			"(680,'CITOLOGO, ZOOLOGIA'),\r\n" + 
			"(681,'CLARINETISTA'),\r\n" + 
			"(682,'CLASIFICADOR DE CAFE O DE TE'),\r\n" + 
			"(683,'CLASIFICADOR DE CIGARROS'),\r\n" + 
			"(684,'CLASIFICADOR DE CUEROS Y PELLEJOS'),\r\n" + 
			"(685,'CLASIFICADOR DE FIBRA'),\r\n" + 
			"(686,'CLASIFICADOR DE MADERA'),\r\n" + 
			"(687,'CLASIFICADOR DE PIEDRA'),\r\n" + 
			"(688,'CLASIFICADOR DE PIELES'),\r\n" + 
			"(689,'CLASIFICADOR DE TABACO'),\r\n" + 
			"(690,'CLASIFICADOR DE TRENES'),\r\n" + 
			"(691,'CLASIFICADOR DE VINOS'),\r\n" + 
			"(692,'CLASIFICADOR, CORRESPONDENCIA'),\r\n" + 
			"(693,'CLASIFICADOR, POLLOS'),\r\n" + 
			"(694,'CLASIFICADOR, ROPA/LAVANDERIA'),\r\n" + 
			"(695,'CLASIFICADOR, TRONCOS'),\r\n" + 
			"(696,'CLAVADOR DE PIELES'),\r\n" + 
			"(697,'CLAVECINISTA'),\r\n" + 
			"(698,'CLIMATOLOGO'),\r\n" + 
			"(699,'CLISADOR, FOTOGRABADOR'),\r\n" + 
			"(701,'CLISADOR-ELECTROTIPISTA'),\r\n" + 
			"(702,'COBRADOR A DOMICILIO, VENTAS A PLAZOS'),\r\n" + 
			"(703,'COBRADOR CONTRIBUCIONES'),\r\n" + 
			"(704,'COBRADOR CONTRIBUCIONES'),\r\n" + 
			"(705,'COBRADOR DE AUTOS'),\r\n" + 
			"(706,'COBRADOR ESPECTACULOS'),\r\n" + 
			"(707,'COBRADOR, ALQUILERES'),\r\n" + 
			"(708,'COBRADOR, AUTOBUSES Y MICROBUSES'),\r\n" + 
			"(709,'COBRADOR, DEUDAS'),\r\n" + 
			"(710,'COBRADOR, FACTURAS'),\r\n" + 
			"(711,'COBRADOR, IMPUESTOS'),\r\n" + 
			"(712,'COBRADOR, PASAJE/ CAMIONETA RURAL (COMBI)'),\r\n" + 
			"(713,'COBRADOR, PASAJE/ FERROCARRIL'),\r\n" + 
			"(714,'COBRADOR, PASAJE/ MICROBUS Y OMNIBUS'),\r\n" + 
			"(715,'COBRADOR, PEAJE'),\r\n" + 
			"(716,'COBRADOR, SEGUROS'),\r\n" + 
			"(717,'COBRADOR, TRANSPORTE POR CARRETERA'),\r\n" + 
			"(718,'COCEDOR DE MALTA'),\r\n" + 
			"(719,'COCEDOR DE MOSTO, CERVEZA'),\r\n" + 
			"(720,'COCEDOR DE SALSAS Y CONDIMENTOS'),\r\n" + 
			"(721,'COCEDOR, REFINACION DE AZUCAR'),\r\n" + 
			"(722,'COCEDOR, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(723,'COCEDOR-CONSERVERO, EN GENERAL'),\r\n" + 
			"(724,'COCEDOR-ESTERILIZADOR'),\r\n" + 
			"(725,'COCHERO DE PUNTO'),\r\n" + 
			"(726,'COCINERO'),\r\n" + 
			"(727,'COCINERO, BARCO'),\r\n" + 
			"(728,'COCINERO, CHEF'),\r\n" + 
			"(729,'COCINERO, CONSERVACION DE ALIMENTOS'),\r\n" + 
			"(730,'COCINERO, DIETAS ESPECIALES'),\r\n" + 
			"(731,'COCINERO, VEGETALES'),\r\n" + 
			"(732,'COLADOR DE CERAMICA,EXCEPTO DE ADOBE Y LADRILLO'),\r\n" + 
			"(733,'COLADOR DE HORNO A PRESION'),\r\n" + 
			"(734,'COLADOR DE HORNO ALTO'),\r\n" + 
			"(735,'COLADOR DE HORNO DE SEGUNDA FUSION'),\r\n" + 
			"(736,'COLADOR DE LADRILLOS Y TEJAS'),\r\n" + 
			"(737,'COLADOR DE MOLDES A MAQUINA CENTRIFUGADORA'),\r\n" + 
			"(738,'COLADOR EN MOLDES, PIEZAS DE METAL'),\r\n" + 
			"(739,'COLCHONERO'),\r\n" + 
			"(740,'COLECTOR DE MUESTRAS,MINAS'),\r\n" + 
			"(741,'COLOCACION DE LOSAS,SUELO, SOLADOR'),\r\n" + 
			"(742,'COLOCADOR DE BALDOSAS SINTETICAS'),\r\n" + 
			"(743,'COLOCADOR DE CABLES GRUESOS SUBTERRANEOS'),\r\n" + 
			"(744,'COLOCADOR DE CAÐERIAS PRINCIPALES DE AGUA'),\r\n" + 
			"(745,'COLOCADOR DE CUBIERTAS DE ASFALTO, DE JUNCO DE METAL'),\r\n" + 
			"(746,'COLOCADOR DE LABRILLOS EN GENERAL'),\r\n" + 
			"(747,'COLOCADOR DE LUNAS DE VEHICULOS'),\r\n" + 
			"(748,'COLOCADOR DE PARQUET'),\r\n" + 
			"(749,'COLOCADOR DE TABLAS, PANADERIA'),\r\n" + 
			"(750,'COLOCADOR DE TEJAS, TECHADOR'),\r\n" + 
			"(751,'COLOCADOR DE TUBOS, CONDUCCIONES'),\r\n" + 
			"(752,'COLOCADOR DE VIDRIOS EN VENTANAS'),\r\n" + 
			"(753,'COMADRONA (PARTERA PRACTICA)'),\r\n" + 
			"(754,'COMANDANTE, AERONAVE'),\r\n" + 
			"(755,'COMANDANTE, BARCO/NAVEGACION INTERIOR (LAGOS, RIOS)'),\r\n" + 
			"(756,'COMANDANTE, BARCO/NAVEGACION MARITIMA'),\r\n" + 
			"(757,'COMBERO'),\r\n" + 
			"(758,'COMBINADOR DE PIELES VALIOSAS'),\r\n" + 
			"(759,'COMEDIANTE'),\r\n" + 
			"(760,'COMENTARISTA, ACTUALIDADES'),\r\n" + 
			"(761,'COMENTARISTA, DEPORTES'),\r\n" + 
			"(762,'COMENTARISTA, RADIO Y TELEVISION'),\r\n" + 
			"(763,'COMENTARISTA-ENTREVISTADOR, TELEVISION - RADIO'),\r\n" + 
			"(764,'COMERCIANTE, ARTICULOS DEPORTIVOS'),\r\n" + 
			"(765,'COMERCIANTE, ARTICULOS ELECTRODOMESTICOS'),\r\n" + 
			"(766,'COMERCIANTE, BOUTIQUE'),\r\n" + 
			"(767,'COMERCIANTE, CALZADO'),\r\n" + 
			"(768,'COMERCIANTE, CARROS'),\r\n" + 
			"(769,'COMERCIANTE, COMBUSTIBLE/GRIFERO (DESPACHADOR DE GASOLINA)'),\r\n" + 
			"(770,'COMERCIANTE, COMERCIO AL POR MAYOR'),\r\n" + 
			"(771,'COMERCIANTE, JOYERIA Y RELOJERIA'),\r\n" + 
			"(772,'COMERCIANTE, JUGUETES'),\r\n" + 
			"(773,'COMERCIANTE, LICORES'),\r\n" + 
			"(774,'COMERCIANTE, LOZA Y PORCELANA'),\r\n" + 
			"(775,'COMERCIANTE, MAYORISTA'),\r\n" + 
			"(776,'COMERCIANTE, MINORISTA'),\r\n" + 
			"(777,'COMERCIANTE, MUEBLES'),\r\n" + 
			"(778,'COMERCIANTE, OPTICA'),\r\n" + 
			"(779,'COMERCIANTE, PRENDAS DE VESTIR'),\r\n" + 
			"(780,'COMERCIANTE, REPUESTOS EN GENERAL'),\r\n" + 
			"(781,'COMERCIO N.E.'),\r\n" + 
			"(782,'COMICO'),\r\n" + 
			"(783,'COMICO, CIRCO'),\r\n" + 
			"(784,'COMPAGINADOR DE FOTO-COMPOSICION'),\r\n" + 
			"(785,'COMPORTERO, REFINACION DE AZUCAR'),\r\n" + 
			"(786,'COMPOSITOR'),\r\n" + 
			"(787,'COMPOSITOR,IMPOSICION'),\r\n" + 
			"(788,'COMPRA VENTA DE MONEDAS Y BILLETES'),\r\n" + 
			"(789,'COMPRADOR'),\r\n" + 
			"(790,'COMPRADOR VENDEDOR DE ORO, PLATA'),\r\n" + 
			"(791,'COMPRADOR, MERCANCIAS/COMERCIO MAYORISTA'),\r\n" + 
			"(792,'COMPRADOR, MERCANCIAS/COMERCIO MINORISTA'),\r\n" + 
			"(793,'COMPRADOR, VENDEDOR AMBULANTE DE MONEDAS Y BILLETES'),\r\n" + 
			"(794,'COMPROBADOR DE TEJIDOS'),\r\n" + 
			"(795,'CONCERTADOR, COROS'),\r\n" + 
			"(796,'CONCERTISTA CANTANTE'),\r\n" + 
			"(797,'CONCERTISTA INSTRUMENTISTA'),\r\n" + 
			"(798,'CONCESIONARIO-ADM., REST. Y BAR/CAFETERIA (TREN, BARCO, AVI'),\r\n" + 
			"(799,'CONCESIONARIO-ADM., REST. Y CAFETERIA (FAB. Y OFIC.)'),\r\n" + 
			"(800,'CONCHERO'),\r\n" + 
			"(801,'CONCILIADOR, LABORAL'),\r\n" + 
			"(802,'CONCILIADOR, RELACIONES LABORALES'),\r\n" + 
			"(803,'CONDUCTOR - CHOFER DE MAQUINARIA AGRICOLA'),\r\n" + 
			"(804,'CONDUCTOR DE ALQUITRANADORA ASFALTADORA'),\r\n" + 
			"(805,'CONDUCTOR DE ANIMALES DE CARGA'),\r\n" + 
			"(806,'CONDUCTOR DE APISONADORA'),\r\n" + 
			"(807,'CONDUCTOR DE APLANADORA DE CAMINOS'),\r\n" + 
			"(808,'CONDUCTOR DE ASFALTADORA'),\r\n" + 
			"(809,'CONDUCTOR DE ATACADOR MECANICO CONSTRUCCION'),\r\n" + 
			"(810,'CONDUCTOR DE AUTOBUS, AUTOMOVIL, CAMIONETA, CAMION O FURGON'),\r\n" + 
			"(811,'CONDUCTOR DE BULLDOZER'),\r\n" + 
			"(812,'CONDUCTOR DE CAMION VOLQUETE'),\r\n" + 
			"(813,'CONDUCTOR DE CANGILON DE ARRASTRE'),\r\n" + 
			"(814,'CONDUCTOR DE CARRETA DE TRANSPORTE TRONCOS, ROLLIZOS Y FUST'),\r\n" + 
			"(815,'CONDUCTOR DE CARRETILLA ELEVADORA'),\r\n" + 
			"(816,'CONDUCTOR DE CARRETON DE HORQUILLA ELEVADORA'),\r\n" + 
			"(817,'CONDUCTOR DE CHAROLADORA, PAPEL'),\r\n" + 
			"(818,'CONDUCTOR DE CINTA TRANSPORTADORA'),\r\n" + 
			"(819,'CONDUCTOR DE COMPRESAS DE AIRE, DE GAS'),\r\n" + 
			"(820,'CONDUCTOR DE DESCORTEZADORA'),\r\n" + 
			"(821,'CONDUCTOR DE DESFIBRADORA DE MADERA'),\r\n" + 
			"(822,'CONDUCTOR DE DRAGA'),\r\n" + 
			"(823,'CONDUCTOR DE DRAGALINA'),\r\n" + 
			"(824,'CONDUCTOR DE ELEVADOR  DE CARGA'),\r\n" + 
			"(825,'CONDUCTOR DE ENGOMADORA, PAPEL'),\r\n" + 
			"(826,'CONDUCTOR DE ESPARCIDORA ACABADORA PARA CAMINO'),\r\n" + 
			"(827,'CONDUCTOR DE EXCAVADORA'),\r\n" + 
			"(828,'CONDUCTOR DE EXPLANADORA Y DE ESCRAPER'),\r\n" + 
			"(829,'CONDUCTOR DE GOFRADORA, PAPEL'),\r\n" + 
			"(830,'CONDUCTOR DE GRUA APILADORA'),\r\n" + 
			"(831,'CONDUCTOR DE GRUA FIJA'),\r\n" + 
			"(832,'CONDUCTOR DE GRUA FLOTANTE'),\r\n" + 
			"(833,'CONDUCTOR DE GRUA LOCOMOVIL'),\r\n" + 
			"(834,'CONDUCTOR DE GRUA MOVIL'),\r\n" + 
			"(835,'CONDUCTOR DE GRUA SOBRE PLATAFORMA MOVIL.FERRC.'),\r\n" + 
			"(836,'CONDUCTOR DE GRUA,SOBRE VAGON DE FERROCARRILES'),\r\n" + 
			"(837,'CONDUCTOR DE HORMIGONERA'),\r\n" + 
			"(838,'CONDUCTOR DE INSTALACION DISTRIBUIDORA PARA LA PREPARACION'),\r\n" + 
			"(839,'CONDUCTOR DE INSTALACIONES DEPURADORA DE AGUA'),\r\n" + 
			"(840,'CONDUCTOR DE JAULAS,MINAS'),\r\n" + 
			"(841,'CONDUCTOR DE LOCOMOTORA EN MINAS Y CANTERAS'),\r\n" + 
			"(842,'CONDUCTOR DE LOCOMOTORAS DE MANIOBRAS'),\r\n" + 
			"(843,'CONDUCTOR DE MAQUINA CONTINUA DE ARRANQUE'),\r\n" + 
			"(844,'CONDUCTOR DE MAQUINA DE ABRIR HOYOS'),\r\n" + 
			"(845,'CONDUCTOR DE MAQUINA DE ABRIR TUNELES'),\r\n" + 
			"(846,'CONDUCTOR DE MAQUINA DE ESTIRADO DE CAUCHO'),\r\n" + 
			"(847,'CONDUCTOR DE MAQUINA DE ESTIRAR VIDRIO PLANO'),\r\n" + 
			"(848,'CONDUCTOR DE MAQUINA DE SOLDAR POR ARCO ELECTRICO'),\r\n" + 
			"(849,'CONDUCTOR DE MAQUINA HINCADORA DE PILOTES'),\r\n" + 
			"(850,'CONDUCTOR DE MAQUINA ROZADORA, CORTADORA, PERFORADORA,ETC'),\r\n" + 
			"(851,'CONDUCTOR DE MAQUINAS DE ABRIR ZANJAS'),\r\n" + 
			"(852,'CONDUCTOR DE MAQUINAS DE EXCAVAR ZANJAS'),\r\n" + 
			"(853,'CONDUCTOR DE MAQUINAS DE FABRICAR TUBOS PAPEL'),\r\n" + 
			"(854,'CONDUCTOR DE MARTINETE'),\r\n" + 
			"(855,'CONDUCTOR DE MOJADORAS, PASTA DE PAPEL'),\r\n" + 
			"(856,'CONDUCTOR DE MOTOCICLETA'),\r\n" + 
			"(857,'CONDUCTOR DE NIVELADORA CON CUCHILLA FRONTAL,BULLDOZER'),\r\n" + 
			"(858,'CONDUCTOR DE NIVELADORA Y ESCRAPER'),\r\n" + 
			"(859,'CONDUCTOR DE ONDULADORA, PAPEL'),\r\n" + 
			"(860,'CONDUCTOR DE PALA MECANICA'),\r\n" + 
			"(861,'CONDUCTOR DE PARAFINADORA, PAPEL'),\r\n" + 
			"(862,'CONDUCTOR DE PAVIMENTADORA EN HORMIGON'),\r\n" + 
			"(863,'CONDUCTOR DE PERFORAD.DE AIRE COMPRIMIDO,CONST.'),\r\n" + 
			"(864,'CONDUCTOR DE PRENSA DE EMBUTIR EL CARTON'),\r\n" + 
			"(865,'CONDUCTOR DE PRENSA DE ESTIRAR METALES'),\r\n" + 
			"(866,'CONDUCTOR DE PRENSA DE HELIOGRABADO'),\r\n" + 
			"(867,'CONDUCTOR DE PUENTE GRUA O GRUA DE PORTICO'),\r\n" + 
			"(868,'CONDUCTOR DE TORRE GRUA'),\r\n" + 
			"(869,'CONDUCTOR DE TRITURADORAS, PULPA DE MADERA'),\r\n" + 
			"(870,'CONDUCTOR DE VAGONERA LANZADERA,MINAS'),\r\n" + 
			"(871,'CONDUCTOR MAQ DE REVELAR Y SECAR PELICULA CINEMATOGRAFICA'),\r\n" + 
			"(872,'CONDUCTOR, ANIMALES/CANTERAS, CARRETERAS'),\r\n" + 
			"(873,'CONDUCTOR, ANIMALES/MINAS'),\r\n" + 
			"(874,'CONDUCTOR, BICICLETA'),\r\n" + 
			"(875,'CONDUCTOR, BOVINOS'),\r\n" + 
			"(876,'CONDUCTOR, CARRO DE MANO'),\r\n" + 
			"(877,'CONDUCTOR, MAQUINARIA AGRICOLA/NO MOTORIZADA'),\r\n" + 
			"(878,'CONDUCTOR, MULAS, ASEMILEROS; MULERO, TRANSPORTES'),\r\n" + 
			"(879,'CONDUCTOR, RECUAS'),\r\n" + 
			"(880,'CONDUCTOR, SILLA DE MANOS'),\r\n" + 
			"(881,'CONDUCTOR, TRICICLO/NO MOTORIZADO'),\r\n" + 
			"(882,'CONDUCTOR, VEHICULO A PEDALES'),\r\n" + 
			"(883,'CONDUCTOR, VEHICULO DE TRACCION ANIMAL/CANTERAS'),\r\n" + 
			"(884,'CONDUCTOR, VEHICULO DE TRACCION ANIMAL/CARRETERAS'),\r\n" + 
			"(885,'CONDUCTOR, VEHICULO DE TRACCION ANIMAL/MINAS'),\r\n" + 
			"(886,'CONDUCTOR, VELOCIPEDO DE TRANSPORTE'),\r\n" + 
			"(887,'CONDUCTOR,AGENTE DE MANIOBRAS'),\r\n" + 
			"(888,'CONDUCTORES DE CAMIONES PESADOS'),\r\n" + 
			"(889,'CONDUCTORES DE GRUAS Y OPERADORES DE INSTALACIONES DE ELEVA'),\r\n" + 
			"(890,'CONDUCTORES DE PERFORADORA DE PERCUSION, POZOS DE PETROLEO'),\r\n" + 
			"(891,'CONDUCTORES DE TREN DE SONDEO POR ROTACION, POZOS DE PETROL'),\r\n" + 
			"(892,'CONFECC ALFOMBRAS JUNCO,PITA,ESPARTO,FIBRA COCO'),\r\n" + 
			"(893,'CONFECC. ARTIC. ADORNOS Y FANTASIA EN PAPEL'),\r\n" + 
			"(894,'CONFECC.DE ZAPATOS DE RAFIA Y FIBRAS SEMEJANTES'),\r\n" + 
			"(895,'CONFECCIONADOR A MANO DE CEPILLO'),\r\n" + 
			"(896,'CONFECCIONADOR A MANO DE PIEZAS DE METAL'),\r\n" + 
			"(897,'CONFECCIONADOR A MAQ. DE BOLSAS Y SOBRES DE PAPEL'),\r\n" + 
			"(898,'CONFECCIONADOR A MAQUINA DE BROCHAS Y CEPILLOS'),\r\n" + 
			"(899,'CONFECCIONADOR DE ALFOMBRAS DE NUDOS A MANO'),\r\n" + 
			"(900,'CONFECCIONADOR DE ARTESANIA CON FIBRA ACRILICA'),\r\n" + 
			"(901,'CONFECCIONADOR DE ARTICULOS MADERA PARA DEPORTE'),\r\n" + 
			"(902,'CONFECCIONADOR DE BOLSAS DE CELOFAN'),\r\n" + 
			"(903,'CONFECCIONADOR DE BOLSAS DE HILO'),\r\n" + 
			"(904,'CONFECCIONADOR DE BROCHAS'),\r\n" + 
			"(905,'CONFECCIONADOR DE CAJAS DE CARTON'),\r\n" + 
			"(906,'CONFECCIONADOR DE CALZADO DE CAÐAMO'),\r\n" + 
			"(907,'CONFECCIONADOR DE CALZADO DE LONA'),\r\n" + 
			"(908,'CONFECCIONADOR DE CIERRES'),\r\n" + 
			"(909,'CONFECCIONADOR DE COLCHAS'),\r\n" + 
			"(910,'CONFECCIONADOR DE CONOS DE FIELTRO PARA SOMBREROS'),\r\n" + 
			"(911,'CONFECCIONADOR DE CORTINAS'),\r\n" + 
			"(912,'CONFECCIONADOR DE DIENTES ARTIFICIALES'),\r\n" + 
			"(913,'CONFECCIONADOR DE EDREDONES'),\r\n" + 
			"(914,'CONFECCIONADOR DE ESCOBAS A MANO'),\r\n" + 
			"(915,'CONFECCIONADOR DE ESTERAS,ESTERONES'),\r\n" + 
			"(916,'CONFECCIONADOR DE FELPUDOS DE JEBE O LLANTA'),\r\n" + 
			"(917,'CONFECCIONADOR DE FLORES ARTIFICIALES(DE TELA)'),\r\n" + 
			"(918,'CONFECCIONADOR DE MALETAS DE CARTON'),\r\n" + 
			"(919,'CONFECCIONADOR DE MUEBLES DE CANA,JUNCO,MIMBRE'),\r\n" + 
			"(920,'CONFECCIONADOR DE MUNECOS Y JUGUETES DE TRAPO'),\r\n" + 
			"(921,'CONFECCIONADOR DE NEUMATICOS,PRIMERA FASE'),\r\n" + 
			"(922,'CONFECCIONADOR DE OJOTAS O LLANQUES'),\r\n" + 
			"(923,'CONFECCIONADOR DE PAPEL'),\r\n" + 
			"(924,'CONFECCIONADOR DE PELUCAS'),\r\n" + 
			"(925,'CONFECCIONADOR DE PINCELES FINOS'),\r\n" + 
			"(926,'CONFECCIONADOR DE PLUMEROS DE TELA'),\r\n" + 
			"(927,'CONFECCIONADOR DE POSTIZOS'),\r\n" + 
			"(928,'CONFECCIONADOR DE PRODUCTOS DE PLASTICO'),\r\n" + 
			"(929,'CONFECCIONADOR DE ROPA DE TAPICERIA'),\r\n" + 
			"(930,'CONFECCIONADOR DE SELLOS DE CAUCHO'),\r\n" + 
			"(931,'CONFECCIONADOR DE SOBRES A MANO'),\r\n" + 
			"(932,'CONFECCIONADOR DE TAPIAS DE JUNCO FINO'),\r\n" + 
			"(933,'CONFECCIONADOR DE TEJIDOS DE PUNTO'),\r\n" + 
			"(934,'CONFECCIONADOR DE VELAS Y BUJIAS'),\r\n" + 
			"(935,'CONFECCIONADOR DE VELAS,CARPAS Y TOLDOS'),\r\n" + 
			"(936,'CONFECCIONADOR DE VELOS Y MANTILLAS A MAQUINA'),\r\n" + 
			"(937,'CONFECCIONADOR MUEBLES MADERA PARA EL HOGAR U OFICINA'),\r\n" + 
			"(938,'CONFITERO, PREPARADOR'),\r\n" + 
			"(939,'CONGELADOR DE ALIMENTOS'),\r\n" + 
			"(940,'CONGRESISTA'),\r\n" + 
			"(941,'CONSEJERO DE EDUCACION'),\r\n" + 
			"(942,'CONSEJERO JURIDICO, EMPRESA'),\r\n" + 
			"(943,'CONSEJERO JURIDICO, IMPUESTOS'),\r\n" + 
			"(944,'CONSEJERO VOCACIONAL'),\r\n" + 
			"(945,'CONSEJERO, AGRICOLA'),\r\n" + 
			"(946,'CONSEJERO, EMPLEO'),\r\n" + 
			"(947,'CONSEJERO, FORESTAL'),\r\n" + 
			"(948,'CONSEJERO, GOBIERNO'),\r\n" + 
			"(949,'CONSEJERO, ORIENTACION PROFESIONAL'),\r\n" + 
			"(950,'CONSEJERO, PERSPECTIVAS DE CARRERA'),\r\n" + 
			"(951,'CONSEJERO, SERVICIO POSTVENTA'),\r\n" + 
			"(952,'CONSEJERO, TURISMO'),\r\n" + 
			"(953,'CONSERJE'),\r\n" + 
			"(954,'CONSERJE, EDIFICIO/APARTAMENTOS'),\r\n" + 
			"(955,'CONSERJE, HOTEL'),\r\n" + 
			"(956,'CONSERVADOR, GALERIA DE ARTE'),\r\n" + 
			"(957,'CONSERVADOR, MUSEO'),\r\n" + 
			"(958,'CONST INSTRUM VIENTO DE MADERA O DE METAL'),\r\n" + 
			"(959,'CONSTRUCTOR DE ALCANTARILLAS, ALBAÐIL'),\r\n" + 
			"(960,'CONSTRUCTOR DE ATAUDES'),\r\n" + 
			"(961,'CONSTRUCTOR DE BALANZAS'),\r\n" + 
			"(962,'CONSTRUCTOR DE BAROMETROS, TERMOMETROS'),\r\n" + 
			"(963,'CONSTRUCTOR DE BRUJULAS'),\r\n" + 
			"(964,'CONSTRUCTOR DE CANALIZACION POR TUBOS'),\r\n" + 
			"(965,'CONSTRUCTOR DE CARRETAS O CARRETILLAS(MADERA)'),\r\n" + 
			"(966,'CONSTRUCTOR DE CASAS, ALBANIL'),\r\n" + 
			"(967,'CONSTRUCTOR DE KIOSCOS DE MADERA'),\r\n" + 
			"(968,'CONSTRUCTOR DE MACHOS A MANO'),\r\n" + 
			"(969,'CONSTRUCTOR DE MACHOS A MAQUINA'),\r\n" + 
			"(970,'CONSULES EN FUNCION (PERUANOS)'),\r\n" + 
			"(971,'CONTACTOLOGO'),\r\n" + 
			"(972,'CONTADOR'),\r\n" + 
			"(973,'CONTADOR MERCANTIL'),\r\n" + 
			"(974,'CONTADOR, AUDITORIA DE EMPRESAS'),\r\n" + 
			"(975,'CONTADOR, CONTABILIDAD MUNICIPAL'),\r\n" + 
			"(976,'CONTADOR, COSTOS'),\r\n" + 
			"(977,'CONTADOR, COSTOS Y PRECIOS'),\r\n" + 
			"(978,'CONTADOR, EMPRESA'),\r\n" + 
			"(979,'CONTORSIONISTA'),\r\n" + 
			"(980,'CONTRABAJO'),\r\n" + 
			"(981,'CONTRALOR GENERAL'),\r\n" + 
			"(982,'CONTRALTO'),\r\n" + 
			"(983,'CONTRAMAESTRE DE BARCO'),\r\n" + 
			"(984,'CONTRATISTA, MANO DE OBRA'),\r\n" + 
			"(985,'CONTROLADOR ADMINISTRATIVO, FERROCARRIL/MERCANCIAS'),\r\n" + 
			"(986,'CONTROLADOR ADMINISTRATIVO, TRAFICO AEREO'),\r\n" + 
			"(987,'CONTROLADOR ADMINISTRATIVO, TRANSPORTE AEREO'),\r\n" + 
			"(988,'CONTROLADOR ADMINISTRATIVO, TRANSPORTE FERROVIARIO (CARGAS)'),\r\n" + 
			"(989,'CONTROLADOR ADMINISTRATIVO, TRANSPORTE MARITIMO'),\r\n" + 
			"(990,'CONTROLADOR ADMINISTRATIVO, TRANSPORTE POR CARRETERA'),\r\n" + 
			"(991,'CONTROLADOR CALIDAD APARAT. ELECTRIC. Y ELECTRONICOS'),\r\n" + 
			"(992,'CONTROLADOR DE MAQUINA LECTORA TEJEDORA(ALFOMBRAS)'),\r\n" + 
			"(993,'CONTROLADOR DE SONIDO,ESTUDIOS DE RADIO Y TV'),\r\n" + 
			"(994,'CONTROLADOR DE TARJETAS DE PERSONAL'),\r\n" + 
			"(995,'CONTROLADOR DE TEJIDOS'),\r\n" + 
			"(996,'CONTROLADOR DE TEJIDOS'),\r\n" + 
			"(997,'CONTROLADOR DE VAGONES DE LUJO Y PULLMAN'),\r\n" + 
			"(998,'CONTROLADOR, PERFORACIONES'),\r\n" + 
			"(999,'CONTROLADOR, TRAFICO AEREO'),\r\n" + 
			"(1000,'CONTROLADORES DE COCHE-CAMA'),\r\n" + 
			"(1001,'COORDINADOR'),\r\n" + 
			"(1002,'COPIADOR DE FOTOGRAFIAS'),\r\n" + 
			"(1003,'COPILOTO, AERONAVE'),\r\n" + 
			"(1004,'COPISTA DE DISEÐOS PARA CARTONES JACQUARD'),\r\n" + 
			"(1005,'COPISTA, MUSICA'),\r\n" + 
			"(1006,'CORDONERO A MANO'),\r\n" + 
			"(1007,'CORDONERO A MAQUINA'),\r\n" + 
			"(1008,'COREOGRAFO'),\r\n" + 
			"(1009,'CORISTA'),\r\n" + 
			"(1010,'CORRECTOR, PRUEBAS DE IMPRENTA'),\r\n" + 
			"(1011,'CORREDOR, BOLSA'),\r\n" + 
			"(1012,'CORREDOR, CICLISTA'),\r\n" + 
			"(1013,'CORREDOR, FABRICA'),\r\n" + 
			"(1014,'CORREDOR, FINCAS'),\r\n" + 
			"(1015,'CORREDOR, SEGUROS'),\r\n" + 
			"(1016,'CORREDOR, VALORES'),\r\n" + 
			"(1017,'CORREO DIPLOMATICO'),\r\n" + 
			"(1018,'CORRESPONSAL, MEDIOS DE INFORMACION'),\r\n" + 
			"(1019,'CORROCERO DE AUTOMOVILES'),\r\n" + 
			"(1020,'CORSETERA'),\r\n" + 
			"(1021,'CORTADOR  DE CHAPA DE MADERA'),\r\n" + 
			"(1022,'CORTADOR DE ACANALADURAS EN NEUMATICOS'),\r\n" + 
			"(1023,'CORTADOR DE CAÐA DE AZUCAR'),\r\n" + 
			"(1024,'CORTADOR DE CARNE'),\r\n" + 
			"(1025,'CORTADOR DE CAUCHO'),\r\n" + 
			"(1026,'CORTADOR DE CORCHO, FABRICACION DE ARTICULOS'),\r\n" + 
			"(1027,'CORTADOR DE CUEROS, CONFECCIONES DE ARTICULOS'),\r\n" + 
			"(1028,'CORTADOR DE CUEROS,CURTIDORES'),\r\n" + 
			"(1029,'CORTADOR DE ESTUAS EN NEUMATICOS'),\r\n" + 
			"(1030,'CORTADOR DE GUANTES'),\r\n" + 
			"(1031,'CORTADOR DE METALES CON SOPLETE'),\r\n" + 
			"(1032,'CORTADOR DE PAJA DE MADERA'),\r\n" + 
			"(1033,'CORTADOR DE PALAS DE CALZADO, A MAQUINA O A MANO'),\r\n" + 
			"(1034,'CORTADOR DE SUELAS'),\r\n" + 
			"(1035,'CORTADOR DE TOLDOS Y SOMBRILLAS, TIENDAS CAMPAÐA'),\r\n" + 
			"(1036,'CORTADOR DE TRAPOS, PASTA DE PAPEL'),\r\n" + 
			"(1037,'CORTADOR DE TRAVIESAS DE FERROCARRIL Y/O POSTES'),\r\n" + 
			"(1038,'CORTADOR DE VELAS DE EMBARCACIONES'),\r\n" + 
			"(1039,'CORTADOR DE VESTIDOS, INCLUSIVE DE CUERO Y PIEL'),\r\n" + 
			"(1040,'CORTADOR DE VIDRIO'),\r\n" + 
			"(1041,'CORTADOR DE VIRUTA PARA PULPA DE MADERA'),\r\n" + 
			"(1042,'CORTADOR EMPEINES CALZADO, A MAQUINA O A MANO'),\r\n" + 
			"(1043,'CORTADOR PRENDAS VESTIR,INCLUSIVE CUERO Y PIEL'),\r\n" + 
			"(1044,'CORTADOR ROPA BLANCA, TAPICERIA, TELAS PARAGUAS'),\r\n" + 
			"(1045,'CORTADOR, SASTRERIA'),\r\n" + 
			"(1046,'CORTADOR, TALLADOR DE CRISTALES DE OPTICA'),\r\n" + 
			"(1047,'COSECHADOR: MANI, ALGODON, PAJAS, ETC.'),\r\n" + 
			"(1048,'COSEDOR A MANO DE PRENDAS DE PELETERIA'),\r\n" + 
			"(1049,'COSEDOR A MANO PRENDAS VESTIR,EXCEPTO CALZADO CUERO'),\r\n" + 
			"(1050,'COSEDOR A MANO Y A MAQUINA, EN GENERAL'),\r\n" + 
			"(1051,'COSEDOR A MANO, ENCUADERNACION'),\r\n" + 
			"(1052,'COSEDOR A MAQUINA-REMALLADORES'),\r\n" + 
			"(1053,'COSEDOR DE CALZADO, A MAQUINA'),\r\n" + 
			"(1054,'COSEDOR DE CUERO (MALETAS, CARTERAS, BOLSAS)'),\r\n" + 
			"(1055,'COSEDOR DE ESCOBAS'),\r\n" + 
			"(1056,'COSEDOR DE PLEIGOS A MAQUINA, ENCUADERNACION'),\r\n" + 
			"(1057,'COSMETOLOGO'),\r\n" + 
			"(1058,'COSMOGRAFO'),\r\n" + 
			"(1059,'COSMOLOGO'),\r\n" + 
			"(1060,'COSTURERA-MODISTA'),\r\n" + 
			"(1061,'CREADOR, DIBUJOS ANIMADOS'),\r\n" + 
			"(1062,'CREADOR, MODELOS/JOYERIA Y ORFEBRERIA'),\r\n" + 
			"(1063,'CREADOR, SISTEMAS/EXCEPTO INFORMATICOS'),\r\n" + 
			"(1064,'CRIADO'),\r\n" + 
			"(1065,'CRIADOR DE CABRAS PARA LA PRODUCCION DE LECHE'),\r\n" + 
			"(1066,'CRIADOR DE GATOS'),\r\n" + 
			"(1067,'CRIADOR DE GUSANOS DE SEDA (OBRERO)'),\r\n" + 
			"(1068,'CRIADOR DE OSTRAS'),\r\n" + 
			"(1069,'CRIADOR DE PERROS'),\r\n" + 
			"(1070,'CRIADOR DE RANAS, PAJAROS (OBRERO)'),\r\n" + 
			"(1071,'CRIADOR DE VACAS LECHERAS'),\r\n" + 
			"(1072,'CRIADOR, ANIMALES DE LABORATORIO/COBAYOS'),\r\n" + 
			"(1073,'CRIADOR, ANIMALES NO DOMESTICOS/PIELES FINAS'),\r\n" + 
			"(1074,'CRIADOR, ANIMALES SALVAJES/PIELES FINAS'),\r\n" + 
			"(1075,'CRIADOR, ANIMALES/RESERVAS NATURALES'),\r\n" + 
			"(1076,'CRIADOR, AUQUENIDOS'),\r\n" + 
			"(1077,'CRIADOR, AVES DE CAZA'),\r\n" + 
			"(1078,'CRIADOR, AVES DE CORRAL'),\r\n" + 
			"(1079,'CRIADOR, CABALLOS'),\r\n" + 
			"(1080,'CRIADOR, CONEJOS'),\r\n" + 
			"(1081,'CRIADOR, CORDEROS DE ASTRACAN'),\r\n" + 
			"(1082,'CRIADOR, CUYES'),\r\n" + 
			"(1083,'CRIADOR, GANADO BOVINO'),\r\n" + 
			"(1084,'CRIADOR, GANADO CABALLAR'),\r\n" + 
			"(1085,'CRIADOR, GANADO CAPRINO/CABRAS (LANA)'),\r\n" + 
			"(1086,'CRIADOR, GANADO OVINO (LANA)'),\r\n" + 
			"(1087,'CRIADOR, GANADO PORCINO'),\r\n" + 
			"(1088,'CRIADOR, GANADO VACUNO (EXCEPTO GANADO LECHERO)'),\r\n" + 
			"(1089,'CRIADOR, GUSANO DE SEDA'),\r\n" + 
			"(1090,'CRIADOR, REPRODUCTORES'),\r\n" + 
			"(1091,'CRIBADOR DE CARBON O MINERALES'),\r\n" + 
			"(1092,'CRIBADOR DE PRODUCTOS QUIMICOS'),\r\n" + 
			"(1093,'CRIBADOR DE TIERRA, CERAMICA'),\r\n" + 
			"(1094,'CRISTALERO DE CLAROBOYAS'),\r\n" + 
			"(1095,'CRISTALERO DE EDIFICIO'),\r\n" + 
			"(1096,'CRITICO'),\r\n" + 
			"(1097,'CRITICO, ARTE'),\r\n" + 
			"(1098,'CRITICO, ARTES PLASTICAS'),\r\n" + 
			"(1099,'CRITICO, CINEMATOGRAFICO'),\r\n" + 
			"(1100,'CRITICO, LITERARIO'),\r\n" + 
			"(1101,'CRITICO, MUSICA'),\r\n" + 
			"(1102,'CRITICO, RADIO'),\r\n" + 
			"(1103,'CRITICO, TEATRO'),\r\n" + 
			"(1104,'CRITICO, TELEVISION'),\r\n" + 
			"(1105,'CRITICO-CODIFICADOR'),\r\n" + 
			"(1106,'CROMADOR'),\r\n" + 
			"(1107,'CRONISTA'),\r\n" + 
			"(1108,'CRONISTA, DEPORTES'),\r\n" + 
			"(1109,'CRONISTA, NOTICIARIOS'),\r\n" + 
			"(1110,'CRONISTA, TRIBUNALES'),\r\n" + 
			"(1111,'CRUPIER, SALA DE JUEGO'),\r\n" + 
			"(1112,'CUADRISTA (DE SISTESIS, GAS)'),\r\n" + 
			"(1113,'CUARTO OFICIAL, MAQUINISTA/BARCO'),\r\n" + 
			"(1114,'CUBICADOR, MADERA'),\r\n" + 
			"(1115,'CUIDADO DE NIÐOS EN VIVIENDAS PARTICULARES'),\r\n" + 
			"(1116,'CUIDADOR, ANIMALES/PARQUES ZOOLOGICOS'),\r\n" + 
			"(1117,'CUIDADOR, ANIMALES/RESERVAS NATURALES'),\r\n" + 
			"(1118,'CULTIVADOR DE FERMENTOS LACTEOS'),\r\n" + 
			"(1119,'CULTIVADOR EXPLOTADOR, CAUCHO'),\r\n" + 
			"(1120,'CULTIVADOR, HONGOS'),\r\n" + 
			"(1121,'CULTIVADOR, LUPULO'),\r\n" + 
			"(1122,'CULTIVADOR, PLANTACIONES/TE'),\r\n" + 
			"(1123,'CULTIVADOR, SETAS Y CHAMPIÐONES'),\r\n" + 
			"(1124,'CULTIVADOR, VIVEROS'),\r\n" + 
			"(1125,'CULTIVADOR, VIVEROS/BULBOS'),\r\n" + 
			"(1126,'CULTIVADOR, VIVEROS/ESPECIAS'),\r\n" + 
			"(1127,'CULTIVADOR, VIVEROS/HORTALIZAS'),\r\n" + 
			"(1128,'CULTIVADOR, VIVEROS/SEMILLAS'),\r\n" + 
			"(1129,'CULTIVADOR: ALGODON, CAÐA, AZUCAR, ETC.'),\r\n" + 
			"(1130,'CURA'),\r\n" + 
			"(1131,'CURADOR DE CARNE O PESCADO'),\r\n" + 
			"(1132,'CURANDERO'),\r\n" + 
			"(1133,'CURANDERO, RELIGIOSO'),\r\n" + 
			"(1134,'CURANDERO, SUGESTION'),\r\n" + 
			"(1135,'CURANDERO-NATURISTA, ALDEA'),\r\n" + 
			"(1136,'CURTIDOR DE CUEROS'),\r\n" + 
			"(1137,'CURVADOR DE MADERA'),\r\n" + 
			"(1138,'CURVADOR DE TUBOS DE VIDRIO'),\r\n" + 
			"(1139,'CUSTODIO'),\r\n" + 
			"(1140,'DAMA DE COMPAÐIA'),\r\n" + 
			"(1141,'DEBANADOR, ELECTRICISTA'),\r\n" + 
			"(1142,'DECANO'),\r\n" + 
			"(1143,'DECANO DE FACULTAD'),\r\n" + 
			"(1144,'DECAPADOR DE METALES'),\r\n" + 
			"(1145,'DECORADOR DE ABORDO, BARCOS'),\r\n" + 
			"(1146,'DECORADOR DE AMBIENTE'),\r\n" + 
			"(1147,'DECORADOR DE CERAMICA'),\r\n" + 
			"(1148,'DECORADOR DE IGLESIAS'),\r\n" + 
			"(1149,'DECORADOR DE VIDRIO'),\r\n" + 
			"(1150,'DECORADOR EN YESO FIBROSO'),\r\n" + 
			"(1151,'DECORADOR EXPOSICIONES'),\r\n" + 
			"(1152,'DECORADOR PROYECTISTA, CINE Y TEATRO'),\r\n" + 
			"(1153,'DECORADOR, ESCAPARATES'),\r\n" + 
			"(1154,'DECORADOR, INTERIORES'),\r\n" + 
			"(1155,'DEGOLLADOR DE RESES'),\r\n" + 
			"(1156,'DELINEANTE'),\r\n" + 
			"(1157,'DELINEANTE, ARQUITECTURA'),\r\n" + 
			"(1158,'DELINEANTE, CARTOGRAFIA'),\r\n" + 
			"(1159,'DELINEANTE, DIBUJANTES/OTROS'),\r\n" + 
			"(1160,'DELINEANTE, GEOLOGIA'),\r\n" + 
			"(1161,'DELINEANTE, ILUSTRACIONES TECNICAS'),\r\n" + 
			"(1162,'DELINEANTE, INDUSTRIAL'),\r\n" + 
			"(1163,'DELINEANTE, INGENIERIA AERONAUTICA'),\r\n" + 
			"(1164,'DELINEANTE, INGENIERIA CIVIL'),\r\n" + 
			"(1165,'DELINEANTE, INGENIERIA DE EDIFICIOS'),\r\n" + 
			"(1166,'DELINEANTE, INGENIERIA DE SISTEMAS DE CALEFACCION Y VENTILA'),\r\n" + 
			"(1167,'DELINEANTE, INGENIERIA ELECTRICA'),\r\n" + 
			"(1168,'DELINEANTE, INGENIERIA ELECTRONICA'),\r\n" + 
			"(1169,'DELINEANTE, INGENIERIA MECANICA'),\r\n" + 
			"(1170,'DELINEANTE, INGENIERIA NAVAL'),\r\n" + 
			"(1171,'DELINEANTE, LITOGRAFIA'),\r\n" + 
			"(1172,'DELINEANTE, MATRICES Y HERRAMIENTAS'),\r\n" + 
			"(1173,'DELINEANTE, TECNICO'),\r\n" + 
			"(1174,'DEMOGRAFO'),\r\n" + 
			"(1175,'DEMOSTRADOR (A) DE ARTICULOS'),\r\n" + 
			"(1176,'DEMOSTRADOR (A) DE PRODUCTOS PARA LA VENTA EN ESTABLECIMIEN'),\r\n" + 
			"(1177,'DEMOSTRADOR, PRACTICAS AGRICOLAS'),\r\n" + 
			"(1178,'DENTISTA'),\r\n" + 
			"(1179,'DENTISTA, PROTESIS DENTALES'),\r\n" + 
			"(1180,'DEPILADOR DE PIELES'),\r\n" + 
			"(1181,'DEPORTISTA, PROFESIONAL'),\r\n" + 
			"(1182,'DERIVADOR, FERROCARRILES'),\r\n" + 
			"(1183,'DERMATOLOGO'),\r\n" + 
			"(1184,'DESBASTADOR DE PIEZAS DE MOLDEO'),\r\n" + 
			"(1185,'DESBASTADOR, OPTICA EN ANTEOJERIA'),\r\n" + 
			"(1186,'DESBORRADOR DE TEXTILES'),\r\n" + 
			"(1187,'DESBROZADOR DE TIERRA'),\r\n" + 
			"(1188,'DESCABEZADOS DE PESCADO'),\r\n" + 
			"(1189,'DESCARGADOR DE AVIONES'),\r\n" + 
			"(1190,'DESCARGADOR DE BARCOS'),\r\n" + 
			"(1191,'DESCARNADOR DE CUEROS A MANO'),\r\n" + 
			"(1192,'DESCARNADOR DE CUEROS A MAQUINA'),\r\n" + 
			"(1193,'DESCARNADOR DE PIELES'),\r\n" + 
			"(1194,'DESCASCARADOR DE FRUTAS SECAS'),\r\n" + 
			"(1195,'DESCASCARADOR DE NUECES'),\r\n" + 
			"(1196,'DESCASCARADOR O TOSTADOR DE MANI'),\r\n" + 
			"(1197,'DESCORCHADOR, ALCORNOQUES'),\r\n" + 
			"(1198,'DESCORTEZADOR A MAQUINA'),\r\n" + 
			"(1199,'DESCORTEZADOR,1ARBOLES'),\r\n" + 
			"(1200,'DESCRUDADOR DE PRODUCTOS TEXTILES'),\r\n" + 
			"(1201,'DESCUARTIZADOR DE RESES, MATARIFE'),\r\n" + 
			"(1202,'DESCUARTIZADOR, BALLENAS'),\r\n" + 
			"(1203,'DESECADOR DE MALTA'),\r\n" + 
			"(1204,'DESECADOR-PULVERIZADOR DE LECHE EN POLVO'),\r\n" + 
			"(1205,'DESFIBRADOR DE LINO O YUTE'),\r\n" + 
			"(1206,'DESFIBRADOR RASPADOR DE MADERA'),\r\n" + 
			"(1207,'DESGOMADOR DE SEDA'),\r\n" + 
			"(1208,'DESHIDRATADOR DE ALIMENTOS'),\r\n" + 
			"(1209,'DESHIDRATADOR DE DISOLUCIONES QUIMICOS POR PULVERIZACION'),\r\n" + 
			"(1210,'DESHIDRATADOR PETROLEO CRUDO, CAMPOS EXTRACCION'),\r\n" + 
			"(1211,'DESHUESADOR'),\r\n" + 
			"(1212,'DESINCRUSTADOR DE POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(1213,'DESINCRUSTADOR, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(1214,'DESMOTADOR, TEXTIL'),\r\n" + 
			"(1215,'DESMUESTRADOR O COLECTOR DE MUESTRAS'),\r\n" + 
			"(1216,'DESPACHADOR, MERCADERIA/COMERCIO AL POR MENOR'),\r\n" + 
			"(1217,'DESPACHADOR, MERCADERIAS/COMERCIO AL POR MAYOR'),\r\n" + 
			"(1218,'DESPALILLADOR DE TABACO A MANO'),\r\n" + 
			"(1219,'DESPALILLADOR DE TABACO A MAQUINA'),\r\n" + 
			"(1220,'DESPEPITADOR, ALGODON'),\r\n" + 
			"(1221,'DESPINADOR DE PEJERREYES Y OTROS PESCADOS'),\r\n" + 
			"(1222,'DESPOJERO, MATADEROS'),\r\n" + 
			"(1223,'DESPOLVADOR DE GRANOS'),\r\n" + 
			"(1224,'DESPOSTADOR, CARNES'),\r\n" + 
			"(1225,'DESPUNTADOR DE SUELAS'),\r\n" + 
			"(1226,'DESTILADOR DE MADERA'),\r\n" + 
			"(1227,'DESTILADOR DE RESINA DE TREMENTINA'),\r\n" + 
			"(1228,'DESTILADOR DE TREMENTINA DE MADERA'),\r\n" + 
			"(1229,'DESTILADOR DEL PETROLEO'),\r\n" + 
			"(1230,'DESTILADOR PRODUCTOS QUIMICOS, EXCEPTO PETROLEO'),\r\n" + 
			"(1231,'DESTILADOR PRODUCTOS QUIMICOS, EXCEPTO PETROLEO, ALAMBIQUE'),\r\n" + 
			"(1232,'DESTILADOR, BEBIDAS ALCOHOL, PERFUMERIA, GLICERINA'),\r\n" + 
			"(1233,'DESTILADOR, MADERA'),\r\n" + 
			"(1234,'DESULFURADOR HIDROCABUROS'),\r\n" + 
			"(1235,'DESULFURADOR, REFINO DEL PETROLEO'),\r\n" + 
			"(1236,'DESVENADOR DE TABACO A MANO'),\r\n" + 
			"(1237,'DESVENADOR DE TABACO A MAQUINA'),\r\n" + 
			"(1238,'DETECTIVE PRIVADO'),\r\n" + 
			"(1239,'DEVANADOR, TEXTIL'),\r\n" + 
			"(1240,'DIABLERO'),\r\n" + 
			"(1241,'DIACONISA'),\r\n" + 
			"(1242,'DIACONO'),\r\n" + 
			"(1243,'DIALOGUISTA'),\r\n" + 
			"(1244,'DIAMANTISTA-PULIDOR Y TALLADOR DE PIEDRAS PRECIOSAS'),\r\n" + 
			"(1245,'DIBUJANTE, CARICATURISTA'),\r\n" + 
			"(1246,'DIBUJANTE, CARTELES'),\r\n" + 
			"(1247,'DIBUJANTE, DIBUJOS ANIMADOS'),\r\n" + 
			"(1248,'DIBUJANTE, DISEÐO INDUSTRIAL'),\r\n" + 
			"(1249,'DIBUJANTE, ILUSTRACIONES'),\r\n" + 
			"(1250,'DIBUJANTE, ILUSTRACIONES TECNICAS'),\r\n" + 
			"(1251,'DIBUJANTE, INTERIORES'),\r\n" + 
			"(1252,'DIBUJANTE, JOYERIA Y ORFEBRERIA'),\r\n" + 
			"(1253,'DIBUJANTE, MODA'),\r\n" + 
			"(1254,'DIBUJANTE, PROYECTISTA/ARTES GRAFICAS'),\r\n" + 
			"(1255,'DIBUJANTE, PUBLICIDAD'),\r\n" + 
			"(1256,'DIETISTAS-NUTRICIONISTAS'),\r\n" + 
			"(1257,'DIGITADOR'),\r\n" + 
			"(1258,'DIMIDOR'),\r\n" + 
			"(1259,'DINAMITERO, PEGADOR, MINAS Y CANTERAS'),\r\n" + 
			"(1260,'DIPLOMATICOS, EXTRANJEROS'),\r\n" + 
			"(1261,'DIPLOMATICOS, PERUANOS (EXCEPTO EMBAJADORES Y CONSULES EN F'),\r\n" + 
			"(1262,'DIPUTADO'),\r\n" + 
			"(1263,'DIRECTOR'),\r\n" + 
			"(1264,'DIRECTOR ARTISTICO, CINE'),\r\n" + 
			"(1265,'DIRECTOR ARTISTICO, TEATRO'),\r\n" + 
			"(1266,'DIRECTOR DE CENTRO EDUCATIVO'),\r\n" + 
			"(1267,'DIRECTOR DE DEPARTAMENTO, ABASTECIMIENTO/SUMINISTRO'),\r\n" + 
			"(1268,'DIRECTOR DE DEPARTAMENTO, ADMINISTRACION'),\r\n" + 
			"(1269,'DIRECTOR DE DEPARTAMENTO, ALMACENAMIENTO'),\r\n" + 
			"(1270,'DIRECTOR DE DEPARTAMENTO, COMERCIALIZACION'),\r\n" + 
			"(1271,'DIRECTOR DE DEPARTAMENTO, COMPRAS/ADQUISICION'),\r\n" + 
			"(1272,'DIRECTOR DE DEPARTAMENTO, CONTABILIDAD'),\r\n" + 
			"(1273,'DIRECTOR DE DEPARTAMENTO, DISTRIBUCION'),\r\n" + 
			"(1274,'DIRECTOR DE DEPARTAMENTO, FINANZAS/GERENTE'),\r\n" + 
			"(1275,'DIRECTOR DE DEPARTAMENTO, INFORMATICA'),\r\n" + 
			"(1276,'DIRECTOR DE DEPARTAMENTO, INVESTIGACION Y DESARROLLO'),\r\n" + 
			"(1277,'DIRECTOR DE DEPARTAMENTO, PERSONAL');", nativeQuery = true)
	void insertarOcupacion1();
	
	@Query(value="insert into ocupacion(id_ocupacion, descripcion) VALUES (1278,'DIRECTOR DE DEPARTAMENTO, PRESUPUESTO')," + 
			"(1279,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/ACTIVIDADES CULTURALES'),\r\n" + 
			"(1280,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/ACTIVIDADES DEPORTIVAS'),\r\n" + 
			"(1281,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/ACTIVIDADES RECREATIVAS'),\r\n" + 
			"(1282,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/ADMINIST'),\r\n" + 
			"(1283,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/AGENCIAS'),\r\n" + 
			"(1284,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/AGRICULT'),\r\n" + 
			"(1285,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/ALMACENA'),\r\n" + 
			"(1286,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMERCIO MAYORISTA'),\r\n" + 
			"(1287,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMERCIO MAYORISTA EXPORTACIÓN'),\r\n" + 
			"(1288,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMERCIO MAYORISTA IMPORTACIÓN'),\r\n" + 
			"(1289,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMERCIO MINORISTA'),\r\n" + 
			"(1290,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMERCIO MINORISTA SUPERMERCADOS'),\r\n" + 
			"(1291,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMERCIO MINORISTA TIENDAS'),\r\n" + 
			"(1292,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMUNICACIONES'),\r\n" + 
			"(1293,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMUNICACIONES CORREOS'),\r\n" + 
			"(1294,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/COMUNICACIONES TELECOMUNICACIONES'),\r\n" + 
			"(1295,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/CONSTRUCCIONES'),\r\n" + 
			"(1296,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/ESPECTACULOS'),\r\n" + 
			"(1297,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/HOTELES'),\r\n" + 
			"(1298,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/INDUSTRIALES'),\r\n" + 
			"(1299,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/INSTITUCIONALES'),\r\n" + 
			"(1300,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/PESCA'),\r\n" + 
			"(1301,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/REPARAC.'),\r\n" + 
			"(1302,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/RESTAURA'),\r\n" + 
			"(1303,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/SALUD'),\r\n" + 
			"(1304,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/SERVICIO'),\r\n" + 
			"(1305,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/SILVICUL'),\r\n" + 
			"(1306,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/TRABAJO'),\r\n" + 
			"(1307,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/TRANSPORTE'),\r\n" + 
			"(1308,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/TRANSPORTE GASODUCTOS Y OLEODUCTOS'),\r\n" + 
			"(1309,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/TRANSPORTE MERCANCÍAS'),\r\n" + 
			"(1310,'DIRECTOR DE DEPARTAMENTO, PRODUCCION Y OPERACIONES/TRANSPORTE PASAJEROS'),\r\n" + 
			"(1311,'DIRECTOR DE DEPARTAMENTO, PUBLICIDAD'),\r\n" + 
			"(1312,'DIRECTOR DE DEPARTAMENTO, RELACIONES INDUSTRIALES'),\r\n" + 
			"(1313,'DIRECTOR DE DEPARTAMENTO, RELACIONES LABORALES'),\r\n" + 
			"(1314,'DIRECTOR DE DEPARTAMENTO, RELACIONES PUBLICAS'),\r\n" + 
			"(1315,'DIRECTOR DE DEPARTAMENTO, VENTAS'),\r\n" + 
			"(1316,'DIRECTOR DE DEPARTAMENTO, VENTAS/ ORGANIZACION'),\r\n" + 
			"(1317,'DIRECTOR DE EMPRESAS, DE AGRICULTURA, CAZA, SILVICULTURA Y GANADERIA'),\r\n" + 
			"(1318,'DIRECTOR DE EMPRESAS, DE COMERCIO MAYORISTA Y MINORISTA, RE'),\r\n" + 
			"(1319,'DIRECTOR DE EMPRESAS, DE CONSTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(1320,'DIRECTOR DE EMPRESAS, DE INDUSTRIAS MANUFACTURERAS, MINAS Y'),\r\n" + 
			"(1321,'DIRECTOR DE EMPRESAS, DE RESTAURANTES Y HOTELERIA'),\r\n" + 
			"(1322,'DIRECTOR DE EMPRESAS, DE SERVICIOS PUBLICOS Y FINANCIEROS'),\r\n" + 
			"(1323,'DIRECTOR DE EMPRESAS, DE TRANSPORTE, ALMACENAMIENTO Y COMUN'),\r\n" + 
			"(1324,'DIRECTOR DE ESCUELA PROFESIONAL'),\r\n" + 
			"(1325,'DIRECTOR DE ESEP/SENATI, ETC.'),\r\n" + 
			"(1326,'DIRECTOR DE ESTUDIOS'),\r\n" + 
			"(1327,'DIRECTOR DE EXPLOTACION DE MINAS Y CANTERAS'),\r\n" + 
			"(1328,'DIRECTOR DE INSTITUTO ACADEMICO'),\r\n" + 
			"(1329,'DIRECTOR DE LA ADMINISTRACION PUBLICA'),\r\n" + 
			"(1330,'DIRECTOR DE LA UNIDAD DE SERVICIOS EDUCATIVOS'),\r\n" + 
			"(1331,'DIRECTOR DE NUCLEOS EDUCATIVOS COMUNALES'),\r\n" + 
			"(1332,'DIRECTOR DE PLATO, CINE'),\r\n" + 
			"(1333,'DIRECTOR DE PRODUCCION (RADIO Y T.V.)'),\r\n" + 
			"(1334,'DIRECTOR DEPARTAMENTAL DE EDUCACION'),\r\n" + 
			"(1335,'DIRECTOR EJECUTIVO DE LA ADMINISTRACION PUBLICA'),\r\n" + 
			"(1336,'DIRECTOR EJECUTIVO, EMPRESA, AGRICULTURA, CAZA, SILVICULTURA'),\r\n" + 
			"(1337,'DIRECTOR EJECUTIVO, EMPRESA, DE COMERCIO MAYORISTA Y MINORISTA'),\r\n" + 
			"(1338,'DIRECTOR EJECUTIVO, EMPRESA, DE CONSTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(1339,'DIRECTOR EJECUTIVO, EMPRESA, DE RESTAURANTES Y HOTELERIA'),\r\n" + 
			"(1340,'DIRECTOR EJECUTIVO, EMPRESA, DE SERVICIOS PUBLICOS Y FINANCIEROS'),\r\n" + 
			"(1341,'DIRECTOR EJECUTIVO, EMPRESA, DE TRANSPORTE, ALMACENAMIENTO'),\r\n" + 
			"(1342,'DIRECTOR EJECUTIVO, EMPRESA, INDUSTRIA MANUFACTURERA, MINAS'),\r\n" + 
			"(1343,'DIRECTOR GENERAL, ADMINISTRACION DE CORREOS'),\r\n" + 
			"(1344,'DIRECTOR GENERAL, ADMINISTRACION PENITENCIARIA'),\r\n" + 
			"(1345,'DIRECTOR GENERAL, ADMINISTRACION PUBLICA'),\r\n" + 
			"(1346,'DIRECTOR GENERAL, ADMINISTRACION PUBLICA/MINISTERIO'),\r\n" + 
			"(1347,'DIRECTOR GENERAL, ADMINISTRACION PUBLICA/REGION'),\r\n" + 
			"(1348,'DIRECTOR GENERAL, CANCILLERIA'),\r\n" + 
			"(1349,'DIRECTOR GENERAL, EMPRESA/ACTIVIDADES CULTURALES'),\r\n" + 
			"(1350,'DIRECTOR GENERAL, EMPRESA/ACTIVIDADES DEPORTIVAS'),\r\n" + 
			"(1351,'DIRECTOR GENERAL, EMPRESA/ACTIVIDADES RECREATIVAS'),\r\n" + 
			"(1352,'DIRECTOR GENERAL, EMPRESA/AGENCIA DE VIAJES'),\r\n" + 
			"(1353,'DIRECTOR GENERAL, EMPRESA/AGRICULTURA'),\r\n" + 
			"(1354,'DIRECTOR GENERAL, EMPRESA/ALMACENAMIENTO'),\r\n" + 
			"(1355,'DIRECTOR GENERAL, EMPRESA/CAZA'),\r\n" + 
			"(1356,'DIRECTOR GENERAL, EMPRESA/COMERCIO MAYORISTA'),\r\n" + 
			"(1357,'DIRECTOR GENERAL, EMPRESA/COMERCIO MINORISTA'),\r\n" + 
			"(1358,'DIRECTOR GENERAL, EMPRESA/COMUNICACIONES'),\r\n" + 
			"(1359,'DIRECTOR GENERAL, EMPRESA/CONSTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(1360,'DIRECTOR GENERAL, EMPRESA/EXPLOTACION: AGRICOLA, FORESTAL Y'),\r\n" + 
			"(1361,'DIRECTOR GENERAL, EMPRESA/HOTELERIA'),\r\n" + 
			"(1362,'DIRECTOR GENERAL, EMPRESA/INDUSTRIA MANUFACTURERA'),\r\n" + 
			"(1363,'DIRECTOR GENERAL, EMPRESA/INTERMEDIACION FINANCIERA'),\r\n" + 
			"(1364,'DIRECTOR GENERAL, EMPRESA/LIMPIEZA'),\r\n" + 
			"(1365,'DIRECTOR GENERAL, EMPRESA/PESCA'),\r\n" + 
			"(1366,'DIRECTOR GENERAL, EMPRESA/RESTAURANTE'),\r\n" + 
			"(1367,'DIRECTOR GENERAL, EMPRESA/SERVICIO DE EMPRESA'),\r\n" + 
			"(1368,'DIRECTOR GENERAL, EMPRESA/SERVICIO DE SANIDAD'),\r\n" + 
			"(1369,'DIRECTOR GENERAL, EMPRESA/SILVICULTURA'),\r\n" + 
			"(1370,'DIRECTOR GENERAL, EMPRESA/SUMINISTRO DE ELECTRICIDAD, GAS Y'),\r\n" + 
			"(1371,'DIRECTOR GENERAL, EMPRESA/TRABAJO SOCIAL'),\r\n" + 
			"(1372,'DIRECTOR GENERAL, EMPRESA/TRANSPORTE'),\r\n" + 
			"(1373,'DIRECTOR GENERAL, ORGANIZACION/ CAZA'),\r\n" + 
			"(1374,'DIRECTOR GENERAL, ORGANIZACION/ACTIVIDADES CULTURALES'),\r\n" + 
			"(1375,'DIRECTOR GENERAL, ORGANIZACION/ACTIVIDADES DEPORTIVAS'),\r\n" + 
			"(1376,'DIRECTOR GENERAL, ORGANIZACION/ACTIVIDADES RECREATIVAS'),\r\n" + 
			"(1377,'DIRECTOR GENERAL, ORGANIZACION/AGENCIA DE VIAJES'),\r\n" + 
			"(1378,'DIRECTOR GENERAL, ORGANIZACION/COMERCIO MAYORISTA'),\r\n" + 
			"(1379,'DIRECTOR GENERAL, ORGANIZACION/COMERCIO MINORISTA'),\r\n" + 
			"(1380,'DIRECTOR GENERAL, ORGANIZACION/HOTELERIA'),\r\n" + 
			"(1381,'DIRECTOR GENERAL, ORGANIZACION/INTERMEDIACION FINANCIERA'),\r\n" + 
			"(1382,'DIRECTOR GENERAL, ORGANIZACION/LIMPIEZA'),\r\n" + 
			"(1383,'DIRECTOR GENERAL, ORGANIZACION/PESCA'),\r\n" + 
			"(1384,'DIRECTOR GENERAL, ORGANIZACION/RESTAURANTE'),\r\n" + 
			"(1385,'DIRECTOR GENERAL, ORGANIZACION/SERVICIO DE EMPRESA'),\r\n" + 
			"(1386,'DIRECTOR GENERAL, ORGANIZACION/SILVICULTURA'),\r\n" + 
			"(1387,'DIRECTOR GENERAL, ORGANIZACION/TRABAJO SOCIAL'),\r\n" + 
			"(1388,'DIRECTOR GENERAL, ORGANIZACION/TRANSPORTE'),\r\n" + 
			"(1389,'DIRECTOR GENERAL, REPARACION/VEHICULOS, AUTOMOTORES, ETC.'),\r\n" + 
			"(1390,'DIRECTOR TEATRAL'),\r\n" + 
			"(1391,'DIRECTOR UNIVERSITARIO'),\r\n" + 
			"(1392,'DIRECTOR, COMERCIO NEP'),\r\n" + 
			"(1393,'DIRECTOR, COREOGRAFIA'),\r\n" + 
			"(1394,'DIRECTOR, COROS'),\r\n" + 
			"(1395,'DIRECTOR, DANZA'),\r\n" + 
			"(1396,'DIRECTOR, ESCENA/CINE'),\r\n" + 
			"(1397,'DIRECTOR, ESCENA/TEATRO'),\r\n" + 
			"(1398,'DIRECTOR, MUSICAL'),\r\n" + 
			"(1399,'DIRECTOR, ORQUESTA SINFONICA'),\r\n" + 
			"(1400,'DIRECTOR, ORQUESTA/BAILE'),\r\n" + 
			"(1401,'DIRECTOR, TEATRO'),\r\n" + 
			"(1402,'DIRIGENTE, ORGANIZACION DE EMPLEADORES'),\r\n" + 
			"(1403,'DIRIGENTE, ORGANIZACION ESPECIALIZADA'),\r\n" + 
			"(1404,'DIRIGENTE, PARTIDO POLITICO'),\r\n" + 
			"(1405,'DIRIGENTE, SINDICATO DE TRABAJADORES'),\r\n" + 
			"(1406,'DISECADOR-TAXIDERMISTA'),\r\n" + 
			"(1407,'DISEÐADOR, ALFOMBRAS'),\r\n" + 
			"(1408,'DISEÐADOR, DECORACION DE INTERIORES'),\r\n" + 
			"(1409,'DISEÐADOR, DECORADOR'),\r\n" + 
			"(1410,'DISEÐADOR, DECORADOR/ESCENARIOS DE TEATRO'),\r\n" + 
			"(1411,'DISEÐADOR, ENVASES'),\r\n" + 
			"(1412,'DISEÐADOR, ESCAPARATISTA'),\r\n" + 
			"(1413,'DISEÐADOR, EXPOSICIONES'),\r\n" + 
			"(1414,'DISEÐADOR, GRAFICO'),\r\n" + 
			"(1415,'DISEÐADOR, HERALDISTA'),\r\n" + 
			"(1416,'DISEÐADOR, HERRERIA ARTISTICA'),\r\n" + 
			"(1417,'DISEÐADOR, INDUSTRIAL'),\r\n" + 
			"(1418,'DISEÐADOR, JOYAS'),\r\n" + 
			"(1419,'DISEÐADOR, MODA'),\r\n" + 
			"(1420,'DISEÐADOR, MUEBLES'),\r\n" + 
			"(1421,'DISEÐADOR, ORFEBRERIA'),\r\n" + 
			"(1422,'DISEÐADOR, PIEZAS DE CERAMICA'),\r\n" + 
			"(1423,'DISEÐADOR, PRENDAS DE VESTIR'),\r\n" + 
			"(1424,'DISEÐADOR, PRODUCTOS COMERCIALES'),\r\n" + 
			"(1425,'DISEÐADOR, PRODUCTOS INDUSTRIALES'),\r\n" + 
			"(1426,'DISEÐADOR, TELAS Y TEJIDOS'),\r\n" + 
			"(1427,'DISPATCHER DE ENERGIA ELECTRICA,REPARTIDOR DE CARGAS'),\r\n" + 
			"(1428,'DOCUMENTALISTA'),\r\n" + 
			"(1429,'DOCUMENTALISTA, MATERIAS ECONOMICAS'),\r\n" + 
			"(1430,'DOCUMENTALISTA, MATERIAS TECNICAS'),\r\n" + 
			"(1431,'DOLADOR, PIEDRAS'),\r\n" + 
			"(1432,'DOMADOR, CIRCO'),\r\n" + 
			"(1433,'DOMADOR, FIERAS'),\r\n" + 
			"(1434,'DORADOR A MANO,ENCUADERNACION'),\r\n" + 
			"(1435,'DULCERO, PREPARADOR'),\r\n" + 
			"(1436,'EBANISTA DE MESA DE BILLAR'),\r\n" + 
			"(1437,'EBANISTA DE PIANOS'),\r\n" + 
			"(1438,'EBANISTA O CARPINTERO EN MADERA, EXCEPTO CONSTRUCCION'),\r\n" + 
			"(1439,'EBANISTA, MARQUETERIA'),\r\n" + 
			"(1440,'EBANISTAS DE ESTUCHES PARA INSTRUMENTOS'),\r\n" + 
			"(1441,'ECOLOGISTA'),\r\n" + 
			"(1442,'ECOLOGISTA, BOTANICA'),\r\n" + 
			"(1443,'ECOLOGISTA, ZOOLOGIA'),\r\n" + 
			"(1444,'ECONOMETRISTA'),\r\n" + 
			"(1445,'ECONOMISTA (INGENIERO)'),\r\n" + 
			"(1446,'ECONOMISTA, AGRICULTURA'),\r\n" + 
			"(1447,'ECONOMISTA, COMERCIO INTERNACIONAL'),\r\n" + 
			"(1448,'ECONOMISTA, DESARROLLO'),\r\n" + 
			"(1449,'ECONOMISTA, ECONOMETRIA'),\r\n" + 
			"(1450,'ECONOMISTA, ESPECIALISTA EN MERCADOTECNIA'),\r\n" + 
			"(1451,'ECONOMISTA, OTROS'),\r\n" + 
			"(1452,'ECONOMO, HOSTELERIA'),\r\n" + 
			"(1453,'EDITOR, LIBROS/REVISTAS'),\r\n" + 
			"(1454,'EDITORIALISTA'),\r\n" + 
			"(1455,'EJECUTANTE, MUSICO'),\r\n" + 
			"(1456,'EJERCITO, PERSONAL DE SERVICIO MILITAR'),\r\n" + 
			"(1457,'EJERCITO, SUB OFICIALES'),\r\n" + 
			"(1458,'EJERCITO, TECNICOS'),\r\n" + 
			"(1459,'EJERCITO,OFICIALES'),\r\n" + 
			"(1460,'ELECTRICISTA BOBINADOR'),\r\n" + 
			"(1461,'ELECTRICISTA DE BARCOS Y AVIONES'),\r\n" + 
			"(1462,'ELECTRICISTA DE BARCOS Y AVIONES'),\r\n" + 
			"(1463,'ELECTRICISTA DE VEHICULOS'),\r\n" + 
			"(1464,'ELECTRICISTA-MONTADOR,AIRE ACONDICIONADO'),\r\n" + 
			"(1465,'ELECTRICISTAS GRAL., CONSTRUC. INSTAL. ELEC., CINE'),\r\n" + 
			"(1466,'ELECTRICO,DE GENERADOR'),\r\n" + 
			"(1467,'ELECTROPLASTIA, GALVANIZADOR'),\r\n" + 
			"(1468,'ELECTROTECNICO SUPERIOR'),\r\n" + 
			"(1469,'ELECTROTERAPEUTA'),\r\n" + 
			"(1470,'ELECTROTIPISTA, IMPRENTA'),\r\n" + 
			"(1471,'ELEVADORISTA DE CARGA'),\r\n" + 
			"(1472,'EMBAJADORES EN FUNCION (PERUANOS)'),\r\n" + 
			"(1473,'EMBALADOR A MANO Y/O MAQUINA'),\r\n" + 
			"(1474,'EMBALADOR, A MANO'),\r\n" + 
			"(1475,'EMBALADOR, A MANO/CAJAS'),\r\n" + 
			"(1476,'EMBALADOR, INDUSTRIA CONSERVERA/ENLATADO'),\r\n" + 
			"(1477,'EMBALSAMADOR'),\r\n" + 
			"(1478,'EMBORRADOR DE LANA'),\r\n" + 
			"(1479,'EMBOTELLADOR MANUAL'),\r\n" + 
			"(1480,'EMBRIOLOGO'),\r\n" + 
			"(1481,'EMENTADOR DE METALES'),\r\n" + 
			"(1482,'EMPADRONADORES'),\r\n" + 
			"(1483,'EMPALMADOR DE CABLES ELECTRICOS'),\r\n" + 
			"(1484,'EMPALMADOR DE CUERDAS Y CABLES EN GRAL, EN EXCEPTO ELECTRIC'),\r\n" + 
			"(1485,'EMPALMADOR DE ESTROBOS'),\r\n" + 
			"(1486,'EMPAPELADOR DE PAREDES'),\r\n" + 
			"(1487,'EMPAQUETADOR A MANO Y/O MAQUINA'),\r\n" + 
			"(1488,'EMPAQUETADOR, MANUAL'),\r\n" + 
			"(1489,'EMPLEADO ACTUARIAL'),\r\n" + 
			"(1490,'EMPLEADO DE  REGISTRO CIVIL'),\r\n" + 
			"(1491,'EMPLEADO DE AGENCIA DE SEGUROS'),\r\n" + 
			"(1492,'EMPLEADO DE CORREOS, CORRESPONDENCIA/CLASIFICACION'),\r\n" + 
			"(1493,'EMPLEADO DE CORRESPONDENCIA'),\r\n" + 
			"(1494,'EMPLEADO DE OFICINA EN GENERAL'),\r\n" + 
			"(1495,'EMPLEADO DE OFICINA PUBLICA O PARTICULAR'),\r\n" + 
			"(1496,'EMPLEADO DE OFICINA, OTROS'),\r\n" + 
			"(1497,'EMPLEADO DE OTROS REGISTROS (ADM. PUBLICA)'),\r\n" + 
			"(1498,'EMPLEADO DE REGISTRO ELECTORAL'),\r\n" + 
			"(1499,'EMPLEADO DE REGISTRO PUBLICOS'),\r\n" + 
			"(1500,'EMPLEADO DE SERVICIOS ADMINISTRATIVOS, OTROS'),\r\n" + 
			"(1501,'EMPLEADO DE SERVICIOS DE PERSONAL'),\r\n" + 
			"(1502,'EMPLEADO DEL HOGAR'),\r\n" + 
			"(1503,'EMPLEADO O AYUDANTE DE IMPRENTA EN GENERAL'),\r\n" + 
			"(1504,'EMPLEADO, ABASTECIMIENTO'),\r\n" + 
			"(1505,'EMPLEADO, ABASTECIMIENTO/MATERIALES'),\r\n" + 
			"(1506,'EMPLEADO, AGENCIA DE VIAJES'),\r\n" + 
			"(1507,'EMPLEADO, AGENCIA DE VIAJES/VENTAS DE BILLETES'),\r\n" + 
			"(1508,'EMPLEADO, ALMACENAJE Y APROVISIONAMIENTO'),\r\n" + 
			"(1509,'EMPLEADO, ARCHIVO/SERVICIOS'),\r\n" + 
			"(1510,'EMPLEADO, BANCO/PRESTAMOS'),\r\n" + 
			"(1511,'EMPLEADO, BANCOS'),\r\n" + 
			"(1512,'EMPLEADO, BIBLIOTECA'),\r\n" + 
			"(1513,'EMPLEADO, BIBLIOTECA/ADQUISICIONES'),\r\n" + 
			"(1514,'EMPLEADO, BIBLIOTECA/CLASIFICACION'),\r\n" + 
			"(1515,'EMPLEADO, BIBLIOTECA/INDICE'),\r\n" + 
			"(1516,'EMPLEADO, BIBLIOTECA/PRESTAMO DE LIBROS'),\r\n" + 
			"(1517,'EMPLEADO, BOLSA'),\r\n" + 
			"(1518,'EMPLEADO, CAJA'),\r\n" + 
			"(1519,'EMPLEADO, CALCULO DE COSTOS'),\r\n" + 
			"(1520,'EMPLEADO, CALCULO DE MATERIALES'),\r\n" + 
			"(1521,'EMPLEADO, CALCULO DE PRESUPUESTOS'),\r\n" + 
			"(1522,'EMPLEADO, CALCULO DE SALARIOS'),\r\n" + 
			"(1523,'EMPLEADO, CLASIFICADOR DE DOCUMENTOS'),\r\n" + 
			"(1524,'EMPLEADO, CONCERTACION DE ENTREVISTAS'),\r\n" + 
			"(1525,'EMPLEADO, CONTABILIDAD'),\r\n" + 
			"(1526,'EMPLEADO, CONTABILIDAD/CALCULO DE COSTOS'),\r\n" + 
			"(1527,'EMPLEADO, CONTABILIDAD/CALCULO DE INTERESES'),\r\n" + 
			"(1528,'EMPLEADO, CONTABILIDAD/CUENTAS CORRIENTES'),\r\n" + 
			"(1529,'EMPLEADO, CONTABILIDAD/DESCUENTOS'),\r\n" + 
			"(1530,'EMPLEADO, CONTABILIDAD/ESTIMACIONES'),\r\n" + 
			"(1531,'EMPLEADO, CONTABILIDAD/EXISTENCIAS'),\r\n" + 
			"(1532,'EMPLEADO, CONTABILIDAD/VERIFICACION'),\r\n" + 
			"(1533,'EMPLEADO, CONTROL DE PESO'),\r\n" + 
			"(1534,'EMPLEADO, CORRECCION DE PRUEBAS/IMPRENTA'),\r\n" + 
			"(1535,'EMPLEADO, CREDITOS'),\r\n" + 
			"(1536,'EMPLEADO, DEPENDIENTE DE TIENDA, COMERCIO NEP'),\r\n" + 
			"(1537,'EMPLEADO, DEPOSITO'),\r\n" + 
			"(1538,'EMPLEADO, DESPACHO'),\r\n" + 
			"(1539,'EMPLEADO, DESPACHO/AUTOBUSES'),\r\n" + 
			"(1540,'EMPLEADO, DESPACHO/BARCOS'),\r\n" + 
			"(1541,'EMPLEADO, DESPACHO/CAMIONES'),\r\n" + 
			"(1542,'EMPLEADO, DESPACHO/FERROCARRIL'),\r\n" + 
			"(1543,'EMPLEADO, DESPACHO/GASODUCTO'),\r\n" + 
			"(1544,'EMPLEADO, DESPACHO/MUELLES'),\r\n" + 
			"(1545,'EMPLEADO, DESPACHO/OLEODUCTO'),\r\n" + 
			"(1546,'EMPLEADO, DESPACHO/TRANSPORTE AEREO'),\r\n" + 
			"(1547,'EMPLEADO, DESPACHO/TRANSPORTE CARGA'),\r\n" + 
			"(1548,'EMPLEADO, DESPACHO/TRANSPORTE FLUVIAL Y TRANSBORDADOR'),\r\n" + 
			"(1549,'EMPLEADO, DESPACHO/TRANSPORTE MARITIMO'),\r\n" + 
			"(1550,'EMPLEADO, DESPACHO/TRANSPORTE POR CARRETERA (EXCEPTO AUTOBUS)'),\r\n" + 
			"(1551,'EMPLEADO, DISTRIBUCION/CORRESPONDENCIA'),\r\n" + 
			"(1552,'EMPLEADO, EDIFICIO/APARTAMENTOS(LIMPIEZA)'),\r\n" + 
			"(1553,'EMPLEADO, ELABORACION DE LISTAS'),\r\n" + 
			"(1554,'EMPLEADO, EMBARQUE/MERCADERIA'),\r\n" + 
			"(1555,'EMPLEADO, EMISION DE BILLETES/EXCEPTO DE VIAJE'),\r\n" + 
			"(1556,'EMPLEADO, EMISION DE BILLETES/VIAJES'),\r\n" + 
			"(1557,'EMPLEADO, ESCRITURAS'),\r\n" + 
			"(1558,'EMPLEADO, ESTADISTICA'),\r\n" + 
			"(1559,'EMPLEADO, EXISTENCIAS/CONTROL'),\r\n" + 
			"(1560,'EMPLEADO, EXISTENCIAS/CONTROL (REGISTROS)'),\r\n" + 
			"(1561,'EMPLEADO, EXISTENCIAS/INVENTARIO'),\r\n" + 
			"(1562,'EMPLEADO, EXISTENCIAS/MERCADERIA'),\r\n" + 
			"(1563,'EMPLEADO, EXISTENCIAS/REGISTRADOR'),\r\n" + 
			"(1564,'EMPLEADO, EXPEDICION Y RECEPCION DE MERCADERIA'),\r\n" + 
			"(1565,'EMPLEADO, FACTURAS'),\r\n" + 
			"(1566,'EMPLEADO, FERROCARRIL/DEPOSITO'),\r\n" + 
			"(1567,'EMPLEADO, FINANZAS'),\r\n" + 
			"(1568,'EMPLEADO, FISCO'),\r\n" + 
			"(1569,'EMPLEADO, GUARDAMUEBLES'),\r\n" + 
			"(1570,'EMPLEADO, HERRAMIENTAS/ALMACEN'),\r\n" + 
			"(1571,'EMPLEADO, HIPOTECAS'),\r\n" + 
			"(1572,'EMPLEADO, INFORMES'),\r\n" + 
			"(1573,'EMPLEADO, INTERVENTOR ALMACENISTA'),\r\n" + 
			"(1574,'EMPLEADO, INVERSIONES'),\r\n" + 
			"(1575,'EMPLEADO, KARDISTA/TARJADOR'),\r\n" + 
			"(1576,'EMPLEADO, MAQUINA FRANQUEADORA'),\r\n" + 
			"(1577,'EMPLEADO, MERCADERIAS'),\r\n" + 
			"(1578,'EMPLEADO, MOVIMIENTO/MERCADERIAS'),\r\n" + 
			"(1579,'EMPLEADO, MOVIMIENTOS/TRENES'),\r\n" + 
			"(1580,'EMPLEADO, OFICINA DE IMPUESTOS/SELLOS Y TIMBRES'),\r\n" + 
			"(1581,'EMPLEADO, OPERACIONES DE CAMBIO'),\r\n" + 
			"(1582,'EMPLEADO, OPERACIONES/TRANSPORTE AEREO'),\r\n" + 
			"(1583,'EMPLEADO, OPERADOR DE FOTOCOPIADORA'),\r\n" + 
			"(1584,'EMPLEADO, OPERADOR DE MAQUINA AUTOCOPISTA'),\r\n" + 
			"(1585,'EMPLEADO, OPERADOR DE MAQUINA MULTICOPISTA'),\r\n" + 
			"(1586,'EMPLEADO, OPERADOR DE MAQUINA REPRODUCTORA DE DOCUMENTOS'),\r\n" + 
			"(1587,'EMPLEADO, PAGADOR DE PLANILLAS DE PAGO'),\r\n" + 
			"(1588,'EMPLEADO, PAGO DE NOMINAS'),\r\n" + 
			"(1589,'EMPLEADO, PAGO DE SALARIOS'),\r\n" + 
			"(1590,'EMPLEADO, PLANIFICACION DE LA PRODUCCION'),\r\n" + 
			"(1591,'EMPLEADO, PLANIFICACION DE LA PRODUCCION/COORDINACION'),\r\n" + 
			"(1592,'EMPLEADO, PLANIFICACION DE LA PRODUCCION/PROGRAMA'),\r\n" + 
			"(1593,'EMPLEADO, PLANIFICACION/MATERIALES'),\r\n" + 
			"(1594,'EMPLEADO, PLANILLERO'),\r\n" + 
			"(1595,'EMPLEADO, POMPAS FUNEBRES/AGENCIA FUNERARIA'),\r\n" + 
			"(1596,'EMPLEADO, PROGRAMA DE ABASTECIMIENTO/MATERIALES'),\r\n" + 
			"(1597,'EMPLEADO, RECEPCION/MERCADERIA (ALMACEN)'),\r\n" + 
			"(1598,'EMPLEADO, REGISTRADOR/ENTRADAS Y SALIDAS DE MERCADERIAS'),\r\n" + 
			"(1599,'EMPLEADO, REGISTRO DE TITULOS Y ACCIONES'),\r\n" + 
			"(1600,'EMPLEADO, SEGUROS'),\r\n" + 
			"(1601,'EMPLEADO, SEGUROS/MODIFICACIONES DE COBERTURA'),\r\n" + 
			"(1602,'EMPLEADO, SEGUROS/PAGO DE SUMINISTROS'),\r\n" + 
			"(1603,'EMPLEADO, SEGUROS/POLIZAS'),\r\n" + 
			"(1604,'EMPLEADO, SERVICIO DE ALMACENAJE'),\r\n" + 
			"(1605,'EMPLEADO, SERVICIO DEL PERSONAL'),\r\n" + 
			"(1606,'EMPLEADO, SERVICIOS FINANCIEROS'),\r\n" + 
			"(1607,'EMPLEADO, SERVICIOS JURIDICOS'),\r\n" + 
			"(1608,'EMPLEADO, SUBASTAS'),\r\n" + 
			"(1609,'EMPLEADO, SUMINISTROS'),\r\n" + 
			"(1610,'EMPLEADO, TENEDURIA DE LIBROS'),\r\n" + 
			"(1611,'EMPLEADO, TRANSACCIONES'),\r\n" + 
			"(1612,'EMPLEADO, TRANSPORTE'),\r\n" + 
			"(1613,'EMPLEADO, TRANSPORTE AEREO/EXPEDICION'),\r\n" + 
			"(1614,'EMPLEADO, TRANSPORTE AEREO/MOVIMIENTO'),\r\n" + 
			"(1615,'EMPLEADO, TRANSPORTE MARITIMO/ESTACION TERMINAL'),\r\n" + 
			"(1616,'EMPLEADO, TRANSPORTE MARITIMO/MUELLE'),\r\n" + 
			"(1617,'EMPLEADO, TRANSPORTE POR CARRETERA/TRAFICO'),\r\n" + 
			"(1618,'EMPLEADO, VALORES'),\r\n" + 
			"(1619,'EMPLEADO, VENTANILLA DE BANCO'),\r\n" + 
			"(1620,'EMPLEADO, VENTANILLA DE CORREOS'),\r\n" + 
			"(1621,'EMPLEADO, VIAJES'),\r\n" + 
			"(1622,'EMPLEADO, VIAJES/FERROCARRILES'),\r\n" + 
			"(1623,'EMPLEADO, VIAJES/LINEAS AEREAS'),\r\n" + 
			"(1624,'EMPLEADOS DE CONTABILIDAD Y CALCULO DE COSTOS'),\r\n" + 
			"(1625,'EMPRESARIO, CINE'),\r\n" + 
			"(1626,'EMPRESARIO, CIRCO'),\r\n" + 
			"(1627,'EMPRESARIO, MUSICA'),\r\n" + 
			"(1628,'EMPRESARIO, POMPAS FUNEBRES'),\r\n" + 
			"(1629,'EMPRESARIO, TEATRO'),\r\n" + 
			"(1630,'EMSAMBLADOR DE NAIPES'),\r\n" + 
			"(1631,'EN METAL DE PAJA Y SIMILARES'),\r\n" + 
			"(1632,'EN TERRAZO'),\r\n" + 
			"(1633,'ENCAJADERO A MANO'),\r\n" + 
			"(1634,'ENCALLADOR'),\r\n" + 
			"(1635,'ENCANTADOR, SERPIENTES'),\r\n" + 
			"(1636,'ENCARGADO DE ACUARIO'),\r\n" + 
			"(1637,'ENCARGADO DE NEGOCIOS, EMBAJADA'),\r\n" + 
			"(1638,'ENCARGADO DEL SERVICIO DE MANTENIMIENTO DE TRAMITES, ETC.'),\r\n" + 
			"(1639,'ENCARGADO, ENTREGA DE ENCOMIENDAS A DOMICILIO'),\r\n" + 
			"(1640,'ENCARGADO, INMUEBLE'),\r\n" + 
			"(1641,'ENCARGADO, LOCAL DE ASEO'),\r\n" + 
			"(1642,'ENCARGADO, SERVICIOS/FERROCARRIL (DEPOSITO)'),\r\n" + 
			"(1643,'ENCARGADO, SERVICIOS/MUELLE'),\r\n" + 
			"(1644,'ENCARGADO, SERVICIOS/TRANSBORDADOR'),\r\n" + 
			"(1645,'ENCARGADO, SERVICIOS/TRANSPORTE POR CARRETERA (TRAFICO)'),\r\n" + 
			"(1646,'ENCARRETADOR, TEXTIL'),\r\n" + 
			"(1647,'ENCEBADOR, CAZA CON TRAMPA'),\r\n" + 
			"(1648,'ENCOFRADOR EN MADERA'),\r\n" + 
			"(1649,'ENCOGEDOR DE PRODUCTOS TEXTILES'),\r\n" + 
			"(1650,'ENCOLADOR DE CHAPAS DE MADERA'),\r\n" + 
			"(1651,'ENCOLADOR, TEXTILES'),\r\n" + 
			"(1652,'ENCOLADOR,ENCUADERNACION'),\r\n" + 
			"(1653,'ENCOMENDERO, REPARTO DE ENCOMIENDAS'),\r\n" + 
			"(1654,'ENCUADERNADOR'),\r\n" + 
			"(1655,'ENCUESTADORES'),\r\n" + 
			"(1656,'ENFERMERA, NIVEL MEDIO'),\r\n" + 
			"(1657,'ENFERMERA, NIVEL MEDIO/CLINICA, CENTRO DE SALUD, ETC.'),\r\n" + 
			"(1658,'ENFERMERA, NIVEL MEDIO/MATERNIDAD'),\r\n" + 
			"(1659,'ENFERMERA, NIVEL MEDIO/OBSTETRICIA'),\r\n" + 
			"(1660,'ENFERMERA, NIVEL MEDIO/ORTOPEDIA'),\r\n" + 
			"(1661,'ENFERMERA, NIVEL MEDIO/PEDIATRIA'),\r\n" + 
			"(1662,'ENFERMERA, NIVEL SUPERIOR (DIPLOMADOS)'),\r\n" + 
			"(1663,'ENFERMERA, NIVEL SUPERIOR/CLINICA'),\r\n" + 
			"(1664,'ENFERMERA, NIVEL SUPERIOR/CONSULTORIO'),\r\n" + 
			"(1665,'ENFERMERA, NIVEL SUPERIOR/HOSPITAL'),\r\n" + 
			"(1666,'ENFERMERA, NIVEL SUPERIOR/MATERNIDAD'),\r\n" + 
			"(1667,'ENFERMERA, NIVEL SUPERIOR/OBSTETRICIA'),\r\n" + 
			"(1668,'ENFERMERA, TECMICO'),\r\n" + 
			"(1669,'ENFERMERA, TECNICO'),\r\n" + 
			"(1670,'ENFERMERO, AMBULANCIA'),\r\n" + 
			"(1671,'ENFERMERO, NIVEL MEDIO'),\r\n" + 
			"(1672,'ENFERMERO, NIVEL MEDIO/CLINICA'),\r\n" + 
			"(1673,'ENFERMERO, NIVEL MEDIO/OBSTETRICIA'),\r\n" + 
			"(1674,'ENFERMERO, NIVEL MEDIO/ORTOPEDIA'),\r\n" + 
			"(1675,'ENFERMERO, NIVEL MEDIO/PEDIATRIA'),\r\n" + 
			"(1676,'ENFERMERO, NIVEL SUPERIOR'),\r\n" + 
			"(1677,'ENFERMERO, NIVEL SUPERIOR (DIPLOMADOS)'),\r\n" + 
			"(1678,'ENFERMERO, NIVEL SUPERIOR/CLINICA'),\r\n" + 
			"(1679,'ENFERMERO, NIVEL SUPERIOR/HOSPITAL'),\r\n" + 
			"(1680,'ENFOSCADOR'),\r\n" + 
			"(1681,'ENFRASCADOR DE VINOS'),\r\n" + 
			"(1682,'ENFRIADOR DE TABACO'),\r\n" + 
			"(1683,'ENGANCHADOR AGRICOLA'),\r\n" + 
			"(1684,'ENGANCHADOR DE VAGONES,FERROCARRILES'),\r\n" + 
			"(1685,'ENGANCHADOR, MINAS'),\r\n" + 
			"(1686,'ENGASTADOR'),\r\n" + 
			"(1687,'ENGOMADOR DE TEJIDOS DE CAUCHO'),\r\n" + 
			"(1688,'ENGRASADOR DE BARCOS'),\r\n" + 
			"(1689,'ENLATADOR DE PESCADO'),\r\n" + 
			"(1690,'ENLAZADOR DE CARTONES JACQUARD'),\r\n" + 
			"(1691,'ENLISTONADOR'),\r\n" + 
			"(1692,'ENLOSADOR'),\r\n" + 
			"(1693,'ENLUCIDOR EN YESO, EN GENERAL'),\r\n" + 
			"(1694,'ENSACADOR A MANO'),\r\n" + 
			"(1695,'ENSACADOR, A MANO'),\r\n" + 
			"(1696,'ENSAMBLADOR DE PRODUCTOS DE CAUCHO'),\r\n" + 
			"(1697,'ENSAMBLADOR DE PRODUCTOS DE PLASTICO'),\r\n" + 
			"(1698,'ENSAYISTA'),\r\n" + 
			"(1699,'ENTARUGADOR DE PAVIMENTOS'),\r\n" + 
			"(1700,'ENTIBADOR, ENMADERADOR DE MINA O DE GALERIA'),\r\n" + 
			"(1701,'ENTOMOLOGO'),\r\n" + 
			"(1702,'ENTRENADOR, ARTES MARCIALES'),\r\n" + 
			"(1703,'ENTRENADOR, ATLETISMO'),\r\n" + 
			"(1704,'ENTRENADOR, BOXEO'),\r\n" + 
			"(1705,'ENTRENADOR, CABALLOS DE CARRERA'),\r\n" + 
			"(1706,'ENTRENADOR, GOLF'),\r\n" + 
			"(1707,'ENTRENADOR, LUCHA'),\r\n" + 
			"(1708,'ENTRENADOR, YOGA'),\r\n" + 
			"(1709,'ENTREVISTADOR, COLOCACION'),\r\n" + 
			"(1710,'ENVASADOR A MANO O Y/O MAQUINA'),\r\n" + 
			"(1711,'ENVASADOR, A MANO'),\r\n" + 
			"(1712,'EPIDEMIOLOGO'),\r\n" + 
			"(1713,'EQUILIBRISTA'),\r\n" + 
			"(1714,'ERGOTERAPEUTA'),\r\n" + 
			"(1715,'ESCABECHERO'),\r\n" + 
			"(1716,'ESCALADOR-PODADOR, ARBOLES'),\r\n" + 
			"(1717,'ESCAMADOR DE PESCADO'),\r\n" + 
			"(1718,'ESCAPARATISTA DECORADOR'),\r\n" + 
			"(1719,'ESCARCHADOR DE FRUTAS'),\r\n" + 
			"(1720,'ESCARGADO DE MATADERO'),\r\n" + 
			"(1721,'ESCAYOLISTA-DECORADOR, ESCAYOLISTA'),\r\n" + 
			"(1722,'ESCOBERO'),\r\n" + 
			"(1723,'ESCOGEDOR DE BOTELLAS'),\r\n" + 
			"(1724,'ESCOGEDOR DE FIBRA'),\r\n" + 
			"(1725,'ESCOGEDOR DE MINERALES'),\r\n" + 
			"(1726,'ESCOGEDOR DE PIEDRAS'),\r\n" + 
			"(1727,'ESCOGEDOR DE PIELES SIN TRATAR'),\r\n" + 
			"(1728,'ESCOGEDOR DE TABACO'),\r\n" + 
			"(1729,'ESCOGEDOR Y COMBINADOR DE PIELES VALIOSAS'),\r\n" + 
			"(1730,'ESCOPETERO'),\r\n" + 
			"(1731,'ESCRIBANO DE ESTADO'),\r\n" + 
			"(1732,'ESCRIBIENTE DE ABOGADO'),\r\n" + 
			"(1733,'ESCRIBIENTE DE NOTARIO'),\r\n" + 
			"(1734,'ESCRIBIENTE DE PROCURADOR'),\r\n" + 
			"(1735,'ESCRIBIENTE PUBLICO'),\r\n" + 
			"(1736,'ESCRITOR'),\r\n" + 
			"(1737,'ESCRITOR, LIBRETOS'),\r\n" + 
			"(1738,'ESCRITOR, NOVELAS'),\r\n" + 
			"(1739,'ESCRITOR, POESIA'),\r\n" + 
			"(1740,'ESCRITOR, TEATRO'),\r\n" + 
			"(1741,'ESCUADRADOR, TRONCOS'),\r\n" + 
			"(1742,'ESCULTOR'),\r\n" + 
			"(1743,'ESMALTADOR DE CERAMICA'),\r\n" + 
			"(1744,'ESMALTADOR DE METALES PRECIOSOS'),\r\n" + 
			"(1745,'ESMALTADOR DE VIDRIO'),\r\n" + 
			"(1746,'ESMERILADOR CON CHORROS DE ARENA,VIDRIO'),\r\n" + 
			"(1747,'ESMERILADOR DE BORDES,VIDRIO'),\r\n" + 
			"(1748,'ESMERILADOR DE LENTES A MAQUINA'),\r\n" + 
			"(1749,'ESMERILADOR VIDRIO O CRISTAL CON CHORRO DE ARENA'),\r\n" + 
			"(1750,'ESPAPADOR'),\r\n" + 
			"(1751,'ESPECIALISTA CUESTIONES DE PERSONAL'),\r\n" + 
			"(1752,'ESPECIALISTA EN COOPERATIVAS'),\r\n" + 
			"(1753,'ESPECIALISTA EN ORTOPTIA Y/O ORTOFONIA'),\r\n" + 
			"(1754,'ESPECIALISTA, BIBLIOTECONOMIA'),\r\n" + 
			"(1755,'ESPECIALISTA, CIENCIAS POLITICAS'),\r\n" + 
			"(1756,'ESPECIALISTA, ENSEÐANZA/METODOS AUDIOVISUALES'),\r\n" + 
			"(1757,'ESPECIALISTA, FONETICA'),\r\n" + 
			"(1758,'ESPECIALISTA, FORMACION DEL PERSONAL'),\r\n" + 
			"(1759,'ESPECIALISTA, PREVENCION DE INCENDIOS'),\r\n" + 
			"(1760,'ESPECIALISTA, RELACIONES PROFESIONALES'),\r\n" + 
			"(1761,'ESPECIALISTA, SALVAMENTO/INCENDIOS (DESASTRES)'),\r\n" + 
			"(1762,'ESPECIALISTA, SEGURIDAD EN EL TRABAJO'),\r\n" + 
			"(1763,'ESPECIALISTA, SEMANTICA'),\r\n" + 
			"(1764,'ESPECIALISTA, TRATAMIENTOS DE BELLEZA'),\r\n" + 
			"(1765,'ESQUILADOR'),\r\n" + 
			"(1766,'ESQUILADOR (OBRERO)'),\r\n" + 
			"(1767,'ESTABLERO, CABALLOS REPRODUCTORES'),\r\n" + 
			"(1768,'ESTADISTICO'),\r\n" + 
			"(1769,'ESTADISTICO, AGRICULTURA'),\r\n" + 
			"(1770,'ESTADISTICO, BIOESTADISTICA'),\r\n" + 
			"(1771,'ESTADISTICO, BIOMETRIA'),\r\n" + 
			"(1772,'ESTADISTICO, ECONOMIA'),\r\n" + 
			"(1773,'ESTADISTICO, ENCUESTAS'),\r\n" + 
			"(1774,'ESTADISTICO, ENCUESTAS POR SONDEO'),\r\n" + 
			"(1775,'ESTADISTICO, ESTADISTICA APLICADA'),\r\n" + 
			"(1776,'ESTADISTICO, FINANZAS'),\r\n" + 
			"(1777,'ESTADISTICO, INVESTIGACION'),\r\n" + 
			"(1778,'ESTADISTICO, MATEMATICO'),\r\n" + 
			"(1779,'ESTADISTICO, MUESTRISTA'),\r\n" + 
			"(1780,'ESTAFETERO, RECIBIDOR DE CARGAS/CORREO'),\r\n" + 
			"(1781,'ESTAMPADOR TEXTILES Y PAPELES PINTADOS MEDIANTE PLANCHAS'),\r\n" + 
			"(1782,'ESTATUARIO'),\r\n" + 
			"(1783,'ESTEREOTIPADOR, IMPRENTA'),\r\n" + 
			"(1784,'ESTEREOTIPISTA, IMPRENTA'),\r\n" + 
			"(1785,'ESTERERO EN JUNCO,PITA Y FIBRA DE COCO'),\r\n" + 
			"(1786,'ESTERILIZADOR DE PRODUCTOS LACTEOS'),\r\n" + 
			"(1787,'ESTIBADOR CARGADOR DE BARCOS'),\r\n" + 
			"(1788,'ESTIBADOR, MANUAL'),\r\n" + 
			"(1789,'ESTILISTA'),\r\n" + 
			"(1790,'ESTIMADOR, QUIMICA INDUSTRIAL'),\r\n" + 
			"(1791,'ESTIRADOR DE FIBRA'),\r\n" + 
			"(1792,'ESTIRADOR DE PIELES'),\r\n" + 
			"(1793,'ESTIRADOR DE TUBOS SIN SOLDADURA'),\r\n" + 
			"(1794,'ESTRATIGRAFISTA'),\r\n" + 
			"(1795,'ESTRIBADOR DE MINERALES'),\r\n" + 
			"(1796,'ESTUFISTA,FUMISTA ALBAÐIL EN LA INDUSTRIA'),\r\n" + 
			"(1797,'ESTUQUISTA-DECORADOR,ESCOYOLISTA'),\r\n" + 
			"(1798,'ETIMOLOGISTA'),\r\n" + 
			"(1799,'ETIQUETADOR, A MANO'),\r\n" + 
			"(1800,'ETNOGRAFO'),\r\n" + 
			"(1801,'ETNOLOGO'),\r\n" + 
			"(1802,'EVALUADOR'),\r\n" + 
			"(1803,'EVALUADOR, SEGUROS/PRIMAS'),\r\n" + 
			"(1804,'EVANGELIZADOR'),\r\n" + 
			"(1805,'EXPENDEDOR DE GIROS POSTALES'),\r\n" + 
			"(1806,'EXPLOTADOR AGRICOLA, TRABAJADOR INDEPENDIENTE'),\r\n" + 
			"(1807,'EXPLOTADOR AGROPECUARIO, TRABAJADOR INDEPENDIENTE'),\r\n" + 
			"(1808,'EXPLOTADOR, FORESTAL O BOSQUES'),\r\n" + 
			"(1809,'EXTENSIONISTA AGRICOLA, VULGARIZADOR, AGRICOLA'),\r\n" + 
			"(1810,'EXTRACTOR DE ACEITE DE ORUJO'),\r\n" + 
			"(1811,'EXTRAS, DOBLES'),\r\n" + 
			"(1812,'EXTRUSOR DE ARCILLA,CERAMICA'),\r\n" + 
			"(1813,'EXTRUSOR DE CAUCHO'),\r\n" + 
			"(1814,'EXTRUSOR DE HILOS DE FIBRA DE VIDRIO'),\r\n" + 
			"(1815,'EXTRUSOR DE METALES'),\r\n" + 
			"(1816,'EXTRUSOR DE PLASTICO'),\r\n" + 
			"(1817,'FABRICANTE DE NEUMATICOS,PRIMERA FASE'),\r\n" + 
			"(1818,'FABRICANTE DE PIEZAS EN HORMIGON ARMADO'),\r\n" + 
			"(1819,'FABRICANTE DE PRODUCTOS DE ASBESTOS-CEMENTO'),\r\n" + 
			"(1820,'FABRICANTE DE PRODUCTOS DE PIEDRA ARTIFICIAL'),\r\n" + 
			"(1821,'FABRICANTES DE INSTRUMENTOS MUSIC., ARPAS, GUITARRA, VIENTO'),\r\n" + 
			"(1822,'FAGOTISTA'),\r\n" + 
			"(1823,'FARMACEUTICO'),\r\n" + 
			"(1824,'FARMACEUTICO, COMERCIO'),\r\n" + 
			"(1825,'FARMACEUTICO, HOSPITAL'),\r\n" + 
			"(1826,'FARMACOLOGO'),\r\n" + 
			"(1827,'FEDERO A MANO'),\r\n" + 
			"(1828,'FERMENTADOR'),\r\n" + 
			"(1829,'FERMENTADOR DE VINOS'),\r\n" + 
			"(1830,'FIAMBRERO, CARNES'),\r\n" + 
			"(1831,'FIDERO'),\r\n" + 
			"(1832,'FILETERO, DECORADO DE CERAMICA'),\r\n" + 
			"(1833,'FILIGRANISTA,JOYERO O PLATERO'),\r\n" + 
			"(1834,'FILOLOGO'),\r\n" + 
			"(1835,'FILOLOGO, ETIMOLOGIA'),\r\n" + 
			"(1836,'FILOLOGO, FONETICA'),\r\n" + 
			"(1837,'FILOLOGO, FONOLOGIA'),\r\n" + 
			"(1838,'FILOLOGO, GRAFOLOGIA'),\r\n" + 
			"(1839,'FILOLOGO, LEXICOGRAFIA'),\r\n" + 
			"(1840,'FILOLOGO, LINGUISTICA'),\r\n" + 
			"(1841,'FILOLOGO, MORFOLOGIA'),\r\n" + 
			"(1842,'FILOLOGO, SEMANTICA'),\r\n" + 
			"(1843,'FILOSOFO'),\r\n" + 
			"(1844,'FILOSOFO, CIENCIAS POLITICAS'),\r\n" + 
			"(1845,'FILTRADOR DE CERVEZA'),\r\n" + 
			"(1846,'FISCAL DE LA CORTE SUPERIOR O SUPREMA'),\r\n" + 
			"(1847,'FISCAL DE LA NACION'),\r\n" + 
			"(1848,'FISICO'),\r\n" + 
			"(1849,'FISICO, ACUSTICA'),\r\n" + 
			"(1850,'FISICO, ELECTRICIDAD Y MAGNETISMO'),\r\n" + 
			"(1851,'FISICO, ELECTRONICA'),\r\n" + 
			"(1852,'FISICO, ENERGIA NUCLEAR'),\r\n" + 
			"(1853,'FISICO, ENERGIA SOLAR (NO CONVENCIONAL)'),\r\n" + 
			"(1854,'FISICO, ESTATICA'),\r\n" + 
			"(1855,'FISICO, FISICA NUCLEAR'),\r\n" + 
			"(1856,'FISICO, FISICA TEORICA'),\r\n" + 
			"(1857,'FISICO, MATEMATICO'),\r\n" + 
			"(1858,'FISICO, MECANICA'),\r\n" + 
			"(1859,'FISICO, OPTICA'),\r\n" + 
			"(1860,'FISICO, OTRO'),\r\n" + 
			"(1861,'FISICO, SONIDO'),\r\n" + 
			"(1862,'FISICO, TERMODINAMICA'),\r\n" + 
			"(1863,'FISIOLOGO'),\r\n" + 
			"(1864,'FISIOLOGO, ANIMALES'),\r\n" + 
			"(1865,'FISIOLOGO, ENDOCRINOLOGIA'),\r\n" + 
			"(1866,'FISIOLOGO, EPIDEMIOLOGIA'),\r\n" + 
			"(1867,'FISIOLOGO, OTROS'),\r\n" + 
			"(1868,'FISIOTERAPEUTA (TERAPEUTA)'),\r\n" + 
			"(1869,'FLAUTISTA'),\r\n" + 
			"(1870,'FLEQUERO A MANO'),\r\n" + 
			"(1871,'FLEQUERO A MAQUINA'),\r\n" + 
			"(1872,'FLORICULTOR'),\r\n" + 
			"(1873,'FLORICULTOR, ROSAS'),\r\n" + 
			"(1874,'FLORICULTOR, TULIPANES'),\r\n" + 
			"(1875,'FLOTADOR, TRONCOS'),\r\n" + 
			"(1876,'FLY HOSTESS, AEROMOZA'),\r\n" + 
			"(1877,'FOGONERO DE BARCO'),\r\n" + 
			"(1878,'FOGONERO DE CALDERA DE VAPOR, EXCEPTO FOGONERO DE BARCO O L'),\r\n" + 
			"(1879,'FOGONERO DE LOCOMOTORA DE VAPOR'),\r\n" + 
			"(1880,'FOLLETINISTA'),\r\n" + 
			"(1881,'FONTANERO,EN GENERAL'),\r\n" + 
			"(1882,'FORJADOR'),\r\n" + 
			"(1883,'FOTOGRABADOR EN GENERAL'),\r\n" + 
			"(1884,'FOTOGRAFO'),\r\n" + 
			"(1885,'FOTOGRAFO AEREO'),\r\n" + 
			"(1886,'FOTOGRAFO AMBULANTE'),\r\n" + 
			"(1887,'FOTOGRAFO COMERCIAL'),\r\n" + 
			"(1888,'FOTOGRAFO INDUSTRIAL'),\r\n" + 
			"(1889,'FOTOGRAFO MEDICO'),\r\n" + 
			"(1890,'FOTOGRAFO PUBLICITARIO'),\r\n" + 
			"(1891,'FOTOGRAFO RETRATISTA'),\r\n" + 
			"(1892,'FOTOGRAFO, ARQUITECTURA'),\r\n" + 
			"(1893,'FOTOGRAFO, FOTOGRAB., IMPRESION O REPROD. EN OFFSET'),\r\n" + 
			"(1894,'FOTOGRAFO, ILUSTRACION COMERCIAL'),\r\n" + 
			"(1895,'FOTOGRAFO, MICROFOTOGRAFIA'),\r\n" + 
			"(1896,'FOTOGRAFO, MODAS'),\r\n" + 
			"(1897,'FOTOGRAFO, POLICIA'),\r\n" + 
			"(1898,'FOTOGRAFO, PRENSA'),\r\n" + 
			"(1899,'FOTOGRAFO-AMPLIADOR'),\r\n" + 
			"(1900,'FOTOGRAFO-REVELADOR'),\r\n" + 
			"(1901,'FOTOGRAFO-SACADOR DE COPIAS'),\r\n" + 
			"(1902,'FOTOGRAMETRISTA Y AEROFOTOGRAMETISTA'),\r\n" + 
			"(1903,'FOTO-IMPRESOR PLANCHAS IMPRESION, FOTOGRABADO'),\r\n" + 
			"(1904,'FOTOMECANICO, FOTOGRABADO EN GENERAL'),\r\n" + 
			"(1905,'FRAILE'),\r\n" + 
			"(1906,'FRESADOR'),\r\n" + 
			"(1907,'FRUTICULTOR'),\r\n" + 
			"(1908,'FUNAMBULO'),\r\n" + 
			"(1909,'FUNCIONARIO, CONSULADO'),\r\n" + 
			"(1910,'FUNCIONARIO, EXPEDICION DE LICENCIAS Y PERMISOS'),\r\n" + 
			"(1911,'FUNCIONARIO, EXPEDICION DE LICENCIAS/EXPORTACION'),\r\n" + 
			"(1912,'FUNCIONARIO, EXPEDICION DE LICENCIAS/IMPORTACION'),\r\n" + 
			"(1913,'FUNCIONARIO, EXPEDICION DE PASAPORTES'),\r\n" + 
			"(1914,'FUNCIONARIO, INMIGRACION'),\r\n" + 
			"(1915,'FUNCIONARIO, PERMISOS DE CONSTRUCCION'),\r\n" + 
			"(1916,'FUNCIONARIO, PRESTACIONES SOCIALES Y OTROS'),\r\n" + 
			"(1917,'FUNCIONARIO, SERVICIO DEL EMPLEO'),\r\n" + 
			"(1918,'FUNCIONARIO, SERVICIO DEL EMPLEO/JOVENES'),\r\n" + 
			"(1919,'FUNDIDOR DE ALTO HORNO, FUSION DE MINERAL'),\r\n" + 
			"(1920,'FUNDIDOR DE CONVERTIDOR BESSEMER, DE ACERO'),\r\n" + 
			"(1921,'FUNDIDOR DE CONVERTIDOR DE ACERO, AL OXIGENO'),\r\n" + 
			"(1922,'FUNDIDOR DE CRISOLES, SEGUNDA FUSION'),\r\n" + 
			"(1923,'FUNDIDOR DE CUBILOTE'),\r\n" + 
			"(1924,'FUNDIDOR DE HORNO DE HOGAR ABIERTO, SEG. FUSION'),\r\n" + 
			"(1925,'FUNDIDOR DE MONOTIPIA Y TIPOS SUELTOS'),\r\n" + 
			"(1926,'FUNDIDOR DE PIEZAS DE MOLDES'),\r\n" + 
			"(1927,'FUNDIDOR EN EL AFINO Y REFINO DE METALES NO FERREOS'),\r\n" + 
			"(1928,'FUNDIDOR EN HORNO DE ACERO MARTIN SIEMENS'),\r\n" + 
			"(1929,'FUNDIDOR EN HORNO DE CONVER. Y AFINADO DE METAL.NO FERREOS'),\r\n" + 
			"(1930,'FUNDIDOR EN HORNO DE REVERBERO, SEGUNDA FUSION'),\r\n" + 
			"(1931,'FUNDIDOR EN HORNO ELECTRICO DE ARCO, REFINO DE ACERO'),\r\n" + 
			"(1932,'FUNDIDOR EN HORNO ELECTRICO, SEGUNDA FUSION'),\r\n" + 
			"(1933,'FUNDIDOR EN HORNO THOMAS'),\r\n" + 
			"(1934,'FUNDIDOR EN HORNOS'),\r\n" + 
			"(1935,'FUNDIDOR EN SEGUNDA FUSION'),\r\n" + 
			"(1936,'FUNDIDOR ESTEREOTIPISTA'),\r\n" + 
			"(1937,'FUNDIDOR VIDRIERO'),\r\n" + 
			"(1938,'FUNIGADOR - CONDUCTOR'),\r\n" + 
			"(1939,'FUTBOLISTA'),\r\n" + 
			"(1940,'GABARRERO'),\r\n" + 
			"(1941,'GACETILLERO'),\r\n" + 
			"(1942,'GAÐAN'),\r\n" + 
			"(1943,'GALLETAS, FABRICACION, OPERADOR MAQUINAS SOBADORA DE MASA'),\r\n" + 
			"(1944,'GALLETAS, OPERADOR DE TROQUEL'),\r\n" + 
			"(1945,'GALONERO A MAQUINA'),\r\n" + 
			"(1946,'GALVANIZADOR EN BAÐO CALIENTE'),\r\n" + 
			"(1947,'GALVANOPLASTISTA O CLISADOR'),\r\n" + 
			"(1948,'GANADERO'),\r\n" + 
			"(1949,'GANADERO CABALLO'),\r\n" + 
			"(1950,'GANADERO FORESTAL, TRABAJADOR INDEPENDIENTE'),\r\n" + 
			"(1951,'GANADERO LANAL'),\r\n" + 
			"(1952,'GANADERO PORCINO'),\r\n" + 
			"(1953,'GANADERO VACUNO (EXECPTO GANADO LECHERO)'),\r\n" + 
			"(1954,'GANADERO, AUQUENIDOS'),\r\n" + 
			"(1955,'GANADERO, CUNICULTOR/CONEJO'),\r\n" + 
			"(1956,'GANADERO, CUYES'),\r\n" + 
			"(1957,'GANADERO, TORO DE LIDIA'),\r\n" + 
			"(1958,'GANCHERO FORESTAL'),\r\n" + 
			"(1959,'GANCHILLERO A MANO'),\r\n" + 
			"(1960,'GASEADOR DE SIDRA'),\r\n" + 
			"(1961,'GASEADOR, TEXTILES'),\r\n" + 
			"(1962,'GASFITERO'),\r\n" + 
			"(1963,'GENEOLOGISTA'),\r\n" + 
			"(1964,'GENETISTA'),\r\n" + 
			"(1965,'GENETISTA, BOTANICA'),\r\n" + 
			"(1966,'GENETISTA, ZOOLOGO'),\r\n" + 
			"(1967,'GEODESIA'),\r\n" + 
			"(1968,'GEOFISICO (INCLUYE INGENIEROS)'),\r\n" + 
			"(1969,'GEOFISICO, GEOMORFOLOGIA'),\r\n" + 
			"(1970,'GEOFISICO, HIDROLOGIA'),\r\n" + 
			"(1971,'GEOFISICO, OCEANOGRAFIA'),\r\n" + 
			"(1972,'GEOFISICO, SISMOLOGIA'),\r\n" + 
			"(1973,'GEOFISICO, VULCANOLOGIA'),\r\n" + 
			"(1974,'GEOGRAFO, GEOGRAFIA ECONOMICA'),\r\n" + 
			"(1975,'GEOGRAFO, GEOGRAFIA FISICA'),\r\n" + 
			"(1976,'GEOGRAFO, GEOGRAFIA POLITICO'),\r\n" + 
			"(1977,'GEOLOGO (INCLUYE INGENIEROS)'),\r\n" + 
			"(1978,'GEOLOGO, ESTRATIGRAFIA'),\r\n" + 
			"(1979,'GEOLOGO, MINAS'),\r\n" + 
			"(1980,'GEOLOGO, OCEANOGRAFIA'),\r\n" + 
			"(1981,'GEOLOGO, PALEONTOLOGIA'),\r\n" + 
			"(1982,'GEOLOGO, PETROLEO'),\r\n" + 
			"(1983,'GEOMANTICO'),\r\n" + 
			"(1984,'GEOMORFOLOGO'),\r\n" + 
			"(1985,'GEREN.-ADM., AGENCIA DE LIMPIEZA Y DESINFECCION'),\r\n" + 
			"(1986,'GEREN.-ADM., AGENCIA DE POMPAS FUNEBRES'),\r\n" + 
			"(1987,'GEREN.-ADM., AGENCIA DE PROTECCION Y SEGURIDAD'),\r\n" + 
			"(1988,'GEREN.-ADM., AGENCIA DE SERVICIOS/EXCEPTO:BARES, HOTEL Y SI'),\r\n" + 
			"(1989,'GEREN.-ADM., AGENCIA DE TURISMO/EXCURSIONES'),\r\n" + 
			"(1990,'GEREN.-ADM., CENTRO DE ESTETICA'),\r\n" + 
			"(1991,'GEREN.-ADM., CENTRO DE RECREACION'),\r\n" + 
			"(1992,'GEREN.-ADM., GIMNASIO'),\r\n" + 
			"(1993,'GEREN.-ADM., LAVANDERIA'),\r\n" + 
			"(1994,'GEREN.-ADM., TALLERES/MEDIANOS Y PEQUEÐOS'),\r\n" + 
			"(1995,'GERENTE DE ADMINISTRACION'),\r\n" + 
			"(1996,'GERENTE DE COMERCIALIZACION'),\r\n" + 
			"(1997,'GERENTE DE CREDITOS'),\r\n" + 
			"(1998,'GERENTE DE PLANTA'),\r\n" + 
			"(1999,'GERENTE DE PRODUCCION'),\r\n" + 
			"(2000,'GERENTE DE VENTAS'),\r\n" + 
			"(2001,'GERENTE GENERAL, EMPRESA/ACTIVIDADES CULTURALES'),\r\n" + 
			"(2002,'GERENTE GENERAL, EMPRESA/ACTIVIDADES DEPORTIVAS'),\r\n" + 
			"(2003,'GERENTE GENERAL, EMPRESA/ACTIVIDADES RECREATIVAS'),\r\n" + 
			"(2004,'GERENTE GENERAL, EMPRESA/AGENCIA DE VIAJES'),\r\n" + 
			"(2005,'GERENTE GENERAL, EMPRESA/AGRICULTURA'),\r\n" + 
			"(2006,'GERENTE GENERAL, EMPRESA/ALMACENAMIENTO'),\r\n" + 
			"(2007,'GERENTE GENERAL, EMPRESA/CAZA'),\r\n" + 
			"(2008,'GERENTE GENERAL, EMPRESA/COMERCIO MAYORISTA'),\r\n" + 
			"(2009,'GERENTE GENERAL, EMPRESA/COMERCIO MINORISTA'),\r\n" + 
			"(2010,'GERENTE GENERAL, EMPRESA/COMUNICACIONES'),\r\n" + 
			"(2011,'GERENTE GENERAL, EMPRESA/CONSTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(2012,'GERENTE GENERAL, EMPRESA/HOTELERIA'),\r\n" + 
			"(2013,'GERENTE GENERAL, EMPRESA/INDUSTRIA MANUFACTURERA'),\r\n" + 
			"(2014,'GERENTE GENERAL, EMPRESA/INTERMEDIACION FINANCIERA'),\r\n" + 
			"(2015,'GERENTE GENERAL, EMPRESA/LIMPIEZA'),\r\n" + 
			"(2016,'GERENTE GENERAL, EMPRESA/PESCA'),\r\n" + 
			"(2017,'GERENTE GENERAL, EMPRESA/RESTAURANTE'),\r\n" + 
			"(2018,'GERENTE GENERAL, EMPRESA/SERVICIO DE EMPRESA'),\r\n" + 
			"(2019,'GERENTE GENERAL, EMPRESA/SERVICIO DE SANIDAD'),\r\n" + 
			"(2020,'GERENTE GENERAL, EMPRESA/SILVICULTURA'),\r\n" + 
			"(2021,'GERENTE GENERAL, EMPRESA/SUMINISTRO DE ELECTRICIDAD, GAS Y AGUA'),\r\n" + 
			"(2022,'GERENTE GENERAL, EMPRESA/TRABAJO SOCIAL'),\r\n" + 
			"(2023,'GERENTE GENERAL, EMPRESA/TRANSPORTE'),\r\n" + 
			"(2024,'GERENTE GENERAL, ORGANIZACION/ACTIVIDADES CULTURALES'),\r\n" + 
			"(2025,'GERENTE GENERAL, ORGANIZACION/ACTIVIDADES DEPORTIVAS'),\r\n" + 
			"(2026,'GERENTE GENERAL, ORGANIZACION/ACTIVIDADES RECREATIVAS'),\r\n" + 
			"(2027,'GERENTE GENERAL, ORGANIZACION/AGENCIA DE VIAJES'),\r\n" + 
			"(2028,'GERENTE GENERAL, ORGANIZACION/CAZA'),\r\n" + 
			"(2029,'GERENTE GENERAL, ORGANIZACION/HOTELERIA'),\r\n" + 
			"(2030,'GERENTE GENERAL, ORGANIZACION/INTERMEDIACION FINANCIERA'),\r\n" + 
			"(2031,'GERENTE GENERAL, ORGANIZACION/LIMPIEZA'),\r\n" + 
			"(2032,'GERENTE GENERAL, ORGANIZACION/PESCA'),\r\n" + 
			"(2033,'GERENTE GENERAL, ORGANIZACION/RESTAURANTES'),\r\n" + 
			"(2034,'GERENTE GENERAL, ORGANIZACION/SERVICIO DE EMPRESA'),\r\n" + 
			"(2035,'GERENTE GENERAL, ORGANIZACION/SERVICIO DE SANIDAD'),\r\n" + 
			"(2036,'GERENTE GENERAL, ORGANIZACION/SILVICULTURA'),\r\n" + 
			"(2037,'GERENTE GENERAL, ORGANIZACION/TRABAJO SOCIAL'),\r\n" + 
			"(2038,'GERENTE GENERAL, ORGANIZACION/TRANSPORTE'),\r\n" + 
			"(2039,'GERENTE INDUSTRIAL'),\r\n" + 
			"(2040,'GERENTE ORGANIZACION, EMPRESA/COMERCIO MAYORISTA'),\r\n" + 
			"(2041,'GERENTE ORGANIZACION, EMPRESA/COMERCIO MINORISTA'),\r\n" + 
			"(2042,'GERENTE REPARACION DE VEHICULOS, AUTO MOTORES, MOTOCICLETAS'),\r\n" + 
			"(2043,'GERENTE, AGRICULTURA'),\r\n" + 
			"(2044,'GERENTE, ALBERGUE/ JOVENES'),\r\n" + 
			"(2045,'GERENTE, ALMACENAMIENTO'),\r\n" + 
			"(2046,'GERENTE, BAR/DISCOTECA Y SNACK BAR'),\r\n" + 
			"(2047,'GERENTE, CAFE-TEATRO'),\r\n" + 
			"(2048,'GERENTE, CAFETERIA'),\r\n" + 
			"(2049,'GERENTE, CAMPAMENTO/ VACACIONES'),\r\n" + 
			"(2050,'GERENTE, CANTINA/ EMPRESA'),\r\n" + 
			"(2051,'GERENTE, CASA DE HUESPEDES'),\r\n" + 
			"(2052,'GERENTE, CAZA'),\r\n" + 
			"(2053,'GERENTE, COMERCIO MAYORISTA'),\r\n" + 
			"(2054,'GERENTE, COMERCIO MAYORISTA/ EXPORTACION'),\r\n" + 
			"(2055,'GERENTE, COMERCIO MAYORISTA/ IMPORTACION'),\r\n" + 
			"(2056,'GERENTE, COMERCIO MINORISTA'),\r\n" + 
			"(2057,'GERENTE, COMERCIO MINORISTA/ CADENA DE ALMACENES'),\r\n" + 
			"(2058,'GERENTE, COMERCIO MINORISTA/ TIENDAS'),\r\n" + 
			"(2059,'GERENTE, COMERCIO MINORISTA/ TIENDAS (AUTOSERVICIO)'),\r\n" + 
			"(2060,'GERENTE, COMERCIO MINORISTA/ TIENDAS (VENTAS CON DESCUENTOS'),\r\n" + 
			"(2061,'GERENTE, COMERCIO MINORISTA/ TIENDAS (VENTAS POR CORREO)'),\r\n" + 
			"(2062,'GERENTE, COMERCIO NEP'),\r\n" + 
			"(2063,'GERENTE, COMUNICACIONES'),\r\n" + 
			"(2064,'GERENTE, CONSTRUCCION'),\r\n" + 
			"(2065,'GERENTE, EXPLOTACION DE MINAS Y CANTERAS'),\r\n" + 
			"(2066,'GERENTE, EXPLOTACION: AGRICOLA, FORESTAL Y PECUARIA'),\r\n" + 
			"(2067,'GERENTE, FONDA'),\r\n" + 
			"(2068,'GERENTE, HOSTELERIA'),\r\n" + 
			"(2069,'GERENTE, HOTEL'),\r\n" + 
			"(2070,'GERENTE, INDUSTRIA MANUFACTURERA'),\r\n" + 
			"(2071,'GERENTE, MOTEL'),\r\n" + 
			"(2072,'GERENTE, PARQUE DE CARAVANAS'),\r\n" + 
			"(2073,'GERENTE, PEÐA'),\r\n" + 
			"(2074,'GERENTE, PENSION'),\r\n" + 
			"(2075,'GERENTE, PESCA'),\r\n" + 
			"(2076,'GERENTE, RESTAURANTE'),\r\n" + 
			"(2077,'GERENTE, RESTAURANTE/ AUTOSERVICIO'),\r\n" + 
			"(2078,'GERENTE, RESTAURANTE-BAR'),\r\n" + 
			"(2079,'GERENTE, SILVICULTURA'),\r\n" + 
			"(2080,'GERENTE, SNACK-BAR'),\r\n" + 
			"(2081,'GERENTE, SUMINISTRO DE ELECTRICIDAD, GAS Y AGUA'),\r\n" + 
			"(2082,'GERENTE, TABERNA'),\r\n" + 
			"(2083,'GERENTE, TIENDA'),\r\n" + 
			"(2084,'GERENTE, TRANSPORTE'),\r\n" + 
			"(2085,'GINECOLOGO'),\r\n" + 
			"(2086,'GOLONDRINO'),\r\n" + 
			"(2087,'GOMA MASCAR, CHICLE, OPERADOR MAQUINAS DE FABRICAR'),\r\n" + 
			"(2088,'GRABADOR A MANO CLISES MADERA, CAUCHO O LINOLEO'),\r\n" + 
			"(2089,'GRABADOR A MANO O A MAQUINA,ENCUADERNACION'),\r\n" + 
			"(2090,'GRABADOR ARTISTICO'),\r\n" + 
			"(2091,'GRABADOR CON PANTOGRAFO'),\r\n" + 
			"(2092,'GRABADOR DE AGUA FUERTE,CRISTAL'),\r\n" + 
			"(2093,'GRABADOR DE CERAMICA VIDRIADA'),\r\n" + 
			"(2094,'GRABADOR DE CRISTAL EN GENERAL'),\r\n" + 
			"(2095,'GRABADOR DE HIERRO, MARFIL,PLASTICO O HUESO'),\r\n" + 
			"(2096,'GRABADOR DE IMPRENTA'),\r\n" + 
			"(2097,'GRABADOR DE INSCRIPCIONES Y PIEDRA A MANO'),\r\n" + 
			"(2098,'GRABADOR DE MARFIL, HUESO Y PLASTICO'),\r\n" + 
			"(2099,'GRABADOR DE METALES PRECIOSOS'),\r\n" + 
			"(2100,'GRABADOR DE PIEDRA CON ESTARCIDORES'),\r\n" + 
			"(2101,'GRABADOR DE PIEDRAS LITOGRAFICAS'),\r\n" + 
			"(2102,'GRABADOR DE PLATERIA Y JOYERIA'),\r\n" + 
			"(2103,'GRABADOR DE RELIEVE EN PIEDRA A MANO'),\r\n" + 
			"(2104,'GRABADOR DE VIDRIO EN GENERAL'),\r\n" + 
			"(2105,'GRABADOR MOTIVOS SIMPLES EN BLOQUES DE PIEDRAS'),\r\n" + 
			"(2106,'GRABADOR PLANCHAS, CILINDROS Y MATRICES METALICO'),\r\n" + 
			"(2107,'GRABADOR, BURILISTA, LITOGRAFISTA, GRABADO IMPRENTA'),\r\n" + 
			"(2108,'GRABADOR, FOTOGRABADO'),\r\n" + 
			"(2109,'GRAFOLOGO'),\r\n" + 
			"(2110,'GRANEADOR DE PLANCHAS PARA CLISES'),\r\n" + 
			"(2111,'GRANJERO, AVICULTOR'),\r\n" + 
			"(2112,'GRUISTA,CONDUCTOR DE GRUA DE PORTICO O PTE GRUA'),\r\n" + 
			"(2113,'GRUMETE'),\r\n" + 
			"(2114,'GUARDA BARRERA,FERROCARRILES'),\r\n" + 
			"(2115,'GUARDA DE ESCLUSA,CANALES O PUERTOS'),\r\n" + 
			"(2116,'GUARDA DE PRENSA DE EMBALSE'),\r\n" + 
			"(2117,'GUARDA DE VALVULAS DE DESAGUE, EMBALSE'),\r\n" + 
			"(2118,'GUARDABOSQUES'),\r\n" + 
			"(2119,'GUARDAESPALDA'),\r\n" + 
			"(2120,'GUARDAFRENOS,TREN DE MERCANCIA'),\r\n" + 
			"(2121,'GUARDAGUJAS/CONTROLADOR DE TRAFICO FERROVIARIO'),\r\n" + 
			"(2122,'GUARDAGUJAS-ENGANCHADOR,(MINAS Y CANTERAS)'),\r\n" + 
			"(2123,'GUARDIA DE SEGURIDAD (PRIVADOS)'),\r\n" + 
			"(2124,'GUARDIAN'),\r\n" + 
			"(2125,'GUARDIAN, CARCEL'),\r\n" + 
			"(2126,'GUARDIAN, EDIFICIO'),\r\n" + 
			"(2127,'GUARDIAN, ESTACIONAMIENTO'),\r\n" + 
			"(2128,'GUARDIAN, FERIA'),\r\n" + 
			"(2129,'GUARDIAN, GALERIA DE ARTE'),\r\n" + 
			"(2130,'GUARDIAN, GANADO'),\r\n" + 
			"(2131,'GUARDIAN, GUARDARROPA'),\r\n" + 
			"(2132,'GUARDIAN, MUSEO'),\r\n" + 
			"(2133,'GUARDIAN, PAJARERA'),\r\n" + 
			"(2134,'GUARDIAN, PARQUE DE ATRACCIONES'),\r\n" + 
			"(2135,'GUARDIAN, PARQUE ZOOLOGICO'),\r\n" + 
			"(2136,'GUARDIAN, PARQUES Y JARDINES PUBLICOS'),\r\n" + 
			"(2137,'GUARDIAN, PRISION, ESTABLECIMIENTO PENAL'),\r\n" + 
			"(2138,'GUARDIAN, SALON DE DESCANSO'),\r\n" + 
			"(2139,'GUARDIAN, VESTUARIO'),\r\n" + 
			"(2140,'GUARNECEDOR CON PLUMAS DE ADORNO'),\r\n" + 
			"(2141,'GUARNECEDOR DE CALZADO'),\r\n" + 
			"(2142,'GUARNICIONERO'),\r\n" + 
			"(2143,'GUIA, EXCURSIONES'),\r\n" + 
			"(2144,'GUIA, EXPEDICION DE CAZA'),\r\n" + 
			"(2145,'GUIA, GALERIA DE ARTE'),\r\n" + 
			"(2146,'GUIA, MUSEOS'),\r\n" + 
			"(2147,'GUIA, TURISMO'),\r\n" + 
			"(2148,'GUIA, VIAJES/ANDINISMO'),\r\n" + 
			"(2149,'GUIA, VIAJES/AUTOBUS'),\r\n" + 
			"(2150,'GUIA, VIAJES/ESTABLECIMIENTOS INDUSTRIALES'),\r\n" + 
			"(2151,'GUIA, VIAJES/GALERIA DE ARTE'),\r\n" + 
			"(2152,'GUIA, VIAJES/LOCAL'),\r\n" + 
			"(2153,'GUIA, VIAJES/MONTAÑISMO'),\r\n" + 
			"(2154,'GUIA, VIAJES/MUSEOS'),\r\n" + 
			"(2155,'GUIA, VIAJES/PARQUES NATURALES Y RESERVAS NACIONALES'),\r\n" + 
			"(2156,'GUIA, VIAJES/PESCA'),\r\n" + 
			"(2157,'GUIA, VIAJES/RESERVA DE CAZA'),\r\n" + 
			"(2158,'GUIA, VIAJES/SAFARI'),\r\n" + 
			"(2159,'GUIA, VIAJES/TEATRO Y MONUMENTOS'),\r\n" + 
			"(2160,'GUILLOTINERO, ENCUADERNACION'),\r\n" + 
			"(2161,'GUIONISTA'),\r\n" + 
			"(2162,'GUITARRERO, FABRICANTE DE INSTRUMENTOS DE CUERDA'),\r\n" + 
			"(2163,'GUITARRISTA'),\r\n" + 
			"(2164,'HELADERO,FABRICACION'),\r\n" + 
			"(2165,'HENDEDOR DE CUEROS O CORTADOR DE CUEROS'),\r\n" + 
			"(2166,'HENDEDOR DE PIEDRAS'),\r\n" + 
			"(2167,'HERALDISTA'),\r\n" + 
			"(2168,'HERBOLARIO'),\r\n" + 
			"(2169,'HERMANA, ENFERMERA/NIVEL MEDIO'),\r\n" + 
			"(2170,'HERRADOR,HERRERO'),\r\n" + 
			"(2171,'HERRAMENTISTA'),\r\n" + 
			"(2172,'HERRERO,EN GENERAL'),\r\n" + 
			"(2173,'HIDROBIOLOGO'),\r\n" + 
			"(2174,'HIDROGENADOR DE ACEITES Y GRASAS'),\r\n" + 
			"(2175,'HIDROLOGO'),\r\n" + 
			"(2176,'HIDROTERAPEUTA'),\r\n" + 
			"(2177,'HIGIENISTA'),\r\n" + 
			"(2178,'HIGIENISTA, BUCODENTAL'),\r\n" + 
			"(2179,'HIGIENISTA, PROFILAXIA'),\r\n" + 
			"(2180,'HIGIENIZADOR DE LECHE'),\r\n" + 
			"(2181,'HILADOR DE NYLON'),\r\n" + 
			"(2182,'HILADOR DE RAYON Y SIMILARES'),\r\n" + 
			"(2183,'HILADOR DE TORNO'),\r\n" + 
			"(2184,'HILADOR DE VIDRIO'),\r\n" + 
			"(2185,'HILANDERO, HILO E HILAZA'),\r\n" + 
			"(2186,'HILANDEROS, TEJEDORES, TINTOREROS, TRABAJADORES ASIMILADOS'),\r\n" + 
			"(2187,'HIPNOTIZADOR'),\r\n" + 
			"(2188,'HISTOLOGO'),\r\n" + 
			"(2189,'HISTOLOGO, ANIMALES'),\r\n" + 
			"(2190,'HISTOLOGO, PLANTAS'),\r\n" + 
			"(2191,'HISTOPATOLOGO'),\r\n" + 
			"(2192,'HISTORIADOR'),\r\n" + 
			"(2193,'HISTORIADOR, CIENCIAS SOCIALES'),\r\n" + 
			"(2194,'HISTORIADOR, HISTORIA ECONOMICA'),\r\n" + 
			"(2195,'HISTORIADOR, HISTORIA POLITICA'),\r\n" + 
			"(2196,'HOJALATERO O CHAPISTA'),\r\n" + 
			"(2197,'HOJALDRISTA'),\r\n" + 
			"(2198,'HOMBRES DE LETRAS'),\r\n" + 
			"(2199,'HORCHATERO'),\r\n" + 
			"(2200,'HORMADOR DE BOINAS'),\r\n" + 
			"(2201,'HORMERO, ARMADOR DE CALZADO'),\r\n" + 
			"(2202,'HORNERO DE ALTO HORNO'),\r\n" + 
			"(2203,'HORNERO DE CONVERSION Y AFINACION DE METALES  NO FERREOS'),\r\n" + 
			"(2204,'HORNERO DE CONVERTIDOR BASSEMER'),\r\n" + 
			"(2205,'HORNERO DE HORNO THOMAS O ELKEM'),\r\n" + 
			"(2206,'HORNERO DE PAN'),\r\n" + 
			"(2207,'HORNERO DE SEGUNDA FUSION'),\r\n" + 
			"(2208,'HORNERO, COQUERIA'),\r\n" + 
			"(2209,'HORNERO, FABRICACION DE ELECTRODOS'),\r\n" + 
			"(2210,'HORNERO, HORNOS CALCINACION, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(2211,'HORNERO,BRIQUETAS'),\r\n" + 
			"(2212,'HORNERO,CERAMICA'),\r\n" + 
			"(2213,'HORNERO,FABRICACION DE VIDRIO'),\r\n" + 
			"(2214,'HORNERO,LOZA Y PORCELANA'),\r\n" + 
			"(2215,'HORNERO,MATERIAL REFRACTARIO EXCEPTO TEJAS Y LADRILLOS'),\r\n" + 
			"(2216,'HORNERO,PORCELANA'),\r\n" + 
			"(2217,'HORNERO,RECOCIDO DEL VIDRIO'),\r\n" + 
			"(2218,'HORNERO,TEJAS Y LADRILLOS'),\r\n" + 
			"(2219,'HORNERO,TEMPLADO DEL VIDRIO'),\r\n" + 
			"(2220,'HORTELANO'),\r\n" + 
			"(2221,'HORTICULTOR'),\r\n" + 
			"(2222,'HORTICULTOR, VIVEROS'),\r\n" + 
			"(2223,'HUECOGRABADORES'),\r\n" + 
			"(2224,'HUESERO'),\r\n" + 
			"(2225,'HUMECTADOR DE TABACO'),\r\n" + 
			"(2226,'ICTIOLOGO'),\r\n" + 
			"(2227,'IGUALADOR DE PELO,PIELES'),\r\n" + 
			"(2228,'ILUMINADOR DE LOZA Y PORCELANA'),\r\n" + 
			"(2229,'ILUSIONISTA'),\r\n" + 
			"(2230,'IMAGINERO'),\r\n" + 
			"(2231,'IMAN'),\r\n" + 
			"(2232,'IMITADOR'),\r\n" + 
			"(2233,'IMITADOR, CABARET'),\r\n" + 
			"(2234,'IMITADOR, RUIDOS DE ANIMALES'),\r\n" + 
			"(2235,'IMPERMEABILIZADOR DE PRODUCTOS TEXTILES'),\r\n" + 
			"(2236,'IMPONEDOR'),\r\n" + 
			"(2237,'IMPREGNADOR DE CAUCHO'),\r\n" + 
			"(2238,'IMPREGNADOR DE MADERA'),\r\n" + 
			"(2239,'IMPREGNADOR DE PRODUCTOS TEXTILES');", nativeQuery = true)
	void insertarOcupacion2();
	
		
	@Query(value="insert into ocupacion(id_ocupacion, descripcion) VALUES (2240,'IMPRESOR A LA PLANCHA,DE TELAS Y PAPELES PINTADOS'),"+ 
			"(2241,'IMPRESOR DE PAPELES'),\r\n" + 
			"(2242,'IMPRESOR DE PRUEBAS'),\r\n" + 
			"(2243,'IMPRESOR DE TELAS A MAQUINA'),\r\n" + 
			"(2244,'IMPRESOR EN GENERAL'),\r\n" + 
			"(2245,'IMPRESOR,SERICIGRAFIA'),\r\n" + 
			"(2246,'INGENIERO (NO CLASIFICADO EN OTRAS CLASIFICACIONES)'),\r\n" + 
			"(2247,'INGENIERO AGROINDUSTRIAL'),\r\n" + 
			"(2248,'INGENIERO AGRONOMO'),\r\n" + 
			"(2249,'INGENIERO BIOQUIMICO INDUSTRIAL'),\r\n" + 
			"(2250,'INGENIERO CIVIL'),\r\n" + 
			"(2251,'INGENIERO CIVIL, CONSTRUCCION'),\r\n" + 
			"(2252,'INGENIERO CIVIL, CONSTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(2253,'INGENIERO CIVIL, CONSTRUCCION/AERODROMOS'),\r\n" + 
			"(2254,'INGENIERO CIVIL, CONSTRUCCION/AEROPUERTOS'),\r\n" + 
			"(2255,'INGENIERO CIVIL, CONSTRUCCION/CALLES'),\r\n" + 
			"(2256,'INGENIERO CIVIL, CONSTRUCCION/CARRETERAS Y AUTOPISTAS'),\r\n" + 
			"(2257,'INGENIERO CIVIL, CONSTRUCCION/CHIMENEAS DE FABRICAS'),\r\n" + 
			"(2258,'INGENIERO CIVIL, CONSTRUCCION/EDIFICIOS Y/O VIVIENDAS'),\r\n" + 
			"(2259,'INGENIERO CIVIL, CONSTRUCCION/ESTRUCTURAS DE EDIFICIOS'),\r\n" + 
			"(2260,'INGENIERO CIVIL, CONSTRUCCION/ESTRUCTURAS METALICAS'),\r\n" + 
			"(2261,'INGENIERO CIVIL, CONSTRUCCION/INSTALACIONES PORTUARIAS'),\r\n" + 
			"(2262,'INGENIERO CIVIL, CONSTRUCCION/MUELLES Y PUERTOS'),\r\n" + 
			"(2263,'INGENIERO CIVIL, CONSTRUCCION/PUENTES'),\r\n" + 
			"(2264,'INGENIERO CIVIL, CONSTRUCCION/TORRES'),\r\n" + 
			"(2265,'INGENIERO CIVIL, CONSTRUCCION/TUNELES'),\r\n" + 
			"(2266,'INGENIERO CIVIL, CONSTRUCCION/VIAS FERREAS'),\r\n" + 
			"(2267,'INGENIERO CIVIL, CONTRATISTAS DE OBRAS'),\r\n" + 
			"(2268,'INGENIERO CIVIL, INSPECTOR DE OBRAS'),\r\n" + 
			"(2269,'INGENIERO CIVIL, IRRIGACION'),\r\n" + 
			"(2270,'INGENIERO CIVIL, MECANICA/SUELOS'),\r\n" + 
			"(2271,'INGENIERO CIVIL, TRABAJOS MARITIMOS'),\r\n" + 
			"(2272,'INGENIERO CONSULTOR, ORGANIZACION INDUSTRIAL'),\r\n" + 
			"(2273,'INGENIERO DE CALCULADORAS ELECTRONICAS'),\r\n" + 
			"(2274,'INGENIERO DE CONTROLES INDUSTRIALES Y ELECTRONICA'),\r\n" + 
			"(2275,'INGENIERO DE MINAS, OTROS'),\r\n" + 
			"(2276,'INGENIERO DE ORDENADORES ELECTRONICOS'),\r\n" + 
			"(2277,'INGENIERO EDAFOLOGO'),\r\n" + 
			"(2278,'INGENIERO ELECTRICISTA'),\r\n" + 
			"(2279,'INGENIERO ELECTRICISTA, ALTO VOLTAJE'),\r\n" + 
			"(2280,'INGENIERO ELECTRICISTA, EQUIPO ELECTROMECANICO'),\r\n" + 
			"(2281,'INGENIERO ELECTRICISTA, EQUIPO ELECTROMECANICO DE BAJA POTE'),\r\n" + 
			"(2282,'INGENIERO ELECTRICISTA, ILUMINACION'),\r\n" + 
			"(2283,'INGENIERO ELECTRICISTA, LINEAS ELECTRICAS'),\r\n" + 
			"(2284,'INGENIERO ELECTRICISTA, PRODUCCION DE ENERGIA'),\r\n" + 
			"(2285,'INGENIERO ELECTRICISTA, PRODUCCION DE ENERGIA ELECTRICA'),\r\n" + 
			"(2286,'INGENIERO ELECTRICISTA, TRACCION ELECTRICA'),\r\n" + 
			"(2287,'INGENIERO ELECTRICISTA, TRANSPORTE DE CORRIENTE ELECTRICA'),\r\n" + 
			"(2288,'INGENIERO ELECTRICISTA, TRANSPORTE Y DISTRIBUCION ENERGIA'),\r\n" + 
			"(2289,'INGENIERO ELECTRONICO'),\r\n" + 
			"(2290,'INGENIERO ELECTRONICO, CONSTRUCCION DE COMPUTADORAS'),\r\n" + 
			"(2291,'INGENIERO ELECTRONICO, SEMICONDUCTORES'),\r\n" + 
			"(2292,'INGENIERO FORESTAL'),\r\n" + 
			"(2293,'INGENIERO INDUSTRIAL'),\r\n" + 
			"(2294,'INGENIERO INDUSTRIAL, HIGIENE Y SEGURIDAD INDUSTRIAL'),\r\n" + 
			"(2295,'INGENIERO MECANICO'),\r\n" + 
			"(2296,'INGENIERO MECANICO Y ELECTRICISTA'),\r\n" + 
			"(2297,'INGENIERO MECANICO, AERONAUTICA'),\r\n" + 
			"(2298,'INGENIERO MECANICO, AGRICULTURA (ING. AGRICOLA)'),\r\n" + 
			"(2299,'INGENIERO MECANICO, AUTOMOTORES'),\r\n" + 
			"(2300,'INGENIERO MECANICO, AUTOMOVILES'),\r\n" + 
			"(2301,'INGENIERO MECANICO, CALEFACCION, VENTILACION Y REFRIGERACIO'),\r\n" + 
			"(2302,'INGENIERO MECANICO, CLIMATIZACION'),\r\n" + 
			"(2303,'INGENIERO MECANICO, CONSTRUCCION NAVAL'),\r\n" + 
			"(2304,'INGENIERO MECANICO, DE FLUIDOS'),\r\n" + 
			"(2305,'INGENIERO MECANICO, ENERGIA NUCLEAR'),\r\n" + 
			"(2306,'INGENIERO MECANICO, MAQUINARIA Y HERRAMIENTAS INDUSTRIALES'),\r\n" + 
			"(2307,'INGENIERO MECANICO, MOTORES A REACCION'),\r\n" + 
			"(2308,'INGENIERO MECANICO, MOTORES DE COMBUSTION INTERNA'),\r\n" + 
			"(2309,'INGENIERO MECANICO, MOTORES DIESEL Y/O PROPULSION A CHORRO'),\r\n" + 
			"(2310,'INGENIERO MECANICO, MOTORES MARINOS'),\r\n" + 
			"(2311,'INGENIERO MECANICO, MOTORES/EQUIPO PARA BARCOS'),\r\n" + 
			"(2312,'INGENIERO MECANICO, MOTORES/EXCEPTO LOS MARINOS'),\r\n" + 
			"(2313,'INGENIERO MECANICO, MOTORES/LOCOMOTORAS A VAPOR'),\r\n" + 
			"(2314,'INGENIERO MECANICO, TURBINAS DE GAS'),\r\n" + 
			"(2315,'INGENIERO METALURGICO'),\r\n" + 
			"(2316,'INGENIERO METALURGICO, MINERALES RADIACTIVOS Y FUNDICION'),\r\n" + 
			"(2317,'INGENIERO METALURGICO, PRODUCCION Y AFINO/METALES'),\r\n" + 
			"(2318,'INGENIERO METALURGICO, TRATAMIENTO DE LOS METALES'),\r\n" + 
			"(2319,'INGENIERO PESQUERO'),\r\n" + 
			"(2320,'INGENIERO QUIMICO EN INDUSTRIA QUIMICA'),\r\n" + 
			"(2321,'INGENIERO QUIMICO, ALIMENTOS Y BEBIDAS'),\r\n" + 
			"(2322,'INGENIERO QUIMICO, ANTIBIOTICOS'),\r\n" + 
			"(2323,'INGENIERO QUIMICO, CARBURANTES/REFINERIA DE PETROLEO'),\r\n" + 
			"(2324,'INGENIERO QUIMICO, CAUCHO'),\r\n" + 
			"(2325,'INGENIERO QUIMICO, COLORES Y PINTURAS'),\r\n" + 
			"(2326,'INGENIERO QUIMICO, EXPLOSIVOS'),\r\n" + 
			"(2327,'INGENIERO QUIMICO, FABRICACION'),\r\n" + 
			"(2328,'INGENIERO QUIMICO, FIBRAS TEXTILES (ING. TEXTIL)'),\r\n" + 
			"(2329,'INGENIERO QUIMICO, GAS/PRODUCCION Y DISTRIBUCION'),\r\n" + 
			"(2330,'INGENIERO QUIMICO, MATERIAL PLASTICO'),\r\n" + 
			"(2331,'INGENIERO QUIMICO, OTROS'),\r\n" + 
			"(2332,'INGENIERO QUIMICO, PAPEL'),\r\n" + 
			"(2333,'INGENIERO QUIMICO, PERFUMISTA'),\r\n" + 
			"(2334,'INGENIERO QUIMICO, PETROLEO Y GAS NATURAL'),\r\n" + 
			"(2335,'INGENIERO QUIMICO, TECNOLOGIA DE LOS COMBUSTIBLES'),\r\n" + 
			"(2336,'INGENIERO TELECOMUNICACIONES'),\r\n" + 
			"(2337,'INGENIERO TELECOMUNICACIONES/RADAR'),\r\n" + 
			"(2338,'INGENIERO TELECOMUNICACIONES/RADIO'),\r\n" + 
			"(2339,'INGENIERO TELECOMUNICACIONES/SISTEMAS DE SEÐALES'),\r\n" + 
			"(2340,'INGENIERO TELECOMUNICACIONES/TELEFONOS'),\r\n" + 
			"(2341,'INGENIERO TELECOMUNICACIONES/TELEGRAFOS'),\r\n" + 
			"(2342,'INGENIERO TELECOMUNICACIONES/TELEVISION'),\r\n" + 
			"(2343,'INGENIERO, ADMINISTRATIVO'),\r\n" + 
			"(2344,'INGENIERO, APLICACIONES DE LA INFORMATICA'),\r\n" + 
			"(2345,'INGENIERO, CALEFACCION, VENTILACION Y REFRIGERACION'),\r\n" + 
			"(2346,'INGENIERO, CANALES Y PUERTOS'),\r\n" + 
			"(2347,'INGENIERO, CERAMICA Y VIDRIOS'),\r\n" + 
			"(2348,'INGENIERO, CLIMATIZACION'),\r\n" + 
			"(2349,'INGENIERO, CONSTRUCCION AERONAUTICA'),\r\n" + 
			"(2350,'INGENIERO, CONSTRUCCION DE AUTOMOVILES'),\r\n" + 
			"(2351,'INGENIERO, CONSTRUCCION NAVAL'),\r\n" + 
			"(2352,'INGENIERO, CONTROL DE CALIDAD'),\r\n" + 
			"(2353,'INGENIERO, CUERO Y CALZADO'),\r\n" + 
			"(2354,'INGENIERO, DE TRANSPORTE'),\r\n" + 
			"(2355,'INGENIERO, DE VUELO'),\r\n" + 
			"(2356,'INGENIERO, ESTADISTICO'),\r\n" + 
			"(2357,'INGENIERO, FRIO INDUSTRIAL'),\r\n" + 
			"(2358,'INGENIERO, HIDRAULICO'),\r\n" + 
			"(2359,'INGENIERO, HIDROLOGIA'),\r\n" + 
			"(2360,'INGENIERO, INDUSTRIAS ALIMENTARIAS'),\r\n" + 
			"(2361,'INGENIERO, INDUSTRIAS DE PAPEL'),\r\n" + 
			"(2362,'INGENIERO, IRRIGACION'),\r\n" + 
			"(2363,'INGENIERO, MAQUINARIA Y HERRAMIENTAS INDUSTRIALES'),\r\n" + 
			"(2364,'INGENIERO, MEDIO AMBIENTE'),\r\n" + 
			"(2365,'INGENIERO, METALURGICO/OTROS'),\r\n" + 
			"(2366,'INGENIERO, MINAS'),\r\n" + 
			"(2367,'INGENIERO, MINAS/CARBON'),\r\n" + 
			"(2368,'INGENIERO, MINAS/MINERALES METALICOS'),\r\n" + 
			"(2369,'INGENIERO, MINAS/MINERALES NO METALICOS'),\r\n" + 
			"(2370,'INGENIERO, MINAS/PETROLEO Y GAS NATURAL'),\r\n" + 
			"(2371,'INGENIERO, ORGANIZACION CALCULO DE COSTOS'),\r\n" + 
			"(2372,'INGENIERO, ORGANIZACION DE ESTUDIO DE TIEMPOS Y MOVIMIENTOS'),\r\n" + 
			"(2373,'INGENIERO, ORGANIZACION INDUSTRIAL'),\r\n" + 
			"(2374,'INGENIERO, ORGANIZACION Y METODOS'),\r\n" + 
			"(2375,'INGENIERO, ORGANIZACION Y PLANIFICACION DE EMPRESAS'),\r\n" + 
			"(2376,'INGENIERO, PERFORACION/POZOS DE PETROLEO Y DE GAS'),\r\n" + 
			"(2377,'INGENIERO, PETROQUIMICO'),\r\n" + 
			"(2378,'INGENIERO, PLANIFICADOR DE TRAFICO'),\r\n" + 
			"(2379,'INGENIERO, PRODUCCION'),\r\n" + 
			"(2380,'INGENIERO, SANITARIO'),\r\n" + 
			"(2381,'INGENIERO, SIDERURGICO'),\r\n" + 
			"(2382,'INGENIERO, SISTEMAS INFORMATICOS'),\r\n" + 
			"(2383,'INGENIERO, SISTEMAS/EXCEPTO INFORMATICOS'),\r\n" + 
			"(2384,'INGENIERO, TOPOGRAFO'),\r\n" + 
			"(2385,'INJERTADOR'),\r\n" + 
			"(2386,'INJERTADOR DE ARBOLES FRUTALES (OBRERO)'),\r\n" + 
			"(2387,'INSEMINADOR (OBRERO)'),\r\n" + 
			"(2388,'INSEMINADOR, AVES'),\r\n" + 
			"(2389,'INSEMINADOR, GANADO'),\r\n" + 
			"(2390,'INSOLADOR DE FOTOGRABADO'),\r\n" + 
			"(2391,'INSPECTOR CALIDAD APARAT. ELECTRIC. Y ELECTRONICOS'),\r\n" + 
			"(2392,'INSPECTOR CONTROL CALIDAD, EQUIPO. ELECTRIC. Y ELECTRONICOS'),\r\n" + 
			"(2393,'INSPECTOR DE DISTINTIVO DE CALIDAD'),\r\n" + 
			"(2394,'INSPECTOR JEFE, COMERCIO AL POR MAYOR'),\r\n" + 
			"(2395,'INSPECTOR JEFE, COMERCIO AL POR MENOR'),\r\n" + 
			"(2396,'INSPECTOR TECNICO, MARINA/MERCANTE'),\r\n" + 
			"(2397,'INSPECTOR TECNICO, VENTAS'),\r\n" + 
			"(2398,'INSPECTOR, CONTROL DE CALIDAD'),\r\n" + 
			"(2399,'INSPECTOR, CONTROL DE CALIDAD/ELECTRICIDAD'),\r\n" + 
			"(2400,'INSPECTOR, CONTROL DE CALIDAD/EQUIPOS ELECTRICOS'),\r\n" + 
			"(2401,'INSPECTOR, CONTROL DE CALIDAD/EQUIPOS ELECTRONICOS'),\r\n" + 
			"(2402,'INSPECTOR, CONTROL DE CALIDAD/MAQUINAS'),\r\n" + 
			"(2403,'INSPECTOR, CONTROL DE CALIDAD/PROCESOS INDUSTRIALES'),\r\n" + 
			"(2404,'INSPECTOR, CONTROL DE CALIDAD/PRODUCTOS MECANICOS'),\r\n" + 
			"(2405,'INSPECTOR, CONTROL DE CALIDAD/SERVICIOS'),\r\n" + 
			"(2406,'INSPECTOR, CONTROL DE CALIDAD/TEJIDOS'),\r\n" + 
			"(2407,'INSPECTOR, ESCUELAS'),\r\n" + 
			"(2408,'INSPECTOR, HACIENDA'),\r\n" + 
			"(2409,'INSPECTOR, INCENDIOS'),\r\n" + 
			"(2410,'INSPECTOR, OBRAS Y EDIFICIOS'),\r\n" + 
			"(2411,'INSPECTOR, PASAPORTES'),\r\n" + 
			"(2412,'INSPECTOR, POLICIA DE FRONTERAS'),\r\n" + 
			"(2413,'INSPECTOR, SANIDAD'),\r\n" + 
			"(2414,'INSPECTOR, SEGURIDAD Y SALUD'),\r\n" + 
			"(2415,'INSPECTOR, SEGURIDAD Y SALUD/CONTAMINACION DEL MEDIO AMBIEN'),\r\n" + 
			"(2416,'INSPECTOR, SEGURIDAD Y SALUD/CUIDADOS A LOS NIÐOS'),\r\n" + 
			"(2417,'INSPECTOR, SEGURIDAD Y SALUD/ELECTRICIDAD'),\r\n" + 
			"(2418,'INSPECTOR, SEGURIDAD Y SALUD/ESTABLECIMIENTOS'),\r\n" + 
			"(2419,'INSPECTOR, SEGURIDAD Y SALUD/FABRICA'),\r\n" + 
			"(2420,'INSPECTOR, SEGURIDAD Y SALUD/PROTECCION DE LOS CONSUMIDORES'),\r\n" + 
			"(2421,'INSPECTOR, SEGURIDAD Y SALUD/SEGURIDAD INDUSTRIAL'),\r\n" + 
			"(2422,'INSPECTOR, SEGURIDAD Y SALUD/TIENDAS Y COMERCIOS'),\r\n" + 
			"(2423,'INSPECTOR, SEGURIDAD Y SALUD/TRABAJO'),\r\n" + 
			"(2424,'INSPECTOR, SEGURIDAD Y SALUD/TRATAMIENTO DE DESECHOS INDUSTRIALES'),\r\n" + 
			"(2425,'INSPECTOR, SEGURIDAD Y SALUD/VEHICULOS'),\r\n" + 
			"(2426,'INSPECTOR, SEGURIDAD/PRODUCTOS'),\r\n" + 
			"(2427,'INSPECTOR, SERVICIOS/BARCAZA'),\r\n" + 
			"(2428,'INSPECTOR, SERVICIOS/CARGA'),\r\n" + 
			"(2429,'INSPECTOR, SERVICIOS/TRANSPORTE POR CARRETERA'),\r\n" + 
			"(2430,'INSPECTOR, SERVICIOS/TRANSPORTE POR FERROCARRIL'),\r\n" + 
			"(2431,'INSPECTOR, SINIESTROS'),\r\n" + 
			"(2432,'INSPECTOR, VEHICULOS/ESPECIFICACIONES TECNICAS'),\r\n" + 
			"(2433,'INSTALADOR CABLES PARA LA ELECTRIFICACION FERROCARRILES'),\r\n" + 
			"(2434,'INSTALADOR CABLES PARA TRACCION VEHICULOS ELECT.'),\r\n" + 
			"(2435,'INSTALADOR DE ANTENAS DE RADIO Y TELEVISION'),\r\n" + 
			"(2436,'INSTALADOR DE CABLES'),\r\n" + 
			"(2437,'INSTALADOR DE CABLES DE ENERGIA ELECTRICA'),\r\n" + 
			"(2438,'INSTALADOR DE CABLES DE TELEFONOS Y TELEGRAFOS'),\r\n" + 
			"(2439,'INSTALADOR DE LINEAS DE TELECOMUNICACIONES'),\r\n" + 
			"(2440,'INSTALADOR DE LINEAS ELECTRICAS PARA TRACCION'),\r\n" + 
			"(2441,'INSTALADOR DE LINEAS SUBTERRANEOS'),\r\n" + 
			"(2442,'INSTALADOR DE MATER.AISLANTE,EN EDIFIC,DE INSONORIZACION'),\r\n" + 
			"(2443,'INSTALADOR DE MATERIAL DE INSONORIZACION'),\r\n" + 
			"(2444,'INSTALADOR DE TELEFONOS Y TELEGRAFOS'),\r\n" + 
			"(2445,'INSTALADOR ELECTRICISTA,ASCENSORES Y EQUIPO SIMILAR'),\r\n" + 
			"(2446,'INSTALADOR LINEAS ELECTRICAS Y TELECOMUNICACIONES'),\r\n" + 
			"(2447,'INSTALADOR LINEAS ENERGIA ELECTRICA, TENDIDO AEREO'),\r\n" + 
			"(2448,'INSTALADOR TUBERIAS,EN GRAL,GAS,BARCOS,AVIONES'),\r\n" + 
			"(2449,'INSTITUTRIZ'),\r\n" + 
			"(2450,'INSTRUCTOR DE MANEJO DE APARATOS ELECTRICOS, ELECTRONICOS,'),\r\n" + 
			"(2451,'INSTRUCTOR DE VUELO'),\r\n" + 
			"(2452,'INSTRUCTOR NAVEGACION/VELA'),\r\n" + 
			"(2453,'INSTRUMENTISTA'),\r\n" + 
			"(2454,'INSTRUMENTISTA, INSTRUMENTOS DE PRECISION'),\r\n" + 
			"(2455,'INTENDENTE GENERAL DE LA ADMINISTRACION PUBLICA'),\r\n" + 
			"(2456,'INTERPRETE'),\r\n" + 
			"(2457,'INTERVENTOR GENERAL DE ECONOMIA DE LA ADMINISTRACION PUBLIC'),\r\n" + 
			"(2458,'INTERVENTOR, CUENTAS'),\r\n" + 
			"(2459,'INVESTIGADOR, INCENDIOS'),\r\n" + 
			"(2460,'IONADO, EQUIPOS DE REGRIGERACION, ETC.'),\r\n" + 
			"(2461,'JARDINERO'),\r\n" + 
			"(2462,'JARDINERO (OBRERO)'),\r\n" + 
			"(2463,'JARDINERO, SEMILLERO'),\r\n" + 
			"(2464,'JARDINERO, VIVEROS'),\r\n" + 
			"(2465,'JEFE DE ABASTECIMIENTO'),\r\n" + 
			"(2466,'JEFE DE ALMACEN'),\r\n" + 
			"(2467,'JEFE DE ARCHIVO Y CORRESPONDENCIA'),\r\n" + 
			"(2468,'JEFE DE BIENESTAR SOCIAL'),\r\n" + 
			"(2469,'JEFE DE CAMAREROS'),\r\n" + 
			"(2470,'JEFE DE CUADRA'),\r\n" + 
			"(2471,'JEFE DE DIQUE O VARADERO'),\r\n" + 
			"(2472,'JEFE DE EMPLEADOS DE OFICINA, OTROS'),\r\n" + 
			"(2473,'JEFE DE ESCALA DE TRANSPORTE AEREO'),\r\n" + 
			"(2474,'JEFE DE ESTACION DE FERROCARRIL'),\r\n" + 
			"(2475,'JEFE DE MAQUINARIA AGRICOLA'),\r\n" + 
			"(2476,'JEFE DE MAQUINAS, BARCO'),\r\n" + 
			"(2477,'JEFE DE MOVIMIENTO DE TRENES'),\r\n" + 
			"(2478,'JEFE DE OFICINA DE CORREO'),\r\n" + 
			"(2479,'JEFE DE OPERACIONES DE VUELO TRANSPORTE AEREO'),\r\n" + 
			"(2480,'JEFE DE ORGANISMO DE DESARROLLO'),\r\n" + 
			"(2481,'JEFE DE ORGANISMO PUBLICO'),\r\n" + 
			"(2482,'JEFE DE PERSONAL ADMINISTRATIVO'),\r\n" + 
			"(2483,'JEFE DE PERSONAL DE SERVIDUMBRE, BARCO'),\r\n" + 
			"(2484,'JEFE DE PUEBLO'),\r\n" + 
			"(2485,'JEFE DE PUERTO.DIQUE SECO'),\r\n" + 
			"(2486,'JEFE DE REDACCION/DIARIO'),\r\n" + 
			"(2487,'JEFE DE REDACCION/REVISTA'),\r\n" + 
			"(2488,'JEFE DE REGISTROS PUBLICOS'),\r\n" + 
			"(2489,'JEFE DE SERVICIOS DE CORREO'),\r\n" + 
			"(2490,'JEFE DE SERVICIOS DE POSTALES'),\r\n" + 
			"(2491,'JEFE DE SERVICIOS DE TELECOMUNICACIONES'),\r\n" + 
			"(2492,'JEFE DE SERVICIOS DE TRANSPORTE POR CARRETERA'),\r\n" + 
			"(2493,'JEFE DE TRAFICO, FERROCARRILES'),\r\n" + 
			"(2494,'JEFE DE TREN DE MERCANCIAS'),\r\n" + 
			"(2495,'JEFE DE TREN DE PASAJEROS'),\r\n" + 
			"(2496,'JEFE TRADICIONAL, PEQUEÐA POBLACION'),\r\n" + 
			"(2497,'JOCKEY'),\r\n" + 
			"(2498,'JORNALERO AGRICOLA'),\r\n" + 
			"(2499,'JUECES NO LETRADOS'),\r\n" + 
			"(2500,'JUEZ'),\r\n" + 
			"(2501,'JUEZ CIVIL'),\r\n" + 
			"(2502,'JUEZ DE LA CORTE SUPERIOR'),\r\n" + 
			"(2503,'JUEZ DE LA CORTE SUPREMA'),\r\n" + 
			"(2504,'JUEZ DE PAZ LETRADO'),\r\n" + 
			"(2505,'JUEZ INSTRUCTOR'),\r\n" + 
			"(2506,'JUEZ SIN ROSTRO'),\r\n" + 
			"(2507,'JUEZ, BOXEO'),\r\n" + 
			"(2508,'JUEZ, CANCHA'),\r\n" + 
			"(2509,'JUEZ, PENAL'),\r\n" + 
			"(2510,'JUEZ, PRIMERA INSTANCIA/TIERRAS, MENORES, OTROS'),\r\n" + 
			"(2511,'JUEZ, SALIDA/CARRERAS'),\r\n" + 
			"(2512,'JUEZ, TRABAJO'),\r\n" + 
			"(2513,'KINESITERAPEUTA (KINESIOLOGOS)'),\r\n" + 
			"(2514,'LAGARERO, VINOS'),\r\n" + 
			"(2515,'LAMINADOR DE ACERO EN CALIENTE'),\r\n" + 
			"(2516,'LAMINADOR DE ACERO EN FRIO'),\r\n" + 
			"(2517,'LAMINADOR DE ACERO EN TREN CONTINUO'),\r\n" + 
			"(2518,'LAMINADOR DE CHOCOLATES'),\r\n" + 
			"(2519,'LAMINADOR DE GALLETAS'),\r\n" + 
			"(2520,'LAMINADOR DE LUNAS DE VIDRIO'),\r\n" + 
			"(2521,'LAMINADOR DE METALES NO FERREOS'),\r\n" + 
			"(2522,'LAMINADOR DE METALES PRECIOSOS'),\r\n" + 
			"(2523,'LAMINADOR DE PRODUCTOS SEMIACABADOS DE ACERO'),\r\n" + 
			"(2524,'LAMINADOR DE TUBOS SIN SOLDADURA'),\r\n" + 
			"(2525,'LAMINADOR DE VENA,TABACO'),\r\n" + 
			"(2526,'LANCHERO'),\r\n" + 
			"(2527,'LANGOSTERO'),\r\n" + 
			"(2528,'LAPIDARIO, TALLADOR Y PULIDOR DE PIEDRAS PRECIOSAS'),\r\n" + 
			"(2529,'LAQUEADOR DE MUEBLES DE MADERA'),\r\n" + 
			"(2530,'LAQUEADOR,EXCEPTO CONSTRUCCION'),\r\n" + 
			"(2531,'LARVERO'),\r\n" + 
			"(2532,'LAVADOR AMBULANTE DE AUTOS'),\r\n" + 
			"(2533,'LAVADOR DE CUEROS'),\r\n" + 
			"(2534,'LAVADOR DE HILADOS Y PRODUCTOS TEXTILES'),\r\n" + 
			"(2535,'LAVADOR DE LANA'),\r\n" + 
			"(2536,'LAVADOR DE MATERIAS QUIMICAS'),\r\n" + 
			"(2537,'LAVADOR DE MINERALES'),\r\n" + 
			"(2538,'LAVADOR DE ORO'),\r\n" + 
			"(2539,'LAVADOR DE PASTA,SIDRA'),\r\n" + 
			"(2540,'LAVADOR, ARTICULOS TEXTILES/A MANO'),\r\n" + 
			"(2541,'LAVADOR, CUEROS Y PIELES/A MANO'),\r\n" + 
			"(2542,'LAVADOR, RESES/CARNICERIA(A MANO)'),\r\n" + 
			"(2543,'LAVADOR, TALLER DE FABRICACION/A MANO'),\r\n" + 
			"(2544,'LAVANDERO'),\r\n" + 
			"(2545,'LAVANDERO, A MANO/LAVANDERIA'),\r\n" + 
			"(2546,'LAVAPISOS'),\r\n" + 
			"(2547,'LAVAPLATOS DE: CANTINA, HOTEL, RESTAURANTE'),\r\n" + 
			"(2548,'LECHE CONDENSADA, PREPARADOR'),\r\n" + 
			"(2549,'LECTOR DE MEDIDORES'),\r\n" + 
			"(2550,'LECTOR, RADIO O TELEVISION'),\r\n" + 
			"(2551,'LEÑADOR'),\r\n" + 
			"(2552,'LEGISLADOR'),\r\n" + 
			"(2553,'LEJIADOR, PASTA PARA PAPEL'),\r\n" + 
			"(2554,'LEXICOGRAFO'),\r\n" + 
			"(2555,'LIBRETISTA'),\r\n" + 
			"(2556,'LICORISTA, DESTILACION'),\r\n" + 
			"(2557,'LIGADOR DE TABACO'),\r\n" + 
			"(2558,'LIJADOR DE CANTOS, CALZADO'),\r\n" + 
			"(2559,'LIMPIABARROS'),\r\n" + 
			"(2560,'LIMPIABOTAS'),\r\n" + 
			"(2561,'LIMPIADOR DE CAMARONES'),\r\n" + 
			"(2562,'LIMPIADOR DE FRUTAS Y HORTALIZAS,PARA CONSERVAS'),\r\n" + 
			"(2563,'LIMPIADOR DE MAQUINAS.BARCOS'),\r\n" + 
			"(2564,'LIMPIADOR DE METALES'),\r\n" + 
			"(2565,'LIMPIADOR DE METALES POR ONDAS ULTRASONICAS'),\r\n" + 
			"(2566,'LIMPIADOR DE PEJERREYES Y OTROS PESCADOS'),\r\n" + 
			"(2567,'LIMPIADOR DE VENTANAS'),\r\n" + 
			"(2568,'LIMPIADOR DE: FABRICAS, HOTELES, OFICINAS Y RESTAURANTES'),\r\n" + 
			"(2569,'LIMPIADOR POR CHORRO DE ARENA, METALES'),\r\n" + 
			"(2570,'LIMPIADOR, EN SECO/A MANO'),\r\n" + 
			"(2571,'LINGUISTA'),\r\n" + 
			"(2572,'LINOTIPISTA'),\r\n" + 
			"(2573,'LIQUIDADOR, RECLAMACIONES/SEGUROS'),\r\n" + 
			"(2574,'LISTERO'),\r\n" + 
			"(2575,'LISTONERO'),\r\n" + 
			"(2576,'LITERATO'),\r\n" + 
			"(2577,'LLAVERERO'),\r\n" + 
			"(2578,'LLENADO O ENVASADOR DE PRODUCTOS'),\r\n" + 
			"(2579,'LOCUTOR, NOTICIAS'),\r\n" + 
			"(2580,'LOCUTOR, RADIO'),\r\n" + 
			"(2581,'LOCUTOR, TELEVISION'),\r\n" + 
			"(2582,'LOSETERO FABRICACION DE LOCETAS Y MOSAICOS'),\r\n" + 
			"(2583,'LUCHADOR'),\r\n" + 
			"(2584,'LUMINOTECNICO, TELEVISION'),\r\n" + 
			"(2585,'LUSTRABOTAS'),\r\n" + 
			"(2586,'LUSTRADOR DE CAUCHO'),\r\n" + 
			"(2587,'LUSTRADOR DE CUEROS'),\r\n" + 
			"(2588,'MACERADOR DE REMOLACHA'),\r\n" + 
			"(2589,'MACHACADOR, TRITURADOR, MINERALES'),\r\n" + 
			"(2590,'MACHERO A MANO'),\r\n" + 
			"(2591,'MACHERO A MAQUINA'),\r\n" + 
			"(2592,'MACHERO-MOLDEADOR,CERAMICA'),\r\n" + 
			"(2593,'MAESTRESALA'),\r\n" + 
			"(2594,'MAESTRO DE AGUJA Y MESA,SASTRE'),\r\n" + 
			"(2595,'MAESTRO DE BALLET'),\r\n" + 
			"(2596,'MAESTRO DE ENSEÑANZA PRIMARIA'),\r\n" + 
			"(2597,'MAESTRO DE ESCUELA'),\r\n" + 
			"(2598,'MAESTRO DE OBRAS EN GENERAL'),\r\n" + 
			"(2599,'MAGO'),\r\n" + 
			"(2600,'MAITRE'),\r\n" + 
			"(2601,'MALABARISTA'),\r\n" + 
			"(2602,'MALETERO, CUERO O MARROQUIN'),\r\n" + 
			"(2603,'MALETERO, HOTEL'),\r\n" + 
			"(2604,'MALLERO'),\r\n" + 
			"(2605,'MALTERO, GERMINACION'),\r\n" + 
			"(2606,'MAMPOSTERO'),\r\n" + 
			"(2607,'MANDADERO'),\r\n" + 
			"(2608,'MANDADERO, OFICINA/CONSERJE DE OFICINA'),\r\n" + 
			"(2609,'MANDRILADOR'),\r\n" + 
			"(2610,'MANDRILERO'),\r\n" + 
			"(2611,'MANGUITERO O PELETERO'),\r\n" + 
			"(2612,'MANICURISTA'),\r\n" + 
			"(2613,'MANIOBRISTA DE BARCO'),\r\n" + 
			"(2614,'MANIOBRISTA DE MUELLE'),\r\n" + 
			"(2615,'MANIOBRISTA, MINAS'),\r\n" + 
			"(2616,'MANIPULADOR, ALMACENES FRIGORIFICOS'),\r\n" + 
			"(2617,'MANIPULADOR, CARGA'),\r\n" + 
			"(2618,'MANIPULADOR, CARNE'),\r\n" + 
			"(2619,'MANIPULADOR, FRUTA'),\r\n" + 
			"(2620,'MANIPULADOR, GRANDES ALMACENES'),\r\n" + 
			"(2621,'MANIPULADOR, MERCADO DE ALIMENTOS'),\r\n" + 
			"(2622,'MANIPULADOR, MERCANCIAS'),\r\n" + 
			"(2623,'MANIPULADOR, PESCADO'),\r\n" + 
			"(2624,'MANIPULADOR, TIENDA'),\r\n" + 
			"(2625,'MANIQUI'),\r\n" + 
			"(2626,'MANTEQUERO (MANTECA)'),\r\n" + 
			"(2627,'MANTEQUILLERO O MAZADOR'),\r\n" + 
			"(2628,'MANUARERA'),\r\n" + 
			"(2629,'MAQUETISTA'),\r\n" + 
			"(2630,'MAQUETISTA EN MADERA'),\r\n" + 
			"(2631,'MAQUILLADOR, CINE'),\r\n" + 
			"(2632,'MAQUILLADOR, SALON'),\r\n" + 
			"(2633,'MAQUILLADOR, TEATRO'),\r\n" + 
			"(2634,'MAQUINISTA DE EXTRACCION,MINAS'),\r\n" + 
			"(2635,'MAQUINISTA DE FOTO-COMPOSICION'),\r\n" + 
			"(2636,'MAQUINISTA DE OFFSET'),\r\n" + 
			"(2637,'MAQUINISTA DE ROTATIVA A COLORES,IMPRENTA'),\r\n" + 
			"(2638,'MAQUINISTA DE TORRE GRUA'),\r\n" + 
			"(2639,'MAQUINISTA DE TREN DE LAMINACION'),\r\n" + 
			"(2640,'MAQUINISTA DE TREN DE MINA O CANTERA'),\r\n" + 
			"(2641,'MAQUINISTA DE TREN O LOCOMOTORA'),\r\n" + 
			"(2642,'MAQUINISTA EN LA FABRICACION DE CABLES'),\r\n" + 
			"(2643,'MAQUINISTA PLATINERO'),\r\n" + 
			"(2644,'MAQUINISTAS DE MAQUINAS FIJAS N.E.O.P'),\r\n" + 
			"(2645,'MAQUINISTAS DE PUENTE GIRATORIO'),\r\n" + 
			"(2646,'MARCADOR, ARBOLES'),\r\n" + 
			"(2647,'MARCADOR, INTRODUC. HOJAS EN MAQ. DE IMPRIMIR'),\r\n" + 
			"(2648,'MARINA, OFICIALES'),\r\n" + 
			"(2649,'MARINA, PERSONAL DE SERVICIO MILITAR'),\r\n" + 
			"(2650,'MARINA, SUB OFICIALES'),\r\n" + 
			"(2651,'MARINA, TECNICOS'),\r\n" + 
			"(2652,'MARINERO EN GRAL, DE PRIMERA,SGDA,DE REMOLCADOR DE YATE,DE'),\r\n" + 
			"(2653,'MARINERO(MARINERO MERCANTE)'),\r\n" + 
			"(2654,'MARISCADOR/MARISQUERO'),\r\n" + 
			"(2655,'MARMOLISTA, CONSTRUCCION'),\r\n" + 
			"(2656,'MARRONERO (OBRERO)'),\r\n" + 
			"(2657,'MARROQUINERO, FABRICACION DE ARTICULOS DE CUERO'),\r\n" + 
			"(2658,'MARTILLADOR DE METALES PRECIOSOS'),\r\n" + 
			"(2659,'MARTILLADOR-HERRERIA'),\r\n" + 
			"(2660,'MARTILLERO, SUBASTAS PUBLICAS'),\r\n" + 
			"(2661,'MASAJISTA'),\r\n" + 
			"(2662,'MASAJISTA ESTETICO'),\r\n" + 
			"(2663,'MATANCERO'),\r\n" + 
			"(2664,'MATANCERO EN GENERAL'),\r\n" + 
			"(2665,'MATARIFE'),\r\n" + 
			"(2666,'MATEMATICO, ANALISIS ACTUARIAL'),\r\n" + 
			"(2667,'MATEMATICO, MATEMATICA APLICADA'),\r\n" + 
			"(2668,'MATEMATICO, MATEMATICA PURA'),\r\n" + 
			"(2669,'MATEMATICO-ANALISTA, INVESTIGACION OPERATIVA'),\r\n" + 
			"(2670,'MATRICEROS, IMPRENTA'),\r\n" + 
			"(2671,'MATRONA (PARTERA PRACTICA)'),\r\n" + 
			"(2672,'MAYORDOMO, EXCEPTO HOGAR PARTICULAR'),\r\n" + 
			"(2673,'MAYORDOMO, HOGAR PARTICULAR'),\r\n" + 
			"(2674,'MAYORISTA, COMERCIO AL POR MAYOR'),\r\n" + 
			"(2675,'MAZAPAN, CONFECCIONADOR'),\r\n" + 
			"(2676,'MECANICO AUTOMOVILES, CAMIONES, MOTOCICLETAS, AUTOBUS, TRAC'),\r\n" + 
			"(2677,'MECANICO DE BALANZAS'),\r\n" + 
			"(2678,'MECANICO DE CAMARAS FOTOGRAFICAS'),\r\n" + 
			"(2679,'MECANICO DE DIRECCION Y FRENOS DE AUTOMOVILES'),\r\n" + 
			"(2680,'MECANICO DE INSTRUMENTO QUIRURGICOS'),\r\n" + 
			"(2681,'MECANICO DE INSTRUMENTOS DE LABORATORIO'),\r\n" + 
			"(2682,'MECANICO DE INSTRUMENTOS DE ODONTOLOGIA'),\r\n" + 
			"(2683,'MECANICO DE INSTRUMENTOS DE OPTICA'),\r\n" + 
			"(2684,'MECANICO DE MAQUINAS EN GENERAL: AGRICULTURA, OFICINA, TEXT'),\r\n" + 
			"(2685,'MECANICO DE MOTORES DE BARCOS,EN GENERAL'),\r\n" + 
			"(2686,'MECANICO DE PROTESIS DENTALES'),\r\n" + 
			"(2687,'MECANICO DE PROTESIS ORTOPEDICAS'),\r\n" + 
			"(2688,'MECANICO DE SALA DE MAQUINAS DE BARCOS'),\r\n" + 
			"(2689,'MECANICO DE SONDAS, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(2690,'MECANICO DE TELEFONO Y TELEGRAFOS'),\r\n" + 
			"(2691,'MECANICO DE TURBINAS,EXCEPTO TURBINAS DE AVION'),\r\n" + 
			"(2692,'MECANICO DENTISTA'),\r\n" + 
			"(2693,'MECANICO ENGRASADOR,EXCEPTO BARCOS'),\r\n" + 
			"(2694,'MECANICO ESPECIALISTA EN HERRAMIENTAS Y MATRICES'),\r\n" + 
			"(2695,'MECANICO MOTORES DIESEL,EXCEPTO MOTOR AUTOMOVILES Y CAMIONES'),\r\n" + 
			"(2696,'MECANICO NAVAL'),\r\n" + 
			"(2697,'MECANICO ORTOPEDISTA'),\r\n" + 
			"(2698,'MECANICO REPARADOR DE BICICLETAS'),\r\n" + 
			"(2699,'MECANICO REPARADOR DE TELEFONOS Y TELEGRAFOS'),\r\n" + 
			"(2700,'MECANICO, AJUSTADOR DE MAQUINARIA EN GENERAL'),\r\n" + 
			"(2701,'MECANICO-AJUSTADOR'),\r\n" + 
			"(2702,'MECANICO-MONTADOR MAQUINA, EQUIPO INDUSTRIAL, AIRE ACONDICI'),\r\n" + 
			"(2703,'MECANICO-REPARADOR DE RECEPTORES RADIO Y TV'),\r\n" + 
			"(2704,'MECANICOS DE INSTRUMENTOS DE PRECISION'),\r\n" + 
			"(2705,'MECANICOS ENGRASADOR,BARCOS'),\r\n" + 
			"(2706,'MECANOGRAFA - DACTILOGRAFA'),\r\n" + 
			"(2707,'MECANOGRAFA, ESTADISTICAS'),\r\n" + 
			"(2708,'MECANOGRAFA, ESTENOGRAFIA'),\r\n" + 
			"(2709,'MECANOGRAFA, FACTURAS'),\r\n" + 
			"(2710,'MECANOGRAFA, MAQUINA PERFORADORA'),\r\n" + 
			"(2711,'MECANOGRAFA, TAQUIGRAFIA'),\r\n" + 
			"(2712,'MECANOGRAFA, TEXTOS'),\r\n" + 
			"(2713,'MECANOGRAFICA EN DOMICILIO'),\r\n" + 
			"(2714,'MECANOGRAFOS AMBULANTES'),\r\n" + 
			"(2715,'MEDICO'),\r\n" + 
			"(2716,'MEDICO FORENSE'),\r\n" + 
			"(2717,'MEDICO, ACUPUNTURA'),\r\n" + 
			"(2718,'MEDICO, ANESTESIA'),\r\n" + 
			"(2719,'MEDICO, CARDIOLOGIA'),\r\n" + 
			"(2720,'MEDICO, DERMATOLOGIA'),\r\n" + 
			"(2721,'MEDICO, ENDOCRINOLOGO'),\r\n" + 
			"(2722,'MEDICO, ESTOMATOLOGIA'),\r\n" + 
			"(2723,'MEDICO, GASTROENTEROLOGO'),\r\n" + 
			"(2724,'MEDICO, GERIATRA'),\r\n" + 
			"(2725,'MEDICO, GINECOLOGIA'),\r\n" + 
			"(2726,'MEDICO, LARINGOLOGO'),\r\n" + 
			"(2727,'MEDICO, MEDICINA GENERAL'),\r\n" + 
			"(2728,'MEDICO, NEFROLOGO'),\r\n" + 
			"(2729,'MEDICO, NEUMOLOGO'),\r\n" + 
			"(2730,'MEDICO, NEUROLOGO'),\r\n" + 
			"(2731,'MEDICO, OBSTETRA/OBSTETRICES'),\r\n" + 
			"(2732,'MEDICO, ODONTOLOGO'),\r\n" + 
			"(2733,'MEDICO, OFTALMOLOGIA (OCULISTA)'),\r\n" + 
			"(2734,'MEDICO, OSTEOPATIA'),\r\n" + 
			"(2735,'MEDICO, OTORRINOLARINGOLOGIA'),\r\n" + 
			"(2736,'MEDICO, PATOLOGO'),\r\n" + 
			"(2737,'MEDICO, PEDIATRIA'),\r\n" + 
			"(2738,'MEDICO, PSIQUIATRIA'),\r\n" + 
			"(2739,'MEDICO, PUERICULTOR'),\r\n" + 
			"(2740,'MEDICO, RADIOLOGIA'),\r\n" + 
			"(2741,'MEDICO, UROLOGO'),\r\n" + 
			"(2742,'MEDICO, VENEREOLOGO'),\r\n" + 
			"(2743,'MEJILLONERO'),\r\n" + 
			"(2744,'MELCOCHERO, PREPARADOR'),\r\n" + 
			"(2745,'MENSAJERO'),\r\n" + 
			"(2746,'MENSAJERO, CORRESPONDENCIA'),\r\n" + 
			"(2747,'MENSAJERO, TELEGRAMAS'),\r\n" + 
			"(2748,'MERETRICES, PROSTITUTAS, COPETINERAS'),\r\n" + 
			"(2749,'MESERO'),\r\n" + 
			"(2750,'METALIZADOR A PISTOLA'),\r\n" + 
			"(2751,'METALIZADOR EN BAÑO CALIENTE'),\r\n" + 
			"(2752,'METEOROLOGO'),\r\n" + 
			"(2753,'METEOROLOGO, CLIMATOLOGIA'),\r\n" + 
			"(2754,'MEZCLADOR DE CAFE'),\r\n" + 
			"(2755,'MEZCLADOR DE CAUCHO'),\r\n" + 
			"(2756,'MEZCLADOR DE FIBRA'),\r\n" + 
			"(2757,'MEZCLADOR DE INGREDIENTES, FABRICACION CHOCOLATE'),\r\n" + 
			"(2758,'MEZCLADOR DE MATERIALES,FABRICACION DE VIDRIO'),\r\n" + 
			"(2759,'MEZCLADOR DE PASTA DE ABRASIVOS'),\r\n" + 
			"(2760,'MEZCLADOR DE TABACO'),\r\n" + 
			"(2761,'MEZCLADOR DE TE'),\r\n" + 
			"(2762,'MEZCLADOR DE VINOS'),\r\n" + 
			"(2763,'MEZCLADOR, REFINO DEL PETROLEO'),\r\n" + 
			"(2764,'MEZZO-SOPRANO'),\r\n" + 
			"(2765,'MICOLOGO'),\r\n" + 
			"(2766,'MICROBIOLOGO'),\r\n" + 
			"(2767,'MICROBUSERO/CONDUCTOR DE MICROBUS'),\r\n" + 
			"(2768,'MICROPALEONTOLOGO'),\r\n" + 
			"(2769,'MIEMBRO DEL DIRECTORIO, ASESOR TECNICO/EXPLOTACION: AGRICOLA'),\r\n" + 
			"(2770,'MIEMBRO DEL DIRECTORIO, COMERCIO MAYORISTA Y MINORISTA, REP'),\r\n" + 
			"(2771,'MIEMBRO DEL DIRECTORIO, CONSEJO ADMINISTRATIVO/COOP. AGRARI'),\r\n" + 
			"(2772,'MIEMBRO DEL DIRECTORIO, CONSTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(2773,'MIEMBRO DEL DIRECTORIO, INDUSTRIAS MANUFACTURERAS, MINAS Y'),\r\n" + 
			"(2774,'MIEMBRO DEL DIRECTORIO, RESTAURANTES Y HOTELERIA'),\r\n" + 
			"(2775,'MIEMBRO DEL DIRECTORIO, SERVICIOS PUBLICOS Y FINANCIEROS'),\r\n" + 
			"(2776,'MIEMBRO DEL DIRECTORIO, TRANSPORTE, ALMACENAMIENTO Y COMUNI'),\r\n" + 
			"(2777,'MIEMBRO, EJERCITO DE SALVACION'),\r\n" + 
			"(2778,'MILITAR NO ESPECIFICADO'),\r\n" + 
			"(2779,'MIMO'),\r\n" + 
			"(2780,'MINERALOGISTA'),\r\n" + 
			"(2781,'MINERO EN GENERAL'),\r\n" + 
			"(2782,'MINERVISTA'),\r\n" + 
			"(2783,'MINIATURISTA'),\r\n" + 
			"(2784,'MINISTRO DEL CULTO'),\r\n" + 
			"(2785,'MINISTRO PLENIPOTENCIARIO'),\r\n" + 
			"(2786,'MINISTRO, DE ESTADO'),\r\n" + 
			"(2787,'MISIONERO'),\r\n" + 
			"(2788,'MODELADOR AL TORNO CON TERRAJA,CERAMICA'),\r\n" + 
			"(2789,'MODELADOR DE LENTES'),\r\n" + 
			"(2790,'MODELISTA DE CERAMICA'),\r\n" + 
			"(2791,'MODELISTA EN MADERA'),\r\n" + 
			"(2792,'MODELISTA-AJUSTADOR, FUNDICION'),\r\n" + 
			"(2793,'MODELO DE FOTOGRAFIA'),\r\n" + 
			"(2794,'MODELO, ARTISTA'),\r\n" + 
			"(2795,'MODELO, ESCULTORES'),\r\n" + 
			"(2796,'MODELO, MODAS'),\r\n" + 
			"(2797,'MODELO, PINTORES'),\r\n" + 
			"(2798,'MODELO, PUBLICIDAD'),\r\n" + 
			"(2799,'MODISTA DE TEATRO'),\r\n" + 
			"(2800,'MODISTON, MODISTO'),\r\n" + 
			"(2801,'MOJADOR DE TABACO'),\r\n" + 
			"(2802,'MOLDEADOR A MAQUINA'),\r\n" + 
			"(2803,'MOLDEADOR DE ARTESA'),\r\n" + 
			"(2804,'MOLDEADOR DE CAJA'),\r\n" + 
			"(2805,'MOLDEADOR DE CLISES POR GALVANOPLASTIA, IMPRENTA'),\r\n" + 
			"(2806,'MOLDEADOR DE CRISOLES'),\r\n" + 
			"(2807,'MOLDEADOR DE LADRILLOS Y BALDOSAS'),\r\n" + 
			"(2808,'MOLDEADOR DE MANTEQUILLA'),\r\n" + 
			"(2809,'MOLDEADOR DE MUELAS ABRASIVAS'),\r\n" + 
			"(2810,'MOLDEADOR DE NEUMATICOS'),\r\n" + 
			"(2811,'MOLDEADOR DE PLASTICO POR COMPRESION'),\r\n" + 
			"(2812,'MOLDEADOR DE PLASTICO POR INYECCION'),\r\n" + 
			"(2813,'MOLDEADOR MACHERO DE CERAMICA'),\r\n" + 
			"(2814,'MOLDEADOR Y VULCANIZADOR DE NEUMATICOS'),\r\n" + 
			"(2815,'MOLEDOR, PROCEDIMIENTOS QUIMICOS AFINES'),\r\n" + 
			"(2816,'MOLINERO DE ARROZ'),\r\n" + 
			"(2817,'MOLINERO DE CACAO'),\r\n" + 
			"(2818,'MOLINERO DE CACAO,FABRICACION DE CHOCOLATES'),\r\n" + 
			"(2819,'MOLINERO DE CAFE'),\r\n" + 
			"(2820,'MOLINERO DE CEREALES'),\r\n" + 
			"(2821,'MOLINERO DE ESPECIAS'),\r\n" + 
			"(2822,'MOLINERO DE GRANOS'),\r\n" + 
			"(2823,'MOLINERO DE MINERAL'),\r\n" + 
			"(2824,'MOLINERO, TRATAMIENTO DE PRODUCTOS QUIMICOS AFINES'),\r\n" + 
			"(2825,'MOLINERO,TIERRA DE LOZA'),\r\n" + 
			"(2826,'MONITOR, CULTURA FISICO'),\r\n" + 
			"(2827,'MONJA'),\r\n" + 
			"(2828,'MONJA, NIVEL MEDIO'),\r\n" + 
			"(2829,'MONJE'),\r\n" + 
			"(2830,'MONJE, NIVEL MEDIO'),\r\n" + 
			"(2831,'MONOTIPISTA'),\r\n" + 
			"(2832,'MONTADOR CABLES DE TRANSPORTE DE ENERGIA ELECTRICA'),\r\n" + 
			"(2833,'MONTADOR CONSTRUCC. METALICAS, EXCEPTO BUQUES'),\r\n" + 
			"(2834,'MONTADOR DE ANDAMIOS'),\r\n" + 
			"(2835,'MONTADOR DE APARATOS DE ELEVACION(FUNICULAR)'),\r\n" + 
			"(2836,'MONTADOR DE APARATOS FOTOGRAFICOS'),\r\n" + 
			"(2837,'MONTADOR DE ARTICULOS DE CUERO'),\r\n" + 
			"(2838,'MONTADOR DE CABLES DE AVIACION'),\r\n" + 
			"(2839,'MONTADOR DE CABLES DE GUAROS AEREOS'),\r\n" + 
			"(2840,'MONTADOR DE CABLES DE PUENTES COLGANTES'),\r\n" + 
			"(2841,'MONTADOR DE CABLES DE TRANSPORTE AEREO'),\r\n" + 
			"(2842,'MONTADOR DE CABLES SUBTERRANEAS'),\r\n" + 
			"(2843,'MONTADOR DE CABLES,PERFOR.DE POZOS DE PETR.GAS'),\r\n" + 
			"(2844,'MONTADOR DE CAJAS DE CARTON A MANO O A MAQUINA'),\r\n" + 
			"(2845,'MONTADOR DE CALDERAS'),\r\n" + 
			"(2846,'MONTADOR DE CLISES SOBRE SOPORTE'),\r\n" + 
			"(2847,'MONTADOR DE EBANISTERIA, EDIFICACION'),\r\n" + 
			"(2848,'MONTADOR DE ELEMENTOS PREFABRIC.DE LA EDIFICAC.'),\r\n" + 
			"(2849,'MONTADOR DE INSTALACIONES TELEFONICAS Y TELEGRAFO'),\r\n" + 
			"(2850,'MONTADOR DE INSTRUMENTOS DE PRECISION'),\r\n" + 
			"(2851,'MONTADOR DE LINEAS CATENARIAS'),\r\n" + 
			"(2852,'MONTADOR DE LINEAS SUBTERRANEOS'),\r\n" + 
			"(2853,'MONTADOR DE LINEAS TELEFONICAS Y TELEGRAFICAS'),\r\n" + 
			"(2854,'MONTADOR DE MANUFACTURAS METALICAS'),\r\n" + 
			"(2855,'MONTADOR DE PALAS DE CALZADO'),\r\n" + 
			"(2856,'MONTADOR DE PIEDRAS PRECIOSAS'),\r\n" + 
			"(2857,'MONTADOR DE PLANCHAS,ASTILLEROS'),\r\n" + 
			"(2858,'MONTADOR DE PRODUCTOS DE CAUCHO'),\r\n" + 
			"(2859,'MONTADOR DE PRODUCTOS DE PLASTICO'),\r\n" + 
			"(2860,'MONTADOR DE RADIOS'),\r\n" + 
			"(2861,'MONTADOR DE REDES A MANO'),\r\n" + 
			"(2862,'MONTADOR DE SUELAS'),\r\n" + 
			"(2863,'MONTADOR DE TUBOS ELECTRONICOS'),\r\n" + 
			"(2864,'MONTADOR ELECTRICISTA, AJUSTADOR EN GENERAL'),\r\n" + 
			"(2865,'MONTADOR ESTRUCTURAS DE ACERO,EXCEPTO BUQUES'),\r\n" + 
			"(2866,'MONTADOR LINEAS AEREAS PARA TRANSPORTE DE CORRIENTE'),\r\n" + 
			"(2867,'MONTADOR O ENSAMBLADOR APARATOS ELECT. Y ELECTRO.'),\r\n" + 
			"(2868,'MONTADOR, ASCENSORES Y EQUIPO SIMILAR'),\r\n" + 
			"(2869,'MONTADOR, ORFEBRERIA'),\r\n" + 
			"(2870,'MONTADOR,EDIFICACION CON ELEMENTOS PREFABRICADO'),\r\n" + 
			"(2871,'MONTAJISTA'),\r\n" + 
			"(2872,'MORFOLOGO'),\r\n" + 
			"(2873,'MOSAISTA,COLOCADOR DE MOSAICOS'),\r\n" + 
			"(2874,'MOTORISTA, LANCHA/BOLICHERA'),\r\n" + 
			"(2875,'MOTOSA O RAPARADORA, SEDA'),\r\n" + 
			"(2876,'MOZO'),\r\n" + 
			"(2877,'MOZO (PERSONAL DOMESTICO)'),\r\n" + 
			"(2878,'MOZO DE ALMACEN'),\r\n" + 
			"(2879,'MOZO DE CUADRA (OBRERO)'),\r\n" + 
			"(2880,'MOZO DE CUERDA'),\r\n" + 
			"(2881,'MOZO DE CUERDA, EXCEPTO EN LOS HOTELES'),\r\n" + 
			"(2882,'MOZO DE EQUIPAJES, EXCEPTO EN LOS HOTELES'),\r\n" + 
			"(2883,'MOZO DE MERCADOS DE ABASTOS'),\r\n" + 
			"(2884,'MOZO DE MUDANZA'),\r\n" + 
			"(2885,'MOZO DE TRANSPORTE DE MUEBLES'),\r\n" + 
			"(2886,'MUCAMA'),\r\n" + 
			"(2887,'MUEBLISTA DE MADERA EN GENERAL'),\r\n" + 
			"(2888,'MUJER DE LIMPIEZA DE: HOTELES, OFICINAS ETC.'),\r\n" + 
			"(2889,'MUJER DE LIMPIEZA, HOGARES'),\r\n" + 
			"(2890,'MUSICO AMBULANTE'),\r\n" + 
			"(2891,'MUSICO, PEÐAS, SALSODROMOS, RESTAURANTES TURISTICOS'),\r\n" + 
			"(2892,'NANA'),\r\n" + 
			"(2893,'NAPADOR DE FIBRA'),\r\n" + 
			"(2894,'NATUROPATA'),\r\n" + 
			"(2895,'NEGOCIADOR, SEGUROS'),\r\n" + 
			"(2896,'NEUROCIRUJANO'),\r\n" + 
			"(2897,'NEUROPATOLOGO'),\r\n" + 
			"(2898,'NIÑERA'),\r\n" + 
			"(2899,'NIQUELADOR'),\r\n" + 
			"(2900,'NORMALISTA'),\r\n" + 
			"(2901,'NORMALIZADOR DE METALES'),\r\n" + 
			"(2902,'NOTARIO PUBLICO'),\r\n" + 
			"(2903,'NOVELISTA'),\r\n" + 
			"(2904,'NUMEROLOGO'),\r\n" + 
			"(2905,'NUMEROMANTICO'),\r\n" + 
			"(2906,'OBISPO'),\r\n" + 
			"(2907,'OBOISTA'),\r\n" + 
			"(2908,'OBRERO AGRICOLA DE ARBOLES FRUTALES'),\r\n" + 
			"(2909,'OBRERO AGRICOLA, AYUDANTE'),\r\n" + 
			"(2910,'OBRERO AVICULTOR, AYUDANTE'),\r\n" + 
			"(2911,'OBRERO CRIADOR, AYUDANTE'),\r\n" + 
			"(2912,'OBRERO DE COMPUERTAS DE EVACUACION,EXCLUSAS EN DIQUE SECO'),\r\n" + 
			"(2913,'OBRERO DE CONSERVACION, REPARACION Y MANTENIMIENTO DE EDIFI'),\r\n" + 
			"(2914,'OBRERO DE FABRICACION DE JUGUETE METALICOS'),\r\n" + 
			"(2915,'OBRERO DE IMPERMEABILIZACION DE TELAS AL ACEITE'),\r\n" + 
			"(2916,'OBRERO DE LA ELABOR. DE PREFABRICADOS DE HORMIGON ARMADO'),\r\n" + 
			"(2917,'OBRERO DE LA ELABORACION DE CUERDAS DE TRIPA'),\r\n" + 
			"(2918,'OBRERO DE LA ELABORACION DE FIBROCEMENTO DE AMIANTO'),\r\n" + 
			"(2919,'OBRERO DE LA ELABORACION DE PROD.HORMIGON ARMADO'),\r\n" + 
			"(2920,'OBRERO DE LA ELABORACION DE PRODUCTOS DE CORCHO'),\r\n" + 
			"(2921,'OBRERO DE LA ELABORACION DE VINOS'),\r\n" + 
			"(2922,'OBRERO DE LA FAB. DE TELAS Y PAPELES PREVESTIDOS'),\r\n" + 
			"(2923,'OBRERO DE LA FABRIC. DE AGLOMERADOS DE PIEDRA ARTIFICIAL'),\r\n" + 
			"(2924,'OBRERO DE LA FABRIC.DE PELICULAS Y PAPEL FOTOGRAFICO'),\r\n" + 
			"(2925,'OBRERO DE LA FABRICACION DE JUGUETES DE MADERA'),\r\n" + 
			"(2926,'OBRERO DE LA FABRICACION DE LEVADURA'),\r\n" + 
			"(2927,'OBRERO DE LA FABRICACION DE LINOLEO'),\r\n" + 
			"(2928,'OBRERO DE LA FABRICACION DE PAPEL Y TELA DE ESMERIL(LIJA)'),\r\n" + 
			"(2929,'OBRERO DE LA FABRICACION DE PIEDRA ARTIFICIAL'),\r\n" + 
			"(2930,'OBRERO DE LA GERMINACION DE GRANOS,CERVEZA'),\r\n" + 
			"(2931,'OBRERO DE LA PREPAC. Y CONSERV.  DE FRUTAS SECAS'),\r\n" + 
			"(2932,'OBRERO DE LA PREPARACION DE ARENAS SILICEAS PARA FILTROS'),\r\n" + 
			"(2933,'OBRERO DE MINERIA DE LAVADO'),\r\n" + 
			"(2934,'OBRERO DE REVEST.DE SUELOS DE BALDOSAS SINTETICAS'),\r\n" + 
			"(2935,'OBRERO DE TRAT. Y REVEST. DE ALQUITRAN O ASFALTO DEL PAPEL'),\r\n" + 
			"(2936,'OBRERO DE VINOS ACHAMPANADOS'),\r\n" + 
			"(2937,'OBRERO DEL APOMAZADO DEL CAUCHO'),\r\n" + 
			"(2938,'OBRERO DEL CURADO DEL HORMIGON'),\r\n" + 
			"(2939,'OBRERO ELABORACION SODAS, GASEOSAS Y OTRAS BEBIDAS NO ALCOH'),\r\n" + 
			"(2940,'OBRERO EN LA ELABORACION DE TELAS ACEITADAS'),\r\n" + 
			"(2941,'OBRERO EN LA FABRIC. DE ARTICULOS DE CAUCHO'),\r\n" + 
			"(2942,'OBRERO EN LA FABRICACION DE ADORNOS ARTIFICIALES'),\r\n" + 
			"(2943,'OBRERO EN LA FABRICACION DE BOTONES'),\r\n" + 
			"(2944,'OBRERO ESPECIALIZADO EN APEOS'),\r\n" + 
			"(2945,'OBRERO ESPECIALIZADO EN SUELO REVESTIDOS CON ASFALTO'),\r\n" + 
			"(2946,'OBRERO FORESTAL, AYUDANTE'),\r\n" + 
			"(2947,'OBRERO GANADERO, AYUDANTE'),\r\n" + 
			"(2948,'OBRERO PORTUARIO'),\r\n" + 
			"(2949,'OBRERO TEXTIL'),\r\n" + 
			"(2950,'OBRERO TRATAM. PETROLEO CRUDO, CAMPOS EXTRACCION'),\r\n" + 
			"(2951,'OBRERO, FABRICACION COLORANTES, TINTES, PINTURAS, BARNICES'),\r\n" + 
			"(2952,'OBRERO, FABRICACION DE CARUSA'),\r\n" + 
			"(2953,'OBRERO, FABRICACION DE COMPRIMIDOS Y GRAGEAS'),\r\n" + 
			"(2954,'OBRERO, FABRICACION DE EXPLOSIVOS'),\r\n" + 
			"(2955,'OBRERO, FABRICACION DE MINIO'),\r\n" + 
			"(2956,'OBRERO, FABRICACION HIDROGENO, OXIGENO, ACETILENO, OTROS'),\r\n" + 
			"(2957,'OBREROS DE LA COAGULACION DE LATEX'),\r\n" + 
			"(2958,'OBREROS DE LA MANIPULACION DE MERCANCIA Y MATERIALES O DE M'),\r\n" + 
			"(2959,'OBREROS DE LA MANUFACTURA A MANO DE PZAS METAL'),\r\n" + 
			"(2960,'OBREROS DEL BALASTO, FERROCARRIL'),\r\n" + 
			"(2961,'OBREROS DEL TRATAMIENTO DE DESECHOS RADIACTIVOS'),\r\n" + 
			"(2962,'OBREROS EN LA FABRICACION DE ABONOS'),\r\n" + 
			"(2963,'OBREROS EN LA FABRICACION DE ACIDOS'),\r\n" + 
			"(2964,'OBREROS FCION MUELLES, CLAVOS, TORNILLOS, CABLES'),\r\n" + 
			"(2965,'OBREROS TRATAMIENTO QUIMICO DE MATERIALES RADIACTIVOS'),\r\n" + 
			"(2966,'OCEANOGRAFO, GEOFISICA'),\r\n" + 
			"(2967,'OCEANOGRAFO, GEOLOGIA'),\r\n" + 
			"(2968,'OCUPACION NO ESPECIFICADA'),\r\n" + 
			"(2969,'ODONTOLOGO'),\r\n" + 
			"(2970,'ODONTOLOGO, ENDODONCIA'),\r\n" + 
			"(2971,'ODONTOLOGO, ORTODONCIA'),\r\n" + 
			"(2972,'ODONTOLOGO, PEDODONCIA'),\r\n" + 
			"(2973,'ODONTOLOGO, PERIODONCIA'),\r\n" + 
			"(2974,'OFICIAL DE MASA O DE PALA,PANADERIA'),\r\n" + 
			"(2975,'OFICIAL DE RESGUARDO DE ADUANA'),\r\n" + 
			"(2976,'OFICIAL MAQUINISTA, BARCO'),\r\n" + 
			"(2977,'OFICIAL MECANICO, VUELO/MECANICO NAVEGANTE'),\r\n" + 
			"(2978,'OFICIAL NAVEGANTE, AERONAVE'),\r\n" + 
			"(2979,'OFICIAL, CUBIERTA'),\r\n" + 
			"(2980,'OFICIAL, NAVEGACION'),\r\n" + 
			"(2981,'OFICINISTA-MECANOGRAFA'),\r\n" + 
			"(2982,'OFTALMOLOGO'),\r\n" + 
			"(2983,'ONIROMANTICO'),\r\n" + 
			"(2984,'OPERAD MAQ. DE MOLDEAR MATERIAS PLASTICAS POR INYECCION'),\r\n" + 
			"(2985,'OPERAD MAQ. PEGADORA Y CERRADORA BOLSAS Y SOBRES'),\r\n" + 
			"(2986,'OPERAD PRENSA ROTATIVA, OFFSET, CILINDRO, PLATINA, LITOGRAF'),\r\n" + 
			"(2987,'OPERAD SEPARADORA CENTRIFUGADORA, TRATAMIENTO QUIMICO Y AFI'),\r\n" + 
			"(2988,'OPERAD. INSTALACIONES PROCESO CONTINUO, REFIN. AZUCAR'),\r\n" + 
			"(2989,'OPERADOR - COSECHADORA'),\r\n" + 
			"(2990,'OPERADOR DE ACIDIFICACION DE POZOS DE PETROLEO'),\r\n" + 
			"(2991,'OPERADOR DE APARATO DE PRECIPITACION'),\r\n" + 
			"(2992,'OPERADOR DE APARATO DE PROYECCION,CINE'),\r\n" + 
			"(2993,'OPERADOR DE APARATOS DE ESTUDIOS DE RADIO Y TV'),\r\n" + 
			"(2994,'OPERADOR DE APARATOS REACCION, CONVERSION PRODUCTOS QUIMICO'),\r\n" + 
			"(2995,'OPERADOR DE AUDIOMETRIA'),\r\n" + 
			"(2996,'OPERADOR DE AUTOCLAVE, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(2997,'OPERADOR DE BANO METALICO POR FLOTACION VIDRIO'),\r\n" + 
			"(2998,'OPERADOR DE BATERIA DE GAS DE HULLA'),\r\n" + 
			"(2999,'OPERADOR DE BATIDORA DE HELADOS'),\r\n" + 
			"(3000,'OPERADOR DE BATIDORA DE HELICE'),\r\n" + 
			"(3001,'OPERADOR DE BATIDORA, PULPA DE MADERA'),\r\n" + 
			"(3002,'OPERADOR DE CABINA, CINEMATOGRAFICA, SALAS CINE'),\r\n" + 
			"(3003,'OPERADOR DE CABRESTANTE'),\r\n" + 
			"(3004,'OPERADOR DE CABRESTANTE DE VAPOR'),\r\n" + 
			"(3005,'OPERADOR DE CALANDRIA DE CAUCHO'),\r\n" + 
			"(3006,'OPERADOR DE CALANDRIA DE PAPEL'),\r\n" + 
			"(3007,'OPERADOR DE CALANDRIAS,TEJIDOS'),\r\n" + 
			"(3008,'OPERADOR DE CALDERA, PASTA PARA PAPEL'),\r\n" + 
			"(3009,'OPERADOR DE CALDERA, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(3010,'OPERADOR DE CENTRAL TERMOELECTRICA E HIDROELECTRICAS'),\r\n" + 
			"(3011,'OPERADOR DE CENTRIFUGADORA'),\r\n" + 
			"(3012,'OPERADOR DE CIZALLA MECANICA'),\r\n" + 
			"(3013,'OPERADOR DE COMPRESOR DE AIRE, DE GAS'),\r\n" + 
			"(3014,'OPERADOR DE CONO DE SEPARACION, MINAS'),\r\n" + 
			"(3015,'OPERADOR DE COQUERIA, CARBON DE COQUE'),\r\n" + 
			"(3016,'OPERADOR DE CRIBAS HIDRAULICAS'),\r\n" + 
			"(3017,'OPERADOR DE CRISTALIZADORA, REFINACION DE AZUCAR'),\r\n" + 
			"(3018,'OPERADOR DE CUADRO DE CONTROL REFINO DEL PETROLEO'),\r\n" + 
			"(3019,'OPERADOR DE CUADRO DE DISTRIBUCION DE CONTROL'),\r\n" + 
			"(3020,'OPERADOR DE DESDOBLADORA, ACEITE Y DERIVADOS'),\r\n" + 
			"(3021,'OPERADOR DE DIFUSOR, AZUCAR DE REMOLACHA'),\r\n" + 
			"(3022,'OPERADOR DE ELECTROCARDIOGRAFIA'),\r\n" + 
			"(3023,'OPERADOR DE ELECTROENCEFOLOGRAFIA'),\r\n" + 
			"(3024,'OPERADOR DE EQUIPO DE GRABACION O REG. DE SONIDO'),\r\n" + 
			"(3025,'OPERADOR DE EQUIPO DE TRANSMISION DE RADIO Y TV'),\r\n" + 
			"(3026,'OPERADOR DE EQUIPO ELECTROGENO PARTICULAR'),\r\n" + 
			"(3027,'OPERADOR DE EQUIPO ELECTRONICO,TRATAMIENTOS QUIMICOS'),\r\n" + 
			"(3028,'OPERADOR DE ESCOPLEADORA'),\r\n" + 
			"(3029,'OPERADOR DE ESMERILADORA'),\r\n" + 
			"(3030,'OPERADOR DE ESTACION DE BOMBEO'),\r\n" + 
			"(3031,'OPERADOR DE ESTACION EMISORA RADIO Y TV,DE EQUIPO'),\r\n" + 
			"(3032,'OPERADOR DE EVAPORADOR'),\r\n" + 
			"(3033,'OPERADOR DE EVAPORADORA, EXTRACTOS ALIMENTICIO'),\r\n" + 
			"(3034,'OPERADOR DE FILTRO DE TAMBOR GIRATORIO'),\r\n" + 
			"(3035,'OPERADOR DE FILTRO PRENSA PARA ARCILLA(CERAMICA)'),\r\n" + 
			"(3036,'OPERADOR DE FILTRO-PRENSA'),\r\n" + 
			"(3037,'OPERADOR DE FILTROS DE PARAFINA'),\r\n" + 
			"(3038,'OPERADOR DE GASOMETRO'),\r\n" + 
			"(3039,'OPERADOR DE GENERADOR DE ENERGIA ELECTRICA, INST. PARTICULA'),\r\n" + 
			"(3040,'OPERADOR DE GRUA DE CUBIERTA'),\r\n" + 
			"(3041,'OPERADOR DE HIDROGENADORA, ACEITE Y DERIVADOS'),\r\n" + 
			"(3042,'OPERADOR DE HORNO DE RECALENTAR'),\r\n" + 
			"(3043,'OPERADOR DE HORNO DE SECADO DE MADERA'),\r\n" + 
			"(3044,'OPERADOR DE IMAGEN DE TELEVISION'),\r\n" + 
			"(3045,'OPERADOR DE INSTALACION DE CENTRAL TERMOELECTRICA E HIDROEL'),\r\n" + 
			"(3046,'OPERADOR DE INSTALACIONES DE BOMBEO,EXC REFINO DE PETROLEO'),\r\n" + 
			"(3047,'OPERADOR DE INSTALACIONES DE CALEF.Y VENTILACION'),\r\n" + 
			"(3048,'OPERADOR DE INSTALACIONES DE FLOTACION'),\r\n" + 
			"(3049,'OPERADOR DE INSTALACIONES DE INCINERACION DE RESIDUOS'),\r\n" + 
			"(3050,'OPERADOR DE INSTALACIONES DE REFRIGERACION'),\r\n" + 
			"(3051,'OPERADOR DE INSTALACIONES DE TRATAMIENTO DEL AGUA,ABASTECIM'),\r\n" + 
			"(3052,'OPERADOR DE INSTALCIONES PARA MEZCLAR HORMIGON'),\r\n" + 
			"(3053,'OPERADOR DE MAQ DE AIRE COMPRIM PARA REVEST. CON HORMIGON'),\r\n" + 
			"(3054,'OPERADOR DE MAQ. COAGULADORA, GRASA VEGETALES'),\r\n" + 
			"(3055,'OPERADOR DE MAQ. DE LABRAR MADERA,EN GENERAL'),\r\n" + 
			"(3056,'OPERADOR DE MAQUINA AMASADORA DE CAUCHO'),\r\n" + 
			"(3057,'OPERADOR DE MAQUINA CALANDRADORA DE CAUCHO'),\r\n" + 
			"(3058,'OPERADOR DE MAQUINA CENTRIFUGADORA DE COLADA'),\r\n" + 
			"(3059,'OPERADOR DE MAQUINA COLADA CONTINUA DE TUBOS Y VARILLAS'),\r\n" + 
			"(3060,'OPERADOR DE MAQUINA DE APRESTAR PAPEL'),\r\n" + 
			"(3061,'OPERADOR DE MAQUINA DE COLAR DE PRESION'),\r\n" + 
			"(3062,'OPERADOR DE MAQUINA DE CORTAR LADRILLOS Y TEJAS'),\r\n" + 
			"(3063,'OPERADOR DE MAQUINA DE CORTAR Y PEGAR CARTON'),\r\n" + 
			"(3064,'OPERADOR DE MAQUINA DE CURVAR METALES'),\r\n" + 
			"(3065,'OPERADOR DE MAQUINA DE EMBOLSAR CIGARRILLOS'),\r\n" + 
			"(3066,'OPERADOR DE MAQUINA DE FABRICAR BOLSAS PLASTICO'),\r\n" + 
			"(3067,'OPERADOR DE MAQUINA DE FABRICAR LAPICES'),\r\n" + 
			"(3068,'OPERADOR DE MAQUINA DE FABRICAR PASTAS ALIMENTICIAS'),\r\n" + 
			"(3069,'OPERADOR DE MAQUINA DE FORRAR CARTON'),\r\n" + 
			"(3070,'OPERADOR DE MAQUINA DE FOTOTIPIA, IMPRENTA'),\r\n" + 
			"(3071,'OPERADOR DE MAQUINA DE FUNCION MULTIPLE'),\r\n" + 
			"(3072,'OPERADOR DE MAQUINA DE GOMA DE MASCAR,CHICLE'),\r\n" + 
			"(3073,'OPERADOR DE MAQUINA DE HACER CIGARRILLOS'),\r\n" + 
			"(3074,'OPERADOR DE MAQUINA DE HACER FILTROS CIGARRILLOS'),\r\n" + 
			"(3075,'OPERADOR DE MAQUINA DE HOMOGENIZACION DE LA LECHE'),\r\n" + 
			"(3076,'OPERADOR DE MAQUINA DE MOLDEAR O SOPLAR VIDRIO'),\r\n" + 
			"(3077,'OPERADOR DE MAQUINA DE PICAR TABACO'),\r\n" + 
			"(3078,'OPERADOR DE MAQUINA DE SELLAR PLASTICOS'),\r\n" + 
			"(3079,'OPERADOR DE MAQUINA DE TALLAR ENGRANAJES'),\r\n" + 
			"(3080,'OPERADOR DE MAQUINA DE TRANSFERENCIA AUTOMATICA'),\r\n" + 
			"(3081,'OPERADOR DE MAQUINA DE TRICOT'),\r\n" + 
			"(3082,'OPERADOR DE MAQUINA DE TRITURAR MADERA'),\r\n" + 
			"(3083,'OPERADOR DE MAQUINA ESTIRADORA DE CAUCHO'),\r\n" + 
			"(3084,'OPERADOR DE MAQUINA FUNDIDORA DE TIPOS'),\r\n" + 
			"(3085,'OPERADOR DE MAQUINA INTERCALADORA DE CHAPAS, CONTRACHAPADO'),\r\n" + 
			"(3086,'OPERADOR DE MAQUINA LAPIADORA DE METALES'),\r\n" + 
			"(3087,'OPERADOR DE MAQUINA MEZCLADORA, TRATAMIENTO QUIMICO AFINES'),\r\n" + 
			"(3088,'OPERADOR DE MAQUINA PARA FABRICAR FIBRA VIDRIO'),\r\n" + 
			"(3089,'OPERADOR DE MAQUINA PARA FABRICAR LANA DE VIDRIO'),\r\n" + 
			"(3090,'OPERADOR DE MAQUINA PARA SECADO Y ENROLLADO, PAPEL'),\r\n" + 
			"(3091,'OPERADOR DE MAQUINA PEGADORA DE PAPEL EN CARTON'),\r\n" + 
			"(3092,'OPERADOR DE MAQUINA PELADORA PARA CHAPAS'),\r\n" + 
			"(3093,'OPERADOR DE MAQUINA PRENSADORA DE CARTON'),\r\n" + 
			"(3094,'OPERADOR DE MAQUINA PULVERIZADORA DE AZUCAR'),\r\n" + 
			"(3095,'OPERADOR DE MAQUINA RECUBRIDORA DE ALAMBRE'),\r\n" + 
			"(3096,'OPERADOR DE MAQUINA SECADORA DE TABACO'),\r\n" + 
			"(3097,'OPERADOR DE MAQUINA, TRATAMIENTO DE TEXTO'),\r\n" + 
			"(3098,'OPERADOR DE MAQUINARIA DE IRRIGACION ARTIFICIAL'),\r\n" + 
			"(3099,'OPERADOR DE MAQUINAS DE DIVIDIR CUEROS'),\r\n" + 
			"(3100,'OPERADOR DE MAQUINAS DE LABRAR, EN GENERAL'),\r\n" + 
			"(3101,'OPERADOR DE MAQUINAS DE REPRODUCCION CARTONES PARA TEJIDOS'),\r\n" + 
			"(3102,'OPERADOR DE MAQUINAS DE SOMBREROS DE FIELTRO'),\r\n" + 
			"(3103,'OPERADOR DE MAQUINAS FIJAS N.E.O.P'),\r\n" + 
			"(3104,'OPERADOR DE MAQUINAS HERRAMIENTAS EN GENERAL'),\r\n" + 
			"(3105,'OPERADOR DE MAQUINAS PARA FABRICAR TORNILLOS'),\r\n" + 
			"(3106,'OPERADOR DE MARMITA, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(3107,'OPERADOR DE MONOTIPIA DE FUNDIR'),\r\n" + 
			"(3108,'OPERADOR DE MONTACARGAS,CONSTRUCCION'),\r\n" + 
			"(3109,'OPERADOR DE PASTA PARA PAPEL EN GENERAL'),\r\n" + 
			"(3110,'OPERADOR DE PILON DE MAIZ'),\r\n" + 
			"(3111,'OPERADOR DE PLANTA DE FUERZA ENERGIA ELECTRICA'),\r\n" + 
			"(3112,'OPERADOR DE PLANTA PARA LICUEFACCION DE GAS'),\r\n" + 
			"(3113,'OPERADOR DE PLANTA TERMOELECTRICA E HIDROELECTRICAS'),\r\n" + 
			"(3114,'OPERADOR DE PONTON DE GRUA'),\r\n" + 
			"(3115,'OPERADOR DE PRENSA DE CERAMICA'),\r\n" + 
			"(3116,'OPERADOR DE PRENSA DE CONTRACHAPADO'),\r\n" + 
			"(3117,'OPERADOR DE PRENSA DE EMBUTIR CARTON'),\r\n" + 
			"(3118,'OPERADOR DE PRENSA DE FAB. TIZAS BLANCAS Y COLOR'),\r\n" + 
			"(3119,'OPERADOR DE PRENSA DE MADERA TERCIADA'),\r\n" + 
			"(3120,'OPERADOR DE PRENSA DE MOLDEAR CAUCHO'),\r\n" + 
			"(3121,'OPERADOR DE PRENSA DE PELLETS DE MINERAL'),\r\n" + 
			"(3122,'OPERADOR DE PRENSA ESTAMPAR EN RELIEVE O SECO'),\r\n" + 
			"(3123,'OPERADOR DE PRENSA GALLETERA, CERAMICA'),\r\n" + 
			"(3124,'OPERADOR DE PRENSA MECANICA,DE METALES'),\r\n" + 
			"(3125,'OPERADOR DE PRENSAS DE FRUTAS'),\r\n" + 
			"(3126,'OPERADOR DE PUENTE GIRATORIO'),\r\n" + 
			"(3127,'OPERADOR DE PUENTE LEVADIZO'),\r\n" + 
			"(3128,'OPERADOR DE QUEBRANTADORA DE MINERAL'),\r\n" + 
			"(3129,'OPERADOR DE QUEBRANTADORA DE ROCAS'),\r\n" + 
			"(3130,'OPERADOR DE QUEBRANTADORA, TRATAMIENTO QUIMICOS AFINES'),\r\n" + 
			"(3131,'OPERADOR DE RADIO Y TELEVISION'),\r\n" + 
			"(3132,'OPERADOR DE RADIOGRAFIA'),\r\n" + 
			"(3133,'OPERADOR DE RAYOS X'),\r\n" + 
			"(3134,'OPERADOR DE REACTOR NUCLEAR'),\r\n" + 
			"(3135,'OPERADOR DE REBANADORA DE CUEROS'),\r\n" + 
			"(3136,'OPERADOR DE SCANER'),\r\n" + 
			"(3137,'OPERADOR DE SCANER (OPTICA)'),\r\n" + 
			"(3138,'OPERADOR DE SECADOR DE BRIQUETAS'),\r\n" + 
			"(3139,'OPERADOR DE SECADOR, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(3140,'OPERADOR DE SIERRA DE CINTA'),\r\n" + 
			"(3141,'OPERADOR DE SIERRA MECANICA DE METALES'),\r\n" + 
			"(3142,'OPERADOR DE SIERRAS DE RECORTAR TABLAS'),\r\n" + 
			"(3143,'OPERADOR DE SOPLADOR DE ARENA, PARA LIMPIAR METALES'),\r\n" + 
			"(3144,'OPERADOR DE TALADRADORA DE METAL'),\r\n" + 
			"(3145,'OPERADOR DE TECLADO DE MONOTIPIA'),\r\n" + 
			"(3146,'OPERADOR DE TIJERA MECANICA'),\r\n" + 
			"(3147,'OPERADOR DE TORNO DE EMBUTIR'),\r\n" + 
			"(3148,'OPERADOR DE TORNO DE VAPOR, CABRESTANTE'),\r\n" + 
			"(3149,'OPERADOR DE TRITURADORA DE MINERALES'),\r\n" + 
			"(3150,'OPERADOR DE TROQUEL DE GALLETAS'),\r\n" + 
			"(3151,'OPERADOR DE TURBINA DE CENTRAL ELECTRICA, PLANTA DE FUERZA'),\r\n" + 
			"(3152,'OPERADOR DE TURBINAS, REFINO DEL PETROLEO'),\r\n" + 
			"(3153,'OPERADOR DE VIDEO'),\r\n" + 
			"(3154,'OPERADOR DE VIDEO O BETAMAX'),\r\n" + 
			"(3155,'OPERADOR DE ZANJADORA DE CANGILONES'),\r\n" + 
			"(3156,'OPERADOR EN PRENSA DE MOLDEAR VIDRIO'),\r\n" + 
			"(3157,'OPERADOR EQUIPO DE AMPLIFICACION DE SONIDO'),\r\n" + 
			"(3158,'OPERADOR EQUIPO ESTUDIOS RADIODIFUSION O TV'),\r\n" + 
			"(3159,'OPERADOR ESTACION EMISORA DE RADIO Y TV'),\r\n" + 
			"(3160,'OPERADOR HORNOS CALCINACION, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(3161,'OPERADOR MAQ. CONFECCIONAR BOLSAS Y SOBRES PAPEL'),\r\n" + 
			"(3162,'OPERADOR MAQ. ESTAMPAR MARCAS DE LOS CIGARRILLOS'),\r\n" + 
			"(3163,'OPERADOR MAQ.CALIBRADORA-CORTADORA MASA, FABRIC. DE GALLETA'),\r\n" + 
			"(3164,'OPERADOR MAQ.SOBADORA MASA, FABRICACION GALLETAS'),\r\n" + 
			"(3165,'OPERADOR MAQUINA DE FABRICAR PAPEL, FASE HUMEDA, FASE SECA'),\r\n" + 
			"(3166,'OPERADOR MAQUINA ESTIRADORA DE PLASTICO'),\r\n" + 
			"(3167,'OPERADOR MAQUINA ESTIRAR VIDRIO PLANO,VARILLAS O TUBO'),\r\n" + 
			"(3168,'OPERADOR MAQUINAS HERRAMIENTA AUTOMATICA MANDO NUMERICO'),\r\n" + 
			"(3169,'OPERADOR PRENSA ALTA PRESION PARA LADRILLOS ESPECIALES'),\r\n" + 
			"(3170,'OPERADOR VERTIDO VIDRIO FUNDIDO/VERTIDOR VIDRIO FUNDIDO'),\r\n" + 
			"(3171,'OPERADOR,  ORDENADOR ELECTRONICO'),\r\n" + 
			"(3172,'OPERADOR, ALMACENAMIENTO DE DATOS'),\r\n" + 
			"(3173,'OPERADOR, CABINA DE PROYECCION/CINEMATOGRAFIA'),\r\n" + 
			"(3174,'OPERADOR, CALCULADORA'),\r\n" + 
			"(3175,'OPERADOR, CAMARA DE CINE'),\r\n" + 
			"(3176,'OPERADOR, CAMARA DE TELEVISION'),\r\n" + 
			"(3177,'OPERADOR, COMPUTADORA'),\r\n" + 
			"(3178,'OPERADOR, ENTRADA DE DATOS/CLASIFICADORA'),\r\n" + 
			"(3179,'OPERADOR, ENTRADA DE DATOS/COMPUTADORAS'),\r\n" + 
			"(3180,'OPERADOR, ENTRADA DE DATOS/CONVERTIDOR (DE CINTAS A TARJETA'),\r\n" + 
			"(3181,'OPERADOR, ENTRADA DE DATOS/MAQUINA CONVERTIDORA (DE CINTAS'),\r\n" + 
			"(3182,'OPERADOR, ENTRADA DE DATOS/MAQUINA CONVERTIDORA (DE TARJETA'),\r\n" + 
			"(3183,'OPERADOR, ENTRADA DE DATOS/MAQUINA PERFORADORAS (CINTAS)'),\r\n" + 
			"(3184,'OPERADOR, ENTRADA DE DATOS/MAQUINA PERFORADORAS (TARJETAS Y'),\r\n" + 
			"(3185,'OPERADOR, ENTRADA DE DATOS/MAQUINA PERFORADORAS (TECLADO)'),\r\n" + 
			"(3186,'OPERADOR, ENTRADA DE DATOS/TABULADORA'),\r\n" + 
			"(3187,'OPERADOR, ENTRADA DE DATOS/TRANSCRIPCION DE PERFORACIONES ('),\r\n" + 
			"(3188,'OPERADOR, EQUIPO AUDIO/RADIO'),\r\n" + 
			"(3189,'OPERADOR, EQUIPO AUDIO/TELEVISION'),\r\n" + 
			"(3190,'OPERADOR, EQUIPO DE AMPLIFICACION DE SONIDO'),\r\n" + 
			"(3191,'OPERADOR, EQUIPO DE DIFUSION/TELEFILMES'),\r\n" + 
			"(3192,'OPERADOR, EQUIPO DE DIFUSION/TELEVISION'),\r\n" + 
			"(3193,'OPERADOR, EQUIPO DE DIFUSION/VIDEO'),\r\n" + 
			"(3194,'OPERADOR, EQUIPO DE RADIO Y TELEVISION'),\r\n" + 
			"(3195,'OPERADOR, EQUIPO DE RADIODIFUSION'),\r\n" + 
			"(3196,'OPERADOR, EQUIPO DE RADIOTELEFONIA/ESTACIONES TERRESTRES'),\r\n" + 
			"(3197,'OPERADOR, EQUIPO DE SONORIZACION, CINE'),\r\n" + 
			"(3198,'OPERADOR, EQUIPO MOVILES DE RADIODIFUSION Y TELEVISION'),\r\n" + 
			"(3199,'OPERADOR, EQUIPOS INFORMATICOS/COMPUTADORAS'),\r\n" + 
			"(3200,'OPERADOR, EQUIPOS INFORMATICOS/UNIDADES PERIFERICAS (IMPRES'),\r\n" + 
			"(3201,'OPERADOR, ESTACION EMISORA DE RADIO'),\r\n" + 
			"(3202,'OPERADOR, ESTACION EMISORA DE TELEVISION'),\r\n" + 
			"(3203,'OPERADOR, ESTUDIOS DE RADIO'),\r\n" + 
			"(3204,'OPERADOR, ESTUDIOS DE TELEVISION'),\r\n" + 
			"(3205,'OPERADOR, GRABACION DE SONIDO'),\r\n" + 
			"(3206,'OPERADOR, GRABACION DE SONIDO/DISCOS'),\r\n" + 
			"(3207,'OPERADOR, GRABACION DE SONIDO/RADIO'),\r\n" + 
			"(3208,'OPERADOR, GRABACION DE SONIDO/TELEVISION'),\r\n" + 
			"(3209,'OPERADOR, MAQUINA CLASIFICADORA Y TABULADOS'),\r\n" + 
			"(3210,'OPERADOR, MAQUINA CONTABLE'),\r\n" + 
			"(3211,'OPERADOR, MAQUINA DE CONTABILIDAD'),\r\n" + 
			"(3212,'OPERADOR, MAQUINA DE LLEVAR LIBROS'),\r\n" + 
			"(3213,'OPERADOR, MAQUINA DE PREPARAR FACTURAS'),\r\n" + 
			"(3214,'OPERADOR, MAQUINA DE SUMAR'),\r\n" + 
			"(3215,'OPERADOR, MAQUINA FRANQUEADORA'),\r\n" + 
			"(3216,'OPERADOR, MICROFONOS'),\r\n" + 
			"(3217,'OPERADOR, PROCESO DE APLICACIONES CATALOGADAS'),\r\n" + 
			"(3218,'OPERADOR, RADAR'),\r\n" + 
			"(3219,'OPERADOR, RADIO/NAVEGACION AEREA'),\r\n" + 
			"(3220,'OPERADOR, RADIO/NAVEGACION MARITIMA'),\r\n" + 
			"(3221,'OPERADOR, TELECOMUNICACIONES'),\r\n" + 
			"(3222,'OPERADOR, TELEFAX'),\r\n" + 
			"(3223,'OPERADOR, TELEGRAFO'),\r\n" + 
			"(3224,'OPERADOR, TELEIMPRESORA'),\r\n" + 
			"(3225,'OPERADOR, TRANSMISORES/RADIO'),\r\n" + 
			"(3226,'OPERADOR, TRANSMISORES/TELEVISION'),\r\n" + 
			"(3227,'OPERADORA, CENTRAL TELEFONICA'),\r\n" + 
			"(3228,'OPERADOR-JEFE, TELECOMUNICACIONES/ESTACION'),\r\n" + 
			"(3229,'OPERADOR-JEFE, TELECOMUNICACIONES/TRAFICO'),\r\n" + 
			"(3230,'OPERAR MAQ. DE MOLDEAR MATERIAS PLASTICAS POR COMPRESION'),\r\n" + 
			"(3231,'OPERARIO DE COLADA CONTINUA'),\r\n" + 
			"(3232,'OPERARIO DE LAMINADO DE REVESTIMIENTO'),\r\n" + 
			"(3233,'OPERARIO DE LAMINADO REVERSIBLE'),\r\n" + 
			"(3234,'OPERARIO DE MESA DE CORTE, OXICORTADOR'),\r\n" + 
			"(3235,'OPERARIO DE NAVE DE COLADA'),\r\n" + 
			"(3236,'OPERARIO DE OXICORTE'),\r\n" + 
			"(3237,'OPERARIO DE TREN DE LAMINACION'),\r\n" + 
			"(3238,'OPTICO, ANTEOJOS'),\r\n" + 
			"(3239,'OPTICO, OFTALMOLOGIA'),\r\n" + 
			"(3240,'OPTOMETRISTA'),\r\n" + 
			"(3241,'ORDEÑADOR'),\r\n" + 
			"(3242,'OREADOR DE TABACO'),\r\n" + 
			"(3243,'ORFEBRE ARTISTA'),\r\n" + 
			"(3244,'ORFEBRE, JOYERO O PLATERO'),\r\n" + 
			"(3245,'ORGANERO,CONSTRUCTOR Y AFINADOR'),\r\n" + 
			"(3246,'ORGANISTA'),\r\n" + 
			"(3247,'ORGANIZADOR DE ESPECTACULO, VARIOS'),\r\n" + 
			"(3248,'ORGANIZADOR DE POMPAS FUNEBRES'),\r\n" + 
			"(3249,'ORGANIZADOR, VIAJES'),\r\n" + 
			"(3250,'ORNITOLOGO'),\r\n" + 
			"(3251,'ORQUESTADOR'),\r\n" + 
			"(3252,'ORTOFONIA, ESPECIALISTA'),\r\n" + 
			"(3253,'ORTOPTIA, ESPECIALISTA'),\r\n" + 
			"(3254,'OSTEOPATA'),\r\n" + 
			"(3255,'OSTRERO'),\r\n" + 
			"(3256,'OSTRICULTOR'),\r\n" + 
			"(3257,'OTORRINOLARINGOLOGO'),\r\n" + 
			"(3258,'OTROS APAREJADORES Y EMPALMADORES DE CABLES,EXCEPTO DE TELE'),\r\n" + 
			"(3259,'OTROS CONDUCTORES DE MAQUINA PARA EL MOVIMIENTO DE TIERRAS'),\r\n" + 
			"(3260,'OTROS GALVANIZADORES Y RECUBRIDORES DE METALES'),\r\n" + 
			"(3261,'OTROS INSTALADORES DE MATER.AISLANTES DE INSONORIZACION'),\r\n" + 
			"(3262,'OTROS JEFES DE TREN, COBRADORES.'),\r\n" + 
			"(3263,'OTROS OBREROS DE LA FABRICACION DE PROD. DERIVADOS'),\r\n" + 
			"(3264,'OTROS OPERADOR DE MAQUINAS FIJAS Y DE INSTALACIONES SIMILAR'),\r\n" + 
			"(3265,'OTROS OPERADORES DE INSTALACIONES DE PRODUCCION DE ENERGIA'),\r\n" + 
			"(3266,'OTROS OPERADORES DE MAQUINAS PARA EL TRATAMIENTO AUTOMATICO'),\r\n" + 
			"(3267,'OTROS OPERADORES DE PRENSA DE IMPRIMIR'),\r\n" + 
			"(3268,'OTROS SONDISTAS Y TRABAJADORES ASIMILADOS'),\r\n" + 
			"(3269,'OTROS TECHADORES'),\r\n" + 
			"(3270,'OTROS, ACTORES Y DIRECTORES DE CINE, RADIO, TEATRO, TELEVIS'),\r\n" + 
			"(3271,'OTROS, ATLETAS, DEPORTISTAS Y AFINES'),\r\n" + 
			"(3272,'OTROS, COMERCIANTES VENDEDORES AL POR MENOR (NO AMBULATORIO'),\r\n" + 
			"(3273,'OTROS, COMPOSITORES, MUSICOS Y CANTANTES'),\r\n" + 
			"(3274,'OTROS, PAYASOS, ACROBATAS Y AFINES'),\r\n" + 
			"(3275,'OVILLADOR, TEXTIL'),\r\n" + 
			"(3276,'OXICORTADOR EN GENERAL, A MANO O A MAQUINA'),\r\n" + 
			"(3277,'PAGADOR GENERAL, ADMINISTRACION PUBLICA'),\r\n" + 
			"(3278,'PAISAJISTA'),\r\n" + 
			"(3279,'PALEONTOLOGO');", nativeQuery = true)
	void insertarOcupacion3();
	
@Query(value="insert into ocupacion(id_ocupacion, descripcion) VALUES (3280,'PALERO, MINAS')," + 
			"(3281,'PALMERO, OBRERO AGRICOLA'),\r\n" + 
			"(3282,'PANADERO-PASTELERO,EN GENERAL'),\r\n" + 
			"(3283,'PANOLERO DE CUBIERTA'),\r\n" + 
			"(3284,'PANTALONERO, CONFECCION EN SERIE'),\r\n" + 
			"(3285,'PANTOGRAFISTA, IMPRENTA'),\r\n" + 
			"(3286,'PAPELERO, FABRICACION A MANO'),\r\n" + 
			"(3287,'PARAGUERO'),\r\n" + 
			"(3288,'PARAMEDICOS'),\r\n" + 
			"(3289,'PARASITOLOGO'),\r\n" + 
			"(3290,'PAREJA DE BAILE'),\r\n" + 
			"(3291,'PARQUETERO, COLOCA PISOS DE PARQUET'),\r\n" + 
			"(3292,'PARROCO'),\r\n" + 
			"(3293,'PARTERA PRACTICA'),\r\n" + 
			"(3294,'PASADOR, IMPRENTA'),\r\n" + 
			"(3295,'PASAMANERO A MANO'),\r\n" + 
			"(3296,'PASAMANERO A MAQUINA'),\r\n" + 
			"(3297,'PASANTE, ABOGADO'),\r\n" + 
			"(3298,'PASANTE, ESCRIBANO'),\r\n" + 
			"(3299,'PASANTE, NOTARIO'),\r\n" + 
			"(3300,'PASTA DE PAPEL LAURENTE'),\r\n" + 
			"(3301,'PASTELERO, PREPARADOR'),\r\n" + 
			"(3302,'PASTELISTA'),\r\n" + 
			"(3303,'PASTEURIZADOR DE LECHE Y PRODUCTOS LACTEOS'),\r\n" + 
			"(3304,'PASTOR MOCHILERO'),\r\n" + 
			"(3305,'PASTOR PROTESTANTE'),\r\n" + 
			"(3306,'PATRON DE PUERTO,DIQUE SECO'),\r\n" + 
			"(3307,'PATRON, BARCO/NAVEGACION INTERIOR'),\r\n" + 
			"(3308,'PATRON, BARCO/NAVEGACION MARITIMA'),\r\n" + 
			"(3309,'PATRON, BOLICHERA'),\r\n" + 
			"(3310,'PATRON, PUERTO'),\r\n" + 
			"(3311,'PATRON, REMOLCADOR'),\r\n" + 
			"(3312,'PATRON, YATE'),\r\n" + 
			"(3313,'PATRONISTA DE ROPA BLANCA'),\r\n" + 
			"(3314,'PATRONISTA DE TELA DE PARAGUAS'),\r\n" + 
			"(3315,'PATRONISTA DE VELAS DE EMBARCACIONES'),\r\n" + 
			"(3316,'PATRONISTA DEL CALZADO'),\r\n" + 
			"(3317,'PATRONISTA PRENDAS VESTIR, LENCERIA, SOMBREROS, GORROS'),\r\n" + 
			"(3318,'PATRONISTA TIENDAS CAMPAÐA,TOLDOS,SOMBRILLAS'),\r\n" + 
			"(3319,'PAVIMENTADOR'),\r\n" + 
			"(3320,'PAVONADOR DE METALES'),\r\n" + 
			"(3321,'PAYASO'),\r\n" + 
			"(3322,'PEDIATRA'),\r\n" + 
			"(3323,'PEDICURISTA'),\r\n" + 
			"(3324,'PEDRERO'),\r\n" + 
			"(3325,'PEGADOR DE CARTELES'),\r\n" + 
			"(3326,'PEGADOR, MINAS Y CANTERAS'),\r\n" + 
			"(3327,'PEGADOR, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(3328,'PEINADOR DE FIBRA'),\r\n" + 
			"(3329,'PEINADORA'),\r\n" + 
			"(3330,'PELADOR DE CAMARONES'),\r\n" + 
			"(3331,'PELADOR DE CUEROS A MANO'),\r\n" + 
			"(3332,'PELADOR DE CUEROS Y PELLEJOS A MAQUINA'),\r\n" + 
			"(3333,'PELADOR DE FRUTAS Y HORTALIZAS,PARA CONSERVAS'),\r\n" + 
			"(3334,'PELADOR DE MANI'),\r\n" + 
			"(3335,'PELADOR DE POLLOS, GALLINAS Y OTRAS AVES'),\r\n" + 
			"(3336,'PELAMBRERO'),\r\n" + 
			"(3337,'PELETERO'),\r\n" + 
			"(3338,'PELLEJERO, CURTIDOR'),\r\n" + 
			"(3339,'PELOTERO, TEXTIL'),\r\n" + 
			"(3340,'PELUQUERO, CABALLEROS'),\r\n" + 
			"(3341,'PELUQUERO, SEÑORAS'),\r\n" + 
			"(3342,'PELUQUERO-BARBERO'),\r\n" + 
			"(3343,'PEON AGRICOLA EN GENERAL'),\r\n" + 
			"(3344,'PEON AGRICOLA, COSECHADOR/ALGODON'),\r\n" + 
			"(3345,'PEON AGRICOLA, COSECHADOR/FRUTAS'),\r\n" + 
			"(3346,'PEON AGRICOLA, COSECHADOR/TE'),\r\n" + 
			"(3347,'PEON AGRICOLA, CULTIVO EXTENSIVO'),\r\n" + 
			"(3348,'PEON AGRICOLA, HORTALIZAS'),\r\n" + 
			"(3349,'PEON AGRICOLA, PAPERO'),\r\n" + 
			"(3350,'PEON AGROPECUARIO'),\r\n" + 
			"(3351,'PEON AGROPECUARIO, ANIMALES DE PELETERIA'),\r\n" + 
			"(3352,'PEON AGROPECUARIO, CRIA DE ANIMALES DE PIEL'),\r\n" + 
			"(3353,'PEON AGROPECUARIO, ESTACIONAL'),\r\n" + 
			"(3354,'PEON AGROPECUARIO, GANADO'),\r\n" + 
			"(3355,'PEON AGROPECUARIO, GANADO EQUINO'),\r\n" + 
			"(3356,'PEON AGROPECUARIO, GUSANOS DE SEDA'),\r\n" + 
			"(3357,'PEON AGROPECUARIO, MIGRANTE'),\r\n" + 
			"(3358,'PEON AGROPECUARIO, ORDEÐADOR/GANADO LECHERO'),\r\n" + 
			"(3359,'PEON AGROPECUARIO, TEMPORERO'),\r\n" + 
			"(3360,'PEON BRACERO'),\r\n" + 
			"(3361,'PEON CAMINERO'),\r\n" + 
			"(3362,'PEON CARBONERO'),\r\n" + 
			"(3363,'PEON CAVADOR, FOSOS'),\r\n" + 
			"(3364,'PEON CAVADOR, POZOS DE AGUA'),\r\n" + 
			"(3365,'PEON CAVADOR, SEPULTURAS, SEPULTURERO, ENTERRADOR'),\r\n" + 
			"(3366,'PEON CAZADOR'),\r\n" + 
			"(3367,'PEON CONSTRUCCION'),\r\n" + 
			"(3368,'PEON CONSTRUCCION/CARRETERAS'),\r\n" + 
			"(3369,'PEON CONSTRUCCION/DIQUES'),\r\n" + 
			"(3370,'PEON DE CARGA, AVIONES'),\r\n" + 
			"(3371,'PEON DE CARGA, BUQUES'),\r\n" + 
			"(3372,'PEON DE CARGA, BUQUES CISTERNA/GASES'),\r\n" + 
			"(3373,'PEON DE CARGA, BUQUES CISTERNA/LIQUIDOS'),\r\n" + 
			"(3374,'PEON DE CARGA, EMPRESAS DE MUDANZAS'),\r\n" + 
			"(3375,'PEON DE ESTANCIA O HACIENDA'),\r\n" + 
			"(3376,'PEON DE LABRANZA'),\r\n" + 
			"(3377,'PEON DE LABRANZA, ARBORICULTOR'),\r\n" + 
			"(3378,'PEON DE LABRANZA, CITRICOS'),\r\n" + 
			"(3379,'PEON DE LABRANZA, COSECHADOR'),\r\n" + 
			"(3380,'PEON DE LABRANZA, COSECHADOR/ALGODON'),\r\n" + 
			"(3381,'PEON DE LABRANZA, COSECHADOR/FRUTOS'),\r\n" + 
			"(3382,'PEON DE LABRANZA, COSECHADOR/HUERTOS'),\r\n" + 
			"(3383,'PEON DE LABRANZA, COSECHADOR/TE'),\r\n" + 
			"(3384,'PEON DE LABRANZA, CRIA DE GANADO'),\r\n" + 
			"(3385,'PEON DE LABRANZA, CULTIVO EXTENSIVO'),\r\n" + 
			"(3386,'PEON DE LABRANZA, GANADO'),\r\n" + 
			"(3387,'PEON DE LABRANZA, GANADO BOVINO'),\r\n" + 
			"(3388,'PEON DE LABRANZA, GANADO OVINO'),\r\n" + 
			"(3389,'PEON DE LIMPIEZA DE: AERONAVES, AUTOBUSES, FABRICAS ETC.'),\r\n" + 
			"(3390,'PEON DE TORRE, PETROLEO'),\r\n" + 
			"(3391,'PEON EN GENERAL'),\r\n" + 
			"(3392,'PEON FERROCARRILLERO, BALASTO'),\r\n" + 
			"(3393,'PEON FORESTAL'),\r\n" + 
			"(3394,'PEON GENERAL'),\r\n" + 
			"(3395,'PEON PORTUARIO'),\r\n" + 
			"(3396,'PEON TRAMPERO'),\r\n" + 
			"(3397,'PEON, ALBAÐILERIA Y AYUDANTE DE ALBAÑIL'),\r\n" + 
			"(3398,'PEON, ARMADO'),\r\n" + 
			"(3399,'PEON, CANTERAS'),\r\n" + 
			"(3400,'PEON, CLASIFICACION/BOTELLAS'),\r\n" + 
			"(3401,'PEON, DE BREGA'),\r\n" + 
			"(3402,'PEON, DE BRIGADA FERROCARRILES'),\r\n" + 
			"(3403,'PEON, DEMOLICION'),\r\n" + 
			"(3404,'PEON, ENROLLADOR DE BOBINAS/A MANO'),\r\n" + 
			"(3405,'PEON, ENROLLADOR DE FILAMENTOS/A MANO'),\r\n" + 
			"(3406,'PEON, ENROLLADOR DE RESORTES/A MANO'),\r\n" + 
			"(3407,'PEON, INDUSTRIA VINICOLA'),\r\n" + 
			"(3408,'PEON, INDUSTRIAS MANUFACTURERAS'),\r\n" + 
			"(3409,'PEÓN, LAVADOR DE MINERALES'),\r\n" + 
			"(3410,'PEÓN, LAVADOR DE ORO'),\r\n" + 
			"(3411,'PEÓN, LIMPIADOR DE PESCADO'),\r\n" + 
			"(3412,'PEON, MINAS O CANTERAS'),\r\n" + 
			"(3413,'PEON, OPERACIONES DE MONTAJE MANUAL'),\r\n" + 
			"(3414,'PEON, RECOLECCION DE DESECHOS'),\r\n" + 
			"(3415,'PEON, SUMINISTRO DE ELECTRICIDAD, GAS Y AGUA'),\r\n" + 
			"(3416,'PEON, TAREAS DIVERSAS'),\r\n" + 
			"(3417,'PERCHADOR DE TEXTILES'),\r\n" + 
			"(3418,'PERCUSIONISTA'),\r\n" + 
			"(3419,'PERFORADOR CON APARATO ROTATIVO, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(3420,'PERFORADOR DE PIEDRAS'),\r\n" + 
			"(3421,'PERFORADOR DE POZOS ARTESIANOS'),\r\n" + 
			"(3422,'PERFORADOR DE POZOS DE AGUA'),\r\n" + 
			"(3423,'PERFORADOR DE POZOS PETROLIFEROS'),\r\n" + 
			"(3424,'PERFORADORES DE MINAS'),\r\n" + 
			"(3425,'PERIODISTA'),\r\n" + 
			"(3426,'PERIODISTA REPORTERO'),\r\n" + 
			"(3427,'PERIODISTA, RADIO'),\r\n" + 
			"(3428,'PERIODISTA, TELEVISION'),\r\n" + 
			"(3429,'PERITO AGRICOLA'),\r\n" + 
			"(3430,'PERITO CONTABLE'),\r\n" + 
			"(3431,'PESADOR DE GRANOS'),\r\n" + 
			"(3432,'PESCADERO, LIMPIADOR DE PESCADO'),\r\n" + 
			"(3433,'PESCADOR ARTESANAL'),\r\n" + 
			"(3434,'PESCADOR DE ALTURA'),\r\n" + 
			"(3435,'PESCADOR DE BAJURA'),\r\n" + 
			"(3436,'PESCADOR DE BOLICHERA'),\r\n" + 
			"(3437,'PESCADOR DE LAGO'),\r\n" + 
			"(3438,'PESCADOR DE RIO'),\r\n" + 
			"(3439,'PESCADOR, AGUA DULCE'),\r\n" + 
			"(3440,'PESCADOR, ATUNERO'),\r\n" + 
			"(3441,'PESCADOR, COSTERO'),\r\n" + 
			"(3442,'PESCADOR, ESPONJAS'),\r\n" + 
			"(3443,'PESCADOR, MARISCADOR'),\r\n" + 
			"(3444,'PESCADOR, MEJILLONERO'),\r\n" + 
			"(3445,'PESCADOR, OSTRAS PERLIFERAS'),\r\n" + 
			"(3446,'PESCADOR, RASTRA'),\r\n" + 
			"(3447,'PESCADOR, SUBSISTENCIA'),\r\n" + 
			"(3448,'PETROLOGO'),\r\n" + 
			"(3449,'PIANISTA'),\r\n" + 
			"(3450,'PICADOR CON MARTILLO NEUMATICO, CONSTRUCCION'),\r\n" + 
			"(3451,'PICADOR DE CARTONES JACQUARD'),\r\n" + 
			"(3452,'PICADOR DE ESTARCIDORES,SERICIGRAFIA'),\r\n" + 
			"(3453,'PICADOR DE TABACO'),\r\n" + 
			"(3454,'PICADOR, MINAS'),\r\n" + 
			"(3455,'PICADOR, TOROS'),\r\n" + 
			"(3456,'PICAPEDRERO'),\r\n" + 
			"(3457,'PILATERO O BATANERO'),\r\n" + 
			"(3458,'PILOTO, AERODESLIZADOR'),\r\n" + 
			"(3459,'PILOTO, AERONAVE/TRANSPORTE AEREO'),\r\n" + 
			"(3460,'PILOTO, CARRERAS/AUTOMOVILES'),\r\n" + 
			"(3461,'PILOTO, COSTERO'),\r\n" + 
			"(3462,'PILOTO, DESLIZADOR'),\r\n" + 
			"(3463,'PILOTO, FUMIGACION'),\r\n" + 
			"(3464,'PILOTO, HELICOPTERO'),\r\n" + 
			"(3465,'PILOTO, HIDROAVION'),\r\n" + 
			"(3466,'PILOTO, HIDROPLANO'),\r\n" + 
			"(3467,'PILOTO, INSTRUCTOR'),\r\n" + 
			"(3468,'PILOTO, PRUEBAS/AERONAUTICA'),\r\n" + 
			"(3469,'PILOTO-PRACTICO NAVEGACION'),\r\n" + 
			"(3470,'PINTOR A PINCEL Y RODILLO,EXCEPTO EDIFICIO Y CONSTRUC.'),\r\n" + 
			"(3471,'PINTOR A PISTOLA,DE LOZA Y PORCELANA'),\r\n" + 
			"(3472,'PINTOR A PISTOLA,EXCEPTO DE EDIF.Y CONSTRUCION'),\r\n" + 
			"(3473,'PINTOR DE AUTOMOVILES'),\r\n" + 
			"(3474,'PINTOR DE BANDAS SOBRE CALLES Y CAMINOS'),\r\n" + 
			"(3475,'PINTOR DE COCHES DE VIAJEROS Y VAGONES, FERROCARRILES'),\r\n" + 
			"(3476,'PINTOR DE CONSTRUC.METALICAS Y CASCOS Y BUQUES'),\r\n" + 
			"(3477,'PINTOR DE CONSTRUCCION ESCENICAS,CINEMATOGRAFIA'),\r\n" + 
			"(3478,'PINTOR DE CONSTRUCCION, CONSERVACION'),\r\n" + 
			"(3479,'PINTOR DE DECORADOR DE FONDO,TEATRO,CINE'),\r\n" + 
			"(3480,'PINTOR DE LETREROS Y ROTULOS'),\r\n" + 
			"(3481,'PINTOR DE ROTULOS'),\r\n" + 
			"(3482,'PINTOR POR INMERSION'),\r\n" + 
			"(3483,'PINTOR RETOCADOR DE AUTOMOV., CARROC. DE PRODUCTOS EN SERIE'),\r\n" + 
			"(3484,'PINTOR, AGUA FUERTE'),\r\n" + 
			"(3485,'PINTOR, PINTURA ABSTRACTA'),\r\n" + 
			"(3486,'PINTOR, PINTURA FIGURATIVA'),\r\n" + 
			"(3487,'PINTOR, TATUAJES'),\r\n" + 
			"(3488,'PINTOR-PULVERIZADOR,FABRICACION DE AUTOMOVILES'),\r\n" + 
			"(3489,'PIPERO, PIPAS DE FUMAR'),\r\n" + 
			"(3490,'PISADOR DE UVA'),\r\n" + 
			"(3491,'PISCICULTOR CRIADORES DE ESPECIES ACUATICAS'),\r\n" + 
			"(3492,'PISCICULTOR DE LAS CIENCIAS BIOLOGICAS'),\r\n" + 
			"(3493,'PISICULTOR DE TRUCHAS'),\r\n" + 
			"(3494,'PLANCHADOR DE CARROCERIAS DE VEHICULOS'),\r\n" + 
			"(3495,'PLANCHADOR DE GENEROS ACABADOS'),\r\n" + 
			"(3496,'PLANCHADOR, A MANO'),\r\n" + 
			"(3497,'PLANIFICADOR, TRANSITO'),\r\n" + 
			"(3498,'PLANIFICADORES'),\r\n" + 
			"(3499,'PLANTADOR, ARBOLES/SILVICULTURA'),\r\n" + 
			"(3500,'PLATEADOR'),\r\n" + 
			"(3501,'PLATERIA, GRABADOR'),\r\n" + 
			"(3502,'PLATERO Y ORFEBRE'),\r\n" + 
			"(3503,'PLATINERO, COMPAGINACION'),\r\n" + 
			"(3504,'PLEGADOR DE HILOS'),\r\n" + 
			"(3505,'PLISADOR DE PAPEL'),\r\n" + 
			"(3506,'PLOMERO'),\r\n" + 
			"(3507,'POCERO'),\r\n" + 
			"(3508,'PODADOR, ARBOLES FRUTALES'),\r\n" + 
			"(3509,'PODADOR, SILVICULTURA'),\r\n" + 
			"(3510,'PODADOR-INJERTADOR, ARBUSTOS'),\r\n" + 
			"(3511,'PODOLOGO'),\r\n" + 
			"(3512,'POETA'),\r\n" + 
			"(3513,'POLICIA MUNICIPAL'),\r\n" + 
			"(3514,'POLICIA NACIONAL, OFICIALES'),\r\n" + 
			"(3515,'POLICIA NACIONAL, SUB OFICIALES'),\r\n" + 
			"(3516,'POLICIA NACIONAL, TECNICOS'),\r\n" + 
			"(3517,'POLICIA NO ESPECIFICADO'),\r\n" + 
			"(3518,'POLICIA PARTICULAR'),\r\n" + 
			"(3519,'POLITOLOGO'),\r\n" + 
			"(3520,'POOJARI'),\r\n" + 
			"(3521,'PORQUERIZO'),\r\n" + 
			"(3522,'PORTAMIRAS, TOPOGRAFIA'),\r\n" + 
			"(3523,'PORTAPLIEGO DE OFICINA'),\r\n" + 
			"(3524,'PORTAVENTANERO'),\r\n" + 
			"(3525,'PORTERO'),\r\n" + 
			"(3526,'PORTERO, HOTEL'),\r\n" + 
			"(3527,'PORTERO, HOTEL/VESTIBULO DE RECEPCION'),\r\n" + 
			"(3528,'PORTERO-CUIDADOR'),\r\n" + 
			"(3529,'PORTERO-CUIDADOR, ESTABLECIMIENTO RELIGIOSO'),\r\n" + 
			"(3530,'PRACTICANTE DE FARMACIA'),\r\n" + 
			"(3531,'PRACTICANTE DE ODONTOLOGIA'),\r\n" + 
			"(3532,'PRACTICANTE EN MEDICINA'),\r\n" + 
			"(3533,'PRACTICO EN FARMACIA'),\r\n" + 
			"(3534,'PRACTICO, PUERTO'),\r\n" + 
			"(3535,'PREDICADOR, SEGLAR'),\r\n" + 
			"(3536,'PREFECTO'),\r\n" + 
			"(3537,'PRENSADOR DE ADOBES CON TROQUEL'),\r\n" + 
			"(3538,'PRENSADOR DE BRIQUETAS DE CARBON'),\r\n" + 
			"(3539,'PRENSADOR DE CACAO, FABRICACION DE CHOCOLATE'),\r\n" + 
			"(3540,'PRENSADOR DE CERAMICA, CON TROQUEL'),\r\n" + 
			"(3541,'PRENSADOR DE CIGARRILLOS'),\r\n" + 
			"(3542,'PRENSADOR DE TABACO DE MASCAR'),\r\n" + 
			"(3543,'PRENSADOR DE UVA'),\r\n" + 
			"(3544,'PREPARADOR CERAMICA EN MOLDES, PASTA DE ARCILLA'),\r\n" + 
			"(3545,'PREPARADOR DE ADOBES'),\r\n" + 
			"(3546,'PREPARADOR DE ALIMENTOS CONCENTRADOS'),\r\n" + 
			"(3547,'PREPARADOR DE ALMIDON'),\r\n" + 
			"(3548,'PREPARADOR DE APRESTOS TEXTILES'),\r\n" + 
			"(3549,'PREPARADOR DE BARBOTIN'),\r\n" + 
			"(3550,'PREPARADOR DE BEBIDAS CARBONICAS Y JARABES'),\r\n" + 
			"(3551,'PREPARADOR DE BOCADITOS ENVASADOS(PAPA FRITA,CAMOTE,ETC)'),\r\n" + 
			"(3552,'PREPARADOR DE BRAILLE, PLANCHAS DE IMPRENTA'),\r\n" + 
			"(3553,'PREPARADOR DE CAJA DE SECADO,HORNO DE CERAMICA'),\r\n" + 
			"(3554,'PREPARADOR DE CHARQUI'),\r\n" + 
			"(3555,'PREPARADOR DE ESTARCIDORES,SERICIGRAFIA'),\r\n" + 
			"(3556,'PREPARADOR DE ESTRUCTURAS DE ACERO EN TALLER'),\r\n" + 
			"(3557,'PREPARADOR DE FIBRA DE VIDRIO'),\r\n" + 
			"(3558,'PREPARADOR DE FIELTRO, A MAQUINA'),\r\n" + 
			"(3559,'PREPARADOR DE GLUCOSA'),\r\n" + 
			"(3560,'PREPARADOR DE JAMONES O JAMONERO'),\r\n" + 
			"(3561,'PREPARADOR DE LECHE CONDENSADA'),\r\n" + 
			"(3562,'PREPARADOR DE MANJARBLANCO Y NATILLAS'),\r\n" + 
			"(3563,'PREPARADOR DE MARGARINA'),\r\n" + 
			"(3564,'PREPARADOR DE MERMELADAS'),\r\n" + 
			"(3565,'PREPARADOR DE MOLDES A MAQUINA'),\r\n" + 
			"(3566,'PREPARADOR DE MOLDES EN EL SUELO Y EN FOSAS'),\r\n" + 
			"(3567,'PREPARADOR DE MOLDES SOBRE BANCO'),\r\n" + 
			"(3568,'PREPARADOR DE MOLDES, CERAMICA, LOZA Y PORCELANA'),\r\n" + 
			"(3569,'PREPARADOR DE PALAS DE CALZADO'),\r\n" + 
			"(3570,'PREPARADOR DE PANELES DE PLASTICO'),\r\n" + 
			"(3571,'PREPARADOR DE PASTAS ALIMENTICIAS'),\r\n" + 
			"(3572,'PREPARADOR DE PICADURA DE TABACO PARA PIPA'),\r\n" + 
			"(3573,'PREPARADOR DE PIGMENTOS'),\r\n" + 
			"(3574,'PREPARADOR DE PLACAS FOTOGRAFICAS'),\r\n" + 
			"(3575,'PREPARADOR DE PLANCHAS DE IMPRENTA BRAILLE'),\r\n" + 
			"(3576,'PREPARADOR DE RAPE'),\r\n" + 
			"(3577,'PREPARADOR DE SUELAS'),\r\n" + 
			"(3578,'PREPARADOR DE TAMALES'),\r\n" + 
			"(3579,'PREPARADOR DE YOUGURT Y CREMAS'),\r\n" + 
			"(3580,'PREPARADOR PASTAS PASTELERIA EN MOLDES A MAQUINA'),\r\n" + 
			"(3581,'PRESENTADOR-ANIMADOR'),\r\n" + 
			"(3582,'PRESENTADOR-ANIMADOR, ESPECTACULOS PUBLICOS'),\r\n" + 
			"(3583,'PRESIDENTE DE GOBIERNO REGIONAL'),\r\n" + 
			"(3584,'PRESIDENTE DE LA CORTE SUPREMA'),\r\n" + 
			"(3585,'PRESIDENTE DE LA REPUBLICA'),\r\n" + 
			"(3586,'PRESIDENTE DEL DIRECTORIO, AGRICULTURA, CAZA, SILVICULTURA'),\r\n" + 
			"(3587,'PRESIDENTE DEL DIRECTORIO, COMERCIO MAYORISTA Y MINORISTA,'),\r\n" + 
			"(3588,'PRESIDENTE DEL DIRECTORIO, CONTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(3589,'PRESIDENTE DEL DIRECTORIO, INDUSTRIAS MANUFACTURERAS, MINAS'),\r\n" + 
			"(3590,'PRESIDENTE DEL DIRECTORIO, RESTAURANTES Y HOTELERIA'),\r\n" + 
			"(3591,'PRESIDENTE DEL DIRECTORIO, SERVICIOS PUBLICOS Y FINANCIEROS'),\r\n" + 
			"(3592,'PRESIDENTE DEL DIRECTORIO, TRANSPORTE, ALMACENAMIENTO Y COM'),\r\n" + 
			"(3593,'PRESIDENTE, CAMARA DE DIPUTADOS'),\r\n" + 
			"(3594,'PRESIDENTE, CAMARA DE SENADORES'),\r\n" + 
			"(3595,'PRESIDENTE, CONGRESO CONSTITUYENTE DEMOCRATICO (CCD)'),\r\n" + 
			"(3596,'PRESIDENTE, TRIBUNAL DE JUSTICIA'),\r\n" + 
			"(3597,'PRESTAMISTA, DINERO'),\r\n" + 
			"(3598,'PRESTAMISTA, PRENDARIO'),\r\n" + 
			"(3599,'PRESTIDIGITADOR'),\r\n" + 
			"(3600,'PRIMER MINISTRO'),\r\n" + 
			"(3601,'PRIMER OFICIAL, MAQUINISTA/BARCO'),\r\n" + 
			"(3602,'PRIOR'),\r\n" + 
			"(3603,'PROBADOR DE AUTOMOVILES,REPARACIONES'),\r\n" + 
			"(3604,'PROCURADOR'),\r\n" + 
			"(3605,'PROCURADOR GENERAL'),\r\n" + 
			"(3606,'PRODUCTOR, CINE'),\r\n" + 
			"(3607,'PRODUCTOR, CULTIVOS EXTENSIVOS'),\r\n" + 
			"(3608,'PRODUCTOR, HORTALIZAS/CULTIVO EXTENSIVO'),\r\n" + 
			"(3609,'PRODUCTOR, RADIO'),\r\n" + 
			"(3610,'PRODUCTOR, REMOLACHA AZUCARERA'),\r\n" + 
			"(3611,'PRODUCTOR, SOYA'),\r\n" + 
			"(3612,'PRODUCTOR, TEATRO'),\r\n" + 
			"(3613,'PRODUCTOR, TELEVISION'),\r\n" + 
			"(3614,'PROFESIONAL EN HOTELERIA'),\r\n" + 
			"(3615,'PROFESIONAL EN TURISMO'),\r\n" + 
			"(3616,'PROFESOR ALFABETIZADOR'),\r\n" + 
			"(3617,'PROFESOR DE ACADEMIA'),\r\n" + 
			"(3618,'PROFESOR DE ALUMNOS FISICAMENTE DEFICIENTES'),\r\n" + 
			"(3619,'PROFESOR DE ALUMNOS MENTALMENTE DEFICIENTES'),\r\n" + 
			"(3620,'PROFESOR DE BAILE'),\r\n" + 
			"(3621,'PROFESOR DE CENECAPE'),\r\n" + 
			"(3622,'PROFESOR DE CIEGOS'),\r\n" + 
			"(3623,'PROFESOR DE EDUCACION INICIAL (PRE-ESCOLAR)'),\r\n" + 
			"(3624,'PROFESOR DE ENSEÑANZA PRIMARIA'),\r\n" + 
			"(3625,'PROFESOR DE IDIOMAS'),\r\n" + 
			"(3626,'PROFESOR DE MUDOS'),\r\n" + 
			"(3627,'PROFESOR DE NIÑOS EXCEPCIONALES'),\r\n" + 
			"(3628,'PROFESOR DE SENATI Y TECSUP'),\r\n" + 
			"(3629,'PROFESOR DE SORDOS'),\r\n" + 
			"(3630,'PROFESOR DE TALLERES, OTROS'),\r\n" + 
			"(3631,'PROFESOR(A) DE ESCUELA MATERNAL O CUNA (GUARDERIA)'),\r\n" + 
			"(3632,'PROFESOR(A) DE JARDIN DE INFANCIA'),\r\n" + 
			"(3633,'PROFESOR(A) DE PARVULOS'),\r\n" + 
			"(3634,'PROFESOR, AJEDREZ'),\r\n" + 
			"(3635,'PROFESOR, BILLAR'),\r\n" + 
			"(3636,'PROFESOR, EDUCACION SECUNDARIA'),\r\n" + 
			"(3637,'PROFESOR, EDUCACION SECUNDARIA/AGRICULTURA'),\r\n" + 
			"(3638,'PROFESOR, EDUCACION SECUNDARIA/ALFABETIZACION DE ADULTOS'),\r\n" + 
			"(3639,'PROFESOR, EDUCACION SECUNDARIA/ARTE-OFICIOS'),\r\n" + 
			"(3640,'PROFESOR, EDUCACION SECUNDARIA/ARTES MANUALES'),\r\n" + 
			"(3641,'PROFESOR, EDUCACION SECUNDARIA/ARTESANIA'),\r\n" + 
			"(3642,'PROFESOR, EDUCACION SECUNDARIA/BELLAS ARTES'),\r\n" + 
			"(3643,'PROFESOR, EDUCACION SECUNDARIA/BIOLOGIA'),\r\n" + 
			"(3644,'PROFESOR, EDUCACION SECUNDARIA/BOTANICA'),\r\n" + 
			"(3645,'PROFESOR, EDUCACION SECUNDARIA/CIENCIAS NATURALES'),\r\n" + 
			"(3646,'PROFESOR, EDUCACION SECUNDARIA/CIENCIAS SOCIALES'),\r\n" + 
			"(3647,'PROFESOR, EDUCACION SECUNDARIA/COMERCIO Y SECRETARIADO'),\r\n" + 
			"(3648,'PROFESOR, EDUCACION SECUNDARIA/CONTABILIDAD MERCANTIL'),\r\n" + 
			"(3649,'PROFESOR, EDUCACION SECUNDARIA/COSTURA'),\r\n" + 
			"(3650,'PROFESOR, EDUCACION SECUNDARIA/DIBUJO TECNICO'),\r\n" + 
			"(3651,'PROFESOR, EDUCACION SECUNDARIA/EBANISTERIA'),\r\n" + 
			"(3652,'PROFESOR, EDUCACION SECUNDARIA/ECONOMIA DOMESTICA'),\r\n" + 
			"(3653,'PROFESOR, EDUCACION SECUNDARIA/EDUCACION CIVICA'),\r\n" + 
			"(3654,'PROFESOR, EDUCACION SECUNDARIA/EDUCACION FISICA'),\r\n" + 
			"(3655,'PROFESOR, EDUCACION SECUNDARIA/ENFERMERIA BASICA'),\r\n" + 
			"(3656,'PROFESOR, EDUCACION SECUNDARIA/FILOSOFIA'),\r\n" + 
			"(3657,'PROFESOR, EDUCACION SECUNDARIA/FISICA'),\r\n" + 
			"(3658,'PROFESOR, EDUCACION SECUNDARIA/FORMACION PROFESIONAL'),\r\n" + 
			"(3659,'PROFESOR, EDUCACION SECUNDARIA/GEOGRAFIA'),\r\n" + 
			"(3660,'PROFESOR, EDUCACION SECUNDARIA/GEOLOGIA'),\r\n" + 
			"(3661,'PROFESOR, EDUCACION SECUNDARIA/HISTORIA'),\r\n" + 
			"(3662,'PROFESOR, EDUCACION SECUNDARIA/HISTORIA DEL ARTE'),\r\n" + 
			"(3663,'PROFESOR, EDUCACION SECUNDARIA/LABORES'),\r\n" + 
			"(3664,'PROFESOR, EDUCACION SECUNDARIA/LABRA (METALES)'),\r\n" + 
			"(3665,'PROFESOR, EDUCACION SECUNDARIA/LENGUA Y LITERATURA'),\r\n" + 
			"(3666,'PROFESOR, EDUCACION SECUNDARIA/LITERATURA'),\r\n" + 
			"(3667,'PROFESOR, EDUCACION SECUNDARIA/MECANICA'),\r\n" + 
			"(3668,'PROFESOR, EDUCACION SECUNDARIA/MECANOGRAFIA'),\r\n" + 
			"(3669,'PROFESOR, EDUCACION SECUNDARIA/MUSICA'),\r\n" + 
			"(3670,'PROFESOR, EDUCACION SECUNDARIA/OTROS'),\r\n" + 
			"(3671,'PROFESOR, EDUCACION SECUNDARIA/PEDAGOGIA'),\r\n" + 
			"(3672,'PROFESOR, EDUCACION SECUNDARIA/PROGRAMACION DE COMPUTADORAS'),\r\n" + 
			"(3673,'PROFESOR, EDUCACION SECUNDARIA/QUIMICA'),\r\n" + 
			"(3674,'PROFESOR, EDUCACION SECUNDARIA/RELIGION'),\r\n" + 
			"(3675,'PROFESOR, EDUCACION SECUNDARIA/SECRETARIADO'),\r\n" + 
			"(3676,'PROFESOR, EDUCACION SECUNDARIA/SOCIOLOGIA'),\r\n" + 
			"(3677,'PROFESOR, EDUCACION SECUNDARIA/TALLA (MADERA)'),\r\n" + 
			"(3678,'PROFESOR, EDUCACION SECUNDARIA/TAQUIGRAFIA'),\r\n" + 
			"(3679,'PROFESOR, EDUCACION SECUNDARIA/TECNICA'),\r\n" + 
			"(3680,'PROFESOR, EDUCACION SECUNDARIA/TECNOLOGICA'),\r\n" + 
			"(3681,'PROFESOR, EDUCACION SECUNDARIA/ZOOLOGIA'),\r\n" + 
			"(3682,'PROFESOR, EDUCACION SUPERIOR'),\r\n" + 
			"(3683,'PROFESOR, EDUCACION SUPERIOR/ADMINISTRACION'),\r\n" + 
			"(3684,'PROFESOR, EDUCACION SUPERIOR/AGRICULTURA'),\r\n" + 
			"(3685,'PROFESOR, EDUCACION SUPERIOR/AGRONOMIA'),\r\n" + 
			"(3686,'PROFESOR, EDUCACION SUPERIOR/ANATOMIA'),\r\n" + 
			"(3687,'PROFESOR, EDUCACION SUPERIOR/ANTROPOLOGIA'),\r\n" + 
			"(3688,'PROFESOR, EDUCACION SUPERIOR/ARQUEOLOGIA'),\r\n" + 
			"(3689,'PROFESOR, EDUCACION SUPERIOR/ARQUITECTURA'),\r\n" + 
			"(3690,'PROFESOR, EDUCACION SUPERIOR/ARTE DRAMATICO'),\r\n" + 
			"(3691,'PROFESOR, EDUCACION SUPERIOR/ARTES INDUSTRIALES'),\r\n" + 
			"(3692,'PROFESOR, EDUCACION SUPERIOR/ASTRONOMIA'),\r\n" + 
			"(3693,'PROFESOR, EDUCACION SUPERIOR/BACTERIOLOGIA'),\r\n" + 
			"(3694,'PROFESOR, EDUCACION SUPERIOR/BELLAS ARTES'),\r\n" + 
			"(3695,'PROFESOR, EDUCACION SUPERIOR/BIBLIOTECONOMIA'),\r\n" + 
			"(3696,'PROFESOR, EDUCACION SUPERIOR/BIOLOGIA'),\r\n" + 
			"(3697,'PROFESOR, EDUCACION SUPERIOR/BIOQUIMICA'),\r\n" + 
			"(3698,'PROFESOR, EDUCACION SUPERIOR/BOTANICA'),\r\n" + 
			"(3699,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS AGRONOMICAS'),\r\n" + 
			"(3700,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS BIOLOGICAS'),\r\n" + 
			"(3701,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS ECONOMICAS'),\r\n" + 
			"(3702,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS FISICAS Y QUIMICAS'),\r\n" + 
			"(3703,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS FORENSES'),\r\n" + 
			"(3704,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS MATEMATICAS'),\r\n" + 
			"(3705,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS MECANICAS'),\r\n" + 
			"(3706,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS MEDICAS'),\r\n" + 
			"(3707,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS MILITARES'),\r\n" + 
			"(3708,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS POLITICAS'),\r\n" + 
			"(3709,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS SOCIALES'),\r\n" + 
			"(3710,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS'),\r\n" + 
			"(3711,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS (ELECTRICIDA'),\r\n" + 
			"(3712,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS (ELECTRONICA'),\r\n" + 
			"(3713,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS (INGENIERIA'),\r\n" + 
			"(3714,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS (QUIMICA)'),\r\n" + 
			"(3715,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS (TECNOLOGIA'),\r\n" + 
			"(3716,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS (TECNOLOGIA)'),\r\n" + 
			"(3717,'PROFESOR, EDUCACION SUPERIOR/CIENCIAS TECNICAS (TELECOMUNIC'),\r\n" + 
			"(3718,'PROFESOR, EDUCACION SUPERIOR/COMERCIALIZACION'),\r\n" + 
			"(3719,'PROFESOR, EDUCACION SUPERIOR/CONSERVATORIO'),\r\n" + 
			"(3720,'PROFESOR, EDUCACION SUPERIOR/CONTABILIDAD'),\r\n" + 
			"(3721,'PROFESOR, EDUCACION SUPERIOR/COOPERATIVISMO'),\r\n" + 
			"(3722,'PROFESOR, EDUCACION SUPERIOR/CRIA DE GANADO'),\r\n" + 
			"(3723,'PROFESOR, EDUCACION SUPERIOR/DEMOGRAFIA'),\r\n" + 
			"(3724,'PROFESOR, EDUCACION SUPERIOR/DERECHO'),\r\n" + 
			"(3725,'PROFESOR, EDUCACION SUPERIOR/DIBUJO INDUSTRIAL'),\r\n" + 
			"(3726,'PROFESOR, EDUCACION SUPERIOR/DIETETICA'),\r\n" + 
			"(3727,'PROFESOR, EDUCACION SUPERIOR/ECONOMIA'),\r\n" + 
			"(3728,'PROFESOR, EDUCACION SUPERIOR/ECONOMIA DOMESTICA'),\r\n" + 
			"(3729,'PROFESOR, EDUCACION SUPERIOR/ECONOMIA Y COMERCIO'),\r\n" + 
			"(3730,'PROFESOR, EDUCACION SUPERIOR/EDUCACION FISICA'),\r\n" + 
			"(3731,'PROFESOR, EDUCACION SUPERIOR/ELABORACION DE ALIMENTOS'),\r\n" + 
			"(3732,'PROFESOR, EDUCACION SUPERIOR/ENFERMERIA'),\r\n" + 
			"(3733,'PROFESOR, EDUCACION SUPERIOR/ENTOMOLOGIA'),\r\n" + 
			"(3734,'PROFESOR, EDUCACION SUPERIOR/ERGOTERAPIA'),\r\n" + 
			"(3735,'PROFESOR, EDUCACION SUPERIOR/ESCUELA DE POLICIA'),\r\n" + 
			"(3736,'PROFESOR, EDUCACION SUPERIOR/ESCULTURA'),\r\n" + 
			"(3737,'PROFESOR, EDUCACION SUPERIOR/ESPECIALIZADO EN COOP.AGRARIA,'),\r\n" + 
			"(3738,'PROFESOR, EDUCACION SUPERIOR/ESTADISTICA'),\r\n" + 
			"(3739,'PROFESOR, EDUCACION SUPERIOR/ESTUDIOS COMERCIALES'),\r\n" + 
			"(3740,'PROFESOR, EDUCACION SUPERIOR/ESTUDIOS INTERNACIONALES'),\r\n" + 
			"(3741,'PROFESOR, EDUCACION SUPERIOR/FARMACIA'),\r\n" + 
			"(3742,'PROFESOR, EDUCACION SUPERIOR/FARMACOLOGIA'),\r\n" + 
			"(3743,'PROFESOR, EDUCACION SUPERIOR/FILOLOGIA'),\r\n" + 
			"(3744,'PROFESOR, EDUCACION SUPERIOR/FILOSOFIA'),\r\n" + 
			"(3745,'PROFESOR, EDUCACION SUPERIOR/FINANZAS'),\r\n" + 
			"(3746,'PROFESOR, EDUCACION SUPERIOR/FISICA'),\r\n" + 
			"(3747,'PROFESOR, EDUCACION SUPERIOR/FISIOTERAPIA'),\r\n" + 
			"(3748,'PROFESOR, EDUCACION SUPERIOR/GEODESIA'),\r\n" + 
			"(3749,'PROFESOR, EDUCACION SUPERIOR/GEOFISICA'),\r\n" + 
			"(3750,'PROFESOR, EDUCACION SUPERIOR/GEOGRAFIA'),\r\n" + 
			"(3751,'PROFESOR, EDUCACION SUPERIOR/GEOLOGIA'),\r\n" + 
			"(3752,'PROFESOR, EDUCACION SUPERIOR/HISTORIA'),\r\n" + 
			"(3753,'PROFESOR, EDUCACION SUPERIOR/HISTORIA DEL ARTE'),\r\n" + 
			"(3754,'PROFESOR, EDUCACION SUPERIOR/HORTICULTURA'),\r\n" + 
			"(3755,'PROFESOR, EDUCACION SUPERIOR/IDIOMAS Y LINGUISTICA'),\r\n" + 
			"(3756,'PROFESOR, EDUCACION SUPERIOR/INFORMATICA'),\r\n" + 
			"(3757,'PROFESOR, EDUCACION SUPERIOR/INGENIERIA Y ARQUITECTURA'),\r\n" + 
			"(3758,'PROFESOR, EDUCACION SUPERIOR/LENGUA Y LITERATURA'),\r\n" + 
			"(3759,'PROFESOR, EDUCACION SUPERIOR/LETRAS'),\r\n" + 
			"(3760,'PROFESOR, EDUCACION SUPERIOR/LINGUISTICA'),\r\n" + 
			"(3761,'PROFESOR, EDUCACION SUPERIOR/LITERATURA'),\r\n" + 
			"(3762,'PROFESOR, EDUCACION SUPERIOR/MATEMATICAS'),\r\n" + 
			"(3763,'PROFESOR, EDUCACION SUPERIOR/MEDICINA'),\r\n" + 
			"(3764,'PROFESOR, EDUCACION SUPERIOR/MEDICINA FORENSE'),\r\n" + 
			"(3765,'PROFESOR, EDUCACION SUPERIOR/MEDICINA VETERINARIA'),\r\n" + 
			"(3766,'PROFESOR, EDUCACION SUPERIOR/METALURGIA'),\r\n" + 
			"(3767,'PROFESOR, EDUCACION SUPERIOR/METEOROLOGIA'),\r\n" + 
			"(3768,'PROFESOR, EDUCACION SUPERIOR/METODOS DE VENTA'),\r\n" + 
			"(3769,'PROFESOR, EDUCACION SUPERIOR/MINERIA'),\r\n" + 
			"(3770,'PROFESOR, EDUCACION SUPERIOR/MUSICA'),\r\n" + 
			"(3771,'PROFESOR, EDUCACION SUPERIOR/NAVEGACION AEREA'),\r\n" + 
			"(3772,'PROFESOR, EDUCACION SUPERIOR/NAVEGACION MARITIMA'),\r\n" + 
			"(3773,'PROFESOR, EDUCACION SUPERIOR/OBSERVACION METEOROLOGICA'),\r\n" + 
			"(3774,'PROFESOR, EDUCACION SUPERIOR/OBSTETRICIA'),\r\n" + 
			"(3775,'PROFESOR, EDUCACION SUPERIOR/ODONTOLOGIA'),\r\n" + 
			"(3776,'PROFESOR, EDUCACION SUPERIOR/OPTOMETRIA'),\r\n" + 
			"(3777,'PROFESOR, EDUCACION SUPERIOR/OSTEOPATIA'),\r\n" + 
			"(3778,'PROFESOR, EDUCACION SUPERIOR/PATOLOGIA'),\r\n" + 
			"(3779,'PROFESOR, EDUCACION SUPERIOR/PEDAGOGIA'),\r\n" + 
			"(3780,'PROFESOR, EDUCACION SUPERIOR/PERIODISMO'),\r\n" + 
			"(3781,'PROFESOR, EDUCACION SUPERIOR/PESCA'),\r\n" + 
			"(3782,'PROFESOR, EDUCACION SUPERIOR/PINTURA ARTISTICA'),\r\n" + 
			"(3783,'PROFESOR, EDUCACION SUPERIOR/PLANIFICACION FAMILIAR'),\r\n" + 
			"(3784,'PROFESOR, EDUCACION SUPERIOR/PLANIFICACION INDUSTRIAL'),\r\n" + 
			"(3785,'PROFESOR, EDUCACION SUPERIOR/PREHISTORIA'),\r\n" + 
			"(3786,'PROFESOR, EDUCACION SUPERIOR/PROGRAMA DE URBANISMO'),\r\n" + 
			"(3787,'PROFESOR, EDUCACION SUPERIOR/PROGRAMACION DE COMPUTADORAS'),\r\n" + 
			"(3788,'PROFESOR, EDUCACION SUPERIOR/PSICOLOGIA'),\r\n" + 
			"(3789,'PROFESOR, EDUCACION SUPERIOR/PUBLICIDAD E INFORMACION PUBLI'),\r\n" + 
			"(3790,'PROFESOR, EDUCACION SUPERIOR/QUIMICA'),\r\n" + 
			"(3791,'PROFESOR, EDUCACION SUPERIOR/QUIROPRACTICA'),\r\n" + 
			"(3792,'PROFESOR, EDUCACION SUPERIOR/RADIOLOGIA'),\r\n" + 
			"(3793,'PROFESOR, EDUCACION SUPERIOR/RELACIONES PUBLICAS'),\r\n" + 
			"(3794,'PROFESOR, EDUCACION SUPERIOR/SERVICIOS DE TELECOMUNICACIONE'),\r\n" + 
			"(3795,'PROFESOR, EDUCACION SUPERIOR/SILVICULTURA'),\r\n" + 
			"(3796,'PROFESOR, EDUCACION SUPERIOR/SOCIOLOGIA'),\r\n" + 
			"(3797,'PROFESOR, EDUCACION SUPERIOR/TEOLOGIA'),\r\n" + 
			"(3798,'PROFESOR, EDUCACION SUPERIOR/TEORIA Y PRACTICA BANCARIA'),\r\n" + 
			"(3799,'PROFESOR, EDUCACION SUPERIOR/TERAPEUTICA PARAMEDICA'),\r\n" + 
			"(3800,'PROFESOR, EDUCACION SUPERIOR/TRATAMIENTOS MEDICOS'),\r\n" + 
			"(3801,'PROFESOR, EDUCACION SUPERIOR/TURISMO (ESCUELA DE TURISMO)'),\r\n" + 
			"(3802,'PROFESOR, EDUCACION SUPERIOR/ZOOLOGIA'),\r\n" + 
			"(3803,'PROFESOR, ENSEÑANZA SECUNDARIA/MATEMATICAS'),\r\n" + 
			"(3804,'PROFESOR, UNIVERSIDAD, OTROS'),\r\n" + 
			"(3805,'PROFESORES, OTROS'),\r\n" + 
			"(3806,'PROGRAMADOR, CODIFICADOR DE LOS PROGRAMAS'),\r\n" + 
			"(3807,'PROGRAMADOR, DESARROLLO DE LA LOGICA DEL PROCESO'),\r\n" + 
			"(3808,'PROGRAMADOR, INFORMATICA/ANALISIS DE BASE DE DATOS'),\r\n" + 
			"(3809,'PROGRAMADOR, INFORMATICA/ANALISIS DE SISTEMAS'),\r\n" + 
			"(3810,'PROGRAMADOR, INFORMATICA/POR COMPUTADORA'),\r\n" + 
			"(3811,'PROGRAMADOR, PRUEBA Y EJECUCION DEL PROGRAMA EN COMPUTADORA'),\r\n" + 
			"(3812,'PROMOTOR SOCIAL (TECNICO ASIMILADO)'),\r\n" + 
			"(3813,'PROMOTOR, DEPORTES'),\r\n" + 
			"(3814,'PROMOTORES DE JUEGO EN LA CALLE (AJEDREZ, DAMAS, ETC.)'),\r\n" + 
			"(3815,'PSICOLOGO'),\r\n" + 
			"(3816,'PSICOLOGO CLINICO'),\r\n" + 
			"(3817,'PSICOLOGO, EXPERIMENTOS'),\r\n" + 
			"(3818,'PSICOLOGO, INDUSTRIAS'),\r\n" + 
			"(3819,'PSICOLOGO, OCUPACIONES'),\r\n" + 
			"(3820,'PSICOLOGO, PEDAGOGIA'),\r\n" + 
			"(3821,'PSICOLOGO, PROBLEMAS SOCIALES'),\r\n" + 
			"(3822,'PSICOLOGO, TRABAJO'),\r\n" + 
			"(3823,'PSIQUIATRA'),\r\n" + 
			"(3824,'PUBLICISTA, RESPONSABLE DE CAMPAÐA PUBLICITARIA'),\r\n" + 
			"(3825,'PULIDOR A MAQUINA DE CRISTALES DE OPTICA'),\r\n" + 
			"(3826,'PULIDOR DE ARROZ'),\r\n" + 
			"(3827,'PULIDOR DE CERAMICA DORADA'),\r\n" + 
			"(3828,'PULIDOR DE CRISTALES'),\r\n" + 
			"(3829,'PULIDOR DE LENTES'),\r\n" + 
			"(3830,'PULIDOR DE METALES, A MANO'),\r\n" + 
			"(3831,'PULIDOR DE METALES, A MAQUINA'),\r\n" + 
			"(3832,'PULIDOR DE PIEDRA A MANO'),\r\n" + 
			"(3833,'PULIDOR DE PIEDRA A MAQUINA'),\r\n" + 
			"(3834,'PULIDOR DE PIEZAS DE METAL COLADO'),\r\n" + 
			"(3835,'PULIDOR DE PIEZAS DE MOLDEO'),\r\n" + 
			"(3836,'PULIDOR DE PRODUCTOS DE PLASTICO'),\r\n" + 
			"(3837,'PULIDOR DE VIDRIO O CRISTAL EN BAÐO DE ACIDO'),\r\n" + 
			"(3838,'PULIDOR,TEXTILES'),\r\n" + 
			"(3839,'PULVERIZADOR DE METAL A PISTOLA'),\r\n" + 
			"(3840,'PULVERIZADOR,DESHIDRATADOR DE DISOLUCIONES QUIMICAS'),\r\n" + 
			"(3841,'PUNTERO, METALES'),\r\n" + 
			"(3842,'PUNTILLERO,MATADEROS'),\r\n" + 
			"(3843,'PURERO A MANO'),\r\n" + 
			"(3844,'PURSERS'),\r\n" + 
			"(3845,'QUESERO'),\r\n" + 
			"(3846,'QUIMICO'),\r\n" + 
			"(3847,'QUIMICO ANALISTA'),\r\n" + 
			"(3848,'QUIMICO, COLORANTES'),\r\n" + 
			"(3849,'QUIMICO, CONTROL DE CALIDAD'),\r\n" + 
			"(3850,'QUIMICO, CORROSION'),\r\n" + 
			"(3851,'QUIMICO, CUEROS Y PIELES'),\r\n" + 
			"(3852,'QUIMICO, DETERGENTES'),\r\n" + 
			"(3853,'QUIMICO, ELECTROQUIMICA'),\r\n" + 
			"(3854,'QUIMICO, FARMACIA'),\r\n" + 
			"(3855,'QUIMICO, FARMACIA/ INDUSTRIA'),\r\n" + 
			"(3856,'QUIMICO, FISICA/OTROS'),\r\n" + 
			"(3857,'QUIMICO, INDUSTRIA DEL VIDRIO'),\r\n" + 
			"(3858,'QUIMICO, INDUSTRIA METALURGICA'),\r\n" + 
			"(3859,'QUIMICO, OTROS (NO INCLUYE ING. QUIMICO)'),\r\n" + 
			"(3860,'QUIMICO, QUIMICA ANALITICA'),\r\n" + 
			"(3861,'QUIMICO, QUIMICA INORGANICA'),\r\n" + 
			"(3862,'QUIMICO, QUIMICA MINERAL'),\r\n" + 
			"(3863,'QUIMICO, QUIMICA ORGANICA'),\r\n" + 
			"(3864,'QUIMICO, TEXTILES'),\r\n" + 
			"(3865,'QUIMICO, TINTURAS'),\r\n" + 
			"(3866,'QUIMICO-FARMACEUTICO'),\r\n" + 
			"(3867,'QUIROMANTICO'),\r\n" + 
			"(3868,'QUIROPODISTA'),\r\n" + 
			"(3869,'QUIROPRACTICO'),\r\n" + 
			"(3870,'QUITAMANCHAS, A MANO'),\r\n" + 
			"(3871,'RABINO'),\r\n" + 
			"(3872,'RADIO TECNICO REPARACIONES DE RADIO Y TV'),\r\n" + 
			"(3873,'RADIONAVEGANTE'),\r\n" + 
			"(3874,'RADIO-TELEFONISTA, ESTACIONES TERRESTRES'),\r\n" + 
			"(3875,'RADIOTELEGRAFISTA'),\r\n" + 
			"(3876,'RADIOTELEGRAFISTA, NAVEGACION MARITIMA'),\r\n" + 
			"(3877,'RASTRILLADOR DE LINO'),\r\n" + 
			"(3878,'RASTRILLADOR, PLAYAS'),\r\n" + 
			"(3879,'RASURADOR DE PIELES'),\r\n" + 
			"(3880,'REALIZADOR, RADIODIFUSION O TELEVISION'),\r\n" + 
			"(3881,'REBLONADOR PLANCHAS METAL, A MANO O MAQ., PLANCHA'),\r\n" + 
			"(3882,'RECADERO'),\r\n" + 
			"(3883,'RECALCADOR DE METALES PRECIOSOS'),\r\n" + 
			"(3884,'RECAUDADOR, IMPUESTOS'),\r\n" + 
			"(3885,'RECEPCIONISTA'),\r\n" + 
			"(3886,'RECEPCIONISTA, DENTISTA'),\r\n" + 
			"(3887,'RECEPCIONISTA, HOSPITAL/CONSULTORIO MEDICO'),\r\n" + 
			"(3888,'RECEPCIONISTA, HOTEL'),\r\n" + 
			"(3889,'RECEPCIONISTA, MEDICO'),\r\n" + 
			"(3890,'RECEPCIONISTA-ACOMPAÐANTE, CABARET, CLUB ETC.'),\r\n" + 
			"(3891,'RECIBIDOR DE APUESTAS'),\r\n" + 
			"(3892,'RECITADOR, EXCEPTO RADIO O TELEVISION'),\r\n" + 
			"(3893,'RECITADOR, RADIO O TELEVISION'),\r\n" + 
			"(3894,'RECOCEDOR DE METALES'),\r\n" + 
			"(3895,'RECOGEDOR DE FRUTAS (OBRERO)'),\r\n" + 
			"(3896,'RECOGEDOR DE PELOTAS'),\r\n" + 
			"(3897,'RECOGEDOR, BASURAS/CAMION O TRICICLO'),\r\n" + 
			"(3898,'RECOLECTOR DE ALGAS, ESPONJAS O MUSGO MARINO'),\r\n" + 
			"(3899,'RECOLECTOR DE FRUTOS, HOJAS DE TE, CAFE, ETC.'),\r\n" + 
			"(3900,'RECOLECTOR DE MIEL'),\r\n" + 
			"(3901,'RECONTADORA DE ALFOMBRAS'),\r\n" + 
			"(3902,'RECOPILADOR DE DIRECTORIOS Y GUIAS'),\r\n" + 
			"(3903,'RECOPILADOR DE INFORMACION ESTADISTICA'),\r\n" + 
			"(3904,'RECORTADOR A MAQUINA DE PROD. DE PLASTICO'),\r\n" + 
			"(3905,'RECORTADOR, ENCUADERNACION'),\r\n" + 
			"(3906,'RECTIFICADOR DE CILINDROS,TRABAJO DE METALES'),\r\n" + 
			"(3907,'RECTIFICADOR DE METALES'),\r\n" + 
			"(3908,'RECTOR'),\r\n" + 
			"(3909,'REDACTOR'),\r\n" + 
			"(3910,'REDACTOR JEFE, DIARIOS'),\r\n" + 
			"(3911,'REDACTOR JEFE, FINANZAS'),\r\n" + 
			"(3912,'REDACTOR JEFE, GUIONES/RADIO Y TELEVISION'),\r\n" + 
			"(3913,'REDACTOR JEFE, REVISTAS'),\r\n" + 
			"(3914,'REDACTOR PARLAMENTARIO'),\r\n" + 
			"(3915,'REDACTOR, ARTICULOS DE FONDO'),\r\n" + 
			"(3916,'REDACTOR, INFORMACION PUBLICA'),\r\n" + 
			"(3917,'REDACTOR, MODAS'),\r\n" + 
			"(3918,'REDACTOR, POLIZAS/SEGUROS'),\r\n" + 
			"(3919,'REDACTOR, PRENSA/EXTRANJERO'),\r\n" + 
			"(3920,'REDACTOR, PRENSA/T.V.'),\r\n" + 
			"(3921,'REDACTOR, PUBLICIDAD'),\r\n" + 
			"(3922,'REDACTOR, REVISTAS'),\r\n" + 
			"(3923,'REDACTOR, TECNICO'),\r\n" + 
			"(3924,'REDACTOR, TECNICO/MANUALES'),\r\n" + 
			"(3925,'REDERO DE MAR'),\r\n" + 
			"(3926,'REDUCTOR DE FOTOGRAFIAS'),\r\n" + 
			"(3927,'REFINADOR DE ACEITES Y GRASAS'),\r\n" + 
			"(3928,'REFINADOR DE PASTA DE PAPEL'),\r\n" + 
			"(3929,'REFINADOR DE TREMENTINA'),\r\n" + 
			"(3930,'REFINO DEL PETROLEO,BOMBERO'),\r\n" + 
			"(3931,'REFRESCADOR DE TABACO'),\r\n" + 
			"(3932,'REFRIGERADOR DE LECHE O PRODUCTOS LACTEOS'),\r\n" + 
			"(3933,'REGENTE, ESCENA'),\r\n" + 
			"(3934,'REGIDOR, TEATRO'),\r\n" + 
			"(3935,'REGISTRADORES'),\r\n" + 
			"(3936,'REGULADORES DE MAQUINA HERRAMIENTAS, EN GENERAL'),\r\n" + 
			"(3937,'REGULADOR-OPERADOR DE TORNO AUTOMATICO DE METAL'),\r\n" + 
			"(3938,'REGUL-OPERAD REVOLVERES PARA EL TRABAJO DE METALES'),\r\n" + 
			"(3939,'REJUNTADOR DE MAMPOSTERIA CAREADA Y CONCERTADA'),\r\n" + 
			"(3940,'RELACIONISTA, INDUSTRIAL'),\r\n" + 
			"(3941,'RELACIONISTA, LABORAL'),\r\n" + 
			"(3942,'RELACIONISTA, OTROS'),\r\n" + 
			"(3943,'RELACIONISTA, PUBLICO'),\r\n" + 
			"(3944,'RELATORES'),\r\n" + 
			"(3945,'RELLENADOR DE ACEITUNAS'),\r\n" + 
			"(3946,'RELOJERO'),\r\n" + 
			"(3947,'REMACHADOR, MANO O MAQ. PLANCHAS MET., MARTILLO NEU.'),\r\n" + 
			"(3948,'REMATADOR'),\r\n" + 
			"(3949,'REMENDADOR DE TEJIDOS'),\r\n" + 
			"(3950,'RENCAUCHADOR DE NEUMATICOS'),\r\n" + 
			"(3951,'REPARACION DE AUTOMOVILES,PINTOR RETOCADOR'),\r\n" + 
			"(3952,'REPARADOR DE APARATOS ELECTRODOMESTICOS'),\r\n" + 
			"(3953,'REPARADOR DE BICICLETAS'),\r\n" + 
			"(3954,'REPARADOR DE CHIMINEAS Y TORRES'),\r\n" + 
			"(3955,'REPARADOR DE RECEPTORES DE RADIO Y TV'),\r\n" + 
			"(3956,'REPARADOR DE RELOJES'),\r\n" + 
			"(3957,'REPARADOR ELECTRICISTA DE APARATOS ELECTRODOMESTICOS'),\r\n" + 
			"(3958,'REPARADOR INSTALACIONES DE TELEFONICOS Y TELEGRAFOS'),\r\n" + 
			"(3959,'REPARADOR, DE JOYAS'),\r\n" + 
			"(3960,'REPARADORA DE ALFOMBRAS'),\r\n" + 
			"(3961,'REPARTIDOR'),\r\n" + 
			"(3962,'REPARTIDOR DE CARGAS,ENERGIA ELECTRICA'),\r\n" + 
			"(3963,'REPARTIDOR, DIARIOS'),\r\n" + 
			"(3964,'REPARTIDOR, PERIODICOS'),\r\n" + 
			"(3965,'REPLANTEADOR DE ESTRUCTURAS, METALICAS'),\r\n" + 
			"(3966,'REPORTERO'),\r\n" + 
			"(3967,'REPORTERO GRAFICO/FOTOGRAFO REPORTERO'),\r\n" + 
			"(3968,'REPORTERO, MODA'),\r\n" + 
			"(3969,'REPORTERO, PRENSA/T.V. O RADIO'),\r\n" + 
			"(3970,'REPOSTERO,ELABORACION DE PASTELES Y OTROS'),\r\n" + 
			"(3971,'REPRESENTANTE,  COMPAÑIA NACIONAL'),\r\n" + 
			"(3972,'REPRESENTANTE, FABRICA/CONCESIONARIO'),\r\n" + 
			"(3973,'REPRESENTANTE, FIRMAS EXTRANJERAS'),\r\n" + 
			"(3974,'REPRESENTANTE, INSTITUCION COMERCIAL'),\r\n" + 
			"(3975,'REPRESENTANTE, SERVICIOS A LAS EMPRESAS'),\r\n" + 
			"(3976,'REPRESENTANTE, SERVICIOS A LAS EMPRESAS/ESPACIOS PUBLICITAR'),\r\n" + 
			"(3977,'REPRESENTANTE, VENTAS/COMERCIO'),\r\n" + 
			"(3978,'REPRESENTANTE, VENTAS/INDUSTRIA MANUFACTURERA'),\r\n" + 
			"(3979,'REPRESENTANTE, VENTAS/TECNICO'),\r\n" + 
			"(3980,'REPRESENTANTES DE ORGANISMOS INTERNACIONALES'),\r\n" + 
			"(3981,'REPRODUCTOR DE CLISES, REPRODUCCION EN PLASTICO'),\r\n" + 
			"(3982,'REPUJADOR DE CUEROS'),\r\n" + 
			"(3983,'REPUJADOR O GRABADOR A MANO O A MAQ,ENCUADERNACION'),\r\n" + 
			"(3984,'REPUJADOR, OTRO JOYERO O PLATERO'),\r\n" + 
			"(3985,'REQUESONERO'),\r\n" + 
			"(3986,'RESINERO'),\r\n" + 
			"(3987,'RESINERO (OBRERO)'),\r\n" + 
			"(3988,'RESTAURADOR DE ARTICULOS DE MADERA'),\r\n" + 
			"(3989,'RESTAURADOR DE MAMPOSTERIA DE CONSTRUC.HISTORIC.,ALBAÐIL'),\r\n" + 
			"(3990,'RESTAURADOR, CUADROS'),\r\n" + 
			"(3991,'RESTAURADOR, OBRAS DE ARTE'),\r\n" + 
			"(3992,'RETOCADOR DE AUTOMOVILES,CARROCERIA'),\r\n" + 
			"(3993,'RETOCADOR DE NEGATIVOS,FOTOGRABADO'),\r\n" + 
			"(3994,'RETOCADOR DE PLANCHAS DE IMPRESION,FOTOGRABADO'),\r\n" + 
			"(3995,'RETOCADOR, DECORADO DE CERAMICA'),\r\n" + 
			"(3996,'RETORCEDOR DE HILO O HILAZA'),\r\n" + 
			"(3997,'RETRATISTA'),\r\n" + 
			"(3998,'REVELADOR DE PELICULAS FOTOGRAFICAS'),\r\n" + 
			"(3999,'REVELADOR DE RADIOGRAFIAS'),\r\n" + 
			"(4000,'REVESTIDOR EN BAÑO CALIENTE'),\r\n" + 
			"(4001,'REVISOR DE TEJIDOS, OBREROS'),\r\n" + 
			"(4002,'REVISOR Y PROBADOR DE MAQUINARIA'),\r\n" + 
			"(4003,'REVISOR, TEJIDOS, TECNICOS'),\r\n" + 
			"(4004,'REVISOR/TELAS'),\r\n" + 
			"(4005,'REVISOR-INSPECTOR, CALIDAD'),\r\n" + 
			"(4006,'REVISOR-PROBADOR, MAQUINA'),\r\n" + 
			"(4007,'REVOCADOR'),\r\n" + 
			"(4008,'REVOLVEDOR DE GRANOS'),\r\n" + 
			"(4009,'REZADOR'),\r\n" + 
			"(4010,'REZAGADOR DE CAPA, ELABORACION DE CIGARROS'),\r\n" + 
			"(4011,'REZAGADOR DE CAPOTE, ELABORACION DE CIGARRILLOS'),\r\n" + 
			"(4012,'REZAGADOR, FERMENTADO DEL TABACO'),\r\n" + 
			"(4013,'RODETERO, TEXTIL'),\r\n" + 
			"(4014,'SACADOR DE COPIAS DE FOTOGRAFIAS'),\r\n" + 
			"(4015,'SACAMUESTRAS, MINAS'),\r\n" + 
			"(4016,'SACERDOTE'),\r\n" + 
			"(4017,'SACERDOTE BUDISTA'),\r\n" + 
			"(4018,'SACRISTAN'),\r\n" + 
			"(4019,'SALADOR DE ALIMENTOS,CARNES Y PESCADO'),\r\n" + 
			"(4020,'SALADOR DE QUESO'),\r\n" + 
			"(4021,'SALAZONERO'),\r\n" + 
			"(4022,'SALCHICHERO'),\r\n" + 
			"(4023,'SALVADERO'),\r\n" + 
			"(4024,'SAMUELLES-MUELLERO'),\r\n" + 
			"(4025,'SANFORIZADOR'),\r\n" + 
			"(4026,'SANGRADOR, ARBOLES/EXCEPTO HEVEA'),\r\n" + 
			"(4027,'SANGRADOR, CAUCHO'),\r\n" + 
			"(4028,'SANGRADOR, JARABE DE ARCE'),\r\n" + 
			"(4029,'SANITARIO'),\r\n" + 
			"(4030,'SASTRE, A MEDIDA'),\r\n" + 
			"(4031,'SASTRE, CONFECCION EN SERIE'),\r\n" + 
			"(4032,'SASTRE, CORTADOR'),\r\n" + 
			"(4033,'SATINADOR-CALANDRADOR DE PAPEL'),\r\n" + 
			"(4034,'SAXOFONISTA'),\r\n" + 
			"(4035,'SECADOR DE ARROZ'),\r\n" + 
			"(4036,'SECADOR DE MADERA'),\r\n" + 
			"(4037,'SECADOR DE MALTA'),\r\n" + 
			"(4038,'SECADOR DE PELICULAS CINEMATOGRAFICAS'),\r\n" + 
			"(4039,'SECADOR DE PESCADO AL SOL'),\r\n" + 
			"(4040,'SECADOR PRODUCTOS QUIMICOS, SECADOR CINTA TRANSPORTADORA'),\r\n" + 
			"(4041,'SECADOR, CORCHO'),\r\n" + 
			"(4042,'SECADOR,FABRICACION DE TEXTILES'),\r\n" + 
			"(4043,'SECRETARIA'),\r\n" + 
			"(4044,'SECRETARIA, BILINGUE'),\r\n" + 
			"(4045,'SECRETARIA, COMERCIAL'),\r\n" + 
			"(4046,'SECRETARIA, EJECUTIVA/BILINGUE'),\r\n" + 
			"(4047,'SECRETARIA, MEDICO'),\r\n" + 
			"(4048,'SECRETARIA, OTROS'),\r\n" + 
			"(4049,'SECRETARIA-MECANOGRAFA'),\r\n" + 
			"(4050,'SECRETARIA-TAQUIGRAFA'),\r\n" + 
			"(4051,'SECRETARIA-TAQUIMECANOGRAFA'),\r\n" + 
			"(4052,'SECRETARIO DE CORTE'),\r\n" + 
			"(4053,'SECRETARIO DE EMBAJADA'),\r\n" + 
			"(4054,'SECRETARIO DE ESTADO'),\r\n" + 
			"(4055,'SECRETARIO DE JUZGADO, EMPLEADO DE OFICINA'),\r\n" + 
			"(4056,'SECRETARIO DE JUZGADO, PROFESIONAL'),\r\n" + 
			"(4057,'SECRETARIO GENERAL ADJUNTO, ADMINISTRACION PUBLICA'),\r\n" + 
			"(4058,'SECRETARIO GENERAL, ADMINISTRACION PUBLICA'),\r\n" + 
			"(4059,'SECRETARIO GENERAL, ORGANIZACION DE EMPLEADORES'),\r\n" + 
			"(4060,'SECRETARIO GENERAL, ORGANIZACION DE PROTECCION DE LA FAUNA'),\r\n" + 
			"(4061,'SECRETARIO GENERAL, ORGANIZACION DE PROTECCION DEL MEDIO AM'),\r\n" + 
			"(4062,'SECRETARIO GENERAL, PARTIDO POLITICO'),\r\n" + 
			"(4063,'SECRETARIO GENERAL, SINDICATO DE TRABAJADORES'),\r\n" + 
			"(4064,'SECRETARIO, JUZGADO, TECNICO'),\r\n" + 
			"(4065,'SECRETARIO, PARTIDO POLITICO'),\r\n" + 
			"(4066,'SEGMENTISTA'),\r\n" + 
			"(4067,'SEGUNDO OFICIAL, MAQUINISTA/BARCO'),\r\n" + 
			"(4068,'SEMOLERO'),\r\n" + 
			"(4069,'SENADOR'),\r\n" + 
			"(4070,'SERENAZGO'),\r\n" + 
			"(4071,'SERENO'),\r\n" + 
			"(4072,'SERICICULTOR'),\r\n" + 
			"(4073,'SERICIGRAFO,IMPRESOR'),\r\n" + 
			"(4074,'SERRUCHADOR,ASERRADERO'),\r\n" + 
			"(4075,'SERVICIO DE ALQUILER DE VEHICULOS'),\r\n" + 
			"(4076,'SERVICIO DE ALQUILER DE VIDEOS, EQUIPOS DE SONIDO'),\r\n" + 
			"(4077,'SEXADOR, POLLOS'),\r\n" + 
			"(4078,'SHIVINGERO'),\r\n" + 
			"(4079,'SIDRERO'),\r\n" + 
			"(4080,'SIRVIENTA (E)'),\r\n" + 
			"(4081,'SIRVIENTA (E), COCINA'),\r\n" + 
			"(4082,'SIRVIENTA (E), SALON'),\r\n" + 
			"(4083,'SIRVIENTE (A), COCINA'),\r\n" + 
			"(4084,'SIRVIENTE (A), SALON'),\r\n" + 
			"(4085,'SISMOLOGO'),\r\n" + 
			"(4086,'SOCIOLOGO, CRIMINOLOGIA'),\r\n" + 
			"(4087,'SOCIOLOGO, INDUSTRIA'),\r\n" + 
			"(4088,'SOCIOLOGO, PATOLOGIA SOCIAL'),\r\n" + 
			"(4089,'SOLADOR DE LABRILLOS O BALDOSAS'),\r\n" + 
			"(4090,'SOLADOR EN MATERIALES PLASTICAS, SINTASOL'),\r\n" + 
			"(4091,'SOLADOR EN MOSAICO'),\r\n" + 
			"(4092,'SOLADOR EN TERRAZO, PAVIMENTO CONTINUO'),\r\n" + 
			"(4093,'SOLADOR,LADRILLOS Y BALDOSAS DE MATERIAL SINTETICO'),\r\n" + 
			"(4094,'SOLDADOR CON SOPLETE Y POR ARCO ELECTRICO,GRAL'),\r\n" + 
			"(4095,'SOLDADOR DE CAUTIN (CAUTIL)'),\r\n" + 
			"(4096,'SOLDADOR N.E.O.P.'),\r\n" + 
			"(4097,'SOLDADOR-PLOMERO'),\r\n" + 
			"(4098,'SOMBRERERO,INCLUSIVE DE SOMBREROS DE PAJA'),\r\n" + 
			"(4099,'SONDISTA DE POZOS EN EXPLOTACION'),\r\n" + 
			"(4100,'SONDISTA, CONDUCTOR DE PERFORADORA DE PERCUSION, PETROLEO Y'),\r\n" + 
			"(4101,'SONDISTA, CONDUCTORES DE TREN DE SONDEO POR ROTACION,'),\r\n" + 
			"(4102,'SONDISTA, EXCEPTO POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(4103,'SONDISTA, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(4104,'SONDISTA, RECUPERACION Y MANTENIMIENTO DE CILINDROS DE PETR'),\r\n" + 
			"(4105,'SONIDOS;EN CALDERAS Y TUBERIAS, DE AIRE ACONDICIONADO'),\r\n" + 
			"(4106,'SOPLADOR VIDRIO,MATERIAL LABORATORIO A MAQUINA'),\r\n" + 
			"(4107,'SOPLETISTA DE CORTE, A MANO'),\r\n" + 
			"(4108,'SOPLETISTA SOLDADOR'),\r\n" + 
			"(4109,'SOPRANO'),\r\n" + 
			"(4110,'SUAVIZADOR DE PIELES'),\r\n" + 
			"(4111,'SUB DIRECTOR DE EMPRESA, AGRICULTURA, CAZA, SILVICULTURA Y'),\r\n" + 
			"(4112,'SUB DIRECTOR DE EMPRESA, COIMERCIO MAYORISTA Y MINORISTA, R'),\r\n" + 
			"(4113,'SUB DIRECTOR DE EMPRESA, CONSTRUCCION Y OBRAS PUBLICAS'),\r\n" + 
			"(4114,'SUB DIRECTOR DE EMPRESA, INDUSTRIAS MANUFACTURERAS, MINAS Y'),\r\n" + 
			"(4115,'SUB DIRECTOR DE EMPRESA, RESTAURANTES Y HOTELERIA'),\r\n" + 
			"(4116,'SUB DIRECTOR DE EMPRESA, RESTAURANTES Y HOTELERIA'),\r\n" + 
			"(4117,'SUB DIRECTOR DE EMPRESA, SERVICIOS PUBLICOS Y FINANCIEROS'),\r\n" + 
			"(4118,'SUB DIRECTOR DE EMPRESA, TRANSPORTE, ALMACENAMIENTO Y COMUN'),\r\n" + 
			"(4119,'SUB DIRECTOR DE LA ADMINISTRACION PUBLICA'),\r\n" + 
			"(4120,'SUBASTADOR'),\r\n" + 
			"(4121,'SUB-PREFECTO'),\r\n" + 
			"(4122,'SUPER INTENDENTE DE PLANTA'),\r\n" + 
			"(4123,'SUPER INTENDENTE DE PRODUCCION'),\r\n" + 
			"(4124,'SUPERINTENDENTE TECNICO, MARINA MERCANTE'),\r\n" + 
			"(4125,'SUPERINTENDENTE, ARMAMENTO/CUBIERTA (BUQUES)'),\r\n" + 
			"(4126,'SUPERVISOR DE ARTES GRAFICAS'),\r\n" + 
			"(4127,'SUPERVISOR DE CAMPO'),\r\n" + 
			"(4128,'SUPERVISOR DE PRODUCCION'),\r\n" + 
			"(4129,'SUPERVISOR DE VENTAS, COMERCIO AL POR MAYOR'),\r\n" + 
			"(4130,'SUPERVISOR DE VENTAS, COMERCIO AL POR MENOR'),\r\n" + 
			"(4131,'SUPERVISOR, COMERCIO N.E.P'),\r\n" + 
			"(4132,'SUPERVISOR, CORREO'),\r\n" + 
			"(4133,'SUPERVISOR, FORESTAL'),\r\n" + 
			"(4134,'TABLAJERO, CARNES'),\r\n" + 
			"(4135,'TALABARTERO'),\r\n" + 
			"(4136,'TALADOR EN GENERAL (CORTADOR DE ARBOLES)'),\r\n" + 
			"(4137,'TALADRADOR DE PIEZAS DE CERAMICA'),\r\n" + 
			"(4138,'TALADRADORA DE PRODUCTOS DE PLASTICO'),\r\n" + 
			"(4139,'TALADRISTA'),\r\n" + 
			"(4140,'TALLADOR DE CRISTALES DE OPTICA'),\r\n" + 
			"(4141,'TALLADOR DE CRISTALES-VIDRIOS,TALLA DECORATIVA'),\r\n" + 
			"(4142,'TALLADOR DE LAMINAS'),\r\n" + 
			"(4143,'TALLADOR DE MADERA'),\r\n" + 
			"(4144,'TALLADOR DE PIEDRA'),\r\n" + 
			"(4145,'TALLADOR DE VIDRIO O CRISTAL'),\r\n" + 
			"(4146,'TALLADOR Y PULIDOR DE PIEDRAS PRECIOSAS'),\r\n" + 
			"(4147,'TALLISTA, MADERA'),\r\n" + 
			"(4148,'TAMBORILERO'),\r\n" + 
			"(4149,'TAMIZADOR DE TIERRAS, CERAMICA'),\r\n" + 
			"(4150,'TAMIZADOR, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(4151,'TAPICERO DE MUEBLES'),\r\n" + 
			"(4152,'TAPICERO DE VEHICULOS'),\r\n" + 
			"(4153,'TAQUIGRAFA'),\r\n" + 
			"(4154,'TAQUILLERO'),\r\n" + 
			"(4155,'TAQUIMECANOGRAFA'),\r\n" + 
			"(4156,'TASADOR'),\r\n" + 
			"(4157,'TASADOR, SEGUROS'),\r\n" + 
			"(4158,'TASADOR, SINIESTROS'),\r\n" + 
			"(4159,'TAXIDERMISTA (NATURALISTA-PREPARADOR)'),\r\n" + 
			"(4160,'TAXISTA'),\r\n" + 
			"(4161,'TAXONOMISTA'),\r\n" + 
			"(4162,'TAXONOMISTA, ANIMALES'),\r\n" + 
			"(4163,'TAXONOMISTA, PLANTAS'),\r\n" + 
			"(4164,'TECHADOR EN GENERAL, PIZARRA, TEJA, ASFALTO, MATERIALES SIN'),\r\n" + 
			"(4165,'TECLISTA MONOTIPISTA'),\r\n" + 
			"(4166,'TECNICO AERONAUTICO'),\r\n" + 
			"(4167,'TECNICO AGRONOMO'),\r\n" + 
			"(4168,'TECNICO AGRONOMO, SUELO'),\r\n" + 
			"(4169,'TECNICO BROMATOLOGO'),\r\n" + 
			"(4170,'TECNICO CALCULISTA, CONSTRUCCION MECANICA'),\r\n" + 
			"(4171,'TECNICO CALCULISTA, INGENIERIA CIVIL/COSTO DE CONSTRUCCION'),\r\n" + 
			"(4172,'TECNICO CALCULISTA, INGENIERIA ELECTRONICA'),\r\n" + 
			"(4173,'TECNICO CONSEJERO DIETETICO, INDUSTRIA DE ALIMENTOS'),\r\n" + 
			"(4174,'TECNICO CONTABLE EMPRESARIAL'),\r\n" + 
			"(4175,'TECNICO CONTABLE EN COSTOS'),\r\n" + 
			"(4176,'TECNICO CONTABLE GUBERNAMENTAL'),\r\n" + 
			"(4177,'TECNICO DE SALUD'),\r\n" + 
			"(4178,'TECNICO DIETISTA'),\r\n" + 
			"(4179,'TECNICO DIETISTA, DIETETICO MEDICA'),\r\n" + 
			"(4180,'TECNICO ELECTRICISTA, ALTA TENSION'),\r\n" + 
			"(4181,'TECNICO ELECTRICISTA, ENERGIA ELECTRICA/DISTRIBUCION'),\r\n" + 
			"(4182,'TECNICO ELECTRICISTA, ILUMINACION'),\r\n" + 
			"(4183,'TECNICO ELECTRICISTA, RADIO Y/O T.V.'),\r\n" + 
			"(4184,'TECNICO ELECTRICISTA, SONIDO'),\r\n" + 
			"(4185,'TECNICO EN AUDIO VISUALES'),\r\n" + 
			"(4186,'TECNICO EN CIENCIAS SOCIALES'),\r\n" + 
			"(4187,'TECNICO EN COMUNICACION'),\r\n" + 
			"(4188,'TECNICO EN ESTADISTICA'),\r\n" + 
			"(4189,'TECNICO EN ESTADISTICA O MATEMATICA, OTROS'),\r\n" + 
			"(4190,'TECNICO EN LA INDUSTRIA, OTROS'),\r\n" + 
			"(4191,'TECNICO EN LABORATORIO CLINICO'),\r\n" + 
			"(4192,'TECNICO EN TENEDURIA DE LIBROS'),\r\n" + 
			"(4193,'TECNICO INSPECTOR, NAVAL'),\r\n" + 
			"(4194,'TECNICO INSPECTOR, NAVAL/BUQUES'),\r\n" + 
			"(4195,'TECNICO MECANICO'),\r\n" + 
			"(4196,'TECNICO MECANICO, ACONDICIONAMIENTO DE AIRE'),\r\n" + 
			"(4197,'TECNICO MECANICO, AERONAUTICA'),\r\n" + 
			"(4198,'TECNICO MECANICO, AGRICULTURA'),\r\n" + 
			"(4199,'TECNICO MECANICO, AUTOMOVILES'),\r\n" + 
			"(4200,'TECNICO MECANICO, CALEFACCION, REFRIGERACION Y VENTILACION'),\r\n" + 
			"(4201,'TECNICO MECANICO, CONSTRUCCION NAVAL'),\r\n" + 
			"(4202,'TECNICO MECANICO, ENERGIA NUCLEAR'),\r\n" + 
			"(4203,'TECNICO MECANICO, INSTRUCTOR DE VEHICULOS AUTOMOTORES'),\r\n" + 
			"(4204,'TECNICO MECANICO, INSTRUMENTOS'),\r\n" + 
			"(4205,'TECNICO MECANICO, LUBRICACION'),\r\n" + 
			"(4206,'TECNICO MECANICO, MANTENIMIENTO DE AVION'),\r\n" + 
			"(4207,'TECNICO MECANICO, MAQUINARIA Y HERRAMIENTAS INDUSTRIALES'),\r\n" + 
			"(4208,'TECNICO MECANICO, MOTORES'),\r\n" + 
			"(4209,'TECNICO MECANICO, MOTORES DE COMBUSTION INTERNA'),\r\n" + 
			"(4210,'TECNICO MECANICO, MOTORES DE LOCOMOTORAS'),\r\n" + 
			"(4211,'TECNICO MECANICO, MOTORES DE PROPULSION A CHORRO'),\r\n" + 
			"(4212,'TECNICO MECANICO, MOTORES DIESEL'),\r\n" + 
			"(4213,'TECNICO MECANICO, SISTEMAS HIDRAULICOS'),\r\n" + 
			"(4214,'TECNICO MECANICO, TURBINAS DE GAS'),\r\n" + 
			"(4215,'TECNICO NUTRICIONISTA, SALUD PUBLICA'),\r\n" + 
			"(4216,'TECNICO ORTOPEDICO'),\r\n" + 
			"(4217,'TECNICO RADIOLOGO'),\r\n" + 
			"(4218,'TECNICO SALA DE CONTROL/RADIO'),\r\n" + 
			"(4219,'TECNICO SALA DE CONTROL/TELEVISION'),\r\n" + 
			"(4220,'TECNICO VETERINARIO, INSEMINACION ARTIFICIAL'),\r\n" + 
			"(4221,'TECNICO, ACIDIFICACION/POZOS'),\r\n" + 
			"(4222,'TECNICO, ACONDICIONAMIENTO DE AIRE'),\r\n" + 
			"(4223,'TECNICO, AGRIMENSOR'),\r\n" + 
			"(4224,'TECNICO, AGROPECUARIO'),\r\n" + 
			"(4225,'TECNICO, ALIMENTOS'),\r\n" + 
			"(4226,'TECNICO, ANALISIS INFORMATICO'),\r\n" + 
			"(4227,'TECNICO, ANALISTA QUIMICO'),\r\n" + 
			"(4228,'TECNICO, ANATOMIA'),\r\n" + 
			"(4229,'TECNICO, ASTRONOMIA'),\r\n" + 
			"(4230,'TECNICO, AUXILIAR DE ARQUITECTURA'),\r\n" + 
			"(4231,'TECNICO, BACTERIOLOGIA'),\r\n" + 
			"(4232,'TECNICO, BANCOS DE SANGRE'),\r\n" + 
			"(4233,'TECNICO, BIOFISICA'),\r\n" + 
			"(4234,'TECNICO, BIOLOGIA (ANALISTA)'),\r\n" + 
			"(4235,'TECNICO, BIOQUIMICA'),\r\n" + 
			"(4236,'TECNICO, BOTANICA'),\r\n" + 
			"(4237,'TECNICO, CALCULO DE COSTOS Y CANTIDADES'),\r\n" + 
			"(4238,'TECNICO, CARTOGRAFO'),\r\n" + 
			"(4239,'TÉCNICO, CEMENTADOR, POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(4240,'TECNICO, CERAMICA'),\r\n" + 
			"(4241,'TECNICO, CIENCIAS BIOLOGICAS/OTROS'),\r\n" + 
			"(4242,'TECNICO, CITOLOGIA'),\r\n" + 
			"(4243,'TECNICO, COMERCIO'),\r\n" + 
			"(4244,'TECNICO, CONTROL DE EQUIPOS INFORMATICOS'),\r\n" + 
			"(4245,'TECNICO, COOPERATIVISMO'),\r\n" + 
			"(4246,'TECNICO, CUEROS Y PIELES'),\r\n" + 
			"(4247,'TECNICO, ECOLOGIA'),\r\n" + 
			"(4248,'TECNICO, ECONOMIA'),\r\n" + 
			"(4249,'TECNICO, EFECTOS SONOROS/CINE'),\r\n" + 
			"(4250,'TECNICO, EFICIENCIA INDUSTRIAL'),\r\n" + 
			"(4251,'TECNICO, ELECTRICISTA'),\r\n" + 
			"(4252,'TECNICO, EN MATEMATICA'),\r\n" + 
			"(4253,'TECNICO, EQUIPO DE GRABACION/CINTA MAGNETICA'),\r\n" + 
			"(4254,'TECNICO, EQUIPO DE GRABACION/DISCOS DIGITALES'),\r\n" + 
			"(4255,'TECNICO, EQUIPO DE GRABACION/EFECTOS SONOROS'),\r\n" + 
			"(4256,'TECNICO, EQUIPO DE GRABACION/HILO MAGNETICO'),\r\n" + 
			"(4257,'TECNICO, EQUIPO DE GRABACION/SONIDO'),\r\n" + 
			"(4258,'TECNICO, EQUIPO DE GRABACION/VIDEO'),\r\n" + 
			"(4259,'TECNICO, EQUIPO DE RADIO Y TELEVISION'),\r\n" + 
			"(4260,'TECNICO, EQUIPO DE SONORIZACION/RADIO'),\r\n" + 
			"(4261,'TECNICO, EQUIPO DE SONORIZACION/TELEVISION'),\r\n" + 
			"(4262,'TECNICO, ESPECIALISTA EN FISICO-QUIMICA'),\r\n" + 
			"(4263,'TECNICO, ESTUDIO DEL TRABAJO'),\r\n" + 
			"(4264,'TECNICO, EXTRACCION/CARBON'),\r\n" + 
			"(4265,'TECNICO, EXTRACCION/GAS (SONDEO DE POZOS)'),\r\n" + 
			"(4266,'TECNICO, EXTRACCION/METALES'),\r\n" + 
			"(4267,'TECNICO, EXTRACCION/PETROLEO Y GAS NATURAL'),\r\n" + 
			"(4268,'TECNICO, FARMACOLOGIA'),\r\n" + 
			"(4269,'TECNICO, FIBRA TEXTIL (DE ING. TEXTIL)'),\r\n" + 
			"(4270,'TECNICO, FISICA/INVESTIGACION (CIENCIAS FISICAS)'),\r\n" + 
			"(4271,'TECNICO, FISIOLOGIA'),\r\n" + 
			"(4272,'TECNICO, FORESTAL'),\r\n" + 
			"(4273,'TECNICO, FOTOGRAMETRISTA Y AEROFOTOGRAMETRISTA'),\r\n" + 
			"(4274,'TECNICO, GANADERIA (PECUARIO)'),\r\n" + 
			"(4275,'TECNICO, GEOFISICA'),\r\n" + 
			"(4276,'TECNICO, GEOLOGIA'),\r\n" + 
			"(4277,'TECNICO, GIMNASIA MEDICA'),\r\n" + 
			"(4278,'TECNICO, HISTOLOGIA'),\r\n" + 
			"(4279,'TECNICO, HORTICULTURA'),\r\n" + 
			"(4280,'TECNICO, INGENIERIA CIVIL'),\r\n" + 
			"(4281,'TECNICO, INGENIERIA CIVIL/CONSTRUCCION DE VIVIENDAS Y EDIFI'),\r\n" + 
			"(4282,'TECNICO, INGENIERIA CIVIL/CONTRATISTA (CONSTRUCCION)'),\r\n" + 
			"(4283,'TECNICO, INGENIERIA CIVIL/ESTRUCTURAS'),\r\n" + 
			"(4284,'TECNICO, INGENIERIA CIVIL/HIDRAULICA'),\r\n" + 
			"(4285,'TECNICO, INGENIERIA CIVIL/IRRIGACION'),\r\n" + 
			"(4286,'TECNICO, INGENIERIA CIVIL/MECANICA DE SUELOS'),\r\n" + 
			"(4287,'TECNICO, INGENIERIA CIVIL/SANITARIA'),\r\n" + 
			"(4288,'TECNICO, INGENIERIA ELECTRICA'),\r\n" + 
			"(4289,'TECNICO, INGENIERIA ELECTRONICA'),\r\n" + 
			"(4290,'TECNICO, INGENIERIA/ESTUDIO DE TIEMPOS Y MOVIMIENTOS'),\r\n" + 
			"(4291,'TECNICO, INGENIERIA/METODOS'),\r\n" + 
			"(4292,'TECNICO, INGENIERIA/ORGANIZACION INDUSTRIAL'),\r\n" + 
			"(4293,'TECNICO, INGENIERIA/PLANIFICACION'),\r\n" + 
			"(4294,'TECNICO, INGENIERIA/PRODUCCION'),\r\n" + 
			"(4295,'TECNICO, INGENIERIA/SEGURIDAD E HIGIENE INDUSTRIAL'),\r\n" + 
			"(4296,'TECNICO, LABORATORIO BIOLOGICO'),\r\n" + 
			"(4297,'TECNICO, LABORATORISTA FISICO O QUIMICO'),\r\n" + 
			"(4298,'TECNICO, MATERIAL DE DOBLAJE'),\r\n" + 
			"(4299,'TECNICO, MERCADOTECNIA (MARKETTING)'),\r\n" + 
			"(4300,'TECNICO, METALURGIA/ENSAYADOR DE METALES'),\r\n" + 
			"(4301,'TECNICO, METALURGIA/EXTRACCION'),\r\n" + 
			"(4302,'TECNICO, METALURGIA/FUNDICION'),\r\n" + 
			"(4303,'TECNICO, METALURGIA/SIDERURGICA'),\r\n" + 
			"(4304,'TECNICO, METALURGIA/TRATAMIENTO Y/O PRODUCCION DE METALES'),\r\n" + 
			"(4305,'TECNICO, METEOROLOGIA'),\r\n" + 
			"(4306,'TECNICO, MINERIA'),\r\n" + 
			"(4307,'TECNICO, OCEANOGRAFIA'),\r\n" + 
			"(4308,'TECNICO, OLEICULTURA'),\r\n" + 
			"(4309,'TECNICO, OPERADOR DE RADAR'),\r\n" + 
			"(4310,'TECNICO, PAPEL'),\r\n" + 
			"(4311,'TECNICO, PATOLOGIA'),\r\n" + 
			"(4312,'TECNICO, PESQUERIA'),\r\n" + 
			"(4313,'TECNICO, PETROQUIMICA'),\r\n" + 
			"(4314,'TECNICO, PLANIFICACION'),\r\n" + 
			"(4315,'TECNICO, POMOLOGIA'),\r\n" + 
			"(4316,'TECNICO, PREVENCION DE INCENDIOS'),\r\n" + 
			"(4317,'TECNICO, PROGRAMACION POR COMPUTADORAS'),\r\n" + 
			"(4318,'TECNICO, PRUEBAS DE SONIDO/SONIDISTA'),\r\n" + 
			"(4319,'TECNICO, QUIMICA INDUSTRIAL'),\r\n" + 
			"(4320,'TECNICO, QUIMICA INDUSTRIAL/GAS'),\r\n" + 
			"(4321,'TECNICO, QUIMICA INDUSTRIAL/PETROLEO'),\r\n" + 
			"(4322,'TECNICO, QUIMICA INDUSTRIAL/PLASTICOS'),\r\n" + 
			"(4323,'TECNICO, QUIMICA INDUSTRIAL/PROCESOS QUIMICOS'),\r\n" + 
			"(4324,'TECNICO, QUIMICA INDUSTRIAL/PRODUCCION Y DISTRIBUCION DE GAS'),\r\n" + 
			"(4325,'TECNICO, QUIMICA INDUSTRIAL/REFINACION DEL PETROLEO'),\r\n" + 
			"(4326,'TECNICO, QUIMICA/INVESTIGACION (CIENCIAS QUIMICAS)'),\r\n" + 
			"(4327,'TECNICO, QUIMICO INDUSTRIAL/CAUCHO'),\r\n" + 
			"(4328,'TECNICO, READAPTACION PROFESIONAL'),\r\n" + 
			"(4329,'TECNICO, SEGURIDAD/TRAFICO AEREO'),\r\n" + 
			"(4330,'TECNICO, SEROLOGIA'),\r\n" + 
			"(4331,'TECNICO, SERVICIOS INFORMATICOS PARA USUARIOS'),\r\n" + 
			"(4332,'TECNICO, SILVICULTURA'),\r\n" + 
			"(4333,'TECNICO, SISTEMAS ELECTRICOS DE AERONAVES'),\r\n" + 
			"(4334,'TECNICO, SISTEMAS/EXCEPTO INFORMATICOS'),\r\n" + 
			"(4335,'TECNICO, SONDEO/POZOS DE PETROLEO Y GAS'),\r\n" + 
			"(4336,'TECNICO, TEJIDOS'),\r\n" + 
			"(4337,'TECNICO, TELECOMUNICACIONES'),\r\n" + 
			"(4338,'TECNICO, TELECOMUNICACIONES/RADIO'),\r\n" + 
			"(4339,'TECNICO, TELECOMUNICACIONES/SISTEMAS DE SEÐALES'),\r\n" + 
			"(4340,'TECNICO, TELECOMUNICACIONES/TELEFONO'),\r\n" + 
			"(4341,'TECNICO, TELECOMUNICACIONES/TELEGRAFO'),\r\n" + 
			"(4342,'TECNICO, TELECOMUNICACIONES/TELEVISION'),\r\n" + 
			"(4343,'TECNICO, ZOOLOGIA EN AGRONOMIA, ZOOTECNIA Y SILVICULTURA'),\r\n" + 
			"(4344,'TECNICO, ZOOLOGIA EN CIENCIAS BIOLOGICAS'),\r\n" + 
			"(4345,'TECNICOS ADMINISTRADORES, OTROS'),\r\n" + 
			"(4346,'TECNICOS CONTABLES, OTROS'),\r\n" + 
			"(4347,'TECNICOS EN RACIONALIZACION ADMINISTRATIVA'),\r\n" + 
			"(4348,'TECNOLOGO MEDICO'),\r\n" + 
			"(4349,'TECNOLOGO PROTESIS'),\r\n" + 
			"(4350,'TEÑIDOR DE CUEROS'),\r\n" + 
			"(4351,'TEÑIDOR DE PIELES A MANO'),\r\n" + 
			"(4352,'TEJE PULSERAS'),\r\n" + 
			"(4353,'TEJEDOR A MAQUINA, CALCETERIA'),\r\n" + 
			"(4354,'TEJEDOR A MAQUINA, GENEROS DE PUNTO'),\r\n" + 
			"(4355,'TEJEDOR DE ALFOMBRA A MAQUINA'),\r\n" + 
			"(4356,'TEJEDOR DE ALFOMBRAS A MANO'),\r\n" + 
			"(4357,'TEJEDOR DE ALFOMBRAS EN TELAR ACCIONADO A MANO'),\r\n" + 
			"(4358,'TEJEDOR DE CALCETERIA, CON BASTIDOR MECANICO'),\r\n" + 
			"(4359,'TEJEDOR DE CAPAZOS'),\r\n" + 
			"(4360,'TEJEDOR DE CAPAZOS DE JUNCO O ESPARTO'),\r\n" + 
			"(4361,'TEJEDOR DE CESTOS'),\r\n" + 
			"(4362,'TEJEDOR DE DISFRACES'),\r\n" + 
			"(4363,'TEJEDOR DE PUNTO A MANO'),\r\n" + 
			"(4364,'TEJEDOR DE PUNTO EN BASTIDOR MANUAL'),\r\n" + 
			"(4365,'TEJEDOR DE PUNTO EN MAQUINA ACCIONADA A MANO'),\r\n" + 
			"(4366,'TEJEDOR DE PUNTO EN MAQUINA HILAN O RASCHEL'),\r\n" + 
			"(4367,'TEJEDOR DE REDES'),\r\n" + 
			"(4368,'TEJEDOR DE REDES A MANO'),\r\n" + 
			"(4369,'TEJEDOR DE SERAS Y SERONES'),\r\n" + 
			"(4370,'TEJEDOR DE TAPICES,EN TELAR ACCIONADO A MANO'),\r\n" + 
			"(4371,'TEJEDOR DE TELAR A MANO'),\r\n" + 
			"(4372,'TEJEDOR DE TELAR JACQUARD'),\r\n" + 
			"(4373,'TEJEDOR DE TELAR MECANICO'),\r\n" + 
			"(4374,'TEJEDOR DE TUL'),\r\n" + 
			"(4375,'TEJEDOR MUEBLES DE MIMBRE'),\r\n" + 
			"(4376,'TEJEDOR PONCHOS O MANTAS TELAR ACCIONADO A MANO'),\r\n" + 
			"(4377,'TEJEDORES DE ESTERAS Y FUNCOS'),\r\n" + 
			"(4378,'TEJERO Y ADOBERO A MANO'),\r\n" + 
			"(4379,'TELEFONISTA, PUBLICA O PRIVADA'),\r\n" + 
			"(4380,'TELEGRAFISTA'),\r\n" + 
			"(4381,'TELEGRAFISTA'),\r\n" + 
			"(4382,'TELETIPISTA, TELEX'),\r\n" + 
			"(4383,'TEMPLADOR DE METALES'),\r\n" + 
			"(4384,'TENDEDOR DE TABACO'),\r\n" + 
			"(4385,'TENEDOR DE LIBROS'),\r\n" + 
			"(4386,'TENOR'),\r\n" + 
			"(4387,'TEOLOGO'),\r\n" + 
			"(4388,'TERAPEUTA, READAPTACION FISICA'),\r\n" + 
			"(4389,'TERAPEUTA, READAPTACION PROFESIONAL'),\r\n" + 
			"(4390,'TERCER OFICIAL, MAQUINISTA/MARINA MERCANTE'),\r\n" + 
			"(4391,'TERRAPLENISTA,MINAS'),\r\n" + 
			"(4392,'TERREFACTOR DE TABACO'),\r\n" + 
			"(4393,'TERRERISTA, MINAS'),\r\n" + 
			"(4394,'TESORERO'),\r\n" + 
			"(4395,'TIMONEL DE BARCO'),\r\n" + 
			"(4396,'TINTERILLERO'),\r\n" + 
			"(4397,'TINTORERO DE CUEROS'),\r\n" + 
			"(4398,'TINTORERO DE FIBRAS'),\r\n" + 
			"(4399,'TINTORERO DE HILADOS'),\r\n" + 
			"(4400,'TINTORERO DE PIELES A MANO'),\r\n" + 
			"(4401,'TINTORERO DE ROPAS'),\r\n" + 
			"(4402,'TINTORERO DE TEJIDOS'),\r\n" + 
			"(4403,'TIPEO POR COMPUTADORA'),\r\n" + 
			"(4404,'TIPOGRAFO EN GENERAL'),\r\n" + 
			"(4405,'TIPOGRAFO OPERADOR DE PRENSAS DE IMPRIMIR'),\r\n" + 
			"(4406,'TIRADOR DE PRUEBAS DE CLISES GRABADOS'),\r\n" + 
			"(4407,'TITIRITERO'),\r\n" + 
			"(4408,'TOLVERO,MINAS Y CANTERAS'),\r\n" + 
			"(4409,'TOMADOR DE MUESTRAS,MINAS'),\r\n" + 
			"(4410,'TONELERO'),\r\n" + 
			"(4411,'TONELERO-SALADOR, PESCA'),\r\n" + 
			"(4412,'TOPIQUERO'),\r\n" + 
			"(4413,'TOPOGRAFO, (SUELOS)'),\r\n" + 
			"(4414,'TOPOGRAFO, FOTOGEOMETRIA'),\r\n" + 
			"(4415,'TOPOGRAFO, HIDROGRAFICO'),\r\n" + 
			"(4416,'TORCEDOR DE HILO O HILAZA'),\r\n" + 
			"(4417,'TORCEDOR DE MECHAS'),\r\n" + 
			"(4418,'TORCEDOR DE TABACO A MANO,ELABORACION CIGARROS'),\r\n" + 
			"(4419,'TORCEDOR DE TABACO A MAQ. ELABORACION DE CIGARROS'),\r\n" + 
			"(4420,'TORERO'),\r\n" + 
			"(4421,'TORNERO'),\r\n" + 
			"(4422,'TORNERO DE EMBUTIR'),\r\n" + 
			"(4423,'TORNERO EN TORNO DE PEDAL, LOZA Y PORCELANA'),\r\n" + 
			"(4424,'TORNERO, LABRA  DE PIEDRA'),\r\n" + 
			"(4425,'TORNERO,LABRA DE MADERA'),\r\n" + 
			"(4426,'TORNERO,LABRA DE METALES'),\r\n" + 
			"(4427,'TORNERO-ALFARERO EN TORNO DE PEDAL'),\r\n" + 
			"(4428,'TORNERO-REPUJADOR ORFEBRERIA'),\r\n" + 
			"(4429,'TORREFACTOR DE ACHICORIA Y OTROS SUCEDANEOS'),\r\n" + 
			"(4430,'TORREFACTOR DE CAFE'),\r\n" + 
			"(4431,'TORRERO DE FARO,AEROPUERTO Y PUERTOS'),\r\n" + 
			"(4432,'TOSTADOR DE CACAHUATES O ALMENDRAS'),\r\n" + 
			"(4433,'TOSTADOR DE CACAO'),\r\n" + 
			"(4434,'TOSTADOR DE CAFE'),\r\n" + 
			"(4435,'TOSTADOR, TRATAMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(4436,'TRABAJADOR AGRICOLA'),\r\n" + 
			"(4437,'TRABAJADOR AGRICOLA CALIFICADO, ALGODON'),\r\n" + 
			"(4438,'TRABAJADOR AGRICOLA CALIFICADO, ARBOLES FRUTALES'),\r\n" + 
			"(4439,'TRABAJADOR AGRICOLA CALIFICADO, ARBUSTOS'),\r\n" + 
			"(4440,'TRABAJADOR AGRICOLA CALIFICADO, ARROZ'),\r\n" + 
			"(4441,'TRABAJADOR AGRICOLA CALIFICADO, CACAHUETES'),\r\n" + 
			"(4442,'TRABAJADOR AGRICOLA CALIFICADO, CACAO'),\r\n" + 
			"(4443,'TRABAJADOR AGRICOLA CALIFICADO, CAÐA DE AZUCAR'),\r\n" + 
			"(4444,'TRABAJADOR AGRICOLA CALIFICADO, CAFE'),\r\n" + 
			"(4445,'TRABAJADOR AGRICOLA CALIFICADO, CESPED'),\r\n" + 
			"(4446,'TRABAJADOR AGRICOLA CALIFICADO, COSECHA/ARBUSTOS'),\r\n" + 
			"(4447,'TRABAJADOR AGRICOLA CALIFICADO, CULTIVO DE HONGOS'),\r\n" + 
			"(4448,'TRABAJADOR AGRICOLA CALIFICADO, CULTIVO EXTENSIVO'),\r\n" + 
			"(4449,'TRABAJADOR AGRICOLA CALIFICADO, CULTIVOS DE SUBSISTENCIA'),\r\n" + 
			"(4450,'TRABAJADOR AGRICOLA CALIFICADO, HEVEA'),\r\n" + 
			"(4451,'TRABAJADOR AGRICOLA CALIFICADO, HORTALIZAS'),\r\n" + 
			"(4452,'TRABAJADOR AGRICOLA CALIFICADO, HORTICULTURA'),\r\n" + 
			"(4453,'TRABAJADOR AGRICOLA CALIFICADO, HUERTOS'),\r\n" + 
			"(4454,'TRABAJADOR AGRICOLA CALIFICADO, IRRIGACION'),\r\n" + 
			"(4455,'TRABAJADOR AGRICOLA CALIFICADO, LINO'),\r\n" + 
			"(4456,'TRABAJADOR AGRICOLA CALIFICADO, LUPULO'),\r\n" + 
			"(4457,'TRABAJADOR AGRICOLA CALIFICADO, PATATAS'),\r\n" + 
			"(4458,'TRABAJADOR AGRICOLA CALIFICADO, PLANTACIONES/ARBUSTOS'),\r\n" + 
			"(4459,'TRABAJADOR AGRICOLA CALIFICADO, PLANTACIONES/TE'),\r\n" + 
			"(4460,'TRABAJADOR AGRICOLA CALIFICADO, POLICULTIVOS'),\r\n" + 
			"(4461,'TRABAJADOR AGRICOLA CALIFICADO, REMOLACHA'),\r\n" + 
			"(4462,'TRABAJADOR AGRICOLA CALIFICADO, TABACO'),\r\n" + 
			"(4463,'TRABAJADOR AGRICOLA CALIFICADO, TRIGO'),\r\n" + 
			"(4464,'TRABAJADOR AGRICOLA CALIFICADO, VITICULTURA'),\r\n" + 
			"(4465,'TRABAJADOR AGRICOLA CALIFICADO, VIVERO'),\r\n" + 
			"(4466,'TRABAJADOR AGRICOLA CALIFICADO, YUTE'),\r\n" + 
			"(4467,'TRABAJADOR CALIFICADO, APICULTURA'),\r\n" + 
			"(4468,'TRABAJADOR CALIFICADO, AVES Y PAJAROS SALVAJES'),\r\n" + 
			"(4469,'TRABAJADOR CALIFICADO, AVICULTURA'),\r\n" + 
			"(4470,'TRABAJADOR CALIFICADO, INCUBADORAS'),\r\n" + 
			"(4471,'TRABAJADOR CALIFICADO, SERICICULTURA'),\r\n" + 
			"(4472,'TRABAJADOR CARBONERO CALIFICADO, CARBON VEGETAL/TECNICAS TR'),\r\n" + 
			"(4473,'TRABAJADOR DE CASINO, PIN-BALL, BOWLING, BINGO Y SALAS DE J'),\r\n" + 
			"(4474,'TRABAJADOR DE PISCIGRANJAS'),\r\n" + 
			"(4475,'TRABAJADOR EN FERIAS Y PARQUES MECANICOS DE DIVERSIONES'),\r\n" + 
			"(4476,'TRABAJADOR EN LA CONSTRUCCION Y REPACIONES'),\r\n" + 
			"(4477,'TRABAJADOR FORESTAL CALIFICADO'),\r\n" + 
			"(4478,'TRABAJADOR FORESTAL CALIFICADO, DESTILACION DE MADERA/TECNI'),\r\n" + 
			"(4479,'TRABAJADOR FORESTAL CALIFICADO, REPOBLACION FORESTAL'),\r\n" + 
			"(4480,'TRABAJADOR FORESTAL CALIFICADO, SILVICULTURA'),\r\n" + 
			"(4481,'TRABAJADOR PECUARIO CALIFICADO'),\r\n" + 
			"(4482,'TRABAJADOR PECUARIO CALIFICADO, CRIADERO DE ANIMALES'),\r\n" + 
			"(4483,'TRABAJADOR PECUARIO CALIFICADO, GANADERIA'),\r\n" + 
			"(4484,'TRABAJADOR PECUARIO CALIFICADO, GANADO LANAR'),\r\n" + 
			"(4485,'TRABAJADOR PECUARIO CALIFICADO, GANADO PORCINO'),\r\n" + 
			"(4486,'TRABAJADOR PECUARIO CALIFICADO, GANADO VACUNO'),\r\n" + 
			"(4487,'TRABAJADOR, ANIMALES SALVAJES/PIELES FINAS'),\r\n" + 
			"(4488,'TRABAJADOR, CRIA DE PAJAROS SALVAJES'),\r\n" + 
			"(4489,'TRABAJADOR, PESCADOR CALIFICADO, PESCA DE SUBSISTENCIA'),\r\n" + 
			"(4490,'TRABAJADOR, ZOOLOGICO'),\r\n" + 
			"(4491,'TRABAJADORES Y PRACTICANTES DE DERECHO, OTROS'),\r\n" + 
			"(4492,'TRACTORISTA'),\r\n" + 
			"(4493,'TRADUCTOR'),\r\n" + 
			"(4494,'TRAGICO'),\r\n" + 
			"(4495,'TRAMITADOR AMBULANTE'),\r\n" + 
			"(4496,'TRAMITADOR DE DOCUMENTOS PARA SEPELIO'),\r\n" + 
			"(4497,'TRAMITADOR DE OFICINA'),\r\n" + 
			"(4498,'TRAMITADORES (REDACTAN CARTAS, LLENADOR FORMULARIOS, ETC)'),\r\n" + 
			"(4499,'TRAMPEROS'),\r\n" + 
			"(4500,'TRANSPORTADOR, LITOGRAFIA'),\r\n" + 
			"(4501,'TRANSPORTADOR,FOTOGRABADO'),\r\n" + 
			"(4502,'TRAPECISTA'),\r\n" + 
			"(4503,'TRAPERO,PREPARACION DE PASTA PARA PAPEL'),\r\n" + 
			"(4504,'TRAPICHERO, CAÑA DE AZUCAR'),\r\n" + 
			"(4505,'TRASCANADOR DE MADEJAS'),\r\n" + 
			"(4506,'TRASEGADOR DE VINOS'),\r\n" + 
			"(4507,'TRAZADOR DE CALDERERIA Y CHAPAS'),\r\n" + 
			"(4508,'TRAZADOR DE EBANISTERIA'),\r\n" + 
			"(4509,'TRAZADOR DE ESTRUCTURAS METALICAS'),\r\n" + 
			"(4510,'TRAZADOR DE GALIBOS, ASTILLEROS'),\r\n" + 
			"(4511,'TRAZADOR DE PLANCHAS Y CHAPAS METALICAS'),\r\n" + 
			"(4512,'TRAZADOR DE PRENDAS DE VESTIR, LENCERIA'),\r\n" + 
			"(4513,'TRAZADOR EN METALES'),\r\n" + 
			"(4514,'TRAZADOR SOBRE PIEDRA'),\r\n" + 
			"(4515,'TRAZADOR, DECORADO DE CERAMICA'),\r\n" + 
			"(4516,'TRAZADOR, LABRADO DE MADERA'),\r\n" + 
			"(4517,'TRECHEADOR DE MINAS Y CANTERAS'),\r\n" + 
			"(4518,'TREFILADOR A MANO'),\r\n" + 
			"(4519,'TREFILADOR A MAQUINA'),\r\n" + 
			"(4520,'TREFILADOR DE METALES PRECIOSOS'),\r\n" + 
			"(4521,'TRENZADOR DE CESTAS,DE SARRIAS'),\r\n" + 
			"(4522,'TRIADOR DE FIBRA'),\r\n" + 
			"(4523,'TRIPERO'),\r\n" + 
			"(4524,'TRIPULACION DE BARCOS PESQUEROS, OTROS'),\r\n" + 
			"(4525,'TRIPULANTE, CABINA/PASAJEROS'),\r\n" + 
			"(4526,'TRITURADOR, MINERALES'),\r\n" + 
			"(4527,'TRITURADOR-PULPERIZADOR, PROCEDIMIENTOS QUIMICOS Y AFINES'),\r\n" + 
			"(4528,'TROMBONISTA'),\r\n" + 
			"(4529,'TROMPETISTA'),\r\n" + 
			"(4530,'TRONZADOR DE PIEDRAS'),\r\n" + 
			"(4531,'TROPERO'),\r\n" + 
			"(4532,'TROQUILADOR DE CUEROS'),\r\n" + 
			"(4533,'TROZADOR, ARBOLES'),\r\n" + 
			"(4534,'TROZADOR, TRAVIESAS DE FERROCARRIL'),\r\n" + 
			"(4535,'TROZADOR, VIGAS'),\r\n" + 
			"(4536,'TUBERO EN GENERAL, DISTRIBUCION GAS, AIRE A PRESION, VAPOR'),\r\n" + 
			"(4537,'TUBEROS DE SONDEO'),\r\n" + 
			"(4538,'TUPISTA, LABRA DE MADERA'),\r\n" + 
			"(4539,'TURRONERO, PREPARADOR'),\r\n" + 
			"(4540,'UJIER'),\r\n" + 
			"(4541,'URBANISTA'),\r\n" + 
			"(4542,'URDIDOR'),\r\n" + 
			"(4543,'VACIADOR DE CERAMICA EN MOLDES'),\r\n" + 
			"(4544,'VACIADOR DE POZOS  NEGROS'),\r\n" + 
			"(4545,'VACUNADOR, VETERINARIO'),\r\n" + 
			"(4546,'VACUNADOR, VETERINARIO/AVES DE GRANJA'),\r\n" + 
			"(4547,'VAPORINO'),\r\n" + 
			"(4548,'VAREADOR'),\r\n" + 
			"(4549,'VEDETTE'),\r\n" + 
			"(4550,'VENDEDOR AMBULANTE PASAMANERIA, LENCERIA, MERCERIA'),\r\n" + 
			"(4551,'VENDEDOR AMBULANTE, ABARROTES'),\r\n" + 
			"(4552,'VENDEDOR AMBULANTE, ACEITE COMESTIBLE'),\r\n" + 
			"(4553,'VENDEDOR AMBULANTE, AGUA MINERAL, GASEOSAS, VINO, ETC.'),\r\n" + 
			"(4554,'VENDEDOR AMBULANTE, ALFALFA Y FORRAJE'),\r\n" + 
			"(4555,'VENDEDOR AMBULANTE, ALFOMBRAS. CORTINAS, TAPICES Y ARTICULO'),\r\n" + 
			"(4556,'VENDEDOR AMBULANTE, ANIMALES VIVOS: CONEJOS, GATOS, PERROS,'),\r\n" + 
			"(4557,'VENDEDOR AMBULANTE, ANTEOJOS Y LUNAS'),\r\n" + 
			"(4558,'VENDEDOR AMBULANTE, ANTICUCHOS'),\r\n" + 
			"(4559,'VENDEDOR AMBULANTE, ANTIGUEDADES'),\r\n" + 
			"(4560,'VENDEDOR AMBULANTE, ART. DE MESA: MANTELES, INDIVIDUALES, P'),\r\n" + 
			"(4561,'VENDEDOR AMBULANTE, ART. DOMEST.: COCINA, LAVADORA, REFRIGE'),\r\n" + 
			"(4562,'VENDEDOR AMBULANTE, ARTICULOS ARTESANALES'),\r\n" + 
			"(4563,'VENDEDOR AMBULANTE, ARTICULOS DE PLATA'),\r\n" + 
			"(4564,'VENDEDOR AMBULANTE, ARTICULOS DEPORTIVOS'),\r\n" + 
			"(4565,'VENDEDOR AMBULANTE, ARTICULOS PARA FIESTAS Y DISFRACES'),\r\n" + 
			"(4566,'VENDEDOR AMBULANTE, ARTICULOS RELIGIOSOS'),\r\n" + 
			"(4567,'VENDEDOR AMBULANTE, AVES VIVOS Y/O SUS CARNES'),\r\n" + 
			"(4568,'VENDEDOR AMBULANTE, CAFE TOSTADO, MOLIDO, ENVASADO Y/O GRAN'),\r\n" + 
			"(4569,'VENDEDOR AMBULANTE, CALZADOS, ZAPATILLAS, SANDALIAS, SLAPS,'),\r\n" + 
			"(4570,'VENDEDOR AMBULANTE, CAMARONES Y LANGOSTINOS'),\r\n" + 
			"(4571,'VENDEDOR AMBULANTE, CARAMELOS, CONFITES, CHOCOLATES, GALLET'),\r\n" + 
			"(4572,'VENDEDOR AMBULANTE, CARNE DE: BALLENA, LOBO MARINO, TORTUGA'),\r\n" + 
			"(4573,'VENDEDOR AMBULANTE, CARNES: PORCINO, VACUNO, ETC.'),\r\n" + 
			"(4574,'VENDEDOR AMBULANTE, CASSETTES (BLANCOS Y GRABADOS) Y DISCOS'),\r\n" + 
			"(4575,'VENDEDOR AMBULANTE, CATRES Y COLCHONES/ CAMAS'),\r\n" + 
			"(4576,'VENDEDOR AMBULANTE, CEBICHES Y DERIVADOS'),\r\n" + 
			"(4577,'VENDEDOR AMBULANTE, CEREALES: AVENA, CEBADA, TRIGO, ETC.'),\r\n" + 
			"(4578,'VENDEDOR AMBULANTE, CHURROS'),\r\n" + 
			"(4579,'VENDEDOR AMBULANTE, CIGARRO, TABACO, PIPAS E IMPLEMENTOS PA'),\r\n" + 
			"(4580,'VENDEDOR AMBULANTE, COCA'),\r\n" + 
			"(4581,'VENDEDOR AMBULANTE, COCHINILLA'),\r\n" + 
			"(4582,'VENDEDOR AMBULANTE, COMIDAS PREPARADAS EN LA CALLE, OTROS'),\r\n" + 
			"(4583,'VENDEDOR AMBULANTE, CORTEZAS Y HIERBAS/ USO MEDICINAL'),\r\n" + 
			"(4584,'VENDEDOR AMBULANTE, CUADROS Y ESCULTURAS'),\r\n" + 
			"(4585,'VENDEDOR AMBULANTE, DIARIOS Y REVISTAS / CANILLITAS'),\r\n" + 
			"(4586,'VENDEDOR AMBULANTE, EMOLIENTE'),\r\n" + 
			"(4587,'VENDEDOR AMBULANTE, ESPECERIAS: CANELA, CLAVO DE OLOR, PIMI'),\r\n" + 
			"(4588,'VENDEDOR AMBULANTE, FLORES'),\r\n" + 
			"(4589,'VENDEDOR AMBULANTE, FRUTA FRESCA'),\r\n" + 
			"(4590,'VENDEDOR AMBULANTE, HELADOS, HIELO, MARCIANOS, ETC.'),\r\n" + 
			"(4591,'VENDEDOR AMBULANTE, HORTALIZAS: AJO, CEBOLLA, CHOCLO, VAINI'),\r\n" + 
			"(4592,'VENDEDOR AMBULANTE, HULES Y/O MARROQUINES'),\r\n" + 
			"(4593,'VENDEDOR AMBULANTE, JUGOS Y REFRESCOS'),\r\n" + 
			"(4594,'VENDEDOR AMBULANTE, JUGUETES'),\r\n" + 
			"(4595,'VENDEDOR AMBULANTE, LEÑA O CARBON'),\r\n" + 
			"(4596,'VENDEDOR AMBULANTE, LIBROS Y NOVELAS'),\r\n" + 
			"(4597,'VENDEDOR AMBULANTE, MALETAS Y MALETINES / CARTERAS'),\r\n" + 
			"(4598,'VENDEDOR AMBULANTE, MARISCOS: CHOROS, CONCHAS, ETC.'),\r\n" + 
			"(4599,'VENDEDOR AMBULANTE, MENESTRAS: FRIJOLES, GARBANZOS, LENTEJA'),\r\n" + 
			"(4600,'VENDEDOR AMBULANTE, MERCERIA: AGUJAS, ADORNOS DE VESTIDO, B'),\r\n" + 
			"(4601,'VENDEDOR AMBULANTE, MUEBLES PARA EL HOGAR'),\r\n" + 
			"(4602,'VENDEDOR AMBULANTE, OTROS'),\r\n" + 
			"(4603,'VENDEDOR AMBULANTE, PAN, PASTELES'),\r\n" + 
			"(4604,'VENDEDOR AMBULANTE, PESCADOS: BONITO, JUREL, PEJERREY, TRUC'),\r\n" + 
			"(4605,'VENDEDOR AMBULANTE, PICANTES'),\r\n" + 
			"(4606,'VENDEDOR AMBULANTE, PLANTAS Y SEMILLAS'),\r\n" + 
			"(4607,'VENDEDOR AMBULANTE, PRENDAS DE VESTIR: CAMISAS, CARTERAS, P'),\r\n" + 
			"(4608,'VENDEDOR AMBULANTE, PRODUCTOS ALIMENTICIOS PARA ANIMALES/ A'),\r\n" + 
			"(4609,'VENDEDOR AMBULANTE, PRODUCTOS FARMACEUTICOS: ALCOHOL, ALGODON'),\r\n" + 
			"(4610,'VENDEDOR AMBULANTE, PRODUCTOS LACTEOS, FIDEOS, HARINAS, AZU'),\r\n" + 
			"(4611,'VENDEDOR AMBULANTE, RAICES DE PLANTAS/ USO MEDICINAL'),\r\n" + 
			"(4612,'VENDEDOR AMBULANTE, RASPADILLAS'),\r\n" + 
			"(4613,'VENDEDOR AMBULANTE, RELOJES'),\r\n" + 
			"(4614,'VENDEDOR AMBULANTE, REPARTIDOR DE LECHE'),\r\n" + 
			"(4615,'VENDEDOR AMBULANTE, REPUESTO Y/O ART. DE FERRETERIA'),\r\n" + 
			"(4616,'VENDEDOR AMBULANTE, SALCHIPAPAS'),\r\n" + 
			"(4617,'VENDEDOR AMBULANTE, SANDWICH'),\r\n" + 
			"(4618,'VENDEDOR AMBULANTE, SOMBREROS'),\r\n" + 
			"(4619,'VENDEDOR AMBULANTE, TELAS Y/O TEJIDOS'),\r\n" + 
			"(4620,'VENDEDOR AMBULANTE, TUBERCULOS: CAMOTE, PAPA, YUCA, ETC.'),\r\n" + 
			"(4621,'VENDEDOR AMBULANTE, UTENSILIOS DE COCINA: CACEROLAS, CUCHIL'),\r\n" + 
			"(4622,'VENDEDOR AMBULANTE, UTILES DE ESCRITORIO: BORRADORES, CUADER'),\r\n" + 
			"(4623,'VENDEDOR AMBULANTE; ACEITE PARA AUTOS, LUBRICANTES (ENVASAD'),\r\n" + 
			"(4624,'VENDEDOR AMBULANTE; COSMETICOS, PERFUMES, LOCION, ETC.'),\r\n" + 
			"(4625,'VENDEDOR AMBULANTE; ESCOBAS, ESCOBILLAS, ESCOBILLONES, ETC.'),\r\n" + 
			"(4626,'VENDEDOR AMBULANTE; GAS / REPARTIDOR EN CAMIONETA O TRICICLO'),\r\n" + 
			"(4627,'VENDEDOR AMBULANTE; JABONES, DETERGENTES, ETC.'),\r\n" + 
			"(4628,'VENDEDOR AMBULANTE; PASTA DENTRIFICA, PAPEL HIGIENICO, ETC.'),\r\n" + 
			"(4629,'VENDEDOR AMBULANTE; PRODUCTOS DE: ORNELLA, UNIQUE, YAMBAL,'),\r\n" + 
			"(4630,'VENDEDOR DE BOLETOS Y PASAJES DE VIAJE AEREO'),\r\n" + 
			"(4631,'VENDEDOR DE BOLETOS, CAMIONETA RURAL, MICROBUSES, OMNIBUS,'),\r\n" + 
			"(4632,'VENDEDOR DE ESTAMPILLAS'),\r\n" + 
			"(4633,'VENDEDOR DE POLIZAS DE SEGUROS'),\r\n" + 
			"(4634,'VENDEDOR EN KIOSCO'),\r\n" + 
			"(4635,'VENDEDOR EN PUESTO DE MERCADO'),\r\n" + 
			"(4636,'VENDEDOR, ABARROTES/ABACERO (BODEGUERO)'),\r\n" + 
			"(4637,'VENDEDOR, ABARROTES/COMERCIO AL POR MAYOR'),\r\n" + 
			"(4638,'VENDEDOR, ARTESANIA'),\r\n" + 
			"(4639,'VENDEDOR, BIENES RAICES'),\r\n" + 
			"(4640,'VENDEDOR, CARBON'),\r\n" + 
			"(4641,'VENDEDOR, CARNE'),\r\n" + 
			"(4642,'VENDEDOR, CARTON/PAPEL'),\r\n" + 
			"(4643,'VENDEDOR, CIGARRILLOS'),\r\n" + 
			"(4644,'VENDEDOR, COMERCIO'),\r\n" + 
			"(4645,'VENDEDOR, COMERCIO AL POR MAYOR'),\r\n" + 
			"(4646,'VENDEDOR, COMERCIO NEP'),\r\n" + 
			"(4647,'VENDEDOR, FARMACIA'),\r\n" + 
			"(4648,'VENDEDOR, FERRETERIA'),\r\n" + 
			"(4649,'VENDEDOR, FLORES'),\r\n" + 
			"(4650,'VENDEDOR, FRUTAS'),\r\n" + 
			"(4651,'VENDEDOR, HERBOLARIOS/HIERBAS'),\r\n" + 
			"(4652,'VENDEDOR, INDUSTRIA MANUFACTURERA'),\r\n" + 
			"(4653,'VENDEDOR, LECHE'),\r\n" + 
			"(4654,'VENDEDOR, LIBROS/UTILES ESCOLARES'),\r\n" + 
			"(4655,'VENDEDOR, LICORERIA'),\r\n" + 
			"(4656,'VENDEDOR, LOZA/CRISTALERIA Y PORCELANA'),\r\n" + 
			"(4657,'VENDEDOR, MADERAS/TRIPLAY'),\r\n" + 
			"(4658,'VENDEDOR, MATERIALES DE CONSTRUCCION'),\r\n" + 
			"(4659,'VENDEDOR, MUEBLERIA'),\r\n" + 
			"(4660,'VENDEDOR, PASAMANERIA/MERCERIA'),\r\n" + 
			"(4661,'VENDEDOR, PELETERO'),\r\n" + 
			"(4662,'VENDEDOR, PERFUMERIA'),\r\n" + 
			"(4663,'VENDEDOR, PRENDAS DE VESTIR'),\r\n" + 
			"(4664,'VENDEDOR, PROPIEDADES INMUEBLES'),\r\n" + 
			"(4665,'VENDEDOR, PROVEEDOR/COMERCIO AL POR MAYOR'),\r\n" + 
			"(4666,'VENDEDOR, PULPA'),\r\n" + 
			"(4667,'VENDEDOR, REPUESTOS EN GENERAL'),\r\n" + 
			"(4668,'VENDEDOR, SOMBREROS'),\r\n" + 
			"(4669,'VENDEDOR, TECNICO'),\r\n" + 
			"(4670,'VENDEDOR, ZAPATERIA'),\r\n" + 
			"(4671,'VENDEDORES DE ARTEFACTOS ELECTRICOS'),\r\n" + 
			"(4672,'VENDEDORES DE LIBROS'),\r\n" + 
			"(4673,'VENDEDORES POR TELEFONO'),\r\n" + 
			"(4674,'VENTRILOCUO'),\r\n" + 
			"(4675,'VERIFICADOR DEL OPERADOR DE MAQUINA PERFORADORA DE TARJETAS'),\r\n" + 
			"(4676,'VERIFICADOR, NAVAL'),\r\n" + 
			"(4677,'VERIFICADOR, SOLICITUDES DE INDEMNIZACION'),\r\n" + 
			"(4678,'VESTIMIENTOS CON HORMIGON'),\r\n" + 
			"(4679,'VETERINARIO'),\r\n" + 
			"(4680,'VETERINARIO EN SALUD PUBLICA, TECNICO'),\r\n" + 
			"(4681,'VETERINARIO, CIRUGIA'),\r\n" + 
			"(4682,'VETERINARIO, EPIDEMIOLOGIA'),\r\n" + 
			"(4683,'VETERINARIO, OTROS'),\r\n" + 
			"(4684,'VETERINARIO, SALUD PUBLICA, PROFESIONAL'),\r\n" + 
			"(4685,'VIAJANTE, COMERCIO/AGENTE'),\r\n" + 
			"(4686,'VICARIO'),\r\n" + 
			"(4687,'VICE-MINISTRO (DIRECTOR SUPERIOR)'),\r\n" + 
			"(4688,'VICE-PRESIDENTE DE LA REPUBLICA'),\r\n" + 
			"(4689,'VICE-PRESIDENTE DEL CONGRESO CONSTITUYENTE DEMOCRATICO (CCD'),\r\n" + 
			"(4690,'VICE-RECTOR'),\r\n" + 
			"(4691,'VIDRIADOR DE CERAMICA'),\r\n" + 
			"(4692,'VIDRIERO, COLOCADOR DE VIDRIOS'),\r\n" + 
			"(4693,'VIGILANTE'),\r\n" + 
			"(4694,'VIGILANTE DE ESTABLECIMIENTO PENAL Y OTROS CENTROS TUTELARE'),\r\n" + 
			"(4695,'VIGILANTE DE MONTE'),\r\n" + 
			"(4696,'VIGILANTE DE SEGURIDAD (PRIVADOS)'),\r\n" + 
			"(4697,'VIGILANTE, HORARIOS DE TRABAJO'),\r\n" + 
			"(4698,'VIGILANTE, MUSEO'),\r\n" + 
			"(4699,'VIGILANTE, NOCTURNO'),\r\n" + 
			"(4700,'VIGILANTES DE COMPUERTAS,SERVICIOS DE AGUA'),\r\n" + 
			"(4701,'VINAGRERO'),\r\n" + 
			"(4702,'VINICULTOR'),\r\n" + 
			"(4703,'VIOLENERO,CONSTRUCTOR Y AFINADOR'),\r\n" + 
			"(4704,'VIOLINISTA'),\r\n" + 
			"(4705,'VIOLONCHELISTA'),\r\n" + 
			"(4706,'VISITADOR MEDICO'),\r\n" + 
			"(4707,'VISITADOR SOCIAL'),\r\n" + 
			"(4708,'VISITADOR, PRISIONES'),\r\n" + 
			"(4709,'VISTA DE ADUANAS'),\r\n" + 
			"(4710,'VITICULTOR'),\r\n" + 
			"(4711,'VOCAL DE LA CORTE SUPERIOR O SUPREMA'),\r\n" + 
			"(4712,'VOLATINERO'),\r\n" + 
			"(4713,'VOLEIBOLISTA'),\r\n" + 
			"(4714,'VOLQUETERO'),\r\n" + 
			"(4715,'VULCANIZADOR ARTIC. CAUCHO, EXCEPTO NEUMATICOS'),\r\n" + 
			"(4716,'VULCANIZADOR Y MOLDEADOR DE NEUMATICOS'),\r\n" + 
			"(4717,'VULCANOLOGO'),\r\n" + 
			"(4718,'XILOGRAFO'),\r\n" + 
			"(4719,'YESERO EN GENERAL'),\r\n" + 
			"(4720,'YUGUERO DE BUEYES'),\r\n" + 
			"(4721,'YUGUERO DE MULAS'),\r\n" + 
			"(4722,'YUGUERO DE MULAS Y BUEYES'),\r\n" + 
			"(4723,'YUNTERO DE MULAS Y BUEYES'),\r\n" + 
			"(4724,'ZAPATERO ORTOPEDISTA'),\r\n" + 
			"(4725,'ZAPATERO REMENDON (AMBULANTE)'),\r\n" + 
			"(4726,'ZINCADOR EN BAÐO CALIENTE'),\r\n" + 
			"(4727,'ZOOLOGO'),\r\n" + 
			"(4728,'ZOOLOGO, EMBRIOLOGIA'),\r\n" + 
			"(4729,'ZOOLOGO, ENTOMOLOGIA'),\r\n" + 
			"(4730,'ZOOLOGO, HISTOLOGIA'),\r\n" + 
			"(4731,'ZOOLOGO, ICTIOLOGIA'),\r\n" + 
			"(4732,'ZOOLOGO, MAMALOGISTA'),\r\n" + 
			"(4733,'ZOOLOGO, ORNITOLOGIA'),\r\n" + 
			"(4734,'ZOOLOGO, PARASITOLOGIA'),\r\n" + 
			"(4735,'ZOOLOGO, PISCICULTURA'),\r\n" + 
			"(4736,'ZOOLOGO, TAXONOMIA'),\r\n" + 
			"(4737,'ZOOTECNICO (INCLUYE INGENIEROS)'),\r\n" + 
			"(4738,'ZURCIDOR DE TEJIDOS');", nativeQuery = true)
	void insertarOcupacion4();

	
	@Query(value="insert into tipo_contrato(id_tip_contrato, descripcion) VALUES (1, 'A DOMICILIO'),"
			+ "(2, 'A PLAZO INDETERMINADO - D.LEG. 728'),\r\n" + 
			"(3, 'A TIEMPO PARCIAL'),\r\n" + 
			"(4, 'ADMINISTRATIVO DE SERVICIOS - D.LEG 1057 (1)'),\r\n" + 
			"(5, 'AGRARIO - LEY 27360'),\r\n" + 
			"(6, 'DE EMERGENCIA'),\r\n" + 
			"(7, 'DE EXPORTACIÓN NO TRADICIONAL  D.LEY 22342'),\r\n" + 
			"(8, 'DE EXTRANJERO - D.LEG.689'),\r\n" + 
			"(9, 'DE SUPLENCIA'),\r\n" + 
			"(10, 'DE TEMPORADA'),\r\n" + 
			"(12, 'FUTBOLISTAS PROFESIONALES'),\r\n" + 
			"(13, 'GERENTE PÚBLICO - D.LEG. 1024 (1)'),\r\n" + 
			"(14, 'INTERMITENTE'),\r\n" + 
			"(15, 'MIGRANTE ANDINO DECISIÓN 545'),\r\n" + 
			"(16, 'NOMBRADO - D.LEG. N.° 276 (1)'),\r\n" + 
			"(17, 'OCASIONAL'),\r\n" + 
			"(18, 'OTROS NO PREVISTOS'),\r\n" + 
			"(19, 'PARA OBRA DETERMINADA O SERVICIO ESPECÍFICO'),\r\n" + 
			"(20, 'POR INICIO O INCREMENTO DE ACTIVIDAD'),\r\n" + 
			"(21, 'POR NECESIDADES DEL MERCADO'),\r\n" + 
			"(22, 'POR RECONVERSIÓN EMPRESARIAL'),\r\n" + 
			"(23, 'SERVICIOS PERSONALES  - APLICABLES A LOS REGÍM. DE CARRERA (1)');", nativeQuery = true)
	void insertarTipoContrato();
	
	
	@Query(value="insert into reg_salud(id_reg_salud, descripcion) VALUES (1,'ESSALUD AGRARIO/ACUÍCOLA')," + 
			"(2,'ESSALUD PENSIONISTAS')," + 
			"(3,'ESSALUD REGULAR (Exclusivamente)')," + 
			"(4,'ESSALUD REGULAR Y EPS/SERV. PROPIOS')," + 
			"(5,'ESSALUD TRABAJADORES PESQUEROS')," + 
			"(6,'ESSALUD TRABAJADORES PESQUEROS Y EPS(SERV.PROPIOS)')," + 
			"(7,'SANIDAD DE FFAA Y POLICIALES (1)')," + 
			"(8,'SIS – MICROEMPRESA(2)');", nativeQuery = true)
	void insertarRegSalud();
	
	
	
	@Query(value="insert into pdo_mes(id_pdo_mes, abrev, descripcion, dias_feriado_calend,cantidad_dias,dias_feriados) VALUES (1, 'ENE','ENERO',1,31,'1')," + 
			"(6, 'JUN','JUNIO',1,30,'29')," + 
			"(7, 'JUL','JULIO',2,31,'28,29')," + 
			"(8, 'AGO','AGOSTO',1,31,'30')," + 
			"(10, 'OCT','OCTUBRE',1,31,'8')," + 
			"(11, 'NOV','NOVIEMBRE',1,30,'1')," + 
			"(12, 'DIC','DICIEMBRE',2,31,'8,25');" + 
			"", nativeQuery = true)
	void insertarPdoMes();
	
	@Query(value="insert into pdo_mes(id_pdo_mes, abrev, descripcion, dias_feriado_calend,cantidad_dias) VALUES " + 
			"(2, 'FEB','FEBRERO',0,29)," + 
			"(3, 'MAR','MARZO',0,31)," + 
			"(4, 'ABR','ABRIL',2,30)," + 
			"(5, 'MAY','MAYO',1,31)," + 
			"(9, 'SEP','SEPTIEMBRE',0,30);", nativeQuery = true)
	void insertarPdoMesSinFeriado();
	
}
