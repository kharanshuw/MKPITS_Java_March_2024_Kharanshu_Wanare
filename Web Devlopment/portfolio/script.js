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
const contactform=document.getElementById('contact-form');
let contactmessage=document.getElementById('contact-message');
const sendemail=(e)=>{
    e.preventDefault();
    emailjs.sendForm('service_bl40bjt','template_ui58e9f','#contact-form','d2mympAFExgYqhRhJ')
.then(()={
    //show sent message
    contactmessage.textContent ='Message sent successfully ';
    setTimeout(() => {
        contactmessage.textContent=''
    }, 5000)

    contactform.reset();
})
}
// serviceID - templateID - #form - publicKey

contactform.addEventListener('submit',sendemail);
/*=============== SHOW SCROLL UP ===============*/ 


/*=============== SCROLL SECTIONS ACTIVE LINK ===============*/


/*=============== SCROLL REVEAL ANIMATION ===============*/
