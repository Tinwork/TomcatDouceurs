/**
 * Created by lookitsmarc on 21/03/2017.
 */
package helper;

import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;

public class helper {

    public static Map getHttpData(javax.servlet.http.HttpServletRequest req, String[] params) {
        // Create a map
        Map<String, String> httpData = new HashMap<String, String>();

        for(int i = 0; i < params.length; i++){
            httpData.put(params[i], req.getParameter(params[i]));
        }

        return httpData;
    }
}
