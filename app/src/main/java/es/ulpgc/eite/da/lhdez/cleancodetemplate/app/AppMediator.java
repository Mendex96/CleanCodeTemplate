package es.ulpgc.eite.da.lhdez.cleancodetemplate.app;

import es.ulpgc.eite.da.lhdez.cleancodetemplate.first.FirstState;
import es.ulpgc.eite.da.lhdez.cleancodetemplate.second.SecondState;

/**
 * Created by Luis on marzo, 2022
 */
@SuppressWarnings("unused")
public class AppMediator {

  private static AppMediator INSTANCE;

  private FirstState mFirstState;
  private SecondState mSecondState;

  private FirstToSecondState mFirstToSecondState;
  private SecondToFirstState mSecondToFirstState;

  private AppMediator() {
    mFirstState = new FirstState();
    mSecondState = new SecondState();
  }


  public static AppMediator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AppMediator();
    }

    return INSTANCE;
  }

  // to reset the state when testing
  public static void resetInstance() {
    INSTANCE = null;
  }

  public FirstState getFirstScreenState() {
    return mFirstState;
  }

  public void setFirstScreenState(FirstState state) {
    mFirstState = state;
  }

  public SecondState getSecondScreenState() {
    return mSecondState;
  }

  public void setSecondScreenState(SecondState state) {
    mSecondState = state;
  }


  public void setNextFirstScreenState(FirstToSecondState state) {
    mFirstToSecondState=state;
  }

  public SecondToFirstState getNextFirstScreenState() {
    SecondToFirstState state = mSecondToFirstState;
    mSecondToFirstState=null;
    return state;
  }


  public void setPreviousSecondScreenState(SecondToFirstState state) {
    mSecondToFirstState=state;
  }

  public FirstToSecondState getPreviousSecondScreenState() {
    FirstToSecondState state = mFirstToSecondState;
    mFirstToSecondState=null;
    return state;
  }

}