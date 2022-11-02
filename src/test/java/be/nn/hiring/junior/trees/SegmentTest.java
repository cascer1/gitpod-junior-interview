package be.nn.hiring.junior.trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import be.nn.hiring.junior.trees.Segment;

public class SegmentTest {
    @Test
    void testNoWeight() {
        Segment segment = new Segment();
        assertEquals(0, segment.getWeight());
    }

    @Test
    void testSimpleWeight() {
        Segment segment = new Segment();
        segment.setWeight(5);
        assertEquals(5, segment.getWeight());
    }

    @Test
    void testNegativeWeightNotAllowed() {
        Segment segment = new Segment();
        assertThrows(IllegalArgumentException.class, () -> segment.setWeight(-1));
    }

    @Test
    void testSameRightChildNotAllowed() {
        Segment rootSegment = new Segment();
        Segment leftChild = new Segment();

        rootSegment.setLeft(leftChild);
        assertThrows(IllegalArgumentException.class, () -> rootSegment.setRight(leftChild));
    }

    @Test
    void testSameLeftChildNotAllowed() {
        Segment rootSegment = new Segment();
        Segment rightChild = new Segment();

        rootSegment.setRight(rightChild);
        assertThrows(IllegalArgumentException.class, () -> rootSegment.setLeft(rightChild));
    }

    @Test
    void testLeftChildWeightIncluded() {
        Segment rootSegment = new Segment();
        Segment leftChild = new Segment();

        rootSegment.setWeight(3);
        leftChild.setWeight(5);

        rootSegment.setLeft(leftChild);

        assertEquals(8, rootSegment.getWeight());
    }

    @Test
    void testRightChildWeightIncluded() {
        Segment rootSegment = new Segment();
        Segment rightChild = new Segment();

        rootSegment.setWeight(3);
        rightChild.setWeight(5);

        rootSegment.setRight(rightChild);

        assertEquals(8, rootSegment.getWeight());
    }
}
