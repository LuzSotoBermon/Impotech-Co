// Obtener el usuario de sessionStorage
const usuario = sessionStorage.getItem("usuario");

if (usuario) {
    document.getElementById("email-usuario").innerText = usuario;
} else {
    // Si no hay usuario, redirigir al login
    window.location.href = "../Inicio de sesion/index.html";
}
