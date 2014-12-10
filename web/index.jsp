<%-- 
    Document   : index
    Created on : Dec 5, 2014, 1:07:45 PM
    Author     : GleasonK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RhetID - Rhetorical Identification</title>
        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="style.css" title="MainCSS" type="text/css" media="screen" charset="utf-8">
    </head>
    <body>
        <div id="bg_div"></div>
	<h1 id="title">RhetID</h1>
	<p id="tag_line">Rhetorical Analysis and Comparison to Classic Authors</p>
	<div id="center_box">
		<div class="center_blur"></div>
		<textarea id="enter_text" name="Text1" cols="40" rows="5" placeholder="Enter Text or Upload a txt file..."></textarea>
		<button id="upload_button">Upload</button>
		<div id="upload_dialog">
		<form name="upload-form" action="upload" method="post" enctype="multipart/form-data">
			<div id="file_upload_modal">
				<center><input type="file" name="file"/><br></center><br/>
			</div>
			<center><input type="submit" value="Analyze" id="analyze_button"/></center>
		</form>
            </div>
	</div>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="main.js"></script>
    </body>
</html>
