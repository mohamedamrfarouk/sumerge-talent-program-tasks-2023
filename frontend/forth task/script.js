var jsonData = [];
var headers = [];

function upload() {
  var files = document.getElementById('file_upload').files;
  if (files.length == 0) {
    alert("Please choose any file...");
  }
  var filename = files[0].name;
  var extension = filename.substring(filename.lastIndexOf(".")).toUpperCase();
  return files[0];
}

async function csvFileToJSON(file) {
  return new Promise((resolve, reject) => {
    try {
      var reader = new FileReader();
      reader.readAsBinaryString(file);
      reader.onload = function (e) {
        var rows = e.target.result.split("\n");
        for (var i = 0; i < rows.length; i++) {
          var cells = rows[i].split(",");
          var rowData = {};
          for (var j = 0; j < cells.length; j++) {
            if (i === 0) {
              var headerName = cells[j].trim();
              headers.push(headerName);
            } else {
              var key = headers[j];
              if (key) {
                rowData[key] = cells[j].trim();
              }
            }
          }
          if (i !== 0) {
            jsonData.push(rowData);
          }
        }
        resolve(jsonData);
      };
    } catch (e) {
      console.error(e);
      reject(e);
    }
  });
}


function displayJsonToHtmlTable(jsonData){
    var table=document.getElementById("display_csv_data");
    table.innerHTML=''
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




const btn = document.querySelector("#btn");


async function btn_func() {
    jsonData=[]
    try {
      const myfile = upload();
      const jsonData = await csvFileToJSON(myfile);

      displayJsonToHtmlTable(jsonData)


    } catch (error) {
      console.error(error);
    }
  }
