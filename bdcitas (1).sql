-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-03-2022 a las 23:33:57
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcitas`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarHist` (`cod_hist` INT(10), `ant` VARCHAR(60), `Motivo` VARCHAR(60), `enfer` VARCHAR(20), `examen` VARCHAR(45))  begin

UPDATE Historia 
SET antecedente=ant, Motivo_Consulta=Motivo, Enfermedad=enfer,Examenes=examen
WHERE idHistoria=cod_hist;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarMed` (`cod_med` INT(10), `nom` VARCHAR(30), `Apepat` VARCHAR(30), `Apemat` VARCHAR(30), `p_Telefono` VARCHAR(10), `p_Email` VARCHAR(35), `idEspec` INT(10))  begin

UPDATE medico 
SET Nombre=nom, apepat=Apepat, apemat= Apemat, Telefono=p_Telefono,Email=p_Email, idespecialidad=idEspec
WHERE id_medico=cod_med;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarPac` (IN `codpac` INT(10), IN `p_DNI` VARCHAR(8), IN `nom` VARCHAR(30), IN `Apepat` VARCHAR(30), IN `Apemat` VARCHAR(30), IN `p_Telefono` VARCHAR(10), IN `p_Email` VARCHAR(35), IN `p_direccion` VARCHAR(30))  NO SQL
begin 
UPDATE usuario 
SET DNI=p_DNI,Nombre=nom, apellidopat=Apepat, apellidomat= Apemat, telefono=p_Telefono,email=p_Email, direccion=p_direccion 
WHERE id_usuario=codpac; 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarPresc` (`idPresc` INT(10), `rece` VARCHAR(100), `recom` VARCHAR(100), `fecha_p` VARCHAR(20))  begin

UPDATE prescripcion 
SET Receta=rece, Recomendacion=recom, Fecha=fecha_p
WHERE idPrescripcion=idPresc;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listarMedico` ()  BEGIN
SELECT M.Nombre,M.apepat,M.apemat,M.Telefono,E.NomEspecilidad FROM MEDICO M
INNER JOIN ESPECIALIDAD E
ON(E.idespecialidad=M.idespecialidad);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_loguin` (`usu` VARCHAR(10), `pass` VARCHAR(10))  SELECT * FROM `usuario` WHERE `DNI` = usu AND `clave` = pass$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarMedico` (`p_Nombre` VARCHAR(30), `p_apepat` VARCHAR(30), `p_apemat` VARCHAR(30), `p_Telefono` VARCHAR(10), `p_Email` VARCHAR(35), `p_clave` VARCHAR(15), `p_idespecialidad` INT(10), `p_id` INT(10))  begin 
DECLARE p_id_medico INT;
 INSERT INTO MEDICO VALUES(null,p_Nombre,p_apepat,p_apemat,p_Telefono,p_Email,
 p_clave,p_idespecialidad,p_id
);
SET p_id_medico=(SELECT LAST_INSERT_ID());
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `idCita` int(5) NOT NULL,
  `id_medico` int(10) DEFAULT NULL,
  `id_especialidad` int(10) NOT NULL,
  `id_usuario` int(10) DEFAULT NULL,
  `Dia` varchar(15) DEFAULT NULL,
  `Hora` varchar(5) DEFAULT NULL,
  `DiaCrearCita` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`idCita`, `id_medico`, `id_especialidad`, `id_usuario`, `Dia`, `Hora`, `DiaCrearCita`) VALUES
