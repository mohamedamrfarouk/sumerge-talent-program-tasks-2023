//Function to generate random number
function randomNumber(min: number, max: number): number {
    let random_number: number = Math.random() * (max - min) + min;
    return random_number
}

var count:number =0

function hhhh(): void{
    count ++;
    console.log(count)

    let fruits = document.querySelectorAll('.fruit');

    fruits.forEach(fruit => {
        fruit.remove();
    });

    let myparent = document.querySelector('.parent')
    let seperator = document.createElement('div')
    seperator.className = "vl"

    if(myparent != null){
        for(let i=0; i<count;i++){
            var leftt = randomNumber(10, 40)
            var topp = randomNumber(15, 90)

            let left_fruit = document.createElement('div')
            left_fruit.innerHTML = '<img src="./data/img.png">'
            left_fruit.className = "fruit"
            left_fruit.style.left = leftt + "%"
            left_fruit.style.top = topp + "%"

            let right_fruit = document.createElement('div')
            right_fruit.innerHTML = '<img src="./data/img.png">'
            right_fruit.className = "fruit"
            right_fruit.style.left = leftt + 50 + "%"
            right_fruit.style.top = topp + "%"

            myparent.appendChild(left_fruit)
            myparent.appendChild(seperator)
            myparent.appendChild(right_fruit)
            document.body.appendChild(myparent)
        }

        var leftt = randomNumber(10, 40)
        var topp = randomNumber(10, 90)

        let extra_fruit = document.createElement('div')
        extra_fruit.innerHTML = '<img src="./data/img.png">'
        extra_fruit.setAttribute("class", "fruit extra")
        extra_fruit.style.left = leftt + "%"
        extra_fruit.style.top = topp + "%"

        myparent.appendChild(extra_fruit)
        document.body.appendChild(myparent)

        let level_number = document.querySelector(".level_number")
        if(level_number){
            level_number.textContent =String(count)
            
            let extra_fruit = document.querySelector('.extra')
            if(extra_fruit){
                console.log(extra_fruit)
                extra_fruit.setAttribute("onclick", "hhhh()")
            }
        }
    }
}

hhhh()

