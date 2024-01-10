package dev;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;    
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {

    public ArticlesServlet() throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> Articles = new ArrayList<>();

        // "mysql-bdd" ici représente le nom (--name) du conteneur de la base de données MySQL
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-bdd:3306/articles_bdd", "root", "root");
             PreparedStatement ps = connection.prepareStatement("select * from articles");
             ResultSet rs = ps.executeQuery()) {


            while (rs.next()) {
                String nom = rs.getString("libelle");
                Articles.add(nom);
            }

            resp.getWriter().write(Articles.toString());


        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("libelle");

        // "mysql-bdd" ici représente le nom (--name) du conteneur de la base de données MySQL
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-bdd:3306/articles_bdd", "root", "root");
             PreparedStatement ps = connection.prepareStatement("insert into articles(libelle) values(?)")) {

            ps.setString(1, nom);

            int nbLignesInserees = ps.executeUpdate();


            resp.getWriter().write(nbLignesInserees + " lignes insérées");


        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write(e.getMessage());
        }


    }
}
