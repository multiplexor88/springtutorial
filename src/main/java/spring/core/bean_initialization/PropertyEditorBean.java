package spring.core.bean_initialization;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Created by multi on 25.04.2016.
 */
public class PropertyEditorBean {
    private byte [] bytes;
    private Class cls;
    private Boolean trueOrFalse;
    private List<String> stringList;
    private Date date;
    private Float floatValue;
    private File file;
    private InputStream stream;
    private Locale locale;
    private Pattern pattern;
    private Properties properties;
    private String trimString;
    private URL url;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        System.out.println("Setting bytes: " + bytes.length);
        this.bytes = bytes;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        System.out.println("Setting class: " + cls);
        this.cls = cls;
    }

    public Boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Setting bool: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("setStringList: " + stringList);
        this.stringList = stringList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        System.out.println("setDate: " + date);
        this.date = date;
    }

    public Float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("setFloatValue: " + floatValue);
        this.floatValue = floatValue;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        System.out.println("setFile: " + file);
        this.file = file;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        System.out.println("setStream: " + stream);
        this.stream = stream;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        System.out.println("setLocale: " + locale);
        this.locale = locale;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("setPattern: " + pattern);
        this.pattern = pattern;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        System.out.println("setProperties: " + properties);
        this.properties = properties;
    }

    public String getTrimString() {
        return trimString;
    }

    public void setTrimString(String trimString) {
        System.out.println("setTrimString: " + trimString);
        this.trimString = trimString;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        System.out.println("setUrl: " + url);
        this.url = url;
    }

    public static class CustomPropertyEditor implements PropertyEditorRegistrar{
        @Override
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            registry.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }
}
