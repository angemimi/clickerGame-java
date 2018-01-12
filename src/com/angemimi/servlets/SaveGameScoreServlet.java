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

/**
 * Servlet implementation class SaveGameScoreServlet
 */
@WebServlet("/saveGame")
public class SaveGameScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveGameScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int score = Integer.parseInt(request.getParameter("score"));
		int pieces = Integer.parseInt(request.getParameter("pieces"));
		int diams = Integer.parseInt(request.getParameter("diams"));
		UUID idPlayer = UUID.fromString(request.getParameter("idPlayer"));
		Player player = new Player().retrieve(idPlayer);
		player.getPlayGame().setScore(score);
		player.getPlayGame().setNbPiece(pieces);
		player.getPlayGame().setNbDiamond(diams);
		if(player.getHigthScore() < score){
			player.setHigthScore(score);
		}
		player.updateToData(player);
//		player.getPlayGame().updateToData(player.getPlayGame());
		HttpSession session = request.getSession();
		session.setAttribute("player"+player.getId(), player);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
