package com.irzstudio.todoliststechoq.remote

import com.irzstudio.todoliststechoq.model.ToDosResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("todos")
    fun getTodos(    ): Observable<ArrayList<ToDosResponse>>

    @GET("todos/{todos_id}")
    fun getIdToDos(
        @Path("todos_id") id : Int
    ): Observable<ToDosResponse>
}