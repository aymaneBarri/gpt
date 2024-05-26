<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notifications</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-2v9eWmA4l1TjPtUJ6a9ftYrKkx8tL9WyMlsWv6sk3Kx6jdihyZ1tPPgIsvF5n1KJ" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
    <style>
    	body {
		    background-color: #f8f9fa;
		}
		
		.list-group-item {
		    border-radius: 5px;
		    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}
    	
    </style>
</head>
<body>
    <div class="container mt-5 offcanvas offcanvas-end" tabindex="-1" id="offcanvas-notifications" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel">Notifications</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas-comments"
				aria-label="Close"></button>
		</div>
        <div class="list-group">
            <div class="list-group-item list-group-item-action mb-2">
                <h6 class="mb-1">Notification</h6>
                <p class="mb-1">This is a notification message.</p>
            </div>
            <div class="list-group-item list-group-item-action mb-2">
                <h6 class="mb-1">Notification</h6>
                <p class="mb-1">Another notification message.</p>
            </div>
            <div class="list-group-item list-group-item-action mb-2">
                <h6 class="mb-1">Notification</h6>
                <p class="mb-1">Yet another notification message.</p>
            </div>
            <!-- Add more static notifications as needed -->
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76A8fkpD6pdt94a4N6bJuqyX4hnFEaEjt8ub78J8CuKxY0hNrEapXIszA3FLxi6" crossorigin="anonymous"></script>
</body>
</html>
