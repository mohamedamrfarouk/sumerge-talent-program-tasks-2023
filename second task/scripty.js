
/*
access element 
-- document.getElementById('elementId') -> return one elemint 
-- document.getElementByTagName('tag name') -> return list of all elements have this tag
-- document.getElementByClassName('tag name') -> return list of all elements have this class name
-- document.querySelectorAll('cssSelector') -> return the list of elements 
-- document.querySelector('cssSelector') -> return the first element 
*/
/*
Dom [get / set content]
-- element.innerHTML -> get / set element html content
-- element.textContent -> get / set element text content not the html 
-- element."attributename" -> get / set attribute value
*/
/*
Dom [check attriputes]
-- Element.attributes -> list of attributes
-- Element.getAttributes -> value of specified attribute
-- Element.hasAttribute -> true or false
-- Element.hasAttributes -> true or false
-- Element.removeAttribute -> delete the attribute and return nothing
-- Element.setAttribute("attribute name", 'value')
*/
/*
Dom [create element]
-- document.createElement('tag name') -> return empty element not in the document yet
-- document.createTextNode("your text") -> returns text element not in the document yet
-- document.createComment("your comment") -> returns comment element not in the document yet
-- Element.appendchild(ELEMENT to be child node)
*/
/*
Dom [deal with childrens]
-- element.children -> returns children element
-- element.childnodes -> elements, comments, spaces
-- element.firstchild -> first child node
-- element.firstelementchild -> first child element
-- element.lastchild -> last child node
-- element.lastelementchild -> last child element
*/
/*

Dom [events]
-- onclick
-- oncontextmenu
-- onmouseenter
-- onmouseleave
-- onload
-- onscroll
-- onresize
etc.............
*/
// Function to generate random number
function randomNumber(min, max) {
    return Math.random() * (max - min) + min;
}

var count=0

function hhhh(){
    count ++;
    console.log(count)

    const fruits = document.querySelectorAll('.fruit');

    fruits.forEach(fruit => {
        fruit.remove();
    });

    myparent = document.querySelector('.parent')
    seperator = document.createElement('div')
    seperator.className = "vl"


    for(let i=0; i<count;i++){
        var leftt = randomNumber(10, 40)
        var topp = randomNumber(15, 90)

        left_fruit = document.createElement('div')
        left_fruit.innerHTML = '<img src="./data/img.png">'
        left_fruit.className = "fruit"
        left_fruit.style.left = leftt + "%"
        left_fruit.style.top = topp + "%"

        right_fruit = document.createElement('div')
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

    extra_fruit = document.createElement('div')
    extra_fruit.innerHTML = '<img src="./data/img.png">'
    extra_fruit.setAttribute("class", "fruit extra")
    extra_fruit.style.left = leftt + "%"
    extra_fruit.style.top = topp + "%"

    myparent.appendChild(extra_fruit)
    document.body.appendChild(myparent)

    level_number = document.querySelector(".level_number")
    level_number.textContent =count
    extra_fruit = document.querySelector('.extra')
    console.log(extra_fruit)
    extra_fruit.setAttribute("onclick", "hhhh()")
}

hhhh()

