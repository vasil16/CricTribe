const backendUrl = "http://localhost:8080/api/auth";

const registerForm = document.getElementById("registerForm");
if (registerForm) {
  registerForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const res = await fetch(`${backendUrl}/register`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: document.getElementById("username").value,
        fullName: document.getElementById("fullname").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value,
        password: document.getElementById("password").value,
      }),
    });

    const data = await res.json();

    if (res.ok) {
      // Optional: Save token/user info in localStorage if needed
      // localStorage.setItem("token", data.token);

      // Redirect to user page
      localStorage.setItem("loggedInUser", JSON.stringify(data));
      window.location.href = "user.html";
    } else {
      document.getElementById("registerResult").innerText = `Error: ${data.message || "Registration failed"}`;
    }
  });
}
