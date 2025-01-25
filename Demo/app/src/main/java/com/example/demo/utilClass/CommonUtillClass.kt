package com.example.demo.utilClass

/**
 * Common Utill class to declare constants
 */

class CommonUtillClass {
    companion object {
        const val mDelaytIME = 2000
        const val mStartTestTag="Before test case execution"
        const val mEndTestTag="After test case execution"
        const val mLoginLabel="Login your Account"

        fun ValidateInputString(str: String, mMaxUserNameLen: Int): Boolean {
            if ((str != null && str.length != 0) && str.length <= mMaxUserNameLen) {
                return true
            } else
                return false
        }
    }


}