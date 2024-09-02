import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    @Test
    public void testAddToFront() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addToFront(10);
        list.addToFront(20);
        list.addToFront(30);

        assertEquals(3, list.size());
        assertEquals("30, 20, 10", list.toString());
    }

    @Test
    public void testAddToEnd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);

        assertEquals(3, list.size());
        assertEquals("10, 20, 30", list.toString());
    }

    @Test
    public void testRemoveFromFront() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addToFront(10);
        list.addToFront(20);
        list.addToFront(30);

        assertEquals(30, list.removeFromFront());
        assertEquals(2, list.size());
        assertEquals("20, 10", list.toString());

        assertEquals(20, list.removeFromFront());
        assertEquals(1, list.size());
        assertEquals("10", list.toString());

        assertEquals(10, list.removeFromFront());
        assertEquals(0, list.size());
        assertEquals("null", list.toString());

        Exception exception = assertThrows(NullPointerException.class, list::removeFromFront);
        assertEquals("CircularLinkedList is empty", exception.getMessage());
    }

    @Test
    public void testRemoveFromEnd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);

        assertEquals(30, list.removeFromEnd());
        assertEquals(2, list.size());
        assertEquals("10, 20", list.toString());

        assertEquals(20, list.removeFromEnd());
        assertEquals(1, list.size());
        assertEquals("10", list.toString());

        assertEquals(10, list.removeFromEnd());
        assertEquals(0, list.size());
        assertEquals("null", list.toString());

        Exception exception = assertThrows(NullPointerException.class, list::removeFromEnd);
        assertEquals("CircularLinkedList is empty", exception.getMessage());
    }

    @Test
    public void testContains() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addToFront(10);
        list.addToFront(20);
        list.addToFront(30);

        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
        assertTrue(list.contains(30));
        assertFalse(list.contains(40));
    }

    @Test
    public void testToArray() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);

        Integer[] expectedArray = {10, 20, 30};
        assertArrayEquals(expectedArray, list.toArray());

        list.removeFromEnd();
        Integer[] expectedArrayAfterRemoval = {10, 20};
        assertArrayEquals(expectedArrayAfterRemoval, list.toArray());

        list.removeFromFront();
        Integer[] expectedArrayAfterFrontRemoval = {20};
        assertArrayEquals(expectedArrayAfterFrontRemoval, list.toArray());
    }

    @Test
    public void testToStringEmptyList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        assertEquals("null", list.toString());
    }
}
