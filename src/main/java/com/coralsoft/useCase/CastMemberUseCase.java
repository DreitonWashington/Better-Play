package com.coralsoft.useCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coralsoft.connection.SingleConnectionDB;
import com.coralsoft.domain.entity.CastMember;
import com.coralsoft.domain.enums.CastMemberType;
import com.coralsoft.domain.exception.CastMemberNotFoundException;
import com.coralsoft.domain.repository.CastMemberRepository;

public class CastMemberUseCase implements CastMemberRepository{

	Connection connection = SingleConnectionDB.getConnection();

	@Override
	public List<CastMember> findAll() throws Exception {

		List<CastMember> castMembers = new ArrayList<>();
		String sql = "select * from cast_member";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while(result.next()){
			CastMember castMember = new CastMember();
			castMember.setId(result.getLong("id"));
			castMember.setName(result.getString("name"));

			switch(result.getString("type")) {

				case "ACTOR":
					castMember.setType(CastMemberType.ACTOR);
					break;

				case "DIRECTOR":
					castMember.setType(CastMemberType.DIRECTOR);
					break;
			}
			castMembers.add(castMember);
		}
		return castMembers;
	}

	@Override
	public CastMember findById(Long id) {

		CastMember castMember = new CastMember();
		String sql = "select * from cast_member where id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				castMember.setId(result.getLong("id"));
				castMember.setName(result.getString("name"));

				switch(result.getString("type")) {
					case "ACTOR":
						castMember.setType(CastMemberType.ACTOR);
						break;

					case "DIRECTOR":
						castMember.setType(CastMemberType.DIRECTOR);
						break;
				}
			}else {
				throw new CastMemberNotFoundException(id);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return castMember;
	}

	@Override
	public CastMember save(CastMember castMember) {

		CastMember castReturn = new CastMember();
		String sql = "insert into cast_member (name, type) values (?, ?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, castMember.getName());
			statement.setString(2, castMember.getType().name());

			statement.execute();
			ResultSet result = statement.getGeneratedKeys();

			if(result.next()) castReturn = this.findById(result.getLong(1));

		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return castReturn;
	}

	@Override
	public CastMember update(CastMember castMember) {

		CastMember castNow = new CastMember();
		String sql = "update cast_member set name = ? , type = ? where id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			castNow = this.findById(castMember.getId());

			statement.setString(1, castMember.getName());
			if(castMember.getType() == null) {
				statement.setString(2, castNow.getType().name());
			}else {
				statement.setString(2, castMember.getType().name());
			}
			statement.setLong(3, castMember.getId());

			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();

			if(result.next()) {
				castNow = this.findById(result.getLong(1));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return castNow;
	}

	@Override
	public void delete(Long id) {

		String sql = "delete from cast_member where id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
