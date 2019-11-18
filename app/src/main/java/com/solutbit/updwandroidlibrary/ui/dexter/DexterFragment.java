package com.solutbit.updwandroidlibrary.ui.dexter;

import android.Manifest;
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

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.solutbit.updwandroidlibrary.R;

import java.util.List;

public class DexterFragment extends Fragment {

    private DexterViewModel dexterViewModel;

    TextView tv_camera, tv_contacts, tv_audio;
    Button btn_camera, btn_contacts, btn_audio, btn_request_all;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dexterViewModel =
                ViewModelProviders.of(this).get(DexterViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dexter, container, false);

        // Content
        tv_camera = root.findViewById(R.id.tv_camera);
        tv_contacts = root.findViewById(R.id.tv_contacts);
        tv_audio = root.findViewById(R.id.tv_audio);
        btn_camera = root.findViewById(R.id.btn_camara);
        btn_contacts = root.findViewById(R.id.btn_contacts);
        btn_audio = root.findViewById(R.id.btn_audio);
        btn_request_all = root.findViewById(R.id.btn_request_all);

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(getActivity())
                        .withPermission(Manifest.permission.CAMERA)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                showPermissionGranted(response.getPermissionName());
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                showPermissionDenied(response.getPermissionName(), response.isPermanentlyDenied());
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                                token.cancelPermissionRequest();
                            }
                        }).check();
            }
        });

        btn_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(getActivity())
                        .withPermission(Manifest.permission.READ_CONTACTS)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                showPermissionGranted(response.getPermissionName());
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                showPermissionDenied(response.getPermissionName(), response.isPermanentlyDenied());
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                                token.cancelPermissionRequest();
                            }
                        }).check();
            }
        });

        btn_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(getActivity())
                        .withPermission(Manifest.permission.RECORD_AUDIO)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                showPermissionGranted(response.getPermissionName());
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                showPermissionDenied(response.getPermissionName(), response.isPermanentlyDenied());
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                                token.cancelPermissionRequest();
                            }
                        }).check();
            }
        });

        btn_request_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withActivity(getActivity())
                        .withPermissions(
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_CONTACTS,
                                Manifest.permission.RECORD_AUDIO
                        ).withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        for(PermissionGrantedResponse response : report.getGrantedPermissionResponses()) {
                            showPermissionGranted(response.getPermissionName());
                        }
                        for(PermissionDeniedResponse response : report.getDeniedPermissionResponses()) {
                            showPermissionDenied(response.getPermissionName(), response.isPermanentlyDenied());
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                        token.cancelPermissionRequest();
                    }
                }).check();
            }
        });
        // End content

        return root;
    }

    public void showPermissionGranted(String permission) {
        TextView feedbackView = getFeedbackViewForPermission(permission);
        feedbackView.setText(R.string.permission_granted_feedback);
    }

    public void showPermissionDenied(String permission, boolean isPermanentlyDenied) {
        TextView feedbackView = getFeedbackViewForPermission(permission);
        feedbackView.setText(isPermanentlyDenied ? R.string.permission_permanently_denied_feedback
                : R.string.permission_denied_feedback);
    }

    private TextView getFeedbackViewForPermission(String name) {
        TextView feedbackView;

        switch (name) {
            case Manifest.permission.CAMERA:
                feedbackView = tv_camera;
                break;
            case Manifest.permission.READ_CONTACTS:
                feedbackView = tv_contacts;
                break;
            case Manifest.permission.RECORD_AUDIO:
                feedbackView = tv_audio;
                break;
            default:
                throw new RuntimeException("No feedback");
        }

        return feedbackView;
    }

}