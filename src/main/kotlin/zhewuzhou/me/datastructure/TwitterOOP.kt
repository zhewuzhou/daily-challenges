package zhewuzhou.me.datastructure

import java.util.*


class Twitter {
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

class TwitterOOP {
    private val userMap = mutableMapOf<Int, User>()

    data class Tweet(var id: Int) {
        companion object {
            var timeStamp = 0
        }

        var time: Int
        var next: Tweet?

        init {
            time = timeStamp++
            next = null
        }
    }

    class User(var id: Int) {
        private val _followed = mutableSetOf<Int>()
        val followed: Set<Int>
            get() = _followed

        var tweetHead: Tweet? = null
        fun follow(id: Int) {
            _followed.add(id)
        }

        fun unfollow(id: Int) {
            _followed.remove(id)
        }

        // everytime user post a new tweet, add it to the head of tweet list.
        fun post(id: Int) {
            val t = Tweet(id)
            t.next = tweetHead
            tweetHead = t
        }

        init {
            follow(id) // first follow itself
        }
    }

    fun postTweet(userId: Int, tweetId: Int) {
        if (!userMap.containsKey(userId)) {
            val u = User(userId)
            userMap[userId] = u
        }
        userMap[userId]!!.post(tweetId)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val res = mutableListOf<Int>()
        if (!userMap.containsKey(userId)) return res
        val users: Set<Int> = userMap[userId]!!.followed
        val q = PriorityQueue(users.size) { a: Tweet?, b: Tweet? -> b!!.time - a!!.time }
        for (user in users) {
            val t: Tweet? = userMap[user]?.tweetHead
            // very imporant! If we add null to the head we are screwed.
            if (t != null) {
                q.add(t)
            }
        }
        var n = 0
        while (!q.isEmpty() && n < 10) {
            val t = q.poll()
            res.add(t!!.id)
            n++
            if (t.next != null) q.add(t.next)
        }
        return res
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op.  */
    fun follow(followerId: Int, followeeId: Int) {
        if (!userMap.containsKey(followerId)) {
            val u = User(followerId)
            userMap[followerId] = u
        }
        if (!userMap.containsKey(followeeId)) {
            val u = User(followeeId)
            userMap[followeeId] = u
        }
        userMap[followerId]!!.follow(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (!userMap.containsKey(followerId) || followerId == followeeId) return
        userMap[followerId]!!.unfollow(followeeId)
    }
}
