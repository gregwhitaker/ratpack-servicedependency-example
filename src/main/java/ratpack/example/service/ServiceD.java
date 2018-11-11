package ratpack.example.service;

import ratpack.service.Service;
import ratpack.service.StartEvent;
import ratpack.service.StopEvent;

/**
 * Service that can depend on either ServiceC or ServiceB based on configuration in the config.yml file.
 */
public class ServiceD implements Service {

    @Override
    public String getName() {
        return ServiceD.class.getSimpleName();
    }

    @Override
    public void onStart(StartEvent event) throws Exception {
        System.out.println("Starting ServiceD");
    }

    @Override
    public void onStop(StopEvent event) throws Exception {
        System.out.println("Stopping ServiceD");
    }
}
