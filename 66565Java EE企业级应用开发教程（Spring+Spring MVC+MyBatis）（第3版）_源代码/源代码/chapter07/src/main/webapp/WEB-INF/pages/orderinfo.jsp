<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>订单信息</title></head>
<style>
    /* 使用CSS样式来设置表格的边框和宽度 */
    table {
        border-collapse: collapse; /* 合并边框 */
        width: 80%;
    }
    /* 设置表格中的单元格边框 */
    th, td {
        border: 1px solid black; /* 设置边框为1像素实线黑色 */
        padding: 8px; /* 设置单元格内边距 */
        text-align: center; /* 居中对齐文本 */
    }
</style>
<body>
您好：${ USER_SESSION.username }
<a href="${ pageContext.request.contextPath }/logout">退出</a>
<table >
    <tr>
        <td colspan="2">订单Id：D001</td>
    </tr>
    <tr  >
        <td>商品Id</td>
        <td>商品名称</td>
    </tr>
    <tr >
        <td>P001</td>
        <td>土豆</td>
    </tr>
    <tr>
        <td>P002</td>
        <td>西红柿</td>
    </tr>
</table>
</body>
</html>

