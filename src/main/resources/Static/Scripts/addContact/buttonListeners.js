function addContact() {
    $.ajax({
        url: "/add",
        type:"GET",
        dataType:"html",
        data:{
            name: $('#name').val(),
            phone: $('#phone').val(),
            email: $('#email').val(),
            blogLink: $('#blogLink').val(),
            comment: $('#comment').val()
        }
    })
    flushInputs();
}

function updateContact() {
    $.ajax({
        url: "/update",
        type: "GET",
        dataType: "html",
        data: {
            id: $('#selectId').val(),
            name: $('#name').val(),
            phone: $('#phone').val(),
            email: $('#email').val(),
            blogLink: $('#blogLink').val(),
            comment: $('#comment').val()
        },
        success: function (){
            console.log("update");
        }
    })

}

function deleteContact() {
    console.log("delete")
}