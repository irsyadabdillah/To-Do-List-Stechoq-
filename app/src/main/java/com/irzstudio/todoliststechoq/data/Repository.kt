package com.irzstudio.todoliststechoq.data

import com.irzstudio.todoliststechoq.model.ToDosResponse
import com.irzstudio.todoliststechoq.remote.Api
import com.irzstudio.todoliststechoq.remote.RetrofitClient
import io.reactivex.Observable

class Repository(val api: Api) {

    fun getTodos() : Observable<ArrayList<ToDosResponse>> {
        return RetrofitClient.instance.getTodos()
    }

    fun getTodosById(id: Int) : Observable<ToDosResponse> {
        return RetrofitClient.instance.getIdToDos(id)
    }
}