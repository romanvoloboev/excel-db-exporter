<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru, en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="includes/css.jsp"%>
    <title>Вход | Excel DB Exporter</title>
</head>

<body class="menubar-hoverable header-fixed ">
<section class="section-account">
    <div class="img-backdrop" style="background-image: url('<c:url value="../resources/img/login_4.jpg"/> ')"></div>
    <div class="spacer"></div>
    <div class="card contain-sm style-transparent">
        <div class="card-body">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <br/>
                    <span class="text-lg text-bold text-primary">ВХОД В СИСТЕМУ</span>
                    <br/><br/>
                    <form class="form floating-label" action="<c:url value="/login_processing"/>" accept-charset="utf-8" method="post">
                        <div class="form-group <c:out value="${failed ? 'has-error':''}"/>">
                            <input type="text" class="form-control" id="username" name="username" required>
                            <label for="username">Логин</label>
                        </div>
                        <div class="form-group <c:out value="${failed ? 'has-error':''}"/>">
                            <input type="password" class="form-control" id="password" name="password" required>
                            <label for="password">Пароль</label>
                            <p class="help-block" style="<c:out value="${failed ? 'color:#6f7676':''}"/>"><a href="#">Забыли?</a></p>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-xs-6 text-left">
                                <div class="checkbox checkbox-inline checkbox-styled">
                                    <label>
                                        <input type="checkbox" name="remember-me" value="true"> <span>Запомнить меня</span>
                                    </label>
                                </div>
                            </div>
                            <div class="col-xs-6 text-right">
                                <button class="btn btn-primary btn-raised" type="submit">Войти</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="includes/js.jsp"%>
</body>
</html>