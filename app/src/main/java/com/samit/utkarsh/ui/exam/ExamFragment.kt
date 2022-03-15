package com.samit.utkarsh.ui.exam

import android.os.Bundle
import com.samit.mytodo.ui.base.BaseFragment
import com.samit.utkarsh.R
import com.samit.utkarsh.databinding.FragmentExamBinding
import com.samit.utkarsh.databinding.FragmentSelectPaperBinding

class ExamFragment :
    BaseFragment<FragmentExamBinding, ExamViewModel, ExamViewModelFactory>() {
    override fun getFragmentView() = R.layout.fragment_exam
    override fun getViewModel() = ExamViewModel::class.java
    override fun getViewModelFactory() = ExamViewModelFactory()



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}