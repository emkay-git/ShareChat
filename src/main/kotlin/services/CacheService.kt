package services

import com.google.inject.Inject
import com.google.inject.Singleton
import repository.CacheRepository
import repository.CacheRepositoryImpl

@Singleton
class CacheService(private val cacheRepositoryImpl: CacheRepositoryImpl) {
    fun setKey(key: String, value: String) {
        cacheRepositoryImpl.setData(key, value)
    }

    fun getKey(key: String): String {
        return cacheRepositoryImpl.getData(key)
    }

    fun deleteKey(key: String) {
        cacheRepositoryImpl.deleteData(key)
    }

    fun displayMap() = cacheRepositoryImpl.displayMap()
}