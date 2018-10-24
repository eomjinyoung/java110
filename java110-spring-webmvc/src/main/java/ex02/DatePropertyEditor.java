package ex02;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

// String ==> java.util.Date 프로퍼티 값 변환기
//
public class DatePropertyEditor extends PropertyEditorSupport {
    
    SimpleDateFormat format;
    
    public DatePropertyEditor(SimpleDateFormat format) {
        this.format = format;
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            this.setValue(format.parse(text));
            
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    @Override
    public Object getValue() {
        return super.getValue();
    }
}










