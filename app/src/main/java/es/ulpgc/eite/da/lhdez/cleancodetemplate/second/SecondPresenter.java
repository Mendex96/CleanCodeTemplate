package es.ulpgc.eite.da.lhdez.cleancodetemplate.second;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.AppMediator;
import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.FirstToSecondState;
import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.SecondToFirstState;

/**
 * Created by Luis on marzo, 2022
 */
public class SecondPresenter implements SecondContract.Presenter {

  //public static String TAG = SecondPresenter.class.getSimpleName();
  public static String TAG = "CleanCodeTemplate.SecondPresenter";

  private WeakReference<SecondContract.View> view;
  private SecondState state;
  private SecondContract.Model model;
  private AppMediator mediator;

  public SecondPresenter(AppMediator mediator) {
    this.mediator = mediator;
    //state = mediator.getSecondState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the mediator initialize the state
    state = getScreenState();
    //state = new SecondState();

    // call the model and initialize the state
    state.data = model.getStoredData();

    // use passed state if is necessary
    FirstToSecondState savedState = getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      //model.onUpdatedDataFromPreviousScreen(savedState.data);

      // update the state if is necessary
      state.data = savedState.data;
    }
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // call the mediator initialize the state
    state = mediator.getSecondScreenState();

    // update the model if is necessary
    //model.onUpdatedDataFromRestartedScreen(state.data);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");


    // call the model and update the state if is necessary
    //state.data = model.getUpdatedData();

    /*
    // use passed state if is necessary
    NextToSecondState savedState = getStateFromNextScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onUpdatedDataFromNextScreen(savedState.data);

      // update the state if is necessary
      state.data = savedState.data;
    }
    */

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

    SecondToFirstState newState= new SecondToFirstState();
    //newState.data = state.data;
    newState.data = model.getStoredData();
    passStateToPreviousScreen(newState);
    view.get().navigateToPreviousScreen();
  }

  private SecondState getScreenState() {
    return mediator.getSecondScreenState();
  }

  private void setScreenState(SecondState state) {
    mediator.setSecondScreenState(state);
  }

  /*
  private NextToSecondState getStateFromNextScreen() {
    return mediator.getNextSecondScreenState();
  }

  private void passStateToNextScreen(SecondToNextState state) {
    mediator.setNextSecondScreenState(state);
  }
  */

  private void passStateToPreviousScreen(SecondToFirstState state) {
    mediator.setPreviousSecondScreenState(state);
  }

  private FirstToSecondState getStateFromPreviousScreen() {
    return mediator.getPreviousSecondScreenState();
  }

  @Override
  public void injectView(WeakReference<SecondContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SecondContract.Model model) {
    this.model = model;
  }

}