package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculadoraServlet", urlPatterns = { "/calculadora" })
public class CalculadoraServlet extends HttpServlet {
    private int resultado(int A, char op, int B) {
        switch (op) {
            case '+': {
                return A + B;
            }
            case '-': {
                return A - B;
            }
            case '*': {
                return A * B;
            }
            default:
                return A / B;
        }
    }

protected void processRequest(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
String paramA = request.getParameter("a");
int A = Integer.parseInt(paramA);
char op = request.getParameter("op").charAt(0);
String paramB = request.getParameter("b");
int B = Integer.parseInt(paramB);
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("\t<head>");
out.println("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
out.println("\t\t<title>Calculadora</title>");
out.println("\t\t<link rel=\"stylesheet\" type=\"text/css\"href=\"estilo.css\">");
out.println("\t</head>");
out.println("\t<body>");
out.println("\t\t<table border=\"1\">");
out.println("\t\t\t<thead>");
out.println("\t\t\t\t<tr>");
out.println("\t\t\t\t\t<th>A</th>");
out.println("\t\t\t\t\t<th>Op</th>");
out.println("\t\t\t\t\t<th>B</th>");
out.println("\t\t\t\t\t<th>resultado</th>");
out.println("\t\t\t\t</tr>");
out.println("\t\t\t</thead>");

out.println("\t\t\t<tbody>");
out.println("\t\t\t\t<tr>");
out.println("\t\t\t\t\t<td>" + paramA +"</td>");
out.println("\t\t\t\t\t<td>" + op + "</td>");
out.println("\t\t\t\t\t<td>" + paramB + "</td>");
out.println("\t\t\t\t\t<td>" + resultado(A, op, B) + "</td>");
out.println("\t\t\t\t</tr>");
out.println("\t\t\t</tbody>");
out.println("\t\t</table>");
out.println("\t</body>");
out.println("</html>");
}
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
