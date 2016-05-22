-- phpMyAdmin SQL Dump
-- version 4.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 22/05/2016 às 11:22
-- Versão do servidor: 5.5.49-0ubuntu0.14.04.1
-- Versão do PHP: 5.5.9-1ubuntu4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `accountManager`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `am_user`
--

CREATE TABLE `am_user` (
  `id` int(11) NOT NULL,
  `name` varchar(80) NOT NULL,
  `email` varchar(40) NOT NULL,
  `image` varchar(100) NOT NULL,
  `auth_type` varchar(40) NOT NULL,
  `password` varchar(200) NOT NULL,
  `token` varchar(200) NOT NULL,
  `token_expiration_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `am_user`
--

INSERT INTO `am_user` (`id`, `name`, `email`, `image`, `auth_type`, `password`, `token`, `token_expiration_date`) VALUES
(1, 'Thiengo Calopsita', 'thiengocalopsita@gmail.com', 'http://www.thiengo.com.br/img/system/logo/logo-thiengo-calopsita-70x70.png', 'full', '7c4a8d09ca3762af61e59520943dc26494f8941b', '5b609ee5b6b0818a80b80f7ff17ba75c8c5237d2', '0000-00-00 00:00:00'),
(2, 'Cleiton Ferreira', 'cleitonferreiraa@hotmail.com', 'http://www.thiengo.com.br/img/system/logo/logo-thiengo-calopsita-70x70.png', 'full', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'e3ad29a0f2031af907f37057c989dcbf53a5c65e', '2016-11-04 00:00:00');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `am_user`
--
ALTER TABLE `am_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `am_user`
--
ALTER TABLE `am_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
