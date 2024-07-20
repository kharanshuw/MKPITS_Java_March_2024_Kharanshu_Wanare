let hrs=document.getElementById('hrs');
let min=document.getElementById('min');
let sec=document.getElementById('sec');
let am_pm=document.getElementById('am-pm');

// setInterval=(()=>{
//     let currenttime=new Date();
//     var dt = new Date();
//     var hours = dt.getHours() ; // gives the value in 24 hours format
//     var AmOrPm = hours >= 12 ? 'pm' : 'am';
//     hours = (hours % 12) || 12;
//     var minutes = dt.getMinutes() ;
//     //var finalTime = "Time  - " + hours + ":" + minutes + " " + AmOrPm; 
//     //finalTime // final time Time - 22:10
    
//     hrs.innerHTML=hours;
//     min.innerHTML=minutes;
//     sec.innerHTML=currenttime.getSeconds();
    
// },1000);

/*
setInterval(() => {
    // Get the current time
    const currenttime = new Date();
  
    // Format the time (hours, minutes, seconds, AM/PM)
    let hours = currenttime.getHours();
    let AmOrPm = hours >= 12 ? 'PM' : 'AM';
    hours = (hours % 12) || 12; // Convert to 12-hour format (12 if 0)
    let minutes = currenttime.getMinutes().toString().padStart(2, '0'); // Ensure two-digit display
    let seconds = currenttime.getSeconds().toString().padStart(2, '0'); // Ensure two-digit display
  
    // Update the HTML elements (assuming they exist)
    hrs.innerHTML = hours;
    min.innerHTML = minutes;
    sec.innerHTML = seconds;
    am_pm.innerHTML=AmOrPm;
  }, 1000);

*/


/*  setInterval(() => {
  let todaydate=new Date();
  let day = document.getElementById('day');
  let month=document.getElementById('month');
  let year = document.getElementById('year');

  let todays_date=todaydate.getDate();
  day.innerHTML=todays_date;
  month.innerHTML=todaydate.getMonth();

  year.innerHTML(todaydate.getFullYear());




}, 1000);*/


// Function to format time (reusable)
function formatTime(currentTime) {
  const hours = currentTime.getHours();
  const AmOrPm = hours >= 12 ? 'PM' : 'AM';
  const formattedHours = (hours % 12) || 12; // Convert to 12-hour format (12 if 0)
  const minutes = currentTime.getMinutes().toString().padStart(2, '0');
  const seconds = currentTime.getSeconds().toString().padStart(2, '0');

  return { hours: formattedHours, minutes, seconds, AmOrPm };
}

// Function to update clock display (reusable)
function updateClock() {
  const currentTime = new Date();
  const { hours, minutes, seconds, AmOrPm } = formatTime(currentTime);

  hrs.innerHTML = hours;
  min.innerHTML = minutes;
  sec.innerHTML = seconds;
  am_pm.innerHTML = AmOrPm;
}

// Function to update date display (reusable)
function updateDate() {
  const todaydate = new Date();
  const day = document.getElementById('day');
  const month = document.getElementById('month');
  const year = document.getElementById('year');

  day.innerHTML = todaydate.getDate();
  month.innerHTML = todaydate.getMonth(); // Use monthNames array
  year.innerHTML = todaydate.getFullYear();
}

// Month names array (for consistent month display)
const monthNames = ["January", "February", "March", "April", "May", "June",
                   "July", "August", "September", "October", "November", "December"];

// Call update functions initially to display content on page load
updateClock();
updateDate();

// Set interval for updates (combined into single setInterval for efficiency)
setInterval(() => {
  updateClock();
  updateDate();
}, 1000);
