package kg.geektech.postapp.data.remote;

import java.util.List;

import kg.geektech.postapp.data.models.Post;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostApi {
    @GET("/posts")
    Call<List<Post>> getPosts();

    @POST("/posts")
    Call<Post> createPost(
      @Body Post post
    );
    @DELETE("/posts/{id}")
    Call<ResponseBody> deletePost(
      @Path("id") int id
    );
}