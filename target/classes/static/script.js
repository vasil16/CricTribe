const backendUrl = "http://localhost:8080/users";

// Register form handler
const registerForm = document.getElementById("registerForm");
if (registerForm) {
  registerForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const res = await fetch(`${backendUrl}/register`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
      }),
    });
    const data = await res.json();
    document.getElementById("registerResult").innerText = res.ok
      ? `Registered successfully! Token: ${data.token}`
      : `Error: ${data.message || "Registration failed"}`;
  });
}

// Login form handler
const loginForm = document.getElementById("loginForm");
if (loginForm) {
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const res = await fetch(`${backendUrl}/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: document.getElementById("username").value,
        password: document.getElementById("password").value,
      }),
    });
    const data = await res.json();
    document.getElementById("loginResult").innerText = res.ok
      ? `Login successful! Token: ${data.token}`
      : `Error: ${data.message || "Login failed"}`;
  });
}
