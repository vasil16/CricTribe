// user.js
const user = JSON.parse(localStorage.getItem("loggedInUser"));
if (user) {
  document.getElementById("username").textContent = user.username;
  document.getElementById("email").textContent = user.email;
  document.getElementById("fullname").textContent = user.player.name;
  document.getElementById("runs").textContent = user.player.totalRuns;
  document.getElementById("wickets").textContent = user.player.totalWickets;
} else {
  window.location.href = "login.html"; // If not logged in, redirect
}
