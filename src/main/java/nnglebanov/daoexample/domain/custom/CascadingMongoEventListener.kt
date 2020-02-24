package nnglebanov.daoexample.domain.custom

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mapping.MappingException
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.MongoId
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent
import org.springframework.util.ReflectionUtils

import java.lang.reflect.Field

class CascadingMongoEventListener : AbstractMongoEventListener<Any>() {

    @Autowired
    private val mongoOperations: MongoOperations? = null

    override fun onBeforeConvert(event: BeforeConvertEvent<Any>) {
        val source = event.source
        ReflectionUtils.doWithFields(source.javaClass) { field ->
            ReflectionUtils.makeAccessible(field)

            if (field.isAnnotationPresent(DBRef::class.java) && field.isAnnotationPresent(CascadeSave::class.java)) {
                val fieldValue = field.get(source)

                if (fieldValue is List<*>) {
                    for (item in fieldValue) {
                        if (item != null) {
                            checkNSave(item)
                        }
                    }
                } else {
                    checkNSave(fieldValue)
                }
            }
        }
    }

    private fun checkNSave(fieldValue: Any) {
        val callback = DbRefFieldCallback()
        ReflectionUtils.doWithFields(fieldValue.javaClass, callback)
        if (!callback.isIdFound) {
            throw MappingException("Oops, something went wrong. Child doesn't have @Id?")
        }
        mongoOperations!!.save(fieldValue)
    }

    private class DbRefFieldCallback : ReflectionUtils.FieldCallback {
        var isIdFound: Boolean = false
            private set

        @Throws(IllegalArgumentException::class, IllegalAccessException::class)
        override fun doWith(field: Field) {
            ReflectionUtils.makeAccessible(field)
            if (field.isAnnotationPresent(MongoId::class.java)) {
                isIdFound = true
            }
        }
    }
}