package ratpack.example.service;

import com.google.inject.Singleton;
import ratpack.service.DependsOn;
import ratpack.service.Service;
import ratpack.service.StartEvent;
import ratpack.service.StopEvent;

/**
 * Service that depends on ServiceA using the {@link DependsOn} annotation.
 */
@Singleton
@DependsOn(ServiceA.class)
public class ServiceB implements Service {

    @Override
    public String getName() {
        return ServiceB.class.getSimpleName();
    }

    @Override
    public void onStart(StartEvent event) throws Exception {
        System.out.println("Starting ServiceB");
    }

    @Override
    public void onStop(StopEvent event) throws Exception {
        System.out.println("Stopping ServiceB");
    }
}
