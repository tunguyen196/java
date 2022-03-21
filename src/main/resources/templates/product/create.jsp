<!DOCTYPE HTML>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Form</h1>
    <form action="#" th:action="@{/product/create}" th:object="${product}" method="post">
        <p>name: <input type="text" th:field="*{name}" /></p>
        <p>amount: <input type="text" th:field="*{amount}" /></p>
        <p>price: <input type="text" th:field="*{price}" /></p>
        <p>url: <input type="text" th:field="*{url}" /></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
    </form>
</body>
</html>