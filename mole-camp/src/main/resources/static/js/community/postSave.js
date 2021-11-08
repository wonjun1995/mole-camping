(function ($){
    "use strict";

    $('.save_form').on('submit',async function (event){
        event.preventDefault();
        let categoryType = $("option[name = 'categoryType']").val()
        let title = $("input[name = 'title']").val()
        let content = $("textarea[name = 'content']").val()
        console.log("post Save 활성화");
        console.log(categoryType);
        console.log(title);
        console.log(content);
    })

})(jQuery)
