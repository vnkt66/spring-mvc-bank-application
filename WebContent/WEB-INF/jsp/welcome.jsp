<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Bank</title>
<style type="text/css">

table {
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body>
	<div style="padding: 30px 0 30px 0; border-radius: 10px; font-size: 20px; text-align: center;">
	  Transactions
	  
	  <table style="margin: 4% 0 4% 30%">
        <tr>
            <th>Id</th><th>Date</th><th>Amount</th>
        </tr>
        <c:forEach items="${transactions}" var="transaction">
            <tr>
            <td>${transaction.getId()}</td>
            <td>${transaction.getDate()}</td>
            <td>${transaction.getAmount()}</td>
            </tr>
        </c:forEach>
    </table>
    
    <p>Account Balance: ${accountBalance}</p>
	</div>
	<a href="index.jsp" style="color: blue; position: absolute; left: 5%; font-size: 20px;">Home Page</a>
	<a href="/BankSpringMVC/transfer.html" style="color: blue; position: absolute; right: 5%; font-size: 20px;">Transfer Money</a>
</body>
</html>