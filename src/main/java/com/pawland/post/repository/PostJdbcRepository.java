package com.pawland.post.repository;

import com.pawland.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostJdbcRepository {

    private static final String TABLE = "post";
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void bulkInsert(List<Post> postList) {
        String sql = String.format("""
            INSERT INTO %s (member_id, content, created_date)
            VALUES (:memberId, :content, :createdDate)
            """, TABLE);

        SqlParameterSource[] params = postList.stream()
            .map(BeanPropertySqlParameterSource::new)
            .toArray(SqlParameterSource[]::new);

        jdbcTemplate.batchUpdate(sql, params);
    }
}
