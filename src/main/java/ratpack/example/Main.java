package ratpack.example;

import ratpack.example.config.DependencyConfig;
import ratpack.example.service.ServiceModule;
import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

/**
 * Starts the ratpack-servicedependency-example application.
 */
public class Main {

    public static void main(String... args) throws Exception {
        ServerConfig serverConfig = ServerConfig.builder()
                .yaml("config.yml")
                .require("/serviceDependencies", DependencyConfig.class)
                .baseDir(BaseDir.find())
                .build();

        RatpackServer.start(s -> s
                .serverConfig(serverConfig)
                .registry(Guice.registry(b -> b
                        .module(ServiceModule.class))
                )
        );
    }
}
