package stack

import java.util.*

/**
 *设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *push(x) -- 将元素 x 推入栈中。
 *pop() -- 删除栈顶的元素。
 *top() -- 获取栈顶元素。
 *getMin() -- 检索栈中的最小元素。
 *示例:
 *
 *MinStack minStack = new MinStack();
 *minStack.push(-2);
 *minStack.push(0);
 *minStack.push(-3);
 *minStack.getMin();   --> 返回 -3.
 *minStack.pop();
 *minStack.top();      --> 返回 0.
 *minStack.getMin();   --> 返回 -2.
 */
class MinStack() {
    val data = Stack<Int>()
    val min = Stack<Int>()
    fun push(x: Int) {
        data.push(x)
        if (min.isEmpty() || x <= min.first()) {
            min.push(x)
        }
    }

    fun pop() {
        if (data.isEmpty()) return
        val pop = data.pop()
        if (min.isNotEmpty() && min.last() == pop) {
            min.pop()
        }
    }

    fun top(): Int {
        if (data.isNotEmpty())
            return data.last()
        return 0
    }

    fun getMin(): Int {
        if (min.isNotEmpty())
            return min.last()
        return 0
    }

}

/**
 * ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
[null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]
 */
fun main() {
    val stack = MinStack()
    stack.push(2147483646)
    stack.push(2147483646)
    stack.push(2147483647)
    println(stack.top())
    println(stack.pop())
    println(stack.getMin())
    println(stack.pop())
    println(stack.getMin())
    println(stack.pop())
    println(stack.push(2147483647))
    println(stack.top())
    println(stack.getMin())
    println(stack.push(-2147483648))
    println(stack.top())
    println(stack.getMin())
    println(stack.pop())
    println(stack.getMin())
}