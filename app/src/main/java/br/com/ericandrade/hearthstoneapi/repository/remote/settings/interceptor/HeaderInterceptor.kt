package br.com.ericandrade.hearthstoneapi.repository.remote.settings.interceptor


import br.com.ericandrade.hearthstoneapi.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
            .addHeader(X_RAPIDAPI_KEY, BuildConfig.API_KEY)
            .addHeader(X_RAPIDAPI_HOST, BuildConfig.API_HOST)

        return chain.proceed(builder.build())
    }

    companion object {
        private const val X_RAPIDAPI_KEY = "X-RapidAPI-Key"
        private const val X_RAPIDAPI_HOST = "X-RapidAPI-Host"
    }
}