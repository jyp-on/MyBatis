package dev.jyp.mybatis.dao;

import dev.jyp.mybatis.dto.PostDto;
import dev.jyp.mybatis.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {
    private final SqlSessionFactory sessionFactory;

    public PostDao(@Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /*
    * mapper 인스턴스는 thread safe하지 않기 때문에 항상 Session을 각각 생성후 닫아줘야한다.
    * 즉 다른함수의 결과가 다른함수에게 영향을 끼칠 수 있다.
    * */

    public int createPost(PostDto dto) {
        // 데이터베이스랑 통신하기 위한 세션 생성
        try (SqlSession session = sessionFactory.openSession()) {
            // PostMapper를 구현한 구현체가 mapper에 주입됨
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
            // try 안에서 session을 만들었으므로 try를 나갈 때 자동으로 session closed
        }
    }

    public PostDto readPost(int id) {
        // 데이터베이스랑 통신하기 위한 세션 생성
        try (SqlSession session = sessionFactory.openSession()) {
            // PostMapper를 구현한 구현체가 mapper에 주입됨
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
            // try 안에서 session을 만들었으므로 try를 나갈 때 자동으로 session closed
        }
    }

    public List<PostDto> readPostAll() {
        try (SqlSession session = sessionFactory.openSession()) {
            // PostMapper를 구현한 구현체가 mapper에 주입됨
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
            // try 안에서 session을 만들었으므로 try를 나갈 때 자동으로 session closed
        }
    }

    public int updatePost(PostDto dto) {
        try (SqlSession session = sessionFactory.openSession()) {
            // PostMapper를 구현한 구현체가 mapper에 주입됨
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
            // try 안에서 session을 만들었으므로 try를 나갈 때 자동으로 session closed
        }
    }

    public int deletePost(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            // PostMapper를 구현한 구현체가 mapper에 주입됨
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
            // try 안에서 session을 만들었으므로 try를 나갈 때 자동으로 session closed
        }
    }
}
