package com.example.arithmetic_study.arrays

import org.junit.Test

class Code81 {

    @Test
    fun test() {
        val data = intArrayOf(1,0,1,1,1)
        println(search(data, 0))
    }

    //已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
    //在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
    //给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false
    fun search(nums: IntArray, target: Int): Boolean {
        if(nums.isEmpty()){
            return false
        }
        if(nums.size==1){
            return target==nums[0]
        }

        var l = 0
        var r = nums.size - 1
        var mid: Int
        while (l <= r) {
            mid = l + (r - l) / 2
            if (nums[mid] == target) {
                return true
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++
                r--
            } else if (nums[l] <= nums[mid]) {
                //左边有序
                if (target < nums[mid] && target >= nums[l]) {
                    //target在左边
                    r = mid - 1
                } else { //target 在右边
                    l = mid + 1
                }
            } else {
                //右边有序
                if (nums[mid] < target && target <= nums[r]) {
                    //target在右边
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
        }
        return false
    }
}