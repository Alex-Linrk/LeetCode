package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LeetCode 341
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> nums;
    int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        nums = new ArrayList<>();
        dsf(nestedList);
    }

    private void dsf(List<NestedInteger> list) {
        for (NestedInteger nestedInteger : list) {
            if (nestedInteger.isInteger()) {
                nums.add(nestedInteger.getInteger());
            } else {
                dsf(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return nums.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < nums.size();
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */