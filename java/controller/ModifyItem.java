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
@WebServlet(urlPatterns = {"/modifyItem.jsp"})
public class ModifyItem extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (
			Integer.parseInt(req.getParameter("id").trim()) > 0 &&
			!req.getParameter("voce").isBlank()
		)
			VoceListaDAO.modifyItem(
				new VoceLista(
					Integer.parseInt(
						req.getParameter("id").trim()
					),
					req.getParameter("voce").trim()
				)
			);
		res.sendRedirect("./");
	}
}