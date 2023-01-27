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
    $.ajax({
        type:"GET",
        url:"/admin/menu-add",
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

function order_list() {
    $("#menu_name").text("주문 목록");
    $.ajax({
        type:"GET",
        url:"/admin/order-list",
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

function store_add() {
    $("#menu_name").text("가게 추가");
    $.ajax({
        type:"GET",
        url:"/admin/store-add",
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

function total_order_list() {
    $("#menu_name").text("총 주문 현황");
    $.ajax({
        type:"GET",
        url:"/admin/total-order-list",
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

function review_list() {
    $("#menu_name").text("리뷰 현황");
    $.ajax({
        type:"GET",
        url:"/admin/review-list",
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

function test1() {
    $("#menu_name").text("장바구니 테스트");
    $.ajax({
        type:"GET",
        url:"/admin/test1",
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

function test2() {
    $("#menu_name").text("테스트 주문 넣기");
    $.ajax({
        type:"GET",
        url:"/admin/test2",
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

function test_review() {
    $("#menu_name").text("리뷰 테스트");
    $.ajax({
        type:"GET",
        url:"/admin/test-review",
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

function logout() {
    localStorage.removeItem("token");
    window.location.href="/admin/login";
}

function addStoreInfo(id) {
    if ($("#addtd" + id).css("display") == "none")
        $("#addtd" + id).show();
    else
        $("#addtd" + id).hide();
}

function sendStoreInfo(id) {
    let data = {
        "storeName":$("#storeInput" + id).val()
    }
    $.ajax({
        type:"POST",
        url:"/admin/store",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(data),
        beforeSend:function (xhr) {
            xhr.setRequestHeader("Authorization",localStorage.getItem("token"));
        },
        success:function(response) {
            alert("가게가 등록되었습니다.");
        }
    })
}