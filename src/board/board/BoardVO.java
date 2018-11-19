package board.board;

public class BoardVO {
	private int boardnum;
	private String id;
	private String inputdate;
	private int viewcount;
	private String title;
	private String content;
	private String savedfile;
	private String originalfile;
	public BoardVO() {
		super();
	}
	public BoardVO(int boardnum, String id, String inputdate, int viewcount,
			String title, String content, String savedfile, String originalfile) {
		super();
		this.boardnum = boardnum;
		this.id = id;
		this.inputdate = inputdate;
		this.viewcount = viewcount;
		this.title = title;
		this.content = content;
		this.savedfile = savedfile;
		this.originalfile = originalfile;
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
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
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
	public String getSavedfile() {
		return savedfile;
	}
	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}
	public String getOriginalfile() {
		return originalfile;
	}
	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}
	@Override
	public String toString() {
		return "BoardVO [boardnum=" + boardnum + ", id=" + id + ", inputdate="
				+ inputdate + ", viewcount=" + viewcount + ", title=" + title
				+ ", content=" + content + ", savedfile=" + savedfile
				+ ", originalfile=" + originalfile + "]";
	}
	
	
}
