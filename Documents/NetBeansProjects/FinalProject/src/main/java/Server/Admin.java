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
 * @author Reb
 */
@WebServlet(name = "Admin", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {

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
            out.println("<title>Servlet Assaisonnement</title>");    
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\n" +
"<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
"<script type=\"text/javascript\" src=\"../Js/bar_chart.js\"> </script>\n" +
"<script type=\"text/javascript\" src=\"../Js/geo_chart.js\"> </script>\n" +
"<script type=\"text/javascript\" src=\"../Js/client_chart.js\"> </script>");            
            out.println("</head>");
            out.println("<body>");
            out.println("  <style >\n" +
"      html{\n" +
"        background:radial-gradient(#91dbca, #d8e8a0);\n" +
"        background-repeat: no-repeat;\n" +
"        height:100%;\n" +
"      }\n" +
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
"</div>\n" +
"\n" +
"\n" +
"  		</header>");
            
            out.println("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
"    <script type=\"text/javascript\">\n" +
"\n" +
"      // Load the Visualization API and the corechart package.\n" +
"      google.charts.load('current', {'packages':['corechart']});\n" +
"\n" +
"      // Set a callback to run when the Google Visualization API is loaded.\n" +
"      google.charts.setOnLoadCallback(drawChart);\n" +
"\n" +
"      // Callback that creates and populates a data table,\n" +
"      // instantiates the pie chart, passes in the data and\n" +
"      // draws it.\n" +
"      function drawChart() {\n" +
"\n" +
"        // Create the data table.\n" +
"        var data = new google.visualization.DataTable();\n" +
"        data.addColumn('string', 'Topping');\n" +
"        data.addColumn('number', 'Slices');\n" +
"        data.addRows([\n" +
"          ['Mushrooms', 3],\n" +
"          ['Onions', 1],\n" +
"          ['Olives', 1],\n" +
"          ['Zucchini', 1],\n" +
"          ['Pepperoni', 2]\n" +
"        ]);\n" +
"\n" +
"        // Set chart options\n" +
"        var options = {'title':'How Much Pizza I Ate Last Night',\n" +
"                       'width':400,\n" +
"                       'height':300};\n" +
"\n" +
"        // Instantiate and draw our chart, passing in some options.\n" +
"        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));\n" +
"        chart.draw(data, options);\n" +
"      }\n" +
"    </script>");
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
