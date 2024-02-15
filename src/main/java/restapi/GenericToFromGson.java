package restapi;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.assertThat;

public class GenericToFromGson {

    private static Gson gson = new Gson();

    /*Utility method to convert object to json string
    * object - Dynamic DTO object
    * Usage :
    * jsonString = Helper.convertDTOToJson(restrictedCallValidationResponse);
    */
    public static String convertDTOToJson(Object object) {
        try {
            return gson.toJson(object);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    /*Utility method to convert json input to dto object
    * json - The input json as String
    * Type -  Dynamic Type
    * Usage : Type lstGrps = new TypeToken<ArrayList<ListeningGroup>>(){}.getType();
    * lstGroups = (List<ListeningGroup>)Helper.convertJsonToDTO(response.getResponseBody(),lstGrps);
    */
    public static Object convertJsonToDTO(String json , Type type){
        Object containerObject = null;
        containerObject = gson.fromJson(json, type);
        return containerObject;
    }


    /*Utility method to convert json input to dto object
    * json - The input json as String
    * containterClassName -  class name of the dto
    * Usage : listeningExternalDTO = (ListeningExternalDTO)Helper.convertJsonToDTO(json, ListeningExternalDTO.class.getCanonicalName());
    */
    public static Object convertJsonToDTO(String json , String dtoClassName) throws ClassNotFoundException {

        Object containerObject = null;
        containerObject = gson.fromJson(json, Class.forName(dtoClassName).getClass());
        return containerObject;
    }
}
