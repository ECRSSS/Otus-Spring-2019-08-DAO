package nnglebanov.daoexample.helpers

import org.apache.commons.lang3.RandomStringUtils

class Utils {
    companion object {
        fun generateId(): String {
            return RandomStringUtils.randomAlphabetic(7)
        }
    }
}