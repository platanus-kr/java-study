package c.a.hd;

import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ConcurrentMap;

@RequiredArgsConstructor
public class GridRepository {

    private final HazelcastInstance instance;

    private static final String HAZELCAST_DEMO_GRID_KEY = "key";

    public ConcurrentMap<String, GridEntity> retrieveMap() {
        return instance.getMap(HAZELCAST_DEMO_GRID_KEY);
    }

}
