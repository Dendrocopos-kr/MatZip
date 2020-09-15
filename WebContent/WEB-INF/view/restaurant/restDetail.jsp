<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<div class="recMenuContainer">
	<c:if test="${ recommendMenuList != null }">
		<c:forEach items="${recommendMenuList}" var="item">
			<div class="recMenuItem" id="recMenuItem_${item.seq}">
				<div class="pic">
					<c:if test="${item.menu_pic == null }">
						<img src="/res/img/restaurant/default_menu.jfif">
					</c:if>
					<c:if test="${item.menu_pic != null }">
						<img src="/res/img/restaurant/${item.i_rest}/${item.menu_pic}">
					</c:if>
					<div class="info">
						<div class="nm">${item.menu_nm}</div>
						<div class="price">
							<fmt:formatNumber type="currency" value="${item.menu_price}"/>
						</div>
					</div>
				</div>
				<c:if
					test="${loginUser.i_user == data.i_user && item.menu_pic != null}">
					<div class="delIconContainer"
						onclick="delRecMenu(${item.i_rest},${item.seq})">
						<span class="material-icons"> clear </span>
					</div>
				</c:if>
			</div>
		</c:forEach>
	</c:if>
</div>

<div id="sectionContainerCenter">
	<div>
		<c:if test="${loginUser.i_user == data.i_user}">
			<div>
				<button onclick="isDel()">삭제</button>

				<form id="recFrm" action="/restaurant/addRecMenusProc"
					enctype="multipart/form-data" method="post">
					<div>
						<button type="button" onclick="addRecMenu()">메뉴 추가</button>
					</div>
					<input type="hidden" name="i_rest" value="${data.i_rest}">
					<div id="recItem"></div>
					<div>
						<input type="submit" value="등록">
					</div>
				</form>
			</div>
		</c:if>
		<div class="restaurant-detail">
			<div id="detail-header">
				<div class="restaurant_title_wrap">
					<span class="title">
						<h1 class="restaurant_name">${data.nm}</h1>
					</span>
				</div>
				<div class="status branch_none">
					<span class="cnt hit">${data.cntHits}</span> <span
						class="cnt favorite">${data.cntFavorite}</span>
				</div>
			</div>
			<div>
				<table>
					<caption>레스토랑 상세 정보</caption>
					<tbody>
						<tr>
							<th>주소</th>
							<td>${data.addr}</td>
						</tr>
						<tr>
							<th>카테고리</th>
							<td>${data.cd_category_nm}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script>
		var idx = 0;
		function addRecMenu() {
			var div = document.createElement('div')

			var inputNm = document.createElement('input')
			inputNm.setAttribute('type', 'text')
			inputNm.setAttribute('name', 'menu_nm')
			var inputPrice = document.createElement('input')
			inputPrice.setAttribute('type', 'number')
			inputPrice.setAttribute('name', 'menu_price')
			var inputPic = document.createElement('input')
			inputPic.setAttribute('type', 'file')
			inputPic.setAttribute('name', 'menu_pic_' + idx++)

			div.append('메뉴: ')
			div.append(inputNm)
			div.append(' 가격: ')
			div.append(inputPrice)
			div.append(' 사진: ')
			div.append(inputPic)

			recItem.append(div)
		}
		addRecMenu()

		function isDel() {
			if (confirm('삭제 하시겠습니까?')) {
				location.href = '/restaurant/restDel?i_rest=${data.i_rest}'
			}
		}
		
		function delRecMenu(i_rest,seq){
			axios.get('/restaurant/ajaxDelRecMenu',{
				params:{
					i_rest,seq
				}
			}).then(function(res){
				if(res.data.result == 1){
					const ele = document.querySelector('#recMenuItem_'+seq)
					ele.remove()
				}
			})			
		}
	</script>
</div>




