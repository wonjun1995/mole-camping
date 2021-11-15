const facilities = ['수세식 화장실', "놀이방", "매점", "샤워실", "수영장", "개수대"]
const operatings = ['오토캠핑', "글램핑", "카라반", "펜션", "방가로"];

const swalBasicOption = {
    heightAuto : false,  // true이면 body의 height가 auto가 되어서 페이지 구조가 변함
    allowOutsideClick : false,
    confirmButtonText : "확인",
}

function swalAlert(option) {
    Object.assign(option, swalBasicOption); // 인자로 전달받은 option과 기본 옵션을 합침

    Swal.fire(option)
}

function blankSpaceCheck(input){
    if(typeof input === 'undefined' || input === null || input ===" " || input.search(/\s/) != -1){
        return true;
    }else{
        return false;
    }
}
function blankCheck(input){
    if(typeof input === 'undefined' || input === null || input ===" " || input === ""){
        return true;
    }else{
        return false;
    }
}

function swalConfirm(option) {
    const confirmBasicOption = {
        showCancelButton: true,
        cancelButtonText: "취소",
    }

    Object.assign(option, confirmBasicOption, swalBasicOption);   // 인자로 전달받은 option, 기본 option, confirm alert의 기본 옵션을 합침

    Swal.fire(option)
}

function addCheckbox(elem, checkboxList){
    for(let checkbox of checkboxList) {
        let $checkBoxElem = $(`<label class = "checkbox">
                                <input type='checkbox' data-label = '${checkbox}'><span class = 'icon'></span>${checkbox}
                               </label>`)
        elem.append($checkBoxElem)
    }
}

function basename (filePath){
    return filePath.split("/").slice(-1)[0]
}
function addCommaToNumber(strNumber){    // 정규식을 이용해서 숫자의 3자리 마다 , 추가
    return String(strNumber).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

Date.prototype.format = function (f) {
    if (!this.valueOf()) return " ";
    var weekKorName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var weekKorShortName = ["일", "월", "화", "수", "목", "금", "토"];
    var weekEngName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    var weekEngShortName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
    var d = this;
    return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi, function ($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear(); // 년 (4자리)
            case "yy": return (d.getFullYear() % 1000).zf(2); // 년 (2자리)
            case "MM": return (d.getMonth() + 1).zf(2); // 월 (2자리)
            case "dd": return d.getDate().zf(2); // 일 (2자리)
            case "KS": return weekKorShortName[d.getDay()]; // 요일 (짧은 한글)
            case "KL": return weekKorName[d.getDay()]; // 요일 (긴 한글)
            case "ES": return weekEngShortName[d.getDay()]; // 요일 (짧은 영어)
            case "EL": return weekEngName[d.getDay()]; // 요일 (긴 영어)
            case "HH": return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2); // 시간 (12시간 기준, 2자리)
            case "mm": return d.getMinutes().zf(2); // 분 (2자리)
            case "ss": return d.getSeconds().zf(2); // 초 (2자리
            case "a/p": return d.getHours() < 12 ? "오전" : "오후"; // 오전/오후 구분
            default: return $1;
        }
    });
};

String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };
String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };
Number.prototype.zf = function (len) { return this.toString().zf(len); };

function enToKrWeek(week){
    const dateDict = {
        "MONDAY" : "월요일",
        "TUESDAY" : "화요일",
        "WEDNESDAY" : "수요일",
        "THURSDAY" : "목요일",
        "FRIDAY" : "금요일",
        "SATURDAY" : "토요일",
        "SUNDAY" : "일요일"
    }

    return dateDict[week];
}