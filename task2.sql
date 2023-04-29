-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Apr 29, 2023 at 08:36 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task2`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountbal`
--

CREATE TABLE `accountbal` (
  `Uid` varchar(30) NOT NULL,
  `Balance` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accountbal`
--

INSERT INTO `accountbal` (`Uid`, `Balance`) VALUES
('shivbhor44', 4300);

-- --------------------------------------------------------

--
-- Table structure for table `atmlogin`
--

CREATE TABLE `atmlogin` (
  `Uid` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `atmlogin`
--

INSERT INTO `atmlogin` (`Uid`, `password`) VALUES
('shivbhor44', 'shiv123');

-- --------------------------------------------------------

--
-- Table structure for table `transactionh`
--

CREATE TABLE `transactionh` (
  `Uid` varchar(11) NOT NULL,
  `Trid` int(12) NOT NULL,
  `trtype` text NOT NULL,
  `amount` float NOT NULL,
  `balance` float NOT NULL,
  `datetime` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transactionh`
--

INSERT INTO `transactionh` (`Uid`, `Trid`, `trtype`, `amount`, `balance`, `datetime`) VALUES
('shivbhor44', 1, 'Deposite', 100, 4000, '10.10'),
('shivbhor44', 2, 'Deposit', 200, 4300, '2023-04-23T14:35:44.765034400'),
('shivbhor44', 3, 'Withdraw', 1000, 3300, '2023-04-24T19:35:38.114369800');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transactionh`
--
ALTER TABLE `transactionh`
  ADD PRIMARY KEY (`Trid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactionh`
--
ALTER TABLE `transactionh`
  MODIFY `Trid` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
