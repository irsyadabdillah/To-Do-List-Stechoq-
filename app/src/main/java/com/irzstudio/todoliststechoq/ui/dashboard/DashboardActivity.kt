package com.irzstudio.todoliststechoq.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.irzstudio.todoliststechoq.R
import com.irzstudio.todoliststechoq.adapter.DashboardAdapter
import com.irzstudio.todoliststechoq.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.koin.android.viewmodel.ext.android.viewModel

class DashboardActivity : AppCompatActivity() {

    private val dashboardAdapter: DashboardAdapter by lazy {
        DashboardAdapter { todosRespone, view ->
            val intent = Intent(applicationContext, DetailActivity::class.java )
            intent.putExtra("id", todosRespone.id)
            startActivity(intent)
        }
    }

    private val viewModel: DashboardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setListTodos()
        observeTodos()
        observeLoading()
        viewModel.requestTodos()
    }

    private fun observeTodos() {
        viewModel.todosResponse.observe(this, {
            dashboardAdapter.setDataAdapter(it)
        })
    }

    private fun observeLoading() {
        viewModel.loading.observe(this, {
            flipper.displayedChild = if (it) 1 else 0
        })
    }

    private fun setListTodos() {
        rv_task.setHasFixedSize(true)
        rv_task.layoutManager = LinearLayoutManager(this)
        rv_task.adapter = dashboardAdapter
    }
}