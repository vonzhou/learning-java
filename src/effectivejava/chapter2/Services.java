package effectivejava.chapter2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//不可实例化的类，用于服务注册和访问
public class Services {
	private Services() {
	}

	// map service name to Service
	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
	private static final String DEFAULT_PROVIDER_NAME = "<def>";

	// provider registration API
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}

	public static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}

	// Service access API
	public Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public Service newInstance(String name) {
		// 通过服务提供者获得服务
		Provider p = providers.get(name);
		if (p == null)
			throw new IllegalArgumentException("No provider registered with "
					+ name);
		return p.newService();
	}

}
