package com.smalllei.jetpackdemo.fragment

import android.app.Notification
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.smalllei.jetpackdemo.R


/**
 * @author: smalllei
 * @date: 2019-07-15
 * @time: 17:18
 * @description:
 * @change:
 */
class NewsFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.news_tv_name).setOnClickListener {
               findNavController().navigate(R.id.about_us_fragment)
        }
    }



}
