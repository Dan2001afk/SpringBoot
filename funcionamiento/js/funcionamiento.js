$(document).ready(function(){
    $("#listar").on('click',function(){
        let tabla = document.querySelector('#tabla');
        $.ajax({
            url:"http://localhost:8080/listaProductos",
            type: "GET", 
            dataType: "JSON",
            success:function(respuesta){
                console.log(respuesta)
                for (i = 0; i<= respuesta.length; i++) {
                    tabla.innerHTML += '<tr><td>' + respuesta [i].codigo + '</td></tr>' +
                    '<tr><td>' + respuesta [i].nombre + '</td></tr>' +
                    '<tr><td>' + respuesta [i].categoria + '</td></tr>'+
                    '<tr><td>' + respuesta [i].precio + '</td></tr>'+
                    '<tr><td>' + respuesta [i].cantidad + '</td></tr>'
                }
            }
        })
    })

$('#descuento').on('click', function(){
        let dato = $("#datosDescuento").val();
        $.ajax({
          url: "http://localhost:8080/descuento/" + dato,
          type: "POST",
          datatype: JSON,
          success:function(respuesta){
            console.log(respuesta)
            alert(respuesta)
            if (respuesta) {
              let tabla = $("#tabla1 tbody");
              tabla.append('<tr><td>' + respuesta.codigo +'</td><td>' + respuesta.nombre + '</td><td>' + respuesta.categoria + '</td><td>' + respuesta.precio + '</td><td>' + respuesta.cantidad + '</td></tr>');
            } else {
              console.log("no esta en el sistema");
            }
          }
        });
      });  

      $("#minimo").on('click',function(){
        let tabla = document.querySelector('#tabla1');
        $.ajax({
            url:"http://localhost:8080/precioMasBarato",
            type: "GET", 
            dataType: "JSON",
            success:function(respuesta){
                console.log(respuesta)
               alert(respuesta)

                
                
            }
        })
    })


    
})