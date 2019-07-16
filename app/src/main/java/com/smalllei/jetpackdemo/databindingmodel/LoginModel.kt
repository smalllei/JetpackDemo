package com.smalllei.jetpackdemo.databindingmodel

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.navigation.Navigation
import com.smalllei.jetpackdemo.R


/**
 * @author: smalllei
 * @date: 2019-07-16
 * @time: 17:33
 * @description:
 * @change:
 */
class LoginModel constructor(name: String, password: String, context: Context) {

    val mName = ObservableField<String>(name)
    val mPwd = ObservableField<String>(password)
    val mContext = context

    fun onNameChanged(s: CharSequence) {
        mName.set(s.toString())
    }

    fun onPwdChanged(s: CharSequence) {
        mPwd.set(s.toString())
    }

    fun login() {
        when {
            TextUtils.isEmpty(mName.get()) -> Toast.makeText(
                mContext,
                R.string.tip_input_name_err,
                Toast.LENGTH_SHORT
            ).show()
            TextUtils.isEmpty(mPwd.get()) -> Toast.makeText(
                mContext,
                R.string.tip_input_password_err,
                Toast.LENGTH_SHORT
            ).show()
            else -> {
                Navigation.findNavController(mContext as Activity, R.id.home_nav_main_fragment)
                    .navigate(R.id.home_fragment)
            }
        }

    }


}