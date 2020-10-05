package net.msina.twbot.yearprogress.model.service.common;

import net.msina.twbot.yearprogress.model.to.DayTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@Component
public class YearInfProvider {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.date.root}${api.date.jalali.current}")
    private String getCurrentDateUrl;

    public Boolean isLeapYear(Integer year){
        if (Arrays.asList(1,5,9,13,17,22,26).contains(year % 33))
            return true;
        return false;
    }

    public DayTo getCurrentJalaliDate(){
        DayTo day = restTemplate.getForEntity(getCurrentDateUrl, DayTo.class).getBody();


        String[] parts = day.getDate().split("-");
        day.setYear(Integer.parseInt(parts[0]));
        day.setMonth(Integer.parseInt(parts[1]));
        day.setDay(Integer.parseInt(parts[2]));

        boolean isLeap = Arrays.asList(1,5,9,13,17,22,26).contains(day.getYear() % 33) ? true : false;
        int passed = 0;
        if (day.getMonth()<=6)
            passed = day.getMonth()-1 * 31 + day.getDay();
        else
            passed = 186 + (day.getMonth() - 7) * 30 + day.getDay();

        int total = isLeap ? 366 : 365;
        day.setPassed(passed);
        day.setTotal(total);

        return day;
    }

}
