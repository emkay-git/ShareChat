package services

import models.CacheData

class OldestKeyEvictionService: EvictionPolicyService {
    override fun getKeyForEviction(map: Map<String, CacheData>): String {
        return map.entries.minByOrNull { it.value.timestamp }!!.key
    }
}