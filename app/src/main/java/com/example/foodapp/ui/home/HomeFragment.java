package com.example.foodapp.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.adapters.HomeHorAdapter;
import com.example.foodapp.adapters.HomeVerAdapter;
import com.example.foodapp.adapters.UpdateVerticalRec;
import com.example.foodapp.databinding.FragmentHomeBinding;
import com.example.foodapp.models.HomeHorModel;
import com.example.foodapp.models.HomeVerModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec, homeVerticalRec;

    ////////////////// Horizontal

    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    ///////////////////////////// Vertical

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);  ///////////////////////////// Horizontal
        homeVerticalRec = root.findViewById((R.id.home_ver_rec));  ///////////////////////////// Vertical


        ///////////////////////////// Horizontal Recycle View
        homeHorModelList = new ArrayList<>();
        homeHorModelList.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        homeHorModelList.add(new HomeHorModel(R.drawable.hamburger, "HamBurger"));
        homeHorModelList.add(new HomeHorModel(R.drawable.fried_potatoes, "Fries"));
        homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream, "Ice Cream"));
        homeHorModelList.add(new HomeHorModel(R.drawable.sandwich, "Sandwich"));

        homeHorAdapter = new HomeHorAdapter(homeHorModelList,getActivity(), this);
        homeHorizontalRec.setAdapter(homeHorAdapter);

        // Définir le LayoutManager pour le RecyclerView horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        homeHorizontalRec.setLayoutManager(layoutManager);
        // D'autres configurations pour votre RecyclerView
        homeHorizontalRec.setHasFixedSize(true); // D'autres configurations pour votre RecyclerView
        homeHorizontalRec.setNestedScrollingEnabled(false); // Optionnel : pour améliorer le défilement dans un conteneur scrollable



        ///////////////////////////// Vertical Recycle View
        homeVerModelList = new ArrayList<>();


        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);

        // Définir le LayoutManager pour le RecyclerView vertical
        layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        homeVerticalRec.setLayoutManager(layoutManager);










        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void callback(int position, ArrayList<HomeVerModel> list) {

        // Créez ou mettez à jour votre adaptateur
        homeVerAdapter = new HomeVerAdapter(getContext(), list);

        // Appliquez l'adaptateur à votre RecyclerView vertical
        homeVerticalRec.setAdapter(homeVerAdapter);

        // Notifiez l'adaptateur des changements de données
        homeVerAdapter.notifyDataSetChanged();
    }
}