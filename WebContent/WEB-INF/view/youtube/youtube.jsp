<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>${title}</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<input id="query" type="text">
	<button id="search-button" onclick="search()">검색</button>
	<div id="search-container"></div>
	<script>
	var request=require('request');

	var optionParams={
		q:query.value,
		part:"snippet",
		key:"★자기key값★",
		maxResults:2
	 };
	//그냥 간단하게 확인하기 쉽게하려고 maxResults 2로 했음
	var url="https://www.googleapis.com/youtube/v3/search?";
	for(var option in optionParams){
		url+=option+"="+optionParams[option]+"&";
	}

	//url의마지막에 붙어있는 & 정리
	url=url.substr(0, url.length-1);

	request(url, function(err, res, body){
		console.log(body)
	});
	</script>
</body>
</html>
