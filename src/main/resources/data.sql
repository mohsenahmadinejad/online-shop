INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (1, 'Hannah', 'Mclaughlin', 'USNS Hanna, FPO AE 02944', '(185)355-5391x0027');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (2, 'Margaret', 'Jackson', '869 Angela Harbors, Elizabethhaven, DE 73231', '001-989-699-9418x410');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (3, 'Jennifer', 'Solis', 'Unit 3168 Box 2180, DPO AA 86075', '6150420276');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (4, 'John', 'Wright', '67848 Kayla Port Suite 092, Hortonmouth, RI 71393', '173.316.9158x7042');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (5, 'Michael', 'Morgan', '089 Diane Lodge Apt. 591, New Robinstad, MT 86616', '953-131-9111');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (6, 'Ann', 'Smith', '771 Austin Ridge, Yangport, NH 35475', '+1-393-489-3812x134');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (7, 'Dennis', 'Mason', '14005 Haynes Manor Apt. 694, New Lauraborough, MS 26057', '001-608-328-3159x91182');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (8, 'Ebony', 'Gonzales', '2447 Kristin Stream, Ruizshire, OH 17007', '601-027-7293x3681');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (9, 'Brendan', 'Johnson', '226 Sarah Dam Apt. 132, West April, NE 11349', '709-442-9824x5616');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (10, 'Angela', 'Moody', '355 Daniel Green Suite 320, South Justinchester, TN 61306', '+1-525-423-2918x9667');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (11, 'Courtney', 'Bryant', '01745 Sarah Unions, West Bethany, OR 71435', '(689)643-4089x25677');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (12, 'Travis', 'Grant', '782 Sutton Parks, North Charles, HI 86844', '0222758535');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (13, 'Rodney', 'Smith', '03417 Jose Plaza, Kochborough, PA 68497', '778-711-0376');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (14, 'Maria', 'Clark', 'Unit 0870 Box 5339, DPO AE 89130', '001-995-555-5918');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (15, 'Jeffrey', 'Davis', '999 Turner Shoals Suite 560, East Josemouth, OR 96066', '377-342-8915x714');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (16, 'Shannon', 'Rogers', 'USNV Hoffman, FPO AE 42578', '(179)535-4036');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (17, 'Kevin', 'Ortega', '119 Jorge Camp Apt. 099, Craigport, DE 77835', '228.897.9454');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (18, 'Tara', 'Garcia', '59917 Wolfe Crossing Suite 060, Lake Aliciaberg, KS 66684', '001-937-995-9119x10976');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (19, 'Becky', 'Ware', '4844 Bryant Extension Apt. 449, New Cynthiaberg, AL 46945', '(133)845-1347x14380');
INSERT INTO t_customers (id, first_name, last_name, address, phone) VALUES (20, 'Heidi', 'Pratt', '0732 Loretta Fort Suite 848, Charlesborough, UT 77407', '867-258-9962');
-- Categories
INSERT INTO t_category (id, name) VALUES (1, 'Electronics');
INSERT INTO t_category (id, name) VALUES (2, 'Clothing');
INSERT INTO t_category (id, name) VALUES (3, 'Books');
INSERT INTO t_category (id, name) VALUES (4, 'Home Appliances');
INSERT INTO t_category (id, name) VALUES (5, 'Sports');
INSERT INTO t_category (id, name) VALUES (6, 'Beauty');
INSERT INTO t_category (id, name) VALUES (7, 'Toys');
INSERT INTO t_category (id, name) VALUES (8, 'Groceries');
INSERT INTO t_category (id, name) VALUES (9, 'Furniture');
INSERT INTO t_category (id, name) VALUES (10, 'Automotive');

-- Products
INSERT INTO tbl_products (id, name, price) VALUES (1, 'Smartphone', 496.92);
INSERT INTO tbl_products (id, name, price) VALUES (2, 'Laptop', 26.63);
INSERT INTO tbl_products (id, name, price) VALUES (3, 'T-Shirt', 88.66);
INSERT INTO tbl_products (id, name, price) VALUES (4, 'Jeans', 108.13);
INSERT INTO tbl_products (id, name, price) VALUES (5, 'Refrigerator', 380.32);
INSERT INTO tbl_products (id, name, price) VALUES (6, 'Football', 165.41);
INSERT INTO tbl_products (id, name, price) VALUES (7, 'Shampoo', 332.14);
INSERT INTO tbl_products (id, name, price) VALUES (8, 'Toy Car', 38.04);
INSERT INTO tbl_products (id, name, price) VALUES (9, 'Sofa', 489.02);
INSERT INTO tbl_products (id, name, price) VALUES (10, 'Car Tire', 370.59);

