package spring.core.bean_initialization;

import java.beans.PropertyEditorSupport;

/**
 * Created by multi on 25.04.2016.
 */
public class CustomUserNameEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] args = text.split("\\s");
        super.setValue(new UserName(args[0], args[1]));
    }
}
