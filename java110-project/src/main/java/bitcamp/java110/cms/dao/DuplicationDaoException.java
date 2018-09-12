package bitcamp.java110.cms.dao;

public class DuplicationDaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicationDaoException() {
        super();
    }

    public DuplicationDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationDaoException(String message) {
        super(message);
    }
    
}
