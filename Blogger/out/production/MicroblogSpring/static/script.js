window.addEventListener('load', function () {
    $(".message-list-item").on("click", function (ev) {
        // events propagate. So. ev.target tells you
        // the element you clicked on. ev.currentTarget
        // tells you the element that's currently being processed.
        if (ev.target != ev.currentTarget) { return; }

        // getting a reference to the modify-post div
        // inside the list item we clicked on
        let editPostDiv = $(this).find(".modify-post");

        // we are storing a boolean as to whether
        // or not this div is visible
        let visible = editPostDiv.is(":visible");

        // we're hiding all modify-post divs
        $(".modify-post").hide();

        // setting the visibility of THIS modify-post
        // div equal to the opposite of what it was
        editPostDiv.toggle(!visible);



    });
});