package ratpack.example.service;

import com.google.inject.Singleton;
import ratpack.service.Service;
import ratpack.service.StartEvent;
import ratpack.service.StopEvent;

/**
 * Service that can depend on either ServiceB or ServiceD based on configuration in the config.yml file.
 */
@Singleton
public class ServiceC implements Service {

    @Override
    public String getName() {
        return ServiceC.class.getSimpleName();
    }

    @Override
    public void onStart(StartEvent event) throws Exception {
        System.out.println("Starting ServiceC");
    }

    @Override
    public void onStop(StopEvent event) throws Exception {
        System.out.println("Stopping ServiceC");
    }
}
