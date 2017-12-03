$(document).ready(function () {

    $("div.color").click(function() {
        var color = getColorClass($(this)[0]);
        var active_color = getColorClass($('div.r0.c0')[0])
        console.log(active_color);
        if (color === active_color) {
            return true;
        }
        /*$("div.field.done").each(function() {
            if (isActive($(this)[0])) {
                console.log("active");
                checkNeighbours($(this)[0]);
            }
            setColor($(this), color);
        })*/
        $.ajax({
            url: 'move/',
            type: 'GET',
            data: {'color': color.substr(3)},
            //dataType: 'json',
            /*success: function (data) {
                obj = JSON.parse(data.responseText);
                console.log(obj);
            },*/
        }).done(function(response) {
            console.log(response);
            fields = response.fields;
            for (var i = 0; i < fields.length; i++) {
                console.log(i, fields[i]);
                console.log("div.field.r" + fields[i].row + 
                    ".c" + fields[i].column);
                setColor(
                    $("div.field.r" + fields[i].row + 
                    ".c" + fields[i].column), 
                    "col" + fields[i].color);
            }
            $("#steps")[0].innerText = response.steps;

            moves_desc = 'ruchów';
            if (response.steps === 1) {
                moves_desc = 'ruch';
            } else if (response.steps === 2 || response.steps === 3 || response.steps === 4) {
                moves_desc = 'ruchy';
            }
            $("#moves")[0].innerText = moves_desc;
        });
        return true;
    });

    function getClassOfRegex(obj, regex) {
        console.log("getClassOfRegex", obj);
        for (var i = 0; i < obj.classList.length; i++) {
            if (regex.test(obj.classList[i])) {
                return obj.classList[i];
            }
        }
        return -1;
    }

    function getColorClass(obj) {
        return getClassOfRegex(obj, new RegExp(/^col\d$/));
    };

    function getRowNr(obj) {
        var row = getClassOfRegex(obj, new RegExp(/^r\d/));
        return parseInt(row.substr(1));
    }

    function getColNr(obj) {
        var col = getClassOfRegex(obj, new RegExp(/^c\d/));
        return parseInt(col.substr(1));
    }

    function isActive(obj) {
        for (var i = 0; i < obj.classList.length; i++) {
            if (obj.classList[i] == "active") {
                return true;
            }
        }
        return false;
    };

    function checkNeighbours(obj) {
        var row = getRowNr(obj);
        var col = getColNr(obj);
        var neighbours = {
            'up': [row, col-1],
            'left': [row-1, col]
        }
    }

    function setColor(obj, color) {
        console.log("setColor", obj, color);
        var col = getColorClass(obj[0]);
        obj.removeClass(col).addClass(color);
    };
    /*$("button.start").click(function(){

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

    function getText(obj) {
        var s = '';
        obj.children().each(function() {
            s = s + $(this).text() + " ";
        });
        return s;
    }

    function changeToDescription(obj) {
        var s = '' + obj.tagName;
        for (var i = 0; i < obj.classList.length; i++) {
            s = s + "." + obj.classList[i];
        }
        return s;
    }*/
});