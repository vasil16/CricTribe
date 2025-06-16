const backendUrl = "http://localhost:8080/api/auth";

const loginForm = document.getElementById("loginForm");
if (loginForm) {
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault(); // ⛔ prevent form from reloading the page

    const res = await fetch(`${backendUrl}/login`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: document.getElementById("username").value,
        password: document.getElementById("password").value,
      }),
    });

    const data = await res.json();

    if (res.ok) {
      // Save token or user info if returned
      // localStorage.setItem("token", data.token);

      // ✅ Redirect to user.html on success
      localStorage.setItem("loggedInUser", JSON.stringify(data));
      window.location.href = "user.html";
      console.log("Login response:", data);

    } else {
      document.getElementById("loginResult").innerText =
        `Login failed: ${data.message || "Invalid credentials"}`;
    }
  });
}
