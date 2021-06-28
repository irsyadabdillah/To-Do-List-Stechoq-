package com.irzstudio.todoliststechoq.listener

import com.irzstudio.todoliststechoq.model.ToDosResponse

interface OnClickListener {
    fun onClick(toDosResponse: ToDosResponse)
}