package com.example.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient() {
        // Create a low-level DynamoDb client
        DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
                .region(Region.AP_SOUTH_1) // Change this if you're in a different AWS region
                .build();

        // Wrap it with the enhanced client for object mapping
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }
}
@Bean
public SnsClient snsClient() {
    return SnsClient.builder()
            .region(Region.AP_SOUTH_1) // Change if you're using another AWS region
            .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
            .build();
}
