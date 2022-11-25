<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="${path}/css/normalize.css">
    <link rel="stylesheet" href="${path}/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
    <title>Pluto Backend Assignment</title>
</head>

<body>
<header>
    <h1>Short URL Generator</h1>
</header>
<main>
    <div class="detail-section">
        <div class="section-title">URL Details</div>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
            </thead>
            <tbody>
            <tr>
                <td>Destination URL</td>
                <td>${url.destinationUrl}</td>
            </tr>
            <tr>
                <td>Short URL</td>
                <td><a href="${path}/${url.shortUrl}">http://localhost:8888/${url.shortUrl}</a></td>
            </tr>
            <tr>
                <td>Created At</td>
                <td>${url.urlCreateDate}</td>
            </tr>
            <tr>
                <td>Total Clicks</td>
                <td>${url.totalClick}</td>
            </tr>
            <tr>
                <td>Last Clicked At</td>
                <td>${url.lastClickDate}</td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="detail-section">
        <div class="section-title">Access Logs</div>
        <table>
            <thead>
            <tr>
                <th>IP</th>
                <th>User Agent</th>
                <th>Referrer</th>
                <th>Clicked At</th>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${url.accessLogList.size() == 0}">
                    <tr>
                        <td colspan="4" class="no-data-td">No Data</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${url.accessLogList}" var="accessLog">
                        <tr>
                            <td>${accessLog.ip}</td>
                            <td>${accessLog.userAgent}</td>
                            <td>${accessLog.referrer}</td>
                            <td>${accessLog.accessLogCreateDate}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
