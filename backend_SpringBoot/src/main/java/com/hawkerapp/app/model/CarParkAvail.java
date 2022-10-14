package com.hawkerapp.app.model;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;

public class CarParkAvail {
    private static Map<String, CarParkData> carparkCurrentInfo = new HashMap<>();

    public CarParkAvail() {
    }

    public static void updateInfo(String carparkNumber, CarParkData currentCarparkData){
        carparkCurrentInfo.put(carparkNumber, currentCarparkData);
    }

    public static Map<String, CarParkData> getCarParkInfo(List<String> nearbyCarparks){
        CarParkFlattener();
        Map<String, CarParkData> carParkDataList = new HashMap<>();
        for (String carparkNumber : nearbyCarparks){
            CarParkData carParkInfo = carparkCurrentInfo.get(carparkNumber);
            carParkDataList.put(carparkNumber, carParkInfo);
        }
        return carParkDataList;
    }

    public static void CarParkFlattener(){
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

            Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());

            for (int i=0;i<1963;i++){
                CarParkData currentCarparkData = new CarParkData(Integer.parseInt((String)flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_info[0].lots_available")),
                        Integer.parseInt((String)flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_info[0].total_lots")),
                        ((String)flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_info[0].lot_type")).charAt(0));
                CarParkAvail.updateInfo((String) flattenedJsonMap.get("items[0].carpark_data["+i+"].carpark_number"), currentCarparkData);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
