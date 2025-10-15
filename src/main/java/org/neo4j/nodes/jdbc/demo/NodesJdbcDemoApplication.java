package org.neo4j.nodes.jdbc.demo;

import io.micrometer.tracing.Tracer;
import org.neo4j.jdbc.Neo4jDriver;
import org.neo4j.jdbc.tracing.micrometer.Neo4jTracingBridge;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NodesJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodesJdbcDemoApplication.class, args);
    }

    @Bean
    public InitializingBean neo4jTracingInitializer(Tracer tracer) {
        return () -> Neo4jDriver.registerTracer(Neo4jTracingBridge.to(tracer));
    }

}
