function idDuplCheck(username){ // id 중복 체크
    if(blankSpaceCheck(username)){
        return false;
    }else{
        if(username.trim().length !== 0){
            return new Promise((resolve, reject) => {
                $.ajax({
                    url:"/auth/joinProc/idcheck",
                    type:"POST",
                    data : {username : username},
                    async : false,
                    success: function (count){
                        if(count > 0){
                            return resolve(false);
                        }else{
                            return resolve(true);
                        }
                    }
                })
            })
        }
    }
}

function joinProc(userInfo){
    return new Promise((resolve, reject) => {
        $.ajax({
            url: "/auth/joinProc",
            type: "POST",
            data: userInfo,
            success: function (response) {
                if (!response.error) {
                    return resolve(true)
                }else{
                    return resolve(false)
                }
            }
        })
    })
}

(function ($) {
    "use strict";

    let input = $('.validate-input input')

    $('.validate-form').on('submit', async function (event) {
        event.preventDefault();
        let check = true;
        const username = $("input[name = 'username']").val()
        const tel = $("input[name = 'tel']").val()    // TODO : 전화번호 입력 값 확인 (ex. 9자리 숫자)
        const password = $("input[name = 'password']").val()
        const passwordValidation = $("input[name = 'password-validation']").val()

        //비밀번호 확인
        if (password !== passwordValidation) {
            swalAlert({icon: "error", html: "비밀번호가 일치 하지 않습니다."})
            check = false;
        }

        for(let i = 0; i < input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        /*=================================================================
        [Validate Id]*/
        const idDuplicate = await idDuplCheck(username);
        if(idDuplicate ===false){
            swalAlert({icon:"error",html:"해당 아이디는 사용할 수 없습니다."})
        }

        if (check === true && idDuplicate === true) {
            const termCheck = $('#terms')[0].checked
            if (!termCheck) {
                swalAlert({icon: "error", html: "개인 정보 수집 및 이용에 대한 안내에 <br> 모두 동의해주세요."})
            } else {
                const joinResult = await joinProc({username : username, password : password, tel : tel})

                if (joinResult){
                    swalAlert({
                        icon: "success",
                        html: "회원가입에 성공하였습니다.",
                        preConfirm: () => {window.location.href = "/auth/loginForm" }
                    })
                }else{
                    swalAlert({
                        icon: "error",
                        html: "회원가입에 실패하였습니다.",
                    })
                }
            }
        }
    });

    $('.validate-form .input-wrap__input').each(function () {
        $(this).focus(function () { hideValidate(this); });
    });

    function validate(input) {
        if ($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if ($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        } else {
            if ($(input).val().trim() == '') {
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }

    /*==================================================================
    [ Show pass ]*/
    var showPass = 0;
    $('.btn-show-pass').on('click', function () {
        if (showPass == 0) {
            $(this).next('input').attr('type', 'text');
            $(this).find('i').removeClass('fa-eye');
            $(this).find('i').addClass('fa-eye-slash');
            showPass = 1;
        } else {
            $(this).next('input').attr('type', 'password');
            $(this).find('i').removeClass('fa-eye-slash');
            $(this).find('i').addClass('fa-eye');
            showPass = 0;
        }
    });
})(jQuery)