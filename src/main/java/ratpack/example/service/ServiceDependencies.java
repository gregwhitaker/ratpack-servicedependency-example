package ratpack.example.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ratpack.example.config.DependencyConfig;
import ratpack.service.ServiceDependenciesSpec;

/**
 * Defines the dependencies between services that can not be defined by using the {@link ratpack.service.DependsOn} annotation.
 *
 * @see <a href="https://ratpack.io/manual/current/api/ratpack/service/ServiceDependenciesSpec.html">Service Dependencies JavaDoc</a>
 */
@Singleton
public class ServiceDependencies implements ratpack.service.ServiceDependencies {

    @Inject
    private DependencyConfig config;

    @Override
    public void define(ServiceDependenciesSpec spec) throws Exception {
        if (config.serviceC.equalsIgnoreCase("ServiceB")) {
            // ServiceC depends on ServiceB and ServiceD depends on ServiceC (A -> B -> C -> D)
            spec.dependsOn(service -> service instanceof ServiceC, service -> service instanceof ServiceB);
            spec.dependsOn(service -> service instanceof ServiceD, service -> service instanceof ServiceC);
        } else {
            // ServiceD depends on ServiceB and ServiceC depends on ServiceD (A -> B -> D -> C)
            spec.dependsOn(service -> service instanceof ServiceD, service -> service instanceof ServiceB);
            spec.dependsOn(service -> service instanceof ServiceC, service -> service instanceof ServiceD);
        }
    }
}
