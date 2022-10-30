chooseAdd();

function chooseAdd() {
    $('#addChoice').html("<b>Add</b>");
    $('#updateChoice').html("Update");
    $('#deleteChoice').html("Delete");
    flushInputs();
    $('#selectId').hide();
    atrButton("add")
}

function chooseUpdate() {
    $('#addChoice').html("Add");
    $('#updateChoice').html("<b>Update</b>");
    $('#deleteChoice').html("Delete");
    flushInputs();
    selectIdShow();
    atrButton("update")

}

function chooseDelete() {
    $('#addChoice').html("Add");
    $('#updateChoice').html("Update");
    $('#deleteChoice').html("<b>Delete</b>");
    flushInputs();
    $('#selectId').show();
    atrButton("delete")
}

function flushInputs() {
    $('#name').val("");
    $('#phone').val("");
    $('#email').val("");
    $('#blogLink').val("");
    $('#comment').val("");
}

function atrButton(task) {
    let submit = $('#submit');
    submit.val(task + " contact")
    submit.off('click')
    submit.on('click', function () {
        if (task === 'add') addContact();
        else if (task === 'update') updateContact();
        else deleteContact();
    })
}

function selectIdShow() {
    $('#selectId').show();
    getIdsFromDB();
    setTimeout(function () {
        selectIdListener()
    }, 50);
}