package board.board;

public class ReplyVO {
	private int replynum;
	private int boardnum;
	private String id;
	private String retext;
	private String inputdate;
	public ReplyVO() {
		super();
	}
	public ReplyVO(int replynum, int boardnum, String id, String retext,
			String inputdate) {
		super();
		this.replynum = replynum;
		this.boardnum = boardnum;
		this.id = id;
		this.retext = retext;
		this.inputdate = inputdate;
	}
	
	public ReplyVO(int boardnum, String id, String retext, String inputdate) {
		super();
		this.boardnum = boardnum;
		this.id = id;
		this.retext = retext;
		this.inputdate = inputdate;
	}
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRetext() {
		return retext;
	}
	public void setRetext(String retext) {
		this.retext = retext;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	@Override
	public String toString() {
		return "ReplyVO [replynum=" + replynum + ", boardnum=" + boardnum
				+ ", id=" + id + ", retext=" + retext + ", inputdate="
				+ inputdate + "]";
	}
	
}
