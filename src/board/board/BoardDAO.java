package board.board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.common.SqlSessionFactoryConfig;

public class BoardDAO {
	private SqlSessionFactory factory = SqlSessionFactoryConfig.getInstance();
	
	public List<BoardVO> getAllData() {
		List<BoardVO> list = null;
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			list = sqlsession.selectList("board.getBoardData");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
		return list;
	}
	public BoardVO getData(int boardnum) {
		BoardVO vo = null;
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			vo = sqlsession.selectOne("board.getData", boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
		return vo;
	}
	
	public void insertReply(ReplyVO vo) {
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			sqlsession.insert("board.insertReply", vo);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
	}
	
	public List<ReplyVO> getReplyInBaord(int boardnum) {
		SqlSession sqlsession = null;
		List<ReplyVO> list = null;
		try {
			sqlsession = factory.openSession();
			list = sqlsession.selectList("board.getReplyInBaord", boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
		return list;
	}
	
	public void deleteReplyInBaord(int replynum) {
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			sqlsession.insert("board.deleteReplyInBaord", replynum);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
	}
	
	public void writeBoard(String id, String title, String content, String file) {
		SqlSession sqlsession = null;
		HashMap<String, Object> hashmap = new HashMap<>();
		hashmap.put("viewcount", 0);
		hashmap.put("id", id);
		hashmap.put("title", title);
		hashmap.put("content", content);
		hashmap.put("file", file);
		try {
			sqlsession = factory.openSession();
			int i = sqlsession.insert("board.writeBoard", hashmap);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
	}
	public void boardDelete(int boardnum) {
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			sqlsession.delete("board.boardDelete", boardnum);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
	}
	public void editBaord(BoardVO board) {
		SqlSession sqlsession = null;
		try {
			sqlsession = factory.openSession();
			sqlsession.update("board.editBaord", board);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlsession != null) sqlsession.close();
		}
	}
}
