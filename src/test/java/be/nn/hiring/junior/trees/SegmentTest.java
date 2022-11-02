package be.nn.hiring.junior.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SegmentTest {
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

    @Test
    void testTwoChildren() {
        Segment rootSegment = new Segment();
        Segment left = new Segment();
        Segment right = new Segment();

        rootSegment.setWeight(1);
        left.setWeight(2);
        right.setWeight(4);

        rootSegment.setLeft(left);
        rootSegment.setRight(right);

        assertEquals(7, rootSegment.getWeight());
    }

    @Test
    void testNested() {
        Segment leftRootSegment = new Segment();
        leftRootSegment.setWeight(1);

        Segment leftLeftChildSegment = new Segment();
        leftLeftChildSegment.setWeight(2);
        leftRootSegment.setLeft(leftLeftChildSegment);

        Segment leftRightChildSegment = new Segment();
        leftRightChildSegment.setWeight(3);
        leftRootSegment.setRight(leftRightChildSegment);

        Segment rightRootSegment = new Segment();
        rightRootSegment.setWeight(4);

        Segment rightLeftChildSegment = new Segment();
        rightLeftChildSegment.setWeight(5);
        rightRootSegment.setLeft(rightLeftChildSegment);

        Segment rightRightChildSegment = new Segment();
        rightRightChildSegment.setWeight(6);
        rightRootSegment.setRight(rightRightChildSegment);

        Segment rootSegment = new Segment();
        rootSegment.setWeight(7);

        rootSegment.setLeft(leftRootSegment);
        rootSegment.setRight(rightRootSegment);

        assertEquals(28, rootSegment.getWeight());
    }
}
