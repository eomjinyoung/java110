package bitcamp.java110.cms.dao;

public class MandatoryValueDaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public MandatoryValueDaoException() {
        super();
    }

    public MandatoryValueDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MandatoryValueDaoException(String message) {
        super(message);
    }
    
}
