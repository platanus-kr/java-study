package volatiles;

public class VolatileImmutableObjectExample {
    // 불변 객체 Config를 안전하게 공개하기 위해 volatile 키워드를 사용합니다.
    private volatile Config config;

    public VolatileImmutableObjectExample(Config initialConfig) {
        this.config = initialConfig;
    }

    // 다른 스레드에서 현재 Config 객체를 안전하게 읽을 수 있습니다.
    public Config getConfig() {
        return config;
    }

    // 새로운 Config로 업데이트하기 위한 메서드입니다. 새로운 Config 객체를 생성한 후, volatile 변수를 업데이트합니다.
    public void updateConfig(String newConfigValue) {
        this.config = new Config(newConfigValue);
    }
}

// Config는 불변 객체입니다. 한번 생성되면 내부 상태가 바뀌지 않습니다.
final class Config {
    private final String configValue;

    public Config(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigValue() {
        return configValue;
    }
}
