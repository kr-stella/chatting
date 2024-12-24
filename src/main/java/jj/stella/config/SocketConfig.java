package jj.stella.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SocketConfig implements WebSocketMessageBrokerConfigurer {
	
	/** 클라이언트가 WebSocket 연결을 할 수 있는 Endpoint */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")
			.setAllowedOrigins("*")
			.withSockJS();
	};
	
	/** 메시지 브로커가 메시지를 라우팅 할 때 사용할 prefix */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		/** 메시지 브로커가 메시지를 라우팅 할 때 사용할 prefix */
		registry.enableSimpleBroker("/topic");
		/** 애플리케이션 내부에서 처리될 메시지 prefix */
		registry.setApplicationDestinationPrefixes("/app");
		
	};
	
}