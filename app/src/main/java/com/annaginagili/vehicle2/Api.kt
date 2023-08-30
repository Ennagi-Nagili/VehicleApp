package com.annaginagili.vehicle2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("getallmanufacturers?format=json")
    fun getVehicle() : Call<Model>

    @GET("GetManufacturerDetails/{manufacturerName}?format=json")
    fun getVehicleByName(@Path("manufacturerName") name: String): Call<Model>

    @GET("GetMakeForManufacturer/{manufacturerName}?format=json")
    fun getManuByName(@Path("manufacturerName") name: String): Call<Model>
}