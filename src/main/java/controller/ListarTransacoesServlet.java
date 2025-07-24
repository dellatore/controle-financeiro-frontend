package controller;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Transacao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@WebServlet("/index")
public class ListarTransacoesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        URL url = new URL("http://localhost:8081/controle-financeiro-dsw2/transacoes");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(conn.getInputStream());
        List<Transacao> transacoes = new Gson().fromJson(reader, new TypeToken<List<Transacao>>(){}.getType());

        request.setAttribute("transacoes", transacoes);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    
}
