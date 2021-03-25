-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 25, 2021 at 08:22 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `l-earn`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `answer_id` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `content` text NOT NULL,
  `rating` int(11) NOT NULL,
  `tutor_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `membership`
--

CREATE TABLE `membership` (
  `membership_id` int(11) NOT NULL,
  `validation_status` varchar(45) NOT NULL,
  `start_date` datetime NOT NULL,
  `payment_proof` varchar(45) NOT NULL,
  `expired_date` datetime NOT NULL,
  `member_id` int(11) NOT NULL,
  `subs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `category` varchar(45) NOT NULL,
  `content` varchar(45) NOT NULL,
  `time` datetime NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `subscription`
--

CREATE TABLE `subscription` (
  `subs_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `validity_periode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tutor`
--

CREATE TABLE `tutor` (
  `tutor_id` int(11) NOT NULL,
  `eligibility_proof` varchar(128) NOT NULL,
  `rating` int(11) NOT NULL,
  `validation_status` enum('valid','non-valid') NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tutor_payment`
--

CREATE TABLE `tutor_payment` (
  `payment_id` int(11) NOT NULL,
  `input_time` datetime NOT NULL,
  `payment_time` datetime DEFAULT NULL,
  `payment_status` enum('pending','paid','rejected') NOT NULL,
  `amount` int(11) NOT NULL,
  `answer_id` int(11) NOT NULL,
  `tutor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `bio` text DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`answer_id`),
  ADD KEY `fkIdx_39` (`tutor_id`),
  ADD KEY `fkIdx_45` (`question_id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `fkIdx_21` (`user_id`);

--
-- Indexes for table `membership`
--
ALTER TABLE `membership`
  ADD PRIMARY KEY (`membership_id`),
  ADD KEY `fkIdx_64` (`member_id`),
  ADD KEY `fkIdx_95` (`subs_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`),
  ADD KEY `fkIdx_30` (`member_id`);

--
-- Indexes for table `subscription`
--
ALTER TABLE `subscription`
  ADD PRIMARY KEY (`subs_id`);

--
-- Indexes for table `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`tutor_id`),
  ADD KEY `fkIdx_15` (`user_id`);

--
-- Indexes for table `tutor_payment`
--
ALTER TABLE `tutor_payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `fkIdx_77` (`answer_id`),
  ADD KEY `fkIdx_80` (`tutor_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `FK_38` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`),
  ADD CONSTRAINT `FK_44` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `FK_20` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `membership`
--
ALTER TABLE `membership`
  ADD CONSTRAINT `FK_63` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  ADD CONSTRAINT `FK_94` FOREIGN KEY (`subs_id`) REFERENCES `subscription` (`subs_id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK_29` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

--
-- Constraints for table `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `FK_14` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `tutor_payment`
--
ALTER TABLE `tutor_payment`
  ADD CONSTRAINT `FK_76` FOREIGN KEY (`answer_id`) REFERENCES `answer` (`answer_id`),
  ADD CONSTRAINT `FK_79` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
