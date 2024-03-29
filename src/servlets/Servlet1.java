package servlets;

import classes.Database;
import classes.Logistic;
//import sun.rmi.runtime.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "Servlet1")
public class Servlet1 extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String id = request.getParameter("id");
        HttpSession session = request.getSession(true);
        Integer hitnumber = 1;
        Object htStr = session.getAttribute("hit");
        if (htStr != null){
            hitnumber = (Integer) htStr + 1;
        }

        session.setAttribute("hit", hitnumber);

        String button = request.getParameter("button");
        Statement statement = Database.connect();
        if ("button1".equals(button)) {
            String statusId = (request.getParameter("status").toString());
            request.setAttribute("status", statusId);
            ArrayList<Logistic> logistics = Database.selectByStatus(statement, statusId);
            request.setAttribute("logistics", logistics);
            ArrayList<String> status = Database.selectStatus(statement);
            request.setAttribute("status", status);
            request.setAttribute("count", hitnumber);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        else if ("button2".equals(button)) {

            ArrayList<Logistic> logistics = Database.sort(statement);
            request.setAttribute("logistics", logistics);
            ArrayList<String> status = Database.selectStatus(statement);
            request.setAttribute("status", status);
            request.setAttribute("count", hitnumber);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }
        if (id != null) {
            Integer rowId = Integer.parseInt(id);
            Database.DeleteById(statement, rowId);

            ArrayList<Logistic> logistics = Database.select(statement);
            request.setAttribute("logistics", logistics);
            ArrayList<String> status = Database.selectStatus(statement);
            request.setAttribute("status", status);
            request.setAttribute("count", hitnumber);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            response.setHeader("Refresh", "5");
            dispatcher.forward(request, response);
            //не перезагружает???
        }

    }



    protected void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer hitnumber = 1;
        Object htStr = session.getAttribute("hit");
        if (htStr != null){
            hitnumber = (Integer) htStr + 1;
        }

        session.setAttribute("hit", hitnumber);

        String statusId = (request.getParameter("status").toString());
        request.setAttribute("status", statusId);
        Statement statement = Database.connect();
        ArrayList<Logistic> logistics = Database.selectByStatus(statement, statusId);
        request.setAttribute("logistics", logistics);
        ArrayList<String> status = Database.selectStatus(statement);
        request.setAttribute("status", status);
        request.setAttribute("count", hitnumber);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session = request.getSession(true);

        Integer hitnumber = 1;
        Object htStr = session.getAttribute("hit");
        if (htStr != null) {
            hitnumber = (Integer) htStr + 1;
        }

        session.setAttribute("hit", hitnumber);
        Statement statement = Database.connect();



        ArrayList<Logistic> logistics1 = Database.select(statement);
        request.setAttribute("logistics", logistics1);
        ArrayList<String> status1 = Database.selectStatus(statement);
        request.setAttribute("status", status1);
        request.setAttribute("count", hitnumber);




        Cookie[] cookies = request.getCookies();
         String cook = "";
        if (cookies != null) {
        for (Cookie cookie : cookies) {
            //  if (cookie.getName().contains("key")) {
            cook += " , " + cookie.getValue();
            //  }
              }
         }
        request.setAttribute("cookie", cook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

//    public void delete(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
//
//    }



    }
