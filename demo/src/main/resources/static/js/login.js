fetch("/api/usuarios/registrar", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({ usuario: "test", password: "1234" })
})
.then(response => {
    if (!response.ok) {
        throw new Error(`Error ${response.status}: ${response.statusText}`);
    }
    return response.json();
})
.then(data => console.log("Respuesta:", data))
.catch(error => console.error("Error en la solicitud:", error));
