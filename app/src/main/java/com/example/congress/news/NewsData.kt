package com.example.congress.news

data class NewsData(
    var type: Int,
    var image: String? = null,
    var mainText: String? = null,
    var subText: String? = null
)
