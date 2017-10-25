$(document).ready(function () {



    $("button.start").click(function(){

            $("td.gutter > div.line").each(function() {
                $(this).prepend("<input class=\"check-input\" type=\"checkbox\" value=\"\" checked>");
            });

            $('input.check-input').click(function() {
                let parent = $(this).parent()[0];
                let divName = changeToDescription(parent);
                $("div.container > " + divName + " > code").each(function() {
                    $(this).toggleClass("gray");
                });
            });

            //$("div.container > div.line").each(function() {
            //    $(this).append("<code class=\"java comments\" style=\"display: none\">//" + getText($(this)) + "</code>");
            //});

            //$("div.container > div.line").click(function() {
            //    $(this).children().each(function() {
            //        $(this).toggle();
            //    });
            //});
    });

    /*function getText(obj) {
        var s = '';
        obj.children().each(function() {
            s = s + $(this).text() + " ";
        });
        return s;
    }*/

    function changeToDescription(obj) {
        var s = '' + obj.tagName;
        for (var i = 0; i < obj.classList.length; i++) {
            s = s + "." + obj.classList[i];
        }
        return s;
    }
});