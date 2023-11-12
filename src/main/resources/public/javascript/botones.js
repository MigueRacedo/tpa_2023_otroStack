function handleButtonHover(event) {
    event.target.style.transform = 'scale(1.05)';
}

function handleButtonLeave(event) {
    event.target.style.transform = 'scale(1)';
}

const botones = document.querySelectorAll('.boton-secundario, .boton-primario,.big-button, .boton-terciario, .user-button');
botones.forEach(button =>{
    button.addEventListener('mouseenter', handleButtonHover);
    button.addEventListener('mouseleave', handleButtonLeave);
});

function enviarCoordenadas() {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(function(position) {

            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;

            var formulario = document.createElement("form");
            formulario.method = "post";
            formulario.action = "incidentes/cercanos";

            var latitudInput = document.createElement("input");
            latitudInput.type = "hidden";
            latitudInput.name = "latitud";
            latitudInput.value = latitude;
            formulario.appendChild(latitudInput);

            var longitudInput = document.createElement("input");
            longitudInput.type = "hidden";
            longitudInput.name = "longitud";
            longitudInput.value = longitude;
            formulario.appendChild(longitudInput);
            document.body.appendChild(formulario);
            formulario.submit();
        });
    } else {
        alert("Geolocalización no es compatible en este navegador.");
    }
}

function toggleDropdown() {
    var dropdownContent = document.getElementById("dropdown-content");
    if (dropdownContent.style.display === "block") {
        dropdownContent.style.display = "none";
    } else {
        dropdownContent.style.display = "block";
    }
}