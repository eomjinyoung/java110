package bitcamp.java110.cms.service;

import bitcamp.java110.cms.domain.Member;

public interface AuthService {
    Member getMember(String email, String password, String memberType);
    Member getFacebookMember(String accessToken, String memberType);
}
