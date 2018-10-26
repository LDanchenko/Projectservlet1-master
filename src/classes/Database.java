package classes;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static String url = "jdbc:mysql://node62636-env-6396616.mircloud.host:11201/logistic?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "ADIoda36819";



    public static Statement connect(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, username, password);

            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;

    }

    public  static ArrayList<Logistic> select(Statement statement)  {


      ArrayList <Logistic> logistics = new ArrayList <Logistic>();
        try{



                ResultSet resultSet = statement.executeQuery("SELECT o.id, o.town,  o.representation, o.route,  a.name AS address, g.name AS goods, c.name AS client, t.name AS transport, st.name AS store, s.name AS status  " +
                        "FROM orders o INNER JOIN addresses a ON o.address = a.id INNER JOIN goods g ON o.goods = g.id INNER JOIN clients c ON o.client = c.id  INNER JOIN transport t ON o.transport = t.id  " +
                        " INNER JOIN stores st ON o.store = st.id INNER JOIN status s ON o.status = s.id");
                while(resultSet.next()){

                    Logistic log = new Logistic();
                    log.setId(resultSet.getInt("id"));
                    log.setTown(resultSet.getString("town"));
                    log.setRepresentation(resultSet.getString("representation"));
                    log.setRoute(resultSet.getString("route"));
                    log.setAddress(resultSet.getString("address"));
                    log.setGood(resultSet.getString("goods"));
                    log.setClient(resultSet.getString("client"));
                    log.setTransport(resultSet.getString("transport"));
                    log.setStore(resultSet.getString("store"));
                    log.setStatus(resultSet.getString("status"));

                    logistics.add(log);
                }
            }


        catch(Exception ex){
            System.out.println(ex);
        }
        return logistics;
    }


    public  static ArrayList<Logistic> selectByStatus(Statement statement, String status) {


        ArrayList<Logistic> logistics = new ArrayList<Logistic>();


            try {
                String s = null;
                ResultSet resultSet1 = statement.executeQuery("SELECT id FROM status WHERE status.name = '" + status + "'");
                if (resultSet1.next()) {
                    s = resultSet1.getString(1);
                    //  JOptionPane.showMessageDialog(null, resultSet.getString(1));
                }

                ResultSet resultSet = statement.executeQuery("SELECT o.id, o.town,  o.representation, o.route,  a.name AS address, g.name AS goods, c.name AS client, t.name AS transport, st.name AS store, s.name AS status  " +
                        "FROM orders o INNER JOIN addresses a ON o.address = a.id INNER JOIN goods g ON o.goods = g.id INNER JOIN clients c ON o.client = c.id  INNER JOIN transport t ON o.transport = t.id  " +
                        " INNER JOIN stores st ON o.store = st.id INNER JOIN status s ON o.status = s.id WHERE o.status = " + s + " ");
                while (resultSet.next()) {

                    Logistic log = new Logistic();
                    log.setId(resultSet.getInt("id"));
                    log.setTown(resultSet.getString("town"));
                    log.setRepresentation(resultSet.getString("representation"));
                    log.setRoute(resultSet.getString("route"));
                    log.setAddress(resultSet.getString("address"));
                    log.setGood(resultSet.getString("goods"));
                    log.setClient(resultSet.getString("client"));
                    log.setTransport(resultSet.getString("transport"));
                    log.setStore(resultSet.getString("store"));
                    log.setStatus(resultSet.getString("status"));

                    logistics.add(log);
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            return logistics;
        }


    public  static ArrayList<Logistic> sort(Statement statement) {


        ArrayList <Logistic> logistics = new ArrayList <Logistic>();
        try{



            ResultSet resultSet = statement.executeQuery("SELECT o.id, o.town,  o.representation, o.route,  a.name AS address, g.name AS goods, c.name AS client, t.name AS transport, st.name AS store, s.name AS status  " +
                    "FROM orders o INNER JOIN addresses a ON o.address = a.id INNER JOIN goods g ON o.goods = g.id INNER JOIN clients c ON o.client = c.id  INNER JOIN transport t ON o.transport = t.id  " +
                    " INNER JOIN stores st ON o.store = st.id INNER JOIN status s ON o.status = s.id ORDER BY o.id DESC");
            while(resultSet.next()){

                Logistic log = new Logistic();
                log.setId(resultSet.getInt("id"));
                log.setTown(resultSet.getString("town"));
                log.setRepresentation(resultSet.getString("representation"));
                log.setRoute(resultSet.getString("route"));
                log.setAddress(resultSet.getString("address"));
                log.setGood(resultSet.getString("goods"));
                log.setClient(resultSet.getString("client"));
                log.setTransport(resultSet.getString("transport"));
                log.setStore(resultSet.getString("store"));
                log.setStatus(resultSet.getString("status"));

                logistics.add(log);
            }
        }


        catch(Exception ex){
            System.out.println(ex);
        }
        return logistics;
    }

    public  static ArrayList<String> selectStatus(Statement statement) {

        ArrayList <String> status = new ArrayList <String>();
        try{

            ResultSet resultSet = statement.executeQuery("SELECT status.name from status");
            while(resultSet.next()){

               status.add(resultSet.getString("name"));
            }
        }


        catch(Exception ex){
            System.out.println(ex);
        }
        return status;
    }

    public  static ArrayList<Logistic> selectSBytatus(Statement statement, String status)  {


        ArrayList <Logistic> logistics = new ArrayList <Logistic>();
        try{



            ResultSet resultSet = statement.executeQuery("SELECT o.id, o.town,  o.representation, o.route,  a.name AS address, g.name AS goods, c.name AS client, t.name AS transport, st.name AS store, s.name AS status  " +
                    "FROM orders o INNER JOIN addresses a ON o.address = a.id INNER JOIN goods g ON o.goods = g.id INNER JOIN clients c ON o.client = c.id  INNER JOIN transport t ON o.transport = t.id  " +
                    " INNER JOIN stores st ON o.store = st.id INNER JOIN status s ON o.status = s.id WHERE o.status = " + status);
            while(resultSet.next()){

                Logistic log = new Logistic();
                log.setId(resultSet.getInt("id"));
                log.setTown(resultSet.getString("town"));
                log.setRepresentation(resultSet.getString("representation"));
                log.setRoute(resultSet.getString("route"));
                log.setAddress(resultSet.getString("address"));
                log.setGood(resultSet.getString("goods"));
                log.setClient(resultSet.getString("client"));
                log.setTransport(resultSet.getString("transport"));
                log.setStore(resultSet.getString("store"));
                log.setStatus(resultSet.getString("status"));

                logistics.add(log);
            }
        }


        catch(Exception ex){
            System.out.println(ex);
        }
        return logistics;
    }


    public  static ArrayList<Logistic> selectById(Statement statement, Integer id)  {


        ArrayList <Logistic> logistics = new ArrayList <Logistic>();
        try{



            ResultSet resultSet = statement.executeQuery("SELECT o.id, o.town,  o.representation, o.route,  a.name AS address, g.name AS goods, c.name AS client, t.name AS transport, st.name AS store, s.name AS status  " +
                    "FROM orders o INNER JOIN addresses a ON o.address = a.id INNER JOIN goods g ON o.goods = g.id INNER JOIN clients c ON o.client = c.id  INNER JOIN transport t ON o.transport = t.id  " +
                    " INNER JOIN stores st ON o.store = st.id INNER JOIN status s ON o.status = s.id WHERE o.id = " + id);
            while(resultSet.next()){

                Logistic log = new Logistic();
                log.setId(resultSet.getInt("id"));
                log.setTown(resultSet.getString("town"));
                log.setRepresentation(resultSet.getString("representation"));
                log.setRoute(resultSet.getString("route"));
                log.setAddress(resultSet.getString("address"));
                log.setGood(resultSet.getString("goods"));
                log.setClient(resultSet.getString("client"));
                log.setTransport(resultSet.getString("transport"));
                log.setStore(resultSet.getString("store"));
                log.setStatus(resultSet.getString("status"));

                logistics.add(log);
            }
            System.out.println(logistics.size());
        }


        catch(Exception ex){
            System.out.println(ex);
        }
        return logistics;
    }

    public static void   DeleteById(Statement statement, Integer id)  {


        try {

            statement.executeUpdate("DELETE FROM orders WHERE orders.id = " + id);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

