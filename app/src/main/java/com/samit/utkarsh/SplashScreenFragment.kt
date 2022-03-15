package com.samit.utkarsh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.samit.utkarsh.utility.jetpack_datastore.UserDataStore
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashScreenFragment : Fragment(), CoroutineScope {
    private lateinit var userPreferences: UserDataStore
    private var isLogin : String? =  null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + Job()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val imageView: ImageView = view.findViewById(R.id.ivSplash)
        Glide.with(this).load(R.drawable.splash_bg).into(imageView)

        userPreferences = UserDataStore(requireActivity())

        userPreferences.isLogin.asLiveData().observe(this.viewLifecycleOwner, Observer {
            it.let {
                isLogin = it
            }

        })
        launch {
            delay(2500)
            withContext(Dispatchers.Main){
                //if(isLogin.equals("Y")){
                if(true){
                    Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_selectStandardFragment)
                }else{
                    //Navigation.findNavController(view).navigate(R.id.action_splashFragment_to_login)
                }

            }
        }
    }
}