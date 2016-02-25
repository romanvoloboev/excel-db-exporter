<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru, en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="includes/css.jsp"%>
    <title>Страница не существует | Excel DB Exporter</title>
</head>
<body class="menubar-hoverable header-fixed ">
<div id="base">
    <div id="content">
        <section>
            <div class="section-body contain-lg">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h1><span class="text-xxxl text-light">404 <i class="fa fa-search-minus text-primary"></i></span></h1>
                        <h2 class="text-light">Oops.. Похоже, что запрашиваемая страница не существует :(</h2>
                        <h3 class="text-light"><a href="<c:url value="/"/>"><i class="fa fa-home text-primary"></i> На главную</a></h3>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<%@include file="includes/js.jsp"%>
</body>
</html>