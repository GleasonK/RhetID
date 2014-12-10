<%-- 
    Document   : results.jsp
    Created on : Dec 5, 2014, 7:02:00 PM
    Author     : GleasonK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="com.kgzr.rhetid.authors.Author" %>
<%@ page import="com.kgzr.rhetid.elements.adt.RhetAnalysis" %>
<%@ page import="com.kgzr.rhetid.authors.Authors" %>
<!DOCTYPE html>
<html>
<head>
    <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="style.css" title="MainCSS" type="text/css" media="screen" charset="utf-8">
</head>
<body>
<!-- 	<div id="bg_div"></div> -->
<div id="page-content">
    <h1 id="title">RhetID</h1>
    <p id="tag_line">Rhetorical Analysis and Comparison to Classic Authors</p>
    <div id="graph-box">
        <%
            Map<String,Double> authScores = (Map<String,Double>) request.getAttribute("authScores");
            List<String> authors= new ArrayList<String>();
            List<Double> scores = new ArrayList<Double>();
            Map.Entry<String,Double> authSelect = new AbstractMap.SimpleEntry<String, Double>("",0d);
            double max = 0d;
            for (Map.Entry<String,Double> entry : authScores.entrySet()){
                authors.add("\"" + entry.getKey() + "\"");
                scores.add(entry.getValue());
                if (entry.getValue() > max) {
                    authSelect =  new AbstractMap.SimpleEntry<String, Double>(entry);
                    max=entry.getValue();
                }
            }
        %>
        <canvas id="myChart" width="600" height="400"></canvas>
    </div>
    <div id="author-info">
        <h1 id="auth-title">You got: <%=authSelect.getKey()%></h1>
        <%
            Author userAnalysis = (Author) request.getAttribute("userAnalysis");
            RhetAnalysis rhet = userAnalysis.getRhetAnalysis();
            Double[] authVec = Authors.authorList.get(authSelect.getKey());
        %>
            <table id="auth-compare">
            <tr><th>Category</th><th>User Analysis</th><th><%=authSelect.getKey()%> Analysis</th></tr>
            <tr><td>Noun/Sentence</td><td><%=rhet.getNnPerSent()%></td>         <td><%=authVec[0]%></td></tr>
            <tr><td>Proper Noun/Sentence</td><td><%=rhet.getPnPerSent()%></td>  <td><%=authVec[1]%></td></tr>
            <tr><td>Pronoun/Sentence</td>  <td><%=rhet.getPpPerSent()%></td>    <td><%=authVec[2]%></td></tr>
            <tr><td>Verb/Sentence</td>     <td><%=rhet.getVbPerSent()%></td>    <td><%=authVec[3]%></td></tr>
            <tr><td>Adjective/Sentence</td><td><%=rhet.getAdjPerSent()%></td>   <td><%=authVec[4]%></td></tr>
            <tr><td>Adverb/Sentence</td>   <td><%=rhet.getAdvPerSent()%></td>   <td><%=authVec[5]%></td></tr>
            <tr><td>Words/Sentence</td><td><%=rhet.getAvgSentLength()%></td>    <td><%=authVec[6]%></td></tr>
            <tr><td>Sentence/Paragraph</td><td><%=rhet.getAvgParaLength()%></td><td><%=authVec[7]%></td></tr>
        </table>
        <%--<%= authScores.toString() %>--%>
        <%--<%= authors.toString() %>--%>
        <%--<%= scores.toString() %>--%>
    </div>
</div>
    </body>
    <script src="Chart.js"></script>
    <script type="text/javascript">
        var data = {
            labels: <%=authors.toString()%>,
            datasets: [
                {
                    label: "Rhetorical Analysis Results",
                    fillColor:"rgba(220,220,220,0.3)",
                    strokeColor:"rgba(220,220,220,1)",
                    pointColor:"rgba(220,220,220,1)",
                    pointStrokeColor:"#fff",
                    pointHighlightFill:"#fff",
                    pointHighlightStroke:"rgba(220,220,220,1)",
                    data:<%=scores.toString()%>
                }
            ]
        }
        var options = {
            showScale:true,
            scaleShowLabels:false,
            scaleShowGridLines:false
        }
        var ctx = document.getElementById("myChart").getContext("2d");
        var newChart = new Chart(ctx).Line(data,options)
    </script>
</html>
