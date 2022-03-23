package es.ulpgc.eite.da.lhdez.cleancodetemplate.second;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.lhdez.cleancodetemplate.R;
import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.AppMediator;

/**
 * Created by Luis on marzo, 2022
 */
public class SecondScreen {

  public static void configure(SecondContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);


    AppMediator mediator = AppMediator.getInstance();
    SecondContract.Presenter presenter = new SecondPresenter(mediator);

    String data = context.get().getString(R.string.second_message_text);
    SecondContract.Model model = new SecondModel(data);

    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}