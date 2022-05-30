package com.service;

public interface ServiceI {
	
	void addUser();
	void showAllUserDataUsingHql();
	void getSingleDataUsingHql();
	void updateSingleDataUsingHql();
	void deleteSingleDataUsingHql();
	void getAllDataUsingHqlAsClause();
	void getDataUsingOrderBy();
	void selectPericularColumn();
	
	//Aggregate
	void findCount();
	void maXPaidAmountFind();
	void calculateAllPaindAmount();

}
