package stack

import java.util.*

/**
 * 基本计算器 II
 * 基本计算器 II
 *实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 *字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 *示例 1:
 *
 *输入: "3+2*2"
 *输出: 7
 *示例 2:
 *
 *输入: " 3/2 "
 *输出: 1
 *示例 3:
 *
 *输入: " 3+5 / 2 "
 *输出: 5
 *说明：
 *
 *你可以假设所给定的表达式都是有效的。
 *请不要使用内置的库函数 eval。
 */
class LeetCode227 {
    fun calculate(s: String): Int {
        val numStack = Stack<Int>()
        val check = Stack<Char>()
        var count = 1
        val symbol = charArrayOf('+', '-', '*', '/')
        for (index in 0..s.lastIndex) {
            when (s[index]) {
                in '0'..'9' -> {
                    if (count == 10) {
                        numStack.push(numStack.pop() * count + s[index].toString().toInt())
                    } else {
                        numStack.push(s[index].toString().toInt())
                        count = 10
                    }
                }
                in symbol -> {
                    if (check.isEmpty().not()) {
                        when (check.peek()) {
                            '*' -> {
                                check.pop()
                                val second = numStack.pop()
                                val first = numStack.pop()
                                numStack.push(second * first)
                            }
                            '/' -> {
                                check.pop()
                                val second = numStack.pop()
                                val first = numStack.pop()
                                numStack.push(first / second)
                            }
                        }
                    }
                    check.push(s[index])
                    count = 1
                }
            }
        }
        if(check.isEmpty().not() &&(check.peek() == '*'||check.peek()=='/')){
            val second = numStack.pop()
            val first = numStack.pop()
            when (check.pop()) {
                '*' -> numStack.push(second * first)
                '/' -> numStack.push(first / second)
            }
        }
        numStack.reverse()
        check.reverse()
        return lastCalculate(numStack, check)
    }


    private fun lastCalculate(number: Stack<Int>, check: Stack<Char>): Int {
        while (check.isEmpty().not()) {
            val first = number.pop()
            val second = number.pop()
            when (check.pop()) {
                '+' -> number.push(second + first)
                '-' -> number.push(first - second)
            }
        }
        return number.pop()
    }
}

fun main() {
    println(
        LeetCode227().calculate("3+2*2")
    )
    println(
        LeetCode227().calculate(" 3/2 ")
    )
    println(
        LeetCode227().calculate(" 3+5 / 2 ")
    )
    println(
        LeetCode227().calculate("42")
    )
    println(
        LeetCode227().calculate("0-2147483647")
    )
    println(
        LeetCode227().calculate("1-1+1")
    )
    println(
        LeetCode227().calculate("2*3+4")
    )
    println(
        LeetCode227().calculate("100000000/1/2/3/4/5/6/7/8/9/10")
    )
}