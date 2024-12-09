<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Orders - Handloom Fashion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: #e0f7fa;
            color: #333;
        }
        header {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background: #6a1b9a;
            color: white;
        }
        header .logo {
            font-size: 24px;
            font-weight: bold;
        }
        nav ul {
            list-style: none;
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            margin: 0;
            padding: 0;
        }
        nav a {
            color: white;
            text-decoration: none;
        }
        .header-links {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }
        .btn {
            background: #ff4081;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            text-decoration: none;
        }
        .order-container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background: #ffffff;
            border-radius: 5px;
        }
        .order-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .order-items {
            list-style: none;
            padding: 0;
        }
        .order-items li {
            display: flex;
            justify-content: space-between;
            border-bottom: 1px solid #ccc;
            padding: 10px 0;
        }
        .order-items li:last-child {
            border-bottom: none;
        }
        footer {
            text-align: center;
            padding: 20px;
            background: #6a1b9a;
            color: white;
			position: fixed;
			width: 100%;
			bottom: 0;
        }
    </style>
</head>
<body>

<header>
	<div class="logo"><a href="index.html">Handlooms</a></div>
    <nav>
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="Add New Student.html">Add New Student</a></li>
            <li><a href="Insert New Result.html">Insert New Result</a></li>
            <li><a href="about.html">About</a></li>
            <li><a href="All Students Results.html">All Students Results</a></li>
            <li><a href="orders.html" id="orders-link">Orders</a></li>
        </ul>
    </nav>
    <div class="header-links">
		<a href="logout.html" class="btn">LogOut</a>
    </div>
</header>

<main>
    <div class="order-container">
        <h2>Your Orders</h2>
        <ul class="order-items" id="order-items">
            <!-- Order items will be populated here -->
        </ul>
        <p><strong>Total: <span id="order-total">$0</span></strong></p>
    </div>
</main>

<footer>
    <p>&copy; 2024 Handloom Fashion. All rights reserved.</p>
</footer>

<script>
    document.addEventListener('DOMContentLoaded', () => {
        updateOrders();
    });

    function updateOrders() {
        let orders = JSON.parse(localStorage.getItem('orders')) || [];
        let orderItems = document.getElementById('order-items');
        let orderTotal = 0;

        orderItems.innerHTML = '';

        fetch('/api/products')  // Assuming you have an API to get all available products
            .then(response => response.json())
            .then(availableProducts => {
                orders = orders.filter(item => availableProducts.some(p => p.name === item.name));
                localStorage.setItem('orders', JSON.stringify(orders));

                orders.forEach(item => {
                    let itemTotal = item.price * item.quantity;
                    orderTotal += itemTotal;

                    let li = document.createElement('li');
                    li.innerHTML = `${item.name} - $${item.price} 
                                     <span>Qty: ${item.quantity}</span>
                                     <span>$${itemTotal.toFixed(2)}</span>`;
                    orderItems.appendChild(li);
                });

                document.getElementById('order-total').textContent = $${orderTotal.toFixed(2)};
            });
    }
</script>

</body>
</html>