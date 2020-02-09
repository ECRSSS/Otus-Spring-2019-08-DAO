package nnglebanov.daoexample.services

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.MessageSource
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import java.util.*

@Service
class LocaleServiceImpl(private val ms: MessageSource, @Value("\${localization.locale}") localeTag: String) : LocaleService {
    private var locale: Locale? = null

    init {
        this.locale = Locale.Builder().setLanguageTag(localeTag).build()
    }

    override fun getLocalizedFile(fileName: String): Resource {
        val path = "/localizedFiles/" + fileName + "_" + locale!!.language + ".csv"
        return ClassPathResource(path)
    }

    override fun getMessage(property: String): String {
        return ms.getMessage(property, null, locale!!)
    }

    override fun setLocale(locale: String) {
        this.locale = Locale.Builder().setLanguage(locale).build()
    }
}