import com.google.inject.Guice
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import repository.CacheRepositoryImpl
import services.CacheService
import services.OldestKeyEvictionService
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleTest {
    private val injector = Guice.createInjector()

    @BeforeAll
    fun setup() {}

    @AfterAll
    fun tearDown() {}

    @Test
    fun `should run dummy test`() {
        assertEquals(5, 5)

        val cacheRepositoryImpl = CacheRepositoryImpl(5, OldestKeyEvictionService())
        val cacheService = CacheService(cacheRepositoryImpl)

        cacheService.setKey("123", "Test Data 1")
        println(cacheService.getKey("123"))
        cacheService.deleteKey("123")
        println(cacheService.getKey("123"))
    }

    @Test
    fun `should throw error for excess`() {
//        assertEquals(5, 5)

        val cacheRepositoryImpl = CacheRepositoryImpl(2, OldestKeyEvictionService())
        val cacheService = CacheService(cacheRepositoryImpl)

        cacheService.setKey("123", "Test Data 1")
        cacheService.setKey("124", "Test Data 1")
        cacheService.setKey("124", "Test Data 1")

        cacheService.displayMap()
//        println(cacheService.getKey("123"))
//        cacheService.deleteKey("123")
//        println(cacheService.getKey("123"))
    }

    @Test
    fun `should delete oldest key for excess items`() {
//        assertEquals(5, 5)
        val oldestEvictionPolicy = OldestKeyEvictionService()
        val cacheRepositoryImpl = CacheRepositoryImpl(2, oldestEvictionPolicy)
        val cacheService = CacheService(cacheRepositoryImpl)

        cacheService.setKey("123", "Test Data 1")
        cacheService.setKey("124", "Test Data 2")
        cacheService.displayMap()
        cacheService.setKey("125", "Test Data 3")
        cacheService.displayMap()
    }
}