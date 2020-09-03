var main = {
    init: function () {
        var _this=this;
        $('#btn-update').on('click', function () {
            _this.update();
        });

    },


    update: function () {
        var data = {
            idx: $('#idx').val(),
            email: $('#email').val(),
            pw: $('#pw').val(),
            chagepw : $('#changepw').val()
        };


        $.ajax({
            type: 'PUT',
            url: '/admin/update/info',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다');
            window.location.href = '/';
        }).fail(function () {
            alert('수정 실패입니다');
        });

    }
}

main.init();