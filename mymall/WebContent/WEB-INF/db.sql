-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 mall.item 구조 내보내기
CREATE TABLE IF NOT EXISTS `item` (
  `no` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` int(10) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 mall.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(50) NOT NULL,
  `pw` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='level\r\n0 : 고객\r\n1 : 관리자';

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 mall.member_item 구조 내보내기
CREATE TABLE IF NOT EXISTS `member_item` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `member_no` int(11) NOT NULL,
  `item_no` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  PRIMARY KEY (`no`),
  KEY `FK_member_item_member` (`member_no`),
  KEY `FK_member_item_item` (`item_no`),
  CONSTRAINT `FK_member_item_item` FOREIGN KEY (`item_no`) REFERENCES `item` (`no`),
  CONSTRAINT `FK_member_item_member` FOREIGN KEY (`member_no`) REFERENCES `member` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
