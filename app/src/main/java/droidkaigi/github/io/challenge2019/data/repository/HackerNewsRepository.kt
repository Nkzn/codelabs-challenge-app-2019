package droidkaigi.github.io.challenge2019.data.repository

import droidkaigi.github.io.challenge2019.data.api.HackerNewsApi
import droidkaigi.github.io.challenge2019.data.api.response.Item
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HackerNewsRepository {

    companion object {
        private const val BASE_URL = "https://hacker-news.firebaseio.com/v0/"
    }

    private val hackerNewsApi by lazy { Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build().create(HackerNewsApi::class.java) }

    fun getItem(id: Long): Call<Item> {
        return hackerNewsApi.getItem(id)
    }

    fun getTopStories(): Call<List<Long>> {
        return hackerNewsApi.getTopStories()
    }
}