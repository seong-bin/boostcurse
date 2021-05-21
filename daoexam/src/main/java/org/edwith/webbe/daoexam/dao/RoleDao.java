package org.edwith.webbe.daoexam.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.edwith.webbe.daoexam.dto.RoleDTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import static org.edwith.webbe.daoexam.dao.RoleDaoSqls.*;
@Repository
public class RoleDao {
	// Spring JDBC에서 제공하는 객체 ( 파라미터를 이름을 이용(문자)할수 있게 해줌)
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<RoleDTO> rowMapper = BeanPropertyRowMapper.newInstance(RoleDTO.class);
	
	// DBConfig에서 bean으로 등록한 dataSource를 받아와 파라미터로 넣어줌
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	public List<RoleDTO> selectAll(){
		// query() 메소드는 결과가 여러건일 때 내부적으로 반복하면서 dto를 생성하고, 생성한 dto를 list에 담고 반환 해준다
		// Collections.emptyMap() : sql문에 바인딩 할 값이 있을 경우 바인딩한 값을 전달할 목적으로 사용
		// rowMapper : select 한건 한건을 dto에 저장하기 위한 목적으로 사용
		// ( BeanPropertyRowMapper객체를 이용하여 컬럼의 값을 자동으로 dto에 담아줌, dbms와 java의 컬렴명 규칙을 맞춰줌 ex : db role_id - java roleId)
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
	}
	
	public int insert(RoleDTO roleDTO) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(roleDTO);
		return insertAction.execute(params);
	}
	

	public int update(RoleDTO roleDTO) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(roleDTO);
		return jdbc.update(UPDATE, params);
	}

	public int delete(RoleDTO roleDTO) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(roleDTO);
		return jdbc.update(DELETE, params);
	}
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
	public RoleDTO selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);		
		}catch(EmptyResultDataAccessException e) {	// 파라미터로 받은 아이디가 없으면 에러남, 예외처리 필수
			return null;
		}
	}
	
}
