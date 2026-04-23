<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传和文件下载</title>
    <script src="${ pageContext.request.contextPath }/js/jquery-3.6.0.js" type="text/javascript"></script>
</head>
<body>
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
        width: 300px;
    }
</style>
<table>
    <tr>
        <td >文件上传${msg}</td>
        <td >下载列表</td>
    </tr>
    <tr>
        <td height="100">
            <form action="${pageContext.request.contextPath}/fileUpLoad"
                  method="post" enctype="multipart/form-data">
                <input type="file" name="file" multiple="multiple"><br/>
                <input type="reset" value="清空"/>
                <input type="submit" value="提交"/>
            </form>
        </td>
        <td id="files"></td>
    </tr>
</table>
</body>
<script>
    $(document).ready(function () {
        var url = "${pageContext.request.contextPath }/getFilesName";
        $.get(url, function (files) {
            // 解析 JSON 数据
            var parsedData = JSON.parse(files);
            // 获取 names 数组
            var namesArray = parsedData.names;
            for (var i = 0; i < namesArray.length; i++) {
                $("#files").append("<li>" +
                    "<a href=${pageContext.request.contextPath }" + "" +
                    "\\" + "downLoad?filename=" + namesArray[i] + ">" +
                    namesArray[i] + "</a></li>");
            }
        })
    })
</script>
</html>

