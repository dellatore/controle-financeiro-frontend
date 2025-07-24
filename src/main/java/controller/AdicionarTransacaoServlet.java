package controller;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Transacao;
import model.TransacaoJson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/adicionar")
public class AdicionarTransacaoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TransacaoJson nova = new TransacaoJson();
        nova.descricao = request.getParameter("descricao");
        nova.valor = Double.parseDouble(request.getParameter("valor"));
        nova.tipo = request.getParameter("tipo");
        nova.categoria = request.getParameter("categoria");
        nova.data = request.getParameter("data");

        String json = new Gson().toJson(nova);
        System.out.println("Enviando JSON: " + json);

        URL url = new URL("http://localhost:8081/controle-financeiro-dsw2/transacoes");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(json.getBytes("UTF-8"));
            os.flush();
        }

        int status = conn.getResponseCode();
        System.out.println("Status resposta: " + status);

        response.sendRedirect(request.getContextPath() + "/index");
    }

   
}
