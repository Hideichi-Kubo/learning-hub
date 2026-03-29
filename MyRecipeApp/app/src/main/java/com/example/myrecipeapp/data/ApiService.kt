package com.example.myrecipeapp.data

import com.example.myrecipeapp.common.Constants.BASE_URL
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// MoshiはJSONをKotlinのデータクラスに変換するライブラリ
// codegenで生成されたアダプターを自動的に使用するため、追加設定は不要
private val moshi = Moshi.Builder()
    .build()

// RetrofitはHTTP通信を簡単に扱えるライブラリ
// ベースURLとJSONコンバーター（Moshi）を設定してビルドする
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

// Retrofitがインターフェースの定義をもとに通信処理を自動生成したオブジェクト
// アプリ全体で共有するためトップレベルに定義している
val recipeApiService = retrofit.create(ApiService::class.java)


// APIのエンドポイントを定義するインターフェース
// Retrofitがこの定義をもとに実際の通信処理を実装してくれる
interface ApiService {
    // @GETはHTTPのGETリクエストを示すアノテーション
    // 引数にはBASE_URLからの相対パスを指定する
    @GET("categories.php")
    // suspendはコルーチン内で呼び出せる非同期関数を表すキーワード
    // 戻り値はMoshiが自動的にJSONからCategoriesResponseに変換する
    suspend fun getCategories(): CategoriesResponse
}
