/**
 *  Service Provider Framework: Multiple service providers implement services
 * and the system makes them implementations available for it's clients.
 * 
 *  This consists mainly of a Service Interface, Provider registration API ie. 
 * used to register implementations giving clients access to them, and Access API
 * ie. clients uses to obtain an instance of the service.
 * 
 * April 5, 2016
 */
package ServiceProviderFrameworkPattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author tkasozi
 */
//noninstantiable class for service and access 
public class Services {

    private Services() {
    }

    //Map service names to services
    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
    private static final String DEFAULT_PROVIDER_NAME = "<def>";

    //Provider registration API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    //Service access API
    public static Service newInService() {
        return newInService(DEFAULT_PROVIDER_NAME);
    }

    private static Service newInService(String name) {
        Provider p = providers.get(name);

        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name " + name);
        }

        return p.newService();
    }
}
