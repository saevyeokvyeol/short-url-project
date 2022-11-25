$(function (){
    var main = {
        init : function () {
            var _this = this;

            $("#btn-authenticate").on("click", function () {
                _this.authenticate();
            });
        },
        authenticate : function () {
            var data = {
                shortUrl : $("#shortUrl").val(),
                password : $("#password").val()
            };

            $.ajax({
                type: "POST",
                url: "/authenticate",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data)
            }).done(function () {
                window.location.href = "/" + $("#shortUrl").val() + "/detail";
            }).fail(function (error) {
                alert("올바르지 않은 비밀번호입니다.");
            });
        }
    };

    main.init();
})