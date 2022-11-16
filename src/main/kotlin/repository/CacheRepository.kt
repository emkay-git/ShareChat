package repository

interface CacheRepository {
    fun getData(key: String): String

    fun setData(key: String, value: String)

    fun deleteData(key: String)
}