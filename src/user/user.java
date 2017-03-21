/**
 * Created by lookitsmarc on 21/03/2017.
 */
package user;

// Import the JEE dependencies
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import bean.UserBean;
import helper.helper;
import helper.db;

public class user extends HttpServlet{

    /**
     * doPost
     * @param req
     * @param resp
     */
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        // Get the post params
        String[] paramsWanted = {"username","password"};
        HashMap<String, String> data = helper.getHttpData(req, paramsWanted);

        // Now we need to check whenever the user is in the db
        db Database = new db("jdbc:mysql://127.0.0.1:3306/people", resp);
        Database.doConnection();
        Boolean isPresent = Database.selectPerson(data);

        if (isPresent){
            // Set the session data
            UserBean bean = new UserBean();
            bean.setUsername(helper.getMapData(data, "username"));
            bean.setPassword(helper.getMapData(data, "password"));

            // set params to the request
            req.setAttribute("userbean", bean);
            this.getServletContext().getRequestDispatcher("/template/admin.jsp").forward(req, resp);
        } else {
            helper.logger("wrong login", resp);
        }
    }

    /**
     * doGet
     * @param req
     * @param resp
     */
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        // routing
    }
}
