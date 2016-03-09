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
            <div class="col-centered col-md-12 text-center"
                 style="padding-top: 17px; padding-left: 0; padding-right: 0;">
                <div id="filePreview" class="dropzone"></div>
            </div>
            <div class="row">
                <div class="col-lg-12 text-center" style="margin-top: 10px;">
                    <h4>Ваши загруженные файлы</h4>
                </div>
                <div id="table" class="col-lg-12">
                    <div class="card">
                        <div class="card-body no-padding">
                            <div class="table-responsive no-margin">
                                <table class="table table-striped no-margin">
                                    <thead>
                                    <tr>
                                        <th class="text-center">Название файла</th>
                                        <th class="text-center">Размер</th>
                                        <th class="text-center">Дата загрузки</th>
                                        <th class="text-center">Автор</th>
                                        <th class="text-center">Действие</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:choose>
                                        <c:when test="${not empty fileList}">
                                            <c:forEach items="${fileList}" var="f">
                                                <tr>
                                                    <td class="text-center">${f.fileName}</td>
                                                    <td class="text-center">${f.fileSize} МБ.</td>
                                                    <td class="text-center">${f.uploadDate}</td>
                                                    <td class="text-center">${f.customer}</td>
                                                    <td class="text-center">
                                                        <a href="<c:url value="/content?id=${f.id}"/>"
                                                           data-toggle="tooltip"
                                                           class="btn btn-icon-toggle ink-reaction btn-primary"
                                                           title="Открыть содержимое"><i class="fa fa-file-excel-o"></i></a>
                                                        <button type="button" onclick="" data-toggle="tooltip"
                                                                class="btn btn-icon-toggle ink-reaction btn-danger"
                                                                title="Удалить файл">
                                                            <span class="fa fa-trash"></span>
                                                        </button>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td class="text-center" colspan="5"><h4>Ничего нет..</h4></td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
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