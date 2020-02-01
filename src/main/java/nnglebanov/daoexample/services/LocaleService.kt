package nnglebanov.daoexample.services

import org.springframework.core.io.Resource

interface LocaleService {

    fun getMessage(property: String): String

    fun getLocalizedFile(fileName: String): Resource

    fun setLocale(locale: String)
}