-- Stock
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (1, 100, 1, 1);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (2, 50, 1, 2);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (3, 88, 1, 3);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (4, 9, 1, 4);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (5, 46, 1, 5);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (6, 58, 1, 6);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (7, 48, 1, 7);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (8, 57, 1, 8);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (9, 55, 1, 9);
INSERT INTO tbl_stock (id, quantity, version, fk_product_id) VALUES (10, 89, 1, 10);


-- Product Categories (20 records, Many-to-Many)
INSERT INTO product_categories (product_id, category_id) VALUES (1, 1); -- Smartphone -> Electronics
INSERT INTO product_categories (product_id, category_id) VALUES (1, 10); -- Smartphone -> Automotive
INSERT INTO product_categories (product_id, category_id) VALUES (2, 1); -- Laptop -> Electronics
INSERT INTO product_categories (product_id, category_id) VALUES (2, 3); -- Laptop -> Books
INSERT INTO product_categories (product_id, category_id) VALUES (3, 2); -- T-Shirt -> Clothing
INSERT INTO product_categories (product_id, category_id) VALUES (3, 5); -- T-Shirt -> Sports
INSERT INTO product_categories (product_id, category_id) VALUES (4, 2); -- Jeans -> Clothing
INSERT INTO product_categories (product_id, category_id) VALUES (4, 5); -- Jeans -> Sports
INSERT INTO product_categories (product_id, category_id) VALUES (5, 4); -- Refrigerator -> Home Appliances
INSERT INTO product_categories (product_id, category_id) VALUES (5, 1); -- Refrigerator -> Electronics
INSERT INTO product_categories (product_id, category_id) VALUES (6, 5); -- Football -> Sports
INSERT INTO product_categories (product_id, category_id) VALUES (6, 7); -- Football -> Toys
INSERT INTO product_categories (product_id, category_id) VALUES (7, 6); -- Shampoo -> Beauty
INSERT INTO product_categories (product_id, category_id) VALUES (7, 4); -- Shampoo -> Home Appliances
INSERT INTO product_categories (product_id, category_id) VALUES (8, 7); -- Toy Car -> Toys
INSERT INTO product_categories (product_id, category_id) VALUES (8, 1); -- Toy Car -> Electronics
INSERT INTO product_categories (product_id, category_id) VALUES (9, 9); -- Sofa -> Furniture
INSERT INTO product_categories (product_id, category_id) VALUES (9, 4); -- Sofa -> Home Appliances
INSERT INTO product_categories (product_id, category_id) VALUES (10, 10); -- Car Tire -> Automotive
INSERT INTO product_categories (product_id, category_id) VALUES (10, 1); -- Car Tire -> Electronics

INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (1, '2025-07-19 17:43:41', 1073.98, 7);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (2, '2025-06-25 02:11:51', 1917.82, 3);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (3, '2025-02-05 17:15:33', 1164.23, 12);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (4, '2025-06-09 10:40:01', 983.77, 7);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (5, '2025-03-18 18:53:16', 1101.16, 15);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (6, '2025-06-14 03:22:37', 2980.11, 19);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (7, '2025-05-07 09:54:23', 2465.41, 10);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (8, '2025-05-07 01:34:55', 1871.43, 8);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (9, '2025-07-16 23:19:32', 755.45, 18);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (10, '2025-03-06 10:54:24', 819.02, 19);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (11, '2025-03-10 16:56:40', 1250.12, 18);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (12, '2025-02-01 14:00:05', 332.16, 1);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (13, '2025-08-03 09:33:51', 641.84, 3);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (14, '2025-03-24 04:31:08', 3784.35, 12);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (15, '2025-08-19 03:24:14', 1384.59, 16);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (16, '2025-07-03 07:35:52', 262.95, 7);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (17, '2025-01-14 07:09:31', 3898.94, 7);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (18, '2025-02-07 04:50:30', 3542.53, 18);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (19, '2025-05-10 00:45:51', 462.38, 10);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (20, '2025-07-30 15:56:38', 1894.9, 19);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (21, '2025-05-18 20:31:15', 1522.18, 7);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (22, '2025-01-26 15:45:20', 1165.59, 12);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (23, '2025-09-01 18:11:46', 2272.58, 16);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (24, '2025-07-18 11:50:55', 3273.65, 16);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (25, '2025-01-29 21:12:55', 380.74, 3);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (26, '2025-06-22 01:37:24', 755.45, 2);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (27, '2025-02-01 15:46:49', 3675.81, 8);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (28, '2025-06-08 04:22:06', 2627.07, 11);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (29, '2025-07-23 08:30:39', 1711.18, 1);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (30, '2025-05-27 11:08:35', 3234.58, 1);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (31, '2025-01-02 15:26:57', 812.52, 15);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (32, '2025-01-30 12:21:53', 323.05, 14);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (33, '2025-01-05 08:52:19', 864.02, 10);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (34, '2025-07-20 18:23:53', 3436.07, 18);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (35, '2025-02-03 07:25:52', 0, 16);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (36, '2025-07-01 06:24:02', 0, 20);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (37, '2025-04-05 09:36:13', 0, 4);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (38, '2025-01-22 10:02:45', 0, 11);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (39, '2025-04-10 02:32:53', 0, 17);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (40, '2025-02-06 18:31:08', 0, 8);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (41, '2025-04-17 11:34:18', 0, 18);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (42, '2025-03-01 03:58:56', 0, 8);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (43, '2025-05-17 22:32:29', 0, 16);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (44, '2025-01-28 23:25:06', 0, 19);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (45, '2025-02-26 21:03:40', 0, 17);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (46, '2025-08-23 06:04:37', 0, 4);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (47, '2025-03-21 06:16:37', 0, 11);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (48, '2025-08-20 00:19:24', 0, 7);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (49, '2025-06-19 23:56:04', 0, 5);
INSERT INTO t_order (id, order_date, total_amount, fk_customer_id) VALUES (50, '2025-01-13 19:15:40', 0, 17);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (1, 361.83, 2, 1, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (2, 234.47, 1, 1, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (3, 115.85, 1, 1, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (4, 81.64, 4, 2, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (5, 29.98, 1, 2, 7);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (6, 390.32, 4, 2, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (7, 129.21, 2, 3, 6);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (8, 115.85, 5, 3, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (9, 81.64, 4, 3, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (10, 390.32, 2, 4, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (11, 203.13, 1, 4, 8);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (12, 234.47, 4, 5, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (13, 81.64, 2, 5, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (14, 390.32, 3, 6, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (15, 361.83, 5, 6, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (16, 234.47, 2, 7, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (17, 390.32, 3, 7, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (18, 59.82, 3, 7, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (19, 129.21, 5, 7, 6);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (20, 81.64, 2, 8, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (21, 203.13, 5, 8, 8);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (22, 390.32, 1, 8, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (23, 151.09, 2, 8, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (24, 151.09, 5, 9, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (25, 151.09, 2, 10, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (26, 129.21, 4, 10, 6);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (27, 203.13, 5, 11, 8);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (28, 234.47, 1, 11, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (29, 151.09, 2, 12, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (30, 29.98, 1, 12, 7);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (31, 59.82, 3, 13, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (32, 59.82, 5, 13, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (33, 81.64, 2, 13, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (34, 390.32, 3, 14, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (35, 115.85, 1, 14, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (36, 81.64, 4, 14, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (37, 361.83, 1, 14, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (38, 361.83, 5, 14, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (39, 361.83, 3, 15, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (40, 59.82, 5, 15, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (41, 203.13, 1, 16, 8);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (42, 59.82, 1, 16, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (43, 129.21, 1, 17, 6);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (44, 361.83, 4, 17, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (45, 59.82, 2, 17, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (46, 361.83, 4, 17, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (47, 151.09, 5, 17, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (48, 234.47, 4, 18, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (49, 81.64, 4, 18, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (50, 234.47, 2, 18, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (51, 361.83, 5, 18, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (52, 59.82, 5, 19, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (53, 81.64, 2, 19, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (54, 129.21, 1, 20, 6);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (55, 29.98, 3, 20, 7);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (56, 234.47, 4, 20, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (57, 390.32, 1, 20, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (58, 115.85, 3, 20, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (59, 390.32, 1, 21, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (60, 81.64, 5, 21, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (61, 361.83, 2, 21, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (62, 234.47, 1, 22, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (63, 59.82, 1, 22, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (64, 115.85, 1, 22, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (65, 151.09, 5, 22, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (66, 151.09, 3, 23, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (67, 234.47, 4, 23, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (68, 151.09, 2, 23, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (69, 115.85, 5, 23, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (70, 390.32, 3, 24, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (71, 390.32, 5, 24, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (72, 151.09, 1, 24, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (73, 59.82, 5, 25, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (74, 81.64, 1, 25, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (75, 151.09, 5, 26, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (76, 151.09, 3, 27, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (77, 81.64, 4, 27, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (78, 151.09, 5, 27, 4);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (79, 115.85, 5, 27, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (80, 390.32, 4, 27, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (81, 234.47, 5, 28, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (82, 129.21, 4, 28, 6);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (83, 234.47, 2, 28, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (84, 234.47, 2, 28, 5);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (85, 29.98, 5, 29, 7);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (86, 390.32, 4, 29, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (87, 361.83, 3, 30, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (88, 81.64, 1, 30, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (89, 115.85, 1, 30, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (90, 390.32, 5, 30, 10);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (91, 203.13, 4, 31, 8);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (92, 203.13, 1, 32, 8);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (93, 29.98, 4, 32, 7);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (94, 115.85, 5, 33, 3);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (95, 203.13, 1, 33, 8);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (96, 81.64, 1, 33, 1);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (97, 29.98, 2, 34, 7);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (98, 361.83, 5, 34, 9);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (99, 59.82, 2, 34, 2);
INSERT INTO t_order_items (id, price, quantity, fk_order_id, fk_product_id) VALUES (100, 361.83, 4, 34, 9);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (1, '814 Eric Ridge Apt. 168', 'Port Brianfort', 1);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (2, '5423 Joyce Parkway Apt. 472', 'Kennethburgh', 2);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (3, '379 Alvarado Island Apt. 299', 'South Amber', 3);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (4, '850 Sanders Freeway', 'East Patriciashire', 4);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (5, '7411 Henderson Club', 'North Kristaville', 5);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (6, '39276 Daniel Center Apt. 110', 'Bakerside', 6);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (7, '615 Franco Cove', 'Michaelburgh', 7);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (8, '21038 Morgan Neck', 'East Christinahaven', 8);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (9, '25130 Anthony Gardens Apt. 692', 'Manntown', 9);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (10, '031 Johnson Forks', 'Ambermouth', 10);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (11, '3161 Michael Islands', 'Leeburgh', 11);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (12, '5735 Erickson Burgs Suite 587', 'Smithborough', 12);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (13, '7272 Julie Ville', 'Lake Paul', 13);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (14, '210 Alicia Bridge Apt. 574', 'Jonesport', 14);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (15, '543 Price Parks', 'North Heatherside', 15);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (16, '70808 Susan Lock', 'Hughesshire', 16);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (17, '72856 Jennifer Crescent Suite 723', 'East Carolynmouth', 17);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (18, '969 Green Spur Suite 975', 'Leestad', 18);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (19, '7147 Paul Key', 'East Katherineburgh', 19);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (20, '9279 King Stream Suite 182', 'South Tinaville', 20);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (21, '7425 Molina Harbors', 'Port David', 21);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (22, '076 Parker Light', 'East Steven', 22);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (23, '96535 Webb Alley', 'Turnerfort', 23);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (24, '636 Hill Lake Apt. 039', 'Mendezton', 24);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (25, '1234 Hernandez Street', 'Mcfarlandmouth', 25);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (26, '7277 Todd Stream Suite 459', 'Charlesfort', 26);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (27, '067 Michael Ferry Apt. 149', 'Mathisberg', 27);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (28, '62728 Rebekah Tunnel Apt. 392', 'Farrellstad', 28);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (29, '97700 Sanchez Road Apt. 884', 'New Andrewview', 29);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (30, '322 Ward Street', 'Lake Melissa', 30);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (31, '60644 Christopher Parkways', 'North Lauraton', 31);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (32, '59692 Pamela Crossing', 'Zacharyfurt', 32);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (33, '531 Ward Lodge', 'Delacruzland', 33);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (34, '268 Jessica Knolls', 'Port Alexa', 34);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (35, '81882 Parker Square', 'North Jenna', 35);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (36, '87165 Wilson Brooks', 'New Henryton', 36);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (37, '3115 Lawrence Land', 'Lake Brianhaven', 37);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (38, '99683 Hendricks Dale', 'Weisstown', 38);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (39, '891 Campbell Crest Apt. 741', 'Port Elizabeth', 39);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (40, '79851 Carmen Walk Suite 799', 'Andersonport', 40);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (41, '2853 Martinez Turnpike Apt. 162', 'Port Robert', 41);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (42, '333 Ryan Burg Apt. 083', 'East Jefferyland', 42);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (43, '723 Chen Cliffs', 'Michelleland', 43);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (44, '6802 Archer Creek Suite 021', 'North Bobbyport', 44);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (45, '7331 Emily Mission Suite 542', 'Lake Tammy', 45);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (46, '428 Brooks Crossroad', 'Lake Tamaraton', 46);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (47, '486 Thomas Station Suite 242', 'Lake Kristahaven', 47);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (48, '521 Matthew Rue', 'Charlesside', 48);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (49, '2221 Johnson Burgs', 'Fuentesmouth', 49);
INSERT INTO tbl_shipping_address (id, address, city, fk_order_id) VALUES (50, '086 Rice Brook Apt. 409', 'East Mitchell', 50);
