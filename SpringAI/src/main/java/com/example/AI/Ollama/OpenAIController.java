package com.example.AI.Ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/OpenAI")
public class OpenAIController {
	
	public ChatClient openClient;
	
	public OpenAIController(@Qualifier("openAiChatModel") ChatModel model) {
		this.openClient = ChatClient.create(model);
	}
	
	@PostMapping("/askOpenAI")
	public String askOpenAi(@RequestBody String request) {
		return openClient
				.prompt(request)
				.call()
				.content();
		
	}

}
