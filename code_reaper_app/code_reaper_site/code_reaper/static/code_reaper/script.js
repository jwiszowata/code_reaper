$(document).ready(function () {
    $("button.start").click(function(){
        //$("div.line").click(function(){
            //var t = $(this).text();
            //var s = '//';
            //$(this).children().each(function() {
            //    s = s + $(this).text() + " ";
            //    $(this).hide();
            //});
            $("div.container > div.line").each(function() {
                $(this).append("<code class=\"java comments\" style=\"display: none\">//" + getText($(this)) + "</code>");
            });

            $("div.container > div.line").click(function() {
                $(this).children().each(function() {
                    $(this).toggle();
                });
            });
    });

    function getText(obj) {
        var s = '';
        obj.children().each(function() {
            s = s + $(this).text() + " ";
        });
        return s;
    }
});