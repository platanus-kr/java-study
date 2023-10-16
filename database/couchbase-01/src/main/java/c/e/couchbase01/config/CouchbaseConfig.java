package c.e.couchbase01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    public static final String NODE_LIST = "localhost";
    public static final String BUCKET_NAME = "projects";
    public static final String BUCKET_USERNAME = "admin";
    public static final String BUCKET_PASSWORD = "P@$$w0rd";


    @Override
    public String getConnectionString() {
        return NODE_LIST;
    }

    @Override
    public String getUserName() {
        return BUCKET_USERNAME;
    }

    @Override
    public String getPassword() {
        return BUCKET_PASSWORD;
    }

    @Override
    public String getBucketName() {
        return BUCKET_NAME;
    }

    // from https://www.baeldung.com/spring-data-couchbase
    // LocalValidatorFactoryBean 일단 이게 뭐하는놈인지 좀 찾아볼것.. 못가져온다. 근데 왜 의존성이 5에 물려있지???? 이해불가.
//    @Bean
//    public LocalValidatorFactoryBean localValidatorFactoryBean() {
//        return new LocalValidatorFactoryBean();
//    }
//
//    @Bean
//    public ValidatingCouchbaseEventListener validatingCouchbaseEventListener() {
//        return new ValidatingCouchbaseEventListener(localValidatorFactoryBean().getValidator());
//    }
}
