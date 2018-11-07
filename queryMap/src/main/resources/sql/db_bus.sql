/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : db_bus

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-11-07 17:26:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bus_line
-- ----------------------------
DROP TABLE IF EXISTS `bus_line`;
CREATE TABLE `bus_line` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LineID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交线路id，该id是唯一标识',
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交站点名称',
  `StartStop` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '首发站',
  `EndStop` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '终点站',
  `StationID` varchar(255) DEFAULT NULL,
  `Lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交线路途经此站的纬度',
  `Lng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交线路途经此站的经度',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=54254 DEFAULT CHARSET=utf8 COMMENT='公交线路信息表';

-- ----------------------------
-- Table structure for bus_route
-- ----------------------------
DROP TABLE IF EXISTS `bus_route`;
CREATE TABLE `bus_route` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `BusRouteName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交路线名称',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1033 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for bus_station
-- ----------------------------
DROP TABLE IF EXISTS `bus_station`;
CREATE TABLE `bus_station` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `StationID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交站点id，该id是唯一标识',
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交站点名称',
  `AdCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '区域编码',
  `CityCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '城市编码',
  `Lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交站点纬度',
  `Lng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交站点经度',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4855 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bus_stop
-- ----------------------------
DROP TABLE IF EXISTS `bus_stop`;
CREATE TABLE `bus_stop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `BusStopName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交站点名称',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5655 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for line_bound
-- ----------------------------
DROP TABLE IF EXISTS `line_bound`;
CREATE TABLE `line_bound` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ClassName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'CLASS_NAME',
  `McLat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'mc的经度',
  `McLng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'mc的纬度',
  `XbLat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xb的纬度',
  `XbLng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xb的经度',
  `SouthWestLat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '西南方向的纬度',
  `SouthWestLng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '西南方向的经度',
  `NorthEastLat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '东北方向的纬度',
  `NorthEastLng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '东北方向的经度',
  `BusLineID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '对应线路表（line_busline）的id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1032 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for line_busline
-- ----------------------------
DROP TABLE IF EXISTS `line_busline`;
CREATE TABLE `line_busline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `BusLineID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '线路id',
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '线路名',
  `Type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公交类型',
  `CityCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '城市编码',
  `StartStop` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '首发站',
  `EndStop` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '终点站',
  `Company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属公交公司',
  `Distance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '全程距离，单位：千米',
  `BasicPrice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '起步票价，单位：元',
  `TotalPrice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '全程票价，单位：元',
  `Stime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '首班车时间',
  `Etime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '末班车时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1032 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for line_location
-- ----------------------------
DROP TABLE IF EXISTS `line_location`;
CREATE TABLE `line_location` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `N` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'N',
  `O` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'O',
  `Lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纬度',
  `Lng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '经度',
  `BusLineID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联busline表的BusLineID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=447922 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for line_via_stop
-- ----------------------------
DROP TABLE IF EXISTS `line_via_stop`;
CREATE TABLE `line_via_stop` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ViaStopID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '唯一标识id',
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '经过的站点名',
  `Sequence` varchar(255) DEFAULT NULL,
  `BusLineID` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联line_busline的表',
  `ViaStopLat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '途径站点的纬度',
  `ViaStopLng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '途径站点的经度',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29200 DEFAULT CHARSET=utf8 COMMENT='公交车途径站，包括首发站和终点站';
