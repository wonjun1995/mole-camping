$(document).on("click", "i.del" , function() {
// 	to remove card
    $(this).parent().remove();
// to clear image
    // $(this).parent().find('.imagePreview').css("background-image","url('')");
});

$(".imagePreview").on("click", (event) => {
    $(event.target).closest(".imgUp").find("input[type = 'file']").click();
})

$(".uploadImage").on("change",function()
{
    var uploadFile = $(this);
    var files = !!this.files ? this.files : [];
    if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support

    if (/^image/.test( files[0].type)){ // only image file
        var reader = new FileReader(); // instance of the FileReader
        reader.readAsDataURL(files[0]); // read the local file

        reader.onloadend = function(){ // set image data as background of div
            //alert(uploadFile.closest(".upimage").find('.imagePreview').length);
            let imagePreViewElem = uploadFile.closest(".imgUp").find('.imagePreview')
            imagePreViewElem.find(".icon-plus").remove()
            imagePreViewElem.css("background-image", "url("+this.result+")");
        }
    }
});
