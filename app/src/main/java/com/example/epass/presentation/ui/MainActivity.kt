package com.example.epass.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epass.presentation.adapters.MyRecAdapter
import com.example.epass.data.db.PassDataSource
import com.example.epass.R
import com.example.epass.data.db.Repo
import com.example.epass.domain.Pass
import com.example.epass.data.db.AppDataBase
import com.example.epass.data.db.DAO
import com.example.epass.databinding.ActivityMainBinding
import com.example.epass.frameworks.RoomDataSource
import com.example.epass.interactors.GetPasses
import com.example.epass.interactors.InsertPass
import com.example.epass.presentation.viewmodels.PassViewModel
import com.example.epass.presentation.viewmodels.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: MyRecAdapter
    private var db:AppDataBase?= null
    private var dao:DAO? = null
    private var dataSource: PassDataSource? = null
    private var sharedViewModel: PassViewModel? = null
    private var repo: Repo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = AppDataBase.getAppDB(this@MainActivity)
        dao = db?.passDao()
        dataSource = RoomDataSource(dao)
        repo =
            Repo(dataSource as PassDataSource)

        val factory = ViewModelFactory(
            GetPasses(repo as Repo),
            InsertPass(repo as Repo)
        )

        sharedViewModel = ViewModelProvider(  this@MainActivity, factory).get(PassViewModel::class.java)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        sharedViewModel?.passes?.observe( this,  Observer {
            binding.recView.adapter =
                MyRecAdapter(
                    sharedViewModel?.passes?.value ?: listOf()
                ) { pass:Pass -> showPassListener(pass)}
        })

        binding.btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, ActivityAddPass::class.java)
            startActivity(intent)
        })

        binding.btnSettings.setOnClickListener(View.OnClickListener {

        })

        /*binding.topBar.setOnMenuItemClickListener{
            menuitem ->
            when(menuitem.itemId)
            {
                R.id.settings -> {
                    Log.i("clicked", "setting")
                    true
                }
                R.id.add ->{
                    val intent = Intent(applicationContext, ActivityAddPass::class.java)
                    startActivity(intent)
                    true
                }
                else -> false


            }
        }*/
    }
    
    private fun initViews()
    {
        val passesList = listOf(
            Pass(
                0,
                "Пропуск в Сбер"
            ), Pass(0, "Пропуск в Урфу")
        )
        adapter =
            MyRecAdapter(passesList) { pass:Pass -> showPassListener(pass)}
        binding.recView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recView.adapter = adapter
    }

    fun showPassListener(pass:Pass){
        val intent = Intent(this@MainActivity,ActivityPass::class.java)
        intent.putExtra("name",pass.name)
        startActivity(intent)
    }
}