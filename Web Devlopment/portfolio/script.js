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


/*=============== EMAIL JS ===============*/


/*=============== SHOW SCROLL UP ===============*/ 


/*=============== SCROLL SECTIONS ACTIVE LINK ===============*/


/*=============== SCROLL REVEAL ANIMATION ===============*/
