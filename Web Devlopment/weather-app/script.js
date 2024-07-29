let container = document.querySelector('.container');
let search = document.querySelector('.search-box button');
let weatherbox = document.querySelector('.weather-box');
let weatherdetails = document.querySelector('.weather-details');
let eror404 = document.querySelector('.not-found');
let cityhide = document.querySelector('.city-hide');


search.addEventListener('click', () => {
  const apikey = '';
  let city = document.querySelector('.search-box input').value;

  if (city == '')
    return;

  let url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apikey}`;

  fetch(url)
    .then((response) => {
      return response.json();
    })
    .then(
      (res) => {

        if (res.cod === '404') {
          cityhide.textContent = city;
          container.style.height = '400px';
          weatherbox.classList.remove('active');
          weatherdetails.classList.remove('active');
          eror404.classList.add('active');
          return;
        }



        let image = document.querySelector('.weather-box img');
        let temperature = document.querySelector('.weather-box .temperature');
        let description = document.querySelector('.weather-box .description');
        let humidity = document.querySelector('.weather-details .humidity span');
        let wind = document.querySelector('.weather-details .wind span');

        if (cityhide.textContent == city) {
          return;
        }
        else {
          cityhide.textContent = city;

          container.style.height = '555px';
          container.classList.add('active');
          weatherbox.classList.add('active');
          weatherdetails.classList.add('active');
          eror404.classList.remove('active');

          setTimeout(() => {
            container.classList.remove('active');

          }, 2500);

          switch (res.weather[0].main) {
            case 'Clear':
              image.src = './images/clear.png';
              console.log(res.weather[0].main);
              break;

            case 'Rain':
              image.src = './images/rain.png';
              console.log(res.weather[0].main);
              break;

            case 'Snow':
              image.src = './images/snow.png';
              console.log(res.weather[0].main);
              break;

            case 'Clouds':
              image.src = './images/cloud.png';
              console.log(res.weather[0].main);

              break;

            case 'Mist':
              image.src = './images/mist.png';
              console.log(res.weather[0].main);

              break;

            case 'Haze':
              image.src = './images/mist.png';
              console.log(res.weather[0].main);

              break;

            default:
              image.src = './images/cloud.png';

              break;
          }

          temperature.innerHTML = `${parseInt(res.main.temp)}<span>°C</span>`;

          description.innerHTML = `${res.weather[0].description}`;

          humidity.innerHTML = `${res.main.humidity}%`;

          wind.innerHTML = `${parseInt(res.wind.speed)}Km/h`;

          let infoweather=document.querySelector('.info-weather');
          let infohumidity=document.querySelector('.info-humidity');
          let infowind=document.querySelector('.info-wind');

          let elcloneinfoweather=infoweather.cloneNode(true);
          let elcloneinfohumidity=infohumidity.cloneNode(true);
          let elcloneinfowind=infowind.cloneNode(true);
        }


      }
    );
});

























/*async function getData() {
  let cityname='nagpur'
  let key='';
    const url = `https://api.openweathermap.org/data/2.5/weather?q=${cityname}&appid=${key}`;
    try {
      const response = await fetch(url);
      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }
  
      const data = await response.json();
      console.log(data);
      console.log(data ["coord"]["lon"]+" "+"coordinates");

      console.log(data["weather"]['0']["id"]);
      console.log(data["weather"]['0']["main"]);
      console.log(data["weather"]['0']["description"]);
    } catch (error) {
      console.error(error.message);
    }
  }
*/
