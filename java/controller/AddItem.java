package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VoceLista;
import model.VoceListaDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/addItem.jsp"})
public class AddItem extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (!req.getParameter("voce").isBlank())
			VoceListaDAO.addItem(
				new VoceLista(0, req.getParameter("voce").trim())
			);
		res.sendRedirect("./");
	}
}