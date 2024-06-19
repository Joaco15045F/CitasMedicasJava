// Función para cargar contenido dinámico en el div #content
function cargarContenido(url) {
    $.get(url, function (data) {
        $('#content').html(data);
    });
}

// Función para cerrar el menú desplegable y cargar contenido
function toggleMenuAndLoadContent(menuItem, url) {
    var $submenu = $(menuItem).next('.submenu');
    cerrarMenus($submenu);
    cargarContenido(url);
}

// Función para cerrar todos los menús desplegables excepto el seleccionado
function cerrarMenus($submenu) {
    $('.submenu').not($submenu).slideUp();
    $submenu.slideToggle();
}

// Función para cerrar sesión
function logout() {
    window.location.href = '/';
}

$(document).ready(function () {
    $('.menu-item').click(function (e) {
        e.preventDefault();
        var $submenu = $(this).next('.submenu');
        cerrarMenus($submenu);
    });

    // Eventos específicos para admin.html y medico.html
    $('#listarPacientes').click(function (e) {
        e.preventDefault();
        toggleMenuAndLoadContent(this, '/citas/listar-pacientes');
    });

    $('#listarUsuarios').click(function (e) {
        e.preventDefault();
        toggleMenuAndLoadContent(this, '/usuarios/lista_de_usuarios');
    });
});
