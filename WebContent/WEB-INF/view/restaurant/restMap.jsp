<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="sectionContainerCenter">
	<div id="mapContainer" style="width: 100%; height: 100%;"></div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4d1e96707b7bb1207994c7b55faad5e2"></script>
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script>		
		const options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(35.8641294,128.5942331), //지도의 중심좌표.
			level: 5 //지도의 레벨(확대, 축소 정도)
		};
		const map = new kakao.maps.Map(mapContainer, options);
		
		function getRestaurantList(){
			axios.get('/restaurant/getList').then(function(res){
				console.log(res)
				res.data.forEach(function(item){
					let markerPosition  = new kakao.maps.LatLng(item.lat, item.lng); 

					// 마커를 생성합니다
					let marker = new kakao.maps.Marker({
					    position: markerPosition
					});

					// 마커가 지도 위에 표시되도록 설정합니다
					marker.setMap(map);
				})
			});
		}
		getRestaurantList();
	</script>
</div>