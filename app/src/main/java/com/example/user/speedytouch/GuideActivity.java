package com.example.user.speedytouch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;


public class GuideActivity extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* //slide 1
        addSlide(AppIntroFragment.newInstance( getResources().getString(R.string.title_1_guide),
        "המשחק שיגרום לכם לחשוב בזריזות, לחפש אחר המספרים והכי חשוב- שלא יהיו בלבולים. 3 פסילות, עשרות מספרים אז קדימה- רוצו לקרוא את החוקים! ",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.lightRed)));
        //slide 2
        addSlide(AppIntroFragment.newInstance("במשחק שלוש רמות קושי- ",
        "למתחילים שבינינו מומלץ להתחיל ברמה הקלה- אשר בה תאלצו להתמודד עם מציאת המספר תוך 5 שניות בלבד!",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.green)));
        //slide 3
        addSlide(AppIntroFragment.newInstance("ולאחר שמצאת 10 מספרים בזמן הנכון והמתאים כדאי שתעבור למתקדמים",
        "ולאלו שצלחו את הרמה הקלה- מחכה הרמה הבינונית שבה נאתגר אתכם עם מספרים נוספים, קשים יותר אבל- אתם אלופים. בשלב זה תוך 4 שניות בלבד תאלצו למצוא את המספר שאבד. ",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.Gold)));
        //slide 4
        addSlide(AppIntroFragment.newInstance("ואם גם פה צברתם 10 מספרים- תשמעו זה כבר באמת מדהים.",
        "רוצו מכאן לרמה הבאה- הקשה מכולן אבל גם האחרונה. מספרים נוספים, מהירים וזריזים שירוצו לכם מול הפנים. 3 שניות בלבד- זה כל מה שיש וכל מה שנותר הוא לרוץ לשחק. בהצלחה!  ",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.ronelRed)));
        showSkipButton(false);*/

        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle(getResources().getString(R.string.title_1_guide));
        sliderPage1.setDescription(getResources().getString(R.string.description_1_guide));
        sliderPage1.setImageDrawable(R.drawable.notime);
        sliderPage1.setBgColor(ContextCompat.getColor(getApplicationContext(),R.color.lightRed));
        addSlide(AppIntroFragment.newInstance(sliderPage1));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle(getResources().getString(R.string.title_2_guide));
        sliderPage2.setDescription(getResources().getString(R.string.description_2_guide));
        //sliderPage1.setImageDrawable(image);
        sliderPage2.setBgColor(ContextCompat.getColor(getApplicationContext(),R.color.green));
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle(getResources().getString(R.string.title_3_guide));
        sliderPage3.setDescription(getResources().getString(R.string.description_3_guide));
        //sliderPage1.setImageDrawable(image);
        sliderPage3.setBgColor(ContextCompat.getColor(getApplicationContext(),R.color.Gold));
        addSlide(AppIntroFragment.newInstance(sliderPage3));

        SliderPage sliderPage4 = new SliderPage();
        sliderPage4.setTitle(getResources().getString(R.string.title_4_guide));
        sliderPage4.setDescription(getResources().getString(R.string.description_4_guide));
        //sliderPage1.setImageDrawable(image);
        sliderPage4.setBgColor(ContextCompat.getColor(getApplicationContext(),R.color.ronelRed));
        addSlide(AppIntroFragment.newInstance(sliderPage4));

        showSkipButton(false);
    }
    @Override
    public void onBackPressed() {
        finishReadingGuide();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finishReadingGuide();
    }
    public void finishReadingGuide()
    {
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
