package com.example.SpringJDBCDemo.repo;

import com.example.SpringJDBCDemo.model.man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class manRep0 {
private JdbcTemplate template;

    public JdbcTemplate getTemplate() {

        return template;
    }
@Autowired
    public void setTemplate(JdbcTemplate template) {

        this.template = template;
    }

    public void save(man man5){
// System.out.println("hello");
   String sql="insert into man1 (id, name, tech) values(?,?,?)";

      int rows = template.update(sql,man5.getId(),man5.getName(),man5.getTech());
System.out.println(rows + " row affected ");
    }

    public List<man> findAll(){

   String sql="select * from man1";
        RowMapper<man> mapper=new RowMapper<man>() {
            @Override
            public man mapRow(ResultSet rs, int rowNum) throws SQLException {
               man a=new man();
a.setId(rs.getInt(1));
a.setName(rs.getString(2));
a.setTech(rs.getString(3));
                return a;


            }
        };

List<man> manL=template.query(sql,mapper);

        return manL;
    }

}
