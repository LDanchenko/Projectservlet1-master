package servlets;

import classes.Database;
import classes.Logistic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "ServletEntry")
public class ServletEntry extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        Integer hitnumber = 1;
        Object htStr = session.getAttribute("hit");
        if (htStr != null){
            hitnumber = (Integer) htStr + 1;
        }

        session.setAttribute("hit", hitnumber);
//        request.setAttribute("count", hitnumber);
        String button = request.getParameter("button");
        Statement statement = Database.connect();
        if ("buttonEdit".equals(button)) {
            String statusId = (request.getParameter("status").toString());
//            request.setAttribute("status", statusId);
//            ArrayList<Logistic> logistics = Database.selectByStatus(statement, statusId);
//            request.setAttribute("logistics", logistics);
//            ArrayList<String> status = Database.selectStatus(statement);
//            request.setAttribute("status", status);
//            request.setAttribute("count", hitnumber);
            System.out.println(statusId + "  ");
            String town = (request.getParameter("town").toString());
            System.out.println(town + "  ");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);




        // Set response content type
        response.setContentType("text/html");

        Integer hitnumber = 1;
        Object htStr = session.getAttribute("hit");
        if (htStr != null){
            hitnumber = (Integer) htStr + 1;
        }

        session.setAttribute("hit", hitnumber);
        String id =  request.getPathInfo().substring(1);
        request.setAttribute("count", id);
        Integer idOrder =  Integer.parseInt(id);

        Cookie cookie = new Cookie("key" + id,id);
        cookie.setMaxAge(60*6000*24);
        cookie.setSecure(false);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        response.addCookie(cookie);

        Statement statement = Database.connect();
        ArrayList<Logistic> logistics = Database.selectById(statement, idOrder);
        request.setAttribute("logistics", logistics);

        ArrayList<String> adr = Database.selectAdr(statement);
        request.setAttribute("adrs", adr);

        ArrayList<String> goods = Database.selectGoods(statement);
        request.setAttribute("goods", goods);

        ArrayList<String> clients = Database.selectClients(statement);
        request.setAttribute("clients", clients);
        ArrayList<String> transports = Database.selectTransport(statement);
        request.setAttribute("transports", transports);
        ArrayList<String> stores = Database.selectStore(statement);
        request.setAttribute("stores", stores);
        ArrayList<String> status = Database.selectStatus(statement);
        request.setAttribute("status", status);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
        dispatcher.forward(request, response);


    }
}
