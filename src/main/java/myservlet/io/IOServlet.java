package myservlet.io;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.concurrent.Future;

/**
 * Created by ray on 2015-08-26.
 */
public abstract class IOServlet extends HttpServlet {

    protected String callBizWork() throws Exception {

        String responseString = null;

        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();

        try {

            httpclient.start();
            HttpGet request = new HttpGet("http://localhost:8080/WorkServlet");
            Future<HttpResponse> future = httpclient.execute(request, null);
            HttpResponse response = future.get();

            responseString = response.getEntity().getContent().toString();

        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

        return responseString;
    }

}
