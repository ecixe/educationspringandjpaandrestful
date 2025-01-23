let allTeachers;

function getTeachers(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        var responseText = this.responseText;
        var responseObj = JSON.parse(responseText).object
        allTeachers=responseObj;
        var tr =  document.getElementById("tbl-teachers-body-tr").innerHTML;
        var tblBody = ""

        for (let i = 0; i<responseObj.length; i++){
            let teachers = responseObj[i]

            tblBody += tr
                .replaceAll(":id", teachers.id)
                .replaceAll(":index",i)
                .replace(":name",teachers.name)
                .replace(":surname",teachers.surname)
                .replace(":email", teachers.email)
                .replace(":age", teachers.age)
                .replace(":university", teachers.university.name)
                .replace(":address", teachers.address.name)
        }
        document.getElementById("tbl-teachers-body").innerHTML=tblBody
    }

    xhttp.open("GET","http://localhost:9090/education/teachers?" +
        "name="+val("name")+"&" +
        "surname="+val("surname")+"&" +
        "email="+val("email")+"&" +
        "age="+val("age")+"&" +
        "university="+val("university")+"&" +
        "address="+val("address"));

    xhttp.send()

}

function val(elementId){
    var value = document.getElementById(elementId).value;
    return value !== null && value !== undefined ? value:"";
}

function getUniversity(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function (){
        let responseObj = JSON.parse(this.responseText);
        let optionsHtml = '<option value="" selected></option>'

        for (let i = 0; i<responseObj.length; i++){
            let university = responseObj[i]
            optionsHtml+='<option value="'+university.id+'">'+university.name+'</option>'
        }
        document.getElementById("university").innerHTML=optionsHtml
        document.getElementById("create_university").innerHTML=optionsHtml
        document.getElementById("update_university").innerHTML=optionsHtml
    }

    xhttp.open("GET","http://localhost:9090/education/teachers?university="+val("university")+"&")

    xhttp.send()

}

let selectedId

function select(id){
    selectedId = id
    console.log("Secilmis id " + selectedId)
}


function deleteTeacher(selectedId){
    const xhttp = new XMLHttpRequest()
    xhttp.onload = function (){
        if (xhttp.readyState === 4 && xhttp.status === 200){
            getTeachers()
        }
    }
    xhttp.open("DELETE", `http://localhost:9090/education/teachers?id=${selectedId}`, true);
    xhttp.send()
}

function insertTeacher(){
    const xhttp = new XMLHttpRequest()
    xhttp.onload = function (){
        if (xhttp.readyState === 4 && xhttp.status === 200){
            getTeachers()
        }
    }
    let teachers={
        name:document.getElementById("create_name").value,
        surname:document.getElementById("create_surname").value,
        email:document.getElementById("create_email").value,
        age:document.getElementById("create_age").value,
        university:{
            id:document.getElementById("create_university").value
        },
        address:{
            id:document.getElementById("create_address").value
        }
    }
    xhttp.open("POST", `http://localhost:9090/education/teachers`, true);
    xhttp.setRequestHeader("Content-type","application/json")
    xhttp.send(JSON.stringify(teachers))
}

function updateTeacher(){
    const xhttp = new XMLHttpRequest()
    xhttp.onload = function (){
        if (xhttp.readyState === 4 && xhttp.status === 200){
            getTeachers()
        }
    }
    let teachers={
        id:selectedId,
        name:document.getElementById("update_name").value,
        surname:document.getElementById("update_surname").value,
        email:document.getElementById("update_email").value,
        age:document.getElementById("update_age").value,
        university:{
            id:document.getElementById("update_university").value
        },
        address:{
            id:document.getElementById("update_address").value
        }
    }
    xhttp.open("PUT", `http://localhost:9090/education/teachers`, true);
    xhttp.setRequestHeader("Content-type","application/json")
    xhttp.send(JSON.stringify(teachers))
}

function selectForUpdate(index){
    let selectedTeacher = allTeachers[index]
    document.getElementById("update_name").value = selectedTeacher.name
    document.getElementById("update_surname").value = selectedTeacher.surname
    document.getElementById("update_age").value = selectedTeacher.age
    document.getElementById("update_email").value = selectedTeacher.email
    document.getElementById("update_university").value = selectedTeacher.university.id
    document.getElementById("update_address").value = selectedTeacher.address.id
    selectedId = selectedTeacher.id
}


document.addEventListener("DOMContentLoaded", function () {
    document.addEventListener('hide.bs.modal', function (event) {
        if (document.activeElement) {
            document.activeElement.blur();
        }
    });
});
window.addEventListener('load',getTeachers)
window.addEventListener('load',getUniversity)
