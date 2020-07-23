package com.andresaftari.submissionfinal.utils.helper

import android.content.Context
import android.util.Log
import com.andresaftari.submissionfinal.data.remote.response.DataResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JSONHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<DataResponse> {
        val list = ArrayList<DataResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listJson = responseObject.getJSONArray("movies")

            for (index in 0 until listJson.length()) {
                val movie = listJson.getJSONObject(index)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val genre = movie.getString("genre")
                val description = movie.getString("description")
                val imagePath = movie.getString("imagePath")

                val response = DataResponse(id, title, genre, description, imagePath)
                list.add(response)
            }
        } catch (e: JSONException) {
            Log.i("JSONHelper.loadMovies", "Failed! ${e.message} - ${e.printStackTrace()}")
        }
        return list
    }

    fun loadShows(): List<DataResponse> {
        val list = ArrayList<DataResponse>()

        try {
            val responseObject = JSONObject(parsingFileToString("ShowResponse.json").toString())
            val listJson = responseObject.getJSONArray("shows")

            for (index in 0 until listJson.length()) {
                val show = listJson.getJSONObject(index)

                val id = show.getString("id")
                val title = show.getString("title")
                val genre = show.getString("genre")
                val description = show.getString("description")
                val imagePath = show.getString("imagePath")

                val response = DataResponse(id, title, genre, description, imagePath)
                list.add(response)
            }
        } catch (e: JSONException) {
            Log.i("JSONHelper.loadShows", "Failed! ${e.message} - ${e.printStackTrace()}")
        }
        return list
    }
}