// Java program to read JSON from a file

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class jsonReader {
    public static void getSimulationElements(ArrayList<sim_object> out) {

        JSONParser parser = new JSONParser();
        try {
            String result = server_requests.getAllSimulationElements();
            if (result == null)
                throw new Exception("ERROR: Server response is null! ");
            JSONArray a = (JSONArray) parser.parse(result);

            for (Object o : a) {
                JSONObject sim_elem = (JSONObject) o;

                // For now, skip elements of simulation, that is, ignore the
                // elements that contains the substring FACTORY

//                if (sim_elem.get("name").toString().contains("FACTORY"))
//                    continue;

                sim_object new_sim_elem = new sim_object(
                        sim_elem.get("id").toString(),
                        sim_elem.get("name").toString(),
                        Integer.parseInt(sim_elem.get("address").toString()),
                        sim_elem.get("type").toString(),
                        sim_elem.get("kind").toString(),
                        Boolean.parseBoolean(sim_elem.get("value").toString()),
                        Boolean.parseBoolean(sim_elem.get("openCircuit").toString()),
                        Boolean.parseBoolean(sim_elem.get("shortCircuit").toString()),
                        Boolean.parseBoolean(sim_elem.get("isForced").toString()),
                        Boolean.parseBoolean(sim_elem.get("forcedValue").toString()));

                out.add(new_sim_elem);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getElementStatus(String elementName) {

        JSONParser parser = new JSONParser();
        try {
            String result = server_requests.getElement(elementName);
            if (result == null)
                throw new Exception("ERROR: Server response is null! ");
            JSONArray a = (JSONArray) parser.parse(result);

            if (a.size() > 1)
                throw new Exception("ERROR: More than 2 elements detect with the name " + elementName);
            else if (a.size() == 0) {
                throw new Exception("ERROR: None element detect with the name " + elementName);
            }

            JSONObject sim_elem = (JSONObject) a.get(0);
            return sim_elem.get("value").toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void setElement(String elementName, String value) {

        JSONParser parser = new JSONParser();
        try {
            String result = server_requests.getElement(elementName);
            if (result == null)
                throw new Exception("ERROR: Server response is null! ");
            JSONArray a = (JSONArray) parser.parse(result);

            if (a.size() > 1)
                throw new Exception("ERROR: More than 2 elements detect with the name " + elementName);
            else if (a.size() == 0) {
                throw new Exception("ERROR: None element detect with the name " + elementName);
            }

            String jsonStr = " ";
            // Verify the type of the element
            // Can be bit, int, float
            JSONObject sim_elem = (JSONObject) a.get(0);
            String type = sim_elem.get("type").toString();
            type = type.toLowerCase();
            switch (type) {
                case "bit":
                    jsonStr = "[{ \"name\" : \"" + elementName + "\",  \"value\" : " + value + " }]";
                    break;
                case "int":
                    jsonStr = "[{ \"name\" : \"" + elementName + "\",  \" value \" : " + Integer.parseInt(value) + " }]";
                    break;
                case "float":
                    jsonStr = "[ { \"name\" : \"" + elementName + "\",  \" value \" : " + Float.parseFloat(value) + " } ]";
                    break;
                default:
                    break;
            }
//            System.out.println(jsonStr);

            result = server_requests.setElement(jsonStr);
            if (result == null)
                return;
            System.out.println("Server response: " + result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}