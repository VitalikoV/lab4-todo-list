function modalHandler() {
    $(".new__post__btn").on("click", function () {
        $(".modal").css({"display": "block"});
    });

    $(".close__icon").on("click", function () {
        $(".modal").css({"display": "none"});
    });
}

$(document).ready(function () {

    searchReceiver();
    scrollHeader();
    $("#down__immediate, #down__normal, #down__done").hide();
    arrowToggle();
    modalHandler();

});



function searchReceiver() {
    $(".search").on("input", function () {
        $(".task").removeClass("found");
        let search = $(this).val();
        if (search.trim().length !== 0) {
            // $(".task:contains('" + search + "')").css("text-decoration", "underline");
            $(".task:contains('" + search + "')").addClass("found");

        }
    });
}

function scrollHeader() {
    $("[data-scroll]").on('click', function (event) {
        event.preventDefault();
        let elementId = $(this).data('scroll');
        let elOffSet = $(elementId).offset().top;

        $("html, body").animate({
            scrollTop: elOffSet - 80
        }, 700)

    })
}


function arrowToggle() {
    immediateToggle();
    normalToggle();
    doneToggle();
}

function immediateToggle() {
    $("#down__immediate").on("click", function () {
        hideTasks(".important", "#down__immediate", "#up__immediate");
    });

    $("#up__immediate").on("click", function () {
        showTasks(".important", "#down__immediate", "#up__immediate");
    });
}

function normalToggle() {
    $("#down__normal").on("click", function () {
        hideTasks(".normal", "#down__normal", "#up__normal");
    });

    $("#up__normal").on("click", function () {
        showTasks(".normal", "#down__normal", "#up__normal");
    });
}

function doneToggle() {
    $("#down__done").on("click", function () {
        hideTasks(".done", "#down__done", "#up__done");
    });

    $("#up__done").on("click", function () {
        showTasks(".done", "#down__done", "#up__done");
    });
}


function hideTasks(selectedElement, down, up){
    $(selectedElement).slideDown(1000);
    $(down).hide();
    $(up).show();

}

function showTasks(selectedElement, down, up){
    $(selectedElement).slideUp(1000);
    $(down).show();
    $(up).hide();
}