<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fastcampus</title>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
</head>
<body>
<div id="menu">
    <ul>
        <li id="logo">fastcampus</li>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="<c:url value='/board/list'/>">Board</a></li>
        <li><a href="<c:url value='/login/login'/>">login</a></li>
        <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
        <li><a href=""><i class="fas fa-search small"></i></a></li>
    </ul>
</div>
<script>
 let msg = "${param.msg}";
 if(msg=="DEL_OK") alert("성공적으로 삭제되었습니다.");
</script>
<div style="text-align:center">
    <table border="1">
        <tr>
            <th>제목</th>
            <th>작성자</th>
            <th>작성날짜</th>
        </tr>
        <c:forEach var="boardDto" items="${list}">
        <tr>
            <th><a href="<c:url value="/board/read?e_title=${boardDto.e_title}&page=${page}&pageSize=${pageSize}"/>">${boardDto.e_title}</a></th>
            <th>관리자</th>
            <th><fmt:formatDate value="${boardDto.e_date}" pattern="yyyy.MM.dd"/></th>
        </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <c:if test="${ph.showPrev}">
            <a href="<c:url value='/board/list?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>">&lt;</a>
        </c:if>
        <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <a href="<c:url value='/board/list?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
        </c:forEach>
        <c:if test="${ph.showNext}">
            <a href="<c:url value='/board/list?page=${ph.endPage+1}&pageSize=${ph.pageSize}'/>">&gt;</a>
        </c:if>
    </div>
</div>
</body>
</html>