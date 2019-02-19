<%--
  Created by IntelliJ IDEA.
  User: Doma
  Date: 19.02.2019
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CRM</title>

    <!-- reference stylesheet --->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Realtionship Manager</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">
            <%--put new button: Add Customer--%>

            <input type="button" value="Add Customer"
                   onclick="window.location.href='showFormForAdd'; return false;"
                class="add-button"
            />

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <%--Loop over and print customers--%>
                <c:forEach var="tempCustomer" items="${customers}">
                    <%--construct an update link with customer id--%>
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <%--dipsplay the update link--%>
                            <a href="${updateLink}">Update</a>


                        </td>
                        <td></td>
                    </tr>

                </c:forEach>



            </table>
        </div>
    </div>

<h2>JSP</h2>
</body>
</html>
