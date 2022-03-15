package com.samit.utkarsh.ui.select_paper

import com.google.firebase.firestore.FirebaseFirestore
import com.samit.utkarsh.models.Paper
import com.samit.utkarsh.models.Standard
import com.samit.utkarsh.utility.Constants
import com.samit.utkarsh.utility.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class SelectPaperRepository {

    private val mPaperCollection = FirebaseFirestore.getInstance().collection(Constants.COLLECTION_STANDARD_MASTER)

    fun getPaperList(stdCode : String) = flow<State<List<Paper>>> {
        emit(State.loading())
        val paperSnap = mPaperCollection.get().await()
        val transactions = paperSnap.toObjects(Paper::class.java)
        emit(State.success(transactions))
    }.catch {
        emit(State.failed(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}