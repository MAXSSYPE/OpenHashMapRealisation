# OpenHashMap

My realisation of hashmap with open addresing.

### Prerequisites

jdk 8+, any ide.

## Methods of OpenHashMap:

* boolean put(int key, long value);

* long get(int key);

* int size();

## Tests

I wrote tests for every use case. Example:

```
@Test
    void callSizeShouldReturnSize() {
        int testSize = 200;
        OpenHashMapImpl openHashMap = new OpenHashMapImpl();
        for (int i = 0; i < testSize; i++) {
            openHashMap.put(i, -i + 3);
        }
        assertEquals(testSize, openHashMap.size());
    }
```
## Built With

* Maven (Dependency Management)
* Junit (for tests)
* Mockito (for tests)

## Authors

* Dudka Maxym

