$(document).ready(function () {

    var nIntervId;

    function addCheckboxes() {
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
    }

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

    function startTimer(duration, display) {
        var timer = duration, minutes, seconds;
        nIntervId = setInterval(function () {
            minutes = parseInt(timer / 60, 10)
            seconds = parseInt(timer % 60, 10);

            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            display.textContent = minutes + ":" + seconds;

            if (--timer < 0) {
                clearInterval(nIntervId);
                $('#finishModal').modal('show');
            }
        }, 1000);
    }

    $('#startModal').modal('show');

    $("button.start").click(function() {
        var time = 60 * 2,
            display = document.querySelector('#time');
        startTimer(time, display);
        addCheckboxes();
    });
});