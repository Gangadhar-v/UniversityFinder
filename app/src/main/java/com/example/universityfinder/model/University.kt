package com.example.universityfinder.model

data class University(
    val name: String,
    val alpha_two_code: String,
    val domains: List<String>,
    val state_province: String?,
    val country: String,
    val web_pages: List<String>
)
