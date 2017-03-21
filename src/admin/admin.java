package admin;

/**
 * Created by lookitsmarc on 21/03/2017.
 */
import helper.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;


public class admin extends HttpServlet{

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        // Get the post params
        String[] paramsWanted = {"username","password"};
        HashMap<String, String> data = helper.getHttpData(req, paramsWanted);

        // Now we need to check whenever the user is in the db
        db Database = new db("jdbc:mysql://127.0.0.1:3306/people", resp);
        Database.doConnection();

        // Insert a user
        Boolean success = Database.insert(data);

        if (success) {
            req.setAttribute("name", helper.getMapData(data, "username"));
            this.getServletContext().getRequestDispatcher("/template/success.jsp").forward(req, resp);
        }
    }
}
