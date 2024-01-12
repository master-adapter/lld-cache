package org.masterAdapter.cache;

import junit.framework.TestCase;
import org.junit.Test;
import org.masterAdapter.factory.CacheFactory;

import static org.junit.Assert.assertEquals;

public class CacheTest {

    @Test
    public void itShouldBeAbleToGetAndAddItemsInTheCache() {
        Cache<Integer, Integer>  cache = new CacheFactory<Integer, Integer>().getDefaultCache(3);
        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(Integer.valueOf(1), cache.get(1)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        cache.put(3, 3);
        assertEquals(Integer.valueOf(3), cache.get(3));

        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        cache.put(4, 4);

        cache.get(2); // This should throw exception "Tried to access non-existing key."
    }
}