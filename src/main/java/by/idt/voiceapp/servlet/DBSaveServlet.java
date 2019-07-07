package by.idt.voiceapp.servlet;

import by.idt.voiceapp.bean.User;
import by.idt.voiceapp.dao.impl.MySQLConnector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DBSaveServlet", urlPatterns = {"/DBSaveServlet"})
public class DBSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        /*String data = "Hello World!";
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(data);*/
        System.out.println(1);
        MySQLConnector connector = new MySQLConnector();
        System.out.println(2);
        User user = new User();
        System.out.println(3);
        String text = request.getReader().readLine();
        System.out.println(text);
        int index = text.indexOf("true");
        System.out.println(index + "!!!");
        boolean status = false;
        if(index > -1)
            status = true;
        user.setFullName(text);
        user.setId(user.hashCode());
        int code = connector.save(user, status);
        //response.getWriter().print(user.getId() + " " + user.getFullName());
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException {

    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
