const API_URL = "https://impotech-co-production.up.railway.app/auth/login";

fetch(API_URL, {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
    },
    body: JSON.stringify({
        email: "correo@ejemplo.com",
        password: "123456",
    }),
})
.then(response => response.json())
.then(data => console.log("Respuesta:", data))
.catch(error => console.error("Error:", error));
