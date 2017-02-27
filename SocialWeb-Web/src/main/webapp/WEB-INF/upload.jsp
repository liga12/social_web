<%--
  Created by IntelliJ IDEA.
  User: liga
  Date: 20.02.17
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload files</title>
</head>
<body>

<div style="padding:5px; color:red;font-style:italic;">
    ${errorMessage}
</div>

<h2>Upload Files</h2>

<form method="post" action="${pageContext.request.contextPath}/uploadFile"
      enctype="multipart/form-data">

    Select file to upload:
    <br />
    <input type="file" name="file" multiple accept="image/*,image/jpeg" />
    <br />
    <input type="file" name="file" />
    <br />
    <br />
    <input type="file" name="file"  />
    <br />
    <input type="file" name="file" />
    <br />
    <br />
    <input type="file" name="file"  />
    <br />
    <input type="file" name="file" />
    <br />
    <input type="file" name="file"  />
    <br />
    <input type="file" name="file" />
    <br />
    <br />
    <input type="file" name="file"  />
    <br />
    <input type="file" name="file" />
    <br />
    <br />
    Description:
    <br />
    <input type="text" name="description" size="100" />
    <br />
    <br />
    <input type="submit" value="Upload" />
</form>

</body>
</html>