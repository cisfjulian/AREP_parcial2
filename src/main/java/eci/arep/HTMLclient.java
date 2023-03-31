package eci.arep;

import static spark.Spark.get;
import static spark.Spark.port;

public class HTMLclient {

    public static void main(String... args){
        port(getPort());


        get("collatzsequence", (req,res) -> {
            int k = Integer.parseInt(req.queryParams("value"));
            return ("{\"operation\": \"collatzsequence\", \"input\": " + k + ", \"output\": \"" + Collatz.sequence(k) + "\"}");
        });
        get("/", (req,res) -> html());
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;

    }

    private static String html(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Form Example</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>Collatz Sequence</h1>\n" +
                "        <form action=\"/hello\">\n" +
                "            <label for=\"name\">Number:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"13\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "        </form> \n" +
                "        <br>" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/collatzsequence?value=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";
    }
}
