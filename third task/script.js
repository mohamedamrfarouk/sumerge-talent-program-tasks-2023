//Function to generate random number
function randomNumber(min, max) {
    var random_number = Math.random() * (max - min) + min;
    return random_number;
}
var count = 0;
function hhhh() {
    count++;
    console.log(count);
    var fruits = document.querySelectorAll('.fruit');
    fruits.forEach(function (fruit) {
        fruit.remove();
    });
    var myparent = document.querySelector('.parent');
    var seperator = document.createElement('div');
    seperator.className = "vl";
    if (myparent != null) {
        for (var i = 0; i < count; i++) {
            var leftt = randomNumber(10, 40);
            var topp = randomNumber(15, 90);
            var left_fruit = document.createElement('div');
            left_fruit.innerHTML = '<img src="./data/img.png">';
            left_fruit.className = "fruit";
            left_fruit.style.left = leftt + "%";
            left_fruit.style.top = topp + "%";
            var right_fruit = document.createElement('div');
            right_fruit.innerHTML = '<img src="./data/img.png">';
            right_fruit.className = "fruit";
            right_fruit.style.left = leftt + 50 + "%";
            right_fruit.style.top = topp + "%";
            myparent.appendChild(left_fruit);
            myparent.appendChild(seperator);
            myparent.appendChild(right_fruit);
            document.body.appendChild(myparent);
        }
        var leftt = randomNumber(10, 40);
        var topp = randomNumber(10, 90);
        var extra_fruit = document.createElement('div');
        extra_fruit.innerHTML = '<img src="./data/img.png">';
        extra_fruit.setAttribute("class", "fruit extra");
        extra_fruit.style.left = leftt + "%";
        extra_fruit.style.top = topp + "%";
        myparent.appendChild(extra_fruit);
        document.body.appendChild(myparent);
        var level_number = document.querySelector(".level_number");
        if (level_number) {
            level_number.textContent = String(count);
            var extra_fruit_1 = document.querySelector('.extra');
            if (extra_fruit_1) {
                console.log(extra_fruit_1);
                extra_fruit_1.setAttribute("onclick", "hhhh()");
            }
        }
    }
}
hhhh();
