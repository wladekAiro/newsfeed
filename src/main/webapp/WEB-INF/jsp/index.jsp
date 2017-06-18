<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/jsp/common/head.jsp">
        <jsp:param name="title" value="News feed"/>
    </jsp:include>
    <link type="text/css" href="/resources/components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
</head>

<body>
<div class="navbar">
    <jsp:include page="/WEB-INF/jsp/common/topmenu.jsp"/>
</div>

<div class="col-sm-2"></div>
<div class="col-sm-8">
    <div id="app">
        <div v-for="feed in items">
            <div class="row">
                <div class="col-sm-12">
                    <div class="row">
                    <ul>
                        <li>
                            <a v-bind:href="feed.url"><h3>{{ feed.title }}</h3></a>
                        </li>
                    </ul>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <p>{{ feed.description }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="col-sm-2"></div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/components/jquery/dist/jquery.min.js"></script>
<script src="/resources/components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="/resources/components/holderjs/holder.js"></script>
<script src="/resources/components/vue/dist/vue.js"></script>
<script src="/resources/js/main.js"></script>
</body>
</html>
