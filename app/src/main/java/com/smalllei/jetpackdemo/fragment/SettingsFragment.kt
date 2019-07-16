package com.smalllei.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
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
class SettingsFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.settings_tv_name).setOnClickListener {
//            val args = Bundle()
//            args.putString("from","NewsFragment")
//            Navigation.createNavigateOnClickListener(R.id.next_action)
            findNavController().navigate(R.id.login_fragment)
        }
    }



}
