package net.msina.twbot.yearprogress.model.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import javax.annotation.PostConstruct;

@Configuration
public class ConnectionProvider {

    @Value("${oauth.consumerKey}")
    private String consumerKey;

    @Value("${oauth.consumerSecret}")
    private String consumerSecret;

    @Value("${oauth.accessToken}")
    private String accessToken;

    @Value("${oauth.accessTokenSecret}")
    private String accessTokenSecret;

    private ConfigurationBuilder configurationBuilder;
    private TwitterFactory twitterFactory;

    @PostConstruct
    private void init(){
        configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        twitterFactory = new TwitterFactory(configurationBuilder.build());
    }

    @Bean
    public Twitter getTwitterInstance(){
        return twitterFactory.getInstance();
    }
}
