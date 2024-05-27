package com.pawland.post;

import com.pawland.post.domain.Post;
import com.pawland.post.repository.PostRepository;
import com.pawland.post.repository.PostJdbcRepository;
import com.pawland.utils.PostFixtureFactory;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class PostBulkInsertTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostJdbcRepository postJdbcRepository;

    @DisplayName("")
    @Test
    void test() {
        // given
        Long memberId = 1L;
        EasyRandom easyRandom = PostFixtureFactory.get(
            memberId,
            LocalDate.of(2024, 5, 26),
            LocalDate.of(2024, 5, 27)
        );

        // #1 - JPA save()
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        List<Post> posts = IntStream.range(0, 1000)
//            .mapToObj(i -> easyRandom.nextObject(Post.class))
//            .toList();
//        stopWatch.stop();
//        System.out.println("객체 생성 시간: " + stopWatch.getTotalTimeSeconds());
//
//        StopWatch queryStopWatch = new StopWatch();
//        queryStopWatch.start();
//        for (Post post : posts) {
//            postRepository.save(post);
//        }
//        queryStopWatch.stop();
//        System.out.println("DB Insert 시간: " + queryStopWatch.getTotalTimeSeconds());

        // #2 JPA - saveAll()
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        List<Post> posts = IntStream.range(0, 1000)
//            .mapToObj(i -> easyRandom.nextObject(Post.class))
//            .toList();
//        stopWatch.stop();
//        System.out.println("객체 생성 시간: " + stopWatch.getTotalTimeSeconds());
//
//        StopWatch queryStopWatch = new StopWatch();
//        queryStopWatch.start();
//        postRepository.saveAll(posts);
//        queryStopWatch.stop();
//        System.out.println("DB Insert 시간: " + queryStopWatch.getTotalTimeSeconds());

        // #3 JdbcTemplate - bulk insert
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<Post> posts = IntStream.range(0, 10000 * 100)
            .mapToObj(i -> easyRandom.nextObject(Post.class))
            .toList();
        stopWatch.stop();
        System.out.println("객체 생성 시간: " + stopWatch.getTotalTimeSeconds());

        StopWatch queryStopWatch = new StopWatch();
        queryStopWatch.start();
        postJdbcRepository.bulkInsert(posts);
        queryStopWatch.stop();
        System.out.println("DB Insert 시간: " + queryStopWatch.getTotalTimeSeconds());

        // when

        // then

    }
}
