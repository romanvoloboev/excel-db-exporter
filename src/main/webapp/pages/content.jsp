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
    <style type="text/css">
        .dropzone {
            border: dashed 2px rgba(72, 72, 67, 0.50);
            border-radius: 5px;
            padding: 0;
            min-height: 80px;
        }
    </style>
</head>

<body class="menubar-hoverable header-fixed menubar-pin ">
<%@include file="includes/header.jsp" %>
<div id="base">
    <div class="offcanvas"></div>
    <div id="content">
        <section>
            <div class="row">
                <div class="col-lg-12 text-center" style="margin-top: 10px;">
                    <h4>Содержимое файла ${file.fileName}</h4>
                </div>
                <div id="table" class="col-lg-12">
                    <div class="card">
                        <div class="card-body no-padding">
                            <div class="table-responsive no-margin">
                                <table class="table table-striped no-margin">
                                    <thead>
                                    <tr>
                                        <th class="text-left"><c:out value="${rowsList[0].name}"/></th>
                                        <th class="text-left"><c:out value="${rowsList[0].phone}"/></th>
                                        <th class="text-left"><c:out value="${rowsList[0].email}"/></th>
                                        <th class="text-left"><c:out value="${rowsList[0].date}"/></th>
                                        <th class="text-left"><c:out value="${rowsList[0].company}"/></th>
                                        <th class="text-left"><c:out value="${rowsList[0].country}"/></th>
                                        <th class="text-left"><c:out value="${rowsList[0].city}"/></th>
                                        <th class="text-left"><c:out value="${rowsList[0].guid}"/></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${rowsList}" var="row" begin="1">
                                        <tr>
                                            <td class="text-left">${row.name}</td>
                                            <td class="text-left">${row.phone}</td>
                                            <td class="text-left">${row.email}</td>
                                            <td class="text-left">${row.date}</td>
                                            <td class="text-left">${row.company}</td>
                                            <td class="text-left">${row.country}</td>
                                            <td class="text-left">${row.city}</td>
                                            <td class="text-left">${row.guid}</td>
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