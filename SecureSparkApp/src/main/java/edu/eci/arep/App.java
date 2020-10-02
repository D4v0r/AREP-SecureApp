package edu.eci.arep;
import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        port(5000);
        secure("ecikeystore.p12", "ecistore", null, null);
        get("/hello", (req, res) -> "Hello World");
    }
}
