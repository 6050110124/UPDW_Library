package com.solutbit.updwandroidlibrary.ui.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.solutbit.updwandroidlibrary.R;

public class FrescoFragment extends Fragment {

    private FrescoViewModel frescoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        frescoViewModel =
                ViewModelProviders.of(this).get(FrescoViewModel.class);

        // Content
        Fresco.initialize(getActivity().getApplicationContext());
        // End Content

        final View root = inflater.inflate(R.layout.fragment_fresco, container, false);

        // Content
        Button btn = root.findViewById(R.id.btnUpload);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                imagePipeline.clearMemoryCaches();

                Uri uri = Uri.parse("https://miro.medium.com/fit/c/240/240/1*SF2VIRFshYt2etl6OhNm_Q.png");
                Uri gif = Uri.parse("https://media.giphy.com/media/111ebonMs90YLu/giphy.gif");
                Uri jpgs = Uri.parse("https://upload.wikimedia.org/wikipedia/commons/5/5d/Media_in_Siam_Square.JPG");

                SimpleDraweeView draweeView = root.findViewById(R.id.my_image_view);
                SimpleDraweeView draweeView2 = root.findViewById(R.id.my_image_view2);
                SimpleDraweeView draweeView3 = root.findViewById(R.id.my_image_view3);
                SimpleDraweeView draweeView4 = root.findViewById(R.id.my_image_view4);
                draweeView.setImageURI(uri);
                draweeView2.setImageURI(jpgs);


                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(jpgs)
                        .setProgressiveRenderingEnabled(true)
                        .build();
                DraweeController controller3 = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(draweeView3.getController())
                        .build();
                draweeView3.setController(controller3);

                DraweeController controller4 = Fresco.newDraweeControllerBuilder()
                        .setUri(gif)
                        .setAutoPlayAnimations(true)
                        .build();
                draweeView4.setController(controller4);
            }
        });
        // End Content

        return root;
    }
}