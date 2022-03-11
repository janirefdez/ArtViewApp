package com.janirefernandez.artviewapp.data.model

import com.google.gson.annotations.SerializedName


data class MuseumObject(
    @SerializedName("info") val info: Info,
    @SerializedName("records") val records: List<Record>
)

data class Info(
    @SerializedName("totalrecordsperquery") val totalRecordsPerQuery: Int,
    @SerializedName("totalrecords") val totalRecords: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("page") val page: Int
)

data class Record(
    @SerializedName("accessionyear") val accessionYear: String,
    @SerializedName("technique") val technique: String,
    @SerializedName("mediacount") val mediaCount: Int,
    @SerializedName("edition") val edition: String,
    @SerializedName("totalpageviews") val totalPageViews: Int,
    @SerializedName("groupcount") val groupCount: Int,
    @SerializedName("people") val people: List<People>,
    @SerializedName("objectnumber") val objectNumber: String,
    @SerializedName("colorcount") val colorCount: Int,
    @SerializedName("lastupdate") val lastUpdate: String,
    @SerializedName("rank") val rank: Int,
    @SerializedName("imagecount") val imageCount: Int,
    @SerializedName("description") val description: String,
    @SerializedName("dateoflastpageview") val dateOfLastPageView: String,
    @SerializedName("dateoffirstpageview") val dateOfFirstPageView: String,
    @SerializedName("primaryimageurl") val primaryImageUrl: String,
    @SerializedName("dated") val dated: String,
    @SerializedName("contextualtextcount") val contextualTextCount: Int,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("period") val period: String,
    @SerializedName("url") val url: String,
    @SerializedName("provenance") val provenance: String,
    @SerializedName("publicationcount") val publicationCount: Int
)

data class People(
    @SerializedName("birthplace") val birthPlace: String,
    @SerializedName("name") val name: String,
    @SerializedName("prefix") val prefix: String,
    @SerializedName("personId") val personId: Int,
    @SerializedName("role") val role: String,
    @SerializedName("displayorder") val displayOrder: Int,
    @SerializedName("culture") val culture: String,
    @SerializedName("displaydate") val displayDate: String,
    @SerializedName("deathplace") val deathPlace: String,
    @SerializedName("displayname") val displayName: String
)
