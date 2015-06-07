package com.ebsi.eflow.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "app_user")
public class AppUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String loginId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String userPasswd;
	private String userQuestion1;
	private String userAnswer1;
	private String userQuestion2;
	private String userAnswer2;
	private String userQuestion3;
	private String userAnswer3;
	private Date lastSuccessfulLogin;
	private Date lastLoginAttempt;
	private Integer failedLoginCount;
	private char acctLocked;
	private char acctNew;
	private char passwdReset;
	private char acctDeleted;
	private Date createdOn;
	private Date updatedOn;
	private int updatedBy;

	
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "login_id", nullable = false, length = 25)
	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column(name = "first_name", nullable = false, length = 25)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name", length = 25)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name", length = 25)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email_id", nullable = false, length = 100)
	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "user_passwd", nullable = false, length = 50)
	public String getUserPasswd() {
		return this.userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	@Column(name = "user_question1", nullable = false, length = 201)
	public String getUserQuestion1() {
		return this.userQuestion1;
	}

	public void setUserQuestion1(String userQuestion1) {
		this.userQuestion1 = userQuestion1;
	}

	@Column(name = "user_answer1", nullable = false, length = 50)
	public String getUserAnswer1() {
		return this.userAnswer1;
	}

	public void setUserAnswer1(String userAnswer1) {
		this.userAnswer1 = userAnswer1;
	}

	@Column(name = "user_question2", length = 200)
	public String getUserQuestion2() {
		return this.userQuestion2;
	}

	public void setUserQuestion2(String userQuestion2) {
		this.userQuestion2 = userQuestion2;
	}

	@Column(name = "user_answer2", length = 50)
	public String getUserAnswer2() {
		return this.userAnswer2;
	}

	public void setUserAnswer2(String userAnswer2) {
		this.userAnswer2 = userAnswer2;
	}

	@Column(name = "user_question3", length = 200)
	public String getUserQuestion3() {
		return this.userQuestion3;
	}

	public void setUserQuestion3(String userQuestion3) {
		this.userQuestion3 = userQuestion3;
	}

	@Column(name = "user_answer3", length = 50)
	public String getUserAnswer3() {
		return this.userAnswer3;
	}

	public void setUserAnswer3(String userAnswer3) {
		this.userAnswer3 = userAnswer3;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_successful_login", length = 19)
	public Date getLastSuccessfulLogin() {
		return this.lastSuccessfulLogin;
	}

	public void setLastSuccessfulLogin(Date lastSuccessfulLogin) {
		this.lastSuccessfulLogin = lastSuccessfulLogin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_attempt", length = 19)
	public Date getLastLoginAttempt() {
		return this.lastLoginAttempt;
	}

	public void setLastLoginAttempt(Date lastLoginAttempt) {
		this.lastLoginAttempt = lastLoginAttempt;
	}

	@Column(name = "failed_login_count")
	public Integer getFailedLoginCount() {
		return this.failedLoginCount;
	}

	public void setFailedLoginCount(Integer failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	@Column(name = "acct_locked", nullable = false, length = 1)
	public char getAcctLocked() {
		return this.acctLocked;
	}

	public void setAcctLocked(char acctLocked) {
		this.acctLocked = acctLocked;
	}

	@Column(name = "acct_new", nullable = false, length = 1)
	public char getAcctNew() {
		return this.acctNew;
	}

	public void setAcctNew(char acctNew) {
		this.acctNew = acctNew;
	}

	@Column(name = "passwd_reset", nullable = false, length = 1)
	public char getPasswdReset() {
		return this.passwdReset;
	}

	public void setPasswdReset(char passwdReset) {
		this.passwdReset = passwdReset;
	}

	@Column(name = "acct_deleted", nullable = false, length = 1)
	public char getAcctDeleted() {
		return this.acctDeleted;
	}

	public void setAcctDeleted(char acctDeleted) {
		this.acctDeleted = acctDeleted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", nullable = false, length = 19)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "updated_by", nullable = false)
	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

}
