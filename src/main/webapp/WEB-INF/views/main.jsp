<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>Garden</h2>
<table border="1" cellpadding="3" cellspacing="1">
    <tr>
        <th>Id</th>
        <th>Деревья</th>
        <th></th>
    </tr>
    <c:forEach items="${parkings}" var="parking">
        <tr>
            <td>${tree.id}</td>
            <td><input type="text" id="idTreeType" value="${tree.type}" name="type"></td>
            <td>
                <form:form name="formUpdate" method="post" action="update">
                    <input type="hidden" name="id" id="updateId">
                    <input type="hidden" name="type" id="updateType">
                    <input type="button" value="Обновить" onclick="updateTree(${tree.id}, ${tree.type})">
                </form:form>
            </td>
            <td>
                <form:form method="post" action="delete">
                    <input type="hidden" name="id" value=${tree.id}>
                    <input type="submit" value="Удалить">
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<form:form method="post" action="add">
    <input type="submit" value="Добавить">
</form:form>

<script type="text/javascript">
    function updateTree(id, type){
        document.getElementById("updateId").value = id;
        document.getElementById("updateType").value = type;
        document.formUpdate.action = "update";
        document.formUpdate.submit();
//        $.ajax({
//            type :      "GET",
//            url:        "update",
//            dataType:   "json",
//            data:       {id, type},
//            success : function(result){
//                if (result != null && result.length > 0){
//                    $('idTreeType').val() = result.idTreeType;
//                }
//            }
//        })
    }
</script>

</body>
</html>