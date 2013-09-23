package com.orderingdb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.entities.Account;
import com.orderingdb.dao.AccountDAO;
import com.orderingdb.util.OrderingConstants;

@ManagedBean(name="account")
@SessionScoped
public class AccountAction {
	
	private AccountDAO acctDao;
	private List<Account> accounts;
	private List<Account> filteredAccts;
	private Account account;
	private Account newAccount;
	
	public Account getNewAccount() {
		return newAccount;
	}

	public void setNewAccount(Account newAccount) {
		this.newAccount = newAccount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Account> getFilteredAccts() {
		return filteredAccts;
	}

	public void setFilteredAccts(List<Account> filteredAccts) {
		this.filteredAccts = filteredAccts;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public AccountAction() {
		acctDao = new AccountDAO();
	}

	public String gotoNewAccount() {
		return "/account/newAccount.xhtml?faces-redirect=true";
	}
	
	public String acquireListofAccounts() {
		List<Account> accts = acctDao.getAccountList();
		accounts = (accts!=null)?accts:new ArrayList<Account>();
		return "/account/listOfAccounts.xhtml?faces-redirect=true";
	}
	
	public void onEdit(RowEditEvent event) {
		System.out.println("hello");
	}
	
	public void createAnAccount() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			acctDao.createAccount(account);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Account created successfully", null));
			newAccount = new Account();
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					OrderingConstants.criticalError, null));
		}
	}
}
