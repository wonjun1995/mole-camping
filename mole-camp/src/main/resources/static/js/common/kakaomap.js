function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementsByName("extra_address")[0].value = extraAddr;

            } else {
                document.getElementsByName("extra_address")[0].value = '';
            }

            //위도, 경도를 뽑아내기 위하여 카카오 주소 검색 api에서 주소 추출 후 재검색
            $.ajax({
                url:'https://dapi.kakao.com/v2/local/search/address.json?query='+encodeURIComponent(data.address),
                type:'GET',
                headers: {'Authorization' : 'KakaoAK 62e24697f7bc91876ca05e412964da74'},
                success:function(data){
                    document.getElementsByName("latitude_y")[0].value = data.documents[0].road_address.y;
                    document.getElementsByName("longtitude_x")[0].value = data.documents[0].road_address.x;
                    document.getElementsByName("region_1depth_name")[0].value = data.documents[0].road_address.region_1depth_name;
                    document.getElementsByName("region_2depth_name")[0].value = data.documents[0].road_address.region_2depth_name;
                },
                error : function(e){
                    console.log(e);
                }
            })

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementsByName('postcode')[0].value = data.zonecode;
            document.getElementsByName("address")[0].value = addr;

        }
    }).open();
}