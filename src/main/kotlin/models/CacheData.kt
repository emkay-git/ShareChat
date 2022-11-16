package models

data class CacheData (
    val value: String,
    val timestamp: Long,
    val ttl: Int = 1 // seconds
)
