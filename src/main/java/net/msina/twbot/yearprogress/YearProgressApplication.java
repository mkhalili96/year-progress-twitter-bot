package net.msina.twbot.yearprogress;

import net.msina.twbot.yearprogress.model.service.TweetService;
import net.msina.twbot.yearprogress.model.service.YearProgressService;
import net.msina.twbot.yearprogress.model.service.common.YearInfProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import twitter4j.TwitterException;

import javax.annotation.PostConstruct;

@EnableScheduling
@SpringBootApplication
public class YearProgressApplication {

    @Autowired
    TweetService tweetService;

    @Autowired
    YearProgressService yearProgressService;

    public static void main(String[] args) {
        SpringApplication.run(YearProgressApplication.class, args);

    }

    @Scheduled(fixedDelay = 86400000)
    public void t() throws TwitterException {
        yearProgressService.progressTweet();
        tweetService.createTweet(yearProgressService.progressTweet());
    }

}
