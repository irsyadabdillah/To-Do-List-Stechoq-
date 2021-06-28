package com.irzstudio.todoliststechoq.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.todoliststechoq.data.Repository
import com.irzstudio.todoliststechoq.model.ToDosResponse
import io.reactivex.disposables.CompositeDisposable

class DetailViewModel(val repository: Repository) : ViewModel() {

    private val _detailResponse = MutableLiveData<ToDosResponse>()
    val detailResponse: LiveData<ToDosResponse> = _detailResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun requestDetail(id: Int) {
        val detailDisposable = repository.getTodosById(id)
            .doOnSubscribe { }
            .doFinally { }
            .subscribe({ _detailResponse.postValue(it) }, { _errorMessage.postValue(it.localizedMessage) })
        compositeDisposable.add(detailDisposable)
    }
}