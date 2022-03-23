package es.ulpgc.eite.da.lhdez.cleancodetemplate.second;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.da.lhdez.cleancodetemplate.R;

/**
 * Created by Luis on marzo, 2022
 */
public class SecondActivity
    extends AppCompatActivity implements SecondContract.View {


  //public static String TAG = SecondActivity.class.getSimpleName();
  public static String TAG = "CleanCodeTemplate.SecondActivity";

  private SecondContract.Presenter presenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    getSupportActionBar().setTitle(R.string.second_screen_title);

    // Log.e(TAG, "onCreate()");

    // do the setup
    SecondScreen.configure(this);

    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
  }


  @Override
  protected void onResume() {
    super.onResume();

    // Log.e(TAG, "onResume()");

    // load the data
    presenter.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    // Log.e(TAG, "onBackPressed()");

    presenter.onBackPressed();
  }


  @Override
  protected void onPause() {
    super.onPause();

    // Log.e(TAG, "onPause()");

    presenter.onPause();
  }


  @Override
  protected void onDestroy() {
    super.onDestroy();

    // Log.e(TAG, "onDestroy()");

    presenter.onDestroy();
  }


  public void onButtonClicked(View view) {

    presenter.onButtonClicked();
  }


  @Override
  public void onViewModelDataUpdated(SecondViewModel viewModel) {
    //Log.e(TAG, "onViewModelDataUpdated()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

  /*
  @Override
  public void navigateToNextScreen() {
    // Log.e(TAG, "navigateToNextScreen()");

    Intent intent = new Intent(this, FirstActivity.class);
    startActivity(intent);
  }
  */

  @Override
  public void navigateToPreviousScreen() {
    // Log.e(TAG, "navigateToPreviousScreen()");

    finish();
  }

  @Override
  public void injectPresenter(SecondContract.Presenter presenter) {
    this.presenter = presenter;
  }

}
