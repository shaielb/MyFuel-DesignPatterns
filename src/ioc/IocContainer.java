package ioc;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import xml.parser.XmlParser;

@SuppressWarnings("unchecked")
public class IocContainer implements IIocContainer {

	public static final String SingleInstance = "single-instance";
	
	private Map<String, Class<?>> _registered = new HashMap<String, Class<?>>();

	private Map<String, Object> _singletons = new HashMap<String, Object>();

	public <T> void register(Class<T> item, String name) {
		_registered.put(name, item);
	}

	public <T> T resolve(String name) {
		Object obj = _singletons.get(name);
		if (obj != null) {
			return (T) obj;
		}
		try {
			T instance = (T) _registered.get(name).newInstance();
			if (_singletons.keySet().contains(name)) {
				_singletons.put(name, instance);
			}
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void register(File xml, String node) throws Exception {
		register(XmlParser.parse(xml.getAbsolutePath(), node));
	}

	public void register(InputStream xml, String node) throws Exception {
		register(XmlParser.parse(xml, node));
	}
	
	private void register(Map<String, Object> map) throws Exception {
		if (map != null) {
			map = (Map<String, Object>) map.get("components");
		}
		for (Entry<String, Object> entry: map.entrySet()) {
			Class<?> c = Class.forName(entry.getKey());
			Object attributes = entry.getValue();
			if (attributes != null && attributes instanceof Map<?, ?>) {
				Map<String, Object> attributesMap = (Map<String, Object>) attributes;
				for (Entry<String, Object> attributeEntry: attributesMap.entrySet()) {
					if (attributeEntry.getKey().equals("id")) {
						_registered.put((String) attributeEntry.getValue(), c);
					}
					if (attributeEntry.getKey().equals(SingleInstance)) {
						_singletons.put((String) attributesMap.get("id"), null);
					}
				}
			}
		}
	}
}
