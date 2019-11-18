package com.solutbit.updwandroidlibrary.ui.glide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.solutbit.updwandroidlibrary.R;

public class GlideFragment extends Fragment {

    private GlideViewModel glideViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        glideViewModel =
                ViewModelProviders.of(this).get(GlideViewModel.class);
        View root = inflater.inflate(R.layout.fragment_glide, container, false);

        // Content
        final String url = "https://d17fnq9dkz9hgj.cloudfront.net/uploads/2012/11/152964589-welcome-home-new-cat-632x475.jpg";
        final ImageView imgView = (ImageView) root.findViewById(R.id.imageView1);
        final Button btnLoad = (Button) root.findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getActivity().getApplicationContext()).load(url).into(imgView);
            }
        });
        // End Content

        return root;
    }
}