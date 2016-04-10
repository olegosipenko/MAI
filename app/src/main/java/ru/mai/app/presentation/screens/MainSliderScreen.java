package ru.mai.app.presentation.screens;

import android.os.Bundle;

import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import flow.path.Path;
import mortar.ViewPresenter;
import ru.mai.app.App;
import ru.mai.app.R;
import ru.mai.app.presentation.events.SwipePageEvent;
import ru.mai.app.presentation.mf_boilerplate.Layout;
import ru.mai.app.presentation.mf_boilerplate.WithModule;
import ru.mai.app.presentation.views.MainSliderView;

/**
 * Created by olegosipenko on 05.04.16.
 */
@Layout(R.layout.view_main_slider)
@WithModule(MainSliderScreen.Module.class)
public class MainSliderScreen extends Path {

    private static int startPosition = 0;

    public MainSliderScreen(int startPosition) {
        MainSliderScreen.startPosition = startPosition;
    }

    @dagger.Module(
            injects = MainSliderView.class,
            addsTo = App.AppModule.class
    )
    public class Module {
        public Module() {
        }
    }

    public static class Presenter extends ViewPresenter<MainSliderView> {
        @Inject
        public Presenter() {
        }

        @Override
        protected void onLoad(Bundle savedInstanceState) {
            super.onLoad(savedInstanceState);
            App.bus.register(this);
            if (!hasView()) return;
            getView().showScreens(startPosition);
        }

        @Override
        public void dropView(MainSliderView view) {
            App.bus.unregister(this);
            super.dropView(view);
        }

        @Subscribe
        public void swipePage(SwipePageEvent event) {
            if (!hasView()) return;
            getView().swipePage(event.getPosition());
        }
    }
}
