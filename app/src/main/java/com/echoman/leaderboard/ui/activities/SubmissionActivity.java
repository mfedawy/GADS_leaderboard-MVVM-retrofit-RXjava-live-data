package com.echoman.leaderboard.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.echoman.leaderboard.R;
import com.echoman.leaderboard.databinding.ActivitySubmissionBinding;
import com.echoman.leaderboard.ui.dialogue.ErrorDialogFragment;
import com.echoman.leaderboard.ui.dialogue.SuccessDialogFragment;
import com.echoman.leaderboard.ui.dialogue.SureDialogFragment;

public class SubmissionActivity extends AppCompatActivity implements SureDialogFragment.SureDialogueListener {

    private static final String TAG = "submission";
    public ActivitySubmissionBinding mBinding;
    public SubmissionViewModel mSubmissionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_submission);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_submission);


        mBinding.materialToolbar2.setNavigationIcon(getDrawable(R.drawable.ic_action_back));
        mBinding.materialToolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mSubmissionViewModel = new ViewModelProvider(this).get(SubmissionViewModel.class);
        mBinding.progressBar.setVisibility(View.GONE);

        mBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mBinding.firstName.length() > 0 && mBinding.lastName.length() > 0 && mBinding.email.length() > 0
                        && mBinding.gitLink.length() > 0) {


                    ShowDialogue();

                } else {

                    Toast.makeText(getApplicationContext(), "complete the data", Toast.LENGTH_LONG).show();


                }
            }
        });


        mSubmissionViewModel.StatusMutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                switch (integer) {
                    case 1:
                        SuccessDialogFragment fragment = new SuccessDialogFragment();
                        fragment.show(getSupportFragmentManager(), "success");
                        mBinding.progressBar.setVisibility(View.GONE);

                        break;
                    case -1:

                        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
                        errorDialogFragment.show(getSupportFragmentManager(), "Error");
                        mBinding.progressBar.setVisibility(View.GONE);

                        break;
                    default:
                }
            }
        });
    }

    private void ShowDialogue() {
        SureDialogFragment dialogue = new SureDialogFragment();
        dialogue.show(getSupportFragmentManager(), "sureDialogue");

    }

    private void submit() {


        mSubmissionViewModel.Submit(
                mBinding.firstName.toString(),
                mBinding.lastName.toString(),
                mBinding.email.toString(),
                mBinding.gitLink.toString());


    }

    @Override
    public void yesClicked() {
        submit();
        mBinding.progressBar.setVisibility(View.VISIBLE);


    }


}