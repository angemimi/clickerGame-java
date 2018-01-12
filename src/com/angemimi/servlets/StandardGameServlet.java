package com.angemimi.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.angemimi.classes.Game;
import com.angemimi.classes.Player;
import com.angemimi.classes.StandardGame;
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
		HttpSession session = request.getSession();
		String uuid = request.getParameter("playerId");
		UUID playerId = null;
		if(uuid != null){
			playerId = UUID.fromString(request.getParameter("playerId"));
		}
		String name = request.getParameter("name");
		Player player;
		request.setAttribute("pageName", "standardPlay");
		if(playerId == null){
//			 Création de l'utilisateur
			player = new Player(name);
			// Ajout de l'utilisateur à la variable static contenant tous les utilisateurs
			player.create(player, "standard", 0);
			//Enregistrement de l'utilisateur dans une variable de session
			request.setAttribute("playerId", player.getId());
		} else {
			// Recherche de l'utilisateur courrant
			player = new Player().retrieve(playerId);
			new Game().deleteToData(player.getPlayGame()); // Suppression de la précédente partie
			Game game = new StandardGame();
			player.setPlayGame(game);
			player.getGames().add(game);
			request.setAttribute("playerId", playerId);
		}
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
