package com.example.foodapp.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.adapters.galleyAdapter;
import com.example.foodapp.databinding.FragmentGalleryBinding;
import com.example.foodapp.models.galleryModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentGallery extends Fragment {

    RecyclerView recyclerView;
    List<galleryModel> galleryModels;
    galleyAdapter galleryAdapter;

    private FragmentGalleryBinding binding;

    @SuppressLint("NotifyDataSetChanged")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        galleryModels = new ArrayList<>();

        galleryModels.add(new galleryModel(R.drawable.breakfast,"50% OFF", "Breakfast", "description description"));
        galleryModels.add(new galleryModel(R.drawable.lunch,"30% OFF", "Lunch", "description description"));
        galleryModels.add(new galleryModel(R.drawable.dinner,"40% OFF", "Dinner", "description description"));
        galleryModels.add(new galleryModel(R.drawable.sweets,"39% OFF", "Sweets", "description description"));
        galleryModels.add(new galleryModel(R.drawable.coffe,"20% OFF", "Coffee", "description description"));

        galleryAdapter = new galleyAdapter(getContext(),galleryModels);
        recyclerView.setAdapter(galleryAdapter);
        galleryAdapter.notifyDataSetChanged();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}