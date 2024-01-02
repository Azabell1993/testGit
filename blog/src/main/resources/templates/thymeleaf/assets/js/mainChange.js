// mainChange.js

$(document).ready(function () {
    // 메뉴 클릭 이벤트 처리
    $(document).on('click', '#menu a:not([href="#"])', function (event) {
        event.preventDefault(); // 기본 동작 방지

        var url = $(this).attr("href"); // 클릭된 메뉴의 링크 URL 가져오기
        $("#dynamicContent").load(url); // 동적으로 변경될 내용을 로드하여 표시
    });
});