(1, 1, 2, 2, '25/10/2018', '15:30', '2019-08-16'),
(4, 2, 3, 3, '10/04/2019', '12:30', '2019-10-21'),
(5, 5, 2, 2, '03/02/2022', '07:00', '2022-02-13'),
(7, 3, 1, 2, '02/01/2019', '9:30', '2022-03-15'),
(8, 2, 2, 2, '05/02/2022', '15:35', '2022-03-15'),
(10, 2, 3, 2, '15/02/2022', '15:35', '2022-03-15'),
(12, 2, 3, 2, '18/03/2022', '17:35', '2022-03-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobantepago`
--

CREATE TABLE `comprobantepago` (
  `Id_comprobante` char(6) NOT NULL,
  `Precio` int(11) DEFAULT NULL,
  `Estado` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `idespecialidad` int(10) NOT NULL,
  `NomEspecilidad` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`idespecialidad`, `NomEspecilidad`) VALUES
(1, 'Nutricion'),
(2, 'Dermatologia'),
(3, 'Gastroentorologia'),
(4, 'Cardiologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia`
--

CREATE TABLE `historia` (
  `idHistoria` int(6) NOT NULL,
  `id_usuario` int(10) NOT NULL,
  `antecedente` varchar(60) DEFAULT NULL,
  `Motivo_Consulta` varchar(60) DEFAULT NULL,
  `Enfermedad` varchar(20) DEFAULT NULL,
  `Examenes` varchar(45) DEFAULT NULL,
  `FechCreHist` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `historia`
--

INSERT INTO `historia` (`idHistoria`, `id_usuario`, `antecedente`, `Motivo_Consulta`, `Enfermedad`, `Examenes`, `FechCreHist`) VALUES
(3, 2, '                            Padre con gastritis cronica   ', '                               Acidez estomacal fuerte     ', 'Ninguna', 'Endoscopia', '2019-09-25'),
(5, 3, 'Padre sufre Tuberculosis ', 'Tos intensa', 'Ninguna', 'Pruebas de sangre', '2019-10-24');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `idHorario` int(5) NOT NULL,
  `Dia` varchar(15) DEFAULT NULL,
  `Hora` varchar(5) DEFAULT NULL,
  `idMedico` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `horario`
--

INSERT INTO `horario` (`idHorario`, `Dia`, `Hora`, `idMedico`) VALUES
(1, '25/10/2018', '15:30', 1),
(2, '10/04/2019', '12:30', 2),
(3, '04/03/2019', '10:40', 2),
(4, '02/01/2019', '9:30', 3),
(5, '10/10/2019', '17:30', 1),
(7, '29/10/2019', '11:00', 5),
(8, '03/02/2022', '07:00', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id_medico` int(10) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `apepat` varchar(30) DEFAULT NULL,
  `apemat` varchar(30) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Email` varchar(35) DEFAULT NULL,
  `clave` varchar(15) DEFAULT NULL,
  `idespecialidad` int(10) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`id_medico`, `Nombre`, `apepat`, `apemat`, `Telefono`, `Email`, `clave`, `idespecialidad`, `id`) VALUES
(1, 'Pedro', 'Altamiza', 'Huaman', '959981853', 'pedroah@gmail.com', '123', 2, 3),
(2, 'Jose', 'Pinto', 'Valdivia', '985426584', 'josepv@gmail.com', '123', 1, 3),
(3, 'Eva', 'Tejada', 'Espinoza', '954726358', 'evaespinoza@gmail.com', '123', 2, 3),
(4, 'Marcela', 'Leyva', 'Sartori', '984256895', 'marcela@gmail.com', '123', 2, 3),
(5, 'Carlos', 'Flores', 'Bustamante', '952661584', 'carlos@gmail.com', '123', 3, 3),
(6, 'Augusto', 'Chois', 'Malaga', '958661583', 'augustomalaga@gmail.com', '123', 3, 3),
(7, 'Juan', 'jggh', 'jggv', 'jggv', 'jgv@gd.com', 'jgvgv', 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil_usuario`
--

CREATE TABLE `perfil_usuario` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `perfil_usuario`
--

INSERT INTO `perfil_usuario` (`id`, `name`) VALUES
(1, 'administrador'),
(3, 'medico'),
(2, 'paciente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prescripcion`
--

CREATE TABLE `prescripcion` (
  `idPrescripcion` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idMedico` int(11) NOT NULL,
  `Receta` varchar(100) NOT NULL,
  `Recomendacion` varchar(100) NOT NULL,
  `Fecha` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prescripcion`
--

INSERT INTO `prescripcion` (`idPrescripcion`, `idPaciente`, `idMedico`, `Receta`, `Recomendacion`, `Fecha`) VALUES
(4, 2, 2, 'Amoxicilina', 'No comer comidas picantes', '20/11/2019');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL,
  `DNI` char(8) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidopat` varchar(30) DEFAULT NULL,
  `apellidomat` varchar(30) DEFAULT NULL,
  `email` varchar(35) NOT NULL,
  `clave` varchar(15) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `fechaRegistro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `DNI`, `nombre`, `apellidopat`, `apellidomat`, `email`, `clave`, `telefono`, `direccion`, `id`, `fechaRegistro`) VALUES
(1, '77036536', 'Juan', 'Flores', 'Meca', 'juanfm154@gmail.com', '123', '959981828', 'mz.33 lote 75', 1, '2019-09-25'),
(2, '45678752', 'Pedro', 'Solorzano', 'Baldoceda', 'pedro@gmail.com', '123', '945454875', 'mz.33 lote 7', 2, '2019-09-25'),
(3, '75584226', 'Cesar', 'Luna', 'Garcia', 'cesar@gmail.com', 'cesar', '954565655', 'Jr. Nicolas de pierola', 2, '2019-09-25'),
(4, '78954425', 'Javier', 'Fernandez', 'Farfan', 'javier@gmail.com', 'javier', '954821657', '2097 s hayden way', 2, '2019-09-25');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_medico` (`id_medico`),
  ADD KEY `FK_espec_cita` (`id_especialidad`);

--
-- Indices de la tabla `comprobantepago`
--
ALTER TABLE `comprobantepago`
  ADD PRIMARY KEY (`Id_comprobante`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`idespecialidad`);

--
-- Indices de la tabla `historia`
--
ALTER TABLE `historia`
  ADD PRIMARY KEY (`idHistoria`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`idHorario`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_medico`),
  ADD KEY `idespecialidad` (`idespecialidad`),
  ADD KEY `id` (`id`);

--
-- Indices de la tabla `perfil_usuario`
--
ALTER TABLE `perfil_usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indices de la tabla `prescripcion`
--
ALTER TABLE `prescripcion`
  ADD PRIMARY KEY (`idPrescripcion`),
  ADD KEY `idPaciente` (`idPaciente`),
  ADD KEY `idMedico` (`idMedico`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `idCita` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `idespecialidad` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `historia`
--
ALTER TABLE `historia`
  MODIFY `idHistoria` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `idHorario` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `id_medico` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `prescripcion`
--
ALTER TABLE `prescripcion`
  MODIFY `idPrescripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `FK_espec_cita` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`idespecialidad`),
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`);

--
-- Filtros para la tabla `historia`
--
ALTER TABLE `historia`
  ADD CONSTRAINT `historia_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `historia_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `medico_ibfk_1` FOREIGN KEY (`idespecialidad`) REFERENCES `especialidad` (`idespecialidad`),
  ADD CONSTRAINT `medico_ibfk_2` FOREIGN KEY (`id`) REFERENCES `perfil_usuario` (`id`);

--
-- Filtros para la tabla `prescripcion`
--
ALTER TABLE `prescripcion`
  ADD CONSTRAINT `prescripcion_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `prescripcion_ibfk_2` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`id_medico`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
