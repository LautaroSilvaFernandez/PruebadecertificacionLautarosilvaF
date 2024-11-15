package com.example.pruebadecertificacionlautarosilvaf



    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    class RetrofitSignos {

        companion object {

            private const val BASE_URL = "https://zodiac-api-two.vercel.app/es/sign"

            lateinit var retrofitInstance: Retrofit
            fun retrofitInstance(): SignosApi {
                val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                    GsonConverterFactory.create()
                ).build()
                return retrofit.create(SignosApi::class.java)
            }
        }

}