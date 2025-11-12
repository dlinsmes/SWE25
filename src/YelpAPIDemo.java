import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

//external library - not built in through java
//file-project structure-libraries-+ From Maven- org.json
import org.json.*;

public class YelpAPIDemo {

    //API - application programming interface
    //-interact with resources and data provided by other
    // programs or websites

    public static void main(String [] args) {

        try {

            //api key to authenticate access to the yelp api
            String API_KEY = "";

            HttpClient client = HttpClient.newHttpClient();

            String term = "taco";
            String location = "irvine";

            //meters
            int radius = 5000;

            //need try/catch to handle a bad URI error
            //form the search uri with various parameters
            URI uri = new URI("https://api.yelp.com/v3/businesses/search?"
                                + "term=" + term
                                + "&location=" + location
                                + "&radius=" + radius);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("authorization", "Bearer " + API_KEY)
                    .build();

            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            System.out.println(response);

            System.out.println(response.body());

            //the response body is JSON object
            //javascript object notation

            JSONObject responseObject = new JSONObject(response.body());
            System.out.println(responseObject);

            //keys are the labels for each piece of data
            System.out.println(responseObject.keySet());

            //total is an int
            int total = responseObject.getInt("total");
            System.out.println(total);

            //region is an object - printout has curly braces
            JSONObject region = responseObject.getJSONObject("region");
            System.out.println(region);

            //isolate and save latitude as a double
            //JSONObjects can store other JSONObjects
            JSONObject center = region.getJSONObject("center");
            System.out.println(center);
            double lat = center.getDouble("latitude");
            System.out.println(lat);

            //can string together multiple function calls to get the same data
            double lat2 = responseObject.getJSONObject("region").getJSONObject("center").getDouble("latitude");
            System.out.println(lat2);

            //businesses is an array - square brackets in the printout
            JSONArray bArray = responseObject.getJSONArray("businesses");
            System.out.println(bArray);

            //the response gives 20 results at a time even though there are 447 total
            System.out.println(bArray.length());

            //get the result at index 0 from the array
            System.out.println(bArray.get(0));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
