-- phpMyAdmin SQL Dump
-- version 4.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 27/05/2016 às 21:40
-- Versão do servidor: 5.5.49-0ubuntu0.14.04.1
-- Versão do PHP: 5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `android`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `an_car`
--

CREATE TABLE `an_car` (
  `id` int(11) NOT NULL,
  `model` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `engine` varchar(45) DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `an_car`
--

INSERT INTO `an_car` (`id`, `model`, `brand`, `year`, `engine`, `image_path`, `price`) VALUES
(1, 'Car 1', 'Brand 1', 2010, 'W8', 'car_01.jpg', 'R$556.033,00'),
(2, 'Car 2', 'Brand 2', 2014, 'V12', 'car_02.jpg', 'R$997.486,00'),
(3, 'Car 3', 'Brand 3', 2010, '24 valvs', 'car_03.jpg', 'R$84.602,00'),
(4, 'Car 4', 'Brand 4', 2013, 'V12', 'car_04.jpg', 'R$477.001,00'),
(5, 'Car 5', 'Brand 5', 2013, 'V6', 'car_05.jpg', 'R$693.625,00'),
(6, 'Car 6', 'Brand 6', 2012, '24 valvs', 'car_06.jpg', 'R$925.185,00'),
(7, 'Car 7', 'Brand 7', 2010, 'V8', 'car_07.jpg', 'R$663.261,00'),
(8, 'Car 8', 'Brand 8', 2012, 'V6', 'car_08.jpg', 'R$90.742,00'),
(9, 'Car 9', 'Brand 9', 2013, 'W8', 'car_09.jpg', 'R$965.297,00'),
(10, 'Car 10', 'Brand 10', 2015, 'V8', 'car_10.jpg', 'R$514.515,00'),
(11, 'Car 11', 'Brand 11', 2013, 'V6', 'car_11.jpg', 'R$838.344,00'),
(12, 'Car 12', 'Brand 12', 2011, 'V6', 'car_12.jpg', 'R$324.303,00'),
(13, 'Car 13', 'Brand 13', 2009, 'V8', 'car_13.jpg', 'R$498.101,00'),
(14, 'Car 14', 'Brand 14', 2007, 'V4', 'car_14.jpg', 'R$517.235,00'),
(15, 'Car 15', 'Brand 15', 2011, 'V10', 'car_15.jpg', 'R$741.894,00'),
(16, 'Car 16', 'Brand 16', 2015, 'valvs', 'car_16.jpg', 'R$845.234,00'),
(17, 'Car 17', 'Brand 17', 2016, 'V8', 'car_17.jpg', 'R$981.548,00'),
(18, 'Car 18', 'Brand 18', 2014, 'V6', 'car_18.jpg', 'R$659.239,00');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `an_car`
--
ALTER TABLE `an_car`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `an_car`
--
ALTER TABLE `an_car`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
