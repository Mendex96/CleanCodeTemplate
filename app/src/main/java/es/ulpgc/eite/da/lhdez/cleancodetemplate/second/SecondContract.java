package es.ulpgc.eite.da.lhdez.cleancodetemplate.second;

import java.lang.ref.WeakReference;

/**
 * Created by Luis on marzo, 2022
 */
public interface SecondContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onViewModelDataUpdated(SecondViewModel viewModel);

    //void navigateToNextScreen();

    void navigateToPreviousScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onButtonClicked();
  }

  interface Model {
    String getUpdatedData();

    String getStoredData();

    void onUpdatedDataFromRestartedScreen(String data);

    void onUpdatedDataFromNextScreen(String data);

    void onUpdatedDataFromPreviousScreen(String data);
  }

}