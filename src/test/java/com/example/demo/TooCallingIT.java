package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPEN_API_KEY", matches = ".+")
public class TooCallingIT {
    @Autowired
    private OpenAiChatModel openAiChatModel;

    static  class MathTools{
        @Tool(description = "soma dois numeros inteiros, a e b")
        public int sum(int a , int b){
            return a + b;
        }
        @Tool(description = "subtrai dois numeros inteiros, a e b")
        public int diff(int a , int b){
            return a - b;
        }
    }

    @Test
    void should_executeSum_when_prompetd(){
        var chatClient = ChatClient.builder( openAiChatModel)
                .defaultSystem("voce é um matematico ")
                .defaultTools(new MathTools())
                .build();

        var response = chatClient.prompt("some 10 mais 20 e exiba o resultado sem explicações")
                .call().content();

        assertThat(response).contains("0");
        System.out.println(response);
    }
}
