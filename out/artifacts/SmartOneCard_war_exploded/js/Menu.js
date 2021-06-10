$(function () {
    $("ul>h2").click(function () {
        $(this).nextAll("li").slideToggle("slow");
    });
});


$(function () {
    $("li>a").click(function () {
        $('#iframe').attr('src',$(this).attr('title'));
    });
});