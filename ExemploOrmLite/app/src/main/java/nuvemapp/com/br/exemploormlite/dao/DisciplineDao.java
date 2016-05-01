package nuvemapp.com.br.exemploormlite.dao;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import nuvemapp.com.br.exemploormlite.cdp.Discipline;

public class DisciplineDao extends BaseDaoImpl<Discipline, Integer> {
	public DisciplineDao(ConnectionSource cs) throws SQLException{
		super(Discipline.class);
		setConnectionSource(cs);
		initialize();
	}
}
