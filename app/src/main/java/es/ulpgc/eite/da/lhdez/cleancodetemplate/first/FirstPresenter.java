package es.ulpgc.eite.da.lhdez.cleancodetemplate.first;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.AppMediator;
import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.FirstToSecondState;
import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.SecondToFirstState;

/**
 * Created by Luis on marzo, 2022
 */
public class FirstPresenter implements FirstContract.Presenter {

  //public static String TAG = FirstPresenter.class.getSimpleName();
  public static String TAG = "CleanCodeTemplate.FirstPresenter";

  private WeakReference<FirstContract.View> view;
  private FirstState state;
  private FirstContract.Model model;
  private AppMediator mediator;

  public FirstPresenter(AppMediator mediator) {
    this.mediator = mediator;
    //state = mediator.getFirstState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the mediator initialize the state
    state = getScreenState();
    //state = new FirstState();

    // call the model and initialize the state
    state.data = model.getStoredData();

    /*
    // use passed state if is necessary
    PreviousToFirstState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onUpdatedDataFromPreviousScreen(savedState.data);

      // update the state if is necessary
      state.data = savedState.data;
    }
    */

  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // call the mediator initialize the state
    state = mediator.getFirstScreenState();

    // update the model if is necessary
    //model.onUpdatedDataFromRestartedScreen(state.data);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");


    // call the model and update the state if is necessary
    //state.data = model.getUpdatedData();

    // use passed state if is necessary
    SecondToFirstState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      //model.onUpdatedDataFromNextScreen(savedState.data);

      // update the state if is necessary
      state.data = savedState.data;
    }

    // update the view
    view.get().onViewModelDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");

    // update the state
    setScreenState(state);
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");

  }

  @Override
  public void onButtonClicked() {
    Log.e(TAG, "onButtonClicked()");

    FirstToSecondState newState= new FirstToSecondState();
    //newState.data = state.data;
    newState.data = model.getStoredData();
    passStateToNextScreen(newState);
    view.get().navigateToNextScreen();
  }

  private FirstState getScreenState() {
    return mediator.getFirstScreenState();
  }

  private void setScreenState(FirstState state) {
    mediator.setFirstScreenState(state);
  }


  private SecondToFirstState getStateFromNextScreen() {
    return mediator.getNextFirstScreenState();
  }

  private void passStateToNextScreen(FirstToSecondState state) {
    mediator.setNextFirstScreenState(state);
  }

  /*
  private void passStateToPreviousScreen(FirstToPreviousState state) {
    mediator.setPreviousFirstScreenState(state);
  }

  private PreviousToFirstState getStateFromPreviousScreen() {
    return mediator.getPreviousFirstScreenState();
  }
  */

  @Override
  public void injectView(WeakReference<FirstContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(FirstContract.Model model) {
    this.model = model;
  }

}