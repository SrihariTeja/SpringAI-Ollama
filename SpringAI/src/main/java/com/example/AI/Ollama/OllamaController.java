package com.example.AI.Ollama;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ollama")
public class OllamaController {
	
	@Autowired
	@Qualifier("ollamaEmbeddingModel")
	public EmbeddingModel embed;
	
	
	
	private ChatClient chatClient;
	
	public OllamaController(OllamaChatModel model) {
		this.chatClient = ChatClient.create(model);
	}
	
	@Autowired
	OllamaService service;
	
	@PostMapping("/OllamaVerify")
	public Object getRequest(@RequestBody String request) {
		
		return service.getResponseFromOllama(request);
	}

   @PostMapping("/embeddings")
   public float[] getEmbedded( @RequestParam String keyword) {
		
	  
		float[] embeddded = embed.embed(keyword);
		return embeddded;
	}
   
   @PostMapping("/ownLLM")
   public String ownLLM(@RequestBody String request) {
	   return service.ownLLm(request);
   }
}
