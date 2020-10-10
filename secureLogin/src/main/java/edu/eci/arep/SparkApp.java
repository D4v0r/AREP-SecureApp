package edu.eci.arep;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class SparkApp
{
    public static void main(String[] args) {
        port(getPort());
        secure("keystores/ecikeystore.p12", "ecistore2", "keystore/trustStore", "ecistore");

        before(((request, response) -> {
            boolean authenticated = request.session().attribute("Loged");

            if(!authenticated){
                halt(401, "you not welcome here");
            }
        }));
        get("/hello", (req, res) -> "Hello Heroku");
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
