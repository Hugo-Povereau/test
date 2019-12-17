 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reguig
 */
@WebServlet(name = "Accueil", urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Accueil</title>");
            out.println("<link href=\"http://fr.allfont.net/allfont.css?fonts=commercial-script-bt\" rel=\"stylesheet\" type=\"text/css3\" />");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n" +
"    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
            
            out.println("</head>");
            out.println("<body>");
            out.println("  <style >\n" +
"      html{\n" +
"        background:radial-gradient(#91dbca, #d8e8a0);\n" +
"        background-repeat: no-repeat;\n" +
"        height:100%;\n" +
"      }\n" +
"\n" +
"      #image{\n" +
"        background-color:#454545;\n" +                    
"        position:absolute;\n" +
"        vertical-align: top;\n" +    
"        width:40%;\n" +            
"        top:30%;\n" +
"        left:50%;\n" +
"        transform: translate(-50%, -50%);\n" +
"\n" +
"      }\n" +
"      p{\n" +
"        position:absolute;\n" +
"        background:radial-gradient(#91dbca, #d8e8a0);\n" +
"        top:60%;\n" +
"        left:40%;\n" +
"        font-family: 'Commercial Script BT', arial;\n" +
"        font-size: 48px;\n" +
"        text-shadow: 4px 4px 4px #aaa;\n" +
"        border-radius: 15px 50px 30px;\n" +
"        padding: 10px;\n" +
"      }\n" +
"\n" +
"      #image_1{\n" +
"      background-color:#289C3B;\n" +
"      margin-left:10px;\n" +
"      }\n" +
"\n" +
"      #image_2{\n" +
"      margin-left:10px;\n" +
"      background-color:#1C5684;\n" +
"      }\n" +
"\n" +
"      #image_3{\n" +
"        margin-left:10px;\n" +
"      background-color:#484158;\n" +
"      }\n" +
"\n" +
"      #image_4{\n" +
"        margin-left:10px;\n" +
"      background-color:#484158;\n" +
"      }\n" +
"\n" +
"      #image_5{\n" +
"      background-color:#289C3B;\n" +
"      margin-left:10px;\n" +
"      }\n" +
"\n" +
"      #image_6{\n" +
"      margin-left:10px;\n" +
"      background-color:#1C5684;\n" +
"      }\n" +
"\n" +
"      #image_7{\n" +
"        margin-left:10px;\n" +
"      background-color:#484158;\n" +
"      }\n" +
"\n" +
"      #image_8{\n" +
"        margin-left:10px;\n" +
"      background-color:#484158;\n" +
"      }\n" +
"\n" +                    
"      .navbar .dropdown-toggle, .navbar .dropdown-menu a {\n" +
"          cursor: pointer;\n" +
"      }\n" +
"\n" +
"      .navbar .dropdown-item.active, .navbar .dropdown-item:active {\n" +
"          color: inherit;\n" +
"          text-decoration: none;\n" +
"          background-color: inherit;\n" +
"      }\n" +
"\n" +
"      .navbar .dropdown-item:focus, .navbar .dropdown-item:hover {\n" +
"          color: #16181b;\n" +
"          text-decoration: none;\n" +
"          background-color: #f8f9fa;\n" +
"      }\n" +
"\n" +
"      @media (min-width: 767px) {\n" +
"          .navbar .dropdown-toggle:not(.nav-link)::after {\n" +
"              display: inline-block;\n" +
"              width: 0;\n" +
"              height: 0;\n" +
"              margin-left: .5em;\n" +
"              vertical-align: 0;\n" +
"              border-bottom: .3em solid transparent;\n" +
"              border-top: .3em solid transparent;\n" +
"              border-left: .3em solid;\n" +
"          }\n" +
"      }\n" +
"\n" +
"\n" +
"    </style>");
            out.println("<script src=\"http://code.jquery.com/jquery.js\"></script>");
            out.println("<script>\n" +
"\n" +
"        $('.navbar .dropdown-item').on('click', function (e) {\n" +
"       var $el = $(this).children('.dropdown-toggle');\n" +
"       var $parent = $el.offsetParent(\".dropdown-menu\");\n" +
"       $(this).parent(\"li\").toggleClass('open');\n" +
"\n" +
"       if (!$parent.parent().hasClass('navbar-nav')) {\n" +
"           if ($parent.hasClass('show')) {\n" +
"               $parent.removeClass('show');\n" +
"               $el.next().removeClass('show');\n" +
"               $el.next().css({\"top\": -999, \"left\": -999});\n" +
"           } else {\n" +
"               $parent.parent().find('.show').removeClass('show');\n" +
"               $parent.addClass('show');\n" +
"               $el.next().addClass('show');\n" +
"               $el.next().css({\"top\": $el[0].offsetTop, \"left\": $parent.outerWidth() - 4});\n" +
"           }\n" +
"           e.preventDefault();\n" +
"           e.stopPropagation();\n" +
"       }\n" +
"   });\n" +
"\n" +
"   $('.navbar .dropdown').on('hidden.bs.dropdown', function () {\n" +
"       $(this).find('li.dropdown').removeClass('show open');\n" +
"       $(this).find('ul.dropdown-menu').removeClass('show open');\n" +
"   });\n" +
"    </script>");
            out.println(" <header>\n" +
"      <div class=\"navbar navbar-expand-md navbar-dark bg-dark mb-4\" role=\"navigation\">\n" +
"    <a class=\"navbar-brand\" href=\"Accueil\">Champo'zin</a>\n" +
"    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\" aria-controls=\"navbarCollapse\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"        <span class=\"navbar-toggler-icon\"></span>\n" +
"    </button>\n" +
"    <div class=\"collapse navbar-collapse\" id=\"navbarCollapse\">\n" +
"        <ul class=\"navbar-nav mr-auto\">\n" +
"\n" +
"            <li class=\"nav-item active\">\n" +
"                <a class=\"nav-link\" href=\"Panier\"> <span class=\"sr-only\">(current)</span>\n" +
"                <img src=\"images/Panier.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n" +
"                Panier</a>\n" +
"            </li>\n" + 
"\n" +              
"            <li class=\"nav-item active\">\n" +
"                <a class=\"nav-link\" href=\"Compte\"> <span class=\"sr-only\">(current)</span>\n" +
"                <img src=\"images/Compte.png\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n" +
"                Compte</a>\n" +
"            </li>\n" +                
"        </ul>\n" +
"\n" +
"    </div>\n" +
"    <form class=\"form-inline mt-2 mt-md-0\">\n" +
"        <input id=\"ecrit\" class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Rechercher un produit \" aria-label=\"Search\">\n" +
"        <button  id= \"cherche_bon_mot\" class=\"btn btn-dark my-2 my-sm-0\" type=\"button\">Search</button>\n" +
"    </form>\n" +
"    </div>\n" +
"\n" +
"  		</header>");
            out.println("<div id = \"image\" class=\"row\" >\n" +
"      <div id=#image_1 class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal1\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"           <a href =\"Boisson\" target =\"_self\">\n" +         
"          <img id = \"premier\" class=\"img-fluid\" src=\"images/Boisson.png\"  title=\"Boissons, cafés, thés, bières\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"      <!-- Portfolio Item 2 -->\n" +
"      <div id=#image_2  class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal2\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"          <a href =\"Assaisonnement\" target =\"_self\">\n" +
"          <img id=\"second\" class=\"img-fluid\" src=\"images/Assaisonnement.png\"  title=\"Sauces, assaisonnements et épices\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"      <!-- Portfolio Item 3 -->\n" +
"      <div id=#image_3  class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal3\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"          <a href =\"Dessert\" target =\"_self\">\n" +                    
"          <img id=\"troisieme\" class=\"img-fluid\" src=\"images/Dessert.png\"  title=\"Desserts et friandises\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"      <!-- Portfolio Item 4 -->\n" +
"      <div id=#image_4  class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal4\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"          <a href =\"Fromage\" target =\"_self\">\n" +   
"          <img id=\"quatrieme\" class=\"img-fluid\" src=\"images/Fromage.png\"  title=\"Fromages\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"      <!-- Portfolio Item 5 -->\n" +
"      <div id=#image_5  class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal5\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"          <a href =\"Biscuit\" target =\"_self\">\n" +   
"          <img id=\"cinquieme\" class=\"img-fluid\" src=\"images/Biscuit.png\"  title=\"Pain, biscuit, pâtes et céréales\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"      <!-- Portfolio Item 6 -->\n" +
"      <div id=#image_6  class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal6\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"          <a href =\"Viande\" target =\"_self\">\n" + 
"          <img id=\"sixieme\" class=\"img-fluid\" src=\"images/Viande.png\"  title=\"Viandes Préparées\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"      <!-- Portfolio Item 7 -->\n" +
"      <div id=#image_7  class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal7\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"          <a href =\"Raisin\" target =\"_self\">\n" + 
"          <img id=\"septieme\" class=\"img-fluid\" src=\"images/Raisin.png\"  title=\"Fruits secs, raisins, autres\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +
"      <!-- Portfolio Item 8 -->\n" +
"      <div id=#image_8  class=\"col-md-3 col-lg-3\">\n" +
"        <div class=\"portfolio-item mx-auto\" data-toggle=\"modal\" data-target=\"#portfolioModal8\">\n" +
"          <div class=\"portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100\">\n" +
"            <div class=\"portfolio-item-caption-content text-center text-white\">\n" +
"              <i class=\"fas fa-plus fa-3x\"></i>\n" +
"            </div>\n" +
"          </div>\n" +
"          <a href =\"Poisson\" target =\"_self\">\n" + 
"          <img id=\"huiteme\" class=\"img-fluid\" src=\"images/Poisson.png\" title=\"Poissons, fruits de mer, escargots\" onmouseover=\"this.width=this.width-5\" onmouseout=\"this.width=this.width+5\" alt=\"\">\n" +
"          </a>\n" +
"        </div>\n" +
"      </div>\n" +
"\n" +                  
"    </div> ");
            out.println("<p>Bienvenue</p>");
          
            out.println("</body>");
            out.println("</html>");
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

}
