package com.samit.utkarsh.ui.select_standard

import android.os.Bundle
import androidx.navigation.Navigation


import com.samit.mytodo.ui.base.BaseFragment
import com.samit.utkarsh.R

import com.samit.utkarsh.databinding.FragmentSelectStandardBinding



class SelectStandardFragment :
    BaseFragment<FragmentSelectStandardBinding, SelectStanardViewModel, SelectStandardViewModelFactory>() {
    override fun getFragmentView() = R.layout.fragment_select_standard
    override fun getViewModel() = SelectStanardViewModel::class.java
    override fun getViewModelFactory() = SelectStandardViewModelFactory()



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.txtNext.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_selectStandardFragment_to_selectPaperFragment)
        }

    }

}