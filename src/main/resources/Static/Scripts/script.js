function getIds() {
    $.ajax({
        url: "http://localhost:8080/getIds",
        method: "GET",
        dataType: "html",
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            setOptions(JSON.parse(data).ids)
        }
    })
}
console.log("script running");

function getOption(id) {
    let opt = document.createElement("option");
    opt.innerHTML = id;
    return opt;
}

function setOptions(ids) {
    for(let i = 0; i < ids.length; i++)
        document.getElementById("selectIds").appendChild(getOption(ids[i]))
}

getIds();;