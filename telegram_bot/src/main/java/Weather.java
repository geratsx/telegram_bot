import models.Model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;


public class Weather {

    private static final String REQUEST_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String METRIC = "&units=metric";
    private static final String TOKEN_PARM = "&appid=6ea8c9077946dcb086541909044b02e6";
    private static final String LOCALE = "&lang=ru";


    public static String getWeather(String message, Model model) throws IOException {
        URL url = new URL(REQUEST_URL + message + METRIC + TOKEN_PARM + LOCALE);
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        StringBuilder res = new StringBuilder();
        while (in.hasNext()) {
            result += in.next();
        }
        System.out.println(result);
        JSONObject object = new JSONObject(result);
        model.setName(object.getString("name"));
        JSONObject main = object.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));
        JSONArray weather = object.getJSONArray("weather");
        for (int i = 0; i < weather.length(); i++) {
            JSONObject tmp = weather.getJSONObject(i);
            model.setIcon((String) tmp.get("icon"));
            model.setDescription((String) tmp.get("description"));
        }
        return res.append("Город: ").append(model.getName())
                .append("\n").append("Температура: ").append(model.getTemp()).append(" C")
                .append("\n").append("Влажность: ").append(model.getHumidity()).append("%")
                .append("\n").append("Сегодня ").append(model.getDescription())
                .append("\n").append("http://openweathermap.org/img/w/").append(model.getIcon()).append(".png").toString();
    }
}
