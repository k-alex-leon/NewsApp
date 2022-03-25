package com.example.newsapp

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView

    private var loader : AsyncTask<Void, Void, MutableList<News>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        loader = getWebInfo(this, mRecyclerView, this)
        loader!!.execute()

    }

    internal class getWebInfo(var activity: AppCompatActivity?, mRecyclerView: RecyclerView, context: Context)
        : AsyncTask<Void, Void, MutableList<News>>(){

        var recyclerView = mRecyclerView
        lateinit var newsAdapter : NewsAdapter
        var context = context

        override fun doInBackground(vararg p0: Void?): MutableList<News> {
            val newsList = mutableListOf<News>()

            try {

                val url = "https://vandal.elespanol.com/noticias/videojuegos"
                val doc = Jsoup.connect(url).get()

                val elements : Elements = doc.select("div.caja620")

                for (i in 0 until elements.size){
                    val imgUrl = elements.select("img.lazy_portada").eq(i).attr("data-src")
                    val title = elements.select("a").eq(i).attr("title")
                    val detail = elements.select("a").eq(i).attr("href")

                    Log.d("data", "img: $imgUrl title: $title detail: $detail")

                    newsList.add(News(imgUrl, title, detail))
                }

            }catch (e : IOException){
                print(e)
            }

            return newsList
        }

        override fun onPostExecute(result: MutableList<News>) {
            super.onPostExecute(result)
            newsAdapter = NewsAdapter(result, context)
            recyclerView.adapter = newsAdapter
        }
    }
}