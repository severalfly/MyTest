<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>考试试题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  ${subject.subjectID }
    <table border="1">
        <tr>
            <td>试题编号</td>
            <td>${subject.subjectID }</td>
        </tr>
        <tr>
            <td>试题题目</td>
            <td>${subject.subjectTitle }</td>
        </tr>
        <tr>
            <td>选项A</td>
            <td>${subject.subjectOptionA }</td>
        </tr>
        <tr>
            <td>选项B</td>
            <td>${subject.subjectOptionB }</td>
        </tr>
        <tr>
            <td>选项C</td>
            <td>${subject.subjectOptionC }</td>
        </tr>
        <tr>
            <td>选项D</td>
            <td>${subject.subjectOptionD }</td>
        </tr>
        <tr>
            <td>答案</td>
            <td>${subject.subjectAnswer }</td>
        </tr>
        <tr>
            <td>答案解析</td>
            <td>${subject.subjectParse }</td>
        </tr>
    </table>
  </body>
<script type="text/javascript">
    var ksTime;
    ksTime = 1;
    if(readCookie("ss") == '')
    {
        setCookie("ss", new Date(), ksTime / 60);
    }
    function sT () {
        var tti = new Date();
        var lt = parseInt(tti - new Date(readCookie("ss"))/1000);
        if((ksTime * 60 - lt) <0) // 考试时间到
        {
            setCookie("ss", new Date(), 0);
            alert("考试时间到，即将提交");
            document.forms[0].submit();
        }
        else
        {
            lm = Math.floor(lt/60);
            ls = lt % 60; // 已过秒数
            allY = ksTime * 60 -lt;
            ym = Math.floor(allY / 60);
            ys = allY % 60;
            document.getElementById("tTime").innerHTML = "考试已经开始了" + lm + "分" + ls + "秒" + ",剩余" + ym + "分" + ys + "秒";
            var ttt = setTimeout("sT()", 1000);
        }
    }

    function readCookie (name) {
        var cookieValue = "";
        var search = name + "=";
        if(document.cookie.length > 0)
        {
            offset = document.cookie.indexOf(search);
            if(offset < 0)
            {
                offset += search.length;
            }
            end = document.cookie.indexOf(";", offset);
            if(end == -1)
            {
                end = document.cookie.length;
            }
            cookieValue = document.cookie.substring(offset, end);
        }
        return cookieValue;
    }

    function setCookie (name ,value, hours) {
        var expire = "";
        if(hours != null)
        {
            expire = new Date((new Date()).getTime() + hours * 3600000 );
            expire = '';
            expires = '' + expire;
        }
        document.cookie = name + "=" +value +expire;
    }
</script>
</html>