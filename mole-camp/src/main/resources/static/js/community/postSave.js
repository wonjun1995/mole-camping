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
            $('.summernote').data("url",data.url)
            $(editor).summernote('insertImage', data.url);
        }
    });
}

(function ($){
    "use strict";

    $('.save_form').on('submit',async function (event){
        event.preventDefault();
        let check=true;

        let categoryType = $("option:selected").val()
        let title = $("input[name = 'title']").val()
        let content = $("textarea[name = 'content']").val()
        let mainImage=$('.summernote').data("url")
        console.log("post Save 활성화");
        console.log(categoryType);
        console.log(title);
        console.log(content);
        console.log(mainImage);

        //title,categoryType,content 공백 체크
        if(blankCheck(categoryType) || blankCheck(title) || blankCheck(content)){
            console.log("Empty Space exists")
            check=false;
            swalAlert({icon:"error",html:"폼을 모두 작성해주세요!"})
        }

        //게시글 작성
        if(check === true){
            console.log("게시글 작성 완료")
            $.ajax({
                url:"/api/community/post",
                type:"POST",
                data:{title: title, content: content, category: categoryType,img_path:mainImage},
                success: function (response) {
                    if (!response.error) {
                        console.log(response);
                        swalAlert({
                            icon: "success",
                            html: "게시글이 등록되었습니다",
                            preConfirm: () => {
                                window.location.href = "/community/post"
                            }
                        })
                    }else{
                        console.log("error",response);
                    }
                }
            })
        }


    })

})(jQuery)