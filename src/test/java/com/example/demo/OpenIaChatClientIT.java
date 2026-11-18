package com.example.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPEN_API_KEY", matches = ".+")
public class OpenIaChatClientIT {
    @Autowired
    OpenAiChatModel openAiChatModelIT;

    @Test
    void should_execute_when_promped(){
        var chatClient = ChatClient.builder( openAiChatModelIT)
                .defaultSystem("voce é um matematico ").build();

        var response = chatClient.prompt("some 10 mais 20 e exiba o resultado sem explicações")
                .call().content();
        assertThat(response).contains("0");
        System.out.println(response);
    }

}
