package edz.example.com.kotlinapplication.test

import java.math.BigInteger

/**
 * anther: created by zuochunsheng on 2019/11/3 15 : 22
 * description :
 *
 */

fun factorial(num: Int): BigInteger {

    if (num == 0) {
        return BigInteger.valueOf(1L)
    }
    return BigInteger.valueOf(num.toLong()).times(factorial(num - 1))
}

//尾递归
class Result(var value: BigInteger = BigInteger.valueOf(1L))

tailrec fun factorials(num: Int, result: Result) {
    if (num == 0) {
        result.value = result.value.times((BigInteger.valueOf(1L)))
    } else {
        result.value = result.value.times((BigInteger.valueOf(num.toLong())))
        factorials((num - 1), result)
    }
}

fun main(args: Array<String>) {
    println(factorial(5))

    val result = Result()
    factorials(5, result)
    println(result.value)
}