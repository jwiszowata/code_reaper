$(document).ready(function () {

    var nIntervId;

    function addCheckboxes() {
        $("td.gutter > div.line").each(function() {
            if ($(this)[0].getElementsByTagName("label") == []) {
                console.log($(this)[0].getElementsByTagName("label"));
                return;
            }
            $(this).prepend(
                "<label class=\"custom-control custom-checkbox small\">" +
                    "<input class=\"custom-control-input\" type=\"checkbox\" value=\"\" checked>" +
                    "<span class=\"custom-control-indicator top check-input\"></span>" +
                "</label>");
            $(this).click(function() {
                let divName = changeToDescription($(this)[0]);
                $("div.container > " + divName + " > code").each(function() {
                    $(this).toggleClass("gray");
                });
                let input = $(this)[0].getElementsByTagName('input')[0];
                input.checked = !input.checked;
            });
        });

        // $('td.gutter > div.line').click(function() {
        //     let divName = changeToDescription($(this)[0]);
        //     $("div.container > " + divName + " > code").each(function() {
        //         $(this).toggleClass("gray");
        //     });
        //     let input = $(this)[0].getElementsByTagName('input')[0];
        //     input.checked = !input.checked;
        // });

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