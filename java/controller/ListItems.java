package controller;

import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VoceListaDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/listItems.json"})
public class ListItems extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setCharacterEncoding("utf-8");
		res.getWriter().print(
			new Gson().toJson(
				VoceListaDAO.listItems()
			)
		);
	}
}