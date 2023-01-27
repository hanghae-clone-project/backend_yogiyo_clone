function store_detail() {
    $("#menu_name").text("가게 현황");
    $.ajax({
        type:"GET",
        url:"/admin/store-detail",
        dataType:"html",
        async:true,
        beforeSend:function (xhr) {
            xhr.setRequestHeader("Authorization",localStorage.getItem("token"));
        },
        success:function(response) {
            $("#feature").replaceWith(response);
        }
    })
}

function menu_add() {
    $("#menu_name").text("메뉴 추가");
}

function order_list() {
    $("#menu_name").text("주문 목록");
}

function store_add() {
    $("#menu_name").text("가게 추가");
}

function total_order_list() {
    $("#menu_name").text("총 주문 현황");
}

function review_list() {
    $("#menu_name").text("리뷰 현황");
}

function test1() {
    $("#menu_name").text("장바구니 테스트");
}

function test2() {
    $("#menu_name").text("테스트 주문 넣기");
}

function main() {
    $("#menu_name").text("메인화면");
    $.ajax({
        type:"GET",
        url:"/admin/admin-main",
        dataType:"html",
        async:true,
        beforeSend:function (xhr) {
            xhr.setRequestHeader("Authorization",localStorage.getItem("token"));
        },
        success:function(response) {
            $("#feature").replaceWith(response);
        }
    })
}