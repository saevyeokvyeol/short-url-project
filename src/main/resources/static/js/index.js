$(function (){
    var main = {
        init : function () {
            var _this = this;

            $("#btn-save").on("click", function () {
                _this.save();
            });
        },
        save : function () {
            var data = {
                destinationUrl : $("#destinationUrl").val(),
                password : $("#password").val()
            };

            $.ajax({
                type: "POST",
                url: "/url",
                dataType: "text",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data)
            }).done(function (result) {
                window.location.href = "/" + result + "/detail";
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
    };

    main.init();
})