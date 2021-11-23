(function ($) {
    "use strict";


    $('.btn-delete').on('click', async function (event) {
        let id = $(".blog_details input[name='post_id']").val()

        $.ajax({
            url: "/api/community/delete/" + id,
            type: "DELETE",
            success: function (response) {
                if (!response.error) {
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
