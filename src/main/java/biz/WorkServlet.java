package biz;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by ray on 2015-08-26.
 */
@WebServlet(urlPatterns = "/WorkServlet")
public class WorkServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {

            long start = System.currentTimeMillis();
            Thread.sleep(1000);
            String name = Thread.currentThread().getName();
            long duration = System.currentTimeMillis() - start;
            response.getWriter().printf("Thread %s completed the task in %d ms.", name, duration);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
