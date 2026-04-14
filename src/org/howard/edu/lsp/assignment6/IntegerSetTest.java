package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    @DisplayName("Test clear() on non-empty set")
    public void testClearNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2);
        set.clear();
        assertEquals(0, set.length());
    }

    @Test
    @DisplayName("Test clear() on already empty set")
    public void testClearEdge() {
        IntegerSet set = new IntegerSet();
        set.clear();
        assertEquals(0, set.length());
    }

    @Test
    @DisplayName("Test length() returns correct count")
    public void testLengthNormal() {
        IntegerSet set = new IntegerSet();
        set.add(10); set.add(20); set.add(30);
        assertEquals(3, set.length());
    }

    @Test
    @DisplayName("Test length() on empty set returns 0")
    public void testLengthEdge() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
    }

    @Test
    @DisplayName("Test equals() with same elements in different order")
    public void testEqualsOrderIndependent() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(3); set2.add(1); set2.add(2);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Test equals() with different elements returns false")
    public void testEqualsEdge() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(1); set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("Test contains() with value present")
    public void testContainsNormal() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
    }

    @Test
    @DisplayName("Test contains() with value not present")
    public void testContainsEdge() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertFalse(set.contains(99));
    }

    @Test
    @DisplayName("Test largest() returns max value")
    public void testLargestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(7); set.add(1);
        assertEquals(7, set.largest());
    }

    @Test
    @DisplayName("Test largest() throws exception on empty set")
    public void testLargestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.largest());
    }

    @Test
    @DisplayName("Test smallest() returns min value")
    public void testSmallestNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(7); set.add(1);
        assertEquals(1, set.smallest());
    }

    @Test
    @DisplayName("Test smallest() throws exception on empty set")
    public void testSmallestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.smallest());
    }

    @Test
    @DisplayName("Test add() adds element correctly")
    public void testAddNormal() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
        assertEquals(1, set.length());
    }

    @Test
    @DisplayName("Test add() does not add duplicate values")
    public void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(5); set.add(5);
        assertEquals(1, set.length());
    }

    @Test
    @DisplayName("Test remove() removes existing element")
    public void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2); set.add(3);
        set.remove(2);
        assertFalse(set.contains(2));
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Test remove() does nothing when value not present")
    public void testRemoveEdge() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2);
        set.remove(99);
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Test union() of two normal sets")
    public void testUnionNormal() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.union(set2);
        assertEquals(4, result.length());
        assertTrue(result.contains(1));
        assertTrue(result.contains(4));
    }

    @Test
    @DisplayName("Test union() with empty set returns original")
    public void testUnionWithEmpty() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet empty = new IntegerSet();
        IntegerSet result = set1.union(empty);
        assertEquals(2, result.length());
    }

    @Test
    @DisplayName("Test intersect() returns common elements")
    public void testIntersectNormal() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.intersect(set2);
        assertEquals(2, result.length());
        assertTrue(result.contains(2));
    }

    @Test
    @DisplayName("Test intersect() with no common elements returns empty")
    public void testIntersectNoOverlap() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(3); set2.add(4);
        assertTrue(set1.intersect(set2).isEmpty());
    }

    @Test
    @DisplayName("Test diff() returns elements in set1 not in set2")
    public void testDiffNormal() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.diff(set2);
        assertEquals(1, result.length());
        assertTrue(result.contains(1));
    }

    @Test
    @DisplayName("Test diff() with identical sets returns empty")
    public void testDiffIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(1); set2.add(2); set2.add(3);
        assertTrue(set1.diff(set2).isEmpty());
    }

    @Test
    @DisplayName("Test complement() returns elements in set2 not in set1")
    public void testComplementNormal() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.complement(set2);
        assertEquals(1, result.length());
        assertTrue(result.contains(4));
    }

    @Test
    @DisplayName("Test complement() with disjoint sets returns all of set2")
    public void testComplementDisjoint() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(3); set2.add(4);
        IntegerSet result = set1.complement(set2);
        assertEquals(2, result.length());
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
    }

    @Test
    @DisplayName("Test isEmpty() returns true on empty set")
    public void testIsEmptyTrue() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test isEmpty() returns false on non-empty set")
    public void testIsEmptyFalse() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Test toString() returns sorted format")
    public void testToStringNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(1); set.add(2);
        assertEquals("[1, 2, 3]", set.toString());
    }

    @Test
    @DisplayName("Test toString() on empty set returns []")
    public void testToStringEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }
}
