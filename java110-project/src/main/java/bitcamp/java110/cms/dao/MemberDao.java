package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Member;

public interface MemberDao {
    int insert(Member member);
    int delete(int no);
}
