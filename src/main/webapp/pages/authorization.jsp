<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>LotyShop/authorization</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">LotyShop</a>

        <div class="btn-group" role="group" aria-label="Basic example">
            <a class="btn btn-outline-success" href="<c:url value="/authorization"/>" role="button">Login</a>
            <a class="btn btn-outline-success" href="<c:url value="/registration"/>" role="button">Registration</a>
        </div>

    </div>
</nav>
<div class="container">
    <form action="${pageContext.request.contextPath}/authorization" method="post">
        <div class="col-4 align-self-center">
            <div class="col-4">
                <div class="p-3 border bg-light"></div>
            </div>
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingInput" name="email" placeholder="email">
                <label for="floatingInput">Email address</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" name="password"
                       placeholder="password">
                <label for="floatingPassword">Password</label>
            </div>
            <div class="col-4">
                <div class="p-3 border bg-light"></div>
            </div>
            <div class="col-4">
                <input type="submit" value="Login" class="btn btn-secondary btn">
            </div>
        </div>
    </form>
</div>
</body>
</html>
