package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonUtils {

    /*private static final String name = "name";
    private static final String mainName = "mainName";
    private static final String place_of_origin = "placeOfOrigin";
    private static final String ingredients = "ingredients";
    private static final String description = "description";
    private static final String also_known_as = "alsoKnownAs";
    private static final String image = "image";*/


    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();



        try {
            JSONObject object = new JSONObject(json);

           //JSONObject name = object.getJSONObject("name");

           // String mainName = object.getJSONObject("name").getString("mainName");

            sandwich.setMainName(object.getJSONObject("name").getString("mainName"));


            ArrayList<String> listKnownAs = new ArrayList<String>();

            JSONArray arrKnownAs = object.getJSONObject("name").getJSONArray("alsoKnownAs");
            if (arrKnownAs != null) {
                for (int i = 0; i < arrKnownAs.length(); i++) {
                    listKnownAs.add(arrKnownAs.getString(i));
                }

            }
            sandwich.setAlsoKnownAs(listKnownAs);



            sandwich.setPlaceOfOrigin(object.getString("placeOfOrigin"));



            sandwich.setDescription(object.getString("description"));


            sandwich.setImage(object.getString("image"));




            ArrayList<String> listIngredients = new ArrayList<>();

            JSONArray arringridients = object.getJSONArray("ingredients");
            for (int i = 0; i < arringridients.length(); i++) {
                listIngredients.add(arringridients.getString(i));
            }
            sandwich.setIngredients(listIngredients);



        } catch (JSONException e) {

            System.out.println("Failure to Parse JSON");
        }

        return sandwich;
    }
}



