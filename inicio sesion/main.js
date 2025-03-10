document.getElementById('login-form').addEventListener('submit', async function(event) {
    event.preventDefault();  

    const usuario = document.getElementById('usuario').value;
    const contrasena = document.getElementById('contrasena').value;

    try {
        const response = await fetch('http://localhost:8090/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email: usuario, password: contrasena })
        });

        const result = await response.text();
        console.log("Respuesta del backend:", result);

        if (result === "Login exitoso") {
            alert("Inicio de sesión exitoso");
            window.location.href = "../Gestion productos/INDEX.HTML";  
        } else {
            alert("Usuario o contraseña incorrectos");
        }
    } catch (error) {
        console.error("Error en la solicitud:", error);
        alert("No se pudo conectar con el servidor.");
    }
});
