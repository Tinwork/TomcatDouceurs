/**
 * Created by lookitsmarc on 21/03/2017.
 */
package helper;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;

public class helper {

    protected static PrintWriter log;

    /**
     * GetHttpData
     * @param req
     * @param params
     * @return
     */
    public static HashMap getHttpData(javax.servlet.http.HttpServletRequest req, String[] params) {
        // Create a map
        HashMap<String, String> httpData = new HashMap<String, String>();

        for(int i = 0; i < params.length; i++){
            httpData.put(params[i], req.getParameter(params[i]));
        }

        return httpData;
    }

    /**
     * Logger
     * @param text
     */
    public static void logger(String text, javax.servlet.http.HttpServletResponse resp){
        try {
            // log on the error into the body
            resp.getWriter().write(text);
        } catch (Exception e) {
            // if it fails print on the logs
            System.out.println(e.getMessage());
        }
    }

    /**
     * GetMapData
     * @param data
     * @param key
     * @return
     */
    public static String getMapData(HashMap<String, String> data, String key){

        String dataToReturn = "";

        for(HashMap.Entry<String, String> entry : data.entrySet()){
            if (Objects.equals(key, entry.getKey())){
                dataToReturn = entry.getValue();
            }
        }

        return dataToReturn;
    }

}
