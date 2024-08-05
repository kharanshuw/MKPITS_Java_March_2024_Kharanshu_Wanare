let numberhours = document.querySelector('.number-hours');
let numberelement = [];

let barseconds = document.querySelector('.bar-seconds');

let barelement = [];


for (let i = 1; i <= 12; i++) {
    numberelement.push(
        `<span style="--index:${i};"><p>${i}</p></span>`
    );
}

numberhours.insertAdjacentHTML("afterbegin", numberelement.join(""));

for (let i = 1; i <= 60; i++) {
    barelement.push(`<span style="--index:${i}; "><p></p></span>`);
}

barseconds.insertAdjacentHTML("afterbegin", barelement.join(""));


let handHours = document.querySelector('.hand.hours');
let handMinutes = document.querySelector('.hand.minutes');
let handSeconds = document.querySelector('.hand.second');

function getCurrentTime() {
    let date = new Date();
    let currentHours = date.getHours();
    let currentMinutes = date.getMinutes();
    let currentSeconds = date.getSeconds();
    // 60 seconds = 360deg so 1 sec = 360 / 60 = 6deg
    // 60 minutes = 360deg so 1 min = 360 / 60 = 6deg
    // 12 hours = 360deg so 1 hrs = 360 / 12 = 30deg
    
    // 1 hrs = 30deg that means 60 min = 30deg so 1 min = 30 / 60 = 0.5 or 1/2 deg
    
    // so formula for hours is (hours * 30 + minutes / 2)

    handMinutes.style.transform=`rotate(${currentMinutes * 6 }deg)`;

    handHours.style.transform=`rotate(${currentHours * 30 + currentMinutes / 2 }deg)`;

    handSeconds.style.transform=`rotate(${currentSeconds * 6 }deg)`;
}

getCurrentTime();

setInterval(getCurrentTime, 1000);