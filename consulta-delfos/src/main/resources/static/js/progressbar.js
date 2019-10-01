window.onload = function move() {
    var cpf = document.getElementById("cpf").value
    var elem = document.getElementById("bar")
    var width = 0

    // var id = setInterval(frame, 290);
    var id = setInterval(frame, 100);

    function frame() {
        if (width >= 100) {
            clearInterval(id);
            window.location.assign("http://localhost:8080/relatorios/" + cpf);
        } else {
            width++;
            elem.style.width = width + '%';
            elem.innerHTML = width * 1  + '%';
        }
    }
}