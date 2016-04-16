package myservlet.io.impl;

import myservlet.io.IOServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ray on 2015-09-01.
 */
@WebServlet(urlPatterns = "/BlockingServlet")
public class BlockingServlet extends IOServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String responseString;

            try {
                responseString = callBizWork();
            } catch (Exception e) {
                throw e;
            }

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            try {
                response.getWriter().println("HELLO, " + responseString);
            } catch (IOException e) {
                throw e;
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
