<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MCQ Quiz</title>
    <style>
        /* Add CSS styles for the logout message */
        #logoutMessage {
            font-size: 50px;
            color: Red;
            font-weight: bold;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Thank You!</h1>
    <p>Your quiz has been submitted successfully. We appreciate your participation.</p>

    <!-- Logout Form -->
    <form id="logoutForm" action="LogoutServlet" method="post">
        <button type="submit">Logout</button>
    </form>

    <!-- Logout Message Container -->
    <div id="logoutMessage"></div>

    <!-- Timer and JavaScript Code Here -->
    <script>
        document.getElementById("logoutForm").addEventListener("submit", function (event) {
            event.preventDefault(); // Prevent the form from submitting normally

            // Send a POST request to LogoutServlet
            fetch('LogoutServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: 'logout=true',
            })
            .then(response => response.json()) // You can adjust this based on the expected response
            .then(data => {
                // Display the styled logout message
                var logoutMessage = document.getElementById("logoutMessage");
                var paragraph = document.createElement("p");
                paragraph.style.color = "green";
                paragraph.style.fontWeight = "bold";
                paragraph.style.textAlign = "center";
                paragraph.innerText = data.message;

                // Clear existing content and append the new paragraph
                logoutMessage.innerHTML = "";
                logoutMessage.appendChild(paragraph);

                // Optionally, redirect to the home page after a delay (e.g., 3 seconds)
                setTimeout(function() {
                    window.location.href = 'home.html';
                }, 3000);
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    </script>
</body>
</html>
