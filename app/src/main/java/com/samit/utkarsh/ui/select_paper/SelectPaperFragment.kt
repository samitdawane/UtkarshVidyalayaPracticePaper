package com.samit.utkarsh.ui.select_paper

import android.os.Bundle
import androidx.navigation.Navigation
import com.samit.mytodo.ui.base.BaseFragment
import com.samit.utkarsh.R
import com.samit.utkarsh.databinding.FragmentSelectPaperBinding

class SelectPaperFragment :
    BaseFragment<FragmentSelectPaperBinding, SelectPaperViewModel, SelectPaperViewModelFactory>() {
    override fun getFragmentView() = R.layout.fragment_select_paper
    override fun getViewModel() = SelectPaperViewModel::class.java
    override fun getViewModelFactory() = SelectPaperViewModelFactory()



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.llMarathi.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_selectPaperFragment_to_examFragment)
        }
    }

}