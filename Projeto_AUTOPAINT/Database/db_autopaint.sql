-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28/07/2025 às 23:11
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_autopaint`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `servicos`
--

CREATE TABLE `servicos` (
  `id_servico` int(11) NOT NULL,
  `nome_cliente` varchar(45) NOT NULL,
  `descricao` varchar(250) NOT NULL,
  `modelo_carro` varchar(25) NOT NULL,
  `placa` char(7) NOT NULL,
  `valor` double(10,2) NOT NULL,
  `tempo_estimado` varchar(10) NOT NULL,
  `status_servico` varchar(20) DEFAULT 'PENDENTE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `servicos`
--

INSERT INTO `servicos` (`id_servico`, `nome_cliente`, `descricao`, `modelo_carro`, `placa`, `valor`, `tempo_estimado`, `status_servico`) VALUES
(1, 'Joao', 'Capo', 'FiatUno', '20PD41S', 150.00, '10', 'Cancelado'),
(2, 'Joao', 'capo', 'Palio', '0KS23S3', 1204.00, '3', 'Cancelado'),
(3, 'Joao', 'Porta Tras Dir', 'Virtus', 'KY31C64', 300.00, '2', 'Cancelado'),
(4, 'Joao', 'Capo', 'Punto', 'JH42VB1', 75.00, '2', 'Cancelado'),
(5, 'Joao', 'Capo Porta Malas', 'Fiat Uno', '95TG4WE', 320.00, '4', 'Cancelado'),
(6, 'Joao', 'Porta Lateral', 'Fiat Palio', 'JG23KZ1', 150.00, '6', 'Cancelado'),
(7, 'Joao', 'Porta', 'Fiat Palio', 'HGT234S', 250.00, '5', 'Cancelado'),
(8, 'Joao', 'Porta', 'Palio', 'KSF23AS', 100.00, '2', 'Finalizado'),
(9, 'Joao12', 'Porta', 'Palio', 'JSD23HF', 150.00, '2', 'Cancelado'),
(10, 'Joao', 'Porta', 'asdf', '231', 140.00, '2', 'Finalizado'),
(11, 'Joao', 'Capo', 'Palio', 'KASFJW2', 140.00, '2', 'Cancelado'),
(12, 'Joao', 'Porta Lat', 'Virtus', 'JS2KDS1', 150.00, '2', 'PENDENTE'),
(13, 'Joao', 'Caps', 'PortaMala', 'KF76SH2', 100.00, '10 Horas', 'PENDENTE'),
(14, 'Joao', 'Texte21', 'XLS', 'JF876DS', 150.00, '2 Dias', 'PENDENTE'),
(15, 'Joao', 'Caps', 'Aventador', 'OS987DS', 5000.00, '10 Dias', 'PENDENTE');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `tipo_usuario` char(3) NOT NULL
) ;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nome`, `cpf`, `telefone`, `email`, `senha`, `tipo_usuario`) VALUES
(1, 'Joao', '10470206969', '4988888888', 'Joao@gmail.com', '12345', 'ADM');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `servicos`
--
ALTER TABLE `servicos`
  ADD PRIMARY KEY (`id_servico`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `cpf` (`cpf`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `servicos`
--
ALTER TABLE `servicos`
  MODIFY `id_servico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
