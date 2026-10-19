package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1,0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test 
    void fire_zero() {
        try {
        TorpedoStore store = new TorpedoStore(1,0);
        store.fire(0);
        } catch (IllegalArgumentException e) {
            assertEquals(true, true);
            return;
        }
        assertEquals(true, false);
    }

    @Test 
    void fire_too_much() {
        try {
        TorpedoStore store = new TorpedoStore(1,0);
        store.fire(10);
        } catch (IllegalArgumentException e) {
            assertEquals(true, true);
            return;
        }
        assertEquals(true, false);
    }

    @Test 
    void should_fail_to_fire() {
        TorpedoStore store = new TorpedoStore(1, 1);
        boolean result = store.fire(1);
        assertEquals(false, result);
    }

    @Test
    void should_be_empty() {
        TorpedoStore store = new TorpedoStore(0);
        boolean result = store.isEmpty();
        assertEquals(true, result);
    }

    @Test
    void should_be_empty_after_fire() {
        TorpedoStore store = new TorpedoStore(1,0);
        store.fire(1);
        boolean result = store.isEmpty();
        assertEquals(true, result);
    }

    @Test
    void should_be_the_same() {
        TorpedoStore store = new TorpedoStore(1,0);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void should_not_be_empty_after_fire() {
        TorpedoStore store = new TorpedoStore(2,0);
        store.fire(1);
        boolean result = store.isEmpty();
        assertEquals(false, result);
    }
}
