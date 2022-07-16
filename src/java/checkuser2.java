
/*
public class checkuser {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContenType("text/html;charset-UTF-8");
        
        try(PrintWriter out = response.getWriter()) {
            Persistencia base = new Persistencia();
            ResultSet rs = base.consultaSQL("select * from usuarios where usuario = " + "'" + request.getParameter("inputEmail") 
            + "'" + "and clave = " + "'" + request.getParameter("inputPassword") + "'"
            );
        
        
            if(rs==null){
                out.println("No hay usuarios que coincidan con la busqueda");
            } else {
                while(rs.next()){
                    out.println(rs.getString("usuario"));
                    out.println(rs.getString("clave"));
                    out.println(rs.getString("nombreyapellido")+"<BR>");
                }

                out.println("<h1>Proyecto: " + request.getContextPath()+"<h1>");
                out.println("<h1>Usuario: " + request.getParameter("inputEmail")+"<h1>");
            }
        }
    }
}
*/