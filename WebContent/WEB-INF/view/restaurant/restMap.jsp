<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="sectionContainerCenter">
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4d1e96707b7bb1207994c7b55faad5e2"></script>

	<div id="map" style="width:100%; height:100%;"></div>

	<script type="text/javascript">
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng(35.8700317, 128.6005225), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</div>
