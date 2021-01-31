package dk.workkit.memcache;

import dk.workkit.domain.Model;
import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCacheTest {

    private InMemoryCache cache;

    @BeforeEach
    void setUp() {
        this.cache = new InMemoryCache(10);
    }

    @Test
    void testCanInsertNewObjectIntoCache() {
        TestModel object = new TestModel("Object");
        String id = UUID.randomUUID().toString();
        cache.put(id, object);
        Map<String, Pair<Long, Model>> map = cache.getCache();
        assertEquals(object, map.get(id).getValue1());
    }

    @Test
    void testShouldUpdateObjectIfAlreadyExists() {
        String id = UUID.randomUUID().toString();
        Map<String, Pair<Long, Model>> initialCache = new HashMap<>();
        initialCache.put(id, new Pair<>(2L, new TestModel(id)));
        cache.setCache(initialCache);
        TestModel object = new TestModel("ObjectUpdated");
        cache.put(id, object);
        Map<String, Pair<Long, Model>> map = cache.getCache();
        Pair<Long, Object> expected = new Pair<>(2L, object);
        assertEquals(expected, map.get(id));
    }

    @Test
    void testWhenCacheIsFull_ShouldSwapWithLeastUsed() {
        cache = new InMemoryCache(2);
        Map<String, Pair<Long, Model>> initialCache = new HashMap<>();
        TestModel object1 = new TestModel(UUID.randomUUID().toString());
        initialCache.put(object1.getId(), new Pair<>(2L, object1));
        TestModel object2 = new TestModel(UUID.randomUUID().toString());
        initialCache.put(object2.getId(), new Pair<>(10L, object2));
        cache.setCache(initialCache);

        TestModel object3 = new TestModel(UUID.randomUUID().toString());
        cache.put(object3.getId(), object3);
        Map<String, Pair<Long, Model>> map = cache.getCache();
        assertFalse(map.containsKey(object1.getId()));
        assertTrue(map.containsKey(object2.getId()));
        assertTrue(map.containsKey(object3.getId()));
    }

    @Test
    void testWhenCacheMiss_ShouldThrowException() {
        assertThrows(CacheMissException.class, () -> cache.get(""));
    }

    @Test
    void testWhenCacheHit_ShouldReturnModel() {
        Map<String, Pair<Long, Model>> initialCache = new HashMap<>();
        TestModel object1 = new TestModel(UUID.randomUUID().toString());
        initialCache.put(object1.getId(), new Pair<>(2L, object1));
        cache.setCache(initialCache);
        Model actual = cache.get(object1.getId());
        assertEquals(object1, actual);
    }

    @Test
    void testWhenCacheHit_ShouldIncreasePopularity() {
        Map<String, Pair<Long, Model>> initialCache = new HashMap<>();
        TestModel object1 = new TestModel(UUID.randomUUID().toString());
        initialCache.put(object1.getId(), new Pair<>(0L, object1));
        cache.setCache(initialCache);
        cache.get(object1.getId());
        Map<String, Pair<Long, Model>> map = cache.getCache();
        assertEquals(1L, map.get(object1.getId()).getValue0());
    }

    @Test
    void testPutAndGetOnSameModel() {
        TestModel object = new TestModel(UUID.randomUUID().toString());
        cache.put(object.getId(), object);
        cache.put(object.getId(), object);
        cache.get(object.getId());
        cache.get(object.getId());
        cache.put(object.getId(), object);
        cache.get(object.getId());
        Pair<Long, Model> actual = cache.getCache().get(object.getId());
        assertEquals(3, actual.getValue0());
        assertEquals(object, actual.getValue1());
    }
}
