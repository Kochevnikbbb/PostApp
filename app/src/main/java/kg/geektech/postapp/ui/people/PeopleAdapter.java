package kg.geektech.postapp.ui.people;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kg.geektech.postapp.data.models.Peoples;
import kg.geektech.postapp.data.models.Post;
import kg.geektech.postapp.databinding.ItemPeopleBinding;
import kg.geektech.postapp.ui.post.OnClick;
import kg.geektech.postapp.ui.post.PostAdapter;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
    private List<Peoples> people;
    private Click click;

    public PeopleAdapter(List<Peoples> people, Click click) {
        this.people = people;
        this.click = click;
    }

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPeopleBinding binding = ItemPeopleBinding.inflate(LayoutInflater.from(
                parent.getContext()), parent, false);
        return new PeopleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, int position) {
        holder.onBind(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    protected class PeopleViewHolder extends RecyclerView.ViewHolder {
        private ItemPeopleBinding binding;

        public PeopleViewHolder(@NonNull ItemPeopleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Peoples post) {
            binding.tvName.setText(post.getName());
            // binding.tvIdPerson.setText(PostAdapter.hashMap.get(post.getUserId()));
            itemView.setOnClickListener(view -> {
                click.click(post);

            });
        }
    }
}
