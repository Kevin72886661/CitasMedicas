package pe.citas.BD.Mysql;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import pe.citas.BD.Interfaces.InterfaceCita;
import pe.citas.BD.Interfaces.InterfaceEspecialidad;
import pe.citas.BD.Interfaces.InterfaceHistoria;
import pe.citas.BD.Interfaces.InterfaceHorario;
import pe.citas.BD.Interfaces.InterfaceMedico;
import pe.citas.BD.Interfaces.InterfacePrescripcion;
import pe.citas.modelo.vo.Cita;
import pe.citas.modelo.vo.Especialidad;
import pe.citas.modelo.vo.HistoriaC;
import pe.citas.modelo.vo.Horario;
import pe.citas.modelo.vo.Medico;
import pe.citas.modelo.vo.Prescripcion_C;
import pe.citas.modelo.vo.Usuario;
import pe.citas.servlets.Usuario.Prescripcion;



public class TestConecta {

    public static void main(String[] args) {
        MysqlConexion conecta = new MysqlConexion();
        InterfaceEspecialidad DaoEsp=new MysqlEspecialidad();
        
        Connection conn = conecta.getConnection();
         
        Cita cita=new Cita();
    
        
//        for (Cita listaCita : listaCitas) {
//            int idcita=listaCita.getIdCita();
//            
//            if (idcita==) {
//                
//            }
//        }
        
        //DaoEsp.insertar(cita);
        
//        InterfaceCita DaoCita=new MysqlCita();
                    
//                    ArrayList<Especialidad> listaespec = DaoEsp.listar();
//                    for (Especialidad espec : listaespec) {
//                        System.out.println("citas "+espec.getNomEspecialidad());
//        }
              InterfaceHorario daoHorario=new MysqlHorario();
              ArrayList<Horario> hora=daoHorario.listar2();
              
              for (Horario h : hora) {
            System.out.println(""+h.getMedico().getNombre());
        }
              
        
//        InterfaceHistoria DaoHistoria=new MysqlHistoria();
//        
//        MysqlHistoria Dao_Historia=new MysqlHistoria();
//        
//                            HistoriaC historia= new HistoriaC();
//
//                    historia.setIdHistoria(3); 
//                    historia.setAntecedentes("Padre con gastritis cronica");
//                    historia.setMotivo("Acidez estomacal fuerte");
//                    historia.setEnfermedad("Ninguna");
//                    historia.setExamenes("Endoscopia");
//                    
//                    DaoHistoria.actualizarHistoria(historia);
                    
//          InterfacePrescripcion DaoPrescripcion=new MysqlPrescripcion();
//          
//          ArrayList<Prescripcion_C> listaPresc=DaoPrescripcion.valiPrescripcion(2);
//          
//          for (Prescripcion_C prescripcion_C : listaPresc) {
//              System.out.println(prescripcion_C.getIdUsuario());
//        }
          
        
//        Dao_Historia.insertar(historia);
        //InterfaceCita DaoCita = new MysqlCita();
//        ArrayList<Cita> lista= DaoCita.valiCitaMedico(1);
//       for(Cita listacita:lista){
//           System.out.println(listacita.getEspecialidad().getNomEspecialidad());
//       }
//          
//        InterfacePrescripcion DaoPrescripcion = new MysqlPrescripcion();
//        
//        Prescripcion_C p= new Prescripcion_C();
//
//        p.setIdUsuario(1);
//        p.setIdMedico(2);
//        p.setReceta("Amoxicilina");
//        p.setRecomendacion("No comer comidas picantes");
//        p.setFecha("05/11/19");
//        
//        DaoPrescripcion.insertar(p);
        
        
         //InterfaceCita DaoCita=new MysqlCita();
        
       // DaoCita.eliminar(6);
        
        
         
        
        
        
        
       
    }

}
