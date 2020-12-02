package project.back.back.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Classe permettant de récupérer les informations de notre système grâce à
 * Spring Actuactor et Health
 *
 */
    @RestController
    public class HealthSystemController {

        public static void main(String []args) throws IOException {

            HealthSystemController st = new HealthSystemController();
            System.out.println(st.getHealth());
            System.out.println(st.getDbHealth());
            System.out.println(st.getJvmHealth());
        }

        //Information relative à la santé de l'application : Up ou Down

        public String getHealth() throws IOException {
            String result = new String();
            URL url = new URL("http://localhost:8080/actuator/health");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.getResponseCode();

            Scanner scan = new Scanner(url.openStream());
            String str = new String();
            while (scan.hasNext())
                str += scan.nextLine();
            scan.close();

            return "Status de l'application "+ str;

        }


        //Information loquace sur l'état du pool JDBC
        public String getDbHealth() throws  IOException {

            String dbHealth = new String();
            java.net.URL urlDb = new URL("http://localhost:8080/actuator/metrics/jdbc.connections.active");
            HttpURLConnection conn = (HttpURLConnection) urlDb.openConnection();
            conn.getResponseCode();
            Scanner scan = new Scanner(urlDb.openStream());
            String str = new String();
            while (scan.hasNext())
                str += scan.nextLine();
            scan.close();

            return str;
        }

        //Information loquace sur la JVM

        public String getJvmHealth() throws IOException {

            String jvmHealth = new String();
            java.net.URL urlJvm = new URL("http://localhost:8080/actuator/metrics/jvm.gc.live.data.size");
            HttpURLConnection conn = (HttpURLConnection) urlJvm.openConnection();
            conn.getResponseCode();
            Scanner scan = new Scanner(urlJvm.openStream());
            String str = new String();
            while (scan.hasNext())
                str += scan.nextLine();
            scan.close();

            return str;
        }
        }


