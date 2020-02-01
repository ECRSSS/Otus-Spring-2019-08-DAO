package nnglebanov.daoexample

import com.github.cloudyrock.mongock.Mongock
import com.github.cloudyrock.mongock.SpringBootMongockBuilder
import com.mongodb.MongoClient
import nnglebanov.daoexample.changelog.DatabaseChangelog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class MongoBeeConfig {


    @Autowired
    private val mongo: MongoClient? = null


    @Bean
    open fun mongoClient(): MongoClient {
        return MongoClient("127.0.0.1")
    }

    @Bean
    open fun mongock(applicationContext: ApplicationContext, mongoClient: MongoClient): Mongock {
        return SpringBootMongockBuilder(mongoClient, "test", DatabaseChangelog::class.java.`package`.name)
                .setApplicationContext(applicationContext)
                .setLockQuickConfig()
                .build()
    }
}
