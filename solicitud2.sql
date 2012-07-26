-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-07-2012 a las 22:31:16
-- Versión del servidor: 5.5.20
-- Versión de PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `solicitud2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `area`
--

CREATE TABLE IF NOT EXISTS `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `area`
--

INSERT INTO `area` (`id`, `descripcion`) VALUES
(2, 'Administración'),
(6, 'Comunicación'),
(4, 'Dirección'),
(1, 'Informática'),
(7, 'Recepción'),
(3, 'RRHH'),
(5, 'Servicios Generales');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE IF NOT EXISTS `articulo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `tipo` tinyint(4) NOT NULL,
  `tamano` varchar(45) DEFAULT NULL,
  `alto` varchar(45) DEFAULT NULL,
  `ancho` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id`, `descripcion`, `tipo`, `tamano`, `alto`, `ancho`, `color`) VALUES
(1, 'Resma de Hoja A4', 1, 'A4', '21 cm', '29 cm', 'blanco'),
(2, 'Swicht KVM', 1, 'P/ 3 host', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auditoria`
--

CREATE TABLE IF NOT EXISTS `auditoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hostname` varchar(45) NOT NULL,
  `hostip` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `accion` varchar(45) NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auditoria_usuario1` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE IF NOT EXISTS `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`id`, `descripcion`) VALUES
(8, 'Administrador'),
(3, 'Análista de sistemas'),
(1, 'Contador'),
(10, 'Director'),
(2, 'Diseñador Gráfico'),
(5, 'Gerente de Informática'),
(6, 'Gerente de ventas'),
(7, 'Gerente Técnico'),
(11, 'Limpiador'),
(4, 'Programador'),
(9, 'Tesorero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `articulo` int(11) NOT NULL,
  `solicitud` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`articulo`,`solicitud`),
  KEY `fk_articulo_has_solicitud_solicitud1` (`solicitud`),
  KEY `fk_articulo_has_solicitud_articulo1` (`articulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE IF NOT EXISTS `programa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`id`, `descripcion`) VALUES
(3, 'Costo Social de la Corrupción'),
(2, 'Desempeño Judicial, Transparencia y Acceso a '),
(1, 'Más Justicia'),
(4, 'Observatorio Latinoamericano de Justicia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `descripcion`) VALUES
(1, 'Administrador'),
(2, 'Manager'),
(3, 'Mortal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rubro`
--

CREATE TABLE IF NOT EXISTS `rubro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `descripcion_UNIQUE` (`descripcion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `rubro`
--

INSERT INTO `rubro` (`id`, `descripcion`) VALUES
(5, 'Articulos de Limpieza'),
(4, 'Consultorías'),
(1, 'Equipos Informáticos'),
(2, 'Infraestructura'),
(3, 'Mantenimiento y Reparación'),
(7, 'Otros'),
(6, 'Útiles de Oficina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE IF NOT EXISTS `solicitud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nro` int(11) NOT NULL,
  `fechasol` datetime NOT NULL,
  `fechaentrega` datetime DEFAULT NULL,
  `descripcion` text NOT NULL,
  `estado` varchar(45) NOT NULL DEFAULT 'pendiente',
  `usrsol` int(11) NOT NULL,
  `usrarpo` int(11) NOT NULL,
  `area` int(11) NOT NULL,
  `rubro` int(11) NOT NULL,
  `programa` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nro_UNIQUE` (`nro`),
  KEY `fk_solicitud_usuario1` (`usrsol`),
  KEY `fk_solicitud_usuario2` (`usrarpo`),
  KEY `fk_solicitud_area1` (`area`),
  KEY `fk_solicitud_rubro1` (`rubro`),
  KEY `fk_solicitud_programa1` (`programa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT '0',
  `password` varchar(80) NOT NULL,
  `rol` int(11) NOT NULL,
  `cargor` int(11) NOT NULL,
  `alta` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_usuario_rol` (`rol`),
  KEY `fk_usuario_cargo1` (`cargor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellido`, `username`, `email`, `telefono`, `estado`, `password`, `rol`, `cargor`, `alta`) VALUES
(5, 'System', 'Solicitud', 'system', 'admin@balem.net', '4554545455', 0, 'system', 1, 1, '0000-00-00 00:00:00'),
(6, 'Enrique', 'Rodriguez', 'erodriguez', 'erodriguez@balem.net', '+59582335064', 1, 'dc12a613487cfc433bdf981b7a65baf4', 1, 1, '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vusuario`
--
CREATE TABLE IF NOT EXISTS `vusuario` (
`id` int(11)
,`nombre` varchar(45)
,`apellido` varchar(45)
,`username` varchar(45)
,`email` varchar(45)
,`telefono` varchar(45)
,`estado` tinyint(1)
,`password` varchar(80)
,`rol` varchar(45)
,`cargo` varchar(45)
,`alta` datetime
);
-- --------------------------------------------------------

--
-- Estructura para la vista `vusuario`
--
DROP TABLE IF EXISTS `vusuario`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vusuario` AS select `us`.`id` AS `id`,`us`.`nombre` AS `nombre`,`us`.`apellido` AS `apellido`,`us`.`username` AS `username`,`us`.`email` AS `email`,`us`.`telefono` AS `telefono`,`us`.`estado` AS `estado`,`us`.`password` AS `password`,`rol`.`descripcion` AS `rol`,`car`.`descripcion` AS `cargo`,`us`.`alta` AS `alta` from ((`usuario` `us` join `rol`) join `cargo` `car`) where ((`car`.`id` = `us`.`cargor`) and (`rol`.`id` = `us`.`rol`));

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `auditoria`
--
ALTER TABLE `auditoria`
  ADD CONSTRAINT `fk_auditoria_usuario1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `fk_articulo_has_solicitud_articulo1` FOREIGN KEY (`articulo`) REFERENCES `articulo` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_articulo_has_solicitud_solicitud1` FOREIGN KEY (`solicitud`) REFERENCES `solicitud` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `fk_solicitud_usuario1` FOREIGN KEY (`usrsol`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_solicitud_usuario2` FOREIGN KEY (`usrarpo`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_solicitud_area1` FOREIGN KEY (`area`) REFERENCES `area` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_solicitud_rubro1` FOREIGN KEY (`rubro`) REFERENCES `rubro` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_solicitud_programa1` FOREIGN KEY (`programa`) REFERENCES `programa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuario_cargo1` FOREIGN KEY (`cargor`) REFERENCES `cargo` (`id`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
