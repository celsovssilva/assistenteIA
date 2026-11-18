package com.example.demo;

import org.awaitility.classpath.ClassPathResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "OPEN_API_KEY", matches = ".+")
public class OpenIaAudioTranscriptionModel {
    @Autowired
    OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;
    @ParameterizedTest
    @CsvSource({

    })


    public  void setOpenAiAudioTranscriptionModel(String fileName){
        var recording = new ClassPathResource("audio" + fileName);

        var response = openAiAudioTranscriptionModel.call(recording);
        assertThat(response).contains("0");
        System.out.println(response);
    }
}
