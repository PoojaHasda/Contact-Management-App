console.log("Script loaded");

// change theme work
let currentTheme = getTheme();
//initial -->

document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page

  changePageTheme(currentTheme, "");
  //set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked");
    if (currentTheme === "dark") {
      //theme ko light
      currentTheme = "light";
    } else {
      //theme ko dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localstorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localstorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  //localstorage mein update karenge
  setTheme(currentTheme);
  //remove the current theme

  if (oldTheme) {
    document.querySelector("html").classList.remove(oldTheme);
  }
  //set the current theme
  document.querySelector("html").classList.add(theme);

  // change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}

//change page change theme


// password validation

function validatePasswords() {
  let password = document.getElementById("password").value;
  let confirmPassword = document.getElementById("confirm_password").value;
  let validationMessage = document.getElementById("password-validation-message");

  if (password.length > 0 || confirmPassword.length > 0) {
    // Show the validation message only if at least one of the fields is not empty
    validationMessage.style.display = "inline";
    
    if (password === confirmPassword) {
      validationMessage.textContent = "Passwords match";
      validationMessage.style.color = "green";
    } else {
      validationMessage.textContent = "Passwords do not match";
      validationMessage.style.color = "red";
    }
  } else {
    // Hide the validation message if both fields are empty
    validationMessage.style.display = "none";
  }
}

// Add event listeners to the password fields when the page loads
document.addEventListener('DOMContentLoaded', function() {
  document.getElementById("password").addEventListener("input", validatePasswords);
  document.getElementById("confirm_password").addEventListener("input", validatePasswords);
});
