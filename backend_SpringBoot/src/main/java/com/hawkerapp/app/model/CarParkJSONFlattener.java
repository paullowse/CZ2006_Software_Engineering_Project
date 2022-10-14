package com.hawkerapp.app.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class CarParkJSONFlattener {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {

            String callString = "https://api.data.gov.sg/v1/transport/carpark-availability";

            Client client = Client.create();
            WebResource webResource = client.resource(callString);

            ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
            if (clientResponse.getStatus() != 200) {
                throw new RuntimeException("Failed"+ clientResponse.toString());
            }

            JSONObject jsonObject = (JSONObject)new JSONParser().parse(clientResponse.getEntity(String.class));

            // JsonFlattener: A Java utility used to FLATTEN nested JSON objects
            // The String class represents character strings. All string literals in Java programs, such as "abc", are implemented as instances of this class.
            String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
            log("\n========== Simple Flatten ========== \n" + flattenedJson);


            Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());

            log("\n=====Flatten As Map=====\n" + flattenedJson);

            // We are using Java8 forEach loop. More info: http://crunchify.me/1VIwm0l
            flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));
            System.out.println(flattenedJsonMap.get("items[0].carpark_data[807].carpark_info[0].total_lots")); //how to access specific attributes

            CarParkAvail carParkAvail = new CarParkAvail();
            for (int i=0;i<1963;i++){
                CarParkData currentCarparkData = new CarParkData(Integer.parseInt((String)flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_info[0].lots_available")),
                        Integer.parseInt((String)flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_info[0].total_lots")),
                        ((String)flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_info[0].lot_type")).charAt(0));
                carParkAvail.updateInfo((String) flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_number"), currentCarparkData);

            }
            List<String> messages = Arrays.asList("W106", "CK53", "SK51", "TM21");
            Map<String, CarParkData> nearbyCarparkInfo = CarParkAvail.getCarParkInfo(messages);
            for(Map.Entry<String,CarParkData> set: nearbyCarparkInfo.entrySet()){
                System.out.println("Carpark Number: " + set.getKey());
                System.out.println("\tLots Available: "+set.getValue().getLotsAvailable());
                System.out.println("\tTotal Lots: "+set.getValue().getTotalLots());
                System.out.println("\tLot Type: "+set.getValue().getLotType());
            }


            // Unflatten it back to original JSON
            //String nestedJson = JsonUnflattener.unflatten(flattenedJson);
            //System.out.println("\n===== Unflatten it back to original JSON ===== \n" + nestedJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void log(String flattenedJson) {
        System.out.println(flattenedJson);

    }
}
