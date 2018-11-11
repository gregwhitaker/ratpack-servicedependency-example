package ratpack.example.service;

import com.google.inject.Singleton;
import ratpack.service.Service;
import ratpack.service.StartEvent;
import ratpack.service.StopEvent;

/**
 * Service that does not depend on any other service.
 */
@Singleton
public class ServiceA implements Service {

    @Override
    public String getName() {
        return ServiceA.class.getSimpleName();
    }

    @Override
    public void onStart(StartEvent event) throws Exception {
        System.out.println("Starting ServiceA");
    }

    @Override
    public void onStop(StopEvent event) throws Exception {
        System.out.println("Stopping ServiceA");
    }
}
