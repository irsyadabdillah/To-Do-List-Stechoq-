package com.irzstudio.todoliststechoq.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.irzstudio.todoliststechoq.R
import com.irzstudio.todoliststechoq.adapter.DashboardAdapter
import com.irzstudio.todoliststechoq.model.ToDosResponse
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()

    private val id: Int by lazy {
        intent.getIntExtra("id", 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        observeDetail()
        viewModel.requestDetail(id)
    }

    private fun observeDetail() {
        viewModel.detailResponse.observe(this, {
            loadDetail(it)
        })
    }

    private fun loadDetail(toDosResponse: ToDosResponse) {
        txt_detail.text = toDosResponse.title
        if (toDosResponse.status == true) {
            txt_status.text = "Completed"
        } else {
            txt_status.text = ""
        }
    }


}