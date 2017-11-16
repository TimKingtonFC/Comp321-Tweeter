package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Tweet;

public class TweetDB {
    public static Tweet getById(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM tweets "
                + "WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            Tweet tweet = null;
            if (rs.next()) {
            	tweet = tweetFromRow(rs);
            }
            
            return tweet;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void insert(Tweet tweet) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO tweets (message, timestamp, user_id) "
                + "VALUES (?, now(), ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, tweet.getMessage());
            ps.setInt(2, tweet.getUser().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void update(Tweet tweet) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE tweets SET numLikes=?, numRetweets=? "
                + "WHERE id=?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, tweet.getNumLikes());
            ps.setInt(2, tweet.getNumRetweets());
            ps.setInt(3, tweet.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static List<Tweet> getAll() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM tweets";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            List<Tweet> tweets = new ArrayList<>();
            while (rs.next()) {
                tweets.add(tweetFromRow(rs));
            }
            
            return tweets;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    private static Tweet tweetFromRow(ResultSet rs) throws SQLException {
        Tweet tweet = new Tweet();
        tweet.setId(rs.getInt("id"));
        tweet.setUser(UserDB.getById(rs.getInt("user_id")));
        tweet.setTimestamp(rs.getDate("timestamp"));
        tweet.setMessage(rs.getString("message"));
        tweet.setNumLikes(rs.getInt("numLikes"));
        tweet.setNumRetweets(rs.getInt("numRetweets"));
        return tweet;
    }
}
