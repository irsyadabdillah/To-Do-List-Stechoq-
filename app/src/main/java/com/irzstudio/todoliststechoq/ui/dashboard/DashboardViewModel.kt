package com.irzstudio.todoliststechoq.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irzstudio.todoliststechoq.data.Repository
import com.irzstudio.todoliststechoq.model.ToDosResponse
import io.reactivex.disposables.CompositeDisposable

class DashboardViewModel( val repository: Repository) : ViewModel() {

    private val _todosResponse = MutableLiveData<ArrayList<ToDosResponse>>()
    val todosResponse : LiveData<ArrayList<ToDosResponse>> = _todosResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    val loading = MutableLiveData<Boolean>()

    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun requestTodos() {
        val todosDisposable = repository.getTodos()
            .doOnSubscribe { loading.postValue(true) }
            .doFinally { loading.postValue(false) }
            .subscribe({_todosResponse.postValue(it)}, {_errorMessage.postValue(it.localizedMessage)})
        compositeDisposable.add(todosDisposable)
    }

}