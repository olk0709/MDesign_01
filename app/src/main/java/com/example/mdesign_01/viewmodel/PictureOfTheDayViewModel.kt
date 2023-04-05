package com.example.mdesign_01.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mdesign_01.BuildConfig
import com.example.mdesign_01.model.PictureOfTheDayResponseData
import com.example.mdesign_01.model.RepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(private val liveData:MutableLiveData<AppState> = MutableLiveData<AppState>(),
                               private val repositoryImpl: RepositoryImpl=RepositoryImpl()):
    ViewModel() {

    fun getLiveData():MutableLiveData<AppState>{
        return liveData
    }

    fun sendRequest(){
        liveData.postValue(AppState.Loading)
        repositoryImpl.getPictureOfTheDayApi().getPictureOfTheDay(BuildConfig.NASA_API_KEY)
            .enqueue(callback)
        }

   private val callback = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ){
            if (response.isSuccessful){
                liveData.postValue(AppState.Success(response.body()!!))
            }else{
                liveData.postValue(AppState.Error(throw java.lang.IllegalStateException("что-то пошло не так")))
            }

        }
        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t:Throwable){

        }
    }
}