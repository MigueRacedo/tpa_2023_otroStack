function abrirInicio() {
    cerrarRegistro();
    const modal = document.getElementById('inicio-overlay');
    modal.style.display = 'flex';
}

function cerrarInicio() {
    const modal = document.getElementById('inicio-overlay');
    modal.style.display = 'none';
}

function abrirRegistro() {
    cerrarInicio();
    const modal = document.getElementById('registrar-overlay');
    modal.style.display = 'flex';
}

function cerrarRegistro() {
    const modal = document.getElementById('registrar-overlay');
    modal.style.display = 'none';
}