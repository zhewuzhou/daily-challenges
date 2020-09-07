package zhewuzhou.me.datastructure

class Twitter() {
    private val tweets: MutableList<Pair<Int, Int>> = mutableListOf()
    private val relationships = mutableMapOf<Int, MutableSet<Int>>()
    fun postTweet(userId: Int, tweetId: Int) {
        tweets.add(Pair(userId, tweetId))
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val users = mutableSetOf(userId)
        val res = mutableListOf<Int>()
        if (relationships.containsKey(userId)) {
            users.addAll(relationships[userId]!!)
        }
        for (i in tweets.lastIndex downTo 0) {
            if (users.contains(tweets[i].first)) {
                res.add(tweets[i].second)
            }
            if (res.size == 10) break
        }
        return res
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(id: Int, followId: Int) {
        if (id == followId) return
        if (relationships.containsKey(id)) {
            relationships[id]!!.add(followId)
        } else {
            relationships[id] = mutableSetOf(followId)
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(id: Int, followId: Int) {
        if (id == followId) return
        if (relationships.containsKey(id) && relationships[id]!!.isNotEmpty()) {
            relationships[id]!!.remove(followId)
        }
    }
}
