<%--
  Created by IntelliJ IDEA.
  User: Ondra
  Date: 2/19/2019
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Customer</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>


</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Add Customer</h3>
        <form:form action="addCustomer" modelAttribute="customer" method="POST">
            <table>
                <tbody>
                <tr>
                    <td>
                        <label>First Name: </label>
                    </td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td>
                        <label>Last Name: </label>
                    </td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td>
                        <label>Email: </label>
                    </td>
                    <td><form:input path="email"/></td>

                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Add" class="save"></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
        </p>

    </div>
</body>
</html>
