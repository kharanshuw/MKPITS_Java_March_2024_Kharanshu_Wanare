const colorBoxes = document.querySelector('#div1');

const colorBoxes2=document.querySelector("#div3");

    colorBoxes.addEventListener('click', function() {
      if (this.id === 'div1') {
        this.style.backgroundColor = 'red';
      } 
    });

    colorBoxes2.addEventListener('click', function() {
        if (this.id === 'div3') {
          this.style.backgroundColor = 'green';
        } 
      });
