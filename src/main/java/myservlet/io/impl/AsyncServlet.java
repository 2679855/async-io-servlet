package myservlet.io.impl;

import myservlet.io.IOServlet;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ray on 2015-08-26.
 */
@WebServlet(urlPatterns = "/AsyncServlet", asyncSupported = true)
public class AsyncServlet extends IOServlet {

    @Override
    protected void doGet(final javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        final AsyncContext asyncContext = request.startAsync();

        new Thread(new Runnable() {

            public void run() {

                String responseString;

                try {
                    responseString = callBizWork();
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage(), e);
                }

                HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");

                try {
                    response.getWriter().println("HELLO, " + responseString);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage(), e);
                }

                asyncContext.complete();
            }
        }).start();
    }

}