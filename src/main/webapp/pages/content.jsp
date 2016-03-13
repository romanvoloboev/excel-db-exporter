<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru, en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="includes/css.jsp" %>
    <title>Excel DB Exporter</title>
</head>

<body class="menubar-hoverable header-fixed menubar-pin ">
<%@include file="includes/header.jsp" %>
<div id="base">
    <div class="offcanvas"></div>
    <div id="content">
        <section>
            <div class="row">
                <div id="table" class="col-lg-12">
                    <div class="card">
                        <div class="card-body no-padding">
                            <div class="table-responsive no-margin">
                                <table class="table table-striped no-margin">
                                    <thead>
                                    <tr>
                                        <th class="text-left">Год</th>
                                        <th class="text-left">КА</th>
                                        <th class="text-left">РН</th>
                                        <th class="text-left">Оператор КА</th>
                                        <th class="text-left">Платформа КА</th>
                                        <th class="text-left">Назначение КА</th>
                                        <th class="text-left">Срок</th>
                                        <th class="text-left">Масса</th>
                                        <th class="text-left">Изготовитель</th>
                                        <th class="text-left">Орбита</th>
                                        <th class="text-left">Провайдер</th>
                                        <th class="text-left">Космодром</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${rowsList}" var="row">
                                        <tr>
                                            <td class="text-left">${row.god}</td>
                                            <td class="text-left">${row.KA}</td>
                                            <td class="text-left">${row.RN}</td>
                                            <td class="text-left">${row.operatorKA}</td>
                                            <td class="text-left">${row.platformaKA}</td>
                                            <td class="text-left">${row.naznachenieKA}</td>
                                            <td class="text-left">${row.srok}</td>
                                            <td class="text-left">${row.massa}</td>
                                            <td class="text-left">${row.izgotovitel}</td>
                                            <td class="text-left">${row.orbita}</td>
                                            <td class="text-left">${row.provaider}</td>
                                            <td class="text-left">${row.kosmodrom}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<%@include file="includes/js.jsp" %>
</body>
</html>