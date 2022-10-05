function validar() {
            if(validaLogin()== true && validaContra()== true)         
               return true;
            else 
               return false;
            }
            function validaLogin(){
                login = document.getElementById("login").value;  
                if(login.length == 0 ) {
                    document.getElementById("login").select(); 
                    alert("Debe ingresar usuario") ;
                    return false ; 
                }else{
                     sw = true;
                     login = login.toUpperCase();
                     for(i=0; i<login.length; i++){  
                       car = login.charAt(i);
                       if( car == ' '){
                          if(car<'A' || car>'Z'){
                             sw = false; 
                             break;
                          }
                        }
                     }                
                     if(sw == false) {
                       document.getElementById("login").select(); 
                       alert("Usuario invalido");    
                       return false;
                     }
                     else 
                         return true;
                }
             }
            function validaContra(){
                contra = document.getElementById("contra").value;  
                if(contra.length == 0 ) {
                    document.getElementById("contra").select(); 
                    alert("Debe ingresar su contraceña") ;
                    return false ; 
                }else{
                    var invalidos = ' ,.-{}´+°!"#$%&/()=?¡@*-';
                    var errores = 0;
                    for(i=0; i<invalidos.length; i++){
			c = invalidos.charAt(i);
			if(contra.indexOf(c)!=-1){
				errores++;
			}
                    }
                    if(errores>0){
			alert("Tu contraceña tiene caracteres especiales no aceptados");
                    } else {
			return true;
                    }
                }
             }
             
             
function validar2() {
            if(validaLogin2()== true && validaContra2()== true && iguales()==true)         
               return true;
            else 
               return false;
            }
            
            function validaLogin2(){
                login = document.getElementById("login2").value;  
                if(login.length == 0 ) {
                    document.getElementById("login2").select(); 
                    alert("Debe ingresar usuario") ;
                    return false ; 
                }else{
                     sw = true;
                     login = login.toUpperCase();
                     for(i=0; i<login.length; i++){  
                       car = login.charAt(i);
                       if( car == ' '){
                          if(car<'A' || car>'Z'){
                             sw = false; 
                             break;
                          }
                        }
                     }                
                     if(sw == false) {
                       document.getElementById("login2").select(); 
                       alert("Usuario invalido");    
                       return false;
                     }
                     else 
                         return true;
                }
             }
            function validaContra2(){
                contra = document.getElementById("contra2").value;  
                if(contra.length == 0 ) {
                    document.getElementById("contra2").select(); 
                    alert("Debe ingresar su contraceña") ;
                    return false ; 
                }else{
                    var invalidos = ' ,.-{}´+°!"#$%&/()=?¡@*-';
                    var errores = 0;
                    for(i=0; i<invalidos.length; i++){
			c = invalidos.charAt(i);
			if(contra.indexOf(c)!=-1){
				errores++;
			}
                    }
                    if(errores>0){
			alert("Tu contraceña tiene caracteres especiales no aceptados");
                    } else {
			return true;
                    }
                }
             }
            function iguales(){
                 contra2 = document.getElementById("contra2").value;  
                 contra3 = document.getElementById("contra3").value;  
                 if (contra2==contra3){
                     return true;
                 }else{
                     alert("Tus contraseñas no coinciden");
                     return false ;
                 }
                 
             }
             