package GSMPartner;


import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
//import org.json.simple.JSONObject;
//import net.minidev.json.JSONUtil;


import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Created by schaud3 on 9/7/16.
 */

public class CreatePartner {
    private static JacksonJaxbJsonProvider provider1;
    public static Map<String,String>baseUrl;
    static{
        baseUrl = new HashMap<String, String>();
        baseUrl.put("qa","http://qa.mpmantle.catdev.walmart.com/mantle-app/api/api/");
        baseUrl.put("stg","https://stg.mpmantle.catdev.walmart.com/mantle-app/api/api/");
        baseUrl.put("local","http://localhost:8070/mantle-app/api/api/");
    }
    public static void main(String[] args){

        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/schaud3/Documents/personal/Experiments/src/main/resources/dummy_supplier.xml")));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] encodedVal = Base64.getEncoder().encode(stringBuilder.toString().getBytes());
        String val = new String(encodedVal);
        val = "{\"payload\":\""+val+"\"}";
        System.out.println(val);
        String env="stg";
        String partnerStore = baseUrl.get(env)+"populate-supplier/populate";
        String bassJob=baseUrl.get(env)+"job/pending-suppliers-poller/run";

        provider1 = new JacksonJaxbJsonProvider();
        JAXRSClientFactoryBean bean = new JAXRSClientFactoryBean();

        bean.setAddress(partnerStore);
        bean.setHeaders(buildHeaderMantle());
        bean.setProvider(provider1);
        WebClient webClient = bean.createWebClient();
        //RestClient webClient = restClient.getRestClient(url, buildHeader());
        webClient.accept("application/json");
        webClient.type("application/json");

        Response response = webClient.put(val);
        if(response.getStatus()==200){
            System.out.println("Partner successfully stored in database");
            bean.setAddress(bassJob);
            webClient=bean.createWebClient();
            response = webClient.post("{\n" +
                    "  \"payload\":{\n" +
                    "    \"variables\":{\n" +
                    "    }\n" +
                    "  }\n" +
                    "}");
            System.out.println("response is "+response.toString());
        }else{
            System.out.println("Something went wrong");
        }


    }
    public static Map<String,String> buildHeaderVows(){
        Map<String,String> header = new HashMap<String, String>();
        header.put("WM_SVC.NAME","DSVOnboarding");
        header.put("WM_SVC.ENV","stg");
        header.put("WM_SVC.VERSION","1.0.0");
        header.put("WM_CONSUMER.ID","d2f1cd78-cd92-435b-af02-1bddc7acb6f1");
        header.put("WM_QOS.CORRELATION_ID","123");
        header.put("WM_AUTH.PRINCIPAL","2fc464de-95a8-4f62-b487-f9759aca16be");
        header.put("WM_AUTH.REALM","e8a571c2-bb35-4ab0-8550-f42c8e985d4b");
        return header;
    }
    public static Map<String,String> buildHeaderMantle(){
        Map<String,String> header = new HashMap<String, String>();
        header.put("WM_SVC.NAME","mantle-app");
        header.put("WM_SVC.ENV","stg");
        header.put("WM_SVC.VERSION","2.0.0");
        header.put("WM_CONSUMER.ID","d2f1cd78-cd92-435b-af02-1bddc7acb6f1");
        header.put("WM_QOS.CORRELATION_ID","123");
        header.put("WM_BU_ID","0");
        header.put("WM_MART_ID","0");
        header.put("WM_CONSUMER.USER","retaillink");
        header.put("WM_PARTNER.ROLE","SELLER");
        header.put("Content-Type","application/json");
        return header;
    }
}

