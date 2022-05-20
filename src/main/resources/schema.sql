
CREATE TABLE `carts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_id` int NOT NULL,
  `user_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `category` (
  `group_id` int NOT NULL,
  `group_name` varchar(50) NOT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `customers` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT 'customer',
  `f_name` varchar(30) DEFAULT NULL,
  `l_name` varchar(30) DEFAULT NULL,
  `f_name_kana` varchar(30) DEFAULT NULL,
  `l_name_kana` varchar(30) DEFAULT NULL,
  `zip_code` varchar(30) DEFAULT NULL,
  `prefecture` varchar(30) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `o_address` varchar(100) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `tell` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `delivery` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `zip_code` varchar(30) DEFAULT NULL,
  `prefecture` varchar(30) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `o_address` varchar(100) DEFAULT NULL,
  `delivery_charge` int DEFAULT '0',
  `order_date` datetime DEFAULT NULL,
  `delivery_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `tax_id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` text,
  `price` int DEFAULT '0',
  `status` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `image` mediumblob,
  `group_id` int NOT NULL,
  `url` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `order_items` (
  `order_items_id` int NOT NULL AUTO_INCREMENT,
  `item_id` int NOT NULL,
  `quantity` int DEFAULT '1',
  `product_total` int NOT NULL,
  PRIMARY KEY (`order_items_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `order_main` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `order_items_id` int NOT NULL,
  `total_payment` int NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `tax` (
  `tax_id` int NOT NULL AUTO_INCREMENT,
  `tax_rate` int NOT NULL,
  PRIMARY KEY (`tax_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
