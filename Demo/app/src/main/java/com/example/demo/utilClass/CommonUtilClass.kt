package com.example.demo.utilClass

/**
 * Common Utill class to declare constants
 */

class CommonUtilClass {
    companion object {
        fun ValidateInputString(str: String, mMaxUserNameLen: Int): Boolean {
            if ((str != null && str.length != 0) && str.length <= mMaxUserNameLen) {
                return true
            } else
                return false
        }
    }


}