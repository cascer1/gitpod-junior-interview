package be.nn.hiring.junior.trees;

public class Segment {
    /**
     * Set the weight of this segment.
     *
     * @throws IllegalArgumentException when provided weight is negative.
     */
    public void setWeight(int weight) {
    }

    /**
     * Get the weight of this segment and all its children.
     */
    public int getWeight() {
        return 0;
    }

    /**
     * Set the left child of this segment.
     *
     * @throws IllegalArgumentException if the same segment is also set as right child.
     */
    public void setLeft(Segment left) {
    }

    /**
     * Set the right child of this segment.
     *
     * @throws IllegalArgumentException if the same segment is also set as left child.
     */
    public void setRight(Segment right) {
    }
}
