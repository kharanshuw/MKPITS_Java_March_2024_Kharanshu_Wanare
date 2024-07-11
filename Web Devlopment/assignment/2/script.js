const menuToggle = document.querySelector('.menu-toggle');
const navLinks = document.querySelector('.nav-links');

menuToggle.addEventListener('click', function() {
  navLinks.classList.toggle('active'); // Add/remove 'active' class
  
  // Optional: Change menu icon appearance on toggle (example)
  const menuIcon = document.querySelector('.menu-icon');
  if (navLinks.classList.contains('active')) {
      menuIcon.style.transform = 'rotate(45deg)'; // Change icon to 'x'
  } else {
      menuIcon.style.transform = 'rotate(0deg)'; // Reset icon to hamburger
  }
});
