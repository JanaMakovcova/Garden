let barvy=document.querySelector(".barvy");
let kvetiny = document.querySelector("#kvetina");

ukazBarvu();

function ukazBarvu() {
    if (kvetiny.checked == true) {
       barvy.classList.remove("schovana");
       //barvy.classList.add("ukaz");
    }
}







function zobrazNavod(){
let navod = document.querySelector('.navod');
navod.classList.toggle('schovej');


}




