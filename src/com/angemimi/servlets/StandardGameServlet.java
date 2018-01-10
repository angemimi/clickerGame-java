package com.angemimi.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.angemimi.classes.Player;
import com.angemimi.datas.Data;

/**
 * Servlet implementation class StandardGameServlet
 */
@WebServlet({"/standardGame", "/standardPlay"})
public class StandardGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StandardGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération du nom d'utilisateur saisie
		String name = request.getParameter("name");
		// Création de l'utilisateur
		Player player = new Player(name);
		// Ajout de l'utilisateur à la variable static contenant tous les utilisateurs
		player.create(player, "standard", 0);
		request.setAttribute("playerId", player.getId());
		request.setAttribute("pageName", "standardPlay");
		HttpSession session = request.getSession();
		
		//Enregistrement de l'utilisateur dans une variable de session
		session.setAttribute("player"+player.getId(), player);
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
