-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 01, 2019 lúc 04:22 PM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dblazada`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `binhluan`
--

CREATE TABLE `binhluan` (
  `MABL` int(11) NOT NULL,
  `MANV` int(11) DEFAULT NULL,
  `MASP` int(11) DEFAULT NULL,
  `NOIDUNG` text DEFAULT NULL,
  `NGAYBINHLUAN` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MAHD` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `SOLUONG` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`MAHD`, `MASP`, `SOLUONG`) VALUES
(1, 1, 2),
(1, 2, 3),
(2, 1, 1),
(2, 34, 1),
(3, 1, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietkhuyenmai`
--

CREATE TABLE `chitietkhuyenmai` (
  `MASP` int(11) NOT NULL,
  `MAKM` int(11) NOT NULL,
  `PHANTRAMKM` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietkhuyenmai`
--

INSERT INTO `chitietkhuyenmai` (`MASP`, `MAKM`, `PHANTRAMKM`) VALUES
(1, 1, 49),
(2, 1, 49),
(3, 1, 49),
(4, 1, 49),
(5, 1, 49),
(6, 1, 49),
(7, 1, 49),
(8, 1, 49),
(9, 1, 49),
(10, 1, 49),
(11, 2, 50),
(12, 2, 50),
(13, 2, 50),
(14, 2, 50),
(56, 2, 50);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietsanpham`
--

CREATE TABLE `chitietsanpham` (
  `MACHITIET` int(11) NOT NULL,
  `MASP` int(11) NOT NULL,
  `TENCHITIET` text NOT NULL,
  `GIATRI` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietsanpham`
--

INSERT INTO `chitietsanpham` (`MACHITIET`, `MASP`, `TENCHITIET`, `GIATRI`) VALUES
(1, 1, '3D TV', 'No'),
(2, 1, 'Camera Back', '11 - 15 MP'),
(3, 1, 'Camera Front', '5 - 6 MP'),
(4, 1, 'Điều kiện', 'Mới'),
(5, 1, 'Curved TV', 'No'),
(6, 1, 'Kích thước màn hình', '4.7'),
(7, 1, 'Mẫu mã', '6s'),
(8, 1, 'Network Connections', '3G-HSPA|4G-LTE'),
(9, 1, 'Hệ điều hành', 'IOS'),
(10, 1, 'Operation System Version', 'IOS9'),
(11, 1, 'Trọng lượng (KG)', '0.2'),
(12, 1, 'Sản xuất tại', 'Trung quốc'),
(13, 1, 'RAM memory', '2GB'),
(14, 1, 'Sim type', 'SIM nano'),
(15, 1, 'Sim Slots', '1'),
(16, 1, 'Bộ nhớ trong', '64GB'),
(17, 1, 'Bảo hành', '12 tháng'),
(18, 2, '3D TV', 'No'),
(19, 2, 'Camera Back', '11 - 15 MP'),
(20, 2, 'Camera Front', '5 - 6 MP'),
(21, 2, 'Điều kiện', 'Mới'),
(22, 2, 'Curved TV', 'No'),
(23, 2, 'Kích thước màn hình', '4.7'),
(24, 2, 'Mẫu mã', '6s'),
(25, 2, 'Network Connections', '3G-HSPA|4G-LTE'),
(26, 2, 'Hệ điều hành', 'IOS'),
(27, 2, 'Operation System Version', 'IOS9'),
(28, 2, 'Trọng lượng (KG)', '0.2'),
(29, 2, 'Sản xuất tại', 'Trung quốc'),
(30, 2, 'RAM memory', '2GB'),
(31, 2, 'Sim type', 'SIM nano'),
(32, 2, 'Sim Slots', '1'),
(33, 2, 'Bộ nhớ trong', '64GB'),
(34, 2, 'Bảo hành', '12 tháng'),
(35, 3, '3D TV', 'No'),
(36, 3, 'Camera Back', '11 - 15 MP'),
(37, 3, 'Camera Front', '5 - 6 MP'),
(38, 3, 'Điều kiện', 'Mới'),
(39, 3, 'Curved TV', 'No'),
(40, 3, 'Kích thước màn hình', '4.7'),
(41, 3, 'Mẫu mã', '6s'),
(42, 3, 'Network Connections', '3G-HSPA|4G-LTE'),
(43, 3, 'Hệ điều hành', 'IOS'),
(44, 3, 'Operation System Version', 'IOS9'),
(45, 3, 'Trọng lượng (KG)', '0.2'),
(46, 3, 'Sản xuất tại', 'Trung quốc'),
(47, 3, 'RAM memory', '2GB'),
(48, 3, 'Sim type', 'SIM nano'),
(49, 3, 'Sim Slots', '1'),
(50, 3, 'Bộ nhớ trong', '64GB'),
(51, 3, 'Bảo hành', '12 tháng'),
(52, 4, '3D TV', 'No'),
(53, 4, 'Camera Back', '11 - 15 MP'),
(54, 4, 'Camera Front', '5 - 6 MP'),
(55, 4, 'Điều kiện', 'Mới'),
(56, 4, 'Curved TV', 'No'),
(57, 4, 'Kích thước màn hình', '4.7'),
(58, 4, 'Mẫu mã', '6s'),
(59, 4, 'Network Connections', '3G-HSPA|4G-LTE'),
(60, 4, 'Hệ điều hành', 'IOS'),
(61, 4, 'Operation System Version', 'IOS9'),
(62, 4, 'Trọng lượng (KG)', '0.2'),
(63, 4, 'Sản xuất tại', 'Trung quốc'),
(64, 4, 'RAM memory', '2GB'),
(65, 4, 'Sim type', 'SIM nano'),
(66, 4, 'Sim Slots', '1'),
(67, 4, 'Bộ nhớ trong', '64GB'),
(68, 4, 'Bảo hành', '12 tháng'),
(69, 5, '3D TV', 'No'),
(70, 5, 'Camera Back', '11 - 15 MP'),
(71, 5, 'Camera Front', '5 - 6 MP'),
(72, 5, 'Điều kiện', 'Mới'),
(73, 5, 'Curved TV', 'No'),
(74, 5, 'Kích thước màn hình', '4.7'),
(75, 5, 'Mẫu mã', '6s'),
(76, 5, 'Network Connections', '3G-HSPA|4G-LTE'),
(77, 5, 'Hệ điều hành', 'IOS'),
(78, 5, 'Operation System Version', 'IOS9'),
(79, 5, 'Trọng lượng (KG)', '0.2'),
(80, 5, 'Sản xuất tại', 'Trung quốc'),
(81, 5, 'RAM memory', '2GB'),
(82, 5, 'Sim type', 'SIM nano'),
(83, 5, 'Sim Slots', '1'),
(84, 5, 'Bộ nhớ trong', '64GB'),
(85, 5, 'Bảo hành', '12 tháng'),
(86, 12, '3D TV', 'No'),
(87, 12, 'Camera Back', '11 - 15 MP'),
(88, 12, 'Camera Front', '5 - 6 MP'),
(89, 12, 'Điều kiện', 'Mới'),
(90, 12, 'Curved TV', 'No'),
(91, 12, 'Kích thước màn hình', '4.7'),
(92, 12, 'Mẫu mã', '6s'),
(93, 12, 'Network Connections', '3G-HSPA|4G-LTE'),
(94, 12, 'Hệ điều hành', 'IOS'),
(95, 12, 'Operation System Version', 'IOS9'),
(96, 12, 'Trọng lượng (KG)', '0.2'),
(97, 12, 'Sản xuất tại', 'Trung quốc'),
(98, 12, 'RAM memory', '2GB'),
(99, 12, 'Sim type', 'SIM nano'),
(100, 12, 'Sim Slots', '1'),
(101, 12, 'Bộ nhớ trong', '64GB'),
(102, 12, 'Bảo hành', '12 tháng'),
(103, 13, '3D TV', 'No'),
(104, 13, 'Camera Back', '11 - 15 MP'),
(105, 13, 'Camera Front', '5 - 6 MP'),
(106, 13, 'Điều kiện', 'Mới'),
(107, 13, 'Curved TV', 'No'),
(108, 13, 'Kích thước màn hình', '4.7'),
(109, 13, 'Mẫu mã', '6s'),
(110, 13, 'Network Connections', '3G-HSPA|4G-LTE'),
(111, 13, 'Hệ điều hành', 'IOS'),
(112, 13, 'Operation System Version', 'IOS9'),
(113, 13, 'Trọng lượng (KG)', '0.2'),
(114, 13, 'Sản xuất tại', 'Trung quốc'),
(115, 13, 'RAM memory', '2GB'),
(116, 13, 'Sim type', 'SIM nano'),
(117, 13, 'Sim Slots', '1'),
(118, 13, 'Bộ nhớ trong', '64GB'),
(119, 13, 'Bảo hành', '12 tháng'),
(120, 14, '3D TV', 'No'),
(121, 14, 'Camera Back', '11 - 15 MP'),
(122, 14, 'Camera Front', '5 - 6 MP'),
(123, 14, 'Điều kiện', 'Mới'),
(124, 14, 'Curved TV', 'No'),
(125, 14, 'Kích thước màn hình', '4.7'),
(126, 14, 'Mẫu mã', '6s'),
(127, 14, 'Network Connections', '3G-HSPA|4G-LTE'),
(128, 14, 'Hệ điều hành', 'IOS'),
(129, 14, 'Operation System Version', 'IOS9'),
(130, 14, 'Trọng lượng (KG)', '0.2'),
(131, 14, 'Sản xuất tại', 'Trung quốc'),
(132, 14, 'RAM memory', '2GB'),
(133, 14, 'Sim type', 'SIM nano'),
(134, 14, 'Sim Slots', '1'),
(135, 14, 'Bộ nhớ trong', '64GB'),
(136, 14, 'Bảo hành', '12 tháng'),
(137, 15, '3D TV', 'No'),
(138, 15, 'Camera Back', '11 - 15 MP'),
(139, 15, 'Camera Front', '5 - 6 MP'),
(140, 15, 'Điều kiện', 'Mới'),
(141, 15, 'Curved TV', 'No'),
(142, 15, 'Kích thước màn hình', '4.7'),
(143, 15, 'Mẫu mã', '6s'),
(144, 15, 'Network Connections', '3G-HSPA|4G-LTE'),
(145, 15, 'Hệ điều hành', 'IOS'),
(146, 15, 'Operation System Version', 'IOS9'),
(147, 15, 'Trọng lượng (KG)', '0.2'),
(148, 15, 'Sản xuất tại', 'Trung quốc'),
(149, 15, 'RAM memory', '2GB'),
(150, 15, 'Sim type', 'SIM nano'),
(151, 15, 'Sim Slots', '1'),
(152, 15, 'Bộ nhớ trong', '64GB'),
(153, 15, 'Bảo hành', '12 tháng'),
(154, 16, '3D TV', 'No'),
(155, 16, 'Camera Back', '11 - 15 MP'),
(156, 16, 'Camera Front', '5 - 6 MP'),
(157, 16, 'Điều kiện', 'Mới'),
(158, 16, 'Curved TV', 'No'),
(159, 16, 'Kích thước màn hình', '4.7'),
(160, 16, 'Mẫu mã', '6s'),
(161, 16, 'Network Connections', '3G-HSPA|4G-LTE'),
(162, 16, 'Hệ điều hành', 'IOS'),
(163, 16, 'Operation System Version', 'IOS9'),
(164, 16, 'Trọng lượng (KG)', '0.2'),
(165, 16, 'Sản xuất tại', 'Trung quốc'),
(166, 16, 'RAM memory', '2GB'),
(167, 16, 'Sim type', 'SIM nano'),
(168, 16, 'Sim Slots', '1'),
(169, 16, 'Bộ nhớ trong', '64GB'),
(170, 16, 'Bảo hành', '12 tháng'),
(171, 17, '3D TV', 'No'),
(172, 17, 'Camera Back', '11 - 15 MP'),
(173, 17, 'Camera Front', '5 - 6 MP'),
(174, 17, 'Điều kiện', 'Mới'),
(175, 17, 'Curved TV', 'No'),
(176, 17, 'Kích thước màn hình', '4.7'),
(177, 17, 'Mẫu mã', '6s'),
(178, 17, 'Network Connections', '3G-HSPA|4G-LTE'),
(179, 17, 'Hệ điều hành', 'IOS'),
(180, 17, 'Operation System Version', 'IOS9'),
(181, 17, 'Trọng lượng (KG)', '0.2'),
(182, 17, 'Sản xuất tại', 'Trung quốc'),
(183, 17, 'RAM memory', '2GB'),
(184, 17, 'Sim type', 'SIM nano'),
(185, 17, 'Sim Slots', '1'),
(186, 17, 'Bộ nhớ trong', '64GB'),
(187, 17, 'Bảo hành', '12 tháng'),
(188, 18, '3D TV', 'No'),
(189, 18, 'Camera Back', '11 - 15 MP'),
(190, 18, 'Camera Front', '5 - 6 MP'),
(191, 18, 'Điều kiện', 'Mới'),
(192, 18, 'Curved TV', 'No'),
(193, 18, 'Kích thước màn hình', '4.7'),
(194, 18, 'Mẫu mã', '6s'),
(195, 18, 'Network Connections', '3G-HSPA|4G-LTE'),
(196, 18, 'Hệ điều hành', 'IOS'),
(197, 18, 'Operation System Version', 'IOS9'),
(198, 18, 'Trọng lượng (KG)', '0.2'),
(199, 18, 'Sản xuất tại', 'Trung quốc'),
(200, 18, 'RAM memory', '2GB'),
(201, 18, 'Sim type', 'SIM nano'),
(202, 18, 'Sim Slots', '1'),
(203, 18, 'Bộ nhớ trong', '64GB'),
(204, 18, 'Bảo hành', '12 tháng'),
(205, 19, '3D TV', 'No'),
(206, 19, 'Camera Back', '11 - 15 MP'),
(207, 19, 'Camera Front', '5 - 6 MP'),
(208, 19, 'Điều kiện', 'Mới'),
(209, 19, 'Curved TV', 'No'),
(210, 19, 'Kích thước màn hình', '4.7'),
(211, 19, 'Mẫu mã', '6s'),
(212, 19, 'Network Connections', '3G-HSPA|4G-LTE'),
(213, 19, 'Hệ điều hành', 'IOS'),
(214, 19, 'Operation System Version', 'IOS9'),
(215, 19, 'Trọng lượng (KG)', '0.2'),
(216, 19, 'Sản xuất tại', 'Trung quốc'),
(217, 19, 'RAM memory', '2GB'),
(218, 19, 'Sim type', 'SIM nano'),
(219, 19, 'Sim Slots', '1'),
(220, 19, 'Bộ nhớ trong', '64GB'),
(221, 19, 'Bảo hành', '12 tháng'),
(222, 20, '3D TV', 'No'),
(223, 20, 'Camera Back', '11 - 15 MP'),
(224, 20, 'Camera Front', '5 - 6 MP'),
(225, 20, 'Điều kiện', 'Mới'),
(226, 20, 'Curved TV', 'No'),
(227, 20, 'Kích thước màn hình', '4.7'),
(228, 20, 'Mẫu mã', '6s'),
(229, 20, 'Network Connections', '3G-HSPA|4G-LTE'),
(230, 20, 'Hệ điều hành', 'IOS'),
(231, 20, 'Operation System Version', 'IOS9'),
(232, 20, 'Trọng lượng (KG)', '0.2'),
(233, 20, 'Sản xuất tại', 'Trung quốc'),
(234, 20, 'RAM memory', '2GB'),
(235, 20, 'Sim type', 'SIM nano'),
(236, 20, 'Sim Slots', '1'),
(237, 20, 'Bộ nhớ trong', '64GB'),
(238, 20, 'Bảo hành', '12 tháng'),
(239, 21, '3D TV', 'No'),
(240, 21, 'Camera Back', '11 - 15 MP'),
(241, 21, 'Camera Front', '5 - 6 MP'),
(242, 21, 'Điều kiện', 'Mới'),
(243, 21, 'Curved TV', 'No'),
(244, 21, 'Kích thước màn hình', '4.7'),
(245, 21, 'Mẫu mã', '6s'),
(246, 21, 'Network Connections', '3G-HSPA|4G-LTE'),
(247, 21, 'Hệ điều hành', 'IOS'),
(248, 21, 'Operation System Version', 'IOS9'),
(249, 21, 'Trọng lượng (KG)', '0.2'),
(250, 21, 'Sản xuất tại', 'Trung quốc'),
(251, 21, 'RAM memory', '2GB'),
(252, 21, 'Sim type', 'SIM nano'),
(253, 21, 'Sim Slots', '1'),
(254, 21, 'Bộ nhớ trong', '64GB'),
(255, 21, 'Bảo hành', '12 tháng'),
(256, 22, '3D TV', 'No'),
(257, 22, 'Camera Back', '11 - 15 MP'),
(258, 22, 'Camera Front', '5 - 6 MP'),
(259, 22, 'Điều kiện', 'Mới'),
(260, 22, 'Curved TV', 'No'),
(261, 22, 'Kích thước màn hình', '4.7'),
(262, 22, 'Mẫu mã', '6s'),
(263, 22, 'Network Connections', '3G-HSPA|4G-LTE'),
(264, 22, 'Hệ điều hành', 'IOS'),
(265, 22, 'Operation System Version', 'IOS9'),
(266, 22, 'Trọng lượng (KG)', '0.2'),
(267, 22, 'Sản xuất tại', 'Trung quốc'),
(268, 22, 'RAM memory', '2GB'),
(269, 22, 'Sim type', 'SIM nano'),
(270, 22, 'Sim Slots', '1'),
(271, 22, 'Bộ nhớ trong', '64GB'),
(272, 22, 'Bảo hành', '12 tháng'),
(273, 23, '3D TV', 'No'),
(274, 23, 'Camera Back', '11 - 15 MP'),
(275, 23, 'Camera Front', '5 - 6 MP'),
(276, 23, 'Điều kiện', 'Mới'),
(277, 23, 'Curved TV', 'No'),
(278, 23, 'Kích thước màn hình', '4.7'),
(279, 23, 'Mẫu mã', '6s'),
(280, 23, 'Network Connections', '3G-HSPA|4G-LTE'),
(281, 23, 'Hệ điều hành', 'IOS'),
(282, 23, 'Operation System Version', 'IOS9'),
(283, 23, 'Trọng lượng (KG)', '0.2'),
(284, 23, 'Sản xuất tại', 'Trung quốc'),
(285, 23, 'RAM memory', '2GB'),
(286, 23, 'Sim type', 'SIM nano'),
(287, 23, 'Sim Slots', '1'),
(288, 23, 'Bộ nhớ trong', '64GB'),
(289, 23, 'Bảo hành', '12 tháng'),
(290, 24, '3D TV', 'No'),
(291, 24, 'Camera Back', '11 - 15 MP'),
(292, 24, 'Camera Front', '5 - 6 MP'),
(293, 24, 'Điều kiện', 'Mới'),
(294, 24, 'Curved TV', 'No'),
(295, 24, 'Kích thước màn hình', '4.7'),
(296, 24, 'Mẫu mã', '6s'),
(297, 24, 'Network Connections', '3G-HSPA|4G-LTE'),
(298, 24, 'Hệ điều hành', 'IOS'),
(299, 24, 'Operation System Version', 'IOS9'),
(300, 24, 'Trọng lượng (KG)', '0.2'),
(301, 24, 'Sản xuất tại', 'Trung quốc'),
(302, 24, 'RAM memory', '2GB'),
(303, 24, 'Sim type', 'SIM nano'),
(304, 24, 'Sim Slots', '1'),
(305, 24, 'Bộ nhớ trong', '64GB'),
(306, 24, 'Bảo hành', '12 tháng'),
(307, 25, '3D TV', 'No'),
(308, 25, 'Camera Back', '11 - 15 MP'),
(309, 25, 'Camera Front', '5 - 6 MP'),
(310, 25, 'Điều kiện', 'Mới'),
(311, 25, 'Curved TV', 'No'),
(312, 25, 'Kích thước màn hình', '4.7'),
(313, 25, 'Mẫu mã', '6s'),
(314, 25, 'Network Connections', '3G-HSPA|4G-LTE'),
(315, 25, 'Hệ điều hành', 'IOS'),
(316, 25, 'Operation System Version', 'IOS9'),
(317, 25, 'Trọng lượng (KG)', '0.2'),
(318, 25, 'Sản xuất tại', 'Trung quốc'),
(319, 25, 'RAM memory', '2GB'),
(320, 25, 'Sim type', 'SIM nano'),
(321, 25, 'Sim Slots', '1'),
(322, 25, 'Bộ nhớ trong', '64GB'),
(323, 25, 'Bảo hành', '12 tháng'),
(324, 26, '3D TV', 'No'),
(325, 26, 'Camera Back', '11 - 15 MP'),
(326, 26, 'Camera Front', '5 - 6 MP'),
(327, 26, 'Điều kiện', 'Mới'),
(328, 26, 'Curved TV', 'No'),
(329, 26, 'Kích thước màn hình', '4.7'),
(330, 26, 'Mẫu mã', '6s'),
(331, 26, 'Network Connections', '3G-HSPA|4G-LTE'),
(332, 26, 'Hệ điều hành', 'IOS'),
(333, 26, 'Operation System Version', 'IOS9'),
(334, 26, 'Trọng lượng (KG)', '0.2'),
(335, 26, 'Sản xuất tại', 'Trung quốc'),
(336, 26, 'RAM memory', '2GB'),
(337, 26, 'Sim type', 'SIM nano'),
(338, 26, 'Sim Slots', '1'),
(339, 26, 'Bộ nhớ trong', '64GB'),
(340, 26, 'Bảo hành', '12 tháng'),
(341, 27, '3D TV', 'No'),
(342, 27, 'Camera Back', '11 - 15 MP'),
(343, 27, 'Camera Front', '5 - 6 MP'),
(344, 27, 'Điều kiện', 'Mới'),
(345, 27, 'Curved TV', 'No'),
(346, 27, 'Kích thước màn hình', '4.7'),
(347, 27, 'Mẫu mã', '6s'),
(348, 27, 'Network Connections', '3G-HSPA|4G-LTE'),
(349, 27, 'Hệ điều hành', 'IOS'),
(350, 27, 'Operation System Version', 'IOS9'),
(351, 27, 'Trọng lượng (KG)', '0.2'),
(352, 27, 'Sản xuất tại', 'Trung quốc'),
(353, 27, 'RAM memory', '2GB'),
(354, 27, 'Sim type', 'SIM nano'),
(355, 27, 'Sim Slots', '1'),
(356, 27, 'Bộ nhớ trong', '64GB'),
(357, 27, 'Bảo hành', '12 tháng'),
(358, 27, '3D TV', 'No'),
(359, 27, 'Camera Back', '11 - 15 MP'),
(360, 27, 'Camera Front', '5 - 6 MP'),
(361, 27, 'Điều kiện', 'Mới'),
(362, 27, 'Curved TV', 'No'),
(363, 27, 'Kích thước màn hình', '4.7'),
(364, 27, 'Mẫu mã', '6s'),
(365, 27, 'Network Connections', '3G-HSPA|4G-LTE'),
(366, 27, 'Hệ điều hành', 'IOS'),
(367, 27, 'Operation System Version', 'IOS9'),
(368, 27, 'Trọng lượng (KG)', '0.2'),
(369, 27, 'Sản xuất tại', 'Trung quốc'),
(370, 27, 'RAM memory', '2GB'),
(371, 28, '3D TV', 'No'),
(372, 28, 'Camera Back', '11 - 15 MP'),
(373, 28, 'Camera Front', '5 - 6 MP'),
(374, 28, 'Điều kiện', 'Mới'),
(375, 28, 'Curved TV', 'No'),
(376, 28, 'Kích thước màn hình', '4.7'),
(377, 28, 'Mẫu mã', '6s'),
(378, 28, 'Network Connections', '3G-HSPA|4G-LTE'),
(379, 28, 'Hệ điều hành', 'IOS'),
(380, 28, 'Operation System Version', 'IOS9'),
(381, 28, 'Trọng lượng (KG)', '0.2'),
(382, 28, 'Sản xuất tại', 'Trung quốc'),
(383, 28, 'RAM memory', '2GB'),
(384, 28, 'Sim type', 'SIM nano'),
(385, 28, 'Sim Slots', '1'),
(386, 28, 'Bộ nhớ trong', '64GB'),
(387, 28, 'Bảo hành', '12 tháng'),
(388, 29, '3D TV', 'No'),
(389, 29, 'Camera Back', '11 - 15 MP'),
(390, 29, 'Camera Front', '5 - 6 MP'),
(391, 29, 'Điều kiện', 'Mới'),
(392, 29, 'Curved TV', 'No'),
(393, 29, 'Kích thước màn hình', '4.7'),
(394, 29, 'Mẫu mã', '6s'),
(395, 29, 'Network Connections', '3G-HSPA|4G-LTE'),
(396, 29, 'Hệ điều hành', 'IOS'),
(397, 29, 'Operation System Version', 'IOS9'),
(398, 29, 'Trọng lượng (KG)', '0.2'),
(399, 29, 'Sản xuất tại', 'Trung quốc'),
(400, 29, 'RAM memory', '2GB'),
(401, 29, 'Sim type', 'SIM nano'),
(402, 29, 'Sim Slots', '1'),
(403, 29, 'Bộ nhớ trong', '64GB'),
(404, 29, 'Bảo hành', '12 tháng'),
(405, 30, '3D TV', 'No'),
(406, 30, 'Camera Back', '11 - 15 MP'),
(407, 30, 'Camera Front', '5 - 6 MP'),
(408, 30, 'Điều kiện', 'Mới'),
(409, 30, 'Curved TV', 'No'),
(410, 30, 'Kích thước màn hình', '4.7'),
(411, 30, 'Mẫu mã', '6s'),
(412, 30, 'Network Connections', '3G-HSPA|4G-LTE'),
(413, 30, 'Hệ điều hành', 'IOS'),
(414, 30, 'Operation System Version', 'IOS9'),
(415, 30, 'Trọng lượng (KG)', '0.2'),
(416, 30, 'Sản xuất tại', 'Trung quốc'),
(417, 30, 'RAM memory', '2GB'),
(418, 30, 'Sim type', 'SIM nano'),
(419, 30, 'Sim Slots', '1'),
(420, 30, 'Bộ nhớ trong', '64GB'),
(421, 30, 'Bảo hành', '12 tháng'),
(422, 31, '3D TV', 'No'),
(423, 31, 'Camera Back', '11 - 15 MP'),
(424, 31, 'Camera Front', '5 - 6 MP'),
(425, 31, 'Điều kiện', 'Mới'),
(426, 31, 'Curved TV', 'No'),
(427, 31, 'Kích thước màn hình', '4.7'),
(428, 31, 'Mẫu mã', '6s'),
(429, 31, 'Network Connections', '3G-HSPA|4G-LTE'),
(430, 31, 'Hệ điều hành', 'IOS'),
(431, 31, 'Operation System Version', 'IOS9'),
(432, 31, 'Trọng lượng (KG)', '0.2'),
(433, 31, 'Sản xuất tại', 'Trung quốc'),
(434, 31, 'RAM memory', '2GB'),
(435, 31, 'Sim type', 'SIM nano'),
(436, 31, 'Sim Slots', '1'),
(437, 31, 'Bộ nhớ trong', '64GB'),
(438, 31, 'Bảo hành', '12 tháng'),
(439, 32, '3D TV', 'No'),
(440, 32, 'Camera Back', '11 - 15 MP'),
(441, 32, 'Camera Front', '5 - 6 MP'),
(442, 32, 'Điều kiện', 'Mới'),
(443, 32, 'Curved TV', 'No'),
(444, 32, 'Kích thước màn hình', '4.7'),
(445, 32, 'Mẫu mã', '6s'),
(446, 32, 'Network Connections', '3G-HSPA|4G-LTE'),
(447, 32, 'Hệ điều hành', 'IOS'),
(448, 32, 'Operation System Version', 'IOS9'),
(449, 32, 'Trọng lượng (KG)', '0.2'),
(450, 32, 'Sản xuất tại', 'Trung quốc'),
(451, 32, 'RAM memory', '2GB'),
(452, 32, 'Sim type', 'SIM nano'),
(453, 32, 'Sim Slots', '1'),
(454, 32, 'Bộ nhớ trong', '64GB'),
(455, 32, 'Bảo hành', '12 tháng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietthuonghieu`
--

CREATE TABLE `chitietthuonghieu` (
  `MATHUONGHIEU` int(11) NOT NULL,
  `MALOAISP` int(11) NOT NULL,
  `HINHLOAISPTH` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietthuonghieu`
--

INSERT INTO `chitietthuonghieu` (`MATHUONGHIEU`, `MALOAISP`, `HINHLOAISPTH`) VALUES
(1, 1, '/hinhthuonghieu/apple.png'),
(2, 49, '/hinhthuonghieu/macbook.png'),
(3, 1, '/hinhthuonghieu/nokia.png'),
(4, 1, '/hinhthuonghieu/samsung.png'),
(5, 1, '/hinhthuonghieu/xiaomi.png'),
(6, 1, '/hinhthuonghieu/asus.png'),
(7, 1, '/hinhthuonghieu/lenovo.png'),
(7, 49, '/hinhthuonghieu/laptoplenovo.png'),
(8, 1, '/hinhthuonghieu/oppo.png'),
(9, 1, '/hinhthuonghieu/sony.png'),
(10, 1, '/hinhthuonghieu/htc.png'),
(11, 49, '/hinhthuonghieu/dell.png'),
(12, 1, '/hinhthuonghieu/hp.png'),
(13, 1, '/hinhthuonghieu/scandisk.png'),
(14, 1, '/hinhthuonghieu/silicon.jpg'),
(15, 1, '/hinhthuonghieu/canon.jpg'),
(16, 49, '/hinhthuonghieu/microsoft.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhgia`
--

CREATE TABLE `danhgia` (
  `MADG` varchar(200) NOT NULL,
  `MASP` int(11) NOT NULL,
  `TENTHIETBI` text DEFAULT NULL,
  `TIEUDE` text DEFAULT NULL,
  `NOIDUNG` text DEFAULT NULL,
  `SOSAO` int(1) DEFAULT NULL,
  `NGAYDANHGIA` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `danhgia`
--

INSERT INTO `danhgia` (`MADG`, `MASP`, `TENTHIETBI`, `TIEUDE`, `NOIDUNG`, `SOSAO`, `NGAYDANHGIA`) VALUES
('', 1, 'Redmi 6 Pro', 'Hoàng Kim Tới', 'abc', 5, '25/09/2019'),
('', 2, 'Redmi 6 Pro', 'Hoàng Thùy Linh', 'Nhưng không', 5, '25/09/2019');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MAHD` int(11) NOT NULL,
  `NGAYMUA` text DEFAULT NULL,
  `NGAYGIAO` text DEFAULT NULL,
  `TRANGTHAI` varchar(20) DEFAULT NULL,
  `TENNGUOINHAN` varchar(50) DEFAULT NULL,
  `SODT` text DEFAULT NULL,
  `DIACHI` text DEFAULT NULL,
  `CHUYENKHOAN` tinyint(1) DEFAULT NULL,
  `MACHUYENKHOAN` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MAHD`, `NGAYMUA`, `NGAYGIAO`, `TRANGTHAI`, `TENNGUOINHAN`, `SODT`, `DIACHI`, `CHUYENKHOAN`, `MACHUYENKHOAN`) VALUES
(1, '20/09/2019', '20/09/2019', 'chờ kiểm duyệt', 'Hoàng Kim Tới', '0123456789', 'Hà Nội', 0, NULL),
(2, '20/09/2019', '20/09/2019', 'chờ kiểm duyệt', 'Hoàng Kim Tới', '0961523638', 'Hà Nội', 0, NULL),
(3, '21/09/2019', '21/09/2019', 'chờ kiểm duyệt', 'bzd', '97649', 'svdbd', 0, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MAKM` int(11) NOT NULL,
  `MALOAISP` int(11) DEFAULT NULL,
  `TENKM` varchar(200) DEFAULT NULL,
  `NGAYBATDAU` varchar(20) DEFAULT NULL,
  `NGAYKETTHUC` varchar(20) DEFAULT NULL,
  `HINHKHUYENMAI` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MAKM`, `MALOAISP`, `TENKM`, `NGAYBATDAU`, `NGAYKETTHUC`, `HINHKHUYENMAI`) VALUES
(1, 2, 'Xã hàng hot đến 49%', '2019/9/21', '2019/10/12', '/hinhkhuyenmai/con loc giam gia mua he.png'),
(2, 2, 'Giải nhiệt mùa hè giảm ngay 50%', '2019/9/10', '2019/10/12', '/hinhkhuyenmai/khuyen mai ta quan ta dan.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loainhanvien`
--

CREATE TABLE `loainhanvien` (
  `MALOAINV` int(11) NOT NULL,
  `TENLOAINV` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loainhanvien`
--

INSERT INTO `loainhanvien` (`MALOAINV`, `TENLOAINV`) VALUES
(1, 'Admin'),
(2, 'Khách hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `MALOAISP` int(11) NOT NULL,
  `TENLOAISP` varchar(200) NOT NULL,
  `MALOAI_CHA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`MALOAISP`, `TENLOAISP`, `MALOAI_CHA`) VALUES
(1, 'Điện thoại & Máy tính bảng', 0),
(2, 'Điện thoại di động', 1),
(3, 'Máy tính bảng', 1),
(4, 'Điện thoại bàn', 1),
(5, 'Phụ kiện điện thoại & máy tính bảng', 1),
(6, 'Ốp lưng và bao da điện thoại', 5),
(7, 'Miếng dán màn hình điện thoại', 5),
(8, 'Phụ kiện di động trên xe hơi', 5),
(9, 'Phụ kiện khác', 5),
(10, 'Cáp & Dock sạc', 5),
(11, 'Linh kiện & Dụng cụ', 5),
(12, 'SIM & Thẻ cào', 5),
(13, 'Pin và bộ sạc', 5),
(14, 'Phụ kiện máy tính bảng', 5),
(15, 'Pin sạc dự phòng', 5),
(16, 'Phụ kiện camera điện thoại', 5),
(17, 'Nhà cửa & Đời sống', 0),
(18, 'Bếp phòng ăn', 17),
(19, 'Dụng cụ làm bánh', 18),
(20, 'Dụng cụ nấu ăn', 18),
(21, 'Đồ dùng bàn ăn', 18),
(22, 'Đồ dùng uống trà và cà phê', 18),
(23, 'Dao nấu bếp', 18),
(24, 'Khăn trải bàn & Phụ kiện bằng vải', 18),
(25, 'Phụ kiện & Dụng cụ nhà bếp', 18),
(26, 'Đồ dùng phòng ngủ', 17),
(27, 'Bộ chăn và ga giường gối', 26),
(28, 'Gối', 26),
(29, 'Phụ kiện giường ngủ', 26),
(30, 'Bộ chăn ra gối nệm', 26),
(31, 'Ga giường', 26),
(32, 'Nệm và Vỏ nệm', 26),
(33, 'Đồ nội thất', 17),
(34, 'Nội thất phòng ngủ', 33),
(35, 'Nội thất phòng khách', 33),
(36, 'Nội thất bếp & Phòng ăn', 33),
(37, 'Nội thất phòng trẻ em', 33),
(38, 'Nội thất phòng làm việc tại gia', 33),
(39, 'Nội thất cho hành lang & lối vào', 33),
(40, 'Nội thất phòng trang trí', 33),
(41, 'Nội thất kiểu cổ', 33),
(42, 'Tân trang nhà cửa', 17),
(43, 'Kho chứa dụng cụ và Garage', 42),
(44, 'Điện', 42),
(45, 'Cổng và Hàng rào', 42),
(46, 'Bảo vệ và An toàn', 42),
(47, 'Ống nước', 42),
(48, 'Máy vi tính & Laptop', 17),
(49, 'Laptop', 48),
(50, 'Dòng giải trí', 49),
(51, 'Macbooks', 49),
(52, 'Ultrabooks', 49),
(53, 'Thiết bị lưu trữ', 17),
(54, 'Ổ cứng SSD', 53),
(55, 'Ổ cứng gắn ngoài', 53),
(56, 'Ổ cứng gắn trong', 53),
(57, 'USB lưu trữ', 53),
(58, 'Máy in & Phụ kiện', 17),
(59, 'Máy in', 58),
(60, 'Kệ máy in', 58),
(61, 'Máy Fax', 58),
(62, 'Mực in', 58),
(63, 'Chăm sóc sức khỏe & làm đẹp', 17),
(64, 'Trang điểm', 63),
(65, 'Mặt', 64),
(66, 'Môi', 64),
(67, 'Mắt', 64),
(68, 'Tẩy trang', 64),
(69, 'Chăm sóc mặt', 63),
(70, 'Mặt nạ đắp', 69),
(71, 'Sữa rữa mặt', 69),
(72, 'Thể thao', 17),
(73, 'Yaga & Thể hình', 72),
(74, 'Yoga', 73),
(75, 'Máy tập thể hình', 73),
(76, 'Máy tập thể lực', 73),
(77, 'Giày & Trang phục', 72),
(78, 'Dành cho nữ', 77),
(79, 'Dành cho nam', 77),
(80, 'Dành cho bé', 77),
(81, 'Thời trang', 0),
(82, 'TV, Video, Âm Thanh ,Game & Thiết Bị Số', 0),
(83, 'Tivi', 82),
(84, 'Dưới 24 inches', 83),
(85, '25-32 inches', 83),
(86, '33-42 inches', 83),
(87, '43-54 inches', 83),
(88, 'Trên 55 inches', 83),
(89, 'Tivi giá đặc biệt cho các tỉnh, thành lớn', 83),
(90, 'Thiết bị âm thanh', 82),
(91, 'Các loại tai nghe', 90),
(92, 'Loa di động', 90),
(93, 'Dàn âm thanh giải trí', 90),
(94, 'Máy nghe nhạc', 90),
(95, 'Video', 82),
(96, 'Thiết bị trình chiếu', 95),
(97, 'Thiết bị streaming', 95),
(98, 'Thiết bị chơi game', 82),
(99, 'Xbox', 98),
(100, 'Nitendo', 98),
(101, 'Thiết bị đeo công nghệ', 82),
(102, 'Đồng hồ thông minh', 101),
(103, 'Thiết bị theo dõi sức khỏe & vận động', 101),
(104, 'Mắt kính thông minh', 101),
(105, 'Thiết bị giám sát thông minh', 102),
(106, 'Thể thao & du lịch', 0),
(107, 'Các loại bài tập & thể hình', 106),
(108, 'Máy tập thể hình', 107),
(109, 'Máy tập thể lực', 107),
(110, 'Phụ kiện', 107),
(111, 'Tạ', 107),
(112, 'Yoga', 107),
(113, 'Pilates', 107),
(114, 'Đấm bốc, Võ thuật & Đánh MMA', 107),
(115, 'Thể tao đồng đội', 106),
(116, 'Máy tập thể hình', 115),
(117, 'Máy tập thể hình', 115),
(118, 'Bóng đá', 115),
(119, 'Bóng rổ', 115),
(120, 'Bóng chuyền', 115),
(121, 'Hoạt động dã ngoại', 106),
(122, 'Xe đạp', 121),
(123, 'Dã ngoại & leo núi', 121),
(124, 'Câu cá', 121),
(125, 'Xe Scooters', 121),
(126, 'Trượt băng trong nhà', 121),
(127, 'Trượt ván', 121),
(128, 'Bơi lội', 121),
(129, 'Xe máy và bách hóa', 0),
(130, 'Ô tô & xe máy', 129),
(131, 'Chăm sóc ô tô & xe máy', 130),
(132, 'Phụ kiện bên ngoài', 130),
(133, 'Phụ kiện bên trong', 130),
(134, 'Link kiện thay thế', 130),
(135, 'Thiết bị giám định ô tô', 130),
(136, 'Xe mô tô & xe địa hình', 130),
(137, 'Dầu nhớt', 130),
(138, 'Sơn sửa', 130),
(139, 'Phụ kiện xe tải', 130),
(140, 'Dụng cụ và thiết bị', 130),
(141, 'Bánh & vỏ xe', 130),
(142, 'Thiết bị định vị', 130);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mongmuon`
--

CREATE TABLE `mongmuon` (
  `MASP` int(11) NOT NULL,
  `MANV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MANV` int(11) NOT NULL,
  `TENNV` varchar(200) DEFAULT NULL,
  `TENDN` varchar(2000) DEFAULT NULL,
  `MATKHAU` varchar(20) DEFAULT NULL,
  `DIACHI` text DEFAULT NULL,
  `NGAYSINH` varchar(10) DEFAULT NULL,
  `SDT` varchar(12) DEFAULT NULL,
  `GIOITINH` tinyint(1) DEFAULT NULL,
  `CMND` varchar(20) DEFAULT NULL,
  `MALOAINV` int(11) DEFAULT NULL,
  `EMAILDOCQUYEN` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MANV`, `TENNV`, `TENDN`, `MATKHAU`, `DIACHI`, `NGAYSINH`, `SDT`, `GIOITINH`, `CMND`, `MALOAINV`, `EMAILDOCQUYEN`) VALUES
(1, 'Hoàng Kim Tới', 'HoangKimToi@gmail.com', '123', NULL, NULL, NULL, NULL, NULL, 1, 'true'),
(2, 'Hoàng Kim Tới 1', 'hoang@gmail.com', '123', 'HD', '20-07-1999', '0961523638', 1, NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MASP` int(11) NOT NULL,
  `TENSP` varchar(200) DEFAULT NULL,
  `GIA` decimal(10,0) DEFAULT NULL,
  `ANHLON` text DEFAULT NULL,
  `ANHNHO` text DEFAULT NULL,
  `THONGTIN` text DEFAULT NULL,
  `SOLUONG` int(11) DEFAULT NULL,
  `MALOAISP` int(11) DEFAULT NULL,
  `MATHUONGHIEU` int(11) DEFAULT NULL,
  `MANV` int(11) NOT NULL,
  `LUOTMUA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`MASP`, `TENSP`, `GIA`, `ANHLON`, `ANHNHO`, `THONGTIN`, `SOLUONG`, `MALOAISP`, `MATHUONGHIEU`, `MANV`, `LUOTMUA`) VALUES
(1, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(2, 'Apple Iphone 6s Plus 16GB (Vàng hồng)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(3, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(4, 'Apple Iphone 6s Plus 16GB (Trắng)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 2, 0),
(5, 'Apple Iphone 6s Plus 16GB (Đen)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 2, 0),
(6, 'Máy tính bảng iPad Mini 7.9 inch Wifi Cellular 64GB (2019)', '14490000', '/hinhsanpham/ipadmini.png', '/hinhsanpham/ipadmini1.png,/hinhsanpham/ipadmini2.png', 'iPad Mini 7.9 inch Wifi Cellular 64GB (2019) được Apple trang bị hiệu năng rất ấn tượng với con chip Apple A12 cùng RAM 3 GB và 64 GB bộ nhớ trong.', 10, 3, 2, 1, 2),
(7, 'Pin sạc dự phòng Asus Zenpower 10.050mAh (Vàng) ', '339000', '/hinhsanpham/pinsacduphongasus.jpg', '/hinhsanpham/ipadmini1.png,/hinhsanpham/ipadmini2.png', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 13, 5, 2, 0),
(8, 'Bao da kiêm bàn phím cho máy tính bảng 7 inch ( Đen)  ', '98000', '/hinhsanpham/baodabanphimmaytinhbang7ich.jpg', '/hinhsanpham/baodabanphimmaytinhbang7ich.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 14, 5, 2, 0),
(9, 'Gậy chụp hình Selfie Stick (Đen phối vàng) ', '36000', '/hinhsanpham/gaychuphinhtusuong.png', '/hinhsanpham/gaychuphinhtusuong.png', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 16, 5, 2, 0),
(10, 'Bộ Miếng dán cường lực và ốp lưng cho iPhone 6 - NVPro 30306 (Trong suốt)  ', '86000', '/hinhsanpham/mieng-gian-cuong-luc-iphone-6-6s.jpg', '/hinhsanpham/mieng-gian-cuong-luc-iphone-6-6s.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 7, 5, 2, 0),
(11, 'Đế kẹp smartphone cho điện thoại', '36000', '/hinhsanpham/dekepsmartphonechodienthoai.jpg', '/hinhsanpham/dekepsmartphonechodienthoai.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 8, 5, 2, 0),
(12, 'Sim 3G tài khoản 600 MB', '106000', '/hinhsanpham/sim3gtaikhoan600.jpg', '/hinhsanpham/sim3gtaikhoan600.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 12, 5, 2, 0),
(13, 'Ổ cắm thông minh Xiaomi Mi Power Strips (Trắng) ', '166000', '/hinhsanpham/o-cam-thong-minh-xiaomi.jpg', '/hinhsanpham/o-cam-thong-minh-xiaomi.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 11, 5, 2, 0),
(14, 'Giá đỡ điện thoại cho tay cầm chơi Game Terios T-3 ( Đen)  ', '99000', '/hinhsanpham/taycamchoigame.jpg', '/hinhsanpham/taycamchoigame.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 11, 5, 2, 0),
(18, 'Tivi LED Arirang 24inch HD - Model AR-2488F (Đen)', '2439000', '/hinhsanpham/tiviled24inchesariang.jpg', '/hinhsanpham/tiviled24inchesariang.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 84, 5, 2, 0),
(19, 'Tivi LED LG 42inch 42LF550T Full HD (Đen)  ', '6939000', '/hinhsanpham/tiviled42inches.jpg', '/hinhsanpham/tiviled42inches.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 85, 5, 2, 0),
(20, 'Smart Tivi LED LG 55inch Full HD - Model 55LH575T (Đen)', '17000000', '/hinhsanpham/tiviled55inches.jpg', '/hinhsanpham/tiviled55inches.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 87, 5, 2, 0),
(21, 'Load Bluetooth SUNTEK S204 (Đen) ', '269000', '/hinhsanpham/sony-electronics-hd-radio.jpg', '/hinhsanpham/sony-electronics-hd-radio.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 92, 5, 2, 0),
(22, 'Tai nghe chụp tai Ovann X1 Gaming (Đen phối Xanh) ', '60000', '/hinhsanpham/tai-nghe-chup-tai-ovann-x1-gaming-den-phoi-xanh_5235588062018469161_300.jpg', '/hinhsanpham/tai-nghe-chup-tai-ovann-x1-gaming-den-phoi-xanh_5235588062018469161_300.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 91, 5, 2, 0),
(23, 'Dàn âm thanh Samsung HT-E350K 5.1 330W (Đen) ', '1760000', '/hinhsanpham/vish-dvd-ht-e350k-2.jpg', '/hinhsanpham/vish-dvd-ht-e350k-2.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 93, 5, 2, 0),
(24, 'Máy nghe nhạc MP3 NVPro Minion (Xanh dương) ', '40000', '/hinhsanpham/may-nghe-nhac-mp3-nvpro-minion-xanh-duong-8610-6315961-e77b808c5237d08a940e6fe597050469-catalog_233.jpg', '/hinhsanpham/may-nghe-nhac-mp3-nvpro-minion-xanh-duong-8610-6315961-e77b808c5237d08a940e6fe597050469-catalog_233.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 94, 5, 2, 0),
(25, 'Máy chiếu mini cho điện thoại (Nâu)  ', '169999', '/hinhsanpham/may-chieu-mini-cho-dien-thoai-nau-9973-9001242-168928dd2df3fa0fae4f2c453b3e8620-catalog_233.jpg', '/hinhsanpham/may-chieu-mini-cho-dien-thoai-nau-9973-9001242-168928dd2df3fa0fae4f2c453b3e8620-catalog_233.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 96, 5, 2, 0),
(26, 'Thiết bị Android TV box MXQ S805 (Đen) ', '429300', '/hinhsanpham/20160530150209551.jpg', '/hinhsanpham/20160530150209551.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 97, 5, 2, 0),
(27, 'Tay cầm chơi game Xbox One Controller và Wireless Adapter for PC (Đen)', '1549000', '/hinhsanpham/36743763_palaciodehierro_wirelesscontrollerc35mmone_xbox_vista_1.jpg', '/hinhsanpham/36743763_palaciodehierro_wirelesscontrollerc35mmone_xbox_vista_1.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 99, 5, 2, 0),
(28, 'Máy chơi games Nintendo Wii +HDD 500 GB (Full Games) (Đen) ', '5999000', '/hinhsanpham/23. WII CONSOLE BLACK W WII REMOTE PLUS _ NUNCHUCK (UPC 045496880675).jpg', '/hinhsanpham/23. WII CONSOLE BLACK W WII REMOTE PLUS _ NUNCHUCK (UPC 045496880675).jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 100, 5, 2, 0),
(29, 'Đồng hồ thông minh Smart Watch Uwatch DZ09 (Bạc) ', '302676000', '/hinhsanpham/res_50df6f16088731d12e6c6698c47231e4_1200x1200c_mttq.jpg', '/hinhsanpham/res_50df6f16088731d12e6c6698c47231e4_1200x1200c_mttq.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 102, 5, 2, 0),
(30, 'Vòng đeo tay Xiaomi Miband 2 (Đen)  ', '819000', '/hinhsanpham/sh-02-a.jpg', '/hinhsanpham/sh-02-a.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 103, 5, 2, 0),
(31, 'Bút ghi âm chuyên nghiệp 8 GB (Đen) ', '612000', '/hinhsanpham/130814225508442671.jpg', '/hinhsanpham/130814225508442671.jpg', 'Asus ZenPower là viên pin sạc chính hãng hiếm hoi đến từ một nhà sản xuất điện thoại khá lớn ở Việt Nam. Hiện tại ZenPower có khá nhiều màu khác nhau, từ hồng đẹp trai đến màu đen yếu đuối. Hiện tại thì mình mượn được màu hồng mạnh mẽ và vàng sang chảnh để trên tay. Asus có bán các miếng bảo vệ cao su nhiều màu cho pin nhưng không rõ có được phân phối ở Việt Nam hay không.', 10, 104, 5, 2, 0),
(32, 'Apple 1', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(33, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(34, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(35, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(36, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(37, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(38, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(39, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(40, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(41, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(42, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(43, 'Apple Iphone 6s Plus 16GB', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(44, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(45, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(46, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(47, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(48, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(49, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(50, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(51, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(52, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(54, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(55, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0),
(56, 'Apple Iphone 6s Plus 16GB (Vàng gold)', '13960000', '/hinhsanpham/iphone6spluse.png', '/hinhsanpham/iphone6spluse1.jpg,/hinhsanpham/iphone6spluse2.jpg,/hinhsanpham/iphone6spluse3.png,/hinhsanpham/iphone6spluse4.jpg', 'Là hàng được nhập khẩu trực tiếp từ nước ngoài bởi doanh nghiệp trong nước, không thông qua nhà phân phối chính thức tại thị trường Việt Nam.\r\nHàng nhập khẩu được nhiều người chọn lựa bởi giá thành tốt, chất lượng vẫn được đảm bảo như những sản phẩm được nhập khẩu thông qua nhà phân phối chính thức (vì được sản xuất từ cùng một nhà máy của hãng sản xuất). Hơn nữa, dù không được bảo hành tại các trung tâm bảo hành chính thức của hãng, các sản phẩm này vẫn được áp dụng đầy đủ chính sách bảo hành của doanh nghiệp nhập khẩu', 10, 2, 1, 1, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `MATHUONGHIEU` int(11) NOT NULL,
  `TENTHUONGHIEU` varchar(200) NOT NULL,
  `LUOTMUA` int(11) NOT NULL,
  `HINHTHUONGHIEU` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `thuonghieu`
--

INSERT INTO `thuonghieu` (`MATHUONGHIEU`, `TENTHUONGHIEU`, `LUOTMUA`, `HINHTHUONGHIEU`) VALUES
(1, 'Iphone', 0, 'hinhthuonghieu/tenapple.jpg'),
(2, 'Apple', 0, 'hinhthuonghieu/tennokia.png'),
(3, 'Nokia', 0, 'hinhthuonghieu/tensamsung.png'),
(4, 'Samsung', 0, 'hinhthuonghieu/tenxiaomi.png'),
(5, 'Xiaomi', 0, 'hinhthuonghieu/tenasus.png'),
(6, 'Asus', 0, 'hinhthuonghieu/tenlenovo.png'),
(7, 'Lenovo', 0, 'hinhthuonghieu/tenoppo.png'),
(8, 'Oppo', 0, 'hinhthuonghieu/tensony.png'),
(9, 'Sony', 0, 'hinhthuonghieu/tenhtc.png'),
(10, 'HTC', 0, 'hinhthuonghieu/tendell.png'),
(11, 'Dell', 0, 'hinhthuonghieu/tenhp.png'),
(12, 'HP', 0, 'hinhthuonghieu/tensandisk.png'),
(13, 'Scandisk', 0, 'hinhthuonghieu/tensilicon.png'),
(14, 'Silicon', 0, 'hinhthuonghieu/tencannon.png'),
(15, 'Canon', 0, 'hinhthuonghieu/tenmicrosoft.png'),
(16, 'Microsoft', 0, '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD PRIMARY KEY (`MABL`),
  ADD KEY `BINHLUAN_MANV` (`MANV`),
  ADD KEY `BINHLUAN_MASP` (`MASP`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MAHD`,`MASP`),
  ADD KEY `KHOANGOAI_CHITIETHOADON_MASP` (`MASP`);

--
-- Chỉ mục cho bảng `chitietkhuyenmai`
--
ALTER TABLE `chitietkhuyenmai`
  ADD PRIMARY KEY (`MASP`,`MAKM`),
  ADD KEY `KHOANGOAI_CHITIETKHUYENMAI_MAKM` (`MAKM`);

--
-- Chỉ mục cho bảng `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD PRIMARY KEY (`MACHITIET`);

--
-- Chỉ mục cho bảng `chitietthuonghieu`
--
ALTER TABLE `chitietthuonghieu`
  ADD PRIMARY KEY (`MATHUONGHIEU`,`MALOAISP`);

--
-- Chỉ mục cho bảng `danhgia`
--
ALTER TABLE `danhgia`
  ADD PRIMARY KEY (`MADG`,`MASP`),
  ADD KEY `KHOANGOAI_DANHGIA_MASP` (`MASP`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MAHD`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MAKM`),
  ADD KEY `KHOANGOAI_KHUYENMAI_MALOAISP` (`MALOAISP`);

--
-- Chỉ mục cho bảng `loainhanvien`
--
ALTER TABLE `loainhanvien`
  ADD PRIMARY KEY (`MALOAINV`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`MALOAISP`);

--
-- Chỉ mục cho bảng `mongmuon`
--
ALTER TABLE `mongmuon`
  ADD PRIMARY KEY (`MASP`,`MANV`),
  ADD KEY `MONGMUON_MANV` (`MANV`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MANV`),
  ADD KEY `NHANVIEN_MALOAINV` (`MALOAINV`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MASP`),
  ADD KEY `SANPHAM_MALOAISP` (`MALOAISP`),
  ADD KEY `SANPHAM_MATHSP` (`MATHUONGHIEU`);

--
-- Chỉ mục cho bảng `thuonghieu`
--
ALTER TABLE `thuonghieu`
  ADD PRIMARY KEY (`MATHUONGHIEU`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  MODIFY `MABL` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  MODIFY `MACHITIET` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=456;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MAHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `MAKM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `loainhanvien`
--
ALTER TABLE `loainhanvien`
  MODIFY `MALOAINV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `MALOAISP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=143;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `MANV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `MASP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT cho bảng `thuonghieu`
--
ALTER TABLE `thuonghieu`
  MODIFY `MATHUONGHIEU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `binhluan`
--
ALTER TABLE `binhluan`
  ADD CONSTRAINT `BINHLUAN_MANV` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `BINHLUAN_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `KHOANGOAI_CHITIETHOADON_MAHD` FOREIGN KEY (`MAHD`) REFERENCES `hoadon` (`MAHD`),
  ADD CONSTRAINT `KHOANGOAI_CHITIETHOADON_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Các ràng buộc cho bảng `chitietkhuyenmai`
--
ALTER TABLE `chitietkhuyenmai`
  ADD CONSTRAINT `KHOANGOAI_CHIETIETKUYENMAI_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`),
  ADD CONSTRAINT `KHOANGOAI_CHITIETKHUYENMAI_MAKM` FOREIGN KEY (`MAKM`) REFERENCES `khuyenmai` (`MAKM`);

--
-- Các ràng buộc cho bảng `danhgia`
--
ALTER TABLE `danhgia`
  ADD CONSTRAINT `KHOANGOAI_DANHGIA_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Các ràng buộc cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD CONSTRAINT `KHOANGOAI_KHUYENMAI_MALOAISP` FOREIGN KEY (`MALOAISP`) REFERENCES `loaisanpham` (`MALOAISP`);

--
-- Các ràng buộc cho bảng `mongmuon`
--
ALTER TABLE `mongmuon`
  ADD CONSTRAINT `MONGMUON_MANV` FOREIGN KEY (`MANV`) REFERENCES `nhanvien` (`MANV`),
  ADD CONSTRAINT `MONGMUON_MASP` FOREIGN KEY (`MASP`) REFERENCES `sanpham` (`MASP`);

--
-- Các ràng buộc cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD CONSTRAINT `NHANVIEN_MALOAINV` FOREIGN KEY (`MALOAINV`) REFERENCES `loainhanvien` (`MALOAINV`);

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `SANPHAM_MALOAISP` FOREIGN KEY (`MALOAISP`) REFERENCES `loaisanpham` (`MALOAISP`),
  ADD CONSTRAINT `SANPHAM_MATHSP` FOREIGN KEY (`MATHUONGHIEU`) REFERENCES `thuonghieu` (`MATHUONGHIEU`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
