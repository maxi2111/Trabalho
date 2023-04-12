/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Produto;

/**
 *
 * @author prampero
 */
@WebServlet(name = "MostrarCarrinho", urlPatterns = {"/MostrarCarrinho"})
public class MostrarCarrinho extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sessao;
        ArrayList<Produto> lista;
        int pos=-1;
        double total =0;
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Comprar</title>");            
            out.println("</head>");
            out.println("<body>");
            sessao = request.getSession(true);
            lista=(ArrayList<Produto>)sessao.getAttribute("carrinho");
            if((lista!=null) && (lista.size()>0)){
                 out.println("<h1> Carrinho de Compras </h1>");  
               for(Produto aux : lista){  // percorre os elementos da lista
                 pos++;
                 total = total + aux.getPreco()*aux.getQtde();
                 out.println("<form action='Controlador' method='post' >");  
                 out.println("<input type='text' name='txtPos' value='"+pos+"' hidden >"); 
                 out.println("<img src='imagem/"+aux.getImagem()+"'  width='100' />");  
                 out.println("Quantidade : <input type='text'name='txtQtde' value='"+aux.getQtde()+"' size='4' readonly />" );  
                 out.println("Total : R$ "+(aux.getPreco()*aux.getQtde()));  
                 out.println("<input type='submit' name='b1' value='Remover' />");  
                 out.println("</form>");  
               }
               out.println("<h1> Total = R$ "+total+"</h1>");
               out.println("<form action='Controlador' method='post' >");
               out.println("<input type='submit' name='b1' value='Finalizar'>");
               out.println("</form>");
               
            }
            else
                out.println("<h1> Carrinho Vazio!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception ex){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Comprar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro:  " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
