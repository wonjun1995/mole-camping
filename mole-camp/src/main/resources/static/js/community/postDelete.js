(function ($) {
    "use strict";


    $('.btn-delete').on('click', async function (event) {
        let id = $(".blog_details input[name='post_id']").val()
        console.log(id)

        console.log("게시글 삭제 완료")
        $.ajax({
            url: "/api/community/delete/" + id,
            type: "DELETE",
            success: function (response) {
                if (!response.error) {
                    console.log(response);
                    swalAlert({
                        icon: "success",
                        html: "게시글이 삭제되었습니다",
                        preConfirm: () => {
                            window.location.href = "/community/post"
                        }
                    })
                } else {
                    console.log("error", response);
                }
            }
        })


    })

})(jQuery)
