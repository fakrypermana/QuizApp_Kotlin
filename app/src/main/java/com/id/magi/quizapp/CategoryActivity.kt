package com.id.magi.quizapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.id.magi.quizapp.Adapter.CategoryAdapter
import com.id.magi.quizapp.Common.SpacesItemDecoration
import com.id.magi.quizapp.DBHelper.DBHelper
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        toolbar_category.title = "QuizApp"
        setSupportActionBar(toolbar_category)

        rv_category.setHasFixedSize(true)
        rv_category.layoutManager = GridLayoutManager(this, 2)

        val adapter = CategoryAdapter(this, DBHelper.getInstance(this).allCategories)
        rv_category.addItemDecoration(SpacesItemDecoration(4))
        rv_category.adapter = adapter
    }
}
