import com.company.project.OpenHashMapImpl;
import org.junit.jupiter.api.Test;
import org.junit.Rule;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Max
 */
public class OpenHashMapTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    void testCreateMapWithNegativeInitialSize() {
        int negativeSize = -1;
        assertThrows(IllegalArgumentException.class, () -> new OpenHashMapImpl(negativeSize));
    }

    @Test
    void shouldCallPutMethod() {
        OpenHashMapImpl openHashMap = Mockito.mock(OpenHashMapImpl.class);
        int testKey = 1;
        long testValue = 2;
        openHashMap.put(testKey, testValue);
        Mockito.verify(openHashMap).put(testKey, testValue);
    }

    @Test
    void shouldCallGetMethod() {
        OpenHashMapImpl openHashMap = Mockito.mock(OpenHashMapImpl.class);
        int testKey = 1;
        openHashMap.get(testKey);
        Mockito.verify(openHashMap).get(testKey);
    }

    @Test
    void shouldCallSizeMethod() {
        OpenHashMapImpl openHashMap = Mockito.mock(OpenHashMapImpl.class);
        openHashMap.size();
        Mockito.verify(openHashMap).size();
    }

    @Test
    void callPutShouldReturnWhatWasPut() {
        OpenHashMapImpl openHashMap = new OpenHashMapImpl();
        int testKey = 1;
        long testValue = 2;
        long expected = 2;
        openHashMap.put(testKey, testValue);
        assertEquals(expected, openHashMap.get(testKey));
    }

    @Test
    void callSizeShouldReturnSize() {
        int testSize = 200;
        OpenHashMapImpl openHashMap = new OpenHashMapImpl(testSize);
        assertEquals(testSize, openHashMap.size());
    }

    @Test
    void callGetWithNoSuchElement() {
        OpenHashMapImpl openHashMap = new OpenHashMapImpl();
        int testKey = -1;
        assertNull(openHashMap.get(testKey));
    }

    @Test
    void callPutWithKeyThatIsInMap() {
        OpenHashMapImpl openHashMap = new OpenHashMapImpl();
        int testKey = -1;
        long testValue = 2;
        long expected = -2;
        openHashMap.put(testKey, testValue);
        openHashMap.put(testKey, expected);
        assertEquals(expected, openHashMap.get(testKey));
    }

    @Test
    void testEquals() {
        OpenHashMapImpl firstTestOpenHashMap = new OpenHashMapImpl();
        OpenHashMapImpl secondTestOpenHashMap = new OpenHashMapImpl(1000);
        int testKey = -2;
        int testValue = -2;
        firstTestOpenHashMap.put(testKey, testValue);
        secondTestOpenHashMap.put(testKey, testValue);
        assertTrue(firstTestOpenHashMap.equals(secondTestOpenHashMap));
    }

    @Test
    void testToString() {
        OpenHashMapImpl openHashMap = new OpenHashMapImpl(10);
        String expected = "OpenHashMapImpl{map=[null, null, null, null, null, null, null, null, null, null]}";
        assertEquals(expected, openHashMap.toString());
    }
}
