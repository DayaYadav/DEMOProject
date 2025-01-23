package com.example.demo.UtillClass

import android.text.TextUtils.isEmpty

class CommonUtillClass {


    /*fun ValidateInputString(str:String,maxLength:Int): Boolean {
        if(!isEmpty(str) && str.length>=maxLength )
        {
            return true
        }
        return false


    }*/

    companion object {
        fun ValidateInputString(str: String, mMaxUserNameLen: Int): Boolean {
            if ((str != null && str.length != 0) && str.length <= mMaxUserNameLen) {
                return true
            } else
                return false
        }
    }


}