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
@WebServlet(urlPatterns = {"/delItem.jsp"})
public class DeleteItem extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (Integer.parseInt(req.getParameter("id").trim()) > 0)
			VoceListaDAO.deleteItem(
				new VoceLista(
					Integer.parseInt(
						req.getParameter("id").trim()
					),
					""
				)
			);
		res.sendRedirect("./");
	}
}