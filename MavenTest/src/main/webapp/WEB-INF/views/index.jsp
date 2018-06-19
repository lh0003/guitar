<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/13 0013
  Time: 上午 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>首页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default   navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">吉他商铺</a>
        </div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/mvn/search"><span class="glyphicon glyphicon-search"></span> 查找</a></li>
        </ul>
    </div>
</nav>
<form role="form" method="post" action="/mvn/search">
    <div class="form-group">
        <label for="1">Builder</label>
        <select class="form-control" name="builder" id="1">
            <option  value="FENDER">FENDER</option>
            <option  value="MARTIN">MARTIN</option>
            <option  value="GIBSON">GIBSON</option>
            <option  value="COLLINGS">COLLINGS</option>
            <option  value="RYAN">RYAN</option>
            <option  value="PRS">PRS</option>
        </select>
        <label for="2">Model</label>
        <select class="form-control" name="model1" id="2">
            <option value="CJ">CJ</option>
            <option value="SJ">SJ</option>
            <option value="Stratocastor">Stratocastor</option>
            <option value="OM-28">OM-28</option>
        </select>
        <label for="3">Type</label>
        <select class="form-control" name="type" id="3">
            <option value="ACOUSTIC">ACOUSTIC</option>
            <option value="ELECTRIC">ELECTRIC</option>
        </select>
        <label for="4">BackWood</label>
        <select class="form-control" name="backWood" id="4">
            <option value="INDIAN_ROSEWOOD">INDIAN_ROSEWOOD</option>
            <option value="BRAZILIAN_ROSEWOO">BRAZILIAN_ROSEWOOD</option>
            <option value="MAHOGANY">MAHOGANY</option>
            <option value="MAPLE">MAPLE</option>
            <option value="COCOBOLO">COCOBOLO</option>
            <option value="CEDAR">CEDAR</option>
            <option value="ADIRONDACK">ADIRONDACK</option>
            <option value="ALDER">ALDER</option>
            <option value="SITKA">SITKA</option>
        </select>
        <label for="5">TopWood</label>
        <select class="form-control" name="topWood" id="5">
            <option value="INDIAN_ROSEWOOD">INDIAN_ROSEWOOD</option>
            <option value="BRAZILIAN_ROSEWOO">BRAZILIAN_ROSEWOOD</option>
            <option value="MAHOGANY">MAHOGANY</option>
            <option value="MAPLE">MAPLE</option>
            <option value="COCOBOLO">COCOBOLO</option>
            <option value="CEDAR">CEDAR</option>
            <option value="ADIRONDACK">ADIRONDACK</option>
            <option value="ALDER">ALDER</option>
            <option value="SITKA">SITKA</option>
        </select>
        <label for="6"> NumStrings</label>
        <select class="form-control" name="numStrings" id="6">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
        </select>
    </div>
    <input type="submit" value="搜索">
</form>



<table class="table table-hover">
    <caption>吉他列表</caption>
    <thead>
    <tr>
        <th>Builder</th>
        <th>Model</th>
        <th>Type</th>
        <th>BackWood</th>
        <th>TopWood</th>
        <th>Price</th></tr>
    </thead>
    <tbody>

    <c:forEach items="${matchingGuitars}" var="guitar" >
        <tr>
            <td>${guitar.getSpec().getBuilder()}</td>
            <td>${guitar.getSpec().getModel()}</td>
            <td>${guitar.getSpec().getType()}</td>
            <td>${guitar.getSpec().getBackWood()}</td>
            <td>${guitar.getSpec().getTopWood()}</td>
            <td>${guitar.getPrice()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
