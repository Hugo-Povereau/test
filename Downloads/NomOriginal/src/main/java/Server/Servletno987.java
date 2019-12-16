/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Servletno987 extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException,ServletException {
    GenererReponse(request, response);
  }

  protected void GenererReponse(HttpServletRequest request, HttpServletResponse reponse) 
    throws IOException {
 
    reponse.setContentType("text/html");

    PrintWriter out =reponse.getWriter();

    out.println("<html>");
    out.println("<body>");
    out.println("<head>");
    out.println("<title>Informations a disposition de la servlet</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>Type mime de la requête :"
      +request.getContentType()+"</p>");
    out.println("<p>Protocole de la requête :"
      +request.getProtocol()+"</p>");
    out.println("<p>Adresse IP du client :"
      +request.getRemoteAddr()+"</p>");
    out.println("<p>Nom du client : "
      +request.getRemoteHost()+"</p>");
    out.println("<p>Nom du serveur qui a reçu la requête :"
      +request.getServerName()+"</p>");
    out.println("<p>Port du serveur qui a reçu la requête :"
      +request.getServerPort()+"</p>");
    out.println("<p>scheme: "+request.getScheme()+"</p>");
    out.println("<p>liste des paramètres </p>");

    for (Enumeration e =request.getParameterNames() ; e.hasMoreElements() ; ) {
      Object p = e.nextElement();
      out.println("<p>&nbsp;&nbsp;nom : "+p+" valeur :"
        +request.getParameter(""+p)+"</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

