package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNIS : TextView
    private lateinit var inputNama : TextView
    private lateinit var jkLakilaki : RadioButton
    private lateinit var jkPerempuan : RadioButton
    private lateinit var btnSimpan : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNIS = findViewById(R.id.txtInputNIS)
        inputNama = findViewById(R.id.txtInputNama)
        jkLakilaki = findViewById(R.id.rbLakiLaki)
        jkPerempuan = findViewById(R.id.rbPerempuan)
        btnSimpan = findViewById(R.id.btnSimpan)
        recyclerView = findViewById(R.id.listData)

        val data = mutableListOf<SiswaData>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = SiswaAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        btnSimpan.setOnClickListener{
            val nis = inputNIS.text.toString()
            val nama = inputNama.text.toString()
            var jk = ""
            if (jkLakilaki.isChecked){
                jk = "Laki-Laki"
            }else{
                jk = "Perempuan"
            }
            val siswa = SiswaData(nis,nama,jk)
            data.add(siswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}