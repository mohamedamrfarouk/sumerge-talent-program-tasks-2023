// Method to upload a valid csv file
function upload() {
    console.log("5")
    var files = document.getElementById('file_upload').files;
    console.log("2")
    if(files.length==0){
        alert("Please choose any file...");
        console.log("3")
    }
    var filename = files[0].name;
    var extension = filename.substring(filename.lastIndexOf(".")).toUpperCase();
        //Here calling another method to read CSV file into json
        return files[0];
}

//Method to read csv file and convert it into JSON 
function csvFileToJSON(file){
    // debugger;
    console.log(file)
    try {
        var reader = new FileReader();
        reader.readAsBinaryString(file);
        reader.onload = function(e) {
            var jsonData = [];
            var headers = [];
            var rows = e.target.result.split("\r\n");               
            for (var i = 0; i < rows.length; i++) {
                var cells = rows[i].split(",");
                var rowData = {};
                for(var j=0;j<cells.length;j++){
                    if(i==0){
                        var headerName = cells[j].trim();
                        headers.push(headerName);
                    }else{
                        var key = headers[j];
                        if(key){
                            rowData[key] = cells[j].trim();
                        }
                    }
                }
                
            if(i!=0){
                jsonData.push(rowData);
            }
        }

        //displaying the json result into HTML table
        console.log(jsonData)
        return jsonData;
        }
    }catch(e){
        console.error(e);
    }
}

//Method to display the data in HTML Table
function displayJsonToHtmlTable(jsonData){
    var table=document.getElementById("display_csv_data");
    if(jsonData.length>0){
        var headers = Object.keys(jsonData[0]);
        var htmlHeader='<thead><tr>';
            
        for(var i=0;i<headers.length;i++){
            htmlHeader+= '<th>'+headers[i]+'</th>';
        }
        htmlHeader+= '<tr></thead>';
            
        var htmlBody = '<tbody>';
        for(var i=0;i<jsonData.length;i++){
            var row=jsonData[i];
            htmlBody+='<tr>';
            for(var j=0;j<headers.length;j++){
                var key = headers[j];
                htmlBody+='<td>'+row[key]+'</td>';
            }
            htmlBody+='</tr>';
        }
        htmlBody+='</tbody>';
        table.innerHTML=htmlHeader+htmlBody;
    }else{
        table.innerHTML='There is no data in CSV';
    }
}



const btn = document.querySelector("#btn")


function btn_func(){
    myfile = upload()
    jsonData = csvFileToJSON(myfile)
    displayJsonToHtmlTable(jsonData)

}
// async function btn_func(){
//     const mypromise = new Promise(async (resolve, reject)=>{
//         myfile = upload()
//         jsonData = csvFileToJSON(myfile)
    
//         if(jsonData){
//             resolve(jsonData)
//         }else{
//             reject(Error("file not valid"))
//         }
//     });
//         console.log("before")
//         let value = await mypromise
//         displayJsonToHtmlTable(value)
//         console.log('after')
// }