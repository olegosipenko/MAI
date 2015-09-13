package oleg.osipenko.mai.data.repository;

import android.content.Context;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import oleg.osipenko.mai.R;
import oleg.osipenko.mai.data.dataModel.ListContent;
import oleg.osipenko.mai.data.dataModel.StaticContent;
import oleg.osipenko.mai.data.dataModel.StaticListContent;
import oleg.osipenko.mai.data.repository.specification.ListContentSpecification;
import oleg.osipenko.mai.data.repository.specification.StaticContentSpecification;
import oleg.osipenko.mai.data.repository.specification.StaticListContentSpecification;
import rx.Observable;
import rx.functions.Func2;
import static oleg.osipenko.mai.Router.FACULTIES;
import static oleg.osipenko.mai.Router.SESSION;
import static oleg.osipenko.mai.Router.PRACTICS;
import static oleg.osipenko.mai.Router.SCHOLARSHIPS;
import static oleg.osipenko.mai.Router.LIBRARIES;
import static oleg.osipenko.mai.Router.CANTEENS;
import static oleg.osipenko.mai.Router.DOTATIONS;
import static oleg.osipenko.mai.Router.MILITARY_INSTITUTE;
import static oleg.osipenko.mai.Router.SECONDARY_EDUCATION;
import static oleg.osipenko.mai.Router.MAGISTRACY;
import static oleg.osipenko.mai.Router.COURSES;
import static oleg.osipenko.mai.Router.ACADEMIC_MOBILITY;
import static oleg.osipenko.mai.Router.EMPLOYMENT_CENTER;
import static oleg.osipenko.mai.Router.SCIENCE;
import static oleg.osipenko.mai.Router.DORMITORIES;
import static oleg.osipenko.mai.Router.SANATORIUM;
import static oleg.osipenko.mai.Router.RECREATION_CENTERS;
import static oleg.osipenko.mai.Router.SPORT_SECTIONS;
import static oleg.osipenko.mai.Router.DK;
import static oleg.osipenko.mai.Router.DOSAAF;
import static oleg.osipenko.mai.Router.DEBATING_CLUB;
import static oleg.osipenko.mai.Router.MAISKY_VZLET;
import static oleg.osipenko.mai.Router.PROFKOM;
import static oleg.osipenko.mai.Router.SOMOL;
import static oleg.osipenko.mai.Router.PRESS;
import static oleg.osipenko.mai.Router.MEDIA;
import static oleg.osipenko.mai.Router.HISTORY;
import static oleg.osipenko.mai.Router.LIFE;
import static oleg.osipenko.mai.Router.HELP;

/**
 * Created by olegosipenko on 07.09.15.
 */
public class MaiRepository implements DataRepository {
    
    List<Integer> facImages = Arrays.asList(
            R.drawable.f1st,
            R.drawable.f2nd,
            R.drawable.f4th,
            R.drawable.f6th,
            R.drawable.f1st,
            R.drawable.f2nd,
            R.drawable.f4th,
            R.drawable.f6th,
            R.drawable.f1st,
            R.drawable.f2nd,
            R.drawable.f4th
    );


    List<Integer> instImages = Arrays.asList(
            R.drawable.f1st,
            R.drawable.f2nd
    );

    List<Integer> filImages = Arrays.asList(
            R.drawable.f1st,
            R.drawable.f2nd,
            R.drawable.f4th,
            R.drawable.f6th
    );

    Context context;

    public MaiRepository(Context context) {
        this.context = context;
    }

    @Override
    public Observable<List<StaticContent>> getStaticContent(StaticContentSpecification specification) {
        if (specification.specified(PRACTICS)) {

        } else if (specification.specified(DOTATIONS)) {

        } else if (specification.specified(EMPLOYMENT_CENTER)) {

        } else if (specification.specified(SCIENCE)) {

        } else if (specification.specified(DORMITORIES)) {

        } else if (specification.specified(SANATORIUM)) {

        } else if (specification.specified(DEBATING_CLUB)) {

        } else if (specification.specified(MAISKY_VZLET)) {

        } else if (specification.specified(PROFKOM)) {

        } else if (specification.specified(SOMOL)) {

        } else if (specification.specified(PRESS)) {

        } else if (specification.specified(HISTORY)) {

        }
        return null;
    }

    @Override
    public Observable<List<ListContent>> getListContent(ListContentSpecification specification) {
        if (specification.specified(FACULTIES)) {
            String[] faculties = context.getResources().getStringArray(R.array.faculties);
            String[] institutes = context.getResources().getStringArray(R.array.institutes);
            String[] filials = context.getResources().getStringArray(R.array.filials);
            Observable<String> unitedStrings = Observable.from(faculties)
                    .concatWith(Observable.from(institutes))
                    .concatWith(Observable.from(filials));
            Observable<Integer> unitedImages = Observable.from(facImages)
                    .concatWith(Observable.from(instImages))
                    .concatWith(Observable.from(filImages));
            return Observable.zip(unitedStrings, unitedImages, new Func2<String, Integer, ListContent>() {
                @Override
                public ListContent call(String s, Integer integer) {
                    return new ListContent.Builder()
                            .setText(s)
                            .setImage(String.valueOf(integer))
                            .setWithImage(true)
                            .build();
                }
            })
                    .toList()
                    .cache();
        } else if (specification.specified(SCHOLARSHIPS)) {

        } else if (specification.specified(LIBRARIES)) {

        } else if (specification.specified(CANTEENS)) {

        } else if (specification.specified(COURSES)) {

        } else if (specification.specified(ACADEMIC_MOBILITY)) {

        } else if (specification.specified(SPORT_SECTIONS)) {

        } else if (specification.specified(MEDIA)) {

        } else if (specification.specified(LIFE)) {

        } else if (specification.specified(HELP)) {

        }
        return Observable.from(Collections.EMPTY_LIST);
    }

    @Override
    public Observable<List<StaticListContent>> getStaticListContent(StaticListContentSpecification specification) {
        if (specification.specified(SESSION)) {

        } else if (specification.specified(MILITARY_INSTITUTE)) {

        } else if (specification.specified(MAGISTRACY)) {

        } else if (specification.specified(SECONDARY_EDUCATION)) {

        } else if (specification.specified(RECREATION_CENTERS)) {

        } else if (specification.specified(DK)) {

        } else if (specification.specified(DOSAAF)) {

        }
        return null;
    }
}
