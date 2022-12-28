
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class server_requests {
    public static String getAllSimulationElements() {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .header("Accept", "application/json")
                    .GET()
                    .uri(URI.create("http://localhost:7410/api/tags/"))
                    .build();


            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new Exception("Server response code: " + response.statusCode());
            }

            return response.body();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static String getElement(String elementName) {

        String url = "http://localhost:7410/api/tags/by-name/" + elementName;
        url = url.replaceAll(" ", "%20");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .header("Accept", "application/json")
                    .GET()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static String setElement(String jsonString) {
        String url = "http://localhost:7410/api/tag/values/by-name/";

        System.out.println("Server requests: " + jsonString);
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .header("Accept", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonString))
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}

