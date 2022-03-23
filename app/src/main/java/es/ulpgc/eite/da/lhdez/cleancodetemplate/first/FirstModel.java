package es.ulpgc.eite.da.lhdez.cleancodetemplate.first;

/**
 * Created by Luis on marzo, 2022
 */
public class FirstModel implements FirstContract.Model {

  //public static String TAG = FirstModel.class.getSimpleName();
  public static String TAG = "CleanCodeTemplate.FirstModel";

  private String data;

  public FirstModel(String data) {
    this.data = data;
  }

  @Override
  public String getStoredData() {
    // Log.e(TAG, "getStoredData()");

    return data;
  }

  @Override
  public String getUpdatedData() {
    // Log.e(TAG, "getUpdatedData()");

    return data;
  }

  @Override
  public void onUpdatedDataFromRestartedScreen(String data) {
    // Log.e(TAG, "onUpdatedDataFromRestartedScreen()");


  }

  @Override
  public void onUpdatedDataFromNextScreen(String data) {
    // Log.e(TAG, "onUpdatedDataFromNextScreen()");


  }

  @Override
  public void onUpdatedDataFromPreviousScreen(String data) {
    // Log.e(TAG, "onUpdatedDataFromPreviousScreen()");


  }
}
