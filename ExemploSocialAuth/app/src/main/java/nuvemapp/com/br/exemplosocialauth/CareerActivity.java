package nuvemapp.com.br.exemplosocialauth;

import org.brickred.socialauth.Career;
import org.brickred.socialauth.Education;
import org.brickred.socialauth.Position;
import org.brickred.socialauth.Recommendation;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CareerActivity extends Activity {
    private SocialAuthAdapter socialAuth;
    private TextView tvInfo;
    private ProgressBar pbLoad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);

        socialAuth = new SocialAuthAdapter(new ResponseListener());
        socialAuth.authorize(CareerActivity.this, Provider.LINKEDIN);

        // VIEWS
        pbLoad = (ProgressBar) findViewById(R.id.pbLoad);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }


    // SOCIAL AUTH CLASS
    public class ResponseListener implements DialogListener{
        @Override
        public void onComplete(Bundle values) {
            socialAuth.getCareerAsync(new CareerDataListener());
        }

        @Override
        public void onBack() {}

        @Override
        public void onCancel() {}

        @Override
        public void onError(SocialAuthError error) {
            Log.i("Script", error.getMessage());
        }
    }


    public class CareerDataListener implements SocialAuthListener<Career> {
        @Override
        public void onExecute(String plataform, Career data) {
            if(data != null){
                String contentInfo = data.getId() != null ? "<b>ID:</b> "+data.getId()+"<br />" : "";
                contentInfo += data.getHeadline() != null ? "<b>Headline:</b> "+data.getHeadline()+"<br />" : "";

                if(data.getEducations() != null){
                    for(Education aux : data.getEducations()){
                        contentInfo += aux.getDegree() != null ? "<b>Degree:</b> "+aux.getDegree()+"<br />" : "";
                        contentInfo += aux.getFieldOfStudy() != null ? "<b>Field Of Study:</b> "+aux.getFieldOfStudy()+"<br />" : "";
                        contentInfo += aux.getSchoolName() != null ? "<b>School Name:</b> "+aux.getSchoolName()+"<br />" : "";
                        contentInfo += aux.getStartDate() != null ? "<b>Start date:</b> "+aux.getStartDate().getYear()+"<br />" : "";
                        contentInfo += aux.getEndDate() != null ? "<b>End date:</b> "+aux.getEndDate().getYear()+"<br />" : "";
                    }
                }

                if(data.getPositions() != null){
                    for(Position aux : data.getPositions()){
                        contentInfo += aux.getCompanyId() != null ? "<b>Company Id:</b> "+aux.getCompanyId()+"<br />" : "";
                        contentInfo += aux.getCompanyName() != null ? "<b>Company Name:</b> "+aux.getCompanyName()+"<br />" : "";
                        contentInfo += aux.getCompanyType() != null ? "<b>Company Type:</b> "+aux.getCompanyType()+"<br />" : "";
                        contentInfo += aux.getIndustry() != null ? "<b>Industry (setor):</b> "+aux.getIndustry()+"<br />" : "";
                        contentInfo += aux.getPositionId() != null ? "<b>Position Id:</b> "+aux.getPositionId()+"<br />" : "";
                        contentInfo += aux.getStartDate() != null ? "<b>Start date:</b> "+aux.getStartDate().getYear()+"<br />" : "";
                        contentInfo += aux.getEndDate() != null ? "<b>End date:</b> "+aux.getEndDate().getYear()+"<br />" : "";
                        contentInfo += aux.getTitle() != null ? "<b>Title:</b> "+aux.getTitle()+"<br />" : "";
                    }
                }

                if(data.getRecommendations() != null){
                    for(Recommendation aux : data.getRecommendations()){
                        contentInfo += aux.getRecommendationId() != null ? "<b>Recommendation Id:</b> "+aux.getRecommendationId()+"<br />" : "";
                        contentInfo += aux.getRecommendationText() != null ? "<b>Recommendation Text:</b> "+aux.getRecommendationText()+"<br />" : "";
                        contentInfo += aux.getRecommendationType() != null ? "<b>Recommendation Type:</b> "+aux.getRecommendationType()+"<br />" : "";
                        contentInfo += aux.getRecommenderFirstName() != null ? "<b>Recommender First Name:</b> "+aux.getRecommenderFirstName()+"<br />" : "";
                        contentInfo += aux.getRecommenderLastName() != null ? "<b>Recommender Last Name:</b> "+aux.getRecommenderLastName()+"<br />" : "";
                        contentInfo += aux.getRecommenderId() != null ? "<b>Recommender ID:</b> "+aux.getRecommenderId()+"<br />" : "";
                    }
                }

                pbLoad.setVisibility(View.GONE);
                tvInfo.setVisibility(View.VISIBLE);
                tvInfo.setText(Html.fromHtml(contentInfo));
            }
        }

        @Override
        public void onError(SocialAuthError error) {
            Log.i("Script", error.getMessage());
        }
    }
}
