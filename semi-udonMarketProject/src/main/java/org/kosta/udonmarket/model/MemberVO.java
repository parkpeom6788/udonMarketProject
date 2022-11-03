package org.kosta.udonmarket.model;

import java.io.Serializable;

public class MemberVO implements Serializable {
	private static final long serialVersionUID = 1065881435339514809L;
	
	private String id;
	private String password;
	private int memberType;
	private String name;
	private String memberNo;
	private String address;
	private String tel;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String id, String password, int memberType, String name, String memberNo, String address,
			String tel) {
		super();
		this.id = id;
		this.password = password;
		this.memberType = memberType;
		this.name = name;
		this.memberNo = memberNo;
		this.address = address;
		this.tel = tel;
	}
	
	// 아이디 찾기
	public MemberVO(String id, String name, String memberNo, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.memberNo = memberNo;
		this.tel = tel;
	}
	
	// 비밀번호 찾기
	public MemberVO(String id, String password, String name, String memberNo, String tel) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.memberNo = memberNo;
		this.tel = tel;
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

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", memberType=" + memberType + ", name=" + name
				+ ", memberNo=" + memberNo + ", address=" + address + ", tel=" + tel + "]";
	}

}
