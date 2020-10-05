package net.msina.twbot.yearprogress.model.service;

import net.msina.twbot.yearprogress.model.service.common.YearInfProvider;
import net.msina.twbot.yearprogress.model.to.DayTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class YearProgressService {
    private static DecimalFormat df2 = new DecimalFormat("##.##");
    @Autowired
    YearInfProvider yearInfProvider;

    public String progressTweet(){
        DayTo day = yearInfProvider.getCurrentJalaliDate();
        String tweet = day.getYear()+" Passing ("+day.getPassed()+"/"+day.getTotal()+")\n";
        int totalBrickCount = 16;
        double unit = (double) day.getTotal()/(double)totalBrickCount;
        int passedBrickCount = (int) (day.getPassed()/unit);

        for (int i = 1 ; i<=totalBrickCount ; i++){
            if(passedBrickCount-- >= 0)
                tweet+="▓";
            else
                tweet+="░";
        }
        double passedPersent =(double) day.getPassed()/(double) day.getTotal()*100;
        tweet+=" "+df2.format(passedPersent)+"%\n";
//        tweet+="["+day.getYear()+"/"+day.getMonth()+"/"+day.getDay()+"]";
        System.out.println(tweet);
       return tweet;
    }
}
