package com.example.newsapp

class News {

    private lateinit var imageNews : String
    private lateinit var titleNews : String
    private lateinit var detailNews : String

    constructor(){}

    constructor(imageNew: String, titleNew: String, detailUrl: String) {
        this.imageNews = imageNew
        this.titleNews= titleNew
        this.detailNews = detailUrl
    }

    fun getImageNew(): String{ return this.imageNews}
    fun setImageNew(imageNew: String){ this.imageNews = imageNew}

    fun getTitleNew(): String{ return this.titleNews}
    fun setTitleNew(titleNew: String){ this.titleNews = titleNew}

    fun getDetailUrl(): String{ return this.detailNews}
    fun setDetailUrl(detailUrl: String){ this.detailNews = detailUrl}
}