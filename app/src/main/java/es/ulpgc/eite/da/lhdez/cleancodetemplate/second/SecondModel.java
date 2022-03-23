package es.ulpgc.eite.da.lhdez.cleancodetemplate.second;

/**
 * Created by Luis on marzo, 2022
 */
public class SecondModel implements SecondContract.Model {

  //public static String TAG = SecondModel.class.getSimpleName();
  public static String TAG = "CleanCodeTemplate.SecondModel";

  private String data;

  public SecondModel(String data) {
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
