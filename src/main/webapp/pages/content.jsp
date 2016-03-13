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
<header id="header">
    <div class="headerbar">
        <ul class="header-nav header-nav-options pull-right">
            <li>
                <button type="submit" onclick="location.href='/'" class="btn btn-icon-toggle ink-reaction"><i
                        class="fa fa-fw fa-home text-primary"></i></button>
            </li>
            <li>
                <button type="submit" onclick="location.href='/logout'" class="btn btn-icon-toggle ink-reaction"><i
                        class="fa fa-fw fa-power-off text-danger"></i></button>
            </li>
        </ul>
    </div>
</header>
<div id="base">
    <div class="offcanvas"></div>
    <div id="content">
        <section>
            <div class="row">
                <div id="table" class="col-lg-12" style="padding-top: 15px; font-size: 12px;">
                    <div class="card">
                        <div class="card-body no-padding">
                            <div class="table-responsive no-margin">
                                <table class="table table-striped no-margin">
                                    <thead>
                                    <tr>
                                        <th class="">Год</th>
                                        <th class="">КА</th>
                                        <th class="">РН</th>
                                        <th class="">Оператор КА</th>
                                        <th class="">Платформа КА</th>
                                        <th class="">Назначение КА</th>
                                        <th class="">Срок</th>
                                        <th class="">Масса</th>
                                        <th class="">Изготовитель</th>
                                        <th class="">Орбита</th>
                                        <th class="">Провайдер</th>
                                        <th class="">Космодром</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${rowsList}" var="row">
                                        <tr>
                                            <td class="">${row.god}</td>
                                            <td class="">${row.KA}</td>
                                            <td class="">${row.RN}</td>
                                            <td class="">${row.operatorKA}</td>
                                            <td class="">${row.platformaKA}</td>
                                            <td class="">${row.naznachenieKA}</td>
                                            <td class="">${row.srok}</td>
                                            <td class="">${row.massa}</td>
                                            <td class="">${row.izgotovitel}</td>
                                            <td class="">${row.orbita}</td>
                                            <td class="">${row.provaider}</td>
                                            <td class="">${row.kosmodrom}</td>
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