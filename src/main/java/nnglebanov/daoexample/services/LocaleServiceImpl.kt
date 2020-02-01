package nnglebanov.daoexample.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocaleServiceImpl implements LocaleService {

    private final MessageSource ms;
    private Locale locale;

    public LocaleServiceImpl(MessageSource ms, @Value("${localization.locale}") String localeTag) {
        this.ms = ms;
        this.locale = new Locale.Builder().setLanguageTag(localeTag).build();
    }

    @Override
    public Resource getLocalizedFile(String fileName) {
        String path = "/localizedFiles/" + fileName + "_" + locale.getLanguage() + ".csv";
        return new ClassPathResource(path);
    }

    @Override
    public String getMessage(String property) {
        return ms.getMessage(property, null, locale);
    }

    @Override
    public void setLocale(String locale) {
        this.locale = new Locale.Builder().setLanguage(locale).build();
    }
}