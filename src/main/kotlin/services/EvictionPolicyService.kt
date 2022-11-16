package services

import models.CacheData

interface EvictionPolicyService {
    fun getKeyForEviction(map: Map<String, CacheData>): String
}