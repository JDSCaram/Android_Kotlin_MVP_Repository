package com.bodeslab.architectureexamplekotlin.network.api.breed

import com.google.gson.annotations.SerializedName
import com.bodeslab.architectureexamplekotlin.network.api.BaseResponse


/**
 * {Created by Jonatas Caram on 24/05/2018}.
 */

class BreedsResponse : BaseResponse() {
    var total: Int? = 0

    @SerializedName("per_page")
    var perPage: Int? = 0

    @SerializedName("current_page")
    var currentPage: Int? = 0

    @SerializedName("last_page")
    var lastPage: Int? = 0

    @SerializedName("next_page_url")
    var nextPageUrl: String? = null

    @SerializedName("prev_page_url")
    var prevPageUrl: String? = null

    var from: Int? = 0
    var to: Int? = 0

    var data: ArrayList<Breeds>? = null
}

data class Breeds(var breed: String?,
                  var country: String?,
                  var origin: String?,
                  var coat: String?,
                  var pattern: String?)
