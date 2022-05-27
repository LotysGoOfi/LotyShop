<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>LotyShop/administration/companies</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value="/administration"/>">LotyShop</a>

        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/administration/products"/>">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/administration/users"/>">Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="<c:url value="/administration/companies"/>">Companies</a>
            </li>
        </ul>
    </div>
</nav>

<table class="table">
    <thead>
    <tr>
        <th scope="col"> Name</th>
        <a class="btn btn-primary" href="<c:url value="/administration/companies/create"/>" role="button">AddCompany</a>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="company" items="${companies}">
        <tr>

            <td> ${company.name}</td>
            <td>
                <a class="btn btn-primary" href="<c:url value="/administration/companies/change?id=${company.id}"/>"
                   role="button">Edit</a>
            </td>
            <td>
                <a class="btn btn-primary" href="<c:url value="/administration/companies/delete?id=${company.id}"/>"
                   role="button">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col">--%>
<%--            Name--%>
<%--        </div>--%>
<%--        <div class="col">--%>
<%--            <a class="btn btn-primary" href="<c:url value="/administration/companies/create"/>" role="button">AddCompany</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="p-3 border bg-light"><span class="placeholder col-12"></span></div>--%>
<%--    <c:forEach var="company" items="${companies}">--%>
<%--        <div class="row">--%>
<%--            <div class="col">--%>
<%--                    ${company.name}--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                <a class="btn btn-primary" href="<c:url value="/administration/companies/change?id=${company.id}"/>" role="button">Edit</a>--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                <a class="btn btn-primary" href="<c:url value="/administration/companies/delete?id=${company.id}"/>" role="button">Delete</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="p-3 border bg-light"><span class="placeholder col-12"></span></div>--%>
<%--    </c:forEach>--%>

<%--</div>--%>


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