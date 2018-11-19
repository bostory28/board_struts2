package board.member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.common.SqlSessionFactoryConfig;

public class MemberDAO {
	private SqlSessionFactory factory = SqlSessionFactoryConfig.getInstance();
	
	public MemberVO login(MemberVO vo) {
		SqlSession sqlsession = null;
		MemberVO membervo = null;
		try {
			sqlsession = factory.openSession();
			membervo = sqlsession.selectOne("member.login", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null)
				sqlsession.close();
		}
		return membervo;
	}
	
	public MemberVO login(String id) {
		SqlSession sqlsession = null;
		MemberVO membervo = null;
		try {
			sqlsession = factory.openSession();
			membervo = sqlsession.selectOne("member.getByid", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null)
				sqlsession.close();
		}
		return membervo;
	}
	
	public void memberJoin(MemberVO vo) {
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			sqlsession.insert("member.memberJoin", vo);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null)
				sqlsession.close();
		}
	}
	
	public void memberUpdate(MemberVO vo) {
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			sqlsession.update("member.memberupdate", vo);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null)
				sqlsession.close();
		}
	}
	
	public void out(String id) {
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			sqlsession.delete("member.out", id);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null)
				sqlsession.close();
		}
	}
}
