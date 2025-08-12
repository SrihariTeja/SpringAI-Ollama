//package com.example.AI.Ollama;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.chat.model.ChatModel;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class LLMConfigurer {
//	
//	@Bean(name="Ollama")
//	public ChatClient ollamaClient(@Qualifier("ollamaChatModel") ChatModel model) {
//		 return ChatClient.create(model);
//	}
//	@Bean(name="openAI")
//	public ChatClient openAIClient(@Qualifier("openAIChatModel") ChatModel model) {
//		 return ChatClient.create(model);
//	}
//
//}
