(function ($) {
    "use strict";

    $('.reply_write_form').on('submit', async function (event) {
        event.preventDefault();
        let check = true;
        let userId = $("input[name='reply_user_id']").val()
        let postId = $("input[name='reply_post_id']").val()
        let replyContent = $("textarea[name='reply_content']").val()

        if (blankCheck(replyContent)) {
            swalAlert({icon: "error", html: "댓글을 작성해주세요!"})
            check = false;
        }
        /*,user_id:userId,post_id:postId*/
        const data = {userId: userId, postId: postId, content: replyContent};

        if (check === true) {
            $.ajax({
                url: "/api/community/post/reply/save",
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
                                window.location.href = "/community/post/" + postId
                            }
                        })
                    } else {
                        console.log("error", response);
                    }
                }
            })
        }
    })

    $('.reply-btn').on('click', function (e) {
        e.preventDefault();
        let postId = $(".blog_details input[name='post_id']").val();
        let replyId = $(e.target).siblings("input[name='delete_reply_id']").val();

        $.ajax({
            url: "/api/community/post/reply/delete/" + replyId,
            type: "DELETE",
            data: {replyId: replyId},
            success: function (response) {
                if (!response.error) {
                    swalAlert({
                        icon: "success",
                        html: "댓글이 삭제되었습니다",
                        preConfirm: () => {
                            window.location.href = "/community/post/" + postId
                        }
                    })
                } else {
                    console.log("error", response);
                }
            }
        })
    })
})(jQuery)
