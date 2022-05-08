<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>LotyShop/administration</title>
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/"/>">LotyShop</a>
        <c:if test="${!isAuthorized}">
            <div class="btn-group" role="group" aria-label="Basic example">
                <a class="btn btn-outline-success" href="<c:url value="/authorization"/>" role="button">Login</a>
                <a class="btn btn-outline-success" href="<c:url value="/registration"/>" role="button">Registration</a>
            </div>
        </c:if>
        <c:if test="${isAuthorized}">
            <div class="btn-group" role="group" aria-label="Basic example">
                <a class="btn btn-outline-success" href="<c:url value="/logOut"/>" role="button">LogOut</a>
            </div>
        </c:if>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col">
            <img src="${product.image}" class="img-thumbnail" alt="...">
        </div>
        <div class="col">
            <h1>${product.name}</h1>
            <p><em>${product.description}</em></p>
        </div>
    </div>
    <div class="row">
        <div class="col">
            ${product.company.name}
        </div>
        <div class="col">
        </div>
        <div class="col">
            <a type="button" href="<c:url value="/product?id=${product.id}"/>" class="btn btn-secondary">Buy</a>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
        integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
        integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
        crossorigin="anonymous"></script>
</body>
</html>