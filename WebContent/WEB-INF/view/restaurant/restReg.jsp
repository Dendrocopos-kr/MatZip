<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sectionContainerCenter">
	<div>
		<form id="frm" action="/restaurant/restRegProc" method="post"
			onsubmit="return chkFrm()">
			<div>
				<input type="text" name="nm" placeholder="가게명 ">
			</div>
			<div>
				<input type="text" name="addr" placeholder="주소 "
					onkeyup="changeAddr()">
				<button type="button" onclick="getLatLng()">좌표 가져오기</button>
			</div>
			<input type="hidden" name="lat" value="0"> <input
				type="hidden" name="lng" value="0">
			<div>
				카테고리 : <select name="cd_category">
					<option value="0">-- 선택 --</option>
					<c:forEach items="${categoryList}" var="item">
						<option value="${item.cd}">${item.val}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<button type="button" onclick="ajaxInsert()">ajax등록</button>
				<input type="submit" value="등록">
			</div>
		</form>
	</div>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4d1e96707b7bb1207994c7b55faad5e2&libraries=services"></script>

	<script type="text/javascript">
	function ajaxInsert(){
		axios.get('/restaurant/insertChk',{
			params:{
				nm : frm.nm.value ,
				addr : frm.addr.value ,
				lat : frm.lat.value ,
				lng : frm.lng.value ,
				cd_category : frm.cd_category.value
				}
		}).then(function(res){
			console.log(res)
			if(res.data.result == 1){
				alert('등록에 성공했습니다.')
				location.href = '/restaurant/restMap'
			}else if (res.data.result == 0){
				alert('등록에 실패했습니다. 다시 시도 해주세요.')
			}
		});
	}
        function chkFrm() {
            if (frm.nm.value.length == 0) {
                alert('가게명을 입력해주세요')
                frm.nm.focus()
                return false
            } else if (frm.addr.value.length < 9) {
                alert('주소를 확인해주세요')
                frm.addr.focus()
                return false
            } else if (frm.lat.value == '0' || frm.lng.value == '0') {
                alert('좌표값을 가져와주세요')
                return false
            } else if (frm.cd_category.value == '0') {
                alert('카테고리를 선택해 주세요')
                frm.cd_category.focus()
                return false
            }
            return true
        }
        function changeAddr() {
            frm.lat.value = '0'
            frm.lng.value = '0'
        }

        const geocoder = new kakao.maps.services.Geocoder()

        function getLatLng() {
            event.preventDefault()
            const addrStr = frm.addr.value

            if (addrStr.length < 9) {
                alert('주소를 확인해주세요')
                frm.addr.focus()
                return
            }

            geocoder.addressSearch(addrStr, function (result, status) {
                if (status === kakao.maps.services.Status.OK) {
                    if (result.length > 0) {
                        frm.lat.value = result[0].y
                        frm.lng.value = result[0].x
                        console.log(result[0])
                    }
                }
            })
        }
    </script>
</div>