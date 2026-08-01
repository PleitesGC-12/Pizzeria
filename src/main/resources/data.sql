-- Customers
INSERT INTO customers (customer_id, customer_name, address, email, phone_number)
VALUES
    ('CLI-001', 'John Smith', '123 Main St', 'john.smith@email.com', '5555-1111'),
    ('CLI-002', 'Emily Johnson', '456 Oak Ave', 'emily.j@email.com', '5555-2222'),
    ('CLI-003', 'Michael Brown', NULL, 'michael.b@email.com', '5555-3333'),
    ('CLI-004', 'Sarah Davis', '789 Pine Rd', 'sarah.d@email.com', '5555-4444'),
    ('CLI-005', 'James Wilson', '321 Elm St', 'james.w@email.com', '5555-5555'),
    ('CLI-006', 'Emma Martinez', NULL, 'emma.m@email.com', '5555-6666'),
    ('CLI-007', 'Robert Taylor', '654 Maple Dr', 'robert.t@email.com', '5555-7777'),
    ('CLI-008', 'Olivia Anderson', '987 Cedar Ln', 'olivia.a@email.com', '5555-8888'),
    ('CLI-009', 'William Thomas', NULL, 'william.t@email.com', '5555-9999'),
    ('CLI-010', 'Sophia Jackson', '147 Birch Blvd', 'sophia.j@email.com', '5555-0000')
    ON CONFLICT (customer_id) DO NOTHING;

-- Pizzas
INSERT INTO pizzas (name, description, price, vegetarian, vegan, available)
VALUES
    ('Margherita', 'Tomato sauce, mozzarella and fresh basil', 8.99, true, false, true),
    ('Pepperoni', 'Tomato sauce, mozzarella and pepperoni', 10.99, false, false, true),
    ('Vegan Delight', 'Tomato sauce, mixed vegetables and vegan cheese', 9.99, true, true, true),
    ('BBQ Chicken', 'BBQ sauce, grilled chicken and red onion', 11.99, false, false, true),
    ('Hawaiian', 'Tomato sauce, mozzarella, ham and pineapple', 10.50, false, false, true),
    ('Four Cheese', 'Mozzarella, gouda, parmesan and blue cheese', 12.99, true, false, true),
    ('Meat Lovers', 'Tomato sauce, beef, bacon and sausage', 13.99, false, false, true),
    ('Spinach Mushroom', 'Tomato sauce, spinach, mushrooms and mozzarella', 9.50, true, false, true),
    ('Buffalo Chicken', 'Buffalo sauce, chicken, celery and mozzarella', 12.50, false, false, false),
    ('Truffle Mushroom', 'Truffle oil, mushrooms, parmesan and arugula', 14.99, true, false, true)
    ON CONFLICT (name) DO NOTHING;

-- Pizza Orders
INSERT INTO pizza_orders (customer_id, date, total, order_method, additional_notes)
VALUES
    ('CLI-001', '2024-01-10 12:00:00', 19.98, 'DELIVERY', 'No onions please'),
    ('CLI-002', '2024-01-11 13:30:00', 10.99, 'PICKUP', NULL),
    ('CLI-003', '2024-01-12 14:00:00', 22.98, 'DINE_IN', 'Window table please'),
    ('CLI-004', '2024-01-13 18:30:00', 11.99, 'DELIVERY', 'Ring the doorbell'),
    ('CLI-005', '2024-01-14 19:00:00', 23.98, 'PICKUP', NULL),
    ('CLI-006', '2024-01-15 20:00:00', 9.99, 'DINE_IN', NULL),
    ('CLI-007', '2024-01-16 12:30:00', 26.98, 'DELIVERY', 'Leave at the door'),
    ('CLI-008', '2024-01-17 13:00:00', 12.99, 'PICKUP', NULL),
    ('CLI-009', '2024-01-18 19:30:00', 24.49, 'DINE_IN', 'Allergy: nuts'),
    ('CLI-010', '2024-01-19 20:30:00', 13.99, 'DELIVERY', 'Extra napkins please')
    ON CONFLICT (id_order) DO NOTHING;

-- Order Items
INSERT INTO order_items (item_id, order_id, id_pizza, quantity, price)
VALUES
    (1, 1, 1, 1, 8.99),
    (2, 1, 2, 1, 10.99),
    (1, 2, 2, 1, 10.99),
    (1, 3, 3, 1, 9.99),
    (2, 3, 4, 1, 11.99),
    (1, 4, 4, 1, 11.99),
    (1, 5, 5, 1, 10.50),
    (2, 5, 7, 1, 13.99),
    (1, 6, 3, 1, 9.99),
    (1, 7, 6, 1, 12.99),
    (2, 7, 7, 1, 13.99),
    (1, 8, 6, 1, 12.99),
    (1, 9, 8, 1, 9.50),
    (2, 9, 5, 1, 10.50),
    (2, 9, 9, 1, 12.50),
    (1, 10, 7, 1, 13.99)
    ON CONFLICT (item_id, order_id) DO NOTHING;