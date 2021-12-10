var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.264842, 126.96033), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
var mapTypeControl = new kakao.maps.MapTypeControl();
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

// HTML5의 geolocation으로 사용할 수 있는지 확인합니다
if (navigator.geolocation) {
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function (position) {
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="padding:5px;">현재위치가 여기요?!</div>'; // 인포윈도우에 표시될 내용입니다
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
    });
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    var locPosition = new kakao.maps.LatLng(37.264842, 126.96033),
        message = 'geolocation을 사용할수 없어요..'
    displayMarker(locPosition, message);
}

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: locPosition
    });
    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;
    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content: iwContent,
        removable: iwRemoveable
    });
    // 인포윈도우를 마커위에 표시합니다
    infowindow.open(map, marker);
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);
}

var campsite_positions = [];
let campsite = $('.campsiteinfo');

for (var i = 0; i < campsite.length; i++) {
    campsite_positions.push({
        'facltNm': $("input[name='facltNm']")[i].value,
        'firstImageUrl': $("input[name='firstImageUrl']")[i].value,
        'addr1': $("input[name='addr1']")[i].value,
        'homepage': $("input[name='homepage']")[i].value,
        'mapY': $("input[name='mapY']")[i].value,
        'mapX': $("input[name='mapX']")[i].value
    });
}

var campsite_imageSrc = '/images/icon/camping_tent.png', // 마커이미지의 주소입니다
    imageSize = new kakao.maps.Size(45, 50), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.


//캠핑장 마커 표시
for (var i = 0; i < campsite_positions.length; i++) {
    var markerImage = new kakao.maps.MarkerImage(campsite_imageSrc, imageSize, imageOption),
        markerPosition = new kakao.maps.LatLng(campsite_positions[i].mapY, campsite_positions[i].mapX); // 마커가 표시될 위치입니다
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: markerPosition,
        image: markerImage,
        clickable: true
    });
    // 커스텀 오버레이에 표시할 컨텐츠 입니다
    var i_content = '<div class="k_wrap">' +
        '    <div class="info">' +
        '        <div class="title">' +
        campsite_positions[i].facltNm +
        '            <button type="button" class="close" onclick="closeOverlay()" title="닫기"></button>' +
        '        </div>' +
        '        <div class="body">' +
        '            <div class="img">' +
        '                <img src="' + campsite_positions[i].firstImageUrl + '" width="73" height="70">' +
        '           </div>' +
        '            <div class="desc">' +
        '                <div class="ellipsis">' + campsite_positions[i].addr1 + '</div>' +
        '                <div><a href="' + campsite_positions[i].homepage + '" target="_blank" class="link">홈페이지</a></div>' +
        '            </div>' +
        '        </div>' +
        '    </div>' +
        '</div>';

    var iwRemoveable = true;
    // 인포윈도우를 생성합니다

    var infowindow = new kakao.maps.InfoWindow({
        content: i_content,
        removable: iwRemoveable
    });
    // 마커에 이벤트를 등록하는 함수 만들고 즉시 호출하여 클로저를 만듭니다
    // 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    (function (marker, infowindow) {
        // 마커에 mouseover 이벤트를 등록하고 마우스 오버 시 인포윈도우를 표시합니다
        kakao.maps.event.addListener(marker, 'click', function () {
            infowindow.open(map, marker);
        });
    })(marker, infowindow);
}

//캠핑스팟 마커 표시

var spot_imageSrc = '/images/icon/location.png',
    imageSize = new kakao.maps.Size(45, 50), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

var campingspot_positions = [];
let campingspot = $('.campingspotInfo');

for (var i = 0; i < campingspot.length; i++) {
    campingspot_positions.push({
        'title': $("input[name='title']")[i].value,
        'address': $("input[name='address']")[i].value,
        'latitude_y': $("input[name='latitude_y']")[i].value,
        'longtitude_x': $("input[name='longtitude_x']")[i].value,
    });
}

for (var i = 0; i < campingspot_positions.length; i++) {
    console.log(campingspot_positions[i]);
    var spot_markerImage = new kakao.maps.MarkerImage(spot_imageSrc, imageSize, imageOption),
        spot_markerPosition = new kakao.maps.LatLng(campingspot_positions[i].latitude_y, campingspot_positions[i].longtitude_x); // 마커가 표시될 위치입니다
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: spot_markerPosition,
        image: spot_markerImage,
        clickable: true
    });
    // 커스텀 오버레이에 표시할 컨텐츠 입니다
    var spot_content = '<div class="k_wrap">' +
        '    <div class="info">' +
        '        <div class="title">' +
        campingspot_positions[i].title +
        '            <button type="button" class="close" onclick="closeOverlay()" title="닫기"></button>' +
        '        </div>' +
        '        <div class="body">' +
/*        '            <div class="img">' +
        '                <img src="' + campingspot_positions[i].firstImageUrl + '" width="73" height="70">' +
        '           </div>' +*/
        '            <div class="desc">' +
        '                <div class="ellipsis">' + campingspot_positions[i].address + '</div>' +
//        '                <div><a href="' + campingspot_positions[i].homepage + '" target="_blank" class="link">홈페이지</a></div>' +
        '            </div>' +
        '        </div>' +
        '    </div>' +
        '</div>';

    var iwRemoveable = true;
    // 인포윈도우를 생성합니다

    var infowindow = new kakao.maps.InfoWindow({
        content: spot_content,
        removable: iwRemoveable
    });
    // 마커에 이벤트를 등록하는 함수 만들고 즉시 호출하여 클로저를 만듭니다
    // 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    (function (marker, infowindow) {
        // 마커에 mouseover 이벤트를 등록하고 마우스 오버 시 인포윈도우를 표시합니다
        kakao.maps.event.addListener(marker, 'click', function () {
            infowindow.open(map, marker);
        });
    })(marker, infowindow);
}

function closeOverlay() {
    infowindow.close();
}


/*
// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
// 마커 위에 커스텀오버레이를 표시합니다
// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
var overlay = new kakao.maps.CustomOverlay({
    content: iwcontent,
    map: map,
    position: marker.getPosition()
});

kakao.maps.event.addListener(marker, 'click', function () {
    overlay.setMap(map);
});
*/


