/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.12-log : Database - dcxt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`app_zzdxmsmk` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `app_zzdxmsmk`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `a_id` int(4) NOT NULL AUTO_INCREMENT,
  `a_name` varchar(25) NOT NULL,
  `a_pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`a_id`),
  UNIQUE KEY `a_name` (`a_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`a_id`,`a_name`,`a_pwd`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3'),(2,'test','098f6bcd4621d373cade4e832627b4f6');

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `b_id` int(4) NOT NULL AUTO_INCREMENT,
  `b_no` varchar(4) NOT NULL,
  `b_name` varchar(30) NOT NULL,
  `b_address` varchar(50) NOT NULL,
  `b_phone` varchar(13) NOT NULL,
  `b_other` text,
  PRIMARY KEY (`b_id`),
  UNIQUE KEY `b_no` (`b_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `business` */

insert  into `business`(`b_id`,`b_no`,`b_name`,`b_address`,`b_phone`,`b_other`) values (1,'A','耶里夏丽新疆餐厅','长宁区天山路762号泓鑫时尚广场西区2楼','660775588','耶里夏丽餐饮品牌多年来致力于西域美食文化的开发与传递，2001年于上海创立了适合大众消费的耶里夏丽新疆风情餐厅，对食品原料严格把关，保证出自正宗清真厂家并新鲜空运至上海，在沪上清真餐饮品牌中独树一帜，深受老饕们的欢迎，并成为政府指定的清真餐饮品牌。'),(2,'B','港泰风','上海市黄浦区云南中路88号近北海路',',021-58760162','这里既有中式酒楼供应的烧腊、点心、煲汤，又有茶餐厅的咖啡、奶茶和甜点，还有潮州打冷等平民化的传统小吃，更不乏煲仔饭、生滚粥、粉面、煎炸小食、明炉小炒等香港地道小吃。'),(3,'C','同食记餐厅','上海市卢湾区局门路550号','55885588','3月1日！同食记餐厅全面换新菜啦，欢迎广大顾客前来品尝！'),(4,'D','咖啡之翼','北京长宁区延安西路1066号','62260251','神仙姐姐哦');

/*Table structure for table `evaluate` */

DROP TABLE IF EXISTS `evaluate`;

CREATE TABLE `evaluate` (
  `e_id` int(3) NOT NULL AUTO_INCREMENT,
  `m_id` int(4) NOT NULL,
  `e_comment` text,
  PRIMARY KEY (`e_id`),
  KEY `m_id` (`m_id`),
  CONSTRAINT `evaluate_ibfk_1` FOREIGN KEY (`m_id`) REFERENCES `meal` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `evaluate` */

insert  into `evaluate`(`e_id`,`m_id`,`e_comment`) values (1,1,'做的不错哦'),(2,2,'好吃好吃'),(3,3,'有点辣，嘿嘿'),(4,4,'恩，不错下次继续'),(5,5,'还算可以吧'),(6,6,'好吃滴不行啦');

/*Table structure for table `meal` */

DROP TABLE IF EXISTS `meal`;

CREATE TABLE `meal` (
  `m_id` int(4) NOT NULL AUTO_INCREMENT,
  `m_name` varchar(40) NOT NULL,
  `b_id` int(3) NOT NULL,
  `m_price` float DEFAULT NULL,
  `m_other` text,
  `m_img` text,
  PRIMARY KEY (`m_id`),
  KEY `b_id` (`b_id`),
  CONSTRAINT `meal_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `business` (`b_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `meal` */

insert  into `meal`(`m_id`,`m_name`,`b_id`,`m_price`,`m_other`,`m_img`) values (1,'清蒸绿萝卜',1,25,'做法非常健康，少油少盐的。今天我想试试用绿萝卜做一次看看味道怎么样。做好以后尝了一下，感觉还不错，因为绿萝卜本身就不辣，有点甜','/upload/1.jpg'),(2,'火腿春饼卷',1,35,'巴玛火腿可生吃也能熟吃，天然发酵的火腿肉色红润，刚入口微咸，嚼起来慢慢醇香四溢~火腿蜜瓜、火腿沙拉常见，这次搭配两个不一样的吃法，用异域风情浓厚的火腿搭配中式风情浓厚的春饼，也算是给这个春天一个交待吧~','/upload/2.jpg'),(3,'香肠西芹炒饭',1,25,'大姐给的香肠被我冻在冰箱好几天了，昨天正好剩了些米饭，果断拿出来物尽其用，儿子吃了一大碗呢。','/upload/3.jpg'),(4,'超简单土豆煎饼',2,25,'只需一个土豆，一点点盐和油，就能做出金黄喷香的土豆煎饼。','/upload/4.jpg'),(5,'巧克力蛋糕卷',2,25,'每次那层蛋糕表皮都被油纸弄破，不论是晾凉后，还是温热时，还是一出炉时，铺在蛋糕表皮的那层油纸总会带走一大片表皮！','/upload/5.jpg'),(6,'醋溜藕丁',2,25,'。这盘简单的醋溜藕丁，是一道普通的家常小菜，简单易做，健脾开胃又下饭。甜','/upload/6.jpg'),(7,'微波烤豆腐',3,25,'最懒人的瘦身美颜料理来了！调个酱汁，刷到豆腐片上，放进微波炉等“叮叮”，全程只要4分钟，酱香豆香四溢的微波烤豆腐便跃然桌上。','/upload/7.jpg'),(8,'上汤丝瓜',3,25,'大蒜拍蒜末，火腿肠切丁，皮蛋切丁，丝瓜滚刀块，咸鸭蛋黄碾碎','/upload/8.jpg'),(9,'奶酒煮生蚝',3,25,'这是波兰索波特步行街上一家印度风味的餐厅，因为在一栋房子的最里面，不走进去就很难发现它。布局风格什么的很棒，店里的音乐都是印度歌曲。','/upload/9.jpg'),(10,'清蒸绿萝卜',4,25,'做法非常健康，少油少盐的。今天我想试试用绿萝卜做一次看看味道怎么样。做好以后尝了一下，感觉还不错，因为绿萝卜本身就不辣，有点甜','/upload/10.jpg');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `n_id` int(3) NOT NULL AUTO_INCREMENT,
  `n_title` varchar(40) NOT NULL,
  `n_content` text,
  `n_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`n_id`,`n_title`,`n_content`,`n_time`) values (1,'清蒸绿萝卜简介','自打学会了清蒸白萝卜，我做了几次了，我两都很爱吃，并且觉得这个做法非常健康，少油少盐的。今天我想试试用绿萝卜做一次看看味道怎么样。做好以后尝了一下，感觉还不错，因为绿萝卜本身就不辣，有点甜，所以蒸好了感觉比白萝卜还好吃，那种萝卜特有的味道几乎吃不出来，而且颜色上也更加诱人，更加有食欲，我决定拿它当做保留菜谱了哈。',1397053316),(2,'香肠西芹炒饭','每逢佳节胖三斤，尤其春节，长假期间，几乎天天拜年，天天大餐，的确是爱美的男生女士一大忌。不过，只要掌握以下六项原则，过年聚餐是不会发胖滴。还不快快收藏菜单。\n过年不发胖原则：\n1、过的是年，气氛第一，吃饭第二。多多和亲戚、朋友们聊聊天，拉拉家常；\n2、过年饮酒是常事，但开车不能碰酒，喝酒不要贪杯，同时为自己准备一碗糙米饭，因为其含有维生素B族，是您酒后护肝的法宝哦；\n3、过年餐桌尽管有整条鱼放着，但为了“年年有余”，整条鱼一般是不吃的，为了能满足小伙伴们口欲，又不发胖，可选择海鲜、虾类、禽类；\n4、饭前先喝汤，避免开吃“撒不住”；\n5、为了能让自己知道进食多少份量，准备一个小餐盘，夹菜之后，先放餐盘，再进食；\n6、记得细嚼慢咽哦。',1397053316),(3,'过年不怕胖，马上有身材！','这家餐厅饭菜不错哦，大家快来尝尝吧！',1397053316),(4,'田园蔬菜养生汤','常听人们说，身体不好时要多喝点汤补补，现在，平日里只要有时间、有心情都可以在家煲汤喝，似乎，煲汤也是一种时尚，今天，咱就来学学怎样才能煲一锅靓汤。',1397053316);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `o_id` int(4) NOT NULL AUTO_INCREMENT,
  `m_id` int(4) NOT NULL,
  `u_name` varchar(40) NOT NULL,
  PRIMARY KEY (`o_id`),
  KEY `u_name` (`u_name`),
  KEY `m_id` (`m_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`u_name`) REFERENCES `user_` (`u_name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `meal` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`o_id`,`m_id`,`u_name`) values (1,1,'张三'),(2,2,'张三'),(3,4,'张三'),(4,4,'王武'),(5,5,'王武'),(6,6,'王武');

/*Table structure for table `user_` */

DROP TABLE IF EXISTS `user_`;

CREATE TABLE `user_` (
  `u_id` int(3) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(25) NOT NULL,
  `u_pwd` varchar(40) NOT NULL,
  `u_phone` varchar(13) NOT NULL,
  `u_address` varchar(9) DEFAULT NULL,
  `u_other` text,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_name` (`u_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user_` */

insert  into `user_`(`u_id`,`u_name`,`u_pwd`,`u_phone`,`u_address`,`u_other`) values (1,'张三','01d7f40760960e7bd9443513f22ab9af','13643713735','郑州','非常喜欢吃'),(2,'王武','9f001e4166cf26bfbdd3b4f67d9ef617','13643713735','南阳','吃货一个');

/*Table structure for table `zan` */

DROP TABLE IF EXISTS `zan`;

CREATE TABLE `zan` (
  `z_id` int(3) NOT NULL AUTO_INCREMENT,
  `m_id` int(4) NOT NULL,
  `z_zan` int(4) DEFAULT NULL,
  `z_cai` int(4) DEFAULT NULL,
  PRIMARY KEY (`z_id`),
  UNIQUE KEY `m_id` (`m_id`),
  CONSTRAINT `zan_ibfk_1` FOREIGN KEY (`m_id`) REFERENCES `meal` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `zan` */

insert  into `zan`(`z_id`,`m_id`,`z_zan`,`z_cai`) values (1,1,20,5),(2,2,10,2),(3,3,5,8),(4,4,5,8),(5,5,5,8),(6,6,5,8),(7,7,5,8),(8,8,5,8),(9,9,5,8),(10,10,5,8);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
