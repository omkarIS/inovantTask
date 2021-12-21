package com.example.innovantproject.Response

data class ConfigurableOption(
    val attribute_code: String,
    val attribute_id: String,
    val attributes: List<Attribute>,
    val type: String
)