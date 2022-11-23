$(document).ready(function () {
    $("tr #deleteEspecialidad").click(function (e) {
        e.preventDefault();
        var cod = $(this).parent().find('#codigo').val();
        swal({
        title: "Esta Seguro de Eliminar?",
        text: "Una vez eliminado deberá agregar de nuevo!",
        confirmButtonText: "Sí, Eliminar!",
         cancelButtonText: "Cancelar!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
        html:true
      })
      .then((willDelete) => {
                    
        if (willDelete) {
            eliminarUsuario(cod)
          swal("Eliminado! La especialidad se elimino correctamente!", {
            icon: "success",
          });
          setTimeout(function (){
                            parent.location.href = "../Especialidad?accion=listar"
                        }, 1000);
        } else {
          swal("Cancelado", "Cancelaste la eliminación", "error");
        }
});
    });

    function eliminarUsuario(cod) {
        var url = "../Especialidad?accion=eliminar&idespec=" + cod;
        console.log("eliminado");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {
                
            }
        });
    }
});

