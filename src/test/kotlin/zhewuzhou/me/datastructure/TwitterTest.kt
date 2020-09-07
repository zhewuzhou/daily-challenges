package zhewuzhou.me.datastructure

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

internal class TwitterTest {
    @Test
    fun `Should find all possible tweets`() {
        val t = Twitter()
        t.postTweet(1, 5)
        assertThat(t.getNewsFeed(1), `is`(listOf(5)))
        t.follow(1, 2)
        t.postTweet(2, 6)
        assertThat(t.getNewsFeed(1), `is`(listOf(6, 5)))
        t.unfollow(1, 2)
        assertThat(t.getNewsFeed(1), `is`(listOf(5)))
        t.follow(1, 2)
        assertThat(t.getNewsFeed(1), `is`(listOf(6, 5)))
    }
}
