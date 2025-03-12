document.addEventListener('DOMContentLoaded', async function() {
    try {
        const response = await fetch('http://localhost:8080/api/usuarios');
        const usuarios = await response.json();

        console.log("Usuarios obtenidos:", usuarios);
        // Aquí podrías llenar una tabla o una lista en HTML con los usuarios obtenidos
    } catch (error) {
        console.error("Error al obtener usuarios:", error);
    }
});
