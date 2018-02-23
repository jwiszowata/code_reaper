$(document).ready(function () {

    $.fn.setDegrees = function() {
        var all = parseInt($('#all_tasks').text());
        this.each(function() {
            var tasks = parseInt($(this).data("value"));
            if (tasks == 0) {
                return;
            }
            var degrees = (tasks / all) * 360;
            $(this).css('-moz-transform', 'rotate(' + degrees + 'deg)');
            $(this).css('-webkit-transform', 'rotate(' + degrees + 'deg)');
            $(this).css('-o-transform', 'rotate(' + degrees + 'deg)');
            $(this).css('transform', 'rotate(' + degrees + 'deg)');
            console.log("setDegrees", $(this), degrees);
        });    
    }; 

    $.fn.rotate = function() {
        var all = parseInt($('#all_tasks').text());
        var angle = 0;
        this.each(function() {
            var tasks = parseInt($(this).children().data("value"));
            var degrees = (tasks / all) * 360;
            $(this).css('-moz-transform', 'rotate(' + angle + 'deg)');
            $(this).css('-webkit-transform', 'rotate(' + angle + 'deg)');
            $(this).css('-o-transform', 'rotate(' + angle + 'deg)');
            $(this).css('transform', 'rotate(' + angle + 'deg)');
            console.log("rotate", $(this), angle);
            angle += degrees;
        });    
    };

    $('.central_hold > .pie').setDegrees();
    $('.central_hold').rotate();

    function properForm(i) {
        var i10 = i % 10;
        var i100 = i % 100;
        var e10 = (i10 == 2 || i10 == 3 || i10 == 4);
        var e100 = (i100 == 12 || i100 == 13 || i100 == 14);
        if (i == 1) {
            return "zadanie";
        } else if (e10 && !e100) {
            return "zadania";
        } else {
            return "zadań";
        }
    }

    var t = parseInt($('span#all_tasks').text());
    $('span#task_word').html(properForm(t));
});