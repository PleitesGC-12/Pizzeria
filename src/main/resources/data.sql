-- Customers
INSERT INTO customers (customer_id, customer_name, address, email, phone_number)
VALUES
    ('CLI-001', 'Juan Perez', 'Av. Central 101', 'juan@email.com', '7777-1111'),
    ('CLI-002', 'Maria Lopez', 'Calle 5 Sur 202', 'maria@email.com', '7777-2222'),
    ('CLI-003', 'Carlos Diaz', NULL, 'carlos@email.com', '7777-3333')
    ON CONFLICT (customer_id) DO NOTHING;

-- Pizzas
INSERT INTO pizzas (name, description, price, vegetarian, vegan, available)
VALUES
    ('Margherita', 'Tomate, mozzarella y albahaca', 8.99, true, false, true),
    ('Pepperoni', 'Tomate, mozzarella y pepperoni', 10.99, false, false, true),
    ('Vegana', 'Tomate, verduras y queso vegano', 9.99, true, true, true),
    ('BBQ Chicken', 'Salsa BBQ, pollo y cebolla', 11.99, false, false, true),
    ('Hawaiana', 'Tomate, mozzarella, jamon y pina', 10.50, false, false, false)
    ON CONFLICT (name) DO NOTHING;

-- Pizza Orders
INSERT INTO pizza_orders (customer_id, date, total, order_method, additional_notes)
VALUES
    ('CLI-001', '2024-01-15 12:30:00', 19.98, 'DELIVERY', 'Sin cebolla'),
    ('CLI-002', '2024-01-15 13:00:00', 10.99, 'PICKUP', NULL),
    ('CLI-001', '2024-01-16 19:00:00', 21.49, 'DELIVERY', 'Tocar el timbre'),
    ('CLI-003', '2024-01-17 20:00:00', 9.99, 'PICKUP', NULL)
    ON CONFLICT (id_order) DO NOTHING;

-- Order Items
INSERT INTO order_items (item_id, order_id, id_pizza, quantity, price)
VALUES
    (1, 1, 1, 1, 8.99),
    (2, 1, 2, 1, 10.99),
    (1, 2, 2, 1, 10.99),
    (1, 3, 4, 1, 11.99),
    (2, 3, 3, 1, 9.50),
    (1, 4, 3, 1, 9.99)
    ON CONFLICT (item_id, order_id) DO NOTHING;