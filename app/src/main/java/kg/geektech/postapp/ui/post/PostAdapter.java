package kg.geektech.postapp.ui.post;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kg.geektech.postapp.data.models.Post;
import kg.geektech.postapp.databinding.ItemPostBinding;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> posts = new ArrayList<>();
    public static HashMap<Integer,String> hashMap = new HashMap<>();
    private OnClick onClick;

    public PostAdapter(OnClick onClick) {
        this.onClick = onClick;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        hashMap.put(0, "хз");
        hashMap.put(1, "Султан Джумалиев");
        hashMap.put(2, "Бекжан Маданбеков");
        hashMap.put(3, "Бакай Белеков");
        hashMap.put(4, "Медербек Шермаматов");
        hashMap.put(5, "Адахан Касымалиев");
        hashMap.put(6, "Жумалиев Мурат");
        hashMap.put(7, "Альберт Жумаев");
        hashMap.put(8, "Милана Анарбекова");
        hashMap.put(9, "Таиров Сагыналы");
        hashMap.put(10, "Уланбек уулу Расул");
        hashMap.put(11, "Жакипов Абдулла");
        hashMap.put(12, "Мыктарбекова Бермет");
        hashMap.put(13, "Айпери Ашыралиева");
        hashMap.put(14, "Гулбарчын Алиева");
        hashMap.put(15, "Эрнис уулу Альберт");
        hashMap.put(16, "Джапаркулов Ахмад");
        hashMap.put(17, "Акедос Мукашев");
        hashMap.put(18, "Касымов Рафкат");
        hashMap.put(19, "Максим Катунин");
        hashMap.put(20, "Жанышев Султанкул");

        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void remove(Post post) {
        int index = posts.lastIndexOf(post);
        posts.remove(post);
        notifyItemRemoved(index);
    }

    protected class PostViewHolder extends RecyclerView.ViewHolder {
        private ItemPostBinding binding;

        public PostViewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Post post) {
            binding.tvUserId.setText(hashMap.get(post.getUserId()));
            binding.tvTitle.setText(post.getTitle());
            binding.tvContent.setText(post.getContent());
            itemView.setOnClickListener(view -> {
                onClick.onClick(post);
            });
            itemView.setOnLongClickListener(view -> {
                onClick.onLongClick(post);
                return true;
            });
        }
    }
}
