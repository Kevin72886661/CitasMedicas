package pe.citas.servlets.Usuario;

import pe.citas.modelo.vo.Opcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import pe.citas.BD.Interfaces.InterfaceMedico;
import pe.citas.BD.Mysql.MysqlMedico;
import pe.citas.modelo.vo.Medico;

public class Lista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Opción del primer combo, seleccionado por el usuario.
            int seleccion = Integer.parseInt(request.getParameter("selected"));
            
            ArrayList<Opcion> opciones = new ArrayList<>();
            
            InterfaceMedico DaoMedico=null;
            DaoMedico=new MysqlMedico();
            
            ArrayList<Medico> listaMedicos=DaoMedico.valiMedico2(seleccion);
            
            for (int i = 0; i < listaMedicos.size(); i++) {
                
                Opcion op1 = new Opcion(listaMedicos.get(i).getId(),listaMedicos.get(i).getNombre()+" "+listaMedicos.get(i).getApellidopat()+" "+listaMedicos.get(i).getApellidomat());
                
                opciones.add(op1);
            }
            
            JSONObject jsonObject = getJsonFromMyList(opciones);    
        
            out.println(jsonObject);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private JSONObject getJsonFromMyList(ArrayList<Opcion> opciones) {
        JSONObject objetoJSONInicial = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        
        for (int i = 0; i < opciones.size(); i++) {
            JSONObject jsonObjectItem = new JSONObject();
            jsonObjectItem.put("opcion_valor", opciones.get(i).getValor());
            jsonObjectItem.put("opcion_texto", opciones.get(i).getTexto());
            jsonArray.put(jsonObjectItem);
        }
        
        objetoJSONInicial.put("opciones", jsonArray);
                
        return objetoJSONInicial;
    }

}
