package com.samit.utkarsh.ui.select_standard

import com.google.firebase.firestore.FirebaseFirestore
import com.samit.utkarsh.models.Standard
import com.samit.utkarsh.utility.Constants
import com.samit.utkarsh.utility.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class SelectStandardRepository {

    private val mStandardCollection = FirebaseFirestore.getInstance().collection(Constants.COLLECTION_STANDARD_MASTER)

    fun getStandardList() = flow<State<List<Standard>>> {
        emit(State.loading())
        val userSnap = mStandardCollection.get().await()

        val transactions = userSnap.toObjects(Standard::class.java)
        emit(State.success(transactions))
    }.catch {
        emit(State.failed(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}