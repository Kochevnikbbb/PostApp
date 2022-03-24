package kg.geektech.postapp.ui.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.postapp.App;
import kg.geektech.postapp.data.models.Post;
import kg.geektech.postapp.databinding.FragmentFormBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormFragment extends Fragment {
    private FragmentFormBinding binding;
    private static final int GROUP_ID = 40;
    private static final int USER_ID = 3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSend.setOnClickListener(view1 -> {
            String title = binding.etTitle.getText().toString();
            String content = binding.etContent.getText().toString();

            Post post = new Post(title, content, USER_ID, GROUP_ID);
            App.api.createPost(post).enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {
                    if (response.isSuccessful()) {
                        requireActivity().onBackPressed();
                    }
                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {

                }
            });

        });

    }
}