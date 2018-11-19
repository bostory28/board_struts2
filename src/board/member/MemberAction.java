package board.member;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport implements SessionAware {
	private String id;
	private String password;
	private boolean logincheck;
	private MemberVO vo;
	private Map<String, Object> session;
	
	public String login() throws Exception {
		MemberDAO dao = new MemberDAO();
		vo = new MemberVO(id, password);
		if(dao.login(vo) == null){
			logincheck = false;
		} else {
			logincheck = true;
			session.put("id", id);
		}
		return SUCCESS;
	}
	
	public String memberJoin() throws Exception {
		MemberDAO dao = new MemberDAO();
		if(dao.login(vo) != null){
			return "memberform";
		}
		dao.memberJoin(vo);
		session.put("id", vo.getId());
		return SUCCESS;
	}
	
	public String memberupdateform() throws Exception {
		MemberDAO dao = new MemberDAO();
		vo = dao.login(id);
		return SUCCESS;
	}
	
	public String memberupdate() throws Exception {
		MemberDAO dao = new MemberDAO();
		dao.memberUpdate(vo);
		return SUCCESS;
	}
	
	public String out() throws Exception {
		MemberDAO dao = new MemberDAO();
		dao.out(id);
		session.remove("id");
		return SUCCESS;
	}
	
	public String logout() throws Exception {
		session.remove("id");
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public MemberVO getVo() {
		return vo;
	}

	public void setVo(MemberVO vo) {
		this.vo = vo;
	}

	public boolean isLogincheck() {
		return logincheck;
	}

	public void setLogincheck(boolean logincheck) {
		this.logincheck = logincheck;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
