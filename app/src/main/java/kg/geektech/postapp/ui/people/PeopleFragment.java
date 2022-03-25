package kg.geektech.postapp.ui.people;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kg.geektech.postapp.App;
import kg.geektech.postapp.R;
import kg.geektech.postapp.data.models.Peoples;
import kg.geektech.postapp.data.models.Post;
import kg.geektech.postapp.databinding.FragmentPeopleBinding;
import kg.geektech.postapp.ui.form.FormFragment;
import kg.geektech.postapp.ui.post.OnClick;
import kg.geektech.postapp.ui.post.PostAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PeopleFragment extends Fragment implements Click {
    private FragmentPeopleBinding binding;
    private PeopleAdapter adapter;
    private List<Peoples> peoples = new ArrayList<>();
    private int id;

    private NavHostFragment navHostFragment;
    private NavController controller;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        adapter = new PeopleAdapter(peoples, this);
        navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        controller = navHostFragment.getNavController();
    }

    private void loadData() {
        peoples.add(new Peoples(1, "Султан Джумалиев"));
        peoples.add(new Peoples(2, "Бекжан Маданбеков"));
        peoples.add(new Peoples(3, "Бакай Белеков"));
        peoples.add(new Peoples(4, "Медербек Шермаматов"));
        peoples.add(new Peoples(5, "Адахан Касымалиев"));
        peoples.add(new Peoples(6, "Жумалиев Мурат"));
        peoples.add(new Peoples(7, "Альберт Жумаев"));
        peoples.add(new Peoples(8, "Милана Анарбекова"));
        peoples.add(new Peoples(9, "Таиров Сагыналы"));
        peoples.add(new Peoples(10, "Уланбек уулу Расул"));
        peoples.add(new Peoples(11, "Жакипов Абдулла"));
        peoples.add(new Peoples(12, "Мыктарбекова Бермет"));
        peoples.add(new Peoples(13, "Айпери Ашыралиева"));
        peoples.add(new Peoples(14, "Гулбарчын Алиева"));
        peoples.add(new Peoples(15, "Эрнис уулу Альберт"));
        peoples.add(new Peoples(16, "Джапаркулов Ахмад"));
        peoples.add(new Peoples(17, "Акедос Мукашев"));
        peoples.add(new Peoples(18, "Касымов Рафкат"));
        peoples.add(new Peoples(19, "Максим Катунин"));
        peoples.add(new Peoples(20, "Жанышев Султанкул"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPeopleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler2.setAdapter(adapter);

    }


    @Override
    public void click(Peoples peoples) {
        id = peoples.getId();
        FormFragment formFragment = new FormFragment();
        formFragment.setUserIdPeople(id);
        controller.navigate(R.id.action_peopleFragment_to_postsFragment);

    }
}