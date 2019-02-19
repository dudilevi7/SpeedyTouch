package com.example.user.speedytouch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;


public class GuideActivity extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //slide 1
        addSlide(AppIntroFragment.newInstance("ברוכים הבאים למשחק Speedy Touch ","המשחק שיגרום לכם לחשוב בזריזות, לחפש אחר המספרים והכי חשוב- שלא יהיו בלבולים. 3 פסילות, עשרות מספרים אז קדימה- רוצו לקרוא את החוקים! ",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.lightRed)));
        //slide 2
        addSlide(AppIntroFragment.newInstance("במשחק שלוש רמות קושי- ","למתחילים שבינינו מומלץ להתחיל ברמה הקלה- אשר בה תאלצו להתמודד עם מציאת המספר תוך 5 שניות בלבד!",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.green)));
        //slide 3
        addSlide(AppIntroFragment.newInstance("ולאחר שמצאת 10 מספרים בזמן הנכון והמתאים כדאי שתעבור למתקדמים","ולאלו שצלחו את הרמה הקלה- מחכה הרמה הבינונית שבה נאתגר אתכם עם מספרים נוספים, קשים יותר אבל- אתם אלופים. בשלב זה תוך 4 שניות בלבד תאלצו למצוא את המספר שאבד. ",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.Gold)));
        //slide 4
        addSlide(AppIntroFragment.newInstance("ואם גם פה צברתם 10 מספרים- תשמעו זה כבר באמת מדהים.","רוצו מכאן לרמה הבאה- הקשה מכולן אבל גם האחרונה. מספרים נוספים, מהירים וזריזים שירוצו לכם מול הפנים. 3 שניות בלבד- זה כל מה שיש וכל מה שנותר הוא לרוץ לשחק. בהצלחה!  ",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.ronelRed)));
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
