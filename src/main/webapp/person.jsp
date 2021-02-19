<%@ page import="dev.qwett.model.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="500" align="center">
    <tr>
        <th><b>First Name</b></th>
        <th><b>Last Name</b></th>
    </tr>
    <%-- Fetching the attributes of the request object
         which was previously set by the servlet`
          "StudentServlet.java"
    --%>
    <%
        ArrayList<Person> personList =
                (ArrayList<Person>) request.getAttribute("personList");
        for (Person obj : personList) {%>
    <%-- Arranging data in tabular form
    --%>
    <tr>
        <td><%=obj.getFirstName()%>
        </td>
        <td><%=obj.getLastName()%>
        </td>
    </tr>
    <%}%>
</table>
<p>
    <form method="post">
        <p>Имя
            <input type="text" name="firstName"/>
        </p>
        <p>Фамилия
            <input type="text" name="lastName"/>
        </p>
        <input type="submit" value="Добавить"/>
    </form>
</body>
</html>