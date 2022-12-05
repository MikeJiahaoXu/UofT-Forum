package CommonUser;
import post_reply_user.CommonUser;
import post_reply_user.Post;
import post_reply_user.Reply;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class common_UserTest {
    //create some users, posts and replies


    Post post1 = new Post("postId1", "userId1", "post1 content", null, null,
            "2022-12-01");

    Post post2 = new Post("postId2", "userId1", "post2 content", null, null,
            "2022-12-01");
    Post post3 = new Post("postId3", "userId1", "post3 content", null, null,
            "2022-11-01");
    Post post4 = new Post("postId4", "userId1", "post4 content", null, null,
            "2022-10-01");

    Reply reply1 = new Reply("1","userId1","postId2","reply1","2022-12-01");
    Reply reply2 = new Reply("2","userId2","postId3","reply2","2021-12-01");
    Reply reply3 = new Reply("3","userId3","postId3","reply3","2020-12-01");
    Reply reply4 = new Reply("4","userId4","postId3","reply4","2022-11-01");
    Reply reply5 = new Reply("5","userId5","postId3","reply5","2021-11-01");


    public void testGetName() {
        CommonUser user = new CommonUser("nick", "1122", "avatar1", null);
        String result = user.getNickname();
        assertEquals("nick", result);
    }

    public void testGetPassword() {
        CommonUser user = new CommonUser("nick", "1122", "avatar1", null);
        String password = user.getPassword();
        assertEquals("1122", password);
    }

    public void testGetAvatar() {
        CommonUser user = new CommonUser("nick", "1122", "avatar1", null);
        String result = user.getAvatar();
        assertEquals("avatar1", result);
    }

    public void testGetALLPost1() {
        CommonUser user = new CommonUser("nick", "1122", "avatar1");
        assertNull(user.getAllPost());
    }

    public void testGetALLPost2() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(posts, user.getAllPost());
    }

    public void testGetALLPost3() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(posts, user.getAllPost());
    }

    public void testGetALLPost4() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(posts, user.getAllPost());
    }

    public void testTotalNumPost1(){
        CommonUser user = new CommonUser("nick", "1122", "avatar1");
        assertEquals(0, user.total_num_post());
    }

    public void testTotalNumPost2(){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(posts, user.getAllPost());
        assertEquals(1, user.total_num_post());
    }

    public void testTotalNumPost3(){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(2, user.total_num_post());
    }

    public void testTotalNumPost4(){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(4, user.total_num_post());
    }

    public void testTotalLikeReceived1(){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(0, user.total_like_received());

    }

    public void testTotalLikeReceived2(){
        ArrayList<String> lst3 = new ArrayList<>();
        lst3.add("user1");
        lst3.add("user2");
        Post post = new Post("postId","userId","postContant",null, lst3,"2022-12-01");
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(2, user.total_like_received());
    }

    public void testTotalLikeReceived3(){
        ArrayList<String> lst3 = new ArrayList<>();
        lst3.add("user1");
        lst3.add("user2");
        Post post1 = new Post("postId","userId","postContant",null, lst3,"2022-12-01");
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        ArrayList<String> lst4 = new ArrayList<>();
        lst4.add("user3");
        Post post2 = new Post("postId","userId","postContant",null, lst4,"2022-12-01");
        posts.add(post2);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(3, user.total_like_received());
    }

    public void testTotalLikeReceived4(){
        ArrayList<String> lst3 = new ArrayList<>();
        lst3.add("user1");
        ArrayList<String> lst4 = new ArrayList<>();
        lst4.add("user1");
        ArrayList<String> lst5 = new ArrayList<>();
        lst4.add("user1");
        ArrayList<String> lst6 = new ArrayList<>();
        lst4.add("user1");
        Post post1 = new Post("postId","userId","postContant",null, lst3,"2022-12-01");
        Post post2 = new Post("postId","userId","postContant",null, lst4,"2022-12-01");
        Post post3 = new Post("postId","userId","postContant",null, lst5,"2022-12-01");
        Post post4 = new Post("postId","userId","postContant",null, lst6,"2022-12-01");
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        assertEquals(4, user.total_like_received());
    }

    public void testTotalReplyReceive1(){
        CommonUser user = new CommonUser("nick", "1122", "avatar1", null);
        int result = user.total_reply_received();
        assertEquals(0, result);

    }

    public void testTotalReplyReceive2(){
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        int result = user.total_reply_received();
        assertEquals(0, result);
    }

    public void testTotalReplyReceive3(){
        ArrayList<Reply> replies = new ArrayList<>();
        replies.add(reply1);
        replies.add(reply2);
        replies.add(reply3);
        Post post = new Post("1","2","3",replies,null);
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        int result = user.total_reply_received();
        assertEquals(3, result);
    }

    public void testTotalReplyReceive4(){
        ArrayList<Reply> replies = new ArrayList<>();
        replies.add(reply1);
        replies.add(reply2);
        replies.add(reply3);
        Post post = new Post("1","2","3",replies,null);
        ArrayList<Reply> replies2 = new ArrayList<>();
        replies.add(reply4);
        Post post2 = new Post("1","2","3",replies2,null);
        ArrayList<Reply> replies3 = new ArrayList<>();
        replies.add(reply5);
        Post post3 = new Post("1","2","3",replies3,null);
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        CommonUser user = new CommonUser("nick", "1122", "avatar1", posts);
        int result = user.total_reply_received();
        assertEquals(5, result);
    }

}
