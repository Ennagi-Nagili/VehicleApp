package com.annaginagili.vehicle2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {
    private var vehicleLiveData = MutableLiveData<Model>()
    fun getVehicle() {
        RetrofitClient.getInstance().getApi().getVehicle().enqueue(object:
            Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.body()!=null){
                    vehicleLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hello",t.message.toString())
            }
        })
    }

    fun getVehicleByName(name: String) {
        RetrofitClient.getInstance().getApi().getVehicleByName(name).enqueue(object:
            Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.body()!=null){
                    vehicleLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hello",t.message.toString())
            }
        })
    }

    fun getManuByName(name: String) {
        RetrofitClient.getInstance().getApi().getManuByName(name).enqueue(object:
            Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                if (response.body()!=null){
                    vehicleLiveData.value = response.body()!!
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("hello",t.message.toString())
            }
        })
    }

    fun observeVehicleLiveData() : LiveData<Model> {
        return vehicleLiveData
    }
}