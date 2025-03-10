fetch("https://impotechco.great-site.net/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email: "correo@example.com", password: "123456" })
})
.then(response => response.json())
.then(data => console.log(data))
.catch(error => console.error("Error en la solicitud:", error));fetch("https://impotechco.great-site.net/auth/login", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password }),
})
