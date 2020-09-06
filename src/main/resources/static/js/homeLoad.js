$(document).ready( function() {
    $.get("/basic",{},function (html) {
        $("#basic-information").html(html);
    })
});

$(document).ready( function() {
    $.get("/certificates",{},function (html) {
        $("#certificates").html(html);
    })
});

$(document).ready( function() {
    $.get("/education",{},function (html) {
        $("#educations").html(html);
    })
});

$(document).ready( function() {
    $.get("/skills",{},function (html) {
        $("#skills").html(html);
    })
});

$(document).ready( function() {
    $.get("/careers",{},function (html) {
        $("#careers").html(html);
    })
});
