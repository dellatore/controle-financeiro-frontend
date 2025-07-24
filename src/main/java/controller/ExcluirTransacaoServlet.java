package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/excluir")
public class ExcluirTransacaoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("ID a deletar: " + id);

        URL url = new URL("http://localhost:8081/controle-financeiro-dsw2/transacoes/" + id);
        System.out.println("URL para DELETE: " + url);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setDoOutput(false);
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        int responseCode = conn.getResponseCode();
        System.out.println("Código HTTP da resposta DELETE: " + responseCode);

        try (InputStream is = (responseCode >= 200 && responseCode < 400) 
                ? conn.getInputStream() 
                : conn.getErrorStream()) {
            if (is != null) {
                byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }

        response.sendRedirect(request.getContextPath() + "/index");
    }
}

