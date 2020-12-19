const button = document.getElementById('button');
const square = document.getElementById('square');

let randBoolean = () => { return (Math.floor(Math.random() * 10) % 2); };

button.addEventListener('click', () => {
    if (randBoolean() % 2)
        square.classList.add('blue');
    else
        square.classList.add('red');
});