<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header id="header">
    <div class="headerbar">
        <ul class="header-nav header-nav-options pull-right">
            <li>
                <button type="submit" onclick="location.href='/content'" class="btn btn-icon-toggle ink-reaction"><i
                        class="fa fa-fw fa-table text-primary"></i></button>
            </li>
            <li>
                <button type="submit" onclick="location.href='/logout'" class="btn btn-icon-toggle ink-reaction"><i
                        class="fa fa-fw fa-power-off text-danger"></i></button>
            </li>
        </ul>
    </div>
</header>