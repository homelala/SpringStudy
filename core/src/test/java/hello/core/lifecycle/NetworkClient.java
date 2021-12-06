package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결메시지");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("NetworkClient.init");
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("NetworkClient.close");
        System.out.println("close: " + url);
    }
//1. 스프링 기본 메소드
//    // 의존관계 주입이 끝나면 호출
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결메시지");
//    }
//
//    // 종료될 때 호출
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결메시지");
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
