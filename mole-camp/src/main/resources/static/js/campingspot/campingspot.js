function uploadSummernoteImageFile(file, editor) {
    data = new FormData();
    data.append("file", file);
    $.ajax({
        data: data,
        type: "POST",
        url: "/community/post/uploadImage",
        contentType: false,
        processData: false,
        success: function (data) {
            //항상 업로드된 파일의 url이 있어야 한다.
            console.log(data);
            $('.summernote').data("url", data.url)
            $(editor).summernote('insertImage', data.url);
        }
    });
}

(function ($) {

    "use strict";
    console.log("캠핑스팟 JS 활성화")

    $('.spot_save').on('submit', async function (event) {
        event.preventDefault();
        let check = true;

        let title = $("input[name = 'title']").val()
        let postcode = $("input[name = 'postcode']").val()
        let address = $("input[name = 'address']").val()
        let detail_address = $("input[name = 'detail_address']").val()
        let latitude_y = $("input[name = 'latitude_y']").val()
        let longtitude_x = $("input[name = 'longtitude_x']").val()
        let region_1depth_name = $("input[name = 'region_1depth_name']").val()
        let region_2depth_name = $("input[name = 'region_2depth_name']").val()
        let description = $("textarea[name = 'description']").val()
        //TODO:사용 여부 확인 필요
        let extra_address = $("input[name = 'extra_address']").val()
        let mainImage = $('.summernote').data("url")

        //title,description,address 공백 체크
        if (blankCheck(address) || blankCheck(title) || blankCheck(description)) {
            console.log("Empty Space exists")
            check = false;
            swalAlert({icon: "error", html: "폼을 모두 작성해주세요!"})
        }
        let data = {
            title: title, postcode: postcode, address: address,
            detail_address: detail_address, latitude_y: latitude_y, longtitude_x: longtitude_x,
            region_1depth_name: region_1depth_name, region_2depth_name: region_2depth_name,
            description: description
        };

        console.log(data);
        //게시글 작성
        if (check === true) {
            console.log("게시글 작성 완료")
            $.ajax({
                url: "/api/campingspot/post",
                type: "POST",
                data: data,
                success: function (response) {
                    if (!response.error) {
                        console.log(response);
                        swalAlert({
                            icon: "success",
                            html: "게시글이 등록되었습니다",
                            preConfirm: () => {
                                window.location.href = "/campingspot"
                            }
                        })
                    } else {
                        console.log("error", response);
                    }
                }
            })
        }


    })

})(jQuery)