package intervalTree;

import java.util.ArrayList;
import java.util.List;

public class IntervalTree {

    private IntervalTreeNode root;

    public IntervalTree() {
        this.root = null;
    }

    public void insertInterval(int start, int end) {
        Interval newInterval = new Interval(start, end);
        root = insert(root, newInterval);
    }

    public void deleteInterval(int start, int end) {
        Interval interval = new Interval(start, end);
        root = delete(root, interval);
    }

    public List<Interval> findOverlappingIntervals(int start, int end) {
        Interval queryInterval = new Interval(start, end);
        List<Interval> result = new ArrayList<>();
        findOverlappingIntervals(root, queryInterval, result);
        return result;
    }

    private IntervalTreeNode insert(IntervalTreeNode node, Interval interval) {
        if (node == null) {
            return new IntervalTreeNode(interval);
        }

        int l = node.interval.start;

        if (interval.start < l) {
            node.left = insert(node.left, interval);
        } else {
            node.right = insert(node.right, interval);
        }

        if (node.max < interval.end) {
            node.max = interval.end;
        }

        return node;
    }

    private IntervalTreeNode delete(IntervalTreeNode node, Interval interval) {
        if (node == null) {
            return null;
        }

        if (interval.start < node.interval.start) {
            node.left = delete(node.left, interval);
        } else if (interval.start > node.interval.start) {
            node.right = delete(node.right, interval);
        } else if (interval.end == node.interval.end) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            IntervalTreeNode minNode = findMin(node.right);
            node.interval = minNode.interval;
            node.right = delete(node.right, minNode.interval);
        } else {
            node.right = delete(node.right, interval);
        }

        if (node != null) {
            node.max = Math.max(node.interval.end, Math.max(getMax(node.left), getMax(node.right)));
        }

        return node;
    }

    private IntervalTreeNode findMin(IntervalTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private int getMax(IntervalTreeNode node) {
        return (node == null) ? Integer.MIN_VALUE : node.max;
    }

    private void findOverlappingIntervals(IntervalTreeNode node, Interval interval, List<Interval> result) {
        if (node == null) {
            return;
        }

        if (isOverlapping(node.interval, interval)) {
            result.add(node.interval);
        }

        if (node.left != null && node.left.max >= interval.start) {
            findOverlappingIntervals(node.left, interval, result);
        }

        findOverlappingIntervals(node.right, interval, result);
    }

    private boolean isOverlapping(Interval interval1, Interval interval2) {
        return interval1.start <= interval2.end && interval2.start <= interval1.end;
    }

    public static void main(String[] args) {
        IntervalTree tree = new IntervalTree();

        tree.insertInterval(15, 20);
        tree.insertInterval(10, 30);
        tree.insertInterval(17, 19);
        tree.insertInterval(5, 20);
        tree.insertInterval(12, 15);
        tree.insertInterval(30, 40);

        System.out.println("Intervals overlapping with [6, 7]: " + tree.findOverlappingIntervals(6, 7));
        System.out.println("Intervals overlapping with [14, 16]: " + tree.findOverlappingIntervals(14, 16));

        tree.deleteInterval(10, 30);
        System.out.println("Intervals overlapping with [14, 16] after deleting [10, 30]: " + tree.findOverlappingIntervals(14, 16));
    }
}

