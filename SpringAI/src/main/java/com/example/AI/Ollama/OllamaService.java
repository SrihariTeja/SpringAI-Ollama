package com.example.AI.Ollama;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {
	
//	@Autowired
//	LLMConfigurer config;

	public ChatClient chatclient;
	
	
	@Autowired
	VectorStore vectorStore;
	
//	FileSystemChatMemory fileSystemChatMemory = new FileSystemChatMemory(
//            Paths.get("chat-memory")
//        );
//	
	
	public OllamaService(@Qualifier("ollamaChatModel") ChatModel model) {
		this.chatclient=ChatClient.create(model);
	}
	
	
	//chatclient = config.ollamaClient(ChatModel chatmo)
	public String getResponseFromOllama(String request) {
		String promrequest = """
				Suggest  me a new movies which belongs to {Genre} and has some A rated sceens and with IMDB rating in {lang} language and with {verdict}.
				Give me the response in format 
				1.Movie name
				2.Hero, Heroine and Director name
				3.Basic Plot 
				4. Runtime
				""";
		String [] keywords = request.split(" ");
		PromptTemplate template = new PromptTemplate(promrequest);
		Prompt promptRequest = template.create(Map.of("Genre",keywords[0],"lang",keywords[1],"verdict",keywords[2]));
	    ChatResponse response = chatclient
	            .prompt(promptRequest)
	            .call()
	            .chatResponse();

	    // Print metadata clearly
	    System.out.println("=== Metadata ===");
	    
	        System.out.println("Model is :::"+response.getMetadata().getModel());
	    

	    // Print the response messages clearly
	    //System.out.println("\n=== Response Messages ===");
	    

	    // Build a human-readable response string
	 

	    AssistantMessage s = response.getResult().getOutput();
	    return s.getText();
	}
	//.advisors(new QuestionAnswerAdvisor(vectorStore))
	
	public String ownLLm(String request) {
		
			return chatclient
					.prompt(request)
					.advisors(new QuestionAnswerAdvisor(vectorStore))
					.call()
					.content();
				
	}
	
	
	
	
	
	
	
}
