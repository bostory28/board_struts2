package board.board;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import board.member.MemberDAO;

import com.opensymphony.xwork2.ActionSupport;

public class BoardAction extends ActionSupport implements SessionAware {
	private int boardnum;
	private String retext;
	private BoardVO board;
	private ReplyVO reply;
	private List<BoardVO> list;
	private List<ReplyVO> replylist;
	private boolean loginCheck;
	private Map<String, Object> session;
	private int replynum;
	private String title;
	private String content;
	private String file;
	private String id;
	
	
	public String replyInsert() throws Exception {
		String id = (String)session.get("id");
		if(id != null) {
			loginCheck = true;
			BoardDAO dao = new BoardDAO();
			dao.insertReply(reply);
		}
		else 
		loginCheck = false;
		
		return SUCCESS;
	}
	
	public String deleteReplyInBaord() throws Exception {
		BoardDAO dao = new BoardDAO();
		dao.deleteReplyInBaord(replynum);
		getReplyInBaord();
		return SUCCESS;
	}
	
	public String getReplyInBaord() throws Exception {
		BoardDAO dao = new BoardDAO();
		replylist = dao.getReplyInBaord(boardnum);
		return SUCCESS;
	}
	
	public String boardlist() throws Exception {
		BoardDAO dao = new BoardDAO();
		list = dao.getAllData();
		return SUCCESS;
	}
	
	public String boardRead() throws Exception {
		BoardDAO dao = new BoardDAO();
		board = dao.getData(boardnum);
		return SUCCESS;
	}
	
	public String writeBoard() throws Exception {
		BoardDAO dao = new BoardDAO();
		dao.writeBoard(id, title, content, file);
		return SUCCESS;
	}
	
	public String boardDelete() throws Exception {
		BoardDAO dao = new BoardDAO();
		dao.boardDelete(boardnum);
		boardlist();
		return SUCCESS;
	}
	
	public String goBoardEditForm() throws Exception {
		BoardDAO dao = new BoardDAO();
		board = dao.getData(boardnum);
		return SUCCESS;
	}
	
	public String editBaord() throws Exception {
		BoardDAO dao = new BoardDAO();
		dao.editBaord(board);
		boardlist();
		return SUCCESS;
	}
	
	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
		this.list = list;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getRetext() {
		return retext;
	}

	public void setRetext(String retext) {
		this.retext = retext;
	}

	public ReplyVO getReply() {
		return reply;
	}

	public void setReply(ReplyVO reply) {
		this.reply = reply;
	}

	public List<ReplyVO> getReplylist() {
		return replylist;
	}

	public void setReplylist(List<ReplyVO> replylist) {
		this.replylist = replylist;
	}

	public boolean isLoginCheck() {
		return loginCheck;
	}

	public void setLoginCheck(boolean loginCheck) {
		this.loginCheck = loginCheck;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getReplynum() {
		return replynum;
	}

	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
