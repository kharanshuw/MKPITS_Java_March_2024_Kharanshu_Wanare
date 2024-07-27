const listElement = document.getElementById('colorList');

listElement.addEventListener('click', function() {
  const listItems = this.querySelectorAll('li');
  listItems.forEach(item => {
    item.style.color = 'red';
  });
});
