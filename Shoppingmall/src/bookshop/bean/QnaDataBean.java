package bookshop.bean;

import java.sql.Timestamp;

public class QnaDataBean {
	private int qna_id;		// qna �۹�ȣ
	private int book_id;	// å�� ��� ��ȣ
	private String book_title;	// å �̸�
	private String qna_writer;	// qna �ۼ���
	private String qna_content;	// qna ����
	private int group_id;	//	qna �׷�
	private byte qora;	// qna �׷� ���� ����
	private byte reply;	// �亯 ����
	private Timestamp reg_date;	// qna �ۼ���
	
	public int getQna_id() {
		return qna_id;
	}
	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getQna_writer() {
		return qna_writer;
	}
	public void setQna_writer(String qna_writer) {
		this.qna_writer = qna_writer;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public byte getQora() {
		return qora;
	}
	public void setQora(byte qora) {
		this.qora = qora;
	}
	public byte getReply() {
		return reply;
	}
	public void setReply(byte reply) {
		this.reply = reply;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
}
