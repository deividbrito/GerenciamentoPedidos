package controller;

//imports
import controller.command.Command;
import controller.command.LoginCommand;
import controller.command.LogoutCommand;
import controller.command.CadastrarUsuarioCommand;
import controller.command.ManterPedidoCommand;
import controller.command.GerarRelatorioCommand;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response); //encaminha requisições get pra processrequest
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response); //encaminha requisições post pra processrequest
    }

    //processa requisições com base em "action"
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Command command = null;

        //verifica qual a "action" e chama o command necessário
        if (action != null) {
            switch (action) {
                case "login":
                    command = new LoginCommand();
                    break;
                case "logout":
                    command = new LogoutCommand();
                    break;
                case "cadastrarUsuario":
                    command = new CadastrarUsuarioCommand();
                    break;
                case "manterPedido":
                    command = new ManterPedidoCommand();
                    break;
                case "gerarRelatorio":
                    command = new GerarRelatorioCommand();
                    break;
                default:
                    request.setAttribute("erro", "Ação inválida");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
            }
        }

        if (command != null) {
            command.execute(request, response);
        }
    }
}

