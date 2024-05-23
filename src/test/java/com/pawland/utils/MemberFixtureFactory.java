package com.pawland.utils;

import com.pawland.member.domain.Member;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.number.LongRandomizer;

public class MemberFixtureFactory {

    public static Member create() {
        Long randomValue = new LongRandomizer().getRandomValue();
        EasyRandomParameters param = new EasyRandomParameters()
            .seed(randomValue)
            .stringLengthRange(1, 10);
        return new EasyRandom(param).nextObject(Member.class);
    }
}
