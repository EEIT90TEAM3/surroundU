<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form ENCTYPE="multipart/form-data" method="POST" action="testimg"">
<label class="fontSize" >照片：</label>
      <Input Type="file" size="40" class="fieldWidth" style="width: 480px;"  name="photo"><BR>
      <br/>
      <div id="btnArea" align="center">
         <input type="submit" name="submit" id="submit" value="ok"/>
         <input type="reset" name="cancel" id="cancel" value="重填">
      </div>
      </form>
</body>
</html>