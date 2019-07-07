<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Speech Recognition</title>
    <link href="https://fonts.googleapis.com/css?family=Sniglet:400,800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="app.css">
</head>
<body>
    <div class="wrapper">
        <header class="header">
            <h1 class="header-title">Speech Recognition</h1>
        </header>
        <main class="main">
            <div class="form-wrapper">
              <h2 class="command-logo">VAX2</h2>
              <p class="initials">Say your fullname</p>
              <button class="btn-audio">Click here</button>
              <div class="user-wrapper">
                <h3 class="user-title">Your name</h3>
                <div class="user-data"></div>
                <h4 class="question-title">Correct?</h4>
                <div class="button-wrapper">
                    <button class="btn true" data-status="true">Yes</button>
                    <button class="btn false" data-status="false">No</button>
                </div>
              <div>
            </div>
        </main>
        <footer class="footer">
            <h2 class="footer-title">Our Team</h2>
            <h3 class="footer-logo">VAx2</h3>
        </footer>
    </div>
    <script src="index.js"></script>
</body>
</html>