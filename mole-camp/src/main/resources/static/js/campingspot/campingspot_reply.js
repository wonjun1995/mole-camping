(function ($) {
    "use strict";

    $('.reply_write_form').on('submit', async function (event) {
        event.preventDefault();
        let check = true;
        let userId = $("input[name='reply_user_id']").val()
        let spotId = $(".blog_details_noshadow input[name='spot_id']").val();
        let replyContent = $("textarea[name='reply_content']").val()

        if (blankCheck(replyContent)) {
            swalAlert({icon: "error", html: "댓글을 작성해주세요!"})
            check = false;
        }
        /*,user_id:userId,post_id:postId*/
        const data = {writer_id: userId, camping_spot_id: spotId, content: replyContent};
        console.log(data);

        if (check === true) {
            $.ajax({
                url: "/api/campingspot/"+spotId+"/reply/save",
                type: "POST",
                data: JSON.stringify(data),
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                success: function (response) {
                    if (!response.error) {
                        swalAlert({
                            icon: "success",
                            html: "댓글이 등록되었습니다",
                            preConfirm: () => {
                                window.location.href = "/campingspot/" + spotId
                            }
                        })
                    } else {
                        console.log("error", response);
                    }
                }
            })
        }
    })

    $('.delete-reply').on('click', function (e) {
        e.preventDefault();
        let spotId = $(".blog_details_noshadow input[name='spot_id']").val();
        let replyId = $(e.target).siblings("input[name='delete_reply_id']").val();

        $.ajax({
            url: "/api/campingspot/"+spotId+"/reply/delete/" + replyId,
            type: "DELETE",
            data: {replyId: replyId},
            success: function (response) {
                if (!response.error) {
                    swalAlert({
                        icon: "success",
                        html: "댓글이 삭제되었습니다",
                        preConfirm: () => {
                            window.location.href = "/campingspot/" + spotId
                        }
                    })
                } else {
                    console.log("error", response);
                }
            }
        })
    })
})(jQuery)
