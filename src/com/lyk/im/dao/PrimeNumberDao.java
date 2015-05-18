package com.lyk.im.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrimeNumberDao extends DatabaseDao {
	private static final String TABLE_NAME = "prime_numbers";
	
	private static final String ID = "id";
	private static final String PRIME = "prime";

	public PrimeNumberDao() {
		super();
	}
	
	public void insert(long prime) {
		String sql = "insert into " + TABLE_NAME + " (" + PRIME + ") values (" + prime + ")";
		//System.out.println(sql);
		try {
			boolean result = getStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}
	
	public int count() {
		String sql = "select count(*) from " + TABLE_NAME;
		ResultSet result = null;
		try {
			result = getStatement().executeQuery(sql);
			while(result.next()) {
				return result.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
			} catch (SQLException e) {

			}
		}
		return 0;
	}
	
	public long select(long id) {
		String sql = "select " + PRIME + " from " + TABLE_NAME + " where id=" + id;
		ResultSet result = null;
		try {
			result = getStatement().executeQuery(sql);
			while(result.next()) {
				return result.getLong(PRIME);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
			} catch (SQLException e) {

			}
		}
 		return -1;
	}
}
