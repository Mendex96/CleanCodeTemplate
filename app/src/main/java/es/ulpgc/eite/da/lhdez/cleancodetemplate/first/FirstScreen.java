package es.ulpgc.eite.da.lhdez.cleancodetemplate.first;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.lhdez.cleancodetemplate.R;
import es.ulpgc.eite.da.lhdez.cleancodetemplate.app.AppMediator;

/**
 * Created by Luis on marzo, 2022
 */
public class FirstScreen {

  public static void configure(FirstContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);


    AppMediator mediator = AppMediator.getInstance();
    FirstContract.Presenter presenter = new FirstPresenter(mediator);

    String data = context.get().getString(R.string.first_message_text);
    FirstContract.Model model = new FirstModel(data);

    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}