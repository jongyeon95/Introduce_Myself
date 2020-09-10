var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data= {
            name: $('#name').val(),
            category: $('#category').val(),
            class_name: $('#className').val(),
            take_time: $('#takeTime').val(),
            issuing_agency: $('#issuingAgency').val()

        };

        $.ajax({
            type: 'POST',
            url: '/admin/save/certificate',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        var data= {
            idx: $('#idx').val(),
            name: $('#name').val(),
        };


        $.ajax({
            type: 'PUT',
            url: '/admin/update/skills',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다');
            window.location.href='/';
        }).fail(function () {
            alert('수정 실패입니다');
        });

    },
    delete : function () {
        var idx = $('#idx').val();

        $.ajax({
            type: 'DELETE',
            url: '/admin/delete/skills/'+idx,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();