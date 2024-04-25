package lab6.var1

fun rearrangeList(nums: MutableList<Int>) {
    val (positive, negative) = nums.partition { it > 0 }
    nums.clear()
    nums.addAll(positive)
    nums.addAll(negative)
}

fun main(){
    val nums: MutableList<Int> = mutableListOf(1,-5,2,-4, -18, 12, 2)
    rearrangeList(nums)

    // Либо просто отсортировать по убыванию
    // nums.sortDescending()

    println(nums)
}