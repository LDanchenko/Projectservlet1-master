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
        request.setAttribute("count", hitnumber);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
        dispatcher.forward(request, response);
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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/entry.jsp");
        dispatcher.forward(request, response);


    }
}
