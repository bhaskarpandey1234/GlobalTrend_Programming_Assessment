package intervalTree;

class IntervalTreeNode {
    Interval interval;
    int max;
    IntervalTreeNode left;
    IntervalTreeNode right;

    IntervalTreeNode(Interval interval) {
        this.interval = interval;
        this.max = interval.end;
        this.left = null;
        this.right = null;
    }
}

