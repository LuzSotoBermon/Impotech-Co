// Obtener el usuario de sessionStorage
const usuario = sessionStorage.getItem("usuario");

if (usuario) {
    document.getElementById("email-usuario").innerText = usuario;
} else {
    window.location.href = "../Inicio de sesion/index.html"; // Redirige si no hay sesión activa
}
