package jsonToMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by schaud3 on 10/3/16.
 */
public class jsonToMap {

    public static void main(String[] args) {
//        ObjectMapper mapper = new ObjectMapper();
//
//        Map<String, Object> map = new HashMap();
//
//        // convert JSON string to Map
//        String goLiveQuestion = "{\"user_holiday\":[{\"name\":\"shreejit\"}],\"primary_name\":\"1\",\"primary_title\":\"1\",\"primary_phone\":\"1\",\"primary_phone_ext\":\"1\",\"primary_email\":\"a@a.a\",\"escalation_name\":\"1\",\"escalation_title\":\"1\",\"escalation_phone\":\"1\",\"escalation_phone_ext\":\"1\",\"escalation_email\":\"a@a.a\",\"it_name\":\"1\",\"it_title\":\"1\",\"it_phone\":\"1\",\"it_phone_ext\":\"1\",\"it_email\":\"a@a.a\",\"after_hours_name\":\"1\",\"after_hours_title\":\"1\",\"after_hours_phone\":\"1\",\"after_hours_phone_ext\":\"1\",\"after_hours_email\":\"a@a.a\",\"internal_name\":\"1\",\"internal_title\":\"1\",\"internal_phone\":\"1\",\"internal_phone_ext\":\"1\",\"internal_email\":\"a@a.a\",\"external_phone\":\"1\",\"alarms_name\":\"1\",\"alarms_title\":\"1\",\"alarms_phone\":\"1\",\"alarms_phone_ext\":\"1\",\"alarms_email\":\"a@a.a\",\"alarms_start\":\"0000\",\"alarms_end\":\"0200\",\"proj_ship_wmt\":\"1\",\"proj_peak_wmt\":\"1\",\"returnaddress_address1\":\"sdfdsfh\",\"returnaddress_address2\":\"gjsdfgjsdfhg\",\"returnaddress_city\":\"jhgdsfjhg\",\"returnaddress_country\":\"JE\",\"returncontact_name\":\"jjjjdfs\",\"returncontact_title\":\"1\",\"returncontact_phone\":\"1\",\"returncontact_phone_ext\":\"1\",\"returncontact_email\":\"a@a.a\",\"returnclaim_email\":\"a@a.a\",\"returnclaim_phone\":\"1\",\"weekly_dsv_ap_email\":\"a@a.aq\",\"automated_chargeback_invoice_email\":\"a@a.a\"}";
//        try {
//            map = mapper.readValue(goLiveQuestion, new TypeReference<Map<String, Object>>(){});
//            System.out.println("converted");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String dates="Thu Oct 06 13:59:41 IST 2016";
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date d = null;
        try {
            d = format.parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d);
    }
}
