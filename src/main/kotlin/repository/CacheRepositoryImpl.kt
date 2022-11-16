package repository

import com.google.inject.Singleton
import models.CacheData
import services.EvictionPolicyService

@Singleton
class CacheRepositoryImpl constructor(
    private val cacheSize: Int,
    private val evictionPolicyService: EvictionPolicyService
) : CacheRepository {
    private val errorMessage = "Key is not present in map"

    private val map: MutableMap<String, CacheData> = mutableMapOf()

    override fun getData(key: String): String {
        return map[key]?.value ?: error(errorMessage)
    }

    override fun setData(key: String, value: String) {
        if (map.containsKey(key).not() && map.size >= cacheSize) {
            val key = evictionPolicyService.getKeyForEviction(map)
            deleteData(key)
        }
        val cacheData = CacheData(value = value, timestamp = System.currentTimeMillis())
        map[key] = cacheData
    }

    override fun deleteData(key: String) {
        println("Deleting Key $key")
        map[key] ?: error(errorMessage)
        map.remove(key)
    }

    fun displayMap() {
        println(map)
    }
}