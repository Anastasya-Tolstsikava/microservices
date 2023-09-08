package com.testproject.zoomarket.config;

import com.testproject.zoomarket.client.PetClient;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    @Primary
    public WebClient petWebClient() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl("http://pet-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public PetClient petClient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(
                WebClientAdapter.forClient(petWebClient())).build();

        return httpServiceProxyFactory.createClient(PetClient.class);
    }
}
