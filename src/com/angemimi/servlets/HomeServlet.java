package com.angemimi.servlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angemimi.classes.Game;
import com.angemimi.classes.Player;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet({"/home"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uuid = request.getParameter("playerId");
		UUID playerId = null;
		if(uuid != null){
			playerId = UUID.fromString(request.getParameter("playerId"));

		}
		if(playerId != null){
			 request.setAttribute("playerId",playerId);
				new Game().deleteToData(new Player().retrieve(playerId).getPlayGame());

		}
	
		request.setAttribute("pageName", "home");
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
