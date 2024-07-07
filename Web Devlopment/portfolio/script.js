/*=============== SHOW MENU ===============*/
const navmenu=document.getElementById('nav-menu');
const navtoggle=document.getElementById('nav-toggle');
const navclose=document.getElementById('nav-close');

// menu show
if(navtoggle){
    navtoggle.addEventListener('click',()=>{
        navmenu.classList.add('show-menu');
    })
}

//menu hidden
if(navclose)
    {
        navclose.addEventListener('click',()=>{
            navmenu.classList.remove('show-menu');
        })
    }
/*=============== REMOVE MENU MOBILE ===============*/
const navlink=document.querySelectorAll('.nav__link');
const linkaction=()=>{
    const navmenu=document.getElementById('nav-menu');
    navmenu.classList.remove('show-menu');
}

navlink.forEach(mynavlink);

function mynavlink(n){
    n.addEventListener('click',linkaction);
}



/*=============== ADD BLUR HEADER ===============*/

const blurheader=()=>{
    const header=document.getElementById('header')
    this.scrollY >= 50 ? header.classList.add('blur-header')
                        :header.classList.remove('blur-header')
}

window.addEventListener('scroll ',blurheader);


/*=============== EMAIL JS ===============*/

// serviceID - templateID - #form - publicKey


/*=============== SHOW SCROLL UP ===============*/
function scrollUp() {
    const scrollUpButton = document.getElementById('scroll-up'); // Get reference to scroll-up button
  
    // Check if scroll position is greater than or equal to 350 pixels
    if (window.scrollY >= 350) {
      scrollUpButton.classList.add('show-scroll'); // Add 'show-scroll' class for visibility
    } else {
      scrollUpButton.classList.remove('show-scroll'); // Remove 'show-scroll' class for hiding
    }
  }
  
  // Add event listener for 'scroll' event on window object
  window.addEventListener('scroll', scrollUp);
  
/*=============== SCROLL SECTIONS ACTIVE LINK ===============*/
// Select all sections with an ID attribute
const sections = document.querySelectorAll('section[id]');

// Function to handle highlighting active section on scroll
const updateActiveSection = () => {
  // Get current vertical scroll position
  const scrollPosition = window.scrollY;

  sections.forEach(section => {
    const sectionHeight = section.offsetHeight;
    const sectionTop = section.offsetTop - getNavigationHeight(); // Account for navigation height

    // Get the corresponding navigation link for this section
    const sectionLink = document.querySelector('.nav__menu a[href*="' + section.id + '"]');

    // Check if the section is currently in view
    if (scrollPosition >= sectionTop && scrollPosition <= sectionTop + sectionHeight) {
      sectionLink.classList.add('active-link'); // Add active class to navigation link
    } else {
      sectionLink.classList.remove('active-link'); // Remove active class
    }
  });
};

// Function to get navigation height (assuming it's constant)
function getNavigationHeight() {
  // Replace with your logic to calculate or retrieve navigation height
  return 58; // Placeholder value, adjust as needed
}

// Attach event listener to window scroll event
window.addEventListener('scroll', updateActiveSection);

// Call updateActiveSection initially to handle potential initial scroll position
updateActiveSection();

/*=============== SCROLL REVEAL ANIMATION ===============*/

const sr=ScrollReveal({
  origin:'top',
  distance:'60px',
  duration:2500,
  delay:400,
})

sr.reveal(`.home__data,.experience,.skills,.contact__container`)
sr.reveal(`.home__img`,{delay :600})
sr.reveal(`.home__scroll`,{delay :800})
sr.reveal(`.work__card,.services__card`,{interval:800})
sr.reveal(`.about__content`,{origin:'right'})
sr.reveal(`.about__img`,{origin:'left'})